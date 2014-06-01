package com.coffee.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.coffee.container.ContainerBeanRoaster;
import com.coffee.main.Main;
import com.coffee.main.tileentity.TileEntityBeanRoaster;

public class GuiBeanRoaster extends GuiContainer{

	
	
	public static final ResourceLocation bground = new ResourceLocation(Main.MODID + ":" + "textures/gui/GuiBeanRoaster.png");
	
	public TileEntityBeanRoaster beanRoaster;
	
	public GuiBeanRoaster(InventoryPlayer inventoryPlayer, TileEntityBeanRoaster entity) {
		super(new ContainerBeanRoaster(inventoryPlayer, entity));
		

		this.beanRoaster = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = "Coffee Bean Roaster";
		
		this.fontRendererObj.drawString(name, (this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2), 5, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 115, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
