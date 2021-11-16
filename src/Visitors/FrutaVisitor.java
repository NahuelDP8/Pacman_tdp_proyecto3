package Visitors;

import Entities.Enemigo;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;
import Entities.Punto;
import Entities.PuntoGrande;
import Entities.ZonaEnemigo;

public class FrutaVisitor implements Visitor {
	private Fruta miFruta;
	
	public FrutaVisitor(Fruta ent) {
		miFruta = ent;
	}
	@Override
	public void visitPunto(Punto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPuntoGrande(PuntoGrande p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitEnemigo(Enemigo e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitProtagonista(Protagonista p) {
		miFruta.afectar();
		p.sumarPuntos(miFruta.getPuntaje()); 
	}

	@Override
	public void visitPared(Pared p) {

	}

	@Override
	public void visitFruta(Fruta f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPocion(Pocion p) {
		// TODO Auto-generated method stub

	}
	@Override

	public void visitZonaEnemigo(ZonaEnemigo z) {
		// TODO Auto-generated method stub
		
	}

}
