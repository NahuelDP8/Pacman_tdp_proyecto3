package Factories;

import Entities.Naruto;
import Entities.PairTupla;
import Entities.Protagonista;

public class FactoryNaruto extends FactoryProtagonista{
	public Protagonista crearProtagonista(PairTupla p , int ancho, int altura) {
		Protagonista naruto = new Naruto( p ,  ancho,  altura);
		return naruto;
	}
}
