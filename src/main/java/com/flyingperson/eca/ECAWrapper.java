package com.flyingperson.eca;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.oredict.OreIngredient;

public class ECAWrapper implements IRecipeWrapper {
	protected List<List<ItemStack>> in;
	protected ItemStack item;
	protected ItemStack uum;
	protected List<List<ItemStack>> uu;
	protected String info;
	
	private ECAWrapper(ItemStack uum, String info, ItemStack... input) {
		this.info = info;
		this.uum = uum;
		in = new ArrayList<>();
		for (ItemStack stack : input) in.add(Collections.singletonList(stack));
	}
	
	public ECAWrapper(ItemStack item2, ItemStack uum) {

		this(uum, "", item2);
		item = item2;
	}
	


	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setOutput(VanillaTypes.ITEM, item);
		ingredients.setInput(VanillaTypes.ITEM, uum);
	}
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		if (info == null) return;
		
		String text = I18n.format(info);
		
		int width = minecraft.fontRenderer.getStringWidth(text);
		int x = (recipeWidth - width) / 2;
		int y = 50;

		minecraft.fontRenderer.drawString(text, x, y, Color.GRAY.getRGB());
	}
}