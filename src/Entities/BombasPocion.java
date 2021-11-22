package Entities;

import javax.swing.ImageIcon;
import Mapas.MapaGrilla;
import Visitors.Visitor;

public class BombasPocion extends Pocion{
	public boolean explosion;
	public BombasPocion(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla); 
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
