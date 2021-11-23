package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Mapas.MapaGrilla;
import Visitors.ExplosionVisitor;
import Visitors.Visitor;

public class Explosion extends Mejora{
	private boolean explotando;
	private ImageIcon imagenExplosion;
	public Explosion(PairTupla p, int anc, int alt, ImageIcon img,ImageIcon img2, MapaGrilla grilla) {
		super(p, anc, alt, img, grilla);
		imagenExplosion = img2;
		v = new ExplosionVisitor(this); 
		explotando = false;
	}

	@Override
	public void accept(Visitor v) {
		v.visitExplosion(this);
	}

	@Override
	public int getMovimientoActual() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void crearExplosion() {
		explotando = true;
		posicion.setX(posicion.getX()-50);
		posicion.setY(posicion.getY()-50);
		ancho += 100;
		altura += 100;
		miRectangulo.setBounds(posicion.getX(), posicion.getY(), ancho, altura);
		
		Image EscalarFoto = imagenExplosion.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		miEntidad.setIcon(FotoEscalada);
		miEntidad.setBounds(posicion.getX(), posicion.getY(), ancho, altura);
		
		miGrilla.actualizarEntidad(this);
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
