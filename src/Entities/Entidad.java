package Entities;

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
	public PairTupla getPos() {
		return posicion;
	}
}
