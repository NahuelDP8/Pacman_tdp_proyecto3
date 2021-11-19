package Controladores;

import Logic.Logica;
import Timer.PotionVelocidadTimer;

public class SpeedPotionControler extends ThreadControl {
	private PotionVelocidadTimer miTimer; 
	private int sleepGeneralProtagonista; 
	
	public SpeedPotionControler(int sleepGeneral) {
		super(); 
		sleepGeneralProtagonista = sleepGeneral; 
	}

	public void normalizarVelocidadPacman() {
		Logica.getLogic(null, null, null).actualizarSleepProtagonista(sleepGeneralProtagonista);
	}
	
	public void activarSuperVelocidadDePacman(int velocidad, int sleepV ) {
		miTimer = PotionVelocidadTimer.getPotionVelocidadTimer(this,sleepV); 
		if(!miTimer.isAlive()) {
			miTimer.start();
			Logica.getLogic(null, null, null).actualizarSleepProtagonista(velocidad);
		}else {
			miTimer.adherirTiempoAdicional(sleepV);
		}
	}
}
