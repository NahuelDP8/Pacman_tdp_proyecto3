package Visitors;

import Entities.BombasPocion;
import Entities.Enemigo;
import Entities.Entidad;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;
import Entities.PuertaEnemigo;
import Entities.Punto;
import Entities.PuntoGrande;

public class EnemigoVisitor implements Visitor {
	private Entidad miEntidad;
	public EnemigoVisitor(Entidad ent) {
		miEntidad = ent;
	}
	@Override
	public void visitEnemigo(Enemigo e) {
		
	}
	
	@Override
	public void visitProtagonista(Protagonista p) {
		miEntidad.interactuarConProtagonista(); 
	}

	@Override
	public void visitPared(Pared p) {
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
	public void visitPunto(Punto p) {}

	@Override
	public void visitPuntoGrande(PuntoGrande p) {}
	
	@Override
	public void visitBombaPocion(BombasPocion p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void visitPuertaEnemigo(PuertaEnemigo p) {
		// TODO Auto-generated method stub
		
	}

}
