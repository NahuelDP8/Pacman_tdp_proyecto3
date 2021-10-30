package Entities;

import javax.swing.ImageIcon;

import Factories.FactoryEnemigo;
import Factories.FactoryProtagonista;

public class Mapa1 extends MapaGrilla {
	protected int ancho;
	protected int altura;
	public Mapa1(ImageIcon fondo, FactoryProtagonista fp, FactoryEnemigo fe, int ancho, int altura) {
		super(fondo, fp, fe, ancho, altura);
		for(int i =0 ; i<=3; i++) {
			for(int j = 0 ; j<=3; j++) {
				
			}
		}
	}

}
