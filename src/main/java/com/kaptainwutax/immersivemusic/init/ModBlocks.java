package com.kaptainwutax.immersivemusic.init;

import java.util.ArrayList;
import java.util.List;

import com.kaptainwutax.immersivemusic.blocks.JukeboxBlock;
import com.kaptainwutax.immersivemusic.blocks.MidiBlock;
import com.kaptainwutax.immersivemusic.blocks.NoteBlock;
import com.kaptainwutax.immersivemusic.blocks.SpeakersBlock;
import com.kaptainwutax.immersivemusic.blocks.DiscBurnerBlock;

import net.minecraft.block.Block;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block NoteBlock = new NoteBlock();
	public static final Block MidiBlock = new MidiBlock();
	public static final Block JukeboxBlock = new JukeboxBlock();
	public static final Block SpeakersBlock = new SpeakersBlock();
	public static final Block DiscBurnerBlock = new DiscBurnerBlock();

}
