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
}
