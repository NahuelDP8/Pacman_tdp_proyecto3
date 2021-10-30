package Logic;

import GUI.GUI;
import Entities.*;
import Factories.FactoryMapaGrilla;

public class Logica {

	private GUI miGUI;
	private Timer miTimer;
	private MapaGrilla miMapa;
	protected FactoryMapaGrilla miFabrica;
	protected Timer miReloj;
	
	public Logica(GUI g, FactoryMapaGrilla f) {
		miGUI = g;
		miFabrica = f;
		miMapa = miFabrica.crearMapa();
		miGUI.actualizarFondo(miMapa.getImage());
		miReloj = new Timer(this); 
	}
	
	public void actualizarReloj() {
		//Llamamos a la Gui para que el reloj se actualice. 
		this.miGUI.actualizarReloj(miReloj.getMinutos(), miReloj.getSegundos());
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
	public void realizarMovimiento() {
		
	}
}
