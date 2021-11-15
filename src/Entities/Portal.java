package Entities;

import javax.swing.ImageIcon;

import Mapas.MapaGrilla;
import Visitors.PortalVisitor;
import Visitors.Visitor;

public class Portal extends Entidad{
	protected Portal miDestino;
	protected int carga = 5; 
	
	public Portal(PairTupla p, int anc, int alt, ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt, img, grilla);
		v = new PortalVisitor(this); 
	}

	@Override
	public void accept(Visitor v) {
		
	}

	public boolean cargaRequerida(int c) {
		return false;
	}

	public void setMiDestino(Portal des) {
		miDestino = des; 
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
}
