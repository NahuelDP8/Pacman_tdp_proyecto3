package Factories;

import Entities.Enemigo;
import Entities.NinjaBlinky;
import Entities.NinjaClyde;
import Entities.NinjaInky;
import Entities.NinjaPinky;

public class FactoryNinja extends FactoryEnemigo{
	public Enemigo crearRosa() {
		Enemigo rosa = new NinjaPinky();
		return rosa;
	}

	public Enemigo crearRojo() {
		Enemigo rojo = new NinjaBlinky();
		return rojo;
	}

	public Enemigo crearAzul() {
		Enemigo azul = new NinjaInky();
		return azul;
	}

	public Enemigo crearNaranja() {
		Enemigo naranja = new NinjaClyde();
		return naranja;
	}
}
