package Improvements;

import javax.swing.ImageIcon;

import Entities.Entidad;
import Entities.PairTupla;
import Visitors.Visitor;
import Mapas.MapaGrilla; 
import Visitors.PuntoGrandeVisitor;

public class PuntoGrande extends Mejora{
	protected static final int puntaje  = 50;  
	public PuntoGrande(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new PuntoGrandeVisitor(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPuntoGrande(this);
	
	}
	
	public void sacarEntidad(Entidad ent) {
		miGrilla.restarPunto();
		miGrilla.sacarEntidad(ent);
	}

	public void afectar() {
		miGrilla.comunicarControlPowerPellet(); 
		sacarEntidad(this);
	}
	
	public int getPuntaje() {
		return puntaje; 
	}
}
