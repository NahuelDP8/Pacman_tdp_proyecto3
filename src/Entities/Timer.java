package Entities;

import Logic.Logica;

public class Timer implements Runnable {
	private int minutos, segundos, pausa;
	private Thread hiloTiempo, hiloMoverPersonaje, hiloMejora,hiloMusica,hiloMoverFantasmasMuertos,hiloMoverFantasmas;
	private Logica miLogica;
	private final int minPausa = 250;
	

	public Timer(Logica logic) {
		miLogica = logic;
		minutos = 0;
		segundos = 0;
		pausa = 400;
		//Hilo que actualiza el reloj.
		hiloTiempo = new Thread(this);
		hiloTiempo.start();
		
		//Hilo que notifica que se debe mover.
		hiloMoverPersonaje = new Thread(this);
		hiloMoverPersonaje.start();
		
		hiloMejora = new Thread(this);
		hiloMejora.start();
		
		hiloMusica = new Thread(this);
		hiloMusica.start();
		
		hiloMoverFantasmasMuertos = new Thread(this);
		hiloMoverFantasmasMuertos.start();
		
		hiloMoverFantasmas = new Thread(this);
		hiloMoverFantasmas.start();

	}

	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		//Actualiza el reloj
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
		while (ct == hiloMoverPersonaje) {
			/*
			try {
				//Completar
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		*/
		}
		while (ct == hiloMejora) {
			/*
				try {
					//Completar
				} catch(InterruptedException e) {
					Thread.currentThread().interrupt();
				}
			*/
		}
		while (ct == hiloMusica) {
			/*
			try {
				//Completar
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		*/
		}
		while (ct == hiloMoverFantasmas) {
			/*
			try {
				//Completar
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		*/
		}
		while (ct == hiloMoverFantasmasMuertos) {
			/*
			try {
				//Completar
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		*/
		}
		
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

}