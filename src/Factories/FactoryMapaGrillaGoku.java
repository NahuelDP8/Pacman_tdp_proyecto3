package Factories;

import javax.swing.ImageIcon;

import Entities.Mapa1;
import Entities.MapaGrilla;
import Logic.Logica;

public class FactoryMapaGrillaGoku extends FactoryMapaGrilla{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/goku.png"));
	
	public MapaGrilla crearMapa(Logica logica) {
		FactoryProtagonista fabricaProt = new FactoryGoku(); 
		FactoryEnemigo fabricaEnem = new FactoryTortuga(); 
		
		MapaGrilla mapa = new Mapa1(miImagen,fabricaProt,fabricaEnem, 0, 0,logica);
		
		return mapa;
	}

}
