package Timer;

import Logic.Logica;

public class Timer implements Runnable {
	private int minutos, segundos;
	private Thread hiloTiempo, hiloMoverPersonaje, hiloFruta, hiloPocion,hiloMusica,hiloMoverFantasmasMuertos,hiloMoverFantasmas;
	private Logica miLogica;
	private int SleepDeProtagonista, SleepDeFantasmas, tiempoEsperaFruta, tiempoEsperaPocion; 
	private boolean frutaActivada = false;
	private boolean pocionActivada = false; 
	public Timer(Logica logic) {
		miLogica = logic;
		minutos = 0;
		segundos = 0;
		//Hilo que actualiza el reloj.
		hiloTiempo = new Thread(this);
		hiloTiempo.start();
		
		//Hilo que notifica que se debe mover.
		hiloMoverPersonaje = new Thread(this);
		hiloMoverPersonaje.start();
		//Hilo que se encarga del manejo de las frutas
		hiloFruta = new Thread(this);
		hiloPocion = new Thread(this);
		//Hilo que se encarga del manejo de la musica
		hiloMusica = new Thread(this);
		hiloMusica.start();
		//
		hiloMoverFantasmasMuertos = new Thread(this);
		hiloMoverFantasmasMuertos.start();
		
		hiloMoverFantasmas = new Thread(this);
		hiloMoverFantasmas.start();
	}
	
	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		//Actualiza el reloj
		while (ct == hiloMoverPersonaje) {
			try {
				Thread.sleep(this.SleepDeProtagonista);
				miLogica.realizarMovimiento(miLogica.getCteProtagonista());
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		
		

		
		while (ct == hiloFruta) {
			try {
				Thread.sleep(this.tiempoEsperaFruta);
				if(!frutaActivada) {
					miLogica.mostrarFrutas();
					frutaActivada = true;
					tiempoEsperaFruta /= 2;
				}
				else {
					frutaActivada = false;
					tiempoEsperaFruta *= 2;
					miLogica.eliminarFruta();
				}
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		/**
		while (ct == hiloPocion) {
			try {
				Thread.sleep(this.tiempoEsperaPocion);
				if(!pocionActivada) {
					miLogica.mostrarPociones(); 
					pocionActivada = true;
				}
				else {
					pocionActivada = false;
					miLogica.eliminarPocion();
				}
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		**/
		
		while (ct == hiloTiempo) {
			try {
				//MANEJO DE TIEMPO
				Thread.sleep(1000);
				segundos += 1;
				if(segundos == 60) {
					minutos++;
					segundos = 0;
				}
				miLogica.actualizarReloj();
					
				}catch(InterruptedException e) {
					Thread.currentThread().interrupt();
			}
		}
		
		
		while (ct == hiloMoverFantasmas) {
			try {
				Thread.sleep(this.SleepDeFantasmas);
				miLogica.realizarMovimiento(miLogica.getCteFantasma());
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}

		
		
		/*
		while (ct == hiloMusica) {

			try {
				//Completar
			} catch(InterruptedException e) {
				Thread.currentThread().interrupt();
			}
/
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
	public void setTiempoEsperaDeFruta(int i) {
		this.tiempoEsperaFruta = i;
	}
	public void setTiempoEsperaDePocion(int i) {
		this.tiempoEsperaPocion = i;
	}
	
	public void activarPocion() {
		hiloPocion.start();
	}
	public void desactivarPocion() {
		pocionActivada = false;
	}
	public void activarFruta() {
		hiloFruta.start();
	}
	public void desactivarFruta() {
		frutaActivada = false;
	}

}
