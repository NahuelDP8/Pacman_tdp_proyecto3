package Entities;


import Visitors.ProtagonistaVisitor;
import Visitors.Visitor;

abstract public class Protagonista extends Personaje{
	
	protected int vidas;
	protected int movimiento;
	protected int puntaje;
	protected int velocidad;
	protected final int MOVER_ABAJO = 1;	
	protected final int MOVER_ARRIBA = 2;
	protected final int MOVER_IZQUIERDA = 3;
	protected final int MOVER_DERECHA = 4;
	
	public Protagonista(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
		vidas = 3;
		movimiento = 0;
		puntaje = 0;
		velocidad = 4;
		v = new ProtagonistaVisitor();
	}
	
	public void realizarMovimiento() {
		if(movimiento == MOVER_ABAJO) {
			posicion.setY(posicion.getY()+ velocidad);
		}else if(movimiento == MOVER_ARRIBA) {
			posicion.setY(posicion.getY()- velocidad);
		}else if(movimiento == MOVER_IZQUIERDA) {
			posicion.setX(posicion.getX()- velocidad);
		}else if(movimiento == MOVER_DERECHA) {
			posicion.setX(posicion.getX()+ velocidad);
		}
		miGrilla.actualizarProtagonista();
	}
	public void moverAbajo() {
		movimiento = MOVER_ABAJO; //Decimos que continue moviendose en esa direccion.
	}
	public void moverArriba() {
		movimiento = MOVER_ARRIBA; //Decimos que continue moviendose en esa direccion.
	}
	public void moverIzquierda() {
		movimiento = MOVER_IZQUIERDA; //Decimos que continue moviendose en esa direccion.
	}
	public void moverDerecha() {
		movimiento = MOVER_DERECHA; //Decimos que continue moviendose en esa direccion.
	}
	public void accept(Visitor v) {
		v.visitProtagonista(this);
	}
}
