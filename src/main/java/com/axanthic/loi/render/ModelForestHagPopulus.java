package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelForestHagPopulus extends ModelBase {
	public ModelRenderer pelvis;
	public ModelRenderer leg_right_top;
	public ModelRenderer pelvis_left;
	public ModelRenderer hip;
	public ModelRenderer leg_right_center;
	public ModelRenderer leg_right_foot;
	public ModelRenderer leg_left_top;
	public ModelRenderer leg_left_top_center;
	public ModelRenderer leg_left_middle;
	public ModelRenderer leg_left_bottom;
	public ModelRenderer leg_left_foot;
	public ModelRenderer hip_left;
	public ModelRenderer belly;
	public ModelRenderer hip_branch_bottom;
	public ModelRenderer hip_branch_top;
	public ModelRenderer belly_left;
	public ModelRenderer chest;
	public ModelRenderer chest_left;
	public ModelRenderer shoulder;
	public ModelRenderer shoulder_left;
	public ModelRenderer neck;
	public ModelRenderer arm_right;
	public ModelRenderer leaf_cape;
	public ModelRenderer arm_left;
	public ModelRenderer stem;
	public ModelRenderer arm_left_lower;
	public ModelRenderer stem_dish;
	public ModelRenderer mush;
	public ModelRenderer r;
	public ModelRenderer o;
	public ModelRenderer o_1;
	public ModelRenderer m;
	public ModelRenderer stew;
	public ModelRenderer head;
	public ModelRenderer arm_right_lower;
	public ModelRenderer leaf_cape_middle;
	public ModelRenderer leaf_cape_bottom;

	public ModelForestHagPopulus() {
		this.textureWidth = 128;
		this.textureHeight = 96;
		this.pelvis = new ModelRenderer(this, 0, 0);
		this.pelvis.setRotationPoint(0.0F, 3.8F, 0.0F);
		this.pelvis.addBox(-6.5F, 0.0F, -2.0F, 8, 4, 4, 0.0F);
		this.setRotateAngle(pelvis, -0.08726646259971647F, 0.0F, -0.17453292519943295F);
		this.leg_left_top = new ModelRenderer(this, 55, 7);
		this.leg_left_top.setRotationPoint(3.0F, 4.3F, 0.0F);
		this.leg_left_top.addBox(-2.5F, 0.0F, -2.5F, 5, 4, 5, 0.0F);
		this.setRotateAngle(leg_left_top, -0.08726646259971647F, 0.0F, -0.10471975511965977F);
		this.head = new ModelRenderer(this, 102, 36);
		this.head.setRotationPoint(0.2F, -8.0F, -3.4F);
		this.head.addBox(-3.0F, -5.0F, -1.5F, 6, 8, 6, 0.0F);
		this.setRotateAngle(head, -0.9599310885968813F, 0.08726646259971647F, 0.03490658503988659F);
		this.leg_left_foot = new ModelRenderer(this, 75, 10);
		this.leg_left_foot.setRotationPoint(0.0F, 2.0F, 0.0F);
		this.leg_left_foot.addBox(-2.5F, 0.0F, -2.5F, 5, 3, 5, 0.0F);
		this.setRotateAngle(leg_left_foot, 0.0F, -0.08726646259971647F, 0.0F);
		this.stem = new ModelRenderer(this, 92, 26);
		this.stem.setRotationPoint(1.5F, 2.0F, -0.2F);
		this.stem.addBox(-2.0F, -12.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngle(stem, 0.0F, 0.0F, -0.17453292519943295F);
		this.belly_left = new ModelRenderer(this, 0, 16);
		this.belly_left.setRotationPoint(0.8F, -0.4F, -0.2F);
		this.belly_left.addBox(0.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(belly_left, 0.0F, 0.0F, 0.05235987755982988F);
		this.neck = new ModelRenderer(this, 110, 18);
		this.neck.setRotationPoint(-1.4F, 1.8F, -0.4F);
		this.neck.addBox(-1.5F, -7.0F, -1.5F, 3, 7, 3, 0.0F);
		this.setRotateAngle(neck, 0.7853981633974483F, 0.08726646259971647F, 0.03490658503988659F);
		this.leg_left_bottom = new ModelRenderer(this, 16, 9);
		this.leg_left_bottom.setRotationPoint(0.0F, 6.2F, 0.0F);
		this.leg_left_bottom.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
		this.setRotateAngle(leg_left_bottom, 0.08726646259971647F, 0.0F, 0.03490658503988659F);
		this.hip = new ModelRenderer(this, 60, 0);
		this.hip.setRotationPoint(0.6F, -3.2F, -0.2F);
		this.hip.addBox(-6.0F, 0.0F, -1.5F, 8, 4, 3, 0.0F);
		this.setRotateAngle(hip, 0.08726646259971647F, 0.0F, 0.03490658503988659F);
		this.chest = new ModelRenderer(this, 47, 16);
		this.chest.setRotationPoint(0.6F, -3.5F, -0.3F);
		this.chest.addBox(-7.5F, 0.0F, -1.5F, 9, 4, 3, 0.0F);
		this.setRotateAngle(chest, 0.08726646259971647F, 0.0F, 0.03490658503988659F);
		this.hip_left = new ModelRenderer(this, 27, 11);
		this.hip_left.setRotationPoint(0.8F, -0.4F, -0.3F);
		this.hip_left.addBox(0.0F, 0.0F, -2.5F, 5, 4, 5, 0.0F);
		this.setRotateAngle(hip_left, 0.0F, 0.0F, 0.10471975511965977F);
		this.belly = new ModelRenderer(this, 95, 11);
		this.belly.setRotationPoint(0.6F, -3.2F, -0.3F);
		this.belly.addBox(-5.9F, 0.0F, -1.0F, 5, 4, 2, 0.0F);
		this.setRotateAngle(belly, 0.08726646259971647F, 0.0F, 0.03490658503988659F);
		this.stew = new ModelRenderer(this, 0, 54);
		this.stew.setRotationPoint(0.0F, 1.98F, 0.0F);
		this.stew.addBox(-9.0F, -13.0F, -9.0F, 18, 2, 18, 0.0F);
		this.mush = new ModelRenderer(this, 20, 38);
		this.mush.setRotationPoint(-1.0F, -2.5F, 0.0F);
		this.mush.addBox(-6.0F, -13.0F, -6.0F, 12, 4, 12, 0.0F);
		this.setRotateAngle(mush, 0.0F, -0.045553093477052F, 0.08726646259971647F);
		this.arm_right_lower = new ModelRenderer(this, 0, 46);
		this.arm_right_lower.setRotationPoint(0.0F, 7.4F, 0.1F);
		this.arm_right_lower.addBox(-2.0F, 0.0F, -1.0F, 2, 11, 2, 0.0F);
		this.setRotateAngle(arm_right_lower, -0.39269908169872414F, 0.0F, -0.08726646259971647F);
		this.leaf_cape_bottom = new ModelRenderer(this, 72, 67);
		this.leaf_cape_bottom.setRotationPoint(0.0F, 7.9F, 0.0F);
		this.leaf_cape_bottom.addBox(-5.0F, 0.0F, -2.0F, 10, 12, 2, 0.0F);
		this.setRotateAngle(leaf_cape_bottom, -0.13962634015954636F, 0.0F, -0.008726646259971648F);
		this.leg_left_middle = new ModelRenderer(this, 115, 8);
		this.leg_left_middle.setRotationPoint(0.0F, 2.3F, 0.0F);
		this.leg_left_middle.addBox(-1.5F, 0.0F, -1.5F, 3, 7, 3, 0.0F);
		this.setRotateAngle(leg_left_middle, 0.08726646259971647F, 0.0F, 0.03490658503988659F);
		this.arm_left_lower = new ModelRenderer(this, 24, 28);
		this.arm_left_lower.setRotationPoint(0.0F, 9.4F, 0.1F);
		this.arm_left_lower.addBox(-2.0F, 0.0F, -1.0F, 2, 9, 2, 0.0F);
		this.setRotateAngle(arm_left_lower, -0.39269908169872414F, 0.0F, 0.08726646259971647F);
		this.o_1 = new ModelRenderer(this, 76, 42);
		this.o_1.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.o_1.addBox(-10.0F, -10.0F, -6.0F, 4, 3, 12, 0.0F);
		this.chest_left = new ModelRenderer(this, 90, 17);
		this.chest_left.setRotationPoint(0.8F, -0.4F, -0.2F);
		this.chest_left.addBox(0.0F, -0.1F, -2.5F, 5, 4, 5, 0.0F);
		this.setRotateAngle(chest_left, 0.0F, 0.0F, 0.08726646259971647F);
		this.stem_dish = new ModelRenderer(this, 54, 31);
		this.stem_dish.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.stem_dish.addBox(-3.0F, -4.0F, -3.0F, 6, 1, 6, 0.0F);
		this.setRotateAngle(stem_dish, 0.0F, 0.18203784098300857F, 0.0F);
		this.m = new ModelRenderer(this, 56, 45);
		this.m.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.m.addBox(6.0F, -10.0F, -6.0F, 4, 3, 12, 0.0F);
		this.leaf_cape_middle = new ModelRenderer(this, 88, 57);
		this.leaf_cape_middle.setRotationPoint(0.0F, 7.9F, 0.0F);
		this.leaf_cape_middle.addBox(-5.0F, 0.0F, -2.0F, 10, 8, 2, 0.0F);
		this.setRotateAngle(leaf_cape_middle, -0.13962634015954636F, 0.0F, -0.008726646259971648F);
		this.o = new ModelRenderer(this, 0, 39);
		this.o.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.o.addBox(-6.0F, -10.0F, 6.0F, 12, 3, 4, 0.0F);
		this.leg_right_top = new ModelRenderer(this, 24, 0);
		this.leg_right_top.setRotationPoint(-4.4F, 3.3F, 0.0F);
		this.leg_right_top.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.setRotateAngle(leg_right_top, -0.08726646259971647F, 0.0F, 0.24434609527920614F);
		this.arm_left = new ModelRenderer(this, 52, 23);
		this.arm_left.setRotationPoint(8.6F, 1.8F, -0.3F);
		this.arm_left.addBox(-2.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		this.setRotateAngle(arm_left, -0.39269908169872414F, 0.0F, -0.13962634015954636F);
		this.hip_branch_bottom = new ModelRenderer(this, 113, 0);
		this.hip_branch_bottom.setRotationPoint(-5.6F, 1.2F, -0.2F);
		this.hip_branch_bottom.addBox(-4.0F, -0.5F, -0.5F, 4, 1, 1, 0.0F);
		this.setRotateAngle(hip_branch_bottom, 0.08726646259971647F, -0.40980330836826856F, -0.5918411493512771F);
		this.pelvis_left = new ModelRenderer(this, 36, 0);
		this.pelvis_left.setRotationPoint(0.7F, -0.9F, 0.0F);
		this.pelvis_left.addBox(0.0F, 0.5F, -3.0F, 6, 5, 6, 0.0F);
		this.setRotateAngle(pelvis_left, 0.0F, 0.0F, 0.17453292519943295F);
		this.leaf_cape = new ModelRenderer(this, 0, 28);
		this.leaf_cape.setRotationPoint(-4.0F, -0.5F, 3.8F);
		this.leaf_cape.addBox(-5.0F, 0.0F, -2.0F, 10, 8, 2, 0.0F);
		this.setRotateAngle(leaf_cape, 0.08726646259971647F, 0.0F, 0.03490658503988659F);
		this.shoulder = new ModelRenderer(this, 12, 20);
		this.shoulder.setRotationPoint(0.6F, -3.3F, -0.3F);
		this.shoulder.addBox(-10.0F, 0.0F, -2.0F, 12, 4, 4, 0.0F);
		this.setRotateAngle(shoulder, 0.08726646259971647F, 0.0F, 0.03490658503988659F);
		this.arm_right = new ModelRenderer(this, 44, 23);
		this.arm_right.setRotationPoint(-9.8F, 0.7F, -0.3F);
		this.arm_right.addBox(-2.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(arm_right, -0.39269908169872414F, 0.0F, 0.08726646259971647F);
		this.r = new ModelRenderer(this, 56, 38);
		this.r.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.r.addBox(-6.0F, -10.0F, -10.0F, 12, 3, 4, 0.0F);
		this.leg_right_foot = new ModelRenderer(this, 98, 0);
		this.leg_right_foot.setRotationPoint(0.0F, 5.3F, 0.0F);
		this.leg_right_foot.addBox(-2.5F, 0.0F, -2.5F, 5, 6, 5, 0.0F);
		this.setRotateAngle(leg_right_foot, 0.08726646259971647F, 0.08726646259971647F, -0.03490658503988659F);
		this.leg_left_top_center = new ModelRenderer(this, 0, 8);
		this.leg_left_top_center.setRotationPoint(0.0F, 3.5F, 0.0F);
		this.leg_left_top_center.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(leg_left_top_center, 0.0F, 0.0F, 0.03490658503988659F);
		this.leg_right_center = new ModelRenderer(this, 82, 0);
		this.leg_right_center.setRotationPoint(0.0F, 5.0F, 0.0F);
		this.leg_right_center.addBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F);
		this.setRotateAngle(leg_right_center, 0.08726646259971647F, 0.0F, -0.03490658503988659F);
		this.hip_branch_top = new ModelRenderer(this, 113, 2);
		this.hip_branch_top.setRotationPoint(-5.0F, 0.8F, 0.4F);
		this.hip_branch_top.addBox(-5.0F, -0.5F, -0.5F, 5, 1, 1, 0.0F);
		this.setRotateAngle(hip_branch_top, 0.08726646259971647F, -0.10471975511965977F, 1.0016444577195458F);
		this.shoulder_left = new ModelRenderer(this, 64, 19);
		this.shoulder_left.setRotationPoint(0.3F, -1.5F, -0.2F);
		this.shoulder_left.addBox(0.0F, 0.2F, -3.5F, 7, 5, 7, 0.0F);
		this.setRotateAngle(shoulder_left, 0.0F, 0.0F, 0.08726646259971647F);
		this.pelvis_left.addChild(this.leg_left_top);
		this.neck.addChild(this.head);
		this.leg_left_bottom.addChild(this.leg_left_foot);
		this.shoulder_left.addChild(this.stem);
		this.belly.addChild(this.belly_left);
		this.shoulder.addChild(this.neck);
		this.leg_left_middle.addChild(this.leg_left_bottom);
		this.pelvis.addChild(this.hip);
		this.belly.addChild(this.chest);
		this.hip.addChild(this.hip_left);
		this.hip.addChild(this.belly);
		this.mush.addChild(this.stew);
		this.stem.addChild(this.mush);
		this.arm_right.addChild(this.arm_right_lower);
		this.leaf_cape_middle.addChild(this.leaf_cape_bottom);
		this.leg_left_top_center.addChild(this.leg_left_middle);
		this.arm_left.addChild(this.arm_left_lower);
		this.mush.addChild(this.o_1);
		this.chest.addChild(this.chest_left);
		this.stem.addChild(this.stem_dish);
		this.mush.addChild(this.m);
		this.leaf_cape.addChild(this.leaf_cape_middle);
		this.mush.addChild(this.o);
		this.pelvis.addChild(this.leg_right_top);
		this.shoulder_left.addChild(this.arm_left);
		this.hip.addChild(this.hip_branch_bottom);
		this.pelvis.addChild(this.pelvis_left);
		this.shoulder.addChild(this.leaf_cape);
		this.chest.addChild(this.shoulder);
		this.shoulder.addChild(this.arm_right);
		this.mush.addChild(this.r);
		this.leg_right_center.addChild(this.leg_right_foot);
		this.leg_left_top.addChild(this.leg_left_top_center);
		this.leg_right_top.addChild(this.leg_right_center);
		this.hip.addChild(this.hip_branch_top);
		this.shoulder.addChild(this.shoulder_left);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -MathHelper.cos(limbSwing * 0.6662F * 2.0f + 2.7f) * limbSwingAmount / 8.0f + limbSwingAmount / 15.05f, 0.0F);
		this.pelvis.render(scale);
		GlStateManager.popMatrix();
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void wiggleRotateAngle(ModelRenderer modelRenderer, float x, float y, float z, float ageInTicks) {
		modelRenderer.rotateAngleX = MathHelper.cos(ageInTicks * 0.045F) * 0.015F + x;
		modelRenderer.rotateAngleY = MathHelper.sin(ageInTicks * 0.034F) * 0.015F + y;
		modelRenderer.rotateAngleZ = -MathHelper.cos(ageInTicks * 0.04F) * 0.015F + z;
	}

	float armBend = 1.0f;
	float elbowBend = 1.0f;
	float legBend = 1.5f;
	float kneeBend = 1.3f;

	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
		this.head.rotateAngleX = headPitch * 0.017453292F - 0.9599310885968813F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F + 0.08726646259971647F;

		//limbSwing = ageInTicks / 10.0f;
		//limbSwingAmount = 0.5f;

		this.leg_left_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * legBend * limbSwingAmount - 0.08726646259971647F;
		this.leg_right_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * legBend * limbSwingAmount - 0.08726646259971647F;

		this.arm_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * armBend * limbSwingAmount - 0.39269908169872414F;
		this.arm_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * armBend * limbSwingAmount - 0.39269908169872414F;

		this.arm_right_lower.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * elbowBend * limbSwingAmount - elbowBend * limbSwingAmount - 0.39269908169872414F;
		this.arm_left_lower.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * elbowBend * limbSwingAmount - elbowBend * limbSwingAmount - 0.39269908169872414F;

		this.leg_right_center.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;
		this.leg_left_middle.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;

		if (this.swingProgress > 0.0F)  {
			float f2 = MathHelper.sin(this.swingProgress * (float)Math.PI) * 2.0F;
			this.arm_left.rotateAngleX -= f2;
			this.arm_right.rotateAngleX -= f2;
		}

		this.arm_right.rotateAngleZ = 0.08726646259971647F;
		this.arm_left.rotateAngleZ = -0.13962634015954636F;
		this.arm_right.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.arm_left.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.arm_right.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.arm_left.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		this.wiggleRotateAngle(stem, 0.0F, 0.0F, -0.17453292519943295F, ageInTicks);
		this.wiggleRotateAngle(belly_left, 0.0F, 0.0F, 0.05235987755982988F, ageInTicks);
		this.wiggleRotateAngle(neck, 0.7853981633974483F, 0.08726646259971647F, 0.03490658503988659F, ageInTicks);
		this.wiggleRotateAngle(hip, 0.08726646259971647F, 0.0F, 0.03490658503988659F, ageInTicks);
		this.wiggleRotateAngle(chest, 0.08726646259971647F, 0.0F, 0.03490658503988659F, ageInTicks);
		this.wiggleRotateAngle(hip_left, 0.0F, 0.0F, 0.10471975511965977F, ageInTicks);
		this.wiggleRotateAngle(belly, 0.08726646259971647F, 0.0F, 0.03490658503988659F, ageInTicks);
		this.wiggleRotateAngle(mush, 0.0F, -0.045553093477052F, 0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(leaf_cape_bottom, -0.13962634015954636F, 0.0F, -0.008726646259971648F, ageInTicks);
		this.wiggleRotateAngle(chest_left, 0.0F, 0.0F, 0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(stem_dish, 0.0F, 0.18203784098300857F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(leaf_cape_middle, -0.13962634015954636F, 0.0F, -0.008726646259971648F, ageInTicks);
		this.wiggleRotateAngle(hip_branch_bottom, 0.08726646259971647F, -0.40980330836826856F, -0.5918411493512771F, ageInTicks);
		this.wiggleRotateAngle(leaf_cape, 0.08726646259971647F, 0.0F, 0.03490658503988659F, ageInTicks);
		this.wiggleRotateAngle(shoulder, 0.08726646259971647F, 0.0F, 0.03490658503988659F, ageInTicks);
		this.wiggleRotateAngle(hip_branch_top, 0.08726646259971647F, -0.10471975511965977F, 1.0016444577195458F, ageInTicks);
		this.wiggleRotateAngle(shoulder_left, 0.0F, 0.0F, 0.08726646259971647F, ageInTicks);
	}
}