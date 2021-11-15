package Nivel;

import Mapas.MapaGrilla;

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
	
	abstract public int sleepProtagonista();
	abstract public int sleepFantasmas();
	abstract public int sleepFruta(); 
	abstract public int sleepPocion();
}
