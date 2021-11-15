package Visitors;

import Entities.Enemigo;
import Entities.Entidad;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;
import Entities.Punto;
import Entities.ZonaEnemigo;
import Entities.PuntoGrande;

public class PuntoGrandeVisitor implements Visitor {

	private PuntoGrande miPuntoGrande;
	public PuntoGrandeVisitor(PuntoGrande ent) {
		miPuntoGrande = ent;
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
		
	}

	@Override
	public void visitProtagonista(Protagonista p) {
		miPuntoGrande.afectar(); 
		p.sumarPuntos(miPuntoGrande.getPuntaje());
	}

	@Override
	public void visitPared(Pared p) {
		// TODO Auto-generated method stub

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
