package Visitors;

import Entities.Enemigo;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Portal;
import Entities.Protagonista;
import Entities.Punto;
import Entities.PuntoGrande;
import Entities.ZonaEnemigo;

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
	public void visitZonaEnemigo(ZonaEnemigo z) {
		// TODO Auto-generated method stub
		
	}

}
