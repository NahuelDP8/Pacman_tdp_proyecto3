package EstructurasMapas;

import javax.swing.ImageIcon;
import Entities.Entidad;
import Entities.PairTupla;
import Mapas.MapaGrilla;
import Visitors.Visitor;

abstract public class Estructura extends Entidad {

	public Estructura(PairTupla p, int anc, int alt, ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt, img, grilla);
	}
	
	public int getMovimientoActual() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int getVelocidad() {
		return 0; 
	}
	
	abstract public void accept(Visitor v);

}
