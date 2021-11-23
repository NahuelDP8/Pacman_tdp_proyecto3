package Factories;

import Mapas.MapaGrilla;
import Nivel.Nivel;
import Entities.Protagonista;
import Logic.Logica;

abstract public class FactoryMapaGrilla{

	abstract public MapaGrilla crearMapa(Logica logica,Nivel lvl,FactoryMapa m);
}
