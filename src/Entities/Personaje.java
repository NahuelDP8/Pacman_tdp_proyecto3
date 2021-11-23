package Entities;

import javax.swing.ImageIcon;

import Logic.Logica;
import Mapas.MapaGrilla;

abstract public class Personaje extends Entidad{
	protected ImageIcon miImagen;
	protected int velocidad;
	protected int cargaPortal; 
	protected int movimientoActual; 
	protected ImageIcon imagenIzquierda;
	protected ImageIcon imagenDerecha;
	
	public ImageIcon getImage() {
		ImageIcon img = null;
		if(movimientoActual == Logica.getLogica().getCnsMOVER_IZQUIERDA() || movimientoActual == 0)
			img = imagenIzquierda;
		else if(movimientoActual == Logica.getLogica().getCnsMOVER_DERECHA())
			img = imagenDerecha;
		else 
			img = miImagen;
		return img;
	}
	
	public int getIzquierda() {
		return Logica.getLogica().getCnsMOVER_IZQUIERDA();
	}
	public int getDerecha() {
		return Logica.getLogica().getCnsMOVER_DERECHA();
	}
	public int getAbajo() {
		return Logica.getLogica().getCnsMOVER_ABAJO();
	}
	public int getArriba() {
		return Logica.getLogica().getCnsMOVER_ARRIBA(); 
	}
	public int getVelocidad() {
		return velocidad;
	}
	public Personaje(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		cargaPortal = 0;
	}
	
	public int getEnergiaPortal() {
		return cargaPortal; 
	}
	
	public void actualizarFoto() {
		miImagen = getImage();
		miEntidad.setIcon(miImagen);
	}
	
	public void recargarEnergiaPortal() {
		cargaPortal++; 
	}
	public void teletransportarme(int x, int y) {
		cargaPortal = 0;
		posicion.setX(x);
		posicion.setY(y);
		miGrilla.actualizarEntidad(this);
	}
}
