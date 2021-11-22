package Nivel;


public class Nivel1 extends Nivel{
	
	public Nivel1() {}

	public int getNivel(){
		return 1;
	}
	public int sleepProtagonista() {
		return 30;
	}
	
	public int sleepFantasmas() {
		return 50;
	}
	
	public int sleepFruta() {
		return 4000;
	}

	public int sleepSuperSpeedPocion() {
		return 5000;
	}

	public int sleepPowerPellets() {
		return 10000;
	}
	public Nivel nivelSiguiente() {
		return new Nivel2();
	}

	@Override
	public int cantidadBombas() {
		return 1;
	}

}
