package Factories;

import Entities.Fruta;
import Entities.Mejora;
import Entities.PairTupla;
import Entities.Pocion;
import Entities.Punto;
import Entities.PuntoGrande;
import Entities.Zona;

public class FactoryMejora{
	public Mejora crearPunto(PairTupla p , int ancho, int altura, Zona zona) {
		Mejora punto = new Punto( p ,  ancho,  altura, zona);
		return punto;
	}
	public Mejora crearFruta(PairTupla p , int ancho, int altura, Zona zona) {
		Mejora punto = new Fruta( p ,  ancho,  altura,zona);
		return punto;
	}
	public Mejora crearPuntoGrande(PairTupla p , int ancho, int altura, Zona zona) {
		Mejora punto = new PuntoGrande( p , ancho,  altura, zona);
		return punto;
	}
	public Mejora crearPocion(PairTupla p , int ancho, int altura, Zona zona) {
		Mejora punto = new Pocion( p ,  ancho,  altura, zona);
		return punto;
	}
}
