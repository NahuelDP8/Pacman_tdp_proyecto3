package Factories;

import javax.swing.ImageIcon;

import Entities.Goku;
import Mapas.MapaGrilla;
import Entities.PairTupla;
import Entities.Protagonista;

public class FactoryGoku extends FactoryProtagonista{
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaGoku.class.getResource("/Imagenes/goku.png"));

	public Protagonista crearProtagonista(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Protagonista goku = new Goku( p ,  ancho,  altura,miImagen,grilla);
		return goku;
	}
}

