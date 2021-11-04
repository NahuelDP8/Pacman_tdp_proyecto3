package Entities;

import Visitors.PocionVisitor;
import Visitors.Visitor;

public class Pocion extends Mejora{

	public Pocion(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
		v = new PocionVisitor(); 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
	}

}
