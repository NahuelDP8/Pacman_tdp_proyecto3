package Controladores;

import Entities.Protagonista;

public class MovimientoProtagonistaControler extends ThreadControl{
	private Protagonista miProtagonista; 
	
	public MovimientoProtagonistaControler(Protagonista miP) {
		super(); 
		miProtagonista = miP; 
	}
	
	public void realizarMovimiento() {
		miProtagonista.iniciarProcesoMovimiento(); 
	}
	
}
