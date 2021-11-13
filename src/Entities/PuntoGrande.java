package Entities;

import javax.swing.ImageIcon;


import Visitors.Visitor;
import Mapas.MapaGrilla; 
import Visitors.PuntoGrandeVisitor;

public class PuntoGrande extends Mejora{

	public PuntoGrande(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new PuntoGrandeVisitor(this);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
	public void sacarEntidad(Entidad ent) {
		miGrilla.restarPunto();
		miGrilla.sacarEntidad(ent);	
	}

}
