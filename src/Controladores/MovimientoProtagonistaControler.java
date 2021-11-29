package Controladores;

import Protagonistas.Protagonista;

public class MovimientoProtagonistaControler extends ThreadControl{
	private Protagonista miProtagonista; 
	
	public MovimientoProtagonistaControler(Protagonista miP) {
		super(); 
		miProtagonista = miP; 
	}
	
	public void realizarMovimiento() {
		miProtagonista.iniciarProcesoMovimiento(); 
	}

	public void actualizarFoto() {
		miProtagonista.fotoNormal();
	}
	
}
