
package Entities;

import javax.swing.ImageIcon;
import Visitors.PuertaEnemigoVisitor;
import Visitors.Visitor;
import Mapas.MapaGrilla;

public class PuertaEnemigo extends Estructura{
	public PuertaEnemigo(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new PuertaEnemigoVisitor(this);  
	}

	public PuertaEnemigo(PairTupla pairTupla, int i, int j, MapaGrilla mapa) {
		super(pairTupla, i,j,null,mapa);	
		v = new PuertaEnemigoVisitor(this); 
	}

	@Override
	public void accept(Visitor v) {
		v.visitPuertaEnemigo(this);
	}

	@Override
	public int getMovimientoActual() {
		return 0;
	}

}
