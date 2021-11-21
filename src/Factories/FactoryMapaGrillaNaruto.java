package Factories;

import Mapas.MapaGrilla;
import Nivel.Nivel;
import Logic.Logica;

public class FactoryMapaGrillaNaruto extends FactoryMapaGrilla{

	public MapaGrilla crearMapa(Logica logica,Nivel lvl,FactoryMapa m) {
		FactoryProtagonista fabricaProt = new FactoryNaruto(); 
		FactoryEnemigo fabricaEnem = new FactoryNinjaMalvado(); 
		
		MapaGrilla mapa = m.crearMapa(fabricaProt,fabricaEnem,logica,lvl);
		
		return mapa;
	}

}
