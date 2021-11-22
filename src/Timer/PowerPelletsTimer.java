package Timer;

import Controladores.PowerPelletsControler;


public class PowerPelletsTimer extends Thread  {
	private static int sleepDePP; //PP=Power Pellets
	private static PowerPelletsControler miControlador;

	public PowerPelletsTimer(PowerPelletsControler miCon, int sleepPP) {
		miControlador = miCon;  
		sleepDePP = sleepPP;  
	}

	public void run() {
		try {
			PowerPelletsTimer.sleep(sleepDePP);
			realizarActividad(); 
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
