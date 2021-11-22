package Visitors;

import Entities.BombasPocion;
import Entities.Enemigo;
import Entities.Explosion;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Portal;
import Entities.Protagonista;
import Entities.PuertaEnemigo;
import Entities.Punto;
import Entities.PuntoGrande;

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
