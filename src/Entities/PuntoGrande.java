package Entities;

import Visitors.PuntoGrandeVisitor;
import Visitors.PuntoVisitor;
import Visitors.Visitor;

public class PuntoGrande extends Mejora{

	public PuntoGrande(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
		v = new PuntoGrandeVisitor(this);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
