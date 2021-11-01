package Entities;

import javax.swing.ImageIcon;
import java.awt.Shape;
import java.awt.Rectangle;;

abstract public class Entidad {
	protected Shape miRectangulo;
	protected PairTupla posicion;
	protected int ancho;
	protected int altura;
	protected MapaGrilla miGrilla;
	protected Zona miZona;
	protected ImageIcon miImagen;

	
	public Entidad (PairTupla p, int anc,int alt) {
		ancho = anc;
		altura = alt;
		posicion = p;
		miRectangulo =  new Rectangle(p.getX(), p.getY(), anc, alt); 
	}
	
	public int getAltura() {
		return altura;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public Shape getRectangulo() {
		return miRectangulo;
	} 
	
	public void setImagen(ImageIcon miImagen) {
		this.miImagen = miImagen;
	}
	public ImageIcon getImagen() {
		return miImagen;
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
