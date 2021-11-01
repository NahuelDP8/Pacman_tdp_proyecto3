package Factories;

import Entities.Enemigo;
import Entities.PairTupla;
import Entities.TortugaBlinky;
import Entities.TortugaClyde;
import Entities.TortugaInky;
import Entities.TortugaPinky;

public class FactoryTortuga extends FactoryEnemigo{

	public Enemigo crearRojo(PairTupla p , int ancho, int altura) {
		Enemigo rojo = new TortugaBlinky(null, ancho, altura);
		return rojo;
	}

	public Enemigo crearAzul(PairTupla p , int ancho, int altura) {
		Enemigo azul = new TortugaInky( p ,  ancho,  altura);
		return azul;
	}

	public Enemigo crearNaranja(PairTupla p , int ancho, int altura) {
		Enemigo naranja = new TortugaClyde( p ,  ancho,  altura);
		return naranja;
	}
	public Enemigo crearRosa(PairTupla p, int ancho, int altura) {
		Enemigo rosa = new TortugaPinky( p ,  ancho,  altura);
		return rosa;
	}
}
