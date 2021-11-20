package Timer;


import Controladores.MovimientosControler;


public class EnemigosTimer extends Thread{
	private MovimientosControler miControlador; 
	private int sleepEnemigos;
	private int cnsEnemigo; 
	
	public EnemigosTimer (MovimientosControler miC, int cnsEnem) {
		miControlador = miC; 
		sleepEnemigos = miControlador.getSleepGeneralEnemigos();  
		this.cnsEnemigo = cnsEnem; 
		this.start();
	} 
	
	public void run() {
		while (Thread.currentThread() == this) {
	
			try {
				Thread.sleep(this.sleepEnemigos);
				miControlador.realizarMovimiento(cnsEnemigo);
				System.out.println(this.sleepEnemigos);
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}
}
