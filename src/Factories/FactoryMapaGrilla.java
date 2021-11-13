package Factories;

import Mapas.MapaGrilla;
import Logic.Logica;

abstract public class FactoryMapaGrilla{

	abstract public MapaGrilla crearMapa(Logica logica);
}
