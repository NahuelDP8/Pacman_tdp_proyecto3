package Factories;

import Entities.MapaGrilla;

abstract public class FactoryMapaGrilla extends AbstractFactory{
	abstract public void crearElemento();
	abstract public MapaGrilla crearMapa();
}
