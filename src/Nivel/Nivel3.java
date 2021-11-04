package Nivel;

public class Nivel3 extends Nivel{
	public Nivel3() {
		activarPociones(); 
		activarFrutas();
	}
	@Override
	public int velocidadProtagonista() {
		// TODO Auto-generated method stub
		return 37;
	}

	@Override
	public int velocidadFantasmas() {
		// TODO Auto-generated method stub
		return 35;
	}

	@Override
	public int apacicionFruta() {
		// TODO Auto-generated method stub
		return 2000;
	}

	@Override
	public int aparicionPocion() {
		// TODO Auto-generated method stub
		return 2000;
	}
}
