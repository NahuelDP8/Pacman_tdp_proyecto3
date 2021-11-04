package Entities;

import Visitors.ParedVisitor;
import Visitors.Visitor;

public class Pared extends Entidad{
	public Pared(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
		v = new ParedVisitor(this);  
	}

	@Override
	public void accept(Visitor v) {
		v.visitPared(this);
	}

}
