package Entities;

import javax.swing.ImageIcon;
import Mapas.MapaGrilla;
import Visitors.BombaVisitor;
import Visitors.Visitor;

public class BombasPocion extends Mejora{

	private final static int velocidad = 15; 
	public BombasPocion(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new BombaVisitor(this); 
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor v) {
		v.visitBombaPocion(this);
	}

	public void afectar() {
		miGrilla.comunicarControlPrincipalSpeed(velocidad);
		this.sacarEntidad(this);
	}

}
