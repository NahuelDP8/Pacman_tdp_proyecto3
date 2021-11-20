package Controladores;

import Logic.Logica;
import Timer.EnemigosTimer;
import Timer.ProtagonistaTimer;
import java.util.ArrayList;
import Entities.Enemigo;
import Entities.Protagonista;

public class MovimientosControler extends ThreadControl {
	private EnemigosTimer tEnemigos; 
	private ProtagonistaTimer tProtagonista; 
	private int sleepPro; 
	private int sleepEnem; 
	private int MOVER_ENEMIGOS; 
	private int MOVER_PROTAGONISTA;
	private MovimientoEnemigosControler movEnemigoC;
	private MovimientoProtagonistaControler movProtagonistaC; 
	
	public MovimientosControler(int sleepPro, int sleepEn, Protagonista miP, ArrayList<Enemigo> lisEnem ) {
		MOVER_ENEMIGOS = Logica.getLogic(null, null, null).getConstanteMOVER_ENEMIGOS();
		MOVER_PROTAGONISTA = Logica.getLogic(null, null, null).getConstanteMOVER_PROTAGONISTA();
		tEnemigos =  new EnemigosTimer(this, MOVER_ENEMIGOS);
		tProtagonista = ProtagonistaTimer.getProtagonistaTimer(this, MOVER_PROTAGONISTA);
		this.sleepPro = sleepPro;
		this.sleepEnem = sleepEn; 
		movEnemigoC = new MovimientoEnemigosControler(lisEnem);
		movProtagonistaC = new MovimientoProtagonistaControler(miP); 
	}
	
	public int getSleepGeneralEnemigos() {
		return sleepEnem;
	}
	
	public int getSleepGeneralProtagonista() {
		return sleepPro;
	}

	public void realizarMovimiento(int constante) {
		if (constante == MOVER_ENEMIGOS) {
			movEnemigoC.moverTodosLosFantasmas();
		}else if(constante == MOVER_PROTAGONISTA){
			movProtagonistaC.realizarMovimiento();
		}
	}
	
}
