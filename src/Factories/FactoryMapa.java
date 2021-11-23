package Factories;

import Mapas.MapaGrilla;
import Nivel.Nivel;
import Logic.Logica;

abstract public class FactoryMapa{

	abstract public MapaGrilla crearMapa(FactoryProtagonista fabricaProt,FactoryEnemigo fabricaEnem,Logica logica,Nivel lvl,FactoryMejora fM);
}