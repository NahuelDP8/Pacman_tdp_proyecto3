package Entities;

import javax.swing.ImageIcon;
import Visitors.ProtagonistaVisitor;
import Visitors.Visitor;
import Mapas.MapaGrilla; 

abstract public class Protagonista extends Personaje{
	protected int vidas;
	protected int movimientoPrevio;
	protected int puntaje;
	protected boolean colisiono;
	protected boolean comiendo;
	protected boolean bomba;
	
	public Protagonista(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		vidas = 3;
		movimientoActual= 0;
		movimientoPrevio = 0;
		puntaje = 0;
		velocidad = 4;
		v = new ProtagonistaVisitor();
		colisiono = false;
		comiendo = false;
	}
	
	public int protagonistaVelocidadPixel() {
		return velocidad;
	}
	
	public void realizarMovimiento() {
		if(movimientoActual == MOVER_ABAJO) {
			posicion.setY(posicion.getY()+ velocidad);
			System.out.println("BASURA");
		}else if(movimientoActual == MOVER_ARRIBA) {
			posicion.setY(posicion.getY()- velocidad);
		}else if(movimientoActual == MOVER_IZQUIERDA) {
			posicion.setX(posicion.getX()- velocidad);
		}else if(movimientoActual == MOVER_DERECHA) {
			posicion.setX(posicion.getX()+ velocidad);
		}
		movimientoPrevio = movimientoActual;
		actualizarFoto();
		miGrilla.actualizarEntidad(this);
		miRectangulo.setBounds(posicion.getX(), posicion.getY(), ancho, altura);
	}

	public void moverAbajo() {
		movimientoPrevio = movimientoActual;
		movimientoActual = MOVER_ABAJO;
		miGrilla.verificarMovimientoPosible();
		colisiono = false;
	}
	public void moverArriba() {
		movimientoPrevio = movimientoActual;
		movimientoActual = MOVER_ARRIBA;
		miGrilla.verificarMovimientoPosible();
		colisiono = false;
	}
	public void moverIzquierda() {
		movimientoPrevio = movimientoActual;
		movimientoActual = MOVER_IZQUIERDA;
		miGrilla.verificarMovimientoPosible();
		colisiono = false;
	}
	public void moverDerecha() {
		movimientoPrevio = movimientoActual;
		movimientoActual = MOVER_DERECHA;
		miGrilla.verificarMovimientoPosible();
		colisiono = false;
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
		colisiono = true;
	}
	public boolean getColisiono() {
		return colisiono;
	}
	public void setColisiono(boolean colision) {
		colisiono = colision;
	}

	public void sumarPuntos(int i) {
		puntaje += i;
		miGrilla.actualizarPuntos(puntaje);	
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	public void quitarVida() {
		if(vidas==1) {
			vidas = 0;
			miGrilla.gameOver(); 
		}else {
			vidas--;
		}
	}

	public boolean getComiendo() {
		return comiendo;
	}
	public void setComiendo(boolean comer) {
		comiendo  = comer;
	}

	public void iniciarProcesoMovimiento() {
		miGrilla.verificacionesPreMovimientoProtagonista();
	}
	public boolean getBomba() {
		return bomba;
	}
	public void setBomba(boolean b) {
		bomba = b;
	}
	
}
