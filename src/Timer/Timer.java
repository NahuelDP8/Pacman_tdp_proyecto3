package Timer;

import Logic.Logica;

public class Timer implements Runnable {
	private int minutos, segundos;
	private Thread hiloTiempo,hiloMusica;
	private Logica miLogica;
	
	public Timer(Logica logic) {
		miLogica = logic;
		minutos = 0;
		segundos = 0;
		//Hilo que actualiza el reloj.
		hiloTiempo = new Thread(this);
		hiloTiempo.start();
		
		//Hilo que se encarga del manejo de la musica
		hiloMusica = new Thread(this);
		hiloMusica.start();
	}
	
	@Override
	public void run() {
		Thread ct = Thread.currentThread();
		
		//Actualiza el reloj
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
	}
	
	public int getMinutos() {
		return minutos;
	}
	public int getSegundos() {
		return segundos;
	}
	
	public void gameOver() {
		hiloTiempo.interrupt();
	}	
}
