package com.kaptainwutax.immersivemusic.GUI;

import com.kaptainwutax.immersivemusic.MIDI;
import com.kaptainwutax.immersivemusic.Mic;

import net.minecraft.client.gui.GuiScreen;

public class MidiBlockGuiClient extends GuiScreen {

	public void initGui () {
	
	drawDefaultBackground();
	MIDI.start();
	//Mic.initForLiveMonitor();
	super.initGui();
	
	}
	
    @Override
    public boolean doesGuiPauseGame() {
        
    	return false;
        
    }
}
