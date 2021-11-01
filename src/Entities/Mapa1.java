package Entities;

import javax.swing.ImageIcon;

import Factories.FactoryEnemigo;
import Factories.FactoryProtagonista;
import Logic.Logica;

public class Mapa1 extends MapaGrilla {
	protected int ancho;
	protected int altura;
	public Mapa1(ImageIcon fondo, FactoryProtagonista fp, FactoryEnemigo fe, int ancho, int altura,Logica log) {
		super(fondo, fp, fe, ancho, altura,log);
		for(int i =0 ; i<=3; i++) {
			for(int j = 0 ; j<=3; j++) {
				
			}
		}
	}

}
