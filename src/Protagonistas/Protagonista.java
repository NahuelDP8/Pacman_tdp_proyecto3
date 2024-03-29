package Protagonistas;

import javax.swing.ImageIcon;

import Entities.PairTupla;
import Entities.Personaje;
import Visitors.ProtagonistaVisitor;
import Visitors.Visitor;
import Mapas.MapaGrilla; 

abstract public class Protagonista extends Personaje{
	protected int vidas;
	protected int movimientoPrevio;
	protected int puntaje;
	protected boolean colisiono;
	protected boolean comiendo;
	protected int bomba;
	protected ImageIcon imagenIzquierdaVelocidad;
	protected ImageIcon imagenDerechaVelocidad;
	protected ImageIcon imagenIzquierdaBomba;
	protected ImageIcon imagenDerechaBomba;
	protected ImageIcon imagenIzquierdaNormal;
	protected ImageIcon imagenDerechaNormal;
	
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
		bomba = 0;
	}
	
	public int protagonistaVelocidadPixel() {
		return velocidad;
	}
	
	public void realizarMovimiento() {
		
		if(movimientoActual == miGrilla.getCnsMOVER_ABAJO()) {
			posicion.setY(posicion.getY()+ velocidad);
		}else if(movimientoActual == miGrilla.getCnsMOVER_ARRIBA()) {
			posicion.setY(posicion.getY()- velocidad);
		}else if(movimientoActual == miGrilla.getCnsMOVER_IZQUIERDA()) {
			posicion.setX(posicion.getX()- velocidad);
		}else if(movimientoActual == miGrilla.getCnsMOVER_DERECHA()) {
			posicion.setX(posicion.getX()+ velocidad);
		}
		movimientoPrevio = movimientoActual;
		actualizarFoto();
		miGrilla.actualizarEntidad(this);
		miRectangulo.setBounds(posicion.getX(), posicion.getY(), ancho, altura);
	}

	public void moverAbajo() {
		movimientoPrevio = movimientoActual;
		movimientoActual = miGrilla.getCnsMOVER_ABAJO();
		miGrilla.verificarMovimientoPosible();
		colisiono = false;
	}
	public void moverArriba() {
		movimientoPrevio = movimientoActual;
		movimientoActual = miGrilla.getCnsMOVER_ARRIBA();
		miGrilla.verificarMovimientoPosible();
		colisiono = false;
	}
	public void moverIzquierda() {
		movimientoPrevio = movimientoActual;
		movimientoActual = miGrilla.getCnsMOVER_IZQUIERDA();
		miGrilla.verificarMovimientoPosible();
		colisiono = false;
	}
	public void moverDerecha() {
		movimientoPrevio = movimientoActual;
		movimientoActual = miGrilla.getCnsMOVER_DERECHA();
		miGrilla.verificarMovimientoPosible();
		colisiono = false;
	}
	public void accept(Visitor v) {
		v.visitProtagonista(this);
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
	public int getBombas() {
		return bomba;
	}
	public void agregarBomba(int b) {
		bomba += b;
		fotoBomba();
	}
	public void usarBomba() {
		bomba--;
		if(bomba == 0)
			fotoNormal();
	}

	public void setCantidadBombas(int b) {
		bomba = b; 
	}
	public void setMovimiento(int i) {
		movimientoActual = i;
	}

	public void fotoVelocidad() {
		imagenIzquierda = imagenIzquierdaVelocidad;
		imagenDerecha = imagenDerechaVelocidad;
	}
	public void fotoBomba() {
		imagenIzquierda = imagenIzquierdaBomba;
		imagenDerecha = imagenDerechaBomba;
	}
	public void fotoNormal() {
		imagenIzquierda = imagenIzquierdaNormal;
		imagenDerecha = imagenDerechaNormal;
	}
	
}
