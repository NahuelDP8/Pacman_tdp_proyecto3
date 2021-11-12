package Entities;

import javax.swing.ImageIcon;

import Visitors.FrutaVisitor;
import Visitors.Visitor;
import Mapas.MapaGrilla; 
public class Fruta extends Mejora{

	public Fruta(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new FrutaVisitor(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
