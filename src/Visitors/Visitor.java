package Visitors;

import Improvements.Punto;
import Improvements.PuntoGrande;
import Improvements.BombasPocion;
import EnemigosGenerales.Enemigo;
import Improvements.Explosion;
import Improvements.Fruta;
import EstructurasMapas.Pared;
import Improvements.Pocion;
import Protagonistas.Protagonista;
import EstructurasMapas.PuertaEnemigo;

public interface Visitor {
	public void visitPunto(Punto p);
	public void visitPuntoGrande(PuntoGrande p);
	public void visitEnemigo(Enemigo e);
	public void visitProtagonista(Protagonista p);
	public void visitPared(Pared p);
	public void visitFruta(Fruta f);
	public void visitPocion(Pocion p);
	public void visitPuertaEnemigo(PuertaEnemigo p);
	public void visitBombaPocion(BombasPocion bombasPocion);
	public void visitExplosion(Explosion p);
}
