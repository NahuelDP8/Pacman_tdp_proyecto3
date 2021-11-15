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
		if(miPortal.cargaRequerida(e.getEnergiaPortal())) {
			e.teletransportarme(miPortal.getPosicionXDestino(), miPortal.getPosicionYDestino());
			System.out.print("MAGIA");
		}else {
			e.recargarEnergiaPortal();
		}
	}

	@Override
	public void visitProtagonista(Protagonista p) {
		if(miPortal.cargaRequerida(p.getEnergiaPortal())) {
			p.teletransportarme(miPortal.getPosicionXDestino(), miPortal.getPosicionYDestino());
			System.out.print("MAGIA");
		}else {
			p.recargarEnergiaPortal();
		}
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
