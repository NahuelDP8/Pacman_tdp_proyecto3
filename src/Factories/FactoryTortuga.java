package Factories;

import Entities.Enemigo;
import Entities.PairTupla;
import Entities.TortugaBlinky;
import Entities.TortugaClyde;
import Entities.TortugaInky;
import Entities.TortugaPinky;
import Entities.Zona;

public class FactoryTortuga extends FactoryEnemigo{

	public Enemigo crearRojo(PairTupla p , int ancho, int altura, Zona zona) {
		Enemigo rojo = new TortugaBlinky(null, ancho, altura, zona);
		return rojo;
	}

	public Enemigo crearAzul(PairTupla p , int ancho, int altura, Zona zona) {
		Enemigo azul = new TortugaInky( p ,  ancho,  altura, zona);
		return azul;
	}

	public Enemigo crearNaranja(PairTupla p , int ancho, int altura, Zona zona) {
		Enemigo naranja = new TortugaClyde( p ,  ancho,  altura, zona);
		return naranja;
	}
	public Enemigo crearRosa(PairTupla p, int ancho, int altura, Zona zona) {
		Enemigo rosa = new TortugaClyde( p ,  ancho,  altura, zona);
		return rosa;
	}
}
