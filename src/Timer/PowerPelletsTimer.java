package Timer;

import Controladores.PowerPelletsControler;


public class PowerPelletsTimer extends Thread  {
	private int sleepDePP; //PP=Power Pellets
	private PowerPelletsControler miControlador;

	public PowerPelletsTimer(PowerPelletsControler miCon, int sleepPP) {
		miControlador = miCon;  
		sleepDePP = sleepPP;  
		this.start();
	}

	public void run() {
		try {
			PowerPelletsTimer.sleep(sleepDePP);
			realizarActividad(); 
			this.interrupt();
		} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
		}		
	}
 
	public void setSleepDePP(int s) {
		sleepDePP=s;
	}
	
	private void realizarActividad() {
		miControlador.enemigosPerseguir();
	}
	
}
