package Nivel;

import Mapas.MapaGrilla;

abstract public class Nivel {
	/* protected ArrayList<Fruta> misFrutas;
	 * protected ArrayList<Pociones> misPociones;
	 */
	
	//Atributos de clase
	protected MapaGrilla miMapa;
	
	//Constructor
	
	public void setMapa(MapaGrilla m) {
		miMapa = m;
	}
	
	
	abstract public int getNivel();
	abstract public int sleepProtagonista();
	abstract public int sleepFantasmas();
	abstract public int sleepFruta(); 
	abstract public int sleepSuperSpeedPocion();
	abstract public int sleepPowerPellets();
	abstract public Nivel nivelSiguiente();
}
