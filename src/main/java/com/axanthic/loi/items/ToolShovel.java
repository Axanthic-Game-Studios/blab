package com.axanthic.loi.items;

import com.axanthic.loi.LandsOfIcaria;
import com.axanthic.loi.ModInformation;
import com.axanthic.loi.Resources.CompleteToolMaterial;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

public class ToolShovel extends ItemSpade {

	public CompleteToolMaterial material;

	public ToolShovel(CompleteToolMaterial material) {
		super(material.material);
		this.material = material;
		this.setCreativeTab(LandsOfIcaria.modTabItems);
		this.setUnlocalizedName("generic.shovel");
		this.setRegistryName(ModInformation.ID, "shovel_" + material.material.name().substring(ModInformation.ID.length() + 1));
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (I18n.canTranslate("item.shovel_" + toolMaterial.name().substring(ModInformation.ID.length() + 1) + ".name"))
			return I18n.translateToLocal("item.shovel_" + toolMaterial.name().substring(ModInformation.ID.length() + 1) + ".name");
		try {
			return String.format(I18n.translateToLocal(this.getUnlocalizedName() + ".name"), I18n.translateToLocal("material." + toolMaterial.name().substring(ModInformation.ID.length() + 1) + ".name"));
		} catch (Exception e) {
			return I18n.translateToLocal(this.getUnlocalizedName() + ".name");
		}
	}

	@Override
	public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot equipmentSlot) {
		Multimap<String, AttributeModifier> multimap = HashMultimap.<String, AttributeModifier>create();

		if (equipmentSlot == EntityEquipmentSlot.MAINHAND) {
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)this.material.material.getAttackDamage() + 1.0D, 0));
			multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", (double)this.material.attackSpeed - 1.9D, 0));
		}
		return multimap;
	}
}
