package Factories;

import Entities.Goku;
import Entities.PairTupla;
import Entities.Protagonista;

public class FactoryGoku extends FactoryProtagonista{
	public Protagonista crearProtagonista(PairTupla p , int ancho, int altura) {
		Protagonista goku = new Goku( p ,  ancho,  altura);
		return goku;
	}
}

