package com.kaptainwutax.immersivemusic.GUI;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.kaptainwutax.immersivemusic.ImmersiveMusic;
import com.kaptainwutax.immersivemusic.MIDI;
import com.kaptainwutax.immersivemusic.blocks.NoteBlock;
import com.kaptainwutax.immersivemusic.blocks.NoteBlockTileEntity;
import com.kaptainwutax.immersivemusic.util.Reference;
import com.kaptainwutax.immersivemusic.util.handlers.NoteBlockSoundsHandler;

import ibxm.Player;
import net.java.games.input.Mouse;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.Console;

public class NoteBlockGuiClient extends GuiScreen {	
	
	public static World world = Minecraft.getMinecraft().world;
    
    int noteButtonWidth = 20;
    int noteButtonHeight = 20;
    
    ResourceLocation texture = new ResourceLocation (Reference.MOD_ID, "textures/gui/background.png");
    
    //notes
    GuiButton button_c;
    GuiButton button_c_;
    GuiButton button_d;
    GuiButton button_d_;
    GuiButton button_e;
    GuiButton button_f;
    GuiButton button_f_;
    GuiButton button_g;
    GuiButton button_g_;
    GuiButton button_a;
    GuiButton button_a_;
    GuiButton button_b;
    
    final int BUTTON_C = 0;
    final int BUTTON_C_ = 1;
    final int BUTTON_D = 2;
    final int BUTTON_D_ = 3;
    final int BUTTON_E = 4;
    final int BUTTON_F = 5;
    final int BUTTON_F_ = 6;
    final int BUTTON_G = 7;
    final int BUTTON_G_ = 8;
    final int BUTTON_A = 9;
    final int BUTTON_A_ = 10;
    final int BUTTON_B = 11;
    
    //octaves
    GuiButton octave_1_;
    GuiButton octave_0;
    GuiButton octave_1;
    GuiButton octave_2;
    GuiButton octave_3;
    GuiButton octave_4;
    GuiButton octave_5;
    GuiButton octave_6;
    GuiButton octave_7;
    GuiButton octave_8;
    
    final int OCTAVE_1_ = 128;
    final int OCTAVE_0 = 129;
    final int OCTAVE_1 = 130;
    final int OCTAVE_2 = 131;
    final int OCTAVE_3 = 132;
    final int OCTAVE_4 = 133;
    final int OCTAVE_5 = 134;
    final int OCTAVE_6 = 135;
    final int OCTAVE_7 = 136;
    final int OCTAVE_8 = 137;
    
    //instruments
    GuiButton instrument;
    GuiButton instrument_increment;
    GuiButton instrument_decrement;
    static String instrumentText = "Loading...";
    
    final int INSTRUMENT = 12;
    final int INSTRUMENT_DECREMENT = 13;
    final int INSTRUMENT_INCREMENT = 14;

    
    
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
       
    	drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
       //org.lwjgl.input.Mouse.setGrabbed(false);
        
    }
	
	public void initGui() {
		
    	buttonList.clear();
    	
		int centerX = (width / 2) - ((noteButtonWidth) / 2);
	    int centerY = (height / 2) - ((noteButtonHeight) / 2);
	    
	    int offsetNotesX = 20;
	    int offsetNotesY = 100;
	     
	    //notes
	    buttonList.add(button_b = new GuiButton(BUTTON_B, centerX + (offsetNotesX * 0), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "B"));
	    buttonList.add(button_a_ = new GuiButton(BUTTON_A_, centerX + (offsetNotesX * -1), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "A#"));
	    buttonList.add(button_a = new GuiButton(BUTTON_A, centerX + (offsetNotesX * -2), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "A"));
	    buttonList.add(button_g_ = new GuiButton(BUTTON_G_, centerX + (offsetNotesX * -3), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "G#"));
	    buttonList.add(button_g = new GuiButton(BUTTON_G, centerX + (offsetNotesX * -4), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "G"));
    	buttonList.add(button_f_ = new GuiButton(BUTTON_F_, centerX + (offsetNotesX * -5), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "F#"));
    	buttonList.add(button_f = new GuiButton(BUTTON_F, centerX + (offsetNotesX * -6), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "F"));
    	buttonList.add(button_e = new GuiButton(BUTTON_E, centerX + (offsetNotesX * -7), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "E"));
     	buttonList.add(button_d_ = new GuiButton(BUTTON_D_, centerX + (offsetNotesX * -8), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "D#"));
     	buttonList.add(button_d = new GuiButton(BUTTON_D, centerX + (offsetNotesX * -9), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "D"));
     	buttonList.add(button_c_ = new GuiButton(BUTTON_C_, centerX + (offsetNotesX * -10), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "C#"));
     	buttonList.add(button_c = new GuiButton(BUTTON_C, centerX + (offsetNotesX * -11), centerY - (offsetNotesY), noteButtonWidth, noteButtonHeight, "C"));
     	
     	int offsetOctaveY = 22;
     	//octaves
     	buttonList.add(octave_1_ = new GuiButton(OCTAVE_1_, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * 0), 200, noteButtonHeight, "Octave -1"));
     	buttonList.add(octave_0 = new GuiButton(OCTAVE_0, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * -1), 200, noteButtonHeight, "Octave 0"));
     	buttonList.add(octave_1 = new GuiButton(OCTAVE_1, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * -2), 200, noteButtonHeight, "Octave 1"));
     	buttonList.add(octave_2 = new GuiButton(OCTAVE_2, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * -3), 200, noteButtonHeight, "Octave 2"));
     	buttonList.add(octave_3 = new GuiButton(OCTAVE_3, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * -4), 200, noteButtonHeight, "Octave 3"));
     	buttonList.add(octave_4 = new GuiButton(OCTAVE_4, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * -5), 200, noteButtonHeight, "Octave 4 (Middle)"));
     	buttonList.add(octave_5 = new GuiButton(OCTAVE_5, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * -6), 200, noteButtonHeight, "Octave 5"));
     	buttonList.add(octave_6 = new GuiButton(OCTAVE_6, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * -7), 200, noteButtonHeight, "Octave 6"));
     	buttonList.add(octave_7 = new GuiButton(OCTAVE_7, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * -8), 200, noteButtonHeight, "Octave 7"));
     	buttonList.add(octave_8 = new GuiButton(OCTAVE_8, centerX + (40), centerY - (offsetNotesY + offsetOctaveY * -9), 200, noteButtonHeight, "Octave 8"));

     	//instruments
     	buttonList.add(instrument_increment = new GuiButton(INSTRUMENT_INCREMENT, centerX - (0), 45, 20, noteButtonHeight, ">"));
     	buttonList.add(instrument_decrement = new GuiButton(INSTRUMENT_DECREMENT, centerX - (220), 45, 20, noteButtonHeight, "<"));
     	setInstrumentText();
     	
		super.initGui();
	}
	
	@Override
    protected void actionPerformed(GuiButton button) throws IOException {
       
		setNote(button.id);
		
        super.actionPerformed(button);
        
}
	
    @Override
    public boolean doesGuiPauseGame() {
        
    	return false;
        
    }
    
    public void setNote(int id) {
    	
    	int _note;
    	
    	if(id > 127) 
    		NoteBlockTileEntity.octave = id - 129;
		
    	if (id < 12) 
    		NoteBlockTileEntity.note = id;
    	
    	//if (id == 12)
    		
    	if (id == 13)
    		NoteBlockTileEntity.instrumentToPlay --;
    	
    	if (id == 14)
    		NoteBlockTileEntity.instrumentToPlay ++;
    	
    	if (NoteBlockTileEntity.instrumentToPlay < 0)
    		NoteBlockTileEntity.instrumentToPlay = 0;
    	
    	if (NoteBlockTileEntity.instrumentToPlay > NoteBlockSoundsHandler.instrumentsAmount - 1)
    		NoteBlockTileEntity.instrumentToPlay = NoteBlockSoundsHandler.instrumentsAmount - 1;
    	
    	setInstrumentText ();

    	NoteBlockTileEntity.noteToPlay = NoteBlockTileEntity.note + (12 * (NoteBlockTileEntity.octave + 1));
    	Console.println(NoteBlockTileEntity.noteToPlay);
    	Console.println(NoteBlockTileEntity.instrumentToPlay);
    			
    	if (NoteBlockSoundsHandler.NOTE_SOUND[NoteBlockTileEntity.instrumentToPlay][NoteBlockTileEntity.noteToPlay] != null)
    		PlayNote(NoteBlockTileEntity.instrumentToPlay, NoteBlockTileEntity.noteToPlay);
 
    }
    
	private void setInstrumentText() {
		
		switch (NoteBlockTileEntity.instrumentToPlay) {
		
		case 0 : instrumentText = "Piano";
			break;
		
		case 1 : instrumentText =  "Violon Staccados";
			break;
			
		case 2 : instrumentText = "French Horn";
			break;
		
		}
		
		int centerX = (width / 2) - ((noteButtonWidth) / 2);
	    int centerY = (height / 2) - ((noteButtonHeight) / 2);
	    
		if (buttonList.contains(instrumentText))
			buttonList.remove(24);
		
     	buttonList.add(instrument = new GuiButton(INSTRUMENT, centerX - (200), 45, 200, noteButtonHeight, instrumentText));

	}

	public static void PlayNote(int instrument, int note) {
		
		world.playSound(0F,0F,0F, NoteBlockSoundsHandler.NOTE_SOUND[instrument][note], SoundCategory.AMBIENT, 1F, 1F, true);
		
	}
    
}
