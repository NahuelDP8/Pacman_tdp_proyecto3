package Factories;

import javax.swing.ImageIcon;

import Entities.Mapa1;
import Entities.MapaGrilla;

public class FactoryMapaGrillaNaruto extends FactoryMapaGrilla{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/naruto.png"));
	
	public void crearElemento() {
		
	}
	public MapaGrilla crearMapa() {
		
		return (MapaGrilla)new Mapa1(miImagen);
	}
}
