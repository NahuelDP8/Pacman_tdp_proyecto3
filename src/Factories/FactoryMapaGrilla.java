package Factories;

import Mapas.MapaGrilla;
import Logic.Logica;

abstract public class FactoryMapaGrilla{

	abstract public MapaGrilla crearMapa1(Logica logica);
	abstract public MapaGrilla crearMapa2(Logica logica);
	abstract public MapaGrilla crearMapa3(Logica logica);
}
