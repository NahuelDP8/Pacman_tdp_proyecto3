package Factories;

import Entities.Enemigo;
import Entities.PairTupla;
import Entities.Protagonista;
import Entities.TortugaClyde;
import Entities.Zona;

abstract public class FactoryProtagonista{
	abstract public Protagonista crearProtagonista(PairTupla p , int ancho, int altura,Zona zona);
}
