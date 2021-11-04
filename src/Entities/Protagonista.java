package Entities;


import java.util.ArrayList;

import Visitors.ProtagonistaVisitor;
import Visitors.Visitor;

abstract public class Protagonista extends Personaje{
	
	protected int vidas;
	protected int movimientoActual;
	protected int movimientoPrevio;
	protected int puntaje;
	protected final int MOVER_ABAJO = 1;	
	protected final int MOVER_ARRIBA = 2;
	protected final int MOVER_IZQUIERDA = 3;
	protected final int MOVER_DERECHA = 4;
	
	public Protagonista(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
		vidas = 3;
		movimientoActual= 0;
		movimientoPrevio = 0;
		puntaje = 0;
		velocidad = 4;
		v = new ProtagonistaVisitor();
	}
	
	public void realizarMovimiento() {
		if(movimientoActual == MOVER_ABAJO) {
			posicion.setY(posicion.getY()+ velocidad);
		}else if(movimientoActual == MOVER_ARRIBA) {
			posicion.setY(posicion.getY()- velocidad);
		}else if(movimientoActual == MOVER_IZQUIERDA) {
			posicion.setX(posicion.getX()- velocidad);
		}else if(movimientoActual == MOVER_DERECHA) {
			posicion.setX(posicion.getX()+ velocidad);
		}
		movimientoPrevio = movimientoActual;
		miGrilla.actualizarProtagonista();
	}
	public void moverAbajo() {
		movimientoPrevio = movimientoActual;
		movimientoActual = MOVER_ABAJO;
		ArrayList<Zona> zonasActivasDeE = miGrilla.mapeoPosEntidadAZona(this);
		ArrayList<Entidad> entidadesColisionadasConE = miGrilla.entidadesColisionadas(zonasActivasDeE, this);
		if(entidadesColisionadasConE.size()!=0) {
			for(Entidad aux : entidadesColisionadasConE)
				this.accept(aux.getVisitor());		
		}
	}
	public void moverArriba() {
		movimientoPrevio = movimientoActual;
		movimientoActual = MOVER_ARRIBA;
		ArrayList<Zona> zonasActivasDeE = miGrilla.mapeoPosEntidadAZona(this);
		ArrayList<Entidad> entidadesColisionadasConE = miGrilla.entidadesColisionadas(zonasActivasDeE, this);
		if(entidadesColisionadasConE.size()!=0) {
			for(Entidad aux : entidadesColisionadasConE)
				this.accept(aux.getVisitor());		
		}
	}
	public void moverIzquierda() {
		movimientoPrevio = movimientoActual;
		movimientoActual = MOVER_IZQUIERDA;
		ArrayList<Zona> zonasActivasDeE = miGrilla.mapeoPosEntidadAZona(this);
		ArrayList<Entidad> entidadesColisionadasConE = miGrilla.entidadesColisionadas(zonasActivasDeE, this);
		if(entidadesColisionadasConE.size()!=0) {
			for(Entidad aux : entidadesColisionadasConE)
				this.accept(aux.getVisitor());		
		}
	}
	public void moverDerecha() {
		movimientoPrevio = movimientoActual;
		movimientoActual = MOVER_DERECHA;
		ArrayList<Zona> zonasActivasDeE = miGrilla.mapeoPosEntidadAZona(this);
		ArrayList<Entidad> entidadesColisionadasConE = miGrilla.entidadesColisionadas(zonasActivasDeE, this);
		if(entidadesColisionadasConE.size()!=0) {
			for(Entidad aux : entidadesColisionadasConE)
				this.accept(aux.getVisitor());		
		}
	}
	public void accept(Visitor v) {
		v.visitProtagonista(this);
	}
	public int getMovimientoActual() {
		return movimientoActual;
	}
	public int getMovimientoPrevio() {
		return movimientoPrevio;
	}
	public void restablecerMovimiento() {
		movimientoActual = movimientoPrevio;
	}
}
