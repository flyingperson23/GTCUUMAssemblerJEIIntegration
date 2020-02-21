package com.flyingperson.eca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.flyingperson.eca.ECARecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

@JEIPlugin
public class ECAPlugin implements IModPlugin {
	@Override
	public void register(IModRegistry registry) {
		List<ECAWrapper> list = new ArrayList<>();
		new ECARecipes().addRecipes(list);
		registry.addRecipes(list, ECA.MODID);
		
		registry.addRecipeCatalyst(new ItemStack(gtclassic.common.GTBlocks.tileUUMAssembler), "eca");
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		registry.addRecipeCategories(new ECACategory(registry.getJeiHelpers().getGuiHelper()));
	}
}