package Factories;

import Entities.Goku;
import Entities.Protagonista;

public class FactoryGoku extends FactoryProtagonista{
	public Protagonista crearProtagonista() {
		Protagonista naruto = new Goku();
		return naruto;
	}
}

