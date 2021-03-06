package com.axanthic.loi.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.items.ItemResources;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSoil extends Block implements IBlockMeta {

	public static PropertyEnum TYPES = PropertyEnum.create("type", SoilTypes.class);
	public static int metaCount = SoilTypes.values().length;

	public BlockSoil() {
		super(Material.GROUND);
		this.setCreativeTab(LandsOfIcaria.modTabBlocks);
		this.setHardness(1.2F);
		this.setUnlocalizedName("soil");
		this.setRegistryName(ModInformation.ID, "soil");
		this.setDefaultState(this.getStateFromMeta(0));
		this.setDefaultState(this.blockState.getBaseState());
		this.setSoundType(SoundType.GROUND);
	}

	@Override
	@Nullable
	public String getHarvestTool(IBlockState state) {
		return "shovel";
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack itemstack = playerIn.getHeldItem(hand);
		if ((getMetaFromState(state) == 1 || getMetaFromState(state) == 0) && (itemstack.getItem() instanceof ItemHoe || itemstack.getItem().getToolClasses(itemstack).contains("hoe")) && playerIn.canPlayerEdit(pos.offset(facing), facing, itemstack)) {
			worldIn.playSound(playerIn, pos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
			if (!worldIn.isRemote) {
				if (getMetaFromState(state) == 0)
					worldIn.setBlockState(pos, Resources.farmLand.getBlock().getDefaultState());
				else if (getMetaFromState(state) == 1)
					worldIn.setBlockState(pos, getStateFromMeta(0));
				itemstack.damageItem(1, playerIn);
			}
			return true;
		}
		return false;
	}

	@Override
	public String getNameForMeta(final int meta) {
		return SoilTypes.byMetadata(meta).getName();
	}

	@Override
	public String[] getNames() {
		return SoilTypes.getNames();
	}

	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, net.minecraftforge.common.IPlantable plantable) {
		if (getMetaFromState(state) == 2)
			return Blocks.SAND.canSustainPlant(state, world, pos, direction, plantable) || Blocks.DIRT.canSustainPlant(state, world, pos, direction, plantable) || plantable instanceof BlockBush;

		return Blocks.DIRT.canSustainPlant(state, world, pos, direction, plantable) || plantable instanceof BlockBush;
	}

	@Override
	public int getMetaFromState(final IBlockState state) {
		return ((SoilTypes) state.getValue(BlockSoil.TYPES)).meta;
	}

	@Override
	public IBlockState getStateFromMeta(final int meta) {
		return this.getDefaultState().withProperty(BlockSoil.TYPES, SoilTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{BlockSoil.TYPES});
	}

	@Override
	public int damageDropped(final IBlockState state) {
		final int meta = this.getMetaFromState(state);
		if ((meta == 2) && this.getUnlocalizedName().equals("tile.soil")) {
			return ItemResources.ResourceType.LOAM_LUMP.toMeta();
		}
		return meta;
	}

	@Override
	public Item getItemDropped(final IBlockState state, final Random rand, final int fortune) {
		if ((this.getMetaFromState(state) == 2) && this.getUnlocalizedName().equals("tile.soil")) {
			return Resources.resource;
		}
		return super.getItemDropped(state, rand, fortune);
	}

	@Override
	public int quantityDropped(final IBlockState state, final int fortune, final Random random) {
		if ((this.getMetaFromState(state) == 2) && this.getUnlocalizedName().equals("tile.soil")) {
			int i = random.nextInt(fortune + 2) - 1;
			if (i < 0) {
				i = 0;
			}
			return Math.min(4, (random.nextInt(3) + 1) * (i + 1));
		} else {
			return 1;
		}
	}

	@Override
	public ItemStack getPickBlock(final IBlockState state, final RayTraceResult target, final World world, final BlockPos pos, final EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(final CreativeTabs itemIn, final NonNullList<ItemStack> items) {
		for (final SoilTypes soilType : SoilTypes.values()) {
			items.add(new ItemStack(this, 1, soilType.meta));
		}
	}

	@Override
	public MapColor getMapColor(final IBlockState state, final IBlockAccess worldIn, final BlockPos pos) {
		return ((SoilTypes) state.getValue(BlockSoil.TYPES)).mapColor;
	}

	public enum SoilTypes implements IStringSerializable {
		MARL(0, "marl", MapColor.BROWN),
		MARLCOURSE(1, "course_marl", MapColor.BROWN),
		LOAM(2, "loam", MapColor.SILVER_STAINED_HARDENED_CLAY);

		private static final SoilTypes[] META_LOOKUP = new SoilTypes[SoilTypes.values().length];
		private final int meta;
		private final String unlocalizedName;
		private final MapColor mapColor;

		SoilTypes(final int metaIn, final String unlocalizedNameIn, final MapColor mapColorIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
		}

		public static SoilTypes byMetadata(int meta) {
			if ((meta < 0) || (meta >= SoilTypes.META_LOOKUP.length)) {
				meta = 0;
			}

			return SoilTypes.META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return this.unlocalizedName;
		}

		public int getMeta() {
			return this.meta;
		}

		public static String[] getNames() {
			final String[] names = new String[SoilTypes.META_LOOKUP.length];
			for (int i = 0; i < SoilTypes.META_LOOKUP.length; i++) {
				names[i] = SoilTypes.META_LOOKUP[i].getName();
			}
			return names;
		}

		static {
			for (final SoilTypes soilType : SoilTypes.values()) {
				SoilTypes.META_LOOKUP[soilType.meta] = soilType;
			}
		}
	}
}
