package Entities;

import javax.swing.ImageIcon;

abstract public class Mejora extends Entidad{
	public Mejora(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
	}

	protected int miPuntaje;
}
