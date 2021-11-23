package Entities;

import javax.swing.ImageIcon;

import Mapas.MapaGrilla;
import Visitors.PortalVisitor;
import Visitors.Visitor;

public class Portal extends Entidad{
	protected PairTupla miDestino;
	protected int carga = 5; 
	
	public Portal(PairTupla p, int anc, int alt, ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt, img, grilla);
		v = new PortalVisitor(this); 
		miDestino = new PairTupla(0,0);
	}

	@Override
	public void accept(Visitor v) {
		
	}

	public boolean cargaRequerida(int c) {
		return carga >= c;
	}

	public void setMiDestino(int desX,int desY) {
		miDestino.setX(desX);
		miDestino.setY(desY); 
	}
	@Override
	public int getMovimientoActual() {
		return 0;
	}
	public int getPosicionXDestino() {
		return miDestino.getX();
	}
	
	public int getPosicionYDestino() {
		return miDestino.getY();
	}

	@Override
	public int getVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}
}
