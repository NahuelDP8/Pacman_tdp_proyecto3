package Factories;

import Entities.Fruta;
import Entities.Mejora;
import Entities.PairTupla;
import Entities.Pocion;
import Entities.Punto;
import Entities.PuntoGrande;

public class FactoryMejora{
	public Mejora crearPunto(PairTupla p , int ancho, int altura) {
		Mejora punto = new Punto( p ,  ancho,  altura);
		return punto;
	}
	public Mejora crearFruta(PairTupla p , int ancho, int altura) {
		Mejora punto = new Fruta( p ,  ancho,  altura);
		return punto;
	}
	public Mejora crearPuntoGrande(PairTupla p , int ancho, int altura) {
		Mejora punto = new PuntoGrande( p , ancho,  altura);
		return punto;
	}
	public Mejora crearPocion(PairTupla p , int ancho, int altura) {
		Mejora punto = new Pocion( p ,  ancho,  altura);
		return punto;
	}
}
