package Entities;

import Visitors.FrutaVisitor;
import Visitors.ProtagonistaVisitor;
import Visitors.Visitor;

public class Fruta extends Mejora{

	public Fruta(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
		v = new FrutaVisitor();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
