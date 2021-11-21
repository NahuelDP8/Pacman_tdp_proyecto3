package Visitors;

import Entities.BombasPocion;
import Entities.Enemigo;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;
import Entities.PuertaEnemigo;
import Entities.Punto;
import Entities.PuntoGrande;

public class ProtagonistaVisitor implements Visitor {

	@Override
	public void visitPunto(Punto p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitPuntoGrande(PuntoGrande p) {
		
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		e.interactuarConProtagonista(); 
	}

	@Override
	public void visitProtagonista(Protagonista p) {
		// TODO Auto-generated method stub

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
	public void visitBombaPocion(BombasPocion p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitPuertaEnemigo(PuertaEnemigo p) {
		// TODO Auto-generated method stub
		
	}

}
