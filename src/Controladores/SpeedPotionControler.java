package Controladores;

import Timer.PotionVelocidadTimer;
import Timer.ProtagonistaTimer;

public class SpeedPotionControler extends ThreadControl {
	private PotionVelocidadTimer miTimer; 
	private int sleepGeneralProtagonista; 
	
	public SpeedPotionControler(int sleepGeneral) {
		super(); 
		sleepGeneralProtagonista = sleepGeneral; 
	}

	public void normalizarVelocidadPacman() {
		ProtagonistaTimer.getProtagonistaTimer().actualizarSleepProtagonista(sleepGeneralProtagonista);
	}
	
	public void activarSuperVelocidadDePacman(int velocidad, int sleepV ) {
		miTimer = PotionVelocidadTimer.getPotionVelocidadTimer(this,sleepV); 
		if(!miTimer.isAlive()) {
			miTimer.start();
			ProtagonistaTimer.getProtagonistaTimer().actualizarSleepProtagonista(velocidad);
		}else {
			miTimer.adherirTiempoAdicional(sleepV);
		}
	}
}
