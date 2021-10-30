package Entities;

import javax.swing.ImageIcon;

import Factories.FactoryEnemigo;
import Factories.FactoryProtagonista;

public class Mapa1 extends MapaGrilla {

	public Mapa1(ImageIcon fondo, FactoryProtagonista fp, FactoryEnemigo fe) {
		super(fondo, fp, fe);
	}

}
