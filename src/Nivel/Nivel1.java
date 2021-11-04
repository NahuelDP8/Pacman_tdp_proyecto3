package Nivel;

import Entities.MapaGrilla;

public class Nivel1 extends Nivel{
	
	public Nivel1() {}

	public void llevarACaboActivaciones() {
		activarFrutas();
		activarPociones();
	}
	public int velocidadProtagonista() {
		return 15;
	}
	
	public int velocidadFantasmas() {
		return 30;
	}
	
	public int apacicionFruta() {
		return 4000;
	}

	public int aparicionPocion() {
		return 100;
	}

}
