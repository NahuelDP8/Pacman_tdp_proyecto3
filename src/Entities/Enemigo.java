package Entities;

import Visitors.Visitor;

public class Enemigo extends Personaje{

	public Enemigo(PairTupla p, int anc, int alt) {
		super(p, anc, alt);

	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
