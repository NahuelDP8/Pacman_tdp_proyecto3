package Timer;


import Controladores.MovimientosControler;
import Logic.Logica;


public class EnemigosTimer extends Thread{
	private MovimientosControler miControlador; 
	private int sleepEnemigos;
	private int cnsEnemigo; 
	private boolean enemigosEnEmergencia; 
	public EnemigosTimer (MovimientosControler miC, int cnsEnem) {
		miControlador = miC; 
		sleepEnemigos = miControlador.getSleepGeneralEnemigos();  
		this.cnsEnemigo = cnsEnem;
		enemigosEnEmergencia =false; 
		this.start();
	} 
	
	public void run() {
		while (Thread.currentThread() == this) {
	
			try {
				if(enemigosEnEmergencia) {
					Thread.sleep((this.sleepEnemigos*80)/100);	
				}else {
					Thread.sleep(this.sleepEnemigos);
				}
				miControlador.realizarMovimiento(cnsEnemigo);
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public void desventajaEnemgios() {
		enemigosEnEmergencia  = true; 
	}
	
	public void normalizarEnemigos() {
		enemigosEnEmergencia =false; 
	}
}
