package Timer;

import java.util.ArrayList;
import Controladores.PPControler;


public class PowerPelletsTimer extends Thread  {
	private static PowerPelletsTimer hiloPP;
	private static int sleepDePP; //PP=Power Pellets
	private static PPControler miControlador;
	private ArrayList<Integer> tiempoAdicional; //Se utilizará en caso de que el protagonista tome otro powerPellet si es que este timer ya esté activado
	
	private PowerPelletsTimer(PPControler miCon) {
		miControlador = miCon; 
		tiempoAdicional = new ArrayList<Integer>(); 
	}

	public static PowerPelletsTimer getPowerPelletsTimer(PPControler miC, int sleepPP) {
		if(hiloPP == null) 
			hiloPP = new PowerPelletsTimer(miC);
		sleepDePP = sleepPP; 
		return hiloPP;
	}
	
	public void run() {
		try {
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
					PowerPelletsTimer.sleep(tiempoAdicional.remove(i)/2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		miControlador.enemigosPerseguir();
		hiloPP = null;
	}
	
	public void adherirTiempoAdicional(int i) {
		tiempoAdicional.add(i);
	}
}
