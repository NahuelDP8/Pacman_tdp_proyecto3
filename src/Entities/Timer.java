package Entities;

import Logic.Logica;

public class Timer implements Runnable {
	private int minutos, segundos, pausa;
	private Thread hiloTiempo, hiloMoverPersonaje, hiloFruta, hiloPocion,hiloMusica,hiloMoverFantasmasMuertos,hiloMoverFantasmas;
	private Logica miLogica;
	private final int minPausa = 250;
	private int SleepDeProtagonista, SleepDeFantasmas; 

	public Timer(Logica logic) {
		miLogica = logic;
		minutos = 0;
		segundos = 0;
		pausa = 400;
		SleepDeFantasmas=100;
		SleepDeProtagonista=55;
		//Hilo que actualiza el reloj.
		hiloTiempo = new Thread(this);
		hiloTiempo.start();
		
		//Hilo que notifica que se debe mover.
		hiloMoverPersonaje = new Thread(this);
		hiloMoverPersonaje.start();
		/*
		hiloFruta = new Thread(this);
		hiloFruta.start();
		
		hiloPocion = new Thread(this);
		hiloPocion.start();
		
		hiloMusica = new Thread(this);
		hiloMusica.start();
		
		hiloMoverFantasmasMuertos = new Thread(this);
		hiloMoverFantasmasMuertos.start();
		
		hiloMoverFantasmas = new Thread(this);
		hiloMoverFantasmas.start();
		*/
	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		//Actualiza el reloj
		while (ct == hiloMoverPersonaje) {
			try {
				Thread.sleep(this.SleepDeProtagonista);

				miLogica.realizarMovimiento();
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		while (ct == hiloTiempo) {
			try {
				Thread.sleep(1000);
				segundos += 1;
				if(segundos == 60) {
					minutos++;
					segundos = 0;
				}
				if(segundos % 5 == 0 && pausa >= minPausa)
					pausa -= 40;
					
				miLogica.actualizarReloj();
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		/*
		while (ct == hiloPocion) {
				try {
					//Completar
				} catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
		}
		while (ct == hiloFruta) {
				try {
					//Completar
				} catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
		}
		
		while (ct == hiloMusica) {

			try {
				//Completar
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
/
		}
		while (ct == hiloMoverFantasmas) {

			try {
				//Completar
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}
		while (ct == hiloMoverFantasmasMuertos) {

			try {
				//Completar
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}

		}
		*/
	}
	
	public int getMinutos() {
		return minutos;
	}
	public int getSegundos() {
		return segundos;
	}
	public void setPausa(int p) {
		pausa=p;
	}
	public int getPausa() {
		return pausa;
	}
	public void gameOver() {
		hiloTiempo.interrupt();
		hiloMoverPersonaje.interrupt();
	}
	
	public void setSleepProtagonista(int i) {
		this.SleepDeProtagonista = i;
	}
	public void setSLeepFantasmas(int i) {
		this.SleepDeFantasmas = i;
	}

}