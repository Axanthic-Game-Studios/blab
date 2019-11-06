package com.axanthic.loi.entity;

import com.axanthic.loi.Resources;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ModelRevenantCaptain extends ModelRevenantCivilian {

	public ModelRenderer skirt_front_center;
	public ModelRenderer helmet;
	public ModelRenderer brushholder;
	public ModelRenderer brush;
	public ModelRenderer rib_4th_back_right;
	public ModelRenderer rib_5th_back_right;
	public ModelRenderer chestplate_top;
	public ModelRenderer rib_4th_side_right;
	public ModelRenderer rib_4th_front_right;
	public ModelRenderer rib_5th_side_right;
	public ModelRenderer rib_5th_front_right;
	public ModelRenderer chestplate_side_right;
	public ModelRenderer chestplate_side_right_1;
	public ModelRenderer chestplate_center;
	public ModelRenderer chestplate_bottom;
	public ModelRenderer chestplate_leatherband;
	public ModelRenderer shoulderplate_right;
	public ModelRenderer shoulderplate_left;
	public ModelRenderer armcloth_right;
	public ModelRenderer armcloth_left;
	public ModelRenderer leg_armor_left;
	public ModelRenderer leg_armor_right;
	public ModelRenderer skirt_front_halfright;
	public ModelRenderer skirt_front_right;
	public ModelRenderer skirt_front_halfleft;
	public ModelRenderer skirt_front_halfleft_1;
	public ModelRenderer skirt_back;
	public ModelRenderer skirt_side_right;
	public ModelRenderer skirt_side_left;

	public ModelRevenantCaptain() {
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.rib_2nd_side_left = new ModelRenderer(this, 48, 11);
		this.rib_2nd_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_2nd_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.skirt_front_halfright = new ModelRenderer(this, 44, 16);
		this.skirt_front_halfright.mirror = true;
		this.skirt_front_halfright.setRotationPoint(0.2F, 0.6F, 0.0F);
		this.skirt_front_halfright.addBox(-2.9F, -2.0F, -1.9F, 2, 7, 1, 0.0F);
		this.setRotateAngle(skirt_front_halfright, 0.0F, 0.0F, 0.10471975511965977F);
		this.rib_4th_side_left = new ModelRenderer(this, 98, 12);
		this.rib_4th_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_4th_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.rib_2nd_back_left = new ModelRenderer(this, 70, 7);
		this.rib_2nd_back_left.setRotationPoint(0.3F, 0.0F, 0.0F);
		this.rib_2nd_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_2nd_back_left, 0.0F, 0.0F, 0.10471975511965977F);
		this.rib_top_backplate_right = new ModelRenderer(this, 82, 9);
		this.rib_top_backplate_right.setRotationPoint(-1.5F, -2.0F, 0.0F);
		this.rib_top_backplate_right.addBox(-5.0F, 5.5F, 0.2F, 13, 1, 1, 0.0F);
		this.skirt_front_halfleft = new ModelRenderer(this, 56, 16);
		this.skirt_front_halfleft.mirror = true;
		this.skirt_front_halfleft.setRotationPoint(0.0F, 0.6F, 0.0F);
		this.skirt_front_halfleft.addBox(0.7F, -2.0F, -1.9F, 2, 7, 1, 0.0F);
		this.setRotateAngle(skirt_front_halfleft, 0.0F, 0.0F, -0.10471975511965977F);
		this.arm_left = new ModelRenderer(this, 62, 0);
		this.arm_left.mirror = true;
		this.arm_left.setRotationPoint(6.0F, -2.0F, 0.0F);
		this.arm_left.addBox(-0.2F, 0.0F, -0.5F, 2, 5, 2, 0.0F);
		this.setRotateAngle(arm_left, -0.20943951023931953F, 0.0F, -0.3141592653589793F);
		this.chestplate_center = new ModelRenderer(this, 0, 48);
		this.chestplate_center.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.chestplate_center.addBox(-2.5F, 1.8F, -2.4F, 5, 9, 5, 0.0F);
		this.rib_5th_front_left = new ModelRenderer(this, 44, 11);
		this.rib_5th_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_5th_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_2nd_front_right = new ModelRenderer(this, 0, 2);
		this.rib_2nd_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_2nd_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.leg_right = new ModelRenderer(this, 46, 0);
		this.leg_right.setRotationPoint(-2.5F, 10.2F, 0.1F);
		this.leg_right.addBox(-1.4F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_right, -0.10471975511965977F, 0.20943951023931953F, 0.0F);
		this.skirt_front_center = new ModelRenderer(this, 38, 16);
		this.skirt_front_center.mirror = true;
		this.skirt_front_center.setRotationPoint(0.0F, 10.0F, 0.0F);
		this.skirt_front_center.addBox(-1.0F, -2.0F, -2.0F, 2, 8, 1, 0.0F);
		this.setRotateAngle(skirt_front_center, -0.20943951023931953F, 0.0F, 0.0F);
		this.rib_4th_side_right = new ModelRenderer(this, 58, 11);
		this.rib_4th_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_4th_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.upper_jaw = new ModelRenderer(this, 70, 0);
		this.upper_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.upper_jaw.addBox(-2.5F, -2.0F, -3.5F, 5, 1, 6, 0.0F);
		this.shoulderplate_left = new ModelRenderer(this, 72, 43);
		this.shoulderplate_left.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shoulderplate_left.addBox(4.0F, 0.5F, -3.5F, 5, 4, 7, 0.0F);
		this.rib_4th_front_right = new ModelRenderer(this, 0, 6);
		this.rib_4th_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_4th_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_3rd_side_left = new ModelRenderer(this, 82, 11);
		this.rib_3rd_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_3rd_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.chestplate_side_right = new ModelRenderer(this, 0, 38);
		this.chestplate_side_right.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.chestplate_side_right.addBox(-7.5F, 2.8F, -2.2F, 4, 5, 5, 0.0F);
		this.setRotateAngle(chestplate_side_right, 0.0F, 0.0F, -0.3141592653589793F);
		this.rib_3rd_front_left = new ModelRenderer(this, 22, 4);
		this.rib_3rd_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_3rd_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_3rd_back_right = new ModelRenderer(this, 80, 7);
		this.rib_3rd_back_right.setRotationPoint(-0.4F, 1.0F, 0.0F);
		this.rib_3rd_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_3rd_back_right, 0.0F, 0.0F, -0.20943951023931953F);
		this.rib_4th_back_left = new ModelRenderer(this, 110, 7);
		this.rib_4th_back_left.setRotationPoint(0.4F, 2.0F, 0.0F);
		this.rib_4th_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_4th_back_left, 0.0F, 0.0F, 0.3141592653589793F);
		this.leg_left_bottom = new ModelRenderer(this, 22, 18);
		this.leg_left_bottom.mirror = true;
		this.leg_left_bottom.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.leg_left_bottom.addBox(-0.6F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_left_bottom, 0.20943951023931953F, 0.0F, 0.0F);
		this.arm_right_lower = new ModelRenderer(this, 78, 27);
		this.arm_right_lower.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.arm_right_lower.addBox(-1.8F, -0.2F, -0.5F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_right_lower, -0.10471975511965977F, 0.0F, -0.10471975511965977F);
		this.skirt_side_left = new ModelRenderer(this, 64, 24);
		this.skirt_side_left.mirror = true;
		this.skirt_side_left.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.skirt_side_left.addBox(3.0F, 0.0F, -1.7F, 1, 8, 3, 0.0F);
		this.setRotateAngle(skirt_side_left, 0.20943951023931953F, 0.0F, -0.20943951023931953F);
		this.rib_top_side_left = new ModelRenderer(this, 106, 9);
		this.rib_top_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F);
		this.front_chest_bone = new ModelRenderer(this, 114, 0);
		this.front_chest_bone.setRotationPoint(0.0F, -2.0F, -0.2F);
		this.front_chest_bone.addBox(-2.0F, 3.5F, -2.0F, 4, 6, 1, 0.0F);
		this.rib_3rd_back_left = new ModelRenderer(this, 90, 7);
		this.rib_3rd_back_left.setRotationPoint(0.4F, 1.0F, 0.0F);
		this.rib_3rd_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_3rd_back_left, 0.0F, 0.0F, 0.20943951023931953F);
		this.chestplate_top = new ModelRenderer(this, 0, 27);
		this.chestplate_top.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.chestplate_top.addBox(-6.5F, 0.8F, -3.0F, 13, 5, 6, 0.0F);
		this.armcloth_left = new ModelRenderer(this, 68, 54);
		this.armcloth_left.setRotationPoint(8.3F, 0.5F, 0.0F);
		this.armcloth_left.addBox(0.5F, -0.5F, -3.0F, 4, 4, 6, 0.0F);
		this.setRotateAngle(armcloth_left, 0.0F, 0.0F, 1.0471975511965976F);
		this.leg_left = new ModelRenderer(this, 38, 0);
		this.leg_left.mirror = true;
		this.leg_left.setRotationPoint(2.5F, 10.2F, 0.1F);
		this.leg_left.addBox(-0.6F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_left, -0.10471975511965977F, -0.20943951023931953F, 0.0F);
		this.helmet = new ModelRenderer(this, 86, 18);
		this.helmet.setRotationPoint(0.0F, -5.0F, 0.0F);
		this.helmet.addBox(-4.0F, -3.5F, -4.7F, 8, 9, 9, 0.0F);
		this.spine_legplate_bottom = new ModelRenderer(this, 6, 14);
		this.spine_legplate_bottom.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.spine_legplate_bottom.addBox(-3.5F, 19.8F, -1.5F, 7, 1, 1, 0.0F);
		this.lower_jaw = new ModelRenderer(this, 92, 0);
		this.lower_jaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.lower_jaw.addBox(-2.5F, -0.8F, -3.3F, 5, 1, 6, 0.0F);
		this.setRotateAngle(lower_jaw, 0.10471975511965977F, 0.0F, 0.0F);
		this.rib_5th_back_left = new ModelRenderer(this, 48, 9);
		this.rib_5th_back_left.setRotationPoint(0.3F, 3.0F, 0.0F);
		this.rib_5th_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_5th_back_left, 0.0F, 0.0F, 0.41887902047863906F);
		this.shoulderplate_right = new ModelRenderer(this, 48, 43);
		this.shoulderplate_right.setRotationPoint(-2.0F, 0.0F, 0.0F);
		this.shoulderplate_right.addBox(-7.0F, 0.5F, -3.5F, 5, 4, 7, 0.0F);
		this.leg_armor_left = new ModelRenderer(this, 38, 35);
		this.leg_armor_left.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leg_armor_left.addBox(-1.2F, -2.0F, -1.2F, 3, 5, 3, 0.0F);
		this.setRotateAngle(leg_armor_left, 0.0F, 0.6806784082777886F, 0.0F);
		this.armcloth_right = new ModelRenderer(this, 48, 54);
		this.armcloth_right.setRotationPoint(-6.3F, 0.5F, 0.0F);
		this.armcloth_right.addBox(-4.5F, -0.5F, -3.0F, 4, 4, 6, 0.0F);
		this.setRotateAngle(armcloth_right, 0.0F, 0.0F, -1.0471975511965976F);
		this.skirt_back = new ModelRenderer(this, 38, 25);
		this.skirt_back.mirror = true;
		this.skirt_back.setRotationPoint(-3.0F, 0.0F, 0.0F);
		this.skirt_back.addBox(-1.0F, -3.0F, 1.6F, 8, 8, 1, 0.0F);
		this.setRotateAngle(skirt_back, 0.3141592653589793F, 0.0F, 0.0F);
		this.chestplate_bottom = new ModelRenderer(this, 20, 48);
		this.chestplate_bottom.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.chestplate_bottom.addBox(-4.5F, 2.8F, -2.3F, 9, 10, 5, 0.0F);
		this.spine = new ModelRenderer(this, 30, 0);
		this.spine.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.spine.addBox(-1.0F, -2.0F, 0.4F, 2, 16, 2, 0.0F);
		this.rib_4th_front_left = new ModelRenderer(this, 22, 6);
		this.rib_4th_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_4th_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_top_back_right = new ModelRenderer(this, 86, 0);
		this.rib_top_back_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 2, 1, 0.0F);
		this.rib_5th_back_right = new ModelRenderer(this, 80, 7);
		this.rib_5th_back_right.setRotationPoint(-0.3F, 3.0F, 0.0F);
		this.rib_5th_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_5th_back_right, 0.0F, 0.0F, -0.41887902047863906F);
		this.spine_legplate_left = new ModelRenderer(this, 19, 14);
		this.spine_legplate_left.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.spine_legplate_left.addBox(1.8F, 0.5F, -1.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(spine_legplate_left, 0.20943951023931953F, 0.10471975511965977F, 0.0F);
		this.spine_legplate_top = new ModelRenderer(this, 58, 9);
		this.spine_legplate_top.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.spine_legplate_top.addBox(-4.0F, 16.8F, 1.0F, 8, 1, 1, 0.0F);
		this.skirt_front_right = new ModelRenderer(this, 50, 16);
		this.skirt_front_right.mirror = true;
		this.skirt_front_right.setRotationPoint(0.0F, 0.6F, 0.0F);
		this.skirt_front_right.addBox(-4.5F, -2.5F, -1.8F, 2, 7, 1, 0.0F);
		this.setRotateAngle(skirt_front_right, 0.0F, 0.0F, 0.20943951023931953F);
		this.rib_3rd_front_right = new ModelRenderer(this, 0, 4);
		this.rib_3rd_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_3rd_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_2nd_front_left = new ModelRenderer(this, 22, 2);
		this.rib_2nd_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_2nd_front_left.addBox(2.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.spine_legplate_right = new ModelRenderer(this, 64, 11);
		this.spine_legplate_right.setRotationPoint(0.0F, 19.0F, 0.0F);
		this.spine_legplate_right.addBox(-3.8F, 0.5F, -1.0F, 2, 1, 3, 0.0F);
		this.setRotateAngle(spine_legplate_right, 0.20943951023931953F, -0.10471975511965977F, 0.0F);
		this.leg_right_bottom = new ModelRenderer(this, 115, 18);
		this.leg_right_bottom.mirror = true;
		this.leg_right_bottom.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.leg_right_bottom.addBox(-1.4F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
		this.setRotateAngle(leg_right_bottom, 0.20943951023931953F, 0.0F, 0.0F);
		this.rib_3rd_side_right = new ModelRenderer(this, 58, 11);
		this.rib_3rd_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_3rd_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.rib_top_back_left = new ModelRenderer(this, 86, 3);
		this.rib_top_back_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_back_left.addBox(1.0F, 3.0F, 1.0F, 4, 2, 1, 0.0F);
		this.rib_top_front_right = new ModelRenderer(this, 0, 0);
		this.rib_top_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_front_right.addBox(-5.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_2nd_side_right = new ModelRenderer(this, 38, 11);
		this.rib_2nd_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_2nd_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.rib_5th_front_right = new ModelRenderer(this, 0, 2);
		this.rib_5th_front_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_5th_front_right.addBox(-5.0F, 7.0F, -2.0F, 3, 1, 1, 0.0F);
		this.brushholder = new ModelRenderer(this, 69, 13);
		this.brushholder.setRotationPoint(0.0F, -1.0F, 1.0F);
		this.brushholder.addBox(-1.0F, -3.5F, -5.5F, 2, 5, 9, 0.0F);
		this.skirt_side_right = new ModelRenderer(this, 56, 24);
		this.skirt_side_right.mirror = true;
		this.skirt_side_right.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.skirt_side_right.addBox(-4.0F, 0.0F, -1.7F, 1, 8, 3, 0.0F);
		this.setRotateAngle(skirt_side_right, 0.20943951023931953F, 0.0F, 0.20943951023931953F);
		this.rib_5th_side_right = new ModelRenderer(this, 58, 11);
		this.rib_5th_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_5th_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.rib_top_side_right = new ModelRenderer(this, 116, 7);
		this.rib_top_side_right.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_side_right.addBox(-6.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F);
		this.chestplate_side_right_1 = new ModelRenderer(this, 18, 38);
		this.chestplate_side_right_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.chestplate_side_right_1.addBox(3.5F, 2.8F, -2.2F, 4, 5, 5, 0.0F);
		this.setRotateAngle(chestplate_side_right_1, 0.0F, 0.0F, 0.3141592653589793F);
		this.skull = new ModelRenderer(this, 0, 0);
		this.skull.setRotationPoint(0.0F, -4.0F, 0.0F);
		this.skull.addBox(-3.5F, -8.0F, -4.0F, 7, 6, 8, 0.0F);
		this.arm_right = new ModelRenderer(this, 54, 0);
		this.arm_right.setRotationPoint(-6.0F, -2.0F, 0.0F);
		this.arm_right.addBox(-1.8F, 0.0F, -0.5F, 2, 7, 2, 0.0F);
		this.setRotateAngle(arm_right, 0.0F, 0.0F, 0.12391837689159739F);
		this.chestplate_leatherband = new ModelRenderer(this, 112, 42);
		this.chestplate_leatherband.setRotationPoint(3.0F, 0.0F, 0.0F);
		this.chestplate_leatherband.addBox(0.0F, 0.0F, -3.5F, 1, 14, 7, 0.0F);
		this.setRotateAngle(chestplate_leatherband, 0.0F, 0.0F, 0.6283185307179586F);
		this.skirt_front_halfleft_1 = new ModelRenderer(this, 62, 16);
		this.skirt_front_halfleft_1.mirror = true;
		this.skirt_front_halfleft_1.setRotationPoint(0.0F, 0.6F, 0.0F);
		this.skirt_front_halfleft_1.addBox(2.5F, -2.5F, -1.8F, 2, 7, 1, 0.0F);
		this.setRotateAngle(skirt_front_halfleft_1, 0.0F, 0.0F, -0.20943951023931953F);
		this.rib_4th_back_right = new ModelRenderer(this, 80, 7);
		this.rib_4th_back_right.setRotationPoint(-0.4F, 2.0F, 0.0F);
		this.rib_4th_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_4th_back_right, 0.0F, 0.0F, -0.3141592653589793F);
		this.rib_5th_side_left = new ModelRenderer(this, 0, 14);
		this.rib_5th_side_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_5th_side_left.addBox(5.0F, 5.0F, -2.0F, 1, 1, 4, 0.0F);
		this.leg_armor_right = new ModelRenderer(this, 38, 35);
		this.leg_armor_right.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.leg_armor_right.addBox(-1.8F, -2.0F, -1.8F, 3, 5, 3, 0.0F);
		this.setRotateAngle(leg_armor_right, 0.0F, 0.890117918517108F, 0.0F);
		this.rib_2nd_back_right = new ModelRenderer(this, 22, 0);
		this.rib_2nd_back_right.setRotationPoint(-0.3F, 0.0F, 0.0F);
		this.rib_2nd_back_right.addBox(-5.0F, 3.0F, 1.0F, 4, 1, 1, 0.0F);
		this.setRotateAngle(rib_2nd_back_right, 0.0F, 0.0F, -0.10471975511965977F);
		this.brush = new ModelRenderer(this, 88, 46);
		this.brush.setRotationPoint(0.0F, -1.0F, 1.0F);
		this.brush.addBox(-0.5F, -5.5F, -6.2F, 1, 7, 11, 0.0F);
		this.rib_top_front_left = new ModelRenderer(this, 68, 0);
		this.rib_top_front_left.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rib_top_front_left.addBox(2.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F);
		this.rib_2nd_back_left.addChild(this.rib_2nd_side_left);
		this.skirt_front_center.addChild(this.skirt_front_halfright);
		this.rib_4th_back_left.addChild(this.rib_4th_side_left);
		this.spine.addChild(this.rib_2nd_back_left);
		this.front_chest_bone.addChild(this.rib_top_backplate_right);
		this.skirt_front_center.addChild(this.skirt_front_halfleft);
		this.chestplate_top.addChild(this.chestplate_center);
		this.rib_5th_side_left.addChild(this.rib_5th_front_left);
		this.rib_2nd_side_right.addChild(this.rib_2nd_front_right);
		this.rib_4th_back_right.addChild(this.rib_4th_side_right);
		this.skull.addChild(this.upper_jaw);
		this.chestplate_top.addChild(this.shoulderplate_left);
		this.rib_4th_side_right.addChild(this.rib_4th_front_right);
		this.rib_3rd_back_left.addChild(this.rib_3rd_side_left);
		this.chestplate_top.addChild(this.chestplate_side_right);
		this.rib_3rd_side_left.addChild(this.rib_3rd_front_left);
		this.spine.addChild(this.rib_3rd_back_right);
		this.spine.addChild(this.rib_4th_back_left);
		this.leg_left.addChild(this.leg_left_bottom);
		this.arm_right.addChild(this.arm_right_lower);
		this.skirt_front_center.addChild(this.skirt_side_left);
		this.rib_top_back_left.addChild(this.rib_top_side_left);
		this.spine.addChild(this.front_chest_bone);
		this.spine.addChild(this.rib_3rd_back_left);
		this.spine.addChild(this.chestplate_top);
		this.shoulderplate_left.addChild(this.armcloth_left);
		this.skull.addChild(this.helmet);
		this.spine_legplate_top.addChild(this.spine_legplate_bottom);
		this.upper_jaw.addChild(this.lower_jaw);
		this.spine.addChild(this.rib_5th_back_left);
		this.chestplate_top.addChild(this.shoulderplate_right);
		this.leg_left_bottom.addChild(this.leg_armor_left);
		this.shoulderplate_right.addChild(this.armcloth_right);
		this.skirt_front_center.addChild(this.skirt_back);
		this.chestplate_top.addChild(this.chestplate_bottom);
		this.rib_4th_side_left.addChild(this.rib_4th_front_left);
		this.spine.addChild(this.rib_top_back_right);
		this.spine.addChild(this.rib_5th_back_right);
		this.spine_legplate_bottom.addChild(this.spine_legplate_left);
		this.spine.addChild(this.spine_legplate_top);
		this.skirt_front_center.addChild(this.skirt_front_right);
		this.rib_3rd_side_right.addChild(this.rib_3rd_front_right);
		this.rib_2nd_side_left.addChild(this.rib_2nd_front_left);
		this.spine_legplate_bottom.addChild(this.spine_legplate_right);
		this.leg_right.addChild(this.leg_right_bottom);
		this.rib_3rd_back_right.addChild(this.rib_3rd_side_right);
		this.spine.addChild(this.rib_top_back_left);
		this.rib_top_side_right.addChild(this.rib_top_front_right);
		this.rib_2nd_back_right.addChild(this.rib_2nd_side_right);
		this.rib_5th_side_right.addChild(this.rib_5th_front_right);
		this.helmet.addChild(this.brushholder);
		this.skirt_front_center.addChild(this.skirt_side_right);
		this.rib_5th_back_right.addChild(this.rib_5th_side_right);
		this.rib_top_back_right.addChild(this.rib_top_side_right);
		this.chestplate_top.addChild(this.chestplate_side_right_1);
		this.chestplate_top.addChild(this.chestplate_leatherband);
		this.skirt_front_center.addChild(this.skirt_front_halfleft_1);
		this.spine.addChild(this.rib_4th_back_right);
		this.rib_5th_back_left.addChild(this.rib_5th_side_left);
		this.leg_right_bottom.addChild(this.leg_armor_right);
		this.spine.addChild(this.rib_2nd_back_right);
		this.brushholder.addChild(this.brush);
		this.rib_top_side_left.addChild(this.rib_top_front_left);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.skirt_front_center.render(f5);

		GlStateManager.pushMatrix();

		GlStateManager.translate(this.arm_right.rotationPointX/16.0D, this.arm_right.rotationPointY/16.0D, this.arm_right.rotationPointZ/16.0D);
		GlStateManager.rotate(this.arm_right.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(this.arm_right.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(this.arm_right.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
		GlStateManager.translate(this.arm_right.offsetX/16.0D, this.arm_right.offsetY/16.0D, this.arm_right.offsetZ/16.0D);

		GlStateManager.translate(this.arm_right_lower.rotationPointX/16.0D, this.arm_right_lower.rotationPointY/16.0D, this.arm_right_lower.rotationPointZ/16.0D);
		GlStateManager.rotate(this.arm_right_lower.rotateAngleX * (180F / (float)Math.PI), 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(this.arm_right_lower.rotateAngleY * (180F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(this.arm_right_lower.rotateAngleZ * (180F / (float)Math.PI), 0.0F, 0.0F, 1.0F);
		GlStateManager.translate(this.arm_right_lower.offsetX/16.0D, this.arm_right_lower.offsetY/16.0D, this.arm_right_lower.offsetZ/16.0D);

		GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
		GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.translate(0.05F, 0.02F, -0.4F);

		Minecraft.getMinecraft().getItemRenderer().renderItem((EntityLivingBase) entity, new ItemStack(Resources.orichalcum.sword), TransformType.THIRD_PERSON_RIGHT_HAND);
		GlStateManager.popMatrix();
	}
}
