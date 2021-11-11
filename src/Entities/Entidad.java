package Entities;

import java.awt.Shape;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Image;
import java.awt.Rectangle;
import Visitors.Visitor;

abstract public class Entidad {
	protected Shape miRectangulo;
	protected PairTupla posicion;
	protected int ancho;
	protected int altura;
	protected MapaGrilla miGrilla;
	protected Visitor v;
	protected Zona miZona;
	protected ImageIcon miImagen;
	protected EntidadGrafica miEntidad;

	public Entidad (PairTupla p, int anc,int alt, ImageIcon img, MapaGrilla grilla) {
		miGrilla = grilla;
		ancho = anc;
		altura = alt;
		posicion = p;
		miRectangulo =  new Rectangle(p.getX(), p.getY(), anc, alt); 
		miImagen = img;
		agregarEntidadGrafica();
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
	public void agregarEntidadGrafica() {
		miEntidad = new EntidadGrafica("");
		miEntidad.setBounds(posicion.getX(), posicion.getY()+155, ancho, altura);
		if(miImagen != null) {
			Image EscalarFoto = miImagen.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
			ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
			miEntidad.setIcon(FotoEscalada);
		}
		miEntidad.setVisible(true);
		miEntidad.setForeground(new Color(0, 128, 0));
		miEntidad.setBackground(Color.WHITE);
		miGrilla.aņadirEntidad(miEntidad);
	}

	public int getX() {
		return posicion.x;
	}
	public int getY() {
		return posicion.y;
	}

	public PairTupla getPos() {
		return posicion;
	}
	public void setGrilla(MapaGrilla g) {
		miGrilla = g;
	}
	
	public Visitor getVisitor() {
		return v;
	}
	abstract public void accept(Visitor v);

	public EntidadGrafica getEntidad() {
		return miEntidad;
	}
	public void setEntidad(EntidadGrafica ent) {
		miEntidad= ent;
	} 
}
