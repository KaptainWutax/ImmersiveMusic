package com.kaptainwutax.immersivemusic.proxy;

import com.kaptainwutax.immersivemusic.ImmersiveMusic;
import com.kaptainwutax.immersivemusic.util.handlers.TileEntityHandler;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
		
	}
	
	public void registerTileEntities() {
		
		TileEntityHandler.registerTileEntities();
		
	}
	
}
