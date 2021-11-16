package Timer;

import java.util.ArrayList;
import Mapas.MapaGrilla;

public class PotionVelocidadTimer extends Thread {
	private static PotionVelocidadTimer hiloPotionVel;
	private static int sleepDePotionVel; //PP=Power Pellets
	private MapaGrilla miGrilla; 
	private ArrayList<Integer> tiempoAdicional; //Se utilizará en caso de que el protagonista tome otro powerPellet si es que este timer ya esté activado
	
	private PotionVelocidadTimer(MapaGrilla miMapa) {
		miGrilla = miMapa; 
		tiempoAdicional = new ArrayList<Integer>(); 
	}

	public static PotionVelocidadTimer getPotionVelocidadTimer(MapaGrilla miMapa) {
		if(hiloPotionVel == null) 
			hiloPotionVel = new PotionVelocidadTimer(miMapa);
		sleepDePotionVel = miMapa.getSleepPocionVelocidad();
		return hiloPotionVel; 
	}
	
	public void run() {
		try {
			activarHilo();
			PowerPelletsTimer.sleep(sleepDePotionVel);
			realizarActividad(); 
		} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
		}		
	}

	public void setSleepDePP(int s) {
		sleepDePotionVel=s;
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
		miGrilla.normalizarVelocidadPacman();
		hiloPotionVel = null; 
	}

	private void activarHilo() {
		// TODO Auto-generated method stub
		
	}
	public void adherirTiempoAdicional(int i) {
		tiempoAdicional.add(i); 
	}

}
