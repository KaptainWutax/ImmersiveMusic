package com.kaptainwutax.immersivemusic.blocks;

import com.kaptainwutax.immersivemusic.ImmersiveMusic;
import com.kaptainwutax.immersivemusic.init.ModBlocks;
import com.kaptainwutax.immersivemusic.init.ModItems;
import com.kaptainwutax.immersivemusic.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel {

	public BlockBase(String name, Material material) {
		
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	@Override
	public void registerModels() {

		ImmersiveMusic.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "Inventory");
		
	}
	
}
