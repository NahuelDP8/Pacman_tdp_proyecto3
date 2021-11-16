package Entities;

import javax.swing.ImageIcon;

import Visitors.FrutaVisitor;
import Visitors.Visitor;
import Mapas.MapaGrilla; 
public class Fruta extends Mejora{

	private final static int miPuntaje = 300; 

	public Fruta(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		v = new FrutaVisitor(this);
	}

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
	
	public int miPuntaje() {
		return miPuntaje;
	}

	public void afectar() {
		sacarEntidad(this); 
	}

	public int getPuntaje() {
		return miPuntaje;
	}

}
