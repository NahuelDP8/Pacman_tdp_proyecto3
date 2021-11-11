package Factories;

import Entities.Enemigo;
import Entities.MapaGrilla;
import Entities.PairTupla;

abstract public class FactoryEnemigo{
	abstract public Enemigo crearRojo(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract public Enemigo crearAzul(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract public Enemigo crearRosa(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract public Enemigo crearNaranja(PairTupla p , int ancho, int altura,MapaGrilla grilla);
}
