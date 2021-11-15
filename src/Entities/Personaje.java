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
