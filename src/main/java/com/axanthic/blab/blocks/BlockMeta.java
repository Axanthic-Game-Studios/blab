package com.axanthic.blab.blocks;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.axanthic.blab.Blab;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockMeta extends Block {

	public static PropertyEnum TYPES = PropertyEnum.create("type", StoneTypes.class);
	public static int metaCount = StoneTypes.values().length;

	public BlockMeta(Material material, float hardness, String name) {
		super(material);
		this.setCreativeTab(Blab.modTab);
		this.setHardness(hardness);
		this.setUnlocalizedName(name);
		this.setRegistryName("blab", name);
		this.setDefaultState(getStateFromMeta(0));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((StoneTypes) state.getValue(TYPES)).getMetadata();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPES, StoneTypes.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[]{TYPES});
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1, this.getMetaFromState(world.getBlockState(pos)));
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (StoneTypes stoneType : StoneTypes.values()) {
			items.add(new ItemStack(this, 1, stoneType.getMetadata()));
		}
	}

	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
		return ((StoneTypes) state.getValue(TYPES)).getMapColor();
	}
	
	public enum StoneTypes implements IStringSerializable {
		YELLOWSTONE(0, "yellowstone", MapColor.BROWN),
		SILKSTONE(1, "silkstone", MapColor.BROWN),
		SUNSTONE(2, "sunstone", MapColor.BROWN),
		BLACKSHALE(3, "blackshale", MapColor.BROWN),
		PUDDINGSTONE(4, "puddingstone", MapColor.BROWN);

		private static final StoneTypes[] META_LOOKUP = new StoneTypes[values().length];
		private final int meta;
		private final String unlocalizedName;
		private final MapColor mapColor;
		
		StoneTypes(int metaIn, String unlocalizedNameIn, MapColor mapColorIn) {
			this.meta = metaIn;
			this.unlocalizedName = unlocalizedNameIn;
			this.mapColor = mapColorIn;
		}

		public int getMetadata() {
			return this.meta;
		}

		/**
		 * The color which represents this entry on a map.
		 */
		public MapColor getMapColor() {
			return this.mapColor;
		}

		public static StoneTypes byMetadata(int meta) {
			if (meta < 0 || meta >= META_LOOKUP.length) {
				meta = 0;
			}

			return META_LOOKUP[meta];
		}

		public String getName() {
			return this.unlocalizedName;
		}

		public static String[] getNames() {
			String[] names = new String[META_LOOKUP.length];
			for (int i = 0; i < META_LOOKUP.length; i++) {
				names[i] = META_LOOKUP[i].getName();
			}
			return names;
		}

		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}

		static {
			for (StoneTypes stoneType : values()) {
				META_LOOKUP[stoneType.getMetadata()] = stoneType;
			}
		}
	}
}
