package com.flyingperson.eca;

import java.util.List;
import java.util.function.Predicate;

import com.flyingperson.eca.ECACompat;
import com.flyingperson.eca.ECAWrapper;

import ic2.api.classic.recipe.machine.MachineOutput;

import gtclassic.common.tile.GTTileUUMAssembler;
import gtclassic.api.recipe.GTRecipeMultiInputList;
import gtclassic.api.recipe.GTRecipeMultiInputList.*;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;

public class ECARecipes extends ECACompat {
	
	static Predicate<MultiRecipe> pred = s -> {
		return true;
	};
	public static final List<MultiRecipe> recipes = gtclassic.common.tile.GTTileUUMAssembler.RECIPE_LIST.getAllRecipes(pred);

	public ECARecipes() {
		super("ic2/gtclassic");
	}

	@Override
	public void addRecipes(List<ECAWrapper> list) {

		for (int i = 0; i < recipes.size(); i++) {
			
			MachineOutput output = recipes.get(i).getOutputs();
			
			List<ItemStack> output2 = output.getAllOutputs();
			
			list.add(new ECAWrapper(output2.get(0), recipes.get(i).getInputs().get(0).getInputs().get(0)));
		}
	}

}