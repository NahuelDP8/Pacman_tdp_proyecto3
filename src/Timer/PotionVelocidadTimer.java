package Timer;

import java.util.ArrayList;
import Controladores.SpeedPotionControler;

public class PotionVelocidadTimer extends Thread {
	private static PotionVelocidadTimer hiloPotionVel;
	private static int sleepDePotionVel; //PP=Power Pellets
	private SpeedPotionControler miControlador; 
	private ArrayList<Integer> tiempoAdicional; //Se utilizará en caso de que el protagonista tome otro powerPellet si es que este timer ya esté activado
	
	private PotionVelocidadTimer(SpeedPotionControler miCon) {
		miControlador = miCon; 
		tiempoAdicional = new ArrayList<Integer>(); 
	}

	public static PotionVelocidadTimer getPotionVelocidadTimer(SpeedPotionControler miC, int speedVP) {
		if(hiloPotionVel == null) 
			hiloPotionVel = new PotionVelocidadTimer(miC);
		sleepDePotionVel = speedVP;
		return hiloPotionVel; 
	}
	
	public void run() {
		try {
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
					PotionVelocidadTimer.sleep(tiempoAdicional.remove(i)/2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		miControlador.normalizarVelocidadPacman();
		hiloPotionVel = null; 
	}

	public void adherirTiempoAdicional(int i) {
		tiempoAdicional.add(i); 
	}

}

