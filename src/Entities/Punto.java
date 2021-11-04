package Entities;

import javax.swing.ImageIcon;

import Visitors.ProtagonistaVisitor;
import Visitors.PuntoVisitor;
import Visitors.Visitor;

public class Punto extends Mejora{

	public Punto(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
		v = new PuntoVisitor();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
}
