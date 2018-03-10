package com.kaptainwutax.immersivemusic.blocks;

import java.util.Random;

import com.kaptainwutax.immersivemusic.init.ModBlocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpeakersBlock extends BlockBase{
	
	public SpeakersBlock() {
		
		super("speakers_block", Material.CORAL);
		
		setSoundType(SoundType.WOOD);
		setHardness(5.0F);
		setResistance(18000000F);
		setHarvestLevel("pickaxe", 0);
		setLightLevel(0F);
		setLightOpacity(15);
		//setBlockUnbreakable();
		setCreativeTab(CreativeTabs.MISC);

	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return Item.getItemFromBlock(ModBlocks.SpeakersBlock);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(ModBlocks.SpeakersBlock);
	}

}
