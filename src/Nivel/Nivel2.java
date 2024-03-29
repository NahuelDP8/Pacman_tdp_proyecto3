package Nivel;

import Factories.FabricaDominio;
import Logic.Logica;
import Mapas.MapaGrilla;

public class Nivel2 extends Nivel {
	
	public Nivel2() {}

	@Override
	public int sleepProtagonista() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public int sleepFantasmas() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public int sleepFruta() {
		// TODO Auto-generated method stub
		return 5000;
	}

	@Override
	public int sleepSuperSpeedPocion() {
		// TODO Auto-generated method stub
		return 2000;
	}

	@Override
	public int sleepPowerPellets() {
		return 8000;
	}

	@Override
	public int getNivel() {
		// TODO Auto-generated method stub
		return 2;
	}
	public Nivel nivelSiguiente() {
		return new Nivel3();
	}

	@Override
	public int cantidadBombas() {
		return 2;
	}
	@Override
	public MapaGrilla mapa(FabricaDominio f,Logica log) {
		return f.crearMapa2(log, this);
	}

}
