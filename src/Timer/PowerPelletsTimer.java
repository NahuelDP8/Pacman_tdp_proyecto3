package Timer;

import java.util.ArrayList;
import Mapas.MapaGrilla;

public class PowerPelletsTimer extends Thread  {
	private static PowerPelletsTimer hiloPP;
	private static int sleepDePP; //PP=Power Pellets
	private MapaGrilla miGrilla;
	private boolean activado= false; 
	private ArrayList<Integer> tiempoAdicional; //Se utilizará en caso de que el protagonista tome otro powerPellet si es que este timer ya esté activado
	
	private PowerPelletsTimer(MapaGrilla miMapa) {
		miGrilla = miMapa; 
		tiempoAdicional = new ArrayList<Integer>(); 
	}

	public static PowerPelletsTimer getPowerPelletsTimer(MapaGrilla miMapa) {
		if(hiloPP == null) 
			hiloPP = new PowerPelletsTimer(miMapa);
		sleepDePP = miMapa.getSleepPowerPellets();
		return hiloPP; 
	}
	
	public void run() {
		try {
			activarHilo();
			PowerPelletsTimer.sleep(sleepDePP);
			realizarActividad(); 
		} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
		}		
	}
 
	public void setSleepDePP(int s) {
		sleepDePP=s;
	}
	
	private void realizarActividad() {
		if(!tiempoAdicional.isEmpty()) {
			for(int i = 0 ; i<tiempoAdicional.size(); i++) {
				try {
					PowerPelletsTimer.sleep(tiempoAdicional.remove(i));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		miGrilla.enemigosPerseguir();
		hiloPP = null; 
		activado = false; 
	}
	
	private void activarHilo() {
		activado = false; 
	}
	
	public boolean yaFueActivado() {
		return activado; 
	}
	
	public void adherirTiempoAdicional(int i) {
		tiempoAdicional.add(i); 
	}
}
