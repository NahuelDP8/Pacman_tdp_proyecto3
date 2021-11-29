package Visitors;

import Improvements.BombasPocion;
import EnemigosGenerales.Enemigo;
import Improvements.Explosion;
import Improvements.Fruta;
import EstructurasMapas.Pared;
import Improvements.Pocion;
import Protagonistas.Protagonista;
import EstructurasMapas.PuertaEnemigo;
import Improvements.Punto;
import Improvements.PuntoGrande;
import Entities.Entidad; 
public class PuertaEnemigoVisitor implements Visitor {
	
	public PuertaEnemigoVisitor(Entidad ent) {
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