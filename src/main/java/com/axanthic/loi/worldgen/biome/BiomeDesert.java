package com.axanthic.loi.worldgen.biome;

import java.util.Random;

import com.axanthic.blab.Resources;
import com.axanthic.blab.entity.EntityForestHag;
import com.axanthic.blab.entity.EntityRevenant;
import com.axanthic.loi.worldgen.feature.WorldGenDroughtrootTree;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenTallGrass;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BiomeDesert extends BiomeLOI {

	public BiomeDesert() {
		super(new BiomeProperties("blab:desert").setRainDisabled().setTemperature(2.0F));
		this.setRegistryName("blab:desert");

		topBlockPrimary = Resources.grainelSand.getBlock().getDefaultState();
		fillerBlockPrimary = Resources.grainelSand.getBlock().getDefaultState();
		topBlockSecondary = Resources.silkstoneSand.getBlock().getDefaultState();
		fillerBlockSecondary = Resources.silkstoneSand.getBlock().getDefaultState();

		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
		spawnableWaterCreatureList.clear();
		spawnableCaveCreatureList.clear();
		spawnableCreatureList.add(new Biome.SpawnListEntry(EntityForestHag.class, 50, 1, 2));
		spawnableMonsterList.add(new Biome.SpawnListEntry(EntityRevenant.class, 200, 1, 4));

		flowers.clear();
		addFlower(Resources.flower.getBlock().getStateFromMeta(15), 20);
		addFlower(Resources.flower2.getBlock().getStateFromMeta(0), 20);
		addFlower(Resources.herb.getBlock().getStateFromMeta(5), 10);
		addFlower(Resources.herb.getBlock().getStateFromMeta(8), 10);
	}

	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos) {
		return 0xB2B755;
	}

	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {

	}

	@Override
	public BiomeDecorator createBiomeDecorator() {
		LOIBiomeDecorator biomeDecorator = new LOIBiomeDecorator();

		biomeDecorator.treesPerChunk = 3;
		biomeDecorator.extraTreeChance = 0.1F;
		biomeDecorator.flowersPerChunk = 4;
		biomeDecorator.cactiPerChunk = 20;
		biomeDecorator.grassPerChunk = 0;
		biomeDecorator.treeGenerators.add(new WorldGenDroughtrootTree(false).init());

		return biomeDecorator;
	}

	@Override
	public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
		return (WorldGenAbstractTree)(rand.nextInt(10) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE);
	}

	@Override
	public WorldGenerator getRandomWorldGenForGrass(Random rand) {
		return new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
	}

	@Override
	public BlockFlower.EnumFlowerType pickRandomFlower(Random rand, BlockPos pos) {
		return rand.nextInt(3) > 0 ? BlockFlower.EnumFlowerType.DANDELION : BlockFlower.EnumFlowerType.POPPY;
	}
}