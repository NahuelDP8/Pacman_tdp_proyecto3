package Entities;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Mapas.MapaGrilla;

public class EnemigoRosa extends Enemigo{

	public EnemigoRosa(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,posR, posS);
		// TODO Auto-generated constructor stub
	}
	
	public void perseguirProtagonista() {
		int movFinal = movimientoActual;
		double disMenor = Double.MAX_VALUE;
		double disAux = 0;
		int posX = posicion.getX();
		int posY = posicion.getY(); 
		PairTupla posicionProtagonista = miGrilla.getPosicionActualProtagonista();
		int movimientoProtagonista = miGrilla.getMovimientoProtagonista();
		int anchoProtagonista = miGrilla.getAnchoProtagonista();
		//Pinky persigue una posicion adelante del protagonista.
		PairTupla posicionAEstudiar = posicionAEstudiar(posicionProtagonista,movimientoProtagonista,anchoProtagonista);
		
		ArrayList<Integer> movimientos = this.movimientosAEstudiar();
		miGrilla.realizarMovimientoFantasma(this, movimientos);
		
		for(int i =0; i<=movimientos.size()-1; i++) {	
			int movAux = movimientos.get(i); 
			if(movAux == MOVER_DERECHA && movDerecha) {
				disAux = distanciaEntrePuntos(new PairTupla(posX+ velocidad, posY),posicionAEstudiar);
				if(disAux<=disMenor) {
					disMenor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux == MOVER_IZQUIERDA && movIzquierda) {
				disAux = distanciaEntrePuntos(new PairTupla(posX-velocidad, posY),posicionAEstudiar);
				if(disAux<=disMenor) {
					disMenor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux== MOVER_ARRIBA && movArriba) {
				disAux = distanciaEntrePuntos(new PairTupla(posX, posY-velocidad),posicionAEstudiar);
				if(disAux<=disMenor) {
					disMenor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux == MOVER_ABAJO && movAbajo) {
				disAux = distanciaEntrePuntos(new PairTupla(posX, posY+velocidad),posicionAEstudiar);
				if(disAux<=disMenor) {
					disMenor= disAux; 
					movFinal = movAux;
				}
			}
		}
		
		//Ahora lo que hacemos es movernos
		this.realizarMovimiento(movFinal);
		movimientoActual = movFinal; 
		
		//al finalizar siempre debemos setear nuevamente como válidas a todas las posiciones válidas
	}

	
	//Pinky persigue una posición adelante del Protagonista (la posición dos veces su ancho delante del mismo), exceptuando cuando el protagonista va hacia arriba.
	private PairTupla posicionAEstudiar(PairTupla pos, int movimiento, int ancho) {
		int x = pos.getX();
		int y = pos.getY();
		
		
		
		if(movimiento == MOVER_IZQUIERDA) {
			pos.setX(x-ancho*2);
		}else if(movimiento == MOVER_DERECHA){
			pos.setX(x+ancho*2);
		}else if(movimiento == MOVER_ARRIBA){
			//Arriba es la unica excepción, si Protagonista esta yendo hacia arriba,
			//Pinky  persigue una posición hacia arriba y a la izquierda. 
			pos.setY(y+ancho*2);
			pos.setX(x-ancho);
		}else if(movimiento == MOVER_ABAJO){
			pos.setY(y+ancho*2);
		}
		
		return pos;
	}

}
