package Controladores;

import Entities.Explosion;
import Timer.BombaTimer;

public class BombasControler extends ThreadControl{
	private Explosion miExplosion;
	private  BombaTimer timerBomba;
	
	public BombasControler (Explosion b ) {
		miExplosion= b;
		timerBomba = new BombaTimer(this);
	}

	public void explotar() {
		miExplosion.crearExplosion();
		
	}

	public void pararExplosion() {
		miExplosion.pararExplosion();
	}
	
	public void parar() {
		if(timerBomba!=null) {
			if(timerBomba.isAlive()) {
				timerBomba.interrupt();
			}	
		}
	}
}
