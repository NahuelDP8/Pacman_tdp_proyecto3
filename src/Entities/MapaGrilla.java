package Entities;

import javax.swing.ImageIcon;

import Factories.FactoryEnemigo;
import Factories.FactoryProtagonista;

public class MapaGrilla {
	protected ImageIcon miFondo;
	protected FactoryProtagonista fabricaProt;
	protected FactoryEnemigo fabricaEnem;
	protected Protagonista miProtagonista;
	
	public MapaGrilla(ImageIcon fondo,FactoryProtagonista fp, FactoryEnemigo fe) {
		miFondo = fondo;
		fabricaProt = fp;
		fabricaEnem = fe;
	}
	
	public ImageIcon getImage() {
		return miFondo;
	}
	
	public void moverProtagonistaAbajo() {
		miProtagonista.moverAbajo();
	}
	public void moverProtagonistaArriba() {
		miProtagonista.moverArriba();
	}
	public void moverProtagonistaDerecha() {
		miProtagonista.moverDerecha();
	}
	public void moverProtagonistaIzquierda() {
		miProtagonista.moverIzquierda();
	}
}
