package com.kaptainwutax.immersivemusic.items;

import com.kaptainwutax.immersivemusic.ImmersiveMusic;
import com.kaptainwutax.immersivemusic.init.ModItems;
import com.kaptainwutax.immersivemusic.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

public ItemBase(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		
		ModItems.ITEMS.add(this);
		
	}

	@Override
	public void registerModels() {

		ImmersiveMusic.proxy.registerItemRenderer(this, 0, "Inventory");
		
	}
}
