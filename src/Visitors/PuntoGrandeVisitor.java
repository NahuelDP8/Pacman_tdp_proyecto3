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
		p.setComiendo(true);
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
