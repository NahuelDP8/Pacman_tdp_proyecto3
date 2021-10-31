package Factories;

import Entities.Enemigo;
import Entities.NinjaBlinky;
import Entities.NinjaClyde;
import Entities.NinjaInky;
import Entities.NinjaPinky;
import Entities.PairTupla;
import Entities.Zona;

public class FactoryNinja extends FactoryEnemigo{
	public Enemigo crearRosa(PairTupla p , int ancho, int altura, Zona zona) {
		Enemigo rosa = new NinjaPinky( p ,  ancho,  altura, zona);
		return rosa;
	}

	public Enemigo crearRojo(PairTupla p , int ancho, int altura, Zona zona) {
		Enemigo rojo = new NinjaBlinky(p ,  ancho,  altura, zona);
		return rojo;
	}

	public Enemigo crearAzul(PairTupla p , int ancho, int altura, Zona zona) {
		Enemigo azul = new NinjaInky(p ,  ancho,  altura, zona);
		return azul;
	}

	public Enemigo crearNaranja(PairTupla p , int ancho, int altura, Zona zona) {
		Enemigo naranja = new NinjaClyde(p ,  ancho,  altura, zona);
		return naranja;
	}
}
