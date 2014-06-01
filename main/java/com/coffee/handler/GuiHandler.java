package com.coffee.handler;

import com.coffee.container.ContainerBeanRoaster;
import com.coffee.gui.GuiBeanRoaster;
import com.coffee.main.Main;
import com.coffee.main.tileentity.TileEntityBeanRoaster;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case Main.guiIDBeanRoaster : 
				if(entity instanceof TileEntityBeanRoaster) {
					return new ContainerBeanRoaster(player.inventory, (TileEntityBeanRoaster) entity);
				}
				return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case Main.guiIDBeanRoaster : 
				if(entity instanceof TileEntityBeanRoaster) {
					return new GuiBeanRoaster(player.inventory, (TileEntityBeanRoaster) entity);
				}
				return null;
			}
		}
		return null;
	}

}
