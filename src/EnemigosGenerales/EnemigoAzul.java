package EnemigosGenerales;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Entities.PairTupla;
import Mapas.MapaGrilla;

public class EnemigoAzul extends Enemigo{
 private Enemigo E_Rojo;
	public EnemigoAzul(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,Enemigo rojo,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,posR, posS);
		velocidad=4;
		E_Rojo=rojo;
	}
	
	public void perseguirProtagonista() {
		int movFinal = movimientoActual;
		double disMenor = Double.MAX_VALUE;
		double disAux = 0;
		int posX = posicion.getX();
		int posY = posicion.getY(); 
		PairTupla posicionProtagonista = miGrilla.getPosicionActualProtagonista();
		PairTupla posicionBlinky = E_Rojo.getPos();
		int movimientoProtagonista = miGrilla.getMovimientoProtagonista();
		int anchoProtagonista = miGrilla.getAnchoProtagonista();
		//Inky persigue una posicion que depende de la posicion de Blinky y el protagonista.
		PairTupla posicionAEstudiar = posicionAEstudiar(posicionProtagonista,movimientoProtagonista,anchoProtagonista,posicionBlinky);
		
		ArrayList<Integer> movimientos = this.movimientosAEstudiar();
		miGrilla.realizarMovimientoFantasma(this, movimientos);
		
		for(int i =0; i<=movimientos.size()-1; i++) {	
			int movAux = movimientos.get(i); 
			if (movAux == miGrilla.getCnsMOVER_DERECHA() && movDerecha) {
				disAux = distanciaEntrePuntos(new PairTupla(posX+ velocidad, posY),posicionAEstudiar);
				if(disAux<=disMenor) {
					disMenor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux == miGrilla.getCnsMOVER_IZQUIERDA() && movIzquierda) {
				disAux = distanciaEntrePuntos(new PairTupla(posX-velocidad, posY),posicionAEstudiar);
				if(disAux<=disMenor) {
					disMenor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux== miGrilla.getCnsMOVER_ARRIBA() && movArriba) {
				disAux = distanciaEntrePuntos(new PairTupla(posX, posY-velocidad),posicionAEstudiar);
				if(disAux<=disMenor) {
					disMenor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux == miGrilla.getCnsMOVER_ABAJO() && movAbajo) {
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

	//Inky persigue una posición adelante que depende del protagonista y de Blinky.
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
