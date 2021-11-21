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
		/*
		//Cambiar dsps de singleton:
		miEntidad.enemigosEnPeligro();
		miEntidad.sacarEntidad(miEntidad);
		p.sumarPuntos(50);
		 */
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
