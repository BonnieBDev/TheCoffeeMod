package com.coffee.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;

import com.coffee.main.tileentity.TileEntityBeanRoaster;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerBeanRoaster extends Container{

	private TileEntityBeanRoaster beanRoaster;
	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCookTime;
	
	public ContainerBeanRoaster(InventoryPlayer inventory, TileEntityBeanRoaster tileentity)
	{
		this.beanRoaster = tileentity;
		
		this.addSlotToContainer(new Slot(tileentity, 0, 39, 20));
		this.addSlotToContainer(new Slot(tileentity, 1, 8, 55));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 97, 19));
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18));
			}
		}
		
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	public void addCraftingToCrafters (ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.beanRoaster.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.beanRoaster.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.beanRoaster.currentItemBurnTime);
	}
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.beanRoaster.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.beanRoaster.cookTime);
			}
			
			if(this.lastBurnTime != this.beanRoaster.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.beanRoaster.burnTime);
			}
			
			if(this.lastCurrentItemBurnTime != this.beanRoaster.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.beanRoaster.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.beanRoaster.cookTime;
		this.lastBurnTime = this.beanRoaster.burnTime;
		this.lastCurrentItemBurnTime = this.beanRoaster.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue) {
		
	}
	
	
	
	
	
	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}

}
