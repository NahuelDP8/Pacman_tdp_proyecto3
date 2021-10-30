package Factories;

import javax.swing.ImageIcon;

import Entities.Mapa1;
import Entities.MapaGrilla;

public class FactoryMapaGrillaGoku extends FactoryMapaGrilla{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/goku.png"));
	
	public MapaGrilla crearMapa() {
		FactoryProtagonista fabricaProt = new FactoryGoku(); 
		FactoryEnemigo fabricaEnem = new FactoryTortuga(); 
		
		MapaGrilla mapa = new Mapa1(miImagen,fabricaProt,fabricaEnem, 0, 0);
		
		return mapa;
	}

}
