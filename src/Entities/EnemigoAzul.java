package Entities;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Mapas.MapaGrilla;

public class EnemigoAzul extends Enemigo{

	public EnemigoAzul(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<Integer> movimientosAEstudiar(){
		ArrayList<Integer> toReturn  = new ArrayList<Integer>();
		this.validarMovimientos();
		toReturn.add(MOVER_ABAJO);
		toReturn.add(MOVER_ARRIBA);
		toReturn.add(MOVER_IZQUIERDA);
		toReturn.add(MOVER_DERECHA);
		int movActual = this.getMovimientoActual(); 
		if(movActual == MOVER_DERECHA) { 
			toReturn.remove(MOVER_IZQUIERDA-1);
			this.invalidarMovimiento(MOVER_IZQUIERDA);
		}else if (movActual == MOVER_IZQUIERDA) {			
			toReturn.remove(MOVER_DERECHA-1);
			this.invalidarMovimiento(MOVER_DERECHA);
		}else if (movActual == MOVER_ARRIBA) {
			toReturn.remove(MOVER_ABAJO-1);
			this.invalidarMovimiento(MOVER_ABAJO);
		}else if (movActual == MOVER_ABAJO) {
			toReturn.remove(MOVER_ARRIBA-1);
			this.invalidarMovimiento(MOVER_ARRIBA);
		}	
		
		return toReturn; 
	}
	
	public void perseguirProtagonista() {
		int movFinal = movimientoActual;
		double disMenor = Double.MAX_VALUE;
		double disAux = 0;
		int posX = posicion.getX();
		int posY = posicion.getY(); 
		PairTupla posicionProtagonista = miGrilla.getPosicionActualProtagonista();
		PairTupla posicionBlinky = miGrilla.getPosicionRojo();
		int movimientoProtagonista = miGrilla.getMovimientoProtagonista();
		int anchoProtagonista = miGrilla.getAnchoProtagonista();
		//Inky persigue una posicion que depende de la posicion de Blinky y el protagonista.
		PairTupla posicionAEstudiar = posicionAEstudiar(posicionProtagonista,movimientoProtagonista,anchoProtagonista,posicionBlinky);
		
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
		
		//al finalizar siempre debemos setear nuevamente como v�lidas a todas las posiciones v�lidas
	}

	//Inky persigue una posici�n adelante que depende del protagonista y de Blinky.
	//Gira 180 grados la distancia entre Blinky y el protagonista.
	private PairTupla posicionAEstudiar(PairTupla pos, int movimiento, int ancho, PairTupla posicionBlinky) {
		int x = pos.getX();
		int y = pos.getY();
		
		int xBlinky = posicionBlinky.getX();
		int yBlinky = posicionBlinky.getY();
		
		int distanciaX = xBlinky - x;
		int distanciaY = yBlinky - y;
		
		//De esta forma, se obtiene el punto tras girar 180 grados la distancia entre Blinky y protagonista.
		int xFinal = x - distanciaX;
		int yFinal = y - distanciaY;

		return new PairTupla(xFinal,yFinal);
	}

}
