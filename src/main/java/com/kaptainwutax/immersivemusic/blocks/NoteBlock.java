package com.kaptainwutax.immersivemusic.blocks;

import java.util.Random;

import com.kaptainwutax.immersivemusic.GUI.NoteBlockGuiClient;
import com.kaptainwutax.immersivemusic.init.ModBlocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.Console;

public class NoteBlock extends BlockBase implements ITileEntityProvider {
		
	public NoteBlock() {
		
		super("note_block", Material.CORAL);
		
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
		return Item.getItemFromBlock(ModBlocks.NoteBlock);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
	{
		return new ItemStack(ModBlocks.NoteBlock);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) 
	{

		openGUI();
		return true;
	}
	
	@SideOnly(value = Side.CLIENT)
	public void openGUI () {
		
		Minecraft.getMinecraft().displayGuiScreen(new NoteBlockGuiClient());
		Console.println("Open GUI!");
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {

		return new NoteBlockTileEntity();
	}

}


