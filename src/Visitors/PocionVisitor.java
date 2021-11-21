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

public class PocionVisitor implements Visitor {
	private Pocion miPocion;
	public PocionVisitor(Pocion ent) {
		miPocion = ent;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void visitProtagonista(Protagonista p) {
		miPocion.afectar(); 
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
