package Entities;

import javax.swing.ImageIcon;

import Visitors.PocionVisitor;
import Visitors.Visitor;

public class Pocion extends Mejora{

	public Pocion(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new PocionVisitor(this); 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
	}

}
