package com.axanthic.loi.render;

import com.axanthic.loi.ModInformation;
import com.axanthic.loi.entity.EntityRevenant;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRevenantPyromancerNether extends RenderLiving<EntityRevenant> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(ModInformation.ID, "textures/entity/mob_revenant_pyro_nether.png");

	public RenderRevenantPyromancerNether(RenderManager manager) {
		super(manager, new ModelRevenantPyromancer(), 0.7F);
		this.addLayer(new LayerRevenantEyes(this));
	}

	protected ResourceLocation getEntityTexture(EntityRevenant entity) {
		return TEXTURE;
	}
}