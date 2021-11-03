package Nivel;

import Entities.MapaGrilla;

abstract public class Nivel {
	/* protected ArrayList<Fruta> misFrutas;
	 * protected ArrayList<Pociones> misPociones;
	 */
	
	//Atributos de clase
	protected MapaGrilla miMapa;
	
	//Constructor
	public Nivel () {
	}
	
	public void setMapa(MapaGrilla m) {
		miMapa = m;
	}
	
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
	
	public void activarFrutas() {
		miMapa.activarFrutas(); 
	}
	
	public void desactivarFrutas() {
		miMapa.desactivarFrutas(); 
	}
	
	abstract public int velocidadProtagonista();
	abstract public int velocidadFantasmas();
	abstract public int apacicionFruta(); 
	abstract public int aparicionPocion();
}
