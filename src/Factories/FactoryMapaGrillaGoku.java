package Factories;

import Mapas.MapaGrilla;
import Nivel.Nivel;
import Logic.Logica;

public class FactoryMapaGrillaGoku extends FactoryMapaGrilla{

	public MapaGrilla crearMapa(Logica logica,Nivel lvl,FactoryMapa m) {
		FactoryProtagonista fabricaProt = new FactoryGoku(); 
		FactoryEnemigo fabricaEnem = new FactoryTortuga(); 
		
		MapaGrilla mapa = m.crearMapa(fabricaProt,fabricaEnem,logica,lvl);
		
		return mapa;
	}

}
