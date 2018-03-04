package com.kaptainwutax.immersivemusic;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;

import com.kaptainwutax.immersivemusic.GUI.NoteBlockGuiClient;
import com.kaptainwutax.immersivemusic.blocks.NoteBlockTileEntity;
import com.kaptainwutax.immersivemusic.util.handlers.NoteBlockSoundsHandler;

import scala.Console;

public class MIDI {

	 public MidiDevice input;
	    public static MidiDevice output;
	     
	    public static void main(String[] args) {
	          new MIDI().start();
	       }
	       
	       
	 
	    public static void start()  {
	         
	        init();  
	     
	          try {
	             output.open();
	             Receiver rcvr = new MyReceiver();
	             MidiSystem.getTransmitter().setReceiver(rcvr);
	          }
	          catch (Exception e) {
	             e.printStackTrace();
	             
	          }
	     
	       }
	   
	       public static void init() {
	 
	           MidiDevice.Info[] devices;
	 
	           devices = MidiSystem.getMidiDeviceInfo();
	 
	           for (MidiDevice.Info info: devices) {
	           
	               System.out.println(" Name: " + info.toString() + ", Decription: " + info.getDescription() + ", Vendor: " + info.getVendor());
	           
	               try {
	                   output = MidiSystem.getMidiDevice(info);
	               } catch (MidiUnavailableException e) {
	                   e.printStackTrace();
	               }
	               
	               if (! output.isOpen()) {
	                   try {
	                       output.open();
	                   } catch (MidiUnavailableException e) {
	                       e.printStackTrace();
	                   }
	               }       
	        }
	           
	       }
	           
	       private static class MyReceiver implements Receiver  {
	          
	    	   Receiver rcvr;
	    	   
	          public MyReceiver() {
	        	  
	             try {
	            	 
	             this.rcvr = MidiSystem.getReceiver();
	             
	             } catch (MidiUnavailableException mue) {
	            	 
	                mue.printStackTrace();
	             }
	          }
	           
	          @Override
	          public void send(MidiMessage message, long timeStamp) {
	             
	        	  byte[] b = message.getMessage();
	        	  b[2] = 0;
	        	
	             if((b[0] & 0xFF) == 144) {
	              System.out.println(b[1] & 0xFF);
	             
	              if (NoteBlockSoundsHandler.NOTE_SOUND[1][b[1] & 0xFF] != null)
	                  NoteBlockGuiClient.PlayNote(1, b[1] & 0xFF);
	             
	             }             
	             
	             rcvr.send(message, timeStamp);
	          }
	     
	          @Override
	          public void close() {
	             rcvr.close();
	          }
	       }        
} 
   

