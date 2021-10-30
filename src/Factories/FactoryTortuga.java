package Factories;

import Entities.Enemigo;
import Entities.TortugaBlinky;
import Entities.TortugaClyde;
import Entities.TortugaInky;
import Entities.TortugaPinky;

public class FactoryTortuga extends FactoryEnemigo{
	public Enemigo crearRosa() {
		Enemigo rosa = new TortugaPinky();
		return rosa;
	}

	public Enemigo crearRojo() {
		Enemigo rojo = new TortugaBlinky();
		return rojo;
	}

	public Enemigo crearAzul() {
		Enemigo azul = new TortugaInky();
		return azul;
	}

	public Enemigo crearNaranja() {
		Enemigo naranja = new TortugaClyde();
		return naranja;
	}
}
