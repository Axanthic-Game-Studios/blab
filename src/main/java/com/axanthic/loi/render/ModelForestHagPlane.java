package com.axanthic.loi.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelForestHagPlane extends ModelBase {
	public ModelRenderer pelvis;
	public ModelRenderer leg_right_top;
	public ModelRenderer leg_left_top;
	public ModelRenderer hip;
	public ModelRenderer leg_right_topcenter;
	public ModelRenderer leg_right_middle;
	public ModelRenderer leg_right_bottom;
	public ModelRenderer foot_right;
	public ModelRenderer leg_left_topcenter;
	public ModelRenderer leg_left_middle;
	public ModelRenderer leg_left_middle_1;
	public ModelRenderer leg_left_middle_2;
	public ModelRenderer leg_left_bottom;
	public ModelRenderer foot_left;
	public ModelRenderer hip_upper;
	public ModelRenderer side;
	public ModelRenderer belly;
	public ModelRenderer belly_1;
	public ModelRenderer chest;
	public ModelRenderer chest_1;
	public ModelRenderer collar;
	public ModelRenderer shoulder_right;
	public ModelRenderer shoulder_left;
	public ModelRenderer neck;
	public ModelRenderer leaf_cape_rear;
	public ModelRenderer arm_stump_right;
	public ModelRenderer arm_left;
	public ModelRenderer arm__left_bottom;
	public ModelRenderer head;
	public ModelRenderer leaf_hair;
	public ModelRenderer leaf_cape_rear_1;
	public ModelRenderer side_leaves;

	public ModelForestHagPlane() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.leg_left_middle_1 = new ModelRenderer(this, 36, 7);
		this.leg_left_middle_1.setRotationPoint(0.0F, 1.7F, 0.0F);
		this.leg_left_middle_1.addBox(-0.7F, 0.0F, 0.3F, 1, 7, 1, 0.0F);
		this.setRotateAngle(leg_left_middle_1, 0.08726646259971647F, -0.04363323129985824F, 0.0F);
		this.hip_upper = new ModelRenderer(this, 0, 9);
		this.hip_upper.setRotationPoint(0.0F, -2.4F, 0.0F);
		this.hip_upper.addBox(-3.9F, 0.0F, -1.2F, 9, 3, 3, 0.0F);
		this.setRotateAngle(hip_upper, 0.0F, 0.0F, 0.08726646259971647F);
		this.leg_left_bottom = new ModelRenderer(this, 61, 7);
		this.leg_left_bottom.setRotationPoint(0.0F, 6.8F, 0.0F);
		this.leg_left_bottom.addBox(-1.5F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
		this.setRotateAngle(leg_left_bottom, 0.0F, 0.04363323129985824F, 0.0F);
		this.leg_right_middle = new ModelRenderer(this, 104, 0);
		this.leg_right_middle.setRotationPoint(0.0F, 2.7F, 0.0F);
		this.leg_right_middle.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
		this.setRotateAngle(leg_right_middle, 0.08726646259971647F, -0.04363323129985824F, 0.0F);
		this.leg_right_top = new ModelRenderer(this, 32, 0);
		this.leg_right_top.setRotationPoint(-3.0F, 3.5F, 0.0F);
		this.leg_right_top.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 4, 0.0F);
		this.setRotateAngle(leg_right_top, -0.08726646259971647F, 0.04363323129985824F, 0.04363323129985824F);
		this.hip = new ModelRenderer(this, 64, 0);
		this.hip.setRotationPoint(0.0F, -2.4F, 0.0F);
		this.hip.addBox(-4.6F, 0.0F, -1.7F, 10, 3, 4, 0.0F);
		this.setRotateAngle(hip, -0.08726646259971647F, 0.0F, 0.08726646259971647F);
		this.foot_right = new ModelRenderer(this, 108, 5);
		this.foot_right.setRotationPoint(0.0F, 1.5F, 0.0F);
		this.foot_right.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(foot_right, 0.08726646259971647F, -0.04363323129985824F, -0.04363323129985824F);
		this.arm__left_bottom = new ModelRenderer(this, 61, 22);
		this.arm__left_bottom.setRotationPoint(0.0F, 7.5F, 0.0F);
		this.arm__left_bottom.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		this.setRotateAngle(arm__left_bottom, -0.17453292519943295F, 0.0F, -0.17453292519943295F);
		this.foot_left = new ModelRenderer(this, 73, 7);
		this.foot_left.setRotationPoint(0.0F, 1.5F, 0.0F);
		this.foot_left.addBox(-2.0F, 0.0F, -2.2F, 4, 3, 4, 0.0F);
		this.setRotateAngle(foot_left, 0.08726646259971647F, 0.04363323129985824F, 0.0F);
		this.leg_right_topcenter = new ModelRenderer(this, 92, 0);
		this.leg_right_topcenter.setRotationPoint(0.0F, 2.8F, 0.0F);
		this.leg_right_topcenter.addBox(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
		this.setRotateAngle(leg_right_topcenter, 0.0F, 0.04363323129985824F, 0.04363323129985824F);
		this.leaf_hair = new ModelRenderer(this, 26, 29);
		this.leaf_hair.setRotationPoint(0.0F, -1.4F, 2.7F);
		this.leaf_hair.addBox(-3.5F, -6.4F, -1.5F, 7, 13, 3, 0.0F);
		this.setRotateAngle(leaf_hair, 0.0F, 0.0F, 0.045553093477052F);
		this.side_leaves = new ModelRenderer(this, 46, 31);
		this.side_leaves.setRotationPoint(-5.0F, -11.0F, 0.0F);
		this.side_leaves.addBox(-1.5F, 0.0F, -2.0F, 3, 18, 4, 0.0F);
		this.chest = new ModelRenderer(this, 52, 12);
		this.chest.setRotationPoint(0.0F, -1.5F, 0.0F);
		this.chest.addBox(-5.3F, 0.0F, -2.8F, 5, 3, 5, 0.0F);
		this.setRotateAngle(chest, 0.08726646259971647F, 0.0F, 0.17453292519943295F);
		this.head = new ModelRenderer(this, 99, 25);
		this.head.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.head.addBox(-3.0F, -5.0F, -6.0F, 6, 8, 6, 0.0F);
		this.setRotateAngle(head, -0.8726646259971648F, -0.091106186954104F, 0.136659280431156F);
		this.shoulder_left = new ModelRenderer(this, 81, 19);
		this.shoulder_left.setRotationPoint(7.5F, -1.0F, 0.8F);
		this.shoulder_left.addBox(-2.5F, 0.0F, -2.5F, 6, 6, 6, 0.0F);
		this.setRotateAngle(shoulder_left, -0.5009094953223726F, 0.7853981633974483F, -0.4553564018453205F);
		this.leg_left_top = new ModelRenderer(this, 48, 0);
		this.leg_left_top.setRotationPoint(3.0F, 3.5F, 0.0F);
		this.leg_left_top.addBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(leg_left_top, -0.08726646259971647F, -0.04363323129985824F, -0.04363323129985824F);
		this.shoulder_right = new ModelRenderer(this, 67, 15);
		this.shoulder_right.setRotationPoint(-5.4F, 0.3F, 0.1F);
		this.shoulder_right.addBox(-2.5F, 0.0F, -2.5F, 5, 4, 5, 0.0F);
		this.setRotateAngle(shoulder_right, -0.4553564018453205F, 0.7853981633974483F, -0.091106186954104F);
		this.leg_right_bottom = new ModelRenderer(this, 112, 0);
		this.leg_right_bottom.setRotationPoint(0.0F, 5.8F, 0.0F);
		this.leg_right_bottom.addBox(-1.5F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
		this.setRotateAngle(leg_right_bottom, 0.0F, -0.04363323129985824F, -0.04363323129985824F);
		this.leg_left_middle_2 = new ModelRenderer(this, 40, 7);
		this.leg_left_middle_2.setRotationPoint(0.0F, 1.7F, 0.0F);
		this.leg_left_middle_2.addBox(0.3F, 0.0F, -0.9F, 1, 7, 1, 0.0F);
		this.setRotateAngle(leg_left_middle_2, 0.08726646259971647F, -0.04363323129985824F, 0.0F);
		this.arm_left = new ModelRenderer(this, 36, 15);
		this.arm_left.setRotationPoint(0.7F, 5.5F, 0.8F);
		this.arm_left.addBox(-1.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
		this.setRotateAngle(arm_left, -0.08726646259971647F, 0.5811946409141118F, -0.13962634015954636F);
		this.collar = new ModelRenderer(this, 0, 19);
		this.collar.setRotationPoint(0.0F, -3.6F, -0.7F);
		this.collar.addBox(-5.7F, 0.0F, -3.0F, 13, 4, 6, 0.0F);
		this.setRotateAngle(collar, 0.08726646259971647F, 0.0F, 0.08726646259971647F);
		this.neck = new ModelRenderer(this, 49, 20);
		this.neck.setRotationPoint(0.6F, 0.8F, -0.5F);
		this.neck.addBox(-1.5F, -6.4F, -1.5F, 3, 8, 3, 0.0F);
		this.setRotateAngle(neck, 0.8726646259971648F, 0.08726646259971647F, 0.0F);
		this.leaf_cape_rear = new ModelRenderer(this, 0, 29);
		this.leaf_cape_rear.setRotationPoint(0.0F, 0.1F, 2.5F);
		this.leaf_cape_rear.addBox(-4.8F, 0.0F, 0.0F, 11, 18, 2, 0.0F);
		this.setRotateAngle(leaf_cape_rear, 0.06806784082777885F, 0.091106186954104F, 0.0F);
		this.leg_left_topcenter = new ModelRenderer(this, 89, 6);
		this.leg_left_topcenter.setRotationPoint(0.0F, 3.8F, 0.0F);
		this.leg_left_topcenter.addBox(-1.5F, 0.0F, -1.5F, 3, 2, 3, 0.0F);
		this.setRotateAngle(leg_left_topcenter, 0.0F, 0.04363323129985824F, 0.04363323129985824F);
		this.side = new ModelRenderer(this, 44, 8);
		this.side.setRotationPoint(0.0F, -1.2F, 0.0F);
		this.side.addBox(-5.3F, -7.2F, -1.5F, 1, 11, 3, 0.0F);
		this.setRotateAngle(side, 0.04363323129985824F, 0.0F, -0.1308996938995747F);
		this.arm_stump_right = new ModelRenderer(this, 0, 15);
		this.arm_stump_right.setRotationPoint(-0.8F, 3.5F, -0.8F);
		this.arm_stump_right.addBox(-1.0F, 0.0F, -0.5F, 2, 8, 1, 0.0F);
		this.setRotateAngle(arm_stump_right, 0.0F, 0.7853981633974483F, 0.0F);
		this.belly = new ModelRenderer(this, 20, 11);
		this.belly.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.belly.addBox(-5.2F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
		this.setRotateAngle(belly, 0.08726646259971647F, 0.0F, -0.27314402793711257F);
		this.leaf_cape_rear_1 = new ModelRenderer(this, 69, 31);
		this.leaf_cape_rear_1.setRotationPoint(0.0F, 6.2F, 1.2F);
		this.leaf_cape_rear_1.addBox(-3.5F, 0.0F, -1.5F, 7, 16, 2, 0.0F);
		this.setRotateAngle(leaf_cape_rear_1, -0.9105382707654417F, 0.0F, -0.045553093477052F);
		this.belly_1 = new ModelRenderer(this, 85, 11);
		this.belly_1.setRotationPoint(0.0F, -3.9F, 0.0F);
		this.belly_1.addBox(0.6F, 0.0F, -2.0F, 5, 4, 4, 0.0F);
		this.setRotateAngle(belly_1, 0.08726646259971647F, 0.0F, 0.08726646259971647F);
		this.chest_1 = new ModelRenderer(this, 103, 13);
		this.chest_1.setRotationPoint(-1.3F, -1.3F, 0.0F);
		this.chest_1.addBox(0.5F, 0.0F, -2.8F, 6, 4, 5, 0.0F);
		this.setRotateAngle(chest_1, 0.08726646259971647F, 0.0F, -0.3490658503988659F);
		this.leg_left_middle = new ModelRenderer(this, 32, 7);
		this.leg_left_middle.setRotationPoint(0.0F, 1.7F, 0.0F);
		this.leg_left_middle.addBox(-1.3F, 0.0F, -1.2F, 1, 7, 1, 0.0F);
		this.setRotateAngle(leg_left_middle, 0.08726646259971647F, -0.08726646259971647F, 0.0F);
		this.pelvis = new ModelRenderer(this, 0, 0);
		this.pelvis.setRotationPoint(0.0F, 3.8F, 0.0F);
		this.pelvis.addBox(-5.5F, 0.0F, -2.5F, 11, 4, 5, 0.0F);
		this.setRotateAngle(pelvis, -0.08726646259971647F, 0.0F, 0.0F);
		this.leg_left_topcenter.addChild(this.leg_left_middle_1);
		this.hip.addChild(this.hip_upper);
		this.leg_left_middle.addChild(this.leg_left_bottom);
		this.leg_right_topcenter.addChild(this.leg_right_middle);
		this.pelvis.addChild(this.leg_right_top);
		this.pelvis.addChild(this.hip);
		this.leg_right_bottom.addChild(this.foot_right);
		this.arm_left.addChild(this.arm__left_bottom);
		this.leg_left_bottom.addChild(this.foot_left);
		this.leg_right_top.addChild(this.leg_right_topcenter);
		this.neck.addChild(this.leaf_hair);
		this.side.addChild(this.side_leaves);
		this.belly.addChild(this.chest);
		this.neck.addChild(this.head);
		this.collar.addChild(this.shoulder_left);
		this.pelvis.addChild(this.leg_left_top);
		this.collar.addChild(this.shoulder_right);
		this.leg_right_middle.addChild(this.leg_right_bottom);
		this.leg_left_topcenter.addChild(this.leg_left_middle_2);
		this.shoulder_left.addChild(this.arm_left);
		this.chest_1.addChild(this.collar);
		this.collar.addChild(this.neck);
		this.collar.addChild(this.leaf_cape_rear);
		this.leg_left_top.addChild(this.leg_left_topcenter);
		this.hip.addChild(this.side);
		this.shoulder_right.addChild(this.arm_stump_right);
		this.hip_upper.addChild(this.belly);
		this.leaf_hair.addChild(this.leaf_cape_rear_1);
		this.hip_upper.addChild(this.belly_1);
		this.belly_1.addChild(this.chest_1);
		this.leg_left_topcenter.addChild(this.leg_left_middle);
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
		this.head.rotateAngleX = headPitch * 0.017453292F - 0.8726646259971648F;
		this.head.rotateAngleY = netHeadYaw * 0.017453292F - 0.091106186954104F;

		//limbSwing = ageInTicks / 10.0f;
		//limbSwingAmount = 0.5f;

		this.leg_left_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * legBend * limbSwingAmount - 0.08726646259971647F;
		this.leg_right_top.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * legBend * limbSwingAmount - 0.08726646259971647F;

		this.shoulder_right.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * armBend * limbSwingAmount - 0.4553564018453205F;
		this.shoulder_left.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * armBend * limbSwingAmount - 0.5009094953223726F;

		//this.arm_right_bottom.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * elbowBend * limbSwingAmount - elbowBend * limbSwingAmount - 0.136659280431156F;
		this.arm__left_bottom.rotateAngleZ = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * elbowBend * limbSwingAmount - elbowBend * limbSwingAmount - 0.17453292519943295F;

		this.leg_right_middle.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F + (float)Math.PI) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;
		this.leg_left_middle.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;
		this.leg_left_middle_1.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;
		this.leg_left_middle_2.rotateAngleX = MathHelper.sin(limbSwing * 0.6662F) * kneeBend * limbSwingAmount + kneeBend * limbSwingAmount + 0.08726646259971647F;

		if (this.swingProgress > 0.0F)  {
			float f2 = MathHelper.sin(this.swingProgress * (float)Math.PI) * 2.0F;
			this.shoulder_left.rotateAngleX -= f2;
			this.shoulder_right.rotateAngleX -= f2;
		}

		this.shoulder_right.rotateAngleZ = -0.091106186954104F;
		this.shoulder_left.rotateAngleZ = -0.4553564018453205F;
		this.shoulder_right.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.shoulder_left.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F;
		this.shoulder_right.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		this.shoulder_left.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;

		this.wiggleRotateAngle(hip_upper, 0.0F, 0.0F, 0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(hip, -0.08726646259971647F, 0.0F, 0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(leaf_hair, 0.0F, 0.0F, 0.045553093477052F, ageInTicks);
		this.wiggleRotateAngle(side_leaves, 0.0F, 0.0F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(chest, 0.08726646259971647F, 0.0F, 0.17453292519943295F, ageInTicks);
		this.wiggleRotateAngle(arm_left, -0.08726646259971647F, 0.5811946409141118F, -0.13962634015954636F, ageInTicks);
		this.wiggleRotateAngle(collar, 0.08726646259971647F, 0.0F, 0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(neck, 0.8726646259971648F, 0.08726646259971647F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(leaf_cape_rear, 0.06806784082777885F, 0.091106186954104F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(side, 0.04363323129985824F, 0.0F, -0.1308996938995747F, ageInTicks);
		this.wiggleRotateAngle(arm_stump_right, 0.0F, 0.7853981633974483F, 0.0F, ageInTicks);
		this.wiggleRotateAngle(belly, 0.08726646259971647F, 0.0F, -0.27314402793711257F, ageInTicks);
		this.wiggleRotateAngle(leaf_cape_rear_1, -0.9105382707654417F, 0.0F, -0.045553093477052F, ageInTicks);
		this.wiggleRotateAngle(belly_1, 0.08726646259971647F, 0.0F, 0.08726646259971647F, ageInTicks);
		this.wiggleRotateAngle(chest_1, 0.08726646259971647F, 0.0F, -0.3490658503988659F, ageInTicks);
	}
}