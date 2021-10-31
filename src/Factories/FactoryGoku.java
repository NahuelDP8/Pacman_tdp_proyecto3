package Factories;

import javax.swing.ImageIcon;

import Entities.Goku;
import Entities.PairTupla;
import Entities.Protagonista;
import Entities.Zona;

public class FactoryGoku extends FactoryProtagonista{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/goku.png"));

	public Protagonista crearProtagonista(PairTupla p , int ancho, int altura, Zona zona) {
		Protagonista goku = new Goku( p ,  ancho,  altura, zona);
		goku.setImagen(miImagen);
		return goku;
	}
}

