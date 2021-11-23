package Factories;

import Entities.Explosion;
import Mapas.MapaGrilla;
import Entities.Mejora;
import Entities.PairTupla;

public abstract class FactoryMejora{

	abstract public Mejora crearPunto(PairTupla p , int ancho, int altura, MapaGrilla grilla);
	abstract public Mejora crearFruta(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract public Mejora crearPocion(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract public Mejora crearBomba(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract public Mejora crearPuntoGrande(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract public Explosion crearExplosion(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	
}
