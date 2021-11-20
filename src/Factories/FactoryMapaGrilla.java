package Factories;

import Mapas.MapaGrilla;
import Nivel.Nivel;
import Logic.Logica;

abstract public class FactoryMapaGrilla{

	abstract public MapaGrilla crearMapa1(Logica logica,Nivel lvl);
	abstract public MapaGrilla crearMapa2(Logica logica,Nivel lvl);
	abstract public MapaGrilla crearMapa3(Logica logica,Nivel lvl);
}
