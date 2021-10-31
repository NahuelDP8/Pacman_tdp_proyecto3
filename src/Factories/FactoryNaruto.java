package Factories;

import javax.swing.ImageIcon;

import Entities.Naruto;
import Entities.PairTupla;
import Entities.Protagonista;
import Entities.Zona;

public class FactoryNaruto extends FactoryProtagonista{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/naruto.png"));

	public Protagonista crearProtagonista(PairTupla p , int ancho, int altura, Zona zona) {
		Protagonista naruto = new Naruto( p ,  ancho,  altura, zona);
		naruto.setImagen(miImagen);
		return naruto;
	}
}
