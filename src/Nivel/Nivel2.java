package Nivel;

public class Nivel2 extends Nivel {
	
	public Nivel2() {}

	@Override
	public int velocidadProtagonista() {
		// TODO Auto-generated method stub
		return 35;
	}

	@Override
	public int velocidadFantasmas() {
		// TODO Auto-generated method stub
		return 33;
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
	@Override
	public void llevarACaboActivaciones() {
		desactivarPociones(); 
		activarFrutas();
	}
}
