package Entities;

import javax.swing.ImageIcon;

import Mapas.MapaGrilla;
import Visitors.ExplosionVisitor;
import Visitors.PortalVisitor;
import Visitors.Visitor;

public class Explosion extends Entidad{
	private boolean explotando;
	public Explosion(PairTupla p, int anc, int alt, ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt, img, grilla);
		v = new ExplosionVisitor(this); 
		explotando = false;
	}

	@Override
	public void accept(Visitor v) {
		
	}

	@Override
	public int getMovimientoActual() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void crearExplosion() {
		explotando = true;
		posicion.setX(posicion.getX()-20);
		posicion.setY(posicion.getY()-20);
		ancho += 40;
		altura += 40;
		miRectangulo.setBounds(posicion.getX(), posicion.getY(), ancho, altura);
	}

	public void pararExplosion() {
		explotando = false;
		sacarEntidad(this);
		
	}

	public boolean getExplotando() {
		// TODO Auto-generated method stub
		return explotando;
	}
}
