package com.flyingperson.eca;

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public abstract class ECACompat implements Comparable<ECACompat> {
	protected String modid;
	
	public ECACompat(String modid) {
		this.modid = modid;
	}
	
	public String getModID() {
		return modid;
	}
	
	public abstract void addRecipes(List<ECAWrapper> list);
	
	public final boolean shouldLoad() {
		return Loader.isModLoaded(modid);
	}

	@Override
	public int compareTo(ECACompat o) {
		return modid.compareTo(o.modid);
	}
	
	public static ItemStack getModdedItem(String name) {
		return getModdedItem(name, 1, 0);
	}
	
	public static ItemStack getModdedItem(String name, int count) {
		return getModdedItem(name, count, 0);
	}
	
	public static ItemStack getModdedItem(String name, int count, int meta) {
		Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(name));
		if (item == null) return ItemStack.EMPTY;
		else return new ItemStack(item, count, meta);
	}
}