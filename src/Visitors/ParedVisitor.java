package Visitors;

import Entities.BombasPocion;
import Entities.Enemigo;
import Entities.Entidad;
import Entities.Explosion;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;
import Entities.PuertaEnemigo;
import Entities.Punto;
import Entities.PuntoGrande;

public class ParedVisitor implements Visitor {
	
	public ParedVisitor(Entidad ent) {
	}
	
	@Override
	public void visitPunto(Punto p) {
	}

	@Override
	public void visitPuntoGrande(PuntoGrande p) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visitEnemigo(Enemigo e) {
		e.colisionPared();
	}

	@Override
	public void visitProtagonista(Protagonista p) {
		p.restablecerMovimiento();
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

	@Override
	public void visitExplosion(Explosion p) {
		// TODO Auto-generated method stub
		
	}


}
