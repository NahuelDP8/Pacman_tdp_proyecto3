package Entities;

import javax.swing.ImageIcon;
import Mapas.MapaGrilla;
import Visitors.BombaVisitor;
import Visitors.Visitor;

public class BombasPocion extends Mejora{
	public boolean explosion;
	private final static int velocidad = 15; 
	public BombasPocion(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new BombaVisitor(this); 
		explosion = false;
	}

	@Override
	public void accept(Visitor v) {
		v.visitBombaPocion(this);
	}

	public void afectar() {
		miGrilla.comunicarActivacionBomba();
		this.sacarEntidad(this);
	}

}
