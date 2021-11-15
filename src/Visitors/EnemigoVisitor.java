package Visitors;

import Entities.Enemigo;
import Entities.Entidad;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;
import Entities.Punto;
import Entities.PuntoGrande;
import Entities.ZonaEnemigo;

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
		//Acá no estoy seguro, no me queda otra que poner un método abstracto en entidad 
		//Debería estar interactuarConEnemigo(); 
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
	
	public void visitZonaEnemigo(ZonaEnemigo z) {
		// TODO Auto-generated method stub
	}

}
