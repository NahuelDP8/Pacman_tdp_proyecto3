package Controladores;

import Timer.PowerPelletsTimer;
import java.util.ArrayList;
import EnemigosGenerales.Enemigo;

public class PowerPelletsControler extends ThreadControl{
	private PowerPelletsTimer miTimer;
	private ArrayList<Enemigo> misEnemigos; 
	
 	public PowerPelletsControler(int sleepPP, ArrayList<Enemigo> enemigos) {
		super(); 
		misEnemigos = enemigos; 
		enemigosEscapar(); 
		miTimer = new PowerPelletsTimer(this, sleepPP); 
	}

	public void enemigosPerseguir() {
		for(Enemigo e : misEnemigos) {
			e.deboPerseguir();
		}
	}
	
	public void enemigosEscapar() {
		for(Enemigo e : misEnemigos) {
			e.deboEscapar();
		}
		
	}
	
	public void parar() {
		if(miTimer!=null) {
			if(miTimer.isAlive()) {
				miTimer.interrupt();
			}	
		}
	}
}
