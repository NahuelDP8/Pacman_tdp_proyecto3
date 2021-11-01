package Factories;

import javax.swing.ImageIcon;

import Entities.Goku;
import Entities.PairTupla;
import Entities.Protagonista;

public class FactoryGoku extends FactoryProtagonista{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/goku.png"));

	public Protagonista crearProtagonista(PairTupla p , int ancho, int altura) {
		Protagonista goku = new Goku( p ,  ancho,  altura);
		goku.setImagen(miImagen);
		return goku;
	}
}

