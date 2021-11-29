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
import EstructurasMapas.Portal;

public class PortalVisitor implements Visitor{
	protected Portal miPortal;
	
	public PortalVisitor(Portal p) {
		miPortal = p;
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
		int x = e.getX();
		int y = e.getY();
		if(miPortal.getPosicionXDestino() != 0)
			x = miPortal.getPosicionXDestino();
		if(miPortal.getPosicionYDestino() != 0)
			y = miPortal.getPosicionYDestino();
		e.teletransportarme(x,y);
	}

	@Override
	public void visitProtagonista(Protagonista p) {
		int x = p.getX();
		int y = p.getY();
		if(miPortal.getPosicionXDestino() != 0)
			x = miPortal.getPosicionXDestino();
		if(miPortal.getPosicionYDestino() != 0)
			y = miPortal.getPosicionYDestino();
		p.teletransportarme(x,y);
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
