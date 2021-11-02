package Entities;

import javax.swing.ImageIcon;

abstract public class Personaje extends Entidad{
	protected ImageIcon miImagen;

	public Personaje(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
	}
}
