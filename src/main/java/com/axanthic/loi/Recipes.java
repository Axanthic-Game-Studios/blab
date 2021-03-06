package com.axanthic.loi;

import javax.annotation.Nonnull;

import com.axanthic.loi.Resources.ArmorSet;
import com.axanthic.loi.Resources.SpellSet;
import com.axanthic.loi.Resources.StairSlabPair;
import com.axanthic.loi.Resources.ToolSet;
import com.axanthic.loi.Resources.WoodSet;
import com.axanthic.loi.blocks.BlockFlower;
import com.axanthic.loi.blocks.BlockFlower2;
import com.axanthic.loi.blocks.BlockOre;
import com.axanthic.loi.blocks.BlockPlanks;
import com.axanthic.loi.blocks.BlockRock;
import com.axanthic.loi.blocks.BlockStorageGem;
import com.axanthic.loi.blocks.BlockStorageMetal;
import com.axanthic.loi.entity.EntityArachneDrone;
import com.axanthic.loi.entity.EntityRevenantCaptain;
import com.axanthic.loi.entity.EntityRevenantPyromancer;
import com.axanthic.loi.entity.EntityScorpion;
import com.axanthic.loi.items.ItemFoods;
import com.axanthic.loi.items.ItemResources;
import com.axanthic.loi.items.ItemStews;
import com.axanthic.loi.items.ItemStorageVaseDyeable;
import com.axanthic.loi.proxy.CommonProxy;
import com.axanthic.loi.utils.ForgeRecipe;
import com.axanthic.loi.utils.GrinderFuel;
import com.axanthic.loi.utils.GrinderRecipe;
import com.axanthic.loi.utils.KettleRecipe;
import com.axanthic.loi.utils.KettleRecipeExplosion;
import com.axanthic.loi.utils.KettleRecipeSpawnMob;
import com.axanthic.loi.utils.RecipeSalt;

import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class Recipes {

	public static void registerRecipes() {
		addForgeRecipe("orichalcum", new ItemStack(Resources.ingot, 1, 3), 0.3F, new OreIngredient("ingotKassiteros"), new OreIngredient("ingotChalkos"), new OreIngredient("ingotChalkos"));
		addForgeRecipe("vanadiumsteel", new ItemStack(Resources.ingot, 1, 6), 0.5F, new OreIngredient("ingotKassiteros"), new OreIngredient("ingotVanadium"), new OreIngredient("gemLignite"));
		addForgeRecipe("molybdenumsteel", new ItemStack(Resources.ingot, 1, 9), 0.6F, new OreIngredient("ingotSideros"), new OreIngredient("ingotMolybdenum"), new OreIngredient("gemAnthracite"));

		addGrinderRecipe("calcite_powder", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE_POWDER.toMeta()), 0.1F, new OreIngredient("gemCalcite"));
		addGrinderRecipe("rock_salt", new ItemStack(Resources.resource, 4, ItemResources.ResourceType.HALITE_POWDER.toMeta()), 0.1F, new OreIngredient("gemHalite"));
		addGrinderRecipe("spelt_flour", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.FLOUR.toMeta()), 0.1F, new OreIngredient("cropSpelt"));
		addGrinderRecipe("grainel_stone", new ItemStack(Resources.grainelStone), 0.1F, Ingredient.fromStacks(new ItemStack(Resources.grainelStone, 1, 1), new ItemStack(Resources.grainelStone, 1, 2)));
		addGrinderRecipe("grainel", new ItemStack(Resources.grainelSand), 0.1F, new ItemStack(Resources.grainelStone));
		addGrinderRecipe("grainel_glass", new ItemStack(Resources.grainelSand), 0.1F, new ItemStack(Resources.grainelGlass));
		addGrinderRecipe("silkstone_sand", new ItemStack(Resources.silkstoneSand), 0.1F, new ItemStack(Resources.rock, 1, 1));
		addGrinderRecipe("silkstone_glass", new ItemStack(Resources.silkstoneSand), 0.1F, new ItemStack(Resources.silkstoneGlass));
		addGrinderRecipe("relicstone", new ItemStack(Resources.rock, 1, 5), 0.1F, new ItemStack(Resources.relicstone));
		addGrinderRecipe("cracked_relicstone_bricks", new ItemStack(Resources.relicstone, 1, 1), 0.1F, new ItemStack(Resources.brick, 1, 5));
		addGrinderRecipe("cracked_relicstone_tiles", new ItemStack(Resources.relicstone, 1, 5), 0.1F, new ItemStack(Resources.relicstone, 1, 4));
		addGrinderRecipe("cobblestone", new ItemStack(Blocks.COBBLESTONE), 0.1F, new ItemStack(Blocks.STONE));
		addGrinderRecipe("gravel", new ItemStack(Blocks.GRAVEL), 0.1F, new ItemStack(Blocks.COBBLESTONE));
		addGrinderRecipe("gravel_sand", new ItemStack(Blocks.SAND), 0.1F, new ItemStack(Blocks.GRAVEL));
		addGrinderRecipe("glass_sand", new ItemStack(Blocks.SAND), 0.1F, Ingredient.fromStacks(new ItemStack(Blocks.GLASS), new ItemStack(Blocks.STAINED_GLASS, 1, OreDictionary.WILDCARD_VALUE)));
		addGrinderRecipe("sandstone_sand", new ItemStack(Blocks.SAND, 4, 0), 0.1F, new ItemStack(Blocks.SANDSTONE, 1, OreDictionary.WILDCARD_VALUE));
		addGrinderRecipe("sandstone_sand_red", new ItemStack(Blocks.SAND, 4, 1), 0.1F, new ItemStack(Blocks.RED_SANDSTONE, 1, OreDictionary.WILDCARD_VALUE));
		addGrinderRecipe("cracked_bricks", new ItemStack(Blocks.STONEBRICK, 1, 2), 0.1F, new ItemStack(Blocks.STONEBRICK));
		addGrinderRecipe("dirt", new ItemStack(Blocks.DIRT), 0.1F, new ItemStack(Blocks.DIRT, 1, 1));
		addGrinderRecipe("snow", new ItemStack(Blocks.SNOW), 0.1F, new ItemStack(Blocks.ICE));
		addGrinderRecipe("string", new ItemStack(Items.STRING, 4, 0), 0.1F, new OreIngredient("wool"));
		addGrinderRecipe("bonemeal", new ItemStack(Items.DYE, 5, 15), 0.1F, new OreIngredient("bone"));
		addGrinderRecipe("blaze_powder", new ItemStack(Items.BLAZE_POWDER, 4, 0), 0.2F, new ItemStack(Items.BLAZE_ROD));
		for (int i = 0; i < 16; ++i)
			addGrinderRecipe("concrete_" + i, new ItemStack(Blocks.CONCRETE_POWDER, 1, i), 0.1F, new ItemStack(Blocks.CONCRETE, 1, i));

		addGrinderFuel("sliver_nugget", new ItemStack(Resources.nugget, 1, 4), 800);
		addGrinderFuel("sliver_ingot", new ItemStack(Resources.ingot, 1, 4), 7200);
		addGrinderFuel("sliver_block", new ItemStack(Resources.metalBlock, 1, 4), 64800);

		addKettleRecipe(Resources.healSpell, 200, new ItemStack(Resources.herb, 1, 1), new ItemStack(Resources.herb, 1, 2), new ItemStack(Resources.food, 1, ItemFoods.FoodType.LAUREL_CHERRY.toMeta()));
		addKettleRecipe(Resources.fortifySpell, 200, new ItemStack(Resources.herb, 1, 3), new ItemStack(Resources.herb, 1, 4), new ItemStack(Resources.food, 1, ItemFoods.FoodType.LAUREL_CHERRY.toMeta()));
		addKettleRecipe(Resources.antiGravitySpell, 200, new ItemStack(Resources.ingot, 1, 2), new ItemStack(Resources.herb, 1, 5), new ItemStack(Resources.herb, 1, 1), new ItemStack(Resources.food, 1, ItemFoods.FoodType.LAUREL_CHERRY.toMeta()));
		addKettleRecipe(Resources.freezingSpell, 200, new ItemStack(Resources.herb, 1, 7), new ItemStack(Resources.herb, 1, 7), new ItemStack(Resources.resource, 1, ItemResources.ResourceType.REMAINS.toMeta()));
		addKettleRecipe(Resources.magicMissileSpell, 200, new ItemStack(Resources.ingot, 1, 2), new ItemStack(Resources.herb, 1, 5), new ItemStack(Resources.herb, 1, 4), new ItemStack(Resources.resource, 1, ItemResources.ResourceType.REMAINS.toMeta()), new ItemStack(Resources.resource, 1, ItemResources.ResourceType.REMAINS.toMeta()));
		addKettleRecipe(Resources.bubbleSpell, 200, new ItemStack(Resources.herb, 1, 1), new ItemStack(Resources.herb, 1, 3), new ItemStack(Resources.herb, 1, 6), new ItemStack(Resources.herb, 1, 8));
		CommonProxy.kettleRecipeRegistry.register(new KettleRecipeSpawnMob(new ResourceLocation(ModInformation.ID, "recipe_pyro"), EntityRevenantPyromancer.class, 0x7DB544, 1000, Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 4)), Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.REMAINS.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.REMAINS.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 7))));
		CommonProxy.kettleRecipeRegistry.register(new KettleRecipeSpawnMob(new ResourceLocation(ModInformation.ID, "recipe_scorpion"), EntityScorpion.class, 0xC18743, 1000, Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 6)), Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 8)), Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 5))));
		CommonProxy.kettleRecipeRegistry.register(new KettleRecipeSpawnMob(new ResourceLocation(ModInformation.ID, "recipe_drone"), EntityArachneDrone.class, 0x56422A, 1000, Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 2)), Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 2))));
		CommonProxy.kettleRecipeRegistry.register(new KettleRecipeSpawnMob(new ResourceLocation(ModInformation.ID, "recipe_captain"), EntityRevenantCaptain.class, 0xFFDC39, 1000, Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.REMAINS.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.REMAINS.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.REMAINS.toMeta()))));
		CommonProxy.kettleRecipeRegistry.register(new KettleRecipeSpawnMob(new ResourceLocation(ModInformation.ID, "recipe_blaze"), EntityBlaze.class, 0xF7AC37, 1000, Ingredient.fromStacks(new ItemStack(Resources.food, 1, ItemFoods.FoodType.LAUREL_CHERRY.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.ingot, 1, 2))));
		//CommonProxy.kettleRecipeRegistry.register(new KettleRecipeSpawnMob(new ResourceLocation(ModInformation.ID, "recipe_siren"), EntitySiren.class, 0xFFFFFF, 1000, Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 3)), Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 1)), Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 1))));
		CommonProxy.kettleRecipeRegistry.register(new KettleRecipeExplosion(new ResourceLocation(ModInformation.ID, "recipe_explosion"), 0xEE6D11, Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 3)), Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 1)), Ingredient.fromStacks(new ItemStack(Resources.herb, 1, 1))));

		//torches
		addRecipe(new ItemStack(Resources.torchAnthracite, 2), "torch_anthracite", new Object[]{"C", "B", 'C', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ANTHRACITE.toMeta()), 'B', Items.BONE});
		addRecipe(new ItemStack(Resources.torchLignite, 2), "torch_lignite", new Object[]{"C", "B", 'C', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LIGNITE.toMeta()), 'B', Items.BONE});

		//signs
		addRecipe(new ItemStack(Resources.signPlane, 3), "sign_plane", new Object[]{"PPP", "PPP", " S ", 'P', new ItemStack(Resources.planks, 1, BlockPlanks.WoodTypes.PLANE.meta), 'S', Items.STICK});
		addRecipe(new ItemStack(Resources.signPopulus, 3), "sign_populus", new Object[]{"PPP", "PPP", " S ", 'P', new ItemStack(Resources.planks, 1, BlockPlanks.WoodTypes.POPULUS.meta), 'S', Items.STICK});
		addRecipe(new ItemStack(Resources.signCypress, 3), "sign_cypress", new Object[]{"PPP", "PPP", " S ", 'P', new ItemStack(Resources.planks, 1, BlockPlanks.WoodTypes.CYPRESS.meta), 'S', Items.STICK});
		addRecipe(new ItemStack(Resources.signFir, 3), "sign_fir", new Object[]{"PPP", "PPP", " S ", 'P', new ItemStack(Resources.planks, 1, BlockPlanks.WoodTypes.FIR.meta), 'S', Items.STICK});
		addRecipe(new ItemStack(Resources.signOlive, 3), "sign_populus", new Object[]{"PPP", "PPP", " S ", 'P', new ItemStack(Resources.planks, 1, BlockPlanks.WoodTypes.OLIVE.meta), 'S', Items.STICK});
		addRecipe(new ItemStack(Resources.signLaurel, 3), "sign_laurel", new Object[]{"PPP", "PPP", " S ", 'P', new ItemStack(Resources.planks, 1, BlockPlanks.WoodTypes.LAUREL.meta), 'S', Items.STICK});
		addRecipe(new ItemStack(Resources.signDroughtroot, 3), "sign_droughtroot", new Object[]{"PPP", "PPP", " S ", 'P', new ItemStack(Resources.planks, 1, BlockPlanks.WoodTypes.DROUGHTROOT.meta), 'S', Items.STICK});

		addRecipe(new ItemStack(Resources.laurelWreath), "laurel_wreath", new Object[]{"LLL", "L L", 'L', Resources.laurel.leaf});

		addRecipe(new ItemStack(Resources.emptyFlask, 3), "empty_flask", new Object[]{"G G", " G ", 'G', Resources.silkstoneGlass});

		addRecipe(new ItemStack(Resources.grenade, 1), "grenade", new Object[]{" S ", "NPN", " N ", 'S', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ARACHNE_STRING.toMeta()), 'P', "dustCalcite", 'N', "nuggetKassiteros"});

		addRecipe(new ItemStack(Resources.aristonePacked), "packed_aristone", new Object[]{"AAA", "AAA", "AAA", 'A', Resources.aristone});

		addRecipe(new ItemStack(Resources.soil, 1, 1), "course_marl", new Object[]{"GS", "SG", 'G', Resources.grainelSand, 'S', new ItemStack(Resources.soil, 1, 0)});

		addRecipe(new ItemStack(Resources.soil, 1, 2), "loam_block", new Object[]{"LL", "LL", 'L', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LOAM_LUMP.toMeta())});
		addRecipe(new ItemStack(Resources.resource, 4, ItemResources.ResourceType.LOAM_LUMP.toMeta()), "loam_lump", new Object[]{"L", 'L', new ItemStack(Resources.soil, 1, 2)});

		//vases
		addRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta()), "unfired_vase", new Object[]{"LLL", "L L", "LLL", 'L', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LOAM_LUMP.toMeta())});

		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.WHITE.toMeta()), "unfired_vase_dyed_white", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeWhite")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.ORANGE.toMeta()), "unfired_vase_dyed_orange", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeOrange")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.MAGENTA.toMeta()), "unfired_vase_dyed_magenta", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeMagenta")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.AZURE.toMeta()), "unfired_vase_dyed_azure", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeLightBlue")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.YELLOW.toMeta()), "unfired_vase_dyed_yellow", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeYellow")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.LIME.toMeta()), "unfired_vase_dyed_lime", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeLime")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.PINK.toMeta()), "unfired_vase_dyed_pink", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyePink")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.GRAY.toMeta()), "unfired_vase_dyed_gray", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeGray")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.PALE.toMeta()), "unfired_vase_dyed_pale", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeLightGray")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.CYAN.toMeta()), "unfired_vase_dyed_cyan", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeCyan")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.PURPLE.toMeta()), "unfired_vase_dyed_purple", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyePurple")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.BLUE.toMeta()), "unfired_vase_dyed_blue", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeBlue")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.BROWN.toMeta()), "unfired_vase_dyed_brown", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeBrown")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.GREEN.toMeta()), "unfired_vase_dyed_green", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeGreen")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.RED.toMeta()), "unfired_vase_dyed_red", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeRed")});
		addShapelessRecipe(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.BLACK.toMeta()), "unfired_vase_dyed_black", "unfired_vase", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta())), new OreIngredient("dyeBlack")});
		addShapelessRecipe(new ItemStack(Resources.vineSproutBlock, 1), "vinesprout_block", new Ingredient[] {Ingredient.fromStacks(new ItemStack(Resources.vineSprout, 1)), Ingredient.fromStacks(new ItemStack(Resources.vineSprout, 1)), Ingredient.fromStacks(new ItemStack(Resources.vineSprout, 1)), Ingredient.fromStacks(new ItemStack(Resources.vineSprout, 1))});
		addShapelessRecipe(new ItemStack(Resources.vineSprout, 4), "vinesprout", new Ingredient[] {Ingredient.fromStacks(new ItemStack(Resources.vineSproutBlock, 1))});
		
		//vases
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.NONE.toMeta()), new ItemStack(Resources.storageVase, 1, 0), 0.2F);

		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.WHITE.toMeta()), new ItemStack(Resources.storageVaseDyedWhite, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.ORANGE.toMeta()), new ItemStack(Resources.storageVaseDyedOrange, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.MAGENTA.toMeta()), new ItemStack(Resources.storageVaseDyedMagenta, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.AZURE.toMeta()), new ItemStack(Resources.storageVaseDyedAzure, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.YELLOW.toMeta()), new ItemStack(Resources.storageVaseDyedYellow, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.LIME.toMeta()), new ItemStack(Resources.storageVaseDyedLime, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.PINK.toMeta()), new ItemStack(Resources.storageVaseDyedPink, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.GRAY.toMeta()), new ItemStack(Resources.storageVaseDyedGray, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.PALE.toMeta()), new ItemStack(Resources.storageVaseDyedPale, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.CYAN.toMeta()), new ItemStack(Resources.storageVaseDyedCyan, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.PURPLE.toMeta()), new ItemStack(Resources.storageVaseDyedPurple, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.BLUE.toMeta()), new ItemStack(Resources.storageVaseDyedBlue, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.BROWN.toMeta()), new ItemStack(Resources.storageVaseDyedBrown, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.GREEN.toMeta()), new ItemStack(Resources.storageVaseDyedGreen, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.RED.toMeta()), new ItemStack(Resources.storageVaseDyedRed, 1, 0), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.unfiredVase, 1, ItemStorageVaseDyeable.VaseType.BLACK.toMeta()), new ItemStack(Resources.storageVaseDyedBlack, 1, 0), 0.2F);

		GameRegistry.addSmelting(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LOAM_LUMP.toMeta()), new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LOAM_BRICK.toMeta()), 0.1F);
		addRecipe(new ItemStack(Resources.loamBricks, 1, 0), "loam_bricks", new Object[]{"BB", "BB", 'B', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LOAM_BRICK.toMeta())});
		addRecipe(new ItemStack(Resources.dolomiteSmooth, 1, 0), "dolomite_smooth", new Object[]{"DD", "DD", 'D', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.DOLOMITE.toMeta())});
		addRecipe(new ItemStack(Resources.dolomiteBricks, 4, 0), "dolomite_bricks", new Object[]{"DD", "DD", 'D', new ItemStack(Resources.dolomiteSmooth, 1, 0)});
		addRecipe(new ItemStack(Resources.dolomitePillar, 2, 0), "dolomite_pillar", new Object[]{"B", "B", 'B', new ItemStack(Resources.dolomiteBricks, 1, 0)});
		addRecipe(new ItemStack(Resources.dolomitePillarHead, 2, 0), "dolomite_pillar_head", new Object[]{"B", "P", 'B', new ItemStack(Resources.dolomiteBricks, 1, 0), 'P', new ItemStack(Resources.dolomitePillar, 1, 0)});
		addRecipe(new ItemStack(Resources.quartzPillarHead, 2, 0), "quartz_pillar_head", new Object[]{"B", "P", 'B', new ItemStack(Blocks.QUARTZ_BLOCK, 1, 1), 'P', new ItemStack(Blocks.QUARTZ_BLOCK, 1, 2)});

		addShapelessRecipe(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.AETERNAE_LEATHER.toMeta()), "aeternae_leather", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.AETERNAE_FUR.toMeta()))});
		GameRegistry.addSmelting(new ItemStack(Resources.food, 1, ItemFoods.FoodType.AETERNAE_MEAT.toMeta()), new ItemStack(Resources.food, 1, ItemFoods.FoodType.AETERNAE_MEAT_COOKED.toMeta()), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Resources.food, 1, ItemFoods.FoodType.SOW_MEAT.toMeta()), new ItemStack(Resources.food, 1, ItemFoods.FoodType.SOW_MEAT_COOKED.toMeta()), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Resources.food, 1, ItemFoods.FoodType.CATOBLEPAS_MEAT.toMeta()), new ItemStack(Resources.food, 1, ItemFoods.FoodType.CATOBLEPAS_MEAT_COOKED.toMeta()), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Resources.food, 1, ItemFoods.FoodType.CERVER_MEAT.toMeta()), new ItemStack(Resources.food, 1, ItemFoods.FoodType.CERVER_MEAT_COOKED.toMeta()), 0.35F);
		GameRegistry.addSmelting(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.FLOUR.toMeta()), new ItemStack(Resources.food, 1, ItemFoods.FoodType.SPELT_BREAD.toMeta()), 0.35F);
		addRecipe(new ItemStack(Resources.food, 1, ItemFoods.FoodType.SPELT_BREAD.toMeta()), "spelt_bread", new Object[]{"SSS", 'S', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.SPELT.toMeta())});
		addRecipe(new ItemStack(Resources.strawberryCake), "strawberry_cake", new Object[]{"SMS", "UJU", "FFF", 'S', new ItemStack(Resources.food, 1, ItemFoods.FoodType.STRAWBERRY.toMeta()), 'M', new ItemStack(Items.MILK_BUCKET), 'U', new ItemStack(Items.SUGAR), 'J', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.JELLYFISH_JELLY.toMeta()), 'F', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.FLOUR.toMeta())});
		addShapelessRecipe(new ItemStack(Resources.stew, 1, ItemStews.StewType.FRUIT_SALAD.toMeta()), "fruit_salad", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.food, 1, ItemFoods.FoodType.STRAWBERRY.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.food, 1, ItemFoods.FoodType.PHYSALIS.toMeta())), Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 3)), Ingredient.fromStacks(new ItemStack(Items.MELON)), Ingredient.fromStacks(new ItemStack(Items.GOLDEN_APPLE)), Ingredient.fromStacks(new ItemStack(Resources.food, 1, ItemFoods.FoodType.LAUREL_CHERRY.toMeta())), Ingredient.fromStacks(new ItemStack(Items.BOWL))});
		addShapelessRecipe(new ItemStack(Resources.stew, 1, ItemStews.StewType.AETERNAE.toMeta()), "aeternae_stew", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.food, 1, ItemFoods.FoodType.AETERNAE_MEAT_COOKED.toMeta())), Ingredient.fromStacks(new ItemStack(Items.BEETROOT)), new OreIngredient("dustSalt"), Ingredient.fromStacks(new ItemStack(Items.BOWL))});
		addShapelessRecipe(new ItemStack(Resources.stew, 1, ItemStews.StewType.CERVER.toMeta()), "cerver_stew", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.food, 1, ItemFoods.FoodType.CERVER_MEAT_COOKED.toMeta())), Ingredient.fromStacks(new ItemStack(Items.CARROT)), new OreIngredient("dustSalt"), Ingredient.fromStacks(new ItemStack(Items.BOWL))});
		addShapelessRecipe(new ItemStack(Resources.stew, 1, ItemStews.StewType.SOW.toMeta()), "sow_stew", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.food, 1, ItemFoods.FoodType.SOW_MEAT_COOKED.toMeta())), new OreIngredient("mushroom"), new OreIngredient("mushroom"), new OreIngredient("dustSalt"), Ingredient.fromStacks(new ItemStack(Items.BOWL))});
		addShapelessRecipe(new ItemStack(Resources.stew, 1, ItemStews.StewType.ONION.toMeta()), "onion_soup", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.onion)), Ingredient.fromStacks(new ItemStack(Resources.onion)), Ingredient.fromStacks(new ItemStack(Resources.onion)), new OreIngredient("dustSalt"), Ingredient.fromStacks(new ItemStack(Items.BOWL))});
		addShapelessRecipe(new ItemStack(Resources.stew, 1, ItemStews.StewType.CATOBLEPAS.toMeta()), "catoblepas_stew", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.food, 1, ItemFoods.FoodType.CATOBLEPAS_MEAT_COOKED.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.onion)), new OreIngredient("dustSalt"), Ingredient.fromStacks(new ItemStack(Items.BOWL))});

		RecipeSalt.initBlacklist();
		RecipeSorter.register(ModInformation.ID + ":recipe_food_salting", RecipeSalt.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
		GameRegistry.findRegistry(IRecipe.class).register(new RecipeSalt().setRegistryName(new ResourceLocation(ModInformation.ID, "recipe_food_salting")));

		addShapelessRecipe(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BLUE_DYE.toMeta()), "ground_flower_dye_blue", "ground_flower_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.blueGroundFlowers, 1, 0))});
		addShapelessRecipe(new ItemStack(Items.DYE, 1, 12), "ground_flower_dye_cyan", "ground_flower_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.cyanGroundFlowers, 1, 0))});
		addShapelessRecipe(new ItemStack(Items.DYE, 1, 9), "ground_flower_dye_pink", "ground_flower_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.pinkGroundFlowers, 1, 0))});
		addShapelessRecipe(new ItemStack(Items.DYE, 1, 5), "ground_flower_dye_purple", "ground_flower_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.purpleGroundFlowers, 1, 0))});
		addShapelessRecipe(new ItemStack(Items.DYE, 1, 1), "ground_flower_dye_red", "ground_flower_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.redGroundFlowers, 1, 0))});
		addShapelessRecipe(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.WHITE_DYE.toMeta()), "ground_flower_dye_white", "ground_flower_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.whiteGroundFlowers, 1, 0))});
		addShapelessRecipe(new ItemStack(Items.DYE, 1, 14), "bromelia_dye_orange", "bromelia_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.bromelia, 1, 0))});
		addShapelessRecipe(new ItemStack(Items.DYE, 1, 13), "bromelia_dye_pink", "bromelia_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.bromelia, 1, 1))});
		addShapelessRecipe(new ItemStack(Items.DYE, 1, 5), "bromelia_dye_purple", "bromelia_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.bromelia, 1, 2))});
		addShapelessRecipe(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.WHITE_DYE.toMeta()), "bromelia_dye_white", "bromelia_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.bromelia, 1, 3))});
		GameRegistry.addSmelting(new ItemStack(Resources.cardon, 1, 0), new ItemStack(Items.DYE, 1, 2), 0.2F);
		addShapelessRecipe(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BROWN_DYE.toMeta()), "brown_dye", "dye", new Ingredient[]{new OreIngredient("dyeRed"), new OreIngredient("dyeBlack")});

		addRecipe(new ItemStack(Resources.kiln, 1, 0), "kiln_rock", "kiln", new Object[]{"SSS", "S S", "SSS", 'S', new ItemStack(Resources.rock, 1, 0)});
		addRecipe(new ItemStack(Resources.kiln, 1, 0), "kiln_brick", "kiln", new Object[]{"BBB", "B B", "BBB", 'B', new ItemStack(Resources.brick, 1, 0)});
		addRecipe(new ItemStack(Resources.grinder, 1, 0), "grinder_rock", "grinder", new Object[]{"SSS", "SIS", "SSS", 'S', new ItemStack(Resources.rock, 1, 2), 'I', "ingotOrichalcum"});
		addRecipe(new ItemStack(Resources.grinder, 1, 0), "grinder_brick", "grinder", new Object[]{"BBB", "BIB", "BBB", 'B', new ItemStack(Resources.brick, 1, 2), 'I', "ingotOrichalcum"});
		addRecipe(new ItemStack(Resources.forge, 1, 0), "forge", new Object[]{"LGL", "L L", "LGL", 'L', new ItemStack(Resources.loamBricks, 1, 0), 'G', new ItemStack(Resources.grainelStone, 1, 1)});
		addRecipe(new ItemStack(Resources.kettle, 1, 0), "kettle", new Object[]{"O O", "V V", "OVO", 'O', "ingotOrichalcum", 'V', "blockVanadiumsteel"});

		addRecipe(new ItemStack(Resources.rock, 4, 1), "silkstone_from_sand", new Object[]{"PP", "PP", 'P', new ItemStack(Resources.silkstoneSand)});
		GameRegistry.addSmelting(new ItemStack(Resources.silkstoneSand, 1, 0), new ItemStack(Resources.silkstoneGlass), 0.1F);
		addRecipe(new ItemStack(Resources.silkstoneGlassPane, 16, 0), "silkstone_glass_pane", new Object[]{"GGG", "GGG", 'G', new ItemStack(Resources.silkstoneGlass, 1, 0)});
		addRecipe(new ItemStack(Resources.silkstoneGlassStraightPane, 4, 0), "silkstone_glass_pane_straight", new Object[]{"GG", "GG", 'G', new ItemStack(Resources.silkstoneGlassPane, 1, 0)});
		addRecipe(new ItemStack(Resources.silkstoneGlassHorizontalPane, 3, 0), "silkstone_glass_pane_horizontal", new Object[]{"GGG", 'G', new ItemStack(Resources.silkstoneGlassPane, 1, 0)});

		addRecipe(new ItemStack(Resources.grainelStone, 1, 0), "grainel_stone", new Object[]{"GG", "GG", 'G', new ItemStack(Resources.grainelSand, 1, 0)});
		addRecipe(new ItemStack(Resources.grainelStone, 4, 1), "grainel_stone_bricks", new Object[]{"GG", "GG", 'G', new ItemStack(Resources.grainelStone, 1, 0)});
		addRecipe(new ItemStack(Resources.grainelStone, 4, 2), "grainel_stone_bricks_chiseled", new Object[]{"S", "S", 'S', new ItemStack(Resources.grainiteBricks.slab, 1, 0)});
		GameRegistry.addSmelting(new ItemStack(Resources.grainelSand, 1, 0), new ItemStack(Resources.grainelGlass, 1, 0), 0.1F);
		addRecipe(new ItemStack(Resources.grainelGlassPane, 16, 0), "grainel_glass_pane", new Object[]{"GGG", "GGG", 'G', new ItemStack(Resources.grainelGlass, 1, 0)});
		addRecipe(new ItemStack(Resources.grainelGlassStraightPane, 4, 0), "grainel_glass_pane_straight", new Object[]{"GG", "GG", 'G', new ItemStack(Resources.grainelGlassPane, 1, 0)});
		addRecipe(new ItemStack(Resources.grainelGlassHorizontalPane, 3, 0), "grainel_glass_pane_horizontal", new Object[]{"GGG", 'G', new ItemStack(Resources.grainelGlassPane, 1, 0)});

		addRecipe(new ItemStack(Resources.ligniteBlock, 1), "lignite_block", new Object[] {"LLL", "LLL", "LLL", 'L', new ItemStack(Resources.resource, 1, 0)});
		addRecipe(new ItemStack(Resources.anthraciteBlock, 1), "anthracite_block", new Object[] {"LLL", "LLL", "LLL", 'L', new ItemStack(Resources.resource, 1, 2)});
		
		GameRegistry.addSmelting(new ItemStack(Resources.rock, 1, 5), new ItemStack(Resources.relicstone, 1, 0), 0.1F);
		GameRegistry.addSmelting(new ItemStack(Resources.brick, 1, 5), new ItemStack(Resources.relicstone, 1, 1), 0.1F);
		addShapelessRecipe(new ItemStack(Resources.relicstone, 1, 2), "relicstone_bricks_mossy", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.brick, 1, 5)), new OreIngredient("vine")});
		addRecipe(new ItemStack(Resources.relicstone, 4, 4), "relicstone_tiles", new Object[]{"BB", "BB", 'B', new ItemStack(Resources.brick, 1, 5)});
		GameRegistry.addSmelting(new ItemStack(Resources.relicstone, 1, 4), new ItemStack(Resources.relicstone, 1, 5), 0.1F);
		addShapelessRecipe(new ItemStack(Resources.relicstone, 1, 6), "relicstone_tiles_mossy", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.relicstone, 1, 4)), new OreIngredient("vine")});
		addRecipe(new ItemStack(Resources.relicstone, 1, 8), "relicstone_chiseled", new Object[]{"S", "S", 'S', new ItemStack(Resources.relicstoneStone.slab, 1, 0)});
		addRecipe(new ItemStack(Resources.pillar, 2, 0), "relicstone_pillar", new Object[]{"B", "B", 'B', new ItemStack(Resources.brick, 1, 5)});
		addRecipe(new ItemStack(Resources.pillarHead, 2, 0), "relicstone_pillar_head", new Object[]{"T", "P", 'P', new ItemStack(Resources.pillar, 1, 0), 'T', new ItemStack(Resources.relicstone, 1, 4)});

		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 0), new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LIGNITE.toMeta()), 0.1F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 1), new ItemStack(Resources.ingot, 1, 0), 0.3F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 2), new ItemStack(Resources.ingot, 1, 1), 0.4F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 3), new ItemStack(Resources.resource, 1, ItemResources.ResourceType.DOLOMITE.toMeta()), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 4), new ItemStack(Resources.ingot, 1, 2), 0.5F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 5), new ItemStack(Resources.ingot, 1, 5), 0.6F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 6), new ItemStack(Resources.ingot, 1, 4), 0.7F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 7), new ItemStack(Resources.ingot, 1, 7), 0.8F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 8), new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ANTHRACITE.toMeta()), 0.2F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 9), new ItemStack(Resources.ingot, 1, 8), 0.9F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 10), new ItemStack(Resources.ingot, 1, 10), 1.0F);
		GameRegistry.addSmelting(new ItemStack(Resources.ore, 1, 12), new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ABYSSAL_ESSENCE.toMeta()), 0.5F);

		addShapelessRecipe(new ItemStack(Resources.seedsStrawberry, 1), "seed_strawberry", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.food, 1, ItemFoods.FoodType.STRAWBERRY.toMeta()))});

		for (int i = 0; i < BlockFlower.FlowerTypes.getNames().length; i++) {
			addShapelessRecipe(getDye(BlockFlower.FlowerTypes.byMetadata(i).color), "flower_dye_" + i, "flower_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.flower, 1, i))});
		}

		for (int i = 0; i < BlockFlower2.FlowerTypes2.getNames().length; i++) {
			addShapelessRecipe(getDye(BlockFlower2.FlowerTypes2.byMetadata(i).color), "flower_2_dye_" + i, "flower_dye", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.flower2, 1, i))});
		}

		for (int i = 0; i < BlockRock.StoneTypes.getNames().length; i++) {
			addRecipe(new ItemStack(Resources.brick, 4, i), BlockRock.StoneTypes.getNames()[i] + "_bricks", "rock_bricks", new Object[]{"RR", "RR", 'R', new ItemStack(Resources.rock, 1, i)});
		}

		for (int i = 0; i < BlockStorageMetal.MetalTypes.getNames().length; i++) {
			String name = BlockStorageMetal.MetalTypes.getNames()[i];
			String metal = upCase(name);
			addRecipe(new ItemStack(Resources.ingot, 1, i), name + "_unnugget", name + "_ingot", new Object[]{"NNN", "NNN", "NNN", 'N', "nugget" + metal});
			addRecipe(new ItemStack(Resources.metalBlock, 1, i), name + "_block", new Object[]{"III", "III", "III", 'I', "ingot" + metal});
			addRecipe(new ItemStack(Resources.nugget, 9, i), name + "_nugget", new Object[]{"I", 'I', "ingot" + metal});
			addRecipe(new ItemStack(Resources.ingot, 9, i), name + "_unblock", name + "_ingot", new Object[]{"B", 'B', "block" + metal});
		}

		for (int i = 0; i < BlockStorageGem.GemTypes.getNames().length; i++) {
			String name = BlockStorageGem.GemTypes.getNames()[i];
			String gem = upCase(name);
			addRecipe(new ItemStack(Resources.gemBlock, 1, i), name + "_block", new Object[]{"III", "III", "III", 'I', "gem" + gem});
			addRecipe(new ItemStack(Resources.resource, 9, ItemResources.ResourceType.byName(name).toMeta()), name + "_unblock", new Object[]{"B", 'B', "block" + gem});
		}

		addRecipe(new ItemStack(Resources.plantFiberBlock, 1), "plant_fiber_block", new Object[]{"III", "III", "III", 'I', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.PLANT_FIBER.toMeta())});
		addRecipe(new ItemStack(Resources.resource, 9, ItemResources.ResourceType.PLANT_FIBER.toMeta()), "plant_fiber_unblock", new Object[]{"B", 'B', new ItemStack(Resources.plantFiberBlock)});
		addRecipe(new ItemStack(Resources.speltBale, 1), "spelt_bale_block", new Object[]{"III", "III", "III", 'I', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.SPELT.toMeta())});
		addRecipe(new ItemStack(Resources.resource, 9, ItemResources.ResourceType.SPELT.toMeta()), "spelt_bale_unblock", new Object[]{"B", 'B', new ItemStack(Resources.speltBale)});
		addRecipe(new ItemStack(Resources.arachneStringBlock, 1), "arachne_string_block", new Object[]{"III", "III", "III", 'I', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ARACHNE_STRING.toMeta())});
		addRecipe(new ItemStack(Resources.resource, 9, ItemResources.ResourceType.ARACHNE_STRING.toMeta()), "arachne_string_unblock", new Object[]{"B", 'B', new ItemStack(Resources.arachneStringBlock)});
		addRecipe(new ItemStack(Resources.jellyfishJellyBlock, 1), "jellyfish_jelly_block", new Object[]{"III", "III", "III", 'I', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.JELLYFISH_JELLY.toMeta())});
		addRecipe(new ItemStack(Resources.resource, 9, ItemResources.ResourceType.JELLYFISH_JELLY.toMeta()), "jellyfish_jelly_unblock", new Object[]{"B", 'B', new ItemStack(Resources.jellyfishJellyBlock)});
		addRecipe(new ItemStack(Resources.rottenBonesBlock, 1), "rotten_bones_block", new Object[]{"III", "III", "III", 'I', new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ROTTEN_BONES.toMeta())});
		addRecipe(new ItemStack(Resources.resource, 9, ItemResources.ResourceType.ROTTEN_BONES.toMeta()), "rotten_bones_unblock", new Object[]{"B", 'B', new ItemStack(Resources.rottenBonesBlock)});

		addShapelessRecipe(new ItemStack(Resources.planks, 2, 0), "head_planks_plane", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.mobHeadForesthagPlane, 1, 0))});
		addShapelessRecipe(new ItemStack(Resources.planks, 2, 1), "head_planks_populus", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.mobHeadForesthagPopulus, 1, 0))});
		addShapelessRecipe(new ItemStack(Resources.planks, 2, 2), "head_planks_cypress", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.mobHeadForesthagCypress, 1, 0))});
		addShapelessRecipe(new ItemStack(Resources.planks, 2, 3), "head_planks_fir", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.mobHeadForesthagFir, 1, 0))});
		addShapelessRecipe(new ItemStack(Resources.planks, 2, 4), "head_planks_olive", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.mobHeadForesthagOlive, 1, 0))});
		addShapelessRecipe(new ItemStack(Resources.planks, 2, 5), "head_planks_laurel", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.mobHeadForesthagLaurel, 1, 0))});
		addShapelessRecipe(new ItemStack(Resources.planks, 2, 6), "head_planks_droughtroot", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.mobHeadForesthagDroughtroot, 1, 0))});

		registerWoodRecipe(Resources.plane);
		registerWoodRecipe(Resources.populus);
		registerWoodRecipe(Resources.cypress);
		registerWoodRecipe(Resources.fir);
		registerWoodRecipe(Resources.olive);
		registerWoodRecipe(Resources.laurel);
		registerWoodRecipe(Resources.droughtroot);

		registerSlabStairRecipe(Resources.yellowstoneStone);
		registerSlabStairRecipe(Resources.silkstoneStone);
		registerSlabStairRecipe(Resources.sunstoneStone);
		registerSlabStairRecipe(Resources.voidshaleStone);
		registerSlabStairRecipe(Resources.baetylStone);
		registerSlabStairRecipe(Resources.relicstoneStone);
		registerSlabStairRecipe(Resources.yellowstoneBrick);
		registerSlabStairRecipe(Resources.silkstoneBrick);
		registerSlabStairRecipe(Resources.sunstoneBrick);
		registerSlabStairRecipe(Resources.voidshaleBrick);
		registerSlabStairRecipe(Resources.baetylBrick);
		registerSlabStairRecipe(Resources.relicstoneBrick);
		registerSlabStairRecipe(Resources.relicstoneSmooth);
		registerSlabStairRecipe(Resources.relicstoneCrackBrick);
		registerSlabStairRecipe(Resources.relicstoneMossBrick);
		registerSlabStairRecipe(Resources.relicstoneTile);
		registerSlabStairRecipe(Resources.relicstoneCrackTile);
		registerSlabStairRecipe(Resources.relicstoneMossTile);
		registerSlabStairRecipe(Resources.grainiteStone);
		registerSlabStairRecipe(Resources.grainiteBricks);
		registerSlabStairRecipe(Resources.loamBrick);
		registerSlabStairRecipe(Resources.smoothDolomite);

		registerToolRecipe(Resources.laurelTools);
		registerToolRecipe(Resources.chalkos);
		registerToolRecipe(Resources.kassiteros);
		registerToolRecipe(Resources.orichalcum);
		registerToolRecipe(Resources.vanadiumsteel);
		registerToolRecipe(Resources.sideros);
		registerToolRecipe(Resources.molybdenumsteel);

		registerArmorRecipe(Resources.aeternaeLeatherArmor);
		registerArmorRecipe(Resources.chalkosArmor);
		registerArmorRecipe(Resources.kassiterosArmor);
		registerArmorRecipe(Resources.orichalcumArmor);
		registerArmorRecipe(Resources.vanadiumArmor);

		//this needs to happen because they prioritize over our recipes
		moveRecipe(new ResourceLocation("crafting_table"));
		moveRecipe(new ResourceLocation("trapdoor"));
		moveRecipe(new ResourceLocation("leather_helmet"));
		moveRecipe(new ResourceLocation("leather_chestplate"));
		moveRecipe(new ResourceLocation("leather_leggings"));
		moveRecipe(new ResourceLocation("leather_boots"));
	}

	public static void registerLateRecipes() {
		NonNullList<ItemStack> copperIngots = OreDictionary.getOres("ingotCopper");
		NonNullList<ItemStack> tinIngots = OreDictionary.getOres("ingotTin");
		NonNullList<ItemStack> leadIngots = OreDictionary.getOres("ingotLead");
		NonNullList<ItemStack> bronzeIngots = OreDictionary.getOres("ingotBronze");
		NonNullList<ItemStack> silverIngots = OreDictionary.getOres("ingotSilver");
		NonNullList<ItemStack> iridiumIngots = OreDictionary.getOres("ingotIridium");
		NonNullList<ItemStack> electrumIngots = OreDictionary.getOres("ingotElectrum");
		NonNullList<ItemStack> nickelIngots = OreDictionary.getOres("ingotNickel");
		NonNullList<ItemStack> invarIngots = OreDictionary.getOres("ingotInvar");
		NonNullList<ItemStack> constantanIngots = OreDictionary.getOres("ingotConstantan");
		NonNullList<ItemStack> cobaltIngots = OreDictionary.getOres("ingotCobalt");
		NonNullList<ItemStack> arditeIngots = OreDictionary.getOres("ingotArdite");
		NonNullList<ItemStack> manyullynIngots = OreDictionary.getOres("ingotManyullyn");

		//metal conversion recipes
		if (!copperIngots.isEmpty())
			addShapelessRecipe(copperIngots.get(0), "chalkos_copper", "copper_ingot", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE_POWDER.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.ingot, 1, 0))});

		if (!tinIngots.isEmpty())
			addShapelessRecipe(tinIngots.get(0), "kassiteros_tin", "tin_ingot", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE_POWDER.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.ingot, 1, 1))});

		if (!leadIngots.isEmpty())
			addShapelessRecipe(leadIngots.get(0), "molibos_lead", "lead_ingot", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE_POWDER.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.ingot, 1, 2))});

		if (!bronzeIngots.isEmpty())
			addShapelessRecipe(bronzeIngots.get(0), "orichalcum_bronze", "bronze_ingot", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE_POWDER.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.ingot, 1, 3))});

		if (!silverIngots.isEmpty())
			addShapelessRecipe(silverIngots.get(0), "sliver_silver", "silver_ingot", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE_POWDER.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.ingot, 1, 4))});

		addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 5, 0), "sideros_iron", "iron_ingot", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE_POWDER.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.ingot, 1, 7))});

		if (!iridiumIngots.isEmpty())
			addShapelessRecipe(iridiumIngots.get(0), "bluridium_iridium", "iridium_ingot", new Ingredient[]{Ingredient.fromStacks(new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE_POWDER.toMeta())), Ingredient.fromStacks(new ItemStack(Resources.ingot, 1, 10))});

		//compatibility alloying recipes
		if (!copperIngots.isEmpty() && !tinIngots.isEmpty() && !bronzeIngots.isEmpty())
			addForgeRecipe("bronze", new ItemStack(bronzeIngots.get(0).getItem(), 3, bronzeIngots.get(0).getMetadata()), 0.2F, new OreIngredient("ingotTin"), new OreIngredient("ingotCopper"), new OreIngredient("ingotCopper"));

		if (!silverIngots.isEmpty() && !electrumIngots.isEmpty())
			addForgeRecipe("electrum", new ItemStack(electrumIngots.get(0).getItem(), 2, electrumIngots.get(0).getMetadata()), 0.3F, new OreIngredient("ingotSilver"), new OreIngredient("ingotGold"));

		if (!nickelIngots.isEmpty() && !invarIngots.isEmpty())
			addForgeRecipe("invar", new ItemStack(invarIngots.get(0).getItem(), 3, invarIngots.get(0).getMetadata()), 0.2F, new OreIngredient("ingotNickel"), new OreIngredient("ingotIron"), new OreIngredient("ingotIron"));

		if (!copperIngots.isEmpty() && !nickelIngots.isEmpty() && !constantanIngots.isEmpty())
			addForgeRecipe("constantan", new ItemStack(constantanIngots.get(0).getItem(), 2, constantanIngots.get(0).getMetadata()), 0.2F, new OreIngredient("ingotCopper"), new OreIngredient("ingotNickel"));

		if (!cobaltIngots.isEmpty() && !arditeIngots.isEmpty() && !manyullynIngots.isEmpty())
			addForgeRecipe("manyullyn", new ItemStack(manyullynIngots.get(0).getItem(), 2, manyullynIngots.get(0).getMetadata()), 0.4F, new OreIngredient("ingotCobalt"), new OreIngredient("ingotArdite"));

		//automatic grinder recipes
		for (String name : OreDictionary.getOreNames()) {
			if (name.startsWith("ingot"))
				if (OreDictionary.getOres(name.replace("ingot", "dust")).size() > 0 && OreDictionary.getOres(name).size() > 0) {
					addGrinderRecipe(name.toLowerCase() + "_dust", OreDictionary.getOres(name.replace("ingot", "dust")).get(0).copy(), 0.1F, new OreIngredient(name));
					continue;
				}
			if (name.startsWith("gem") && !(name.equals("gemCalcite") || name.equals("gemHalite")))
				if (OreDictionary.getOres(name.replace("gem", "dust")).size() > 0 && OreDictionary.getOres(name).size() > 0) {
					addGrinderRecipe(name.toLowerCase() + "_dust", OreDictionary.getOres(name.replace("gem", "dust")).get(0).copy(), 0.1F, new OreIngredient(name));
					continue;
				}
			if (name.startsWith("ore"))
				if (OreDictionary.getOres(name.replace("ore", "dust")).size() > 0 && OreDictionary.getOres(name).size() > 0) {
					ItemStack returnstack = OreDictionary.getOres(name.replace("ore", "dust")).get(0).copy();
					returnstack.setCount(2);
					addGrinderRecipe(name.toLowerCase() + "_dust", returnstack, 0.2F, new OreIngredient(name));
				}
		}
	}

	public static void registerWoodRecipe(WoodSet set) {
		int meta = set.type.meta;
		addRecipe(new ItemStack(Resources.planks, 4, meta), set.type.unlocalizedName + "_planks", "planks", new Object[]{"L", 'L', set.log});
		addRecipe(new ItemStack(Resources.planks, 4, meta), set.type.unlocalizedName + "_stripped_planks", "planks", new Object[]{"L", 'L', set.strippedLog});
		GameRegistry.addSmelting(set.log, new ItemStack(Items.COAL, 1, 1), 0.1F);
		GameRegistry.addSmelting(set.strippedLog, new ItemStack(Items.COAL, 1, 1), 0.1F);
		addRecipe(new ItemStack(set.fence, 3), set.type.unlocalizedName + "_fence", "wooden_fence", new Object[]{"PSP", "PSP", 'S', "stickWood", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.fenceGate, 3), set.type.unlocalizedName + "_fence_gate", "wooden_fence_gate", new Object[]{"SPS", "SPS", 'S', "stickWood", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.slab, 6), set.type.unlocalizedName + "_slab", "wooden_slab", new Object[]{"PPP", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.stairs, 4), set.type.unlocalizedName + "_stairs", "wooden_stairs", new Object[]{"P  ", "PP ", "PPP", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.door, 3), set.type.unlocalizedName + "_door", "wooden_door", new Object[]{"PP", "PP", "PP", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.trapdoor, 2), set.type.unlocalizedName + "_trapdoor", "wooden_trapdoor", new Object[]{"PPP", "PPP", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.ladder, 6), set.type.unlocalizedName + "_ladder", "wooden_ladder", new Object[]{"P P", "PPP", "P P", 'P', new ItemStack(Resources.planks, 1, meta)});
		addRecipe(new ItemStack(set.workbench, 1), set.type.unlocalizedName + "_workbench", "crafting_table", new Object[]{"PP", "PP", 'P', new ItemStack(Resources.planks, 1, meta)});
	}

	public static void registerSlabStairRecipe(StairSlabPair set) {
		ItemStack base = new ItemStack(set.baseItem, 1, set.baseMeta);
		addRecipe(new ItemStack(set.slab, 6), set.name + "_slab", new Object[]{"BBB", 'B', base});
		addRecipe(new ItemStack(set.stairs, 4), set.name + "_stairs", new Object[]{"B  ", "BB ", "BBB", 'B', base});
		if (set.wall != null)
			addRecipe(new ItemStack(set.wall, 6), set.name + "_wall", new Object[]{"BBB", "BBB", 'B', base});
	}

	public static void registerToolRecipe(ToolSet set) {
		ItemStack material = set.bident.material.material.getRepairItemStack();
		String name = set.bident.material.material.name().substring(ModInformation.ID.length() + 1);
		addRecipe(new ItemStack(set.axe), name + "_axe", new Object[]{"MM", "MB", " B", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.pickaxe), name + "_pickaxe", new Object[]{"MMM", " B ", " B ", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.shovel), name + "_shovel", new Object[]{"M", "B", "B", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.sword), name + "_sword", new Object[]{"M", "M", "B", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.dagger), name + "_dagger", new Object[]{"M", "B", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.bident), name + "_bident", new Object[]{"M M", " B ", " B ", 'M', material, 'B', Items.BONE});
		addRecipe(new ItemStack(set.scythe), name + "_scythe", new Object[]{" MM", "M B", "  B", 'M', material, 'B', Items.BONE});
	}

	public static boolean registerArmorRecipe(ArmorSet set) {
		ItemStack material = set.material.getRepairItemStack();
		String name = set.material.name().substring(ModInformation.ID.length() + 1);
		addRecipe(new ItemStack(set.helmet), name + "_helmet", new Object[]{"MMM", "M M", 'M', material});
		addRecipe(new ItemStack(set.chestplate), name + "_chestplate", new Object[]{"M M", "MMM", "MMM", 'M', material});
		addRecipe(new ItemStack(set.leggings), name + "_leggings", new Object[]{"MMM", "M M", "M M", 'M', material});
		addRecipe(new ItemStack(set.boots), name + "_boots", new Object[]{"M M", "M M", 'M', material});
		return true;
	}

	public static void addRecipe(@Nonnull ItemStack output, String name, Object... params) {
		addRecipe(output, name, name, params);
	}

	public static void addRecipe(@Nonnull ItemStack output, String name, String group, Object... params) {
		GameRegistry.addShapedRecipe(new ResourceLocation(ModInformation.ID, "recipe_" + name), new ResourceLocation(group), output, params);
	}

	public static void addShapelessRecipe(@Nonnull ItemStack output, String name, Ingredient... params) {
		addShapelessRecipe(output, name, name, params);
	}

	public static void addShapelessRecipe(@Nonnull ItemStack output, String name, String group, Ingredient... params) {
		GameRegistry.addShapelessRecipe(new ResourceLocation(ModInformation.ID, "recipe_" + name), new ResourceLocation(group), output, params);
	}

	public static void addGrinderRecipe(String name, ItemStack output, Float xp, Ingredient input) {
		CommonProxy.grinderRecipeRegistry.register(new GrinderRecipe(new ResourceLocation(ModInformation.ID, "recipe_" + name), input, xp, output));
	}

	public static void addGrinderRecipe(String name, ItemStack output, Float xp, ItemStack input) {
		addGrinderRecipe(name, output, xp, Ingredient.fromStacks(input));
	}

	public static void addGrinderFuel(String name, ItemStack fuel, int burnTime) {
		CommonProxy.grinderFuelRegistry.register(new GrinderFuel(new ResourceLocation(ModInformation.ID, "recipe_" + name), fuel, burnTime));
	}

	public static void addForgeRecipe(String name, ItemStack output, float xp, Ingredient... inputs) {
		CommonProxy.forgeRecipeRegistry.register(new ForgeRecipe(new ResourceLocation(ModInformation.ID, "recipe_" + name), output, xp, inputs));
	}

	public static void addForgeRecipe(String name, ItemStack output, float xp, ItemStack... inputs) {
		Ingredient[] ingredients = new Ingredient[inputs.length];
		for (int i = 0; i < inputs.length; ++i) {
			ingredients[i] = Ingredient.fromStacks(inputs[i]);
		}
		addForgeRecipe(name, output, xp, ingredients);
	}

	public static void addKettleRecipe(String name, ItemStack output, int color, int cost, Ingredient... inputs) {
		CommonProxy.kettleRecipeRegistry.register(new KettleRecipe(new ResourceLocation(ModInformation.ID, "recipe_" + name), output, color, cost, inputs));
	}

	public static void addKettleRecipe(String name, ItemStack output, int color, int cost, ItemStack... inputs) {
		Ingredient[] ingredients = new Ingredient[inputs.length];
		for (int i = 0; i < inputs.length; ++i) {
			ingredients[i] = Ingredient.fromStacks(inputs[i]);
		}
		addKettleRecipe(name, output, color, cost, ingredients);
	}

	public static void addKettleRecipe(String name, ItemStack output, ItemStack concoction, int color, int cost, Ingredient... inputs) {
		CommonProxy.kettleRecipeRegistry.register(new KettleRecipe(new ResourceLocation(ModInformation.ID, "recipe_" + name), output, concoction, color, cost, inputs));
	}

	public static void addKettleRecipe(String name, ItemStack output, ItemStack concoction, int color, int cost, ItemStack... inputs) {
		Ingredient[] ingredients = new Ingredient[inputs.length];
		for (int i = 0; i < inputs.length; ++i) {
			ingredients[i] = Ingredient.fromStacks(inputs[i]);
		}
		addKettleRecipe(name, output, concoction, color, cost, ingredients);
	}

	public static void addKettleRecipe(SpellSet spell, int cost, Ingredient... inputs) {
		addKettleRecipe(spell.name, new ItemStack(spell.spellItem), spell.hasConcoction ? new ItemStack(spell.concoction) : null, spell.spell.getColor(), cost, inputs);
	}

	public static void addKettleRecipe(SpellSet spell, int cost, ItemStack... inputs) {
		addKettleRecipe(spell.name, new ItemStack(spell.spellItem), spell.hasConcoction ? new ItemStack(spell.concoction) : null, spell.spell.getColor(), cost, inputs);
	}

	public static void moveRecipe(ResourceLocation name) {
		if (ForgeRegistries.RECIPES.containsKey(name)) {
			IRecipe recipe = ForgeRegistries.RECIPES.getValue(name);
			((IForgeRegistryModifiable) ForgeRegistries.RECIPES).remove(name);
			//ForgeRegistries.RECIPES.register(recipe);
			//GameRegistry.addShapedRecipe(name, group, recipe.getRecipeOutput(), recipe.getIngredients());
			//GameData.register_impl(value)

			if (recipe instanceof ShapedRecipes) {
				ForgeRegistries.RECIPES.register(new ShapedRecipes(recipe.getGroup(), ((ShapedRecipes) recipe).getWidth(), ((ShapedRecipes) recipe).getHeight(), recipe.getIngredients(), recipe.getRecipeOutput()).setRegistryName(name));
			}
			if (recipe instanceof ShapelessRecipes) {
				ForgeRegistries.RECIPES.register(new ShapelessRecipes(recipe.getGroup(), recipe.getRecipeOutput(), recipe.getIngredients()).setRegistryName(name));
			}
		}
	}

	public static String upCase(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	public static ItemStack getDye(int color) {
		if (color == 0)
			return new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BLACK_DYE.toMeta());
		if (color == 3)
			return new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BROWN_DYE.toMeta());
		if (color == 4)
			return new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BLUE_DYE.toMeta());
		if (color == 15)
			return new ItemStack(Resources.resource, 1, ItemResources.ResourceType.WHITE_DYE.toMeta());
		return new ItemStack(Items.DYE, 1, color);
	}

	public static void registerOredict() {
		OreDictionary.registerOre("oreLignite", new ItemStack(Resources.ore, 1, 0));
		OreDictionary.registerOre("oreChalkos", new ItemStack(Resources.ore, 1, 1));
		OreDictionary.registerOre("oreKassiteros", new ItemStack(Resources.ore, 1, 2));
		OreDictionary.registerOre("oreDolomite", new ItemStack(Resources.ore, 1, 3));
		OreDictionary.registerOre("oreMolibos", new ItemStack(Resources.ore, 1, 4));
		OreDictionary.registerOre("oreVanadium", new ItemStack(Resources.ore, 1, 5));
		OreDictionary.registerOre("oreSliver", new ItemStack(Resources.ore, 1, 6));
		OreDictionary.registerOre("oreSideros", new ItemStack(Resources.ore, 1, 7));
		OreDictionary.registerOre("oreAnthracite", new ItemStack(Resources.ore, 1, 8));
		OreDictionary.registerOre("oreMolybdenum", new ItemStack(Resources.ore, 1, 9));
		OreDictionary.registerOre("oreBluridium", new ItemStack(Resources.ore, 1, 10));
		OreDictionary.registerOre("oreHyliastrum", new ItemStack(Resources.ore, 1, 11));
		OreDictionary.registerOre("oreAbyssalEssence", new ItemStack(Resources.ore, 1, 12));
		OreDictionary.registerOre("oreRottenBones", new ItemStack(Resources.ore, 1, BlockOre.OreTypes.ROTTEN_BONES.getMeta()));

		OreDictionary.registerOre("ingotChalkos", new ItemStack(Resources.ingot, 1, 0));
		OreDictionary.registerOre("ingotKassiteros", new ItemStack(Resources.ingot, 1, 1));
		OreDictionary.registerOre("ingotMolibos", new ItemStack(Resources.ingot, 1, 2));
		OreDictionary.registerOre("ingotOrichalcum", new ItemStack(Resources.ingot, 1, 3));
		OreDictionary.registerOre("ingotSliver", new ItemStack(Resources.ingot, 1, 4));
		OreDictionary.registerOre("ingotVanadium", new ItemStack(Resources.ingot, 1, 5));
		OreDictionary.registerOre("ingotVanadiumsteel", new ItemStack(Resources.ingot, 1, 6));
		OreDictionary.registerOre("ingotSideros", new ItemStack(Resources.ingot, 1, 7));
		OreDictionary.registerOre("ingotMolybdenum", new ItemStack(Resources.ingot, 1, 8));
		OreDictionary.registerOre("ingotMolybdenumsteel", new ItemStack(Resources.ingot, 1, 9));
		OreDictionary.registerOre("ingotBluridium", new ItemStack(Resources.ingot, 1, 10));

		OreDictionary.registerOre("nuggetChalkos", new ItemStack(Resources.nugget, 1, 0));
		OreDictionary.registerOre("nuggetKassiteros", new ItemStack(Resources.nugget, 1, 1));
		OreDictionary.registerOre("nuggetMolibos", new ItemStack(Resources.nugget, 1, 2));
		OreDictionary.registerOre("nuggetOrichalcum", new ItemStack(Resources.nugget, 1, 3));
		OreDictionary.registerOre("nuggetSliver", new ItemStack(Resources.nugget, 1, 4));
		OreDictionary.registerOre("nuggetVanadium", new ItemStack(Resources.nugget, 1, 5));
		OreDictionary.registerOre("nuggetVanadiumsteel", new ItemStack(Resources.nugget, 1, 6));
		OreDictionary.registerOre("nuggetSideros", new ItemStack(Resources.nugget, 1, 7));
		OreDictionary.registerOre("nuggetMolybdenum", new ItemStack(Resources.nugget, 1, 8));
		OreDictionary.registerOre("nuggetMolybdenumsteel", new ItemStack(Resources.nugget, 1, 9));
		OreDictionary.registerOre("nuggetBluridium", new ItemStack(Resources.nugget, 1, 10));

		OreDictionary.registerOre("blockChalkos", new ItemStack(Resources.metalBlock, 1, 0));
		OreDictionary.registerOre("blockKassiteros", new ItemStack(Resources.metalBlock, 1, 1));
		OreDictionary.registerOre("blockMolibos", new ItemStack(Resources.metalBlock, 1, 2));
		OreDictionary.registerOre("blockOrichalcum", new ItemStack(Resources.metalBlock, 1, 3));
		OreDictionary.registerOre("blockSliver", new ItemStack(Resources.metalBlock, 1, 4));
		OreDictionary.registerOre("blockVanadium", new ItemStack(Resources.metalBlock, 1, 5));
		OreDictionary.registerOre("blockVanadiumsteel", new ItemStack(Resources.metalBlock, 1, 6));
		OreDictionary.registerOre("blockSideros", new ItemStack(Resources.metalBlock, 1, 7));
		OreDictionary.registerOre("blockMolybdenum", new ItemStack(Resources.metalBlock, 1, 8));
		OreDictionary.registerOre("blockMolybdenumsteel", new ItemStack(Resources.metalBlock, 1, 9));
		OreDictionary.registerOre("blockBluridium", new ItemStack(Resources.metalBlock, 1, 10));

		OreDictionary.registerOre("gemLignite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LIGNITE.toMeta()));
		OreDictionary.registerOre("fuelLignite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LIGNITE.toMeta()));
		OreDictionary.registerOre("gemDolomite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.DOLOMITE.toMeta()));
		OreDictionary.registerOre("gemAnthracite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ANTHRACITE.toMeta()));
		OreDictionary.registerOre("fuelAnthracite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ANTHRACITE.toMeta()));
		OreDictionary.registerOre("dustAbyssalEssence", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ABYSSAL_ESSENCE.toMeta()));
		OreDictionary.registerOre("gemHalite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.HALITE.toMeta()));
		OreDictionary.registerOre("gemCalcite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE.toMeta()));
		OreDictionary.registerOre("gemJasper", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.JASPER.toMeta()));
		OreDictionary.registerOre("gemZircon", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ZIRCON.toMeta()));
		OreDictionary.registerOre("dustCalcite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.CALCITE_POWDER.toMeta()));
		OreDictionary.registerOre("clay", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LOAM_LUMP.toMeta()));
		OreDictionary.registerOre("itemClay", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LOAM_LUMP.toMeta()));
		OreDictionary.registerOre("ingotLoamBrick", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.LOAM_BRICK.toMeta()));
		OreDictionary.registerOre("itemLeather", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.AETERNAE_LEATHER.toMeta()));
		OreDictionary.registerOre("leather", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.AETERNAE_LEATHER.toMeta()));
		OreDictionary.registerOre("dye", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BLACK_DYE.toMeta()));
		OreDictionary.registerOre("dyeBlack", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BLACK_DYE.toMeta()));
		OreDictionary.registerOre("dye", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BROWN_DYE.toMeta()));
		OreDictionary.registerOre("dyeBrown", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BROWN_DYE.toMeta()));
		OreDictionary.registerOre("dye", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BLUE_DYE.toMeta()));
		OreDictionary.registerOre("dyeBlue", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.BLUE_DYE.toMeta()));
		OreDictionary.registerOre("dye", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.WHITE_DYE.toMeta()));
		OreDictionary.registerOre("dyeWhite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.WHITE_DYE.toMeta()));
		OreDictionary.registerOre("sugarcane", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.VINEREEDS.toMeta()));
		OreDictionary.registerOre("cropSpelt", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.SPELT.toMeta()));
		OreDictionary.registerOre("string", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.ARACHNE_STRING.toMeta()));
		OreDictionary.registerOre("dustSmallHalite", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.HALITE_POWDER.toMeta()));
		OreDictionary.registerOre("dustSalt", new ItemStack(Resources.resource, 1, ItemResources.ResourceType.HALITE_POWDER.toMeta()));

		OreDictionary.registerOre("cropOlive", new ItemStack(Resources.food, 1, ItemFoods.FoodType.OLIVE_GREEN.toMeta()));
		OreDictionary.registerOre("cropOlive", new ItemStack(Resources.food, 1, ItemFoods.FoodType.OLIVE_BLACK.toMeta()));
		OreDictionary.registerOre("cropLaurelcherry", new ItemStack(Resources.food, 1, ItemFoods.FoodType.LAUREL_CHERRY.toMeta()));
		OreDictionary.registerOre("cropStrawberry", new ItemStack(Resources.food, 1, ItemFoods.FoodType.STRAWBERRY.toMeta()));
		OreDictionary.registerOre("cropPhysalis", new ItemStack(Resources.food, 1, ItemFoods.FoodType.PHYSALIS.toMeta()));
		OreDictionary.registerOre("cropOnion", new ItemStack(Resources.onion, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("cropGarlic", new ItemStack(Resources.food, 1, ItemFoods.FoodType.GARLIC.toMeta()));

		OreDictionary.registerOre("dirt", new ItemStack(Resources.soil, 1, 0));
		OreDictionary.registerOre("dirt", new ItemStack(Resources.soil, 1, 1));
		OreDictionary.registerOre("blockClay", new ItemStack(Resources.soil, 1, 2));
		OreDictionary.registerOre("sand", new ItemStack(Resources.silkstoneSand, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockSand", new ItemStack(Resources.silkstoneSand, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockGlass", new ItemStack(Resources.silkstoneGlass, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("paneGlass", new ItemStack(Resources.silkstoneGlassPane, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("paneGlass", new ItemStack(Resources.silkstoneGlassStraightPane, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("paneGlass", new ItemStack(Resources.silkstoneGlassHorizontalPane, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("sand", new ItemStack(Resources.grainelSand, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockSand", new ItemStack(Resources.grainelSand, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("sandstone", new ItemStack(Resources.grainelStone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockSandstone", new ItemStack(Resources.grainelStone, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockGlass", new ItemStack(Resources.grainelGlass, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("paneGlass", new ItemStack(Resources.grainelGlassPane, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("paneGlass", new ItemStack(Resources.grainelGlassStraightPane, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("paneGlass", new ItemStack(Resources.grainelGlassHorizontalPane, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stone", new ItemStack(Resources.relicstone, 1, 0));
		OreDictionary.registerOre("blockStone", new ItemStack(Resources.relicstone, 1, 0));

		//chests
		OreDictionary.registerOre("chestWood", new ItemStack(Resources.icariaChest, 1));
		OreDictionary.registerOre("chestTrapped", new ItemStack(Resources.icariaChestTrapped, 1));

		OreDictionary.registerOre("blockDolomite", new ItemStack(Resources.dolomiteSmooth, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("blockCalcite", new ItemStack(Resources.gemBlock, 1, BlockStorageGem.GemTypes.CALCITE.getMeta()));
		OreDictionary.registerOre("blockHalite", new ItemStack(Resources.gemBlock, 1, BlockStorageGem.GemTypes.HALITE.getMeta()));
		OreDictionary.registerOre("blockJasper", new ItemStack(Resources.gemBlock, 1, BlockStorageGem.GemTypes.JASPER.getMeta()));
		OreDictionary.registerOre("blockZircon", new ItemStack(Resources.gemBlock, 1, BlockStorageGem.GemTypes.ZIRCON.getMeta()));

		OreDictionary.registerOre("vine", new ItemStack(LOIVines.vineBloomy, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("vine", new ItemStack(LOIVines.vineBranch, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("vine", new ItemStack(LOIVines.vineBrushy, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("vine", new ItemStack(LOIVines.vineDry, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("vine", new ItemStack(LOIVines.vineReedy, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("vine", new ItemStack(LOIVines.vineSwirly, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("vine", new ItemStack(LOIVines.vineThorny, 1, OreDictionary.WILDCARD_VALUE));

		OreDictionary.registerOre("mushroom", new ItemStack(Blocks.BROWN_MUSHROOM, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("mushroom", new ItemStack(Blocks.RED_MUSHROOM, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("mushroom", new ItemStack(Resources.groundMushroom0, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("mushroom", new ItemStack(Resources.groundMushroom1, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("mushroom", new ItemStack(Resources.groundMushroom2, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("mushroom", new ItemStack(Resources.treeMushroom0, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("mushroom", new ItemStack(Resources.treeMushroom1, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("mushroom", new ItemStack(Resources.treeMushroom2, 1, OreDictionary.WILDCARD_VALUE));

		OreDictionary.registerOre("plankWood", new ItemStack(Resources.planks, 1, OreDictionary.WILDCARD_VALUE));
		registerWoodOredict(Resources.plane);
		registerWoodOredict(Resources.populus);
		registerWoodOredict(Resources.cypress);
		registerWoodOredict(Resources.fir);
		registerWoodOredict(Resources.olive);
		registerWoodOredict(Resources.laurel);
		registerWoodOredict(Resources.droughtroot);
	}

	public static void registerWoodOredict(WoodSet set) {
		OreDictionary.registerOre("logWood", new ItemStack(set.log, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("logWood", new ItemStack(set.strippedLog, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeSapling", new ItemStack(set.sapling, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeLeaves", new ItemStack(set.leaf, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("fenceWood", new ItemStack(set.fence, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("fenceGateWood", new ItemStack(set.fenceGate, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("slabWood", new ItemStack(set.slab, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stairWood", new ItemStack(set.stairs, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("workbench", new ItemStack(set.workbench, 1, OreDictionary.WILDCARD_VALUE));
	}
}
