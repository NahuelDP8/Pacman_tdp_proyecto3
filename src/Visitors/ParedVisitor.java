package Visitors;

import Entities.Enemigo;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;
import Entities.Punto;
import Entities.PuntoGrande;

public class ParedVisitor implements Visitor {

	@Override
	public void visitPunto(Punto p) {
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

}