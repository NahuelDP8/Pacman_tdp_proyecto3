package Factories;

import javax.swing.ImageIcon;

import Entities.Mapa1;
import Entities.MapaGrilla;

public class FactoryMapaGrillaGoku extends FactoryMapaGrilla{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/goku.png"));
	public void crearElemento() {
		
	}
	public MapaGrilla crearMapa() {
		
		return (MapaGrilla)new Mapa1(miImagen);
	}
}
