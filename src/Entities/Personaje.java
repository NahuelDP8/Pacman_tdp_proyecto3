package Entities;

import javax.swing.ImageIcon;
import Mapas.MapaGrilla;

abstract public class Personaje extends Entidad{
	protected ImageIcon miImagen;
	protected int velocidad;
	protected int cargaPortal; 
	protected final int MOVER_ABAJO = 1;	
	protected final int MOVER_ARRIBA = 2;
	protected final int MOVER_IZQUIERDA = 3;
	protected final int MOVER_DERECHA = 4;
	
	public int getIzquierda() {
		return MOVER_IZQUIERDA;
	}
	public int getDerecha() {
		return MOVER_DERECHA;
	}
	public int getAbajo() {
		return MOVER_ABAJO;
	}
	public int getArriba() {
		return MOVER_ARRIBA;
	}
	public Personaje(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		cargaPortal = 0;
	}
	
	public int getEnergiaPortal() {
		return cargaPortal; 
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
