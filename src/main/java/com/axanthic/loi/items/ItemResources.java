package com.axanthic.loi.items;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;

public class ItemResources extends ItemMeta {
	public ItemResources() {
		super("resource", new String[ResourceType.length]);
		for (ResourceType type : ResourceType.values) {
			this.names[type.toMeta()] = type.name;
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack item) {
		ResourceType type = ResourceType.byMeta(item.getMetadata());
		if (type.isMaterial) {
			return "material." + type.name;
		}
		
		return super.getUnlocalizedName(item);
	}

	@Override
	public int getItemBurnTime(ItemStack stack) {
		return ResourceType.byMeta(stack.getMetadata()).burnTime;
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer player, EntityLivingBase target, EnumHand hand)
	{
		if (target instanceof EntitySheep)
		{
			EntitySheep entitysheep = (EntitySheep)target;

			EnumDyeColor black = EnumDyeColor.byDyeDamage(0);
			EnumDyeColor blue = EnumDyeColor.byDyeDamage(4);
			EnumDyeColor brown = EnumDyeColor.byDyeDamage(3);
			EnumDyeColor white = EnumDyeColor.byDyeDamage(15);

			if(stack.getMetadata() == ResourceType.BLACK_DYE.toMeta() && entitysheep.getFleeceColor() != black && !entitysheep.getSheared())
			{
				entitysheep.setFleeceColor(black);
				stack.shrink(1);
			}

			else if(stack.getMetadata() == ResourceType.BLUE_DYE.toMeta() && entitysheep.getFleeceColor() != blue && !entitysheep.getSheared())
			{
				entitysheep.setFleeceColor(blue);
				stack.shrink(1);
			}

			else if(stack.getMetadata() == ResourceType.BROWN_DYE.toMeta() && entitysheep.getFleeceColor() != brown && !entitysheep.getSheared())
			{
				entitysheep.setFleeceColor(brown);
				stack.shrink(1);
			}

			else if(stack.getMetadata() == ResourceType.WHITE_DYE.toMeta() && entitysheep.getFleeceColor() != white && !entitysheep.getSheared())
			{
				entitysheep.setFleeceColor(white);
				stack.shrink(1);
			}

			return true;
		}

		else
		{
			return false;
		}
	}
	
	public enum ResourceType {
		LIGNITE("lignite", true, 800),
		DOLOMITE("dolomite", true),
		ANTHRACITE("anthracite", true, 3200),
		ABYSSAL_ESSENCE("abyssal_essence", true),
		HALITE("halite", true),
		CALCITE("calcite", true),
		JASPER("jasper", true),
		ZIRCON("zircon", true),
		CALCITE_POWDER("calcite_powder"),
		LOAM_LUMP("loam_lump"),
		LOAM_BRICK("loam_brick"),
		ROTTEN_BONES("rotten_bones", true),
		REMAINS("remains"),
		AETERNAE_FUR("aeternae_fur"),
		AETERNAE_LEATHER("aeternae_leather", true),
		BLACK_DYE("black_dye"),
		BROWN_DYE("brown_dye"),
		BLUE_DYE("blue_dye"),
		WHITE_DYE("white_dye"),
		VINEREEDS("vinereeds"),
		SPELT("spelt"),
		FLOUR("flour"),
		ARACHNE_STRING("arachne_string"),
		PLANT_FIBER("plant_fiber"),
		JELLYFISH_JELLY("jellyfish_jelly"),
		HALITE_POWDER("halite_powder");
		
		public static final ResourceType[] values = ResourceType.values();
		public static final int length = values.length;
		private static final Map<String, ResourceType> NAME_LOOKUP = new HashMap<String, ResourceType>(length);
		
		public final String name;
		public final boolean isMaterial;
		public final int burnTime;
		
		ResourceType(String name) {
			this.name = name;
			this.isMaterial = false;
			this.burnTime = -1;
		}
		
		ResourceType(String name, boolean isMaterial) {
			this.name = name;
			this.isMaterial = isMaterial;
			this.burnTime = -1;
		}
		
		ResourceType(String name, int burnTime) {
			this.name = name;
			this.isMaterial = false;
			this.burnTime = burnTime;
		}
		
		ResourceType(String name, boolean isMaterial, int burnTime) {
			this.name = name;
			this.isMaterial = isMaterial;
			this.burnTime = burnTime;
		}
		
		public static ResourceType byMeta(int meta) {
			return values[meta];
		}
		
		public static ResourceType byName(String name) {
			return NAME_LOOKUP.get(name);
		}
		
		public int toMeta() {
			return ordinal();
		}
		
		static {
			for (ResourceType type : values) {
				NAME_LOOKUP.put(type.name, type);
			}
		}
	}
}
