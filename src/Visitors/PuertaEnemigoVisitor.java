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

public class PuertaEnemigoVisitor implements Visitor {
	private Entidad miEntidad;
	
	public PuertaEnemigoVisitor(Entidad ent) {
		miEntidad = ent;
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
		e.colisionarPuertaEnemigo();
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