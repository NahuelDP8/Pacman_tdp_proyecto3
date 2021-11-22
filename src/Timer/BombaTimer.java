package Timer;

import Controladores.BombasControler;

public class BombaTimer extends Thread{
	private BombasControler miControlador; 
	private int sleepBombas;
	private int sleepExplosion;
	
	public BombaTimer (BombasControler miC) {
		miControlador = miC; 
		sleepBombas = 3000; 
		sleepExplosion = 1000; 
		this.start();
	} 
	
	public void run() {
			try {
				Thread.sleep(this.sleepBombas);
				miControlador.explotar();
				Thread.sleep(this.sleepExplosion);
				miControlador.parar();
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
	}
}
