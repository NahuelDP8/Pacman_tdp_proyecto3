package Logic;

import GUI.GUI;
import Entities.*;
import Factories.FactoryMapaGrilla;

public class Logica {

	private GUI miGUI;
	private Timer miTimer;
	private MapaGrilla miMapa;
	protected FactoryMapaGrilla miFabrica;
	
	public Logica(GUI g, FactoryMapaGrilla f) {
		miGUI = g;
		miFabrica = f;
		miMapa = miFabrica.crearMapa();
		miGUI.actualizarFondo(miMapa.getImage());
	}
	
	public void moverProtagonistaAbajo() {
		miMapa.moverProtagonistaAbajo();
	}
	public void moverProtagonistaArriba() {
		miMapa.moverProtagonistaArriba();
	}
	public void moverProtagonistaDerecha() {
		miMapa.moverProtagonistaDerecha();
	}
	public void moverProtagonistaIzquierda() {
		miMapa.moverProtagonistaIzquierda();
	}
}
