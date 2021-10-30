package Factories;

import Entities.Fruta;
import Entities.Mejora;
import Entities.Pocion;
import Entities.Punto;
import Entities.PuntoGrande;

public class FactoryMejora{
	public Mejora crearPunto() {
		Mejora punto = new Punto();
		return punto;
	}
	public Mejora crearFruta() {
		Mejora punto = new Fruta();
		return punto;
	}
	public Mejora crearPuntoGrande() {
		Mejora punto = new PuntoGrande();
		return punto;
	}
	public Mejora crearPocion() {
		Mejora punto = new Pocion();
		return punto;
	}
}
