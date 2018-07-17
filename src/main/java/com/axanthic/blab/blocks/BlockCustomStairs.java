package com.axanthic.blab.blocks;

import com.axanthic.blab.Blab;
import com.axanthic.blab.ModInformation;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockCustomStairs extends BlockStairs implements IBlockMaterial{

	public String name;
	public Block modelBlock;

	public BlockCustomStairs(IBlockState modelState, String name) {// + "_" + modelState.getProperties().
		super(modelState);
		this.name = name;
		this.modelBlock = modelState.getBlock();
		this.setCreativeTab(Blab.modTab);
		this.setUnlocalizedName("stairs");
		if (modelBlock instanceof IBlockMaterial)
			this.setRegistryName(ModInformation.ID, "stairs_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMaterial) modelBlock).getName());
		else if (modelBlock instanceof IBlockMeta)
			this.setRegistryName(ModInformation.ID, "stairs_" + modelState.getBlock().getRegistryName().getResourcePath() + "_" + ((IBlockMeta) modelBlock).getNameForMeta(modelBlock.getMetaFromState(modelState)));
		else
			this.setRegistryName(ModInformation.ID, "stairs_" + modelState.getBlock().getRegistryName().getResourcePath());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return modelBlock.getFlammability(world, pos, face);
	}

	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face) {
		return modelBlock.getFireSpreadSpeed(world, pos, face);
	}
}
