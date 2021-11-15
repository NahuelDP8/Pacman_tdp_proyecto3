
package Entities;

import javax.swing.ImageIcon;
import Visitors.ParedVisitor;
import Visitors.Visitor;
import Mapas.MapaGrilla;

public class Pared extends Entidad{
	public Pared(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new ParedVisitor(this);  
	}

	public Pared(PairTupla pairTupla, int i, int j, MapaGrilla mapa) {
		super(pairTupla, i,j,null,mapa);	
		v = new ParedVisitor(this); 
	}

	@Override
	public void accept(Visitor v) {
		v.visitPared(this);
	}

	@Override
	public int getMovimientoActual() {
		return 0;
	}

}
