package com.flyingperson.eca;

import javax.annotation.Nullable;
import java.util.Map;

import net.minecraft.item.ItemStack;

import mezz.jei.api.gui.IGuiIngredient;

public class ECARecipeDisplayData {
	@Nullable
	private Map<Integer, ? extends IGuiIngredient<ItemStack>> currentIngredients = null;
	@Nullable
	private ItemStack item;
	@Nullable
	private ItemStack uum;
	
	
	@Nullable
	public Map<Integer, ? extends IGuiIngredient<ItemStack>> getCurrentIngredients() {
		return currentIngredients;
	}
	
	public void setCurrentIngredients(Map<Integer, ? extends IGuiIngredient<ItemStack>> currentIngredients) {
		this.currentIngredients = currentIngredients;
	}
	
	@Nullable
	public ItemStack getItem() {
		return item;
	}
	
	@Nullable
	public ItemStack getUU() {
		return uum;
	}
	
	public void setLast(ItemStack item, ItemStack uu) {
		this.item = item;
		this.uum = uu;
	}
	
}
