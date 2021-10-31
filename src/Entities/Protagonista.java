package Entities;

import javax.swing.ImageIcon;

abstract public class Protagonista extends Personaje{

	protected int vidas;
	protected int movimiento;
	protected int puntaje;
	protected int velocidad;
	
	public Protagonista(PairTupla p, int anc, int alt,Zona zona) {
		super(p, anc, alt,zona);
		vidas = 3;
		movimiento = 0;
		puntaje = 0;
		velocidad = 4;
	}
	
	public void realizarMovimiento() {
		if(movimiento == 1)
			posicion.setY(posicion.getY()+ velocidad);
		else if(movimiento == 2)
			posicion.setY(posicion.getY()- velocidad);
		else if(movimiento == 3)
			posicion.setX(posicion.getX()- velocidad);
		else if(movimiento == 4)
			posicion.setX(posicion.getX()+ velocidad);
		miGrilla.actualizarProtagonista();
	}
	public void moverAbajo() {
		movimiento = 1; //Decimos que continue moviendose en esa direccion.
	}
	public void moverArriba() {
		movimiento = 2; //Decimos que continue moviendose en esa direccion.
	}
	public void moverIzquierda() {
		movimiento = 3; //Decimos que continue moviendose en esa direccion.
	}
	public void moverDerecha() {
		movimiento = 4; //Decimos que continue moviendose en esa direccion.
	}


}
