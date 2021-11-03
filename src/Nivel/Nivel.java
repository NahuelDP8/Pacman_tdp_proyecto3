package Nivel;

import Entities.MapaGrilla;

abstract public class Nivel {
	protected MapaGrilla miMapa;
	
	abstract public int getVelocidadProtagonista();
	
	abstract public int getVelocidadFantasmas();
	
	public void aumentarFanstamaNaranja() {
		miMapa.agregarEnemigoNaranja();
	}
	
	public void aumentarFantasmaAzul() {
		miMapa.agregarEnemigoAzul();
	}
	
	public void aumentarFanstamaRosa() {
		miMapa.agregarEnemigoRosa();
	}
	
	public void aumentarFanstamaRojo() {
		miMapa.agregarEnemigoRojo();
	}
	
	public void activarPociones() {
		miMapa.activarPociones(); 
	}
	
	public void desactivarPociones() {
		miMapa.desactivarPociones();
	}
}
