package Entities;

import javax.swing.ImageIcon;

import Visitors.ParedVisitor;
import Visitors.Visitor;

public class Pared extends Entidad{
	public Pared(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new ParedVisitor(this);  
	}

	public Pared(PairTupla p, int anc, int alt, MapaGrilla grilla) {
		super(p, anc, alt,null, grilla);
		v = new ParedVisitor(this);  
		
	}

	@Override
	public void accept(Visitor v) {
		v.visitPared(this);
	}

}
