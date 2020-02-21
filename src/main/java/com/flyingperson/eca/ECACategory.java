package com.flyingperson.eca;

import java.util.List;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiFluidStackGroup;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidStack;

public class ECACategory implements IRecipeCategory<ECAWrapper> {
	public static final ResourceLocation BACKGROUND = new ResourceLocation(ECA.MODID, "textures/background.png");
	public static final ResourceLocation ICON = new ResourceLocation(ECA.MODID, "textures/uu.png");
	private IDrawable background, icon;
	
	public ECACategory(IGuiHelper guiHelper) {
		background = guiHelper.drawableBuilder(BACKGROUND, 0, 0, 140, 32).addPadding(0, 12, 0, 0).build();
		//icon = guiHelper.drawableBuilder(ICON, 0, 0, 16, 16).setTextureSize(16, 16).build();
	}
	
	@Override
	public String getUid() {
		return ECA.MODID;
	}

	@Override
	public String getTitle() {
		return "UUM Assembler";
	}

	@Override
	public String getModName() {
		return ECA.MODID;
	}

	@Override
	public IDrawable getBackground() {
		return background;
	}


	@Override
	public void setRecipe(IRecipeLayout recipeLayout, ECAWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();
		
		guiItemStacks.init(0, false, 100, 10);
		guiItemStacks.init(1, true, 20, 10);

		guiItemStacks.set(ingredients);

		ECARecipeDisplayData displayData = ECARecipeDisplayDataCache.getDisplayData(recipeWrapper);
		displayData.setCurrentIngredients(guiItemStacks.getGuiIngredients());
	}
}
