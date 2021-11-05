package Visitors;

import Entities.Enemigo;
import Entities.Entidad;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;
import Entities.Punto;
import Entities.PuntoGrande;

public class PuntoVisitor implements Visitor {
	private Entidad miEntidad;
	public PuntoVisitor(Entidad ent) {
		miEntidad = ent;
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
		//Cambiar dsps de singleton:
		p.sacarPunto(miEntidad);
		p.sumarPuntos(10);
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

}
