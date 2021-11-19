package Nivel;

public class Nivel2 extends Nivel {
	
	public Nivel2() {}

	@Override
	public int sleepProtagonista() {
		// TODO Auto-generated method stub
		return 35;
	}

	@Override
	public int sleepFantasmas() {
		// TODO Auto-generated method stub
		return 33;
	}

	@Override
	public int sleepFruta() {
		// TODO Auto-generated method stub
		return 5000;
	}

	@Override
	public int sleepSuperSpeedPocion() {
		return 2000;
	}

	@Override
	public int sleepPowerPellets() {
		return 6000;
	}

	@Override
	public int getNivel() {
		// TODO Auto-generated method stub
		return 2;
	}

}
