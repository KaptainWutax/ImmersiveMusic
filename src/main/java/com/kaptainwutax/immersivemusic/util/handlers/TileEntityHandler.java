package com.kaptainwutax.immersivemusic.util.handlers;

import com.kaptainwutax.immersivemusic.blocks.NoteBlockTileEntity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(NoteBlockTileEntity.class, "NoteBlockTileEntity");

	}
}
