package com.coffee.main.creativetabs;

import com.coffee.main.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsMainTab extends CreativeTabs {

	public CreativeTabsMainTab(String mainTabLabel) {
		super(mainTabLabel);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Main.machineBeanRoasterIdle);
	}

}
