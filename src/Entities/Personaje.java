package Entities;

import javax.swing.ImageIcon;

abstract public class Personaje extends Entidad{
	protected ImageIcon miImagen;
	protected int velocidad;
	public Personaje(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
	}
}
