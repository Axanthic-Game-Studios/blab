package com.axanthic.loi.tileentity;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources;
import com.axanthic.loi.proxy.ClientProxy;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class TileEntitySpecialRendererGrinder extends TileEntitySpecialRenderer<TileEntityGrinder> {

	ItemStack gearLarge = new ItemStack(Resources.renderAddon, 1, 0);
	ItemStack gearLargeActive = new ItemStack(Resources.renderAddon, 1, 1);
	ItemStack gearSmall = new ItemStack(Resources.renderAddon, 1, 2);
	ItemStack gearSmallActive = new ItemStack(Resources.renderAddon, 1, 3);
	public static TileEntitySpecialRendererGrinder instance;
	IBakedModel grinderModel;

	@Override
	public void setRendererDispatcher(TileEntityRendererDispatcher rendererDispatcherIn) {
		super.setRendererDispatcher(rendererDispatcherIn);
		instance = this;
		grinderModel = ClientProxy.modelManager.getModel(new ModelResourceLocation(new ResourceLocation(ModInformation.ID, "crafting_grinder"), "burning=false,facing=north"));
	}

	public void renderInventory() {
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.5F, 0.5F, 0.5F);
		Minecraft.getMinecraft().getRenderItem().renderItem(gearLarge, grinderModel);
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		GlStateManager.translate(0.5F, 14.5F/16.0F, 0.25F);
		GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(2.0F, 2.0F, 2.0F);
		Minecraft.getMinecraft().getRenderItem().renderItem(gearLarge, ItemCameraTransforms.TransformType.GROUND);
		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		GlStateManager.translate(3.0F/16.0F, 3.0F/16.0F, 0.5F/16.0F);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(2.0F, 2.0F, 2.0F);
		Minecraft.getMinecraft().getRenderItem().renderItem(gearSmall, ItemCameraTransforms.TransformType.GROUND);
		GlStateManager.translate(5.0F/32.0F, 0.0F, 15.0F/32.0F);
		Minecraft.getMinecraft().getRenderItem().renderItem(gearSmall, ItemCameraTransforms.TransformType.GROUND);
		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}

	@Override
	public void render(TileEntityGrinder tileEntity, double relativeX, double relativeY, double relativeZ, float partialTicks, int blockDamageProgress, float alpha) {
		if (!(tileEntity instanceof TileEntityGrinder)) return;

		GlStateManager.pushMatrix();
		GlStateManager.translate((float) relativeX, (float) relativeY, (float) relativeZ);
		GlStateManager.translate(0.5F, 14.5F/16.0F, 0.25F);
		GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(2.0F, 2.0F, 2.0F);

		if (tileEntity.isGrinding())
			Minecraft.getMinecraft().getRenderItem().renderItem(gearLargeActive, ItemCameraTransforms.TransformType.GROUND);
		else
			Minecraft.getMinecraft().getRenderItem().renderItem(gearLarge, ItemCameraTransforms.TransformType.GROUND);

		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();

		GlStateManager.pushMatrix();
		GlStateManager.translate((float) relativeX, (float) relativeY, (float) relativeZ);
		EnumFacing facing = tileEntity.getWorld().getBlockState(tileEntity.getPos()).getValue(BlockHorizontal.FACING);
		if (facing.equals(EnumFacing.WEST) || facing.equals(EnumFacing.EAST)) {
			GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.translate(-1.0F, 0.0F, 0.0F);
		}
		GlStateManager.translate(3.0F/16.0F, 3.0F/16.0F, 0.5F/16.0F);
		GlStateManager.enableRescaleNormal();
		GlStateManager.scale(2.0F, 2.0F, 2.0F);

		if (tileEntity.isGrinding())
			Minecraft.getMinecraft().getRenderItem().renderItem(gearSmallActive, ItemCameraTransforms.TransformType.GROUND);
		else
			Minecraft.getMinecraft().getRenderItem().renderItem(gearSmall, ItemCameraTransforms.TransformType.GROUND);

		GlStateManager.translate(5.0F/32.0F, 0.0F, 15.0F/32.0F);

		if (tileEntity.isGrinding())
			Minecraft.getMinecraft().getRenderItem().renderItem(gearSmallActive, ItemCameraTransforms.TransformType.GROUND);
		else
			Minecraft.getMinecraft().getRenderItem().renderItem(gearSmall, ItemCameraTransforms.TransformType.GROUND);

		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}

	@Override
	public boolean isGlobalRenderer(TileEntityGrinder tileEntity) {
		return false;
	}
}