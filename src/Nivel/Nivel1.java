package Nivel;

import Entities.MapaGrilla;

public class Nivel1 extends Nivel{
	
	public Nivel1() {
		desactivarPociones(); 
		activarFrutas();
	}
	
	public int velocidadProtagonista() {
		return 30;
	}
	
	public int velocidadFantasmas() {
		return 30;
	}
	
	public int apacicionFruta() {
		return 2000;
	}
	@Override
	public int aparicionPocion() {
		return 2000;
	}

}
