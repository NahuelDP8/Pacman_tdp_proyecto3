package Nivel;

public class Nivel3 extends Nivel{
	public Nivel3() {
	}
	@Override
	public int sleepProtagonista() {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	public int sleepFantasmas() {
		// TODO Auto-generated method stub
		return 35;
	}

	@Override
	public int sleepFruta() {
		// TODO Auto-generated method stub
		return 2000;
	}

	@Override
	public int sleepSuperSpeedPocion() {
		// TODO Auto-generated method stub
		return 2000;
	}
	@Override
	public int sleepPowerPellets() {
		return 3000;
	}
	@Override
	public int getNivel() {
		return 3;
	}
	public Nivel nivelSiguiente() {
		return null;
	}
	@Override
	public int cantidadBombas() {
		return 3;
	}
}
