package Visitors;

import Entities.Punto;
import Entities.PuntoGrande;
import Entities.Enemigo;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;

public interface Visitor {
	public void visitPunto(Punto p);
	public void visitPuntoGrande(PuntoGrande p);
	public void visitEnemigo(Enemigo e);
	public void visitProtagonista(Protagonista p);
	public void visitPared(Pared p);
	public void visitFruta(Fruta f);
	public void visitPocion(Pocion p);
}