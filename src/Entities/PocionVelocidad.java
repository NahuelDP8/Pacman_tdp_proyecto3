package Entities;

import javax.swing.ImageIcon;

import Visitors.Visitor;
import Mapas.MapaGrilla;

public class PocionVelocidad extends Pocion{
	private final static int velocidad = 15; 
	public PocionVelocidad(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
	}

	@Override
	public void accept(Visitor v) {
		v.visitPocion(this);
	}

	public void afectar() {
		miGrilla.comunicarControlPrincipalSpeed(velocidad);
		this.sacarEntidad(this);
	}

	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
