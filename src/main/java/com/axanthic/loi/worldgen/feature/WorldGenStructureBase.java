package com.axanthic.loi.worldgen.feature;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.Resources;
import com.axanthic.loi.blocks.BlockRelicstone;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplatePublic;

public abstract class WorldGenStructureBase extends WorldGenerator {

	final PlacementSettings placementsettings;

	public WorldGenStructureBase(float integrity) {
		placementsettings = new PlacementSettings().setIntegrity(integrity).setChunk((ChunkPos)null).setReplacedBlock((Block)null);
	}

	public static void addBlocksToWorldSilently(TemplatePublic template, World worldIn, BlockPos pos, @Nullable ITemplateProcessor templateProcessor, PlacementSettings placementIn, Random rand, int flags) {
		if (!template.blocks.isEmpty() && template.getSize().getX() >= 1 && template.getSize().getY() >= 1 && template.getSize().getZ() >= 1) {
			Block block = placementIn.getReplacedBlock();
			StructureBoundingBox structureboundingbox = placementIn.getBoundingBox();

			for (Template.BlockInfo template$blockinfo : template.blocks) {
				BlockPos relativePos = template.transformedBlockPos(placementIn, template$blockinfo.pos);
				BlockPos blockpos = relativePos.add(pos);
				// Forge: skip processing blocks outside BB to prevent cascading worldgen issues
				if (structureboundingbox != null && !structureboundingbox.isVecInside(blockpos)) continue;
				Template.BlockInfo template$blockinfo1 = templateProcessor != null ? templateProcessor.processBlock(worldIn, blockpos, template$blockinfo) : template$blockinfo;

				if (template$blockinfo1 != null) {
					Block block1 = template$blockinfo1.blockState.getBlock();

					if ((block == null || block != block1) && (!placementIn.getIgnoreStructureBlock() || block1 != Blocks.STRUCTURE_BLOCK) && (structureboundingbox == null || structureboundingbox.isVecInside(blockpos))) {
						IBlockState iblockstate = replaceBlock(template$blockinfo1.blockState.withMirror(placementIn.getMirror()), relativePos.getY(), rand);
						IBlockState iblockstate1 = iblockstate.withRotation(placementIn.getRotation());

						if (template$blockinfo1.tileentityData != null) {
							TileEntity tileentity = worldIn.getTileEntity(blockpos);

							if (tileentity != null) {
								if (tileentity instanceof IInventory) {
									((IInventory)tileentity).clear();
								}

								worldIn.setBlockState(blockpos, Blocks.BARRIER.getDefaultState(), 4);
							}
						}

						if (worldIn.setBlockState(blockpos, iblockstate1, flags) && template$blockinfo1.tileentityData != null) {
							TileEntity tileentity2 = worldIn.getTileEntity(blockpos);

							if (tileentity2 != null) {
								template$blockinfo1.tileentityData.setInteger("x", blockpos.getX());
								template$blockinfo1.tileentityData.setInteger("y", blockpos.getY());
								template$blockinfo1.tileentityData.setInteger("z", blockpos.getZ());
								tileentity2.readFromNBT(template$blockinfo1.tileentityData);
								tileentity2.mirror(placementIn.getMirror());
								tileentity2.rotate(placementIn.getRotation());
							}
						}
					}
				}
			}
		}
	}

	private final static IBlockState[] bricks = new IBlockState[] {Resources.brick.getBlock().getStateFromMeta(5), Resources.relicstone.getBlock().getStateFromMeta(1), Resources.relicstone.getBlock().getStateFromMeta(2)};
	private final static IBlockState[] tiles = new IBlockState[] {Resources.relicstone.getBlock().getStateFromMeta(4), Resources.relicstone.getBlock().getStateFromMeta(5), Resources.relicstone.getBlock().getStateFromMeta(6)};
	private final static Block[] brickSlabs = new Block[] {Resources.relicstoneBrick.slab.getBlock(), Resources.relicstoneCrackBrick.slab.getBlock(), Resources.relicstoneMossBrick.slab.getBlock()};
	private final static Block[] brickStairs = new Block[] {Resources.relicstoneBrick.stairs.getBlock(), Resources.relicstoneCrackBrick.stairs.getBlock(), Resources.relicstoneMossBrick.stairs.getBlock()};
	private final static IBlockState[] brickWalls = new IBlockState[] {Resources.relicstoneBrick.wall.getBlock().getDefaultState(), Resources.relicstoneCrackBrick.wall.getBlock().getDefaultState(), Resources.relicstoneMossBrick.wall.getBlock().getDefaultState()};
	private final static Block[] tileSlabs = new Block[] {Resources.relicstoneTile.slab.getBlock(), Resources.relicstoneCrackTile.slab.getBlock(), Resources.relicstoneMossTile.slab.getBlock()};
	private final static Block[] tileStairs = new Block[] {Resources.relicstoneTile.stairs.getBlock(), Resources.relicstoneCrackTile.stairs.getBlock(), Resources.relicstoneMossTile.stairs.getBlock()};

	public static IBlockState replaceBlock(IBlockState state, int height, Random rand) {
		int type;
		height *=2;
		if (height < -1)
			height = -1;
		if (rand.nextInt(height + 3) == 0 || (height < 7 && rand.nextInt(height + 3) == 0)) {
			type = 2;
		} else {
			type = rand.nextInt(2);
		}
		Block block = state.getBlock();
		int meta = block.getMetaFromState(state);
		if (block instanceof BlockRelicstone) {
			if (meta == 3)
				return bricks[type];
			if (meta == 7)
				return tiles[type];
		} else if (block.equals(Resources.relicstoneDraftBrick.slab.getBlock())) {
			return brickSlabs[type].getStateFromMeta(meta);
		} else if (block.equals(Resources.relicstoneDraftBrick.stairs.getBlock())) {
			return brickStairs[type].getStateFromMeta(meta);
		} else if (block.equals(Resources.relicstoneDraftBrick.wall.getBlock())) {
			return brickWalls[type];
		} else if (block.equals(Resources.relicstoneDraftTile.slab.getBlock())) {
			return tileSlabs[type].getStateFromMeta(meta);
		} else if (block.equals(Resources.relicstoneDraftTile.stairs.getBlock())) {
			return tileStairs[type].getStateFromMeta(meta);
		}
		return state;
	}

	public static TemplatePublic readTemplateFromJar(ResourceLocation resource) {
		try {
			InputStream inputstream = MinecraftServer.class.getResourceAsStream("/assets/" + resource.getResourceDomain() + "/structures/" + resource.getResourcePath() + ".nbt");
			return readTemplateFromStream(inputstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static TemplatePublic readTemplateFromStream(InputStream stream) throws IOException {
		NBTTagCompound nbttagcompound = CompressedStreamTools.readCompressed(stream);

		if (!nbttagcompound.hasKey("DataVersion", 99)) {
			nbttagcompound.setInteger("DataVersion", 500);
		}
		TemplatePublic template = new TemplatePublic();
		template.read(nbttagcompound);
		return template;
	}
}