package Timer;


import Controladores.MovimientosControler;


public class EnemigosTimer extends Thread{
	private MovimientosControler miControlador; 
	private Thread hiloEnemigos; 
	private int sleepEnemigos;
	private int cnsEnemigo; 
	
	public EnemigosTimer (MovimientosControler miC, int cnsEnem) {
		miControlador = miC; 
		hiloEnemigos = new Thread();
		hiloEnemigos.start();
		sleepEnemigos = miControlador.getSleepGeneralEnemigos();  
		this.cnsEnemigo = cnsEnem; 
	} 
	
	public void run() {
		try {
			Thread.sleep(this.sleepEnemigos);
			miControlador.realizarMovimiento(cnsEnemigo);
		} catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
