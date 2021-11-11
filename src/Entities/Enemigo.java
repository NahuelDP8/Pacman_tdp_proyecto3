package Entities;

import EnemigosStates.*;
import Visitors.Visitor;

public abstract class Enemigo extends Personaje{
	protected EstadoEnemigo miEstado; 
	protected int movimientoActual; 
	protected boolean huboColisionConPared;
	protected boolean movIzquierda; 
	protected boolean movDerecha;
	protected boolean movAbajo;
	protected boolean movArriba;
	protected final int MOVER_ABAJO = 1;	
	protected final int MOVER_ARRIBA = 2;
	protected final int MOVER_IZQUIERDA = 3;
	protected final int MOVER_DERECHA = 4;
	
	public Enemigo(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
		miEstado = new Persiguiendo(this); 
		huboColisionConPared = false; 
	}
	
	public void accept(Visitor v) {
		v.visitEnemigo(this);
	}
	
	public void changeState(EstadoEnemigo e) {
		miEstado = e;
	}
	
	public void colisionPared() {
		huboColisionConPared = true; 
	}
	
	public void noColisioPared() {
		huboColisionConPared=false; 
	}
	public boolean getColisionPared() {
		return huboColisionConPared; 
	}
	
	public void invalidarMovimiento(int movimiento) {
		if(movimiento == MOVER_ABAJO)
			movAbajo = false; 
		else if(movimiento == MOVER_ARRIBA)
			movArriba = false; 
		else if (movimiento == MOVER_IZQUIERDA)
			movIzquierda = false;
		else if (movimiento == MOVER_DERECHA)
			movDerecha = false; 
	}
	
	public void validarMovimientos() {
		movAbajo = true; 
		movArriba = true; 
		movIzquierda = true;
		movDerecha = true; 
	}
	
	abstract public void perseguirProtagonista();
	
	public int getMovimientoActual() {
		return movimientoActual; 
	} 
}
