package Entities;

import javax.swing.ImageIcon;

import Visitors.Visitor;

public class Enemigo extends Personaje{

	public Enemigo(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);

	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
