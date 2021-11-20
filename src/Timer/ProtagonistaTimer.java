package Timer;

import Controladores.MovimientosControler;

public class ProtagonistaTimer extends Thread {
	private MovimientosControler miControlador; 
	private static ProtagonistaTimer hiloPro; 
	private int sleepProtagonista; 
	private int cnsProtagonista;
	
	private ProtagonistaTimer (MovimientosControler miC, int cnsPro) {
		miControlador = miC; 
		hiloPro.start();
		sleepProtagonista = miControlador.getSleepGeneralProtagonista(); 
		cnsProtagonista = cnsPro; 
	} 
	
	public static ProtagonistaTimer getProtagonistaTimer(MovimientosControler miC, int cnsPro) {
		if (hiloPro == null) {
			hiloPro = new ProtagonistaTimer(miC, cnsPro); 
		}
		return hiloPro; 
	}
	
	public static ProtagonistaTimer getProtagonistaTimer() {
		return hiloPro; 
	}
	
	public void run() {
		try {
			Thread.sleep(this.sleepProtagonista);
			miControlador.realizarMovimiento(cnsProtagonista);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void actualizarSleepProtagonista(int sleepGeneralProtagonista) {
		sleepProtagonista =sleepGeneralProtagonista; 
		
	}
}
