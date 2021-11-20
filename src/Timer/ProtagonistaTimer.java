package Timer;

import Controladores.MovimientosControler;

public class ProtagonistaTimer extends Thread {
	private MovimientosControler miControlador; 
	private Thread hiloPro; 
	private int sleepProtagonista; 
	private int cnsProtagonista;
	
	public ProtagonistaTimer (MovimientosControler miC, int cnsPro) {
		miControlador = miC; 
		hiloPro = new Thread ();
		hiloPro.start();
		sleepProtagonista = miControlador.getSleepGeneralProtagonista(); 
		cnsProtagonista = cnsPro; 
	} 
	
	public void run() {
		try {
			Thread.sleep(this.sleepProtagonista);
			miControlador.realizarMovimiento(cnsProtagonista);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
