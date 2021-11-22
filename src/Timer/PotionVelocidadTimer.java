package Timer;

import Controladores.SpeedPotionControler;

public class PotionVelocidadTimer extends Thread {
	private static int sleepDePotionVel; //PP=Power Pellets
	private SpeedPotionControler miControlador; 
	
	public PotionVelocidadTimer(SpeedPotionControler miCon, int sleepV) {
		miControlador = miCon; 
		sleepDePotionVel = sleepV; 
		this.start();
	}
	
	public void run() {
		try {
			PotionVelocidadTimer.sleep(sleepDePotionVel);
			realizarActividad(); 
			PotionVelocidadTimer.interrupted();
		} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
		}		
	}

	public void setSleepDePP(int s) {
		sleepDePotionVel=s;
	}
	
	private void realizarActividad() {	
		miControlador.normalizarVelocidadPacman(); 
	}

	
}

