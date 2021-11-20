package Controladores;

import Timer.PowerPelletsTimer;
import java.util.ArrayList;
import Entities.Enemigo;

public class PowerPelletsControler extends ThreadControl{
	private PowerPelletsTimer miTimer;
	private ArrayList<Enemigo> misEnemigos; 
	
 	public PowerPelletsControler() {
		super(); 
	}

	public void enemigosPerseguir() {
		for(Enemigo e : misEnemigos) {
			e.deboPerseguir();
		}
	}

	public void activarPowerPellet(int sleepPP, ArrayList<Enemigo> enemigos) {
		misEnemigos = enemigos;
		enemigosEscapar(); 
		miTimer = PowerPelletsTimer.getPowerPelletsTimer(this, sleepPP); 
		if(!miTimer.isAlive()) {
			miTimer.start();
		}else {
			miTimer.adherirTiempoAdicional(sleepPP);
		}
	}
	
	public void enemigosEscapar() {
		for(Enemigo e : misEnemigos) {
			e.deboEscapar();
		}
		
	}
}
