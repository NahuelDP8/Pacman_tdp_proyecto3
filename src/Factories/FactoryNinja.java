package Factories;

import Entities.Enemigo;
import Entities.NinjaBlinky;
import Entities.NinjaClyde;
import Entities.NinjaInky;
import Entities.NinjaPinky;
import Entities.PairTupla;

public class FactoryNinja extends FactoryEnemigo{
	public Enemigo crearRosa(PairTupla p , int ancho, int altura) {
		Enemigo rosa = new NinjaPinky( p ,  ancho,  altura);
		return rosa;
	}

	public Enemigo crearRojo(PairTupla p , int ancho, int altura) {
		Enemigo rojo = new NinjaBlinky(p ,  ancho,  altura);
		return rojo;
	}

	public Enemigo crearAzul(PairTupla p , int ancho, int altura) {
		Enemigo azul = new NinjaInky(p ,  ancho,  altura);
		return azul;
	}

	public Enemigo crearNaranja(PairTupla p , int ancho, int altura) {
		Enemigo naranja = new NinjaClyde(p ,  ancho,  altura);
		return naranja;
	}
}
