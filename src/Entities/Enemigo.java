package Entities;

import EnemigosStates.*;
import Visitors.EnemigoVisitor;
import Visitors.Visitor;

import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import Mapas.MapaGrilla;

public abstract class Enemigo extends Personaje{
	protected EstadoEnemigo miEstado; 
	protected int movimientoActual; 
	protected boolean huboColisionConPared;
	protected boolean movIzquierda; 
	protected boolean movDerecha;
	protected boolean movAbajo;
	protected boolean movArriba;
	
	public Enemigo(PairTupla p, int anc, int alt, ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla );
		miEstado = new Persiguiendo(this); 
		huboColisionConPared = false;
		velocidad = 4; 
		v = new EnemigoVisitor(this);
		movimientoActual = 4;
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
	
	public void realizarMovimiento(int mov) {
		if(mov == MOVER_ABAJO) {
			posicion.setY(posicion.getY()+ velocidad);
		}else if(mov == MOVER_ARRIBA) {
			posicion.setY(posicion.getY()- velocidad);
		}else if(mov == MOVER_IZQUIERDA) {
			posicion.setX(posicion.getX()- velocidad);
		}else if(mov == MOVER_DERECHA) {
			posicion.setX(posicion.getX()+ velocidad);
		} 
		miRectangulo.setBounds(posicion.getX(), posicion.getY(), ancho, altura);
		miGrilla.actualizarEntidad(this);
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
	
	public void moverme() {
		miEstado.realizarMovimiento();
	}
	
	public int getMovimientoActual() {
		return movimientoActual; 
	} 
	public void deboEscapar() {
		miEstado.deboEscapar(); 
	}
	
	public void deboPerseguir() {
		miEstado.deboPerseguir();
	}
	
	protected double distanciaEntrePuntos(PairTupla A, PairTupla B) {
		double x = Math.pow(B.getX()-A.getX(),2);
		double y = Math.pow(B.getY()-A.getY(),2);
		double distancia = Math.sqrt(x+y); 
		return distancia; 
	}
	
	//Todos los enemigos a priori, tendrán el mismo mecanismo de escape, dependiendo de la posición de pacman 
	public void realizarEscape() {
		int movFinal = movimientoActual;
		double disMayor = Double.MIN_VALUE;
		double disAux = 0;
		int posX = posicion.getX();
		int posY = posicion.getY(); 
		PairTupla posicionProtagonista = miGrilla.getPosicionActualProtagonista();
		ArrayList<Integer> movimientos = new ArrayList<Integer>(); 
		movimientos.add(MOVER_ARRIBA);
		movimientos.add(MOVER_ABAJO);
		movimientos.add(MOVER_IZQUIERDA);
		movimientos.add(MOVER_DERECHA); 
		
		miGrilla.realizarMovimientoFantasma(this, movimientos);
		
		for(int i =0; i<=movimientos.size()-1; i++) {	
			int movAux = movimientos.get(i); 
			if(movAux == MOVER_DERECHA && movDerecha) {
				disAux = distanciaEntrePuntos(new PairTupla(posX+ velocidad, posY),posicionProtagonista);
				if(disAux>=disMayor) {
					disMayor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux == MOVER_IZQUIERDA && movIzquierda) {
				disAux = distanciaEntrePuntos(new PairTupla(posX-velocidad, posY),posicionProtagonista);
				if(disAux>=disMayor) {
					disMayor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux== MOVER_ARRIBA && movArriba) {
				disAux = distanciaEntrePuntos(new PairTupla(posX, posY-velocidad),posicionProtagonista);
				if(disAux>=disMayor) {
					disMayor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux == MOVER_ABAJO && movAbajo) {
				disAux = distanciaEntrePuntos(new PairTupla(posX, posY+velocidad),posicionProtagonista);
				if(disAux>=disMayor) {
					disMayor= disAux; 
					movFinal = movAux;
				}
			}
		}
		this.validarMovimientos();
		//Ahora lo que hacemos es movernos
		this.realizarMovimiento(movFinal);
		movimientoActual = movFinal; 
	}

	public void interactuarConProtagonista() {
		miEstado.interactuarConProtagonista(); 
	}

	public void notificarMuerteProtagonista() {
		miGrilla.protagonistaPierdeVida(); 
	}

	public void retornarZonaEnemigo() {
		int movFinal = movimientoActual;
		double disMenor = Double.MAX_VALUE;
		double disAux = 0;
		int posX = posicion.getX();
		int posY = posicion.getY(); 
		PairTupla posicionCelda = new PairTupla(229,186);
		ArrayList<Integer> movimientos = new ArrayList<Integer>(); 
		movimientos.add(MOVER_ARRIBA);
		movimientos.add(MOVER_ABAJO);
		movimientos.add(MOVER_IZQUIERDA);
		movimientos.add(MOVER_DERECHA); 
		
		miGrilla.realizarMovimientoFantasma(this, movimientos);
		
		if(posX == posicionCelda.getX() && posY == posicionCelda.getY())
			changeState(new Persiguiendo(this));
		else {
			
			for(int i =0; i<=movimientos.size()-1; i++) {	
				int movAux = movimientos.get(i); 
				if(movAux == MOVER_DERECHA && movDerecha) {
					disAux = distanciaEntrePuntos(new PairTupla(posX+ velocidad, posY),posicionCelda);
					if(disAux<=disMenor) {
						disMenor= disAux; 
						movFinal = movAux;
					}
				}else if(movAux == MOVER_IZQUIERDA && movIzquierda) {
					disAux = distanciaEntrePuntos(new PairTupla(posX-velocidad, posY),posicionCelda);
					if(disAux<=disMenor) {
						disMenor= disAux; 
						movFinal = movAux;
					}
				}else if(movAux== MOVER_ARRIBA && movArriba) {
					disAux = distanciaEntrePuntos(new PairTupla(posX, posY-velocidad),posicionCelda);
					if(disAux<=disMenor) {
						disMenor= disAux; 
						movFinal = movAux;
					}
				}else if(movAux == MOVER_ABAJO && movAbajo) {
					disAux = distanciaEntrePuntos(new PairTupla(posX, posY+velocidad),posicionCelda);
					if(disAux<=disMenor) {
						disMenor= disAux; 
						movFinal = movAux;
					}
				}
			}
		}
		this.validarMovimientos();
		//Ahora lo que hacemos es movernos
		this.realizarMovimiento(movFinal);
		movimientoActual = movFinal; 
	}
}
