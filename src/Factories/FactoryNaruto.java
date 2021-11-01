package Factories;

import javax.swing.ImageIcon;

import Entities.Naruto;
import Entities.PairTupla;
import Entities.Protagonista;

public class FactoryNaruto extends FactoryProtagonista{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/probar.gif"));

	public Protagonista crearProtagonista(PairTupla p , int ancho, int altura) {
		Protagonista naruto = new Naruto( p ,  ancho,  altura);
		naruto.setImagen(miImagen);
		return naruto;
	}
}
