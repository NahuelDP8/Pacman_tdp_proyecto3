package Factories;

import Entities.Naruto;
import Entities.Protagonista;

public class FactoryNaruto extends FactoryProtagonista{
	public Protagonista crearProtagonista() {
		Protagonista naruto = new Naruto();
		return naruto;
	}
}
