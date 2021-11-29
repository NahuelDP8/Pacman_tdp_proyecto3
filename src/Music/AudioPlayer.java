package Music;
	
import java.io.File;

import javax.sound.sampled.*;


public class AudioPlayer{
	private long MSecondPosition;
	Clip clip;
	
	
    public AudioPlayer( File audioFile ,boolean loop) {
        try{
        	 if(audioFile.exists()) {
        		 AudioInputStream audioIStream = AudioSystem.getAudioInputStream(audioFile);
        		 clip = AudioSystem.getClip();
        		 clip.open(audioIStream);
        		 if(loop) {
        			 clip.loop(Clip.LOOP_CONTINUOUSLY);
        		 }else {
        			 clip.start();
        		 }
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
    		playMusicContinuously();
    	}
    }
    
    public void stopMusic() {
    	clip.stop();
    	MSecondPosition=clip.getMicrosecondPosition();
    }
    
    public void playMusicContinuously() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    	clip.setMicrosecondPosition(MSecondPosition);
    }
    
   


}