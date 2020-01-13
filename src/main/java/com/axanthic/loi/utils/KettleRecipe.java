package com.axanthic.loi.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import com.axanthic.loi.ModInformation;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class KettleRecipe extends IForgeRegistryEntry.Impl<KettleRecipe> {

	public NonNullList<Ingredient> recipeInputs;
	public ItemStack recipeOutput;
	public int color;
	public ArrayList<Integer> order = new ArrayList<Integer>();

	public KettleRecipe(ResourceLocation name, ItemStack output, int color, Ingredient... inputs) {
		this.setRegistryName(name);
		this.recipeOutput = output;
		this.color = color;
		this.recipeInputs = NonNullList.from(Ingredient.EMPTY, inputs);
		for (int i = 0; i < recipeInputs.size(); ++i) {
			this.order.add(i);
		}
	}

	public void generateOrder(long seed) {
		order = new ArrayList<Integer>();
		for (int i = 0; i < recipeInputs.size(); ++i) {
			this.order.add(i);
		}

		Random rand = new Random(seed - this.getRegistryName().getResourcePath().hashCode());
		Collections.shuffle(order, rand);

		/*System.out.println("Recipe order for: " + this.getRegistryName().getResourcePath());
		for (int i = 0; i < order.size(); ++i) {
			System.out.println(recipeInputs.get(order.get(i)).getMatchingStacks()[0].getDisplayName());
		}*/
	}

	public KettleRecipe(String name, ItemStack output, int color, Ingredient... inputs) {
		this(new ResourceLocation(ModInformation.ID, name), output, color, inputs);
	}

	public ItemStack getOutput(ItemStack... input) {
		return this.recipeOutput;
	}

	public int getColor() {
		return this.color;
	}

	public NonNullList<Ingredient> getInputs() {
		return this.recipeInputs;
	}

	public boolean matches(ItemStack... ingredients) {
		boolean flag = true;
		for (int i = 0; i < ingredients.length; ++i) {
			if (i >= order.size())
				break;
			flag = flag && recipeInputs.get(order.get(i)).apply(ingredients[i]);
		}

		if (flag)
			return true;

		if (order.size() < 5) {
			flag = true;
			for (int i = 0; i < ingredients.length - 1; ++i) {
				if (i >= order.size())
					break;
				flag = flag && recipeInputs.get(order.get(i)).apply(ingredients[i + 1]);
			}
		}

		if (flag)
			return true;

		if (order.size() < 4) {
			flag = true;
			for (int i = 0; i < ingredients.length - 2; ++i) {
				if (i >= order.size())
					break;
				flag = flag && recipeInputs.get(order.get(i)).apply(ingredients[i + 2]);
			}
		}

		if (flag)
			return true;

		if (order.size() < 3) {
			flag = true;
			for (int i = 0; i < ingredients.length - 3; ++i) {
				if (i >= order.size())
					break;
				flag = flag && recipeInputs.get(order.get(i)).apply(ingredients[i + 3]);
			}
		}

		return flag;
	}
}