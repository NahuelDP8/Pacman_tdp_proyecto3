package Controladores;

import Timer.PotionVelocidadTimer;
import Timer.ProtagonistaTimer;

public class SpeedPotionControler extends ThreadControl {
	protected PotionVelocidadTimer miTimer; 
	private int sleepGeneralProtagonista; 
	
	public SpeedPotionControler(int sleepGeneral, int sleepV, int velocidad) {
		super(); 
		sleepGeneralProtagonista = sleepGeneral; 
		miTimer = new PotionVelocidadTimer(this,sleepV); 
		ProtagonistaTimer.getProtagonistaTimer().actualizarSleepProtagonista(velocidad);
	}

	public void normalizarVelocidadPacman() {
		ProtagonistaTimer.getProtagonistaTimer().actualizarSleepProtagonista(sleepGeneralProtagonista);
	}
	
	
}