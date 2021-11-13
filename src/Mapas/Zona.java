package Mapas;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.ArrayList;

import Entities.Entidad;
import Entities.PairTupla;

public class Zona {
	protected PairTupla posicionEnMatriz;
	protected ArrayList<Entidad> misEntidades;
	protected Shape miRectangulo;
	protected int idZona;
	protected int ancho;
	protected int alto;
	
	public Zona(int id, PairTupla p, int an,int al) {
		misEntidades = new ArrayList<Entidad>();
		posicionEnMatriz = p;
		idZona = id;
		ancho = an;
		alto = al;
		miRectangulo =  new Rectangle(p.getX(), p.getY(), an, al);
	}
	public ArrayList<Entidad> obtenerEntidades(){
		return misEntidades;
	}
	public void setEntidad(Entidad nueva) {
		misEntidades.add(nueva);
	}
	public ArrayList<Entidad> getEntidades() {
		return misEntidades;
	}
	public int getAncho() {
		return ancho;
	}
	public int getAlto() {
		return alto;
	}
	public int getX(){
		return posicionEnMatriz.getX();
	}
	public int getY(){
		return posicionEnMatriz.getY();
	}
	public void realizarColisiones() {
		
	}
	public Shape getRectangulo() {
		return miRectangulo;
	}
	public void remove(Entidad e) {
		misEntidades.remove(e);
		
	}
}
