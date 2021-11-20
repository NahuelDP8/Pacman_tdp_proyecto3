package Visitors;

import Entities.Punto;
import Entities.PuntoGrande;
import Entities.BombasPocion;
import Entities.Enemigo;
import Entities.Fruta;
import Entities.Pared;
import Entities.Pocion;
import Entities.Protagonista;
import Entities.ZonaEnemigo;

public interface Visitor {
	public void visitPunto(Punto p);
	public void visitPuntoGrande(PuntoGrande p);
	public void visitEnemigo(Enemigo e);
	public void visitProtagonista(Protagonista p);
	public void visitPared(Pared p);
	public void visitFruta(Fruta f);
	public void visitPocion(Pocion p);
	public void visitBombaPocion(BombasPocion p);
	public void visitZonaEnemigo(ZonaEnemigo z);
}
