package Factories;


import Entities.MapaGrilla;
import Entities.PairTupla;
import Entities.Protagonista;


abstract public class FactoryProtagonista{
	abstract public Protagonista crearProtagonista(PairTupla p , int ancho, int altura,MapaGrilla grilla);
}
