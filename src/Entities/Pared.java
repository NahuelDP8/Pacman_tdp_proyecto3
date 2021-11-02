package Entities;

import Visitors.Visitor;

public class Pared extends Entidad{
	public Pared(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
