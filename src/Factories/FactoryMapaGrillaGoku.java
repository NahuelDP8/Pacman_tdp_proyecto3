package Factories;

import Mapas.MapaGrilla;
import Nivel.Nivel;

import javax.swing.ImageIcon;

import Logic.Logica;

public class FactoryMapaGrillaGoku extends FactoryMapaGrilla{
	private ImageIcon cargando=new ImageIcon(FactoryMapaGrillaGoku.class.getResource("/Imagenes/gokuCargando.gif"));
	
	public MapaGrilla crearMapa(Logica logica,Nivel lvl,FactoryMapa m) {
		FactoryProtagonista fabricaProt = new FactoryGoku(); 
		FactoryEnemigo fabricaEnem = new FactoryZombie();
		FactoryMejoraGoku fM= new FactoryMejoraGoku();
		MapaGrilla mapa = m.crearMapa(fabricaProt,fabricaEnem,logica,lvl,fM);
		return mapa;
	}
	public ImageIcon getImagenCargando() {
		return cargando;
	}
}
