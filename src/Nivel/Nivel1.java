package Nivel;

import Entities.MapaGrilla;

public class Nivel1 extends Nivel{
	
	public Nivel1() {}

	public void llevarACaboActivaciones() {
		desactivarPociones(); 
		activarFrutas();
	}
	public int velocidadProtagonista() {
		return 40;
	}
	
	public int velocidadFantasmas() {
		return 30;
	}
	
	public int apacicionFruta() {
		return 4000;
	}

	public int aparicionPocion() {
		return 0;
	}

}