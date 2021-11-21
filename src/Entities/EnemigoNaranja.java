package Entities;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Mapas.MapaGrilla;

public class EnemigoNaranja extends Enemigo{

	public EnemigoNaranja(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
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
		//Inky persigue una posicion que depende de la posicion de Blinky y el protagonista.
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

	//Clyde persigue al protagonista,salvo que se encuentre a poca distancia de pacman, en cuyo caso,
	//huye hacia la parte inferior izquierda del mapa.
	private PairTupla posicionAEstudiar(PairTupla pos, int movimiento, int ancho) {
		
		if(distanciaEntrePuntos(pos,posicion) <= ancho*4) {
			//Esquina inferior izquierda.
			pos.setX(0);
			pos.setY(540);
		}
		return pos;
	}

}
