package Factories;

import Entities.Enemigo;
import Entities.PairTupla;
import Entities.Zona;

abstract public class FactoryEnemigo{
	abstract public Enemigo crearRojo(PairTupla p , int ancho, int altura,Zona zona);
	abstract public Enemigo crearAzul(PairTupla p , int ancho, int altura,Zona zona);
	abstract public Enemigo crearRosa(PairTupla p , int ancho, int altura,Zona zona);
	abstract public Enemigo crearNaranja(PairTupla p , int ancho, int altura,Zona zona);
}
