package Entities;

import javax.swing.ImageIcon;

import Mapas.MapaGrilla;
import Visitors.Visitor;

public class ZonaEnemigo extends Entidad{

	public ZonaEnemigo(PairTupla p, int anc, int alt, ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt, img, grilla);
	}

	@Override
	public void accept(Visitor v) {
		v.visitZonaEnemigo(this); 
	}

	@Override
	public int getMovimientoActual() {
		// TODO Auto-generated method stub
		return 0;
	}

}
