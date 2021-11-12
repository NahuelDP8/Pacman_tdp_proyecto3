package Entities;

import javax.swing.ImageIcon;
import Mapas.MapaGrilla;

abstract public class Personaje extends Entidad{
	protected ImageIcon miImagen;
	protected int velocidad;
	public Personaje(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
	}
}
