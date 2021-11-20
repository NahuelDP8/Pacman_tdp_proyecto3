package Factories;

import javax.swing.ImageIcon;

import Mapas.Mapa1;
import Mapas.Mapa2;
import Mapas.Mapa3;
import Mapas.MapaGrilla;
import Nivel.Nivel;
import Logic.Logica;

public class FactoryMapaGrillaGoku extends FactoryMapaGrilla{

	private ImageIcon miImagen1=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/fondo.png"));
	private ImageIcon miImagen2=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/fondo2.png"));
	private ImageIcon miImagen3=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/fondo3.png"));

	public MapaGrilla crearMapa1(Logica logica,Nivel lvl) {
		FactoryProtagonista fabricaProt = new FactoryGoku(); 
		FactoryEnemigo fabricaEnem = new FactoryTortuga(); 
		
		MapaGrilla mapa = new Mapa1(miImagen1,fabricaProt,fabricaEnem, 0, 0,logica,lvl);
		
		return mapa;
	}
	public MapaGrilla crearMapa2(Logica logica,Nivel lvl) {
		FactoryProtagonista fabricaProt = new FactoryGoku(); 
		FactoryEnemigo fabricaEnem = new FactoryTortuga(); 
		
		MapaGrilla mapa = new Mapa2(miImagen2,fabricaProt,fabricaEnem, 0, 0,logica,lvl);
		
		return mapa;
	}
	public MapaGrilla crearMapa3(Logica logica,Nivel lvl) {
		FactoryProtagonista fabricaProt = new FactoryGoku(); 
		FactoryEnemigo fabricaEnem = new FactoryTortuga(); 
		
		MapaGrilla mapa = new Mapa3(miImagen3,fabricaProt,fabricaEnem, 0, 0,logica,lvl);
		
		return mapa;
	}

}
