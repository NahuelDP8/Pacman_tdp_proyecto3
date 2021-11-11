package Factories;

import javax.swing.ImageIcon;

import Entities.MapaGrilla;
import Entities.Naruto;
import Entities.PairTupla;
import Entities.Protagonista;

public class FactoryNaruto extends FactoryProtagonista{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/narutoRun.gif"));

	public Protagonista crearProtagonista(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Protagonista naruto = new Naruto( p ,  ancho,  altura, miImagen,grilla);
		return naruto;
	}
}
