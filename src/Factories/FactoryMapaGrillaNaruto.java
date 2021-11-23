package Factories;

import Mapas.MapaGrilla;
import Nivel.Nivel;
import Entities.Protagonista;
import Logic.Logica;

public class FactoryMapaGrillaNaruto extends FactoryMapaGrilla{
	private FactoryProtagonista fabricaProt;
	public MapaGrilla crearMapa(Logica logica,Nivel lvl,FactoryMapa m) {
		fabricaProt = new FactoryNaruto(); 
		FactoryEnemigo fabricaEnem = new FactoryNinjaMalvado(); 
		
		MapaGrilla mapa = m.crearMapa(fabricaProt,fabricaEnem,logica,lvl);
		
		return mapa;
	}
}
