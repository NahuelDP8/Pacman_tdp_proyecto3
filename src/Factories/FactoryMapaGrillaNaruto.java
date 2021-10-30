package Factories;

import javax.swing.ImageIcon;

import Entities.Mapa1;
import Entities.MapaGrilla;

public class FactoryMapaGrillaNaruto extends FactoryMapaGrilla{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/naruto.png"));

	public MapaGrilla crearMapa() {	
		FactoryProtagonista fabricaProt = new FactoryGoku(); 
		FactoryEnemigo fabricaEnem = new FactoryTortuga(); 
		
		MapaGrilla mapa = new Mapa1(miImagen,fabricaProt,fabricaEnem);
		
		return mapa;
	}
}
