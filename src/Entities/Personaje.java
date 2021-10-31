package Entities;

import javax.swing.ImageIcon;

abstract public class Personaje extends Entidad{
	protected ImageIcon miImagen;

	public Personaje(PairTupla p, int anc, int alt,Zona zona) {
		super(p, anc, alt,zona);
	}
	
	public void setImagen(ImageIcon miImagen) {
		this.miImagen = miImagen;
	}
	public ImageIcon getImagen() {
		return miImagen;
	}
}
