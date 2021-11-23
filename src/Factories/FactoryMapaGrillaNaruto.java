package Factories;

import Mapas.MapaGrilla;
import Nivel.Nivel;

import javax.swing.ImageIcon;

import Logic.Logica;

public class FactoryMapaGrillaNaruto extends FactoryMapaGrilla{
	private ImageIcon cargando=new ImageIcon(FactoryMapaGrillaGoku.class.getResource("/Imagenes/narutoCargando.gif"));
	
	public MapaGrilla crearMapa(Logica logica,Nivel lvl,FactoryMapa m) {
		FactoryProtagonista fabricaProt = new FactoryNaruto(); 
		FactoryEnemigo fabricaEnem = new FactoryNinjaMalvado(); 
		FactoryMejoraNaruto fM= new FactoryMejoraNaruto();
		MapaGrilla mapa = m.crearMapa(fabricaProt,fabricaEnem,logica,lvl,fM);
		
		return mapa;
	}
	
	public ImageIcon getImagenCargando() {
		return cargando;
	}
	
}
