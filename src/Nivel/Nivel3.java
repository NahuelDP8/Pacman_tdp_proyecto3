package Nivel;

import Factories.FabricaDominio;
import Logic.Logica;
import Mapas.MapaGrilla;

public class Nivel3 extends Nivel{
	public Nivel3() {
	}
	@Override
	public int sleepProtagonista() {
		// TODO Auto-generated method stub
		return 25;
	}

	@Override
	public int sleepFantasmas() {
		// TODO Auto-generated method stub
		return 25;
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
		return 8000;
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
	@Override
	public MapaGrilla mapa(FabricaDominio f,Logica log) {
		return f.crearMapa3(log, this);
	}
}
