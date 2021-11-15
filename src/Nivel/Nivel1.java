package Nivel;


public class Nivel1 extends Nivel{
	
	public Nivel1() {}

	public void llevarACaboActivaciones() {
		activarFrutas();
		desactivarPociones();
	}
	public int sleepProtagonista() {
		return 20;
	}
	
	public int sleepFantasmas() {
		return 50;
	}
	
	public int sleepFruta() {
		return 4000;
	}

	public int sleepPocion() {
		return 0;
	}

	@Override
	public int sleepPowerPellets() {
		return 10000;
	}

}
