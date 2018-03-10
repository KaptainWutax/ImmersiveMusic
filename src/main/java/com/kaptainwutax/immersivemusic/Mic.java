package com.kaptainwutax.immersivemusic;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

public class Mic {

	public static void initForLiveMonitor() {

	    AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100, 16, 2, 4, 44100, false);

	    try {

	        //Speaker
	        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
	        SourceDataLine sourceLine = (SourceDataLine) AudioSystem.getLine(info);
	        sourceLine.open();

	        //Microphone
	        info = new DataLine.Info(TargetDataLine.class, format);
	        TargetDataLine targetLine = (TargetDataLine) AudioSystem.getLine(info);
	        targetLine.open();

	        Thread monitorThread = new Thread() {
	            @Override
	            public void run() {
	                targetLine.start();
	                sourceLine.start();

	                byte[] data = new byte[targetLine.getBufferSize() / 5];
	                int readBytes;

	                while (true) {
	                    readBytes = targetLine.read(data, 0, data.length);
	                    sourceLine.write(data, 0, readBytes);
	                }
	            }
	        };

	        System.out.println( "Start LIVE Monitor for 15 seconds" );
	        monitorThread.start();

	        Thread.sleep(15000);
	        targetLine.stop();
	        targetLine.close();
	        System.out.println( "End LIVE Monitor" );

	    }
	    catch(LineUnavailableException lue) { lue.printStackTrace(); }
	    catch(InterruptedException ie) { ie.printStackTrace(); }


	}
}
