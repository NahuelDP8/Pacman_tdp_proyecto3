package Entities;

import javax.swing.ImageIcon;

import Visitors.PocionVisitor;
import Visitors.Visitor;
import Mapas.MapaGrilla;

public class Pocion extends Mejora{

	public Pocion(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new PocionVisitor(this); 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		v.visitPocion(this);
	}

}
