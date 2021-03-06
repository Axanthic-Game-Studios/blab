package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityJellyfish;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerJellyfishGlow<T extends EntityJellyfish> implements LayerRenderer<T> {
	private static final ResourceLocation GLOW = new ResourceLocation(ModInformation.ID, "textures/entity/mob_jellyfish_glowing.png");
	private final RenderJellyfish jelyfishRenderer;

	public LayerJellyfishGlow(RenderJellyfish jellyfishRendererIn) {
		this.jelyfishRenderer = jellyfishRendererIn;
	}

	public void doRenderLayer(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (entitylivingbaseIn.isInvisible())
			return;
		BlockPos pos = new BlockPos(entitylivingbaseIn);
		World world = entitylivingbaseIn.getEntityWorld();
		float light = Math.max(world.getLightFor(EnumSkyBlock.SKY, pos) * world.getSunBrightness(partialTicks), world.getLightFor(EnumSkyBlock.BLOCK, pos));
		if (light < 7.0F) {
			this.jelyfishRenderer.bindTexture(GLOW);
			GlStateManager.depthMask(true);
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			GlStateManager.alphaFunc(516, 0.003921569F);
			int i = 15728864;
			int j = i % 65536;
			int k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
			GlStateManager.color(1.0F, 1.0F, 1.0F, ((Math.max(3.0F, light) - 3.0F) / -4.0F) + 1.0F);
			Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
			this.jelyfishRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
			Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
			i = entitylivingbaseIn.getBrightnessForRender();
			j = i % 65536;
			k = i / 65536;
			OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
			this.jelyfishRenderer.setLightmap(entitylivingbaseIn);
			GlStateManager.disableBlend();
		}
	}

	public boolean shouldCombineTextures() {
		return false;
	}
}