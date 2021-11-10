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
	public int sleepPocion() {
		// TODO Auto-generated method stub
		return 2000;
	}
	public void llevarACaboActivaciones() {
		activarFrutas();
		activarPociones();
	}
}
