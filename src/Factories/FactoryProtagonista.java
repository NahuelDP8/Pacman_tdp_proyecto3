package Factories;

import Entities.PairTupla;
import Entities.Protagonista;
import Mapas.MapaGrilla;

abstract public class FactoryProtagonista{
	abstract public Protagonista crearProtagonista(PairTupla p , int ancho, int altura,MapaGrilla grilla);
}
