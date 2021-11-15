package Timer;

import Logic.Logica;

public class PowerPelletsTimer implements Runnable  {
	private Thread hiloPP;
	private int SleepDePP; //PP=Power Pellets
	private Logica miLogica;
	private boolean protaImparable = false;
	public PowerPelletsTimer(Logica logic) {
		hiloPP= new Thread(this);
		hiloPP.start();
		SleepDePP=1000;
	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		//Actualiza el reloj
		while (ct == hiloPP) {
			try {
				Thread.sleep(this.SleepDePP);
				if(!protaImparable) {
					protaImparable=true;
					//falta metodo
				}
				else {
					protaImparable = false;
					//falta metodo
				}
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
    }
	
	public void setSleepDePP(int s) {
		SleepDePP=s;
	}
	
	
	
}
