package Factories;

import Entities.Explosion;
import Mapas.MapaGrilla;
import Entities.Mejora;
import Entities.PairTupla;

abstract class FactoryMejora{

	abstract Mejora crearPunto(PairTupla p , int ancho, int altura, MapaGrilla grilla);
	abstract Mejora crearFruta(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract Mejora crearPocion(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract Mejora crearBomba(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract Mejora crearPuntoGrande(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	abstract Explosion crearExplosion(PairTupla p , int ancho, int altura,MapaGrilla grilla);
	
}
