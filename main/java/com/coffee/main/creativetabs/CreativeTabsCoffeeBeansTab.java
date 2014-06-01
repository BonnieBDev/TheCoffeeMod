package com.coffee.main.creativetabs;

import com.coffee.main.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsCoffeeBeansTab extends CreativeTabs {

	public CreativeTabsCoffeeBeansTab(String coffeeBeanTabLabel) {
		super(coffeeBeanTabLabel);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemById(Item.getIdFromItem(Main.itemCoffeeCherries));
	}

}