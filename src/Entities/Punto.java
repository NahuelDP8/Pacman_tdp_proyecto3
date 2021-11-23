package Entities;

import javax.swing.ImageIcon;

import Visitors.PuntoVisitor;
import Visitors.Visitor;
import Mapas.MapaGrilla; 
public class Punto extends Mejora{

	public Punto(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new PuntoVisitor(this);
		// TODO Auto-generated constructor stub
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
