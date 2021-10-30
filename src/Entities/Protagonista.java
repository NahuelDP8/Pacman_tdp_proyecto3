package Entities;

abstract public class Protagonista extends Personaje{

	protected int vidas;
	protected int movimiento;
	protected int puntaje;
	protected int velocidad;
	
	public Protagonista() {
		vidas = 3;
		movimiento = 0;
		puntaje = 0;
		velocidad = 3;
	}
	
	public void realizarMovimiento() {
		if(movimiento == 1)
			moverAbajo();
		else if(movimiento == 2)
			moverArriba();
		else if(movimiento == 3)
			moverIzquierda();
		else if(movimiento == 4)
			moverDerecha();
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
