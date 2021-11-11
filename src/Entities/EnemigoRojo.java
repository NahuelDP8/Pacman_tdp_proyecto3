package Entities;

import java.util.ArrayList;
import java.lang.Math;
public abstract class EnemigoRojo extends Enemigo{
	
	public EnemigoRojo(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
		// TODO Auto-generated constructor stub
	}
	
	private ArrayList<Integer> movimientosAEstudiar(){
		ArrayList<Integer> toReturn  = new ArrayList<Integer>(); 
		toReturn.add(MOVER_ABAJO);
		toReturn.add(MOVER_ARRIBA);
		toReturn.add(MOVER_IZQUIERDA);
		toReturn.add(MOVER_DERECHA);
		
		int movActual = this.getMovimientoActual(); 
		
		if(movActual == MOVER_DERECHA) { 
			toReturn.remove(MOVER_IZQUIERDA);
			this.invalidarMovimiento(MOVER_IZQUIERDA);
		}else if (movActual == MOVER_IZQUIERDA) {			
			toReturn.remove(MOVER_DERECHA);
			this.invalidarMovimiento(MOVER_DERECHA);
		}else if (movActual == MOVER_ARRIBA) {
			toReturn.remove(MOVER_ABAJO);
			this.invalidarMovimiento(MOVER_ABAJO);
		}else if (movActual == MOVER_ABAJO) {
			toReturn.remove(MOVER_ARRIBA);
			this.invalidarMovimiento(MOVER_ARRIBA);
		}	
		
		return toReturn; 
	}
	
	private double distanciaEntrePuntos(PairTupla A, PairTupla B) {
		double distancia = Math.sqrt((A.getX()-B.getX())+(A.getY()-B.getY())); 
		return distancia; 
	}

	public void perseguirProtagonista() {
		int movFinal;
		double disMenor, disAux;
		
		ArrayList<Integer> movimientos = this.movimientosAEstudiar();
		miGrilla.realizarMovimientoFantasma(this, movimientos);
		
		PairTupla posicionProtagonista = miGrilla.getPosicionActualProtagonista();
		for(int i =0; i<3; i++) {
			
			int movAux = movimientos.get(i); 
			if(i == MOVER_DERECHA) {
				if(movDerecha) {
				}
			}
		}
		//al finalizar siempre debemos setear nuevamente como válidas a todas las posiciones válidas
		this.validarMovimientos();
	}

}
