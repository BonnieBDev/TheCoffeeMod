package com.coffee.main;

import com.coffee.beans.CoffeeCherries;
import com.coffee.handler.GuiHandler;
import com.coffee.main.blocks.BeanRoaster;
import com.coffee.main.creativetabs.CreativeTabsMainTab;
import com.coffee.main.tileentity.TileEntityBeanRoaster;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "the_coffee_mod";
    public static final String VERSION = "1.0";
    
    @Instance(MODID)
    public static Main instance;
    
    //Creative Tabs
    public static CreativeTabs mainTab = new CreativeTabsMainTab("MainTab");
    public static CreativeTabs coffeeBeansTab = new CreativeTabsMainTab("CoffeeBeansTab");
    
    //Blocks
    public static Block machineBeanRoasterIdle;
    public static Block machineBeanRoasterActive;
    public static final int guiIDBeanRoaster = 0;
    
    //Items
    public static Item itemCoffeeCherries;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    
    NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    
    GameRegistry.registerTileEntity(TileEntityBeanRoaster.class, "BeanRoaster");
    	
    //Initializers
    	
    	//Machines
    	machineBeanRoasterIdle = new BeanRoaster(false).setBlockName("beanRoasterIdle").setCreativeTab(this.mainTab);
    	machineBeanRoasterActive = new BeanRoaster(true).setBlockName("beanRoasterActive").setLightLevel(0.625F);
    	
    	//Blocks
    	
    	//Items
    	itemCoffeeCherries = new CoffeeCherries().setUnlocalizedName("coffeeCherries").setCreativeTab(this.coffeeBeansTab);
    	
    //Registers
    	
    	//Machines
    	GameRegistry.registerBlock(machineBeanRoasterIdle, machineBeanRoasterIdle.getUnlocalizedName().substring(5));
    	GameRegistry.registerBlock(machineBeanRoasterActive, machineBeanRoasterActive.getUnlocalizedName().substring(5));
    	
    	//Blocks
    	
    	
    	//Items
    	
    }
}
