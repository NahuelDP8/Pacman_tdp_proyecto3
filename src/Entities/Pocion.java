package Entities;

import javax.swing.ImageIcon;

import Visitors.PocionVisitor;
import Visitors.Visitor;
import Mapas.MapaGrilla;

public abstract class Pocion extends Mejora{
	public Pocion(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new PocionVisitor(this); 
	}

	@Override
	public abstract void accept(Visitor v);

	public abstract void afectar();

}
