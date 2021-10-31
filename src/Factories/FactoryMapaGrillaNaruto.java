package Factories;

import javax.swing.ImageIcon;

import Entities.Mapa1;
import Entities.MapaGrilla;

public class FactoryMapaGrillaNaruto extends FactoryMapaGrilla{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/naruto.png"));

	public MapaGrilla crearMapa() {	
		FactoryProtagonista fabricaProt = new FactoryNaruto(); 
		FactoryEnemigo fabricaEnem = new FactoryNinja(); 
		
		MapaGrilla mapa = new Mapa1(miImagen,fabricaProt,fabricaEnem, 0, 0);
		
		return mapa;
	}
}
