package Entities;

import javax.swing.ImageIcon;
import Mapas.MapaGrilla; 

abstract public class Mejora extends Entidad{

	protected int miPuntaje; 
	
	public Mejora(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
	}
	
	public int getMovimientoActual() {
		return 0; 
	}
	
	public int getVelocidad() {
		return 0; 
	}
}
