package Factories;

import javax.swing.ImageIcon;

import Mapas.Mapa1;
import Mapas.MapaGrilla;
import Logic.Logica;

public class FactoryMapaGrillaGoku extends FactoryMapaGrilla{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/fondo.png"));

	public MapaGrilla crearMapa(Logica logica) {
		FactoryProtagonista fabricaProt = new FactoryGoku(); 
		FactoryEnemigo fabricaEnem = new FactoryTortuga(); 
		
		MapaGrilla mapa = new Mapa1(miImagen,fabricaProt,fabricaEnem, 0, 0,logica);
		
		return mapa;
	}

}
