package Music;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sound.sampled.*;


public class AudioPlayer{
	private long MSecondPosition;
	Clip clip;
	public static Properties configurations;
	
	
    public AudioPlayer( File audioFile ) {
    	loadConfiguration();
        try{
        	 if(audioFile.exists()) {
        	 AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
             clip = AudioSystem.getClip();
             clip.open(audioStream);
             clip.loop(clip.LOOP_CONTINUOUSLY);
             clip.start();
        	 }else
        		 System.out.println("Esta Vacio");
        	
        }
        catch(Exception ex)    {
            ex.printStackTrace();
        }
    }
    
    private static void loadConfiguration() {
		try {
			InputStream input = new FileInputStream("./configuration.properties");
			AudioPlayer.configurations= new Properties();
			AudioPlayer.configurations.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
    
    public void alternarSilencio() {
    	if(clip.isActive()){
    		stopMusic();
    	}else {
    		playMusic();
    	}
    }
    private void stopMusic() {
    	clip.stop();
    	MSecondPosition=clip.getMicrosecondPosition();
    }
    
    private void playMusic() {
        clip.loop(clip.LOOP_CONTINUOUSLY);
    	clip.setMicrosecondPosition(MSecondPosition);
    	
    	
    }
    
   


}