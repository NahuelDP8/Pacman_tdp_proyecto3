package Music;
	
import java.io.File;

import javax.sound.sampled.*;


public class AudioPlayer{
	private long MSecondPosition;
	Clip clip;
	
	
    public AudioPlayer( File audioFile ) {
        try{
        	 if(audioFile.exists()) {
        		 AudioInputStream audioIStream = AudioSystem.getAudioInputStream(audioFile);
        		 clip = AudioSystem.getClip();
        		 clip.open(audioIStream);
        		 clip.loop(Clip.LOOP_CONTINUOUSLY);
        	 }else
        		 System.out.println("Esta Vacio");
        	
        }
        catch(Exception ex)    {
            ex.printStackTrace();
        }
    }
    public void alternarSilencio() {
    	if(clip.isActive()){
    		stopMusic();
    	}else {
    		playMusic();
    	}
    }
    
    public void stopMusic() {
    	clip.stop();
    	MSecondPosition=clip.getMicrosecondPosition();
    }
    
    private void playMusic() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    	clip.setMicrosecondPosition(MSecondPosition);
    }
    
   


}