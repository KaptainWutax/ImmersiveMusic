package com.kaptainwutax.immersivemusic.init;

import java.util.ArrayList;
import java.util.List;

import com.kaptainwutax.immersivemusic.blocks.NoteBlock;
import com.kaptainwutax.immersivemusic.blocks.MidiBlock;


import net.minecraft.block.Block;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block NoteBlock = new NoteBlock();
	public static final Block MidiBlock = new MidiBlock();

}
