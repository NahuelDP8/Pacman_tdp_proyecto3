package Entities;

import javax.swing.ImageIcon;

abstract public class Entidad {
	protected PairTupla posicion;
	protected int ancho;
	protected int altura;
	protected MapaGrilla miGrilla;
	
	public Entidad (PairTupla p, int anc,int alt) {
		ancho = anc;
		altura = alt;
		posicion = p;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	
	//verificar abajo sacar?
	public int getX() {
		return posicion.x;
	}
	public int getY() {
		return posicion.y;
	}
	// verificar arriba de esto
	public PairTupla getPos() {
		return posicion;
	}
	public void setGrilla(MapaGrilla g) {
		miGrilla = g;
	}
}
