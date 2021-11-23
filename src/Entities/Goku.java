package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Factories.FactoryMapaGrillaNaruto;
import Mapas.MapaGrilla; 
public class Goku extends Protagonista{
	private ImageIcon imgDerecha=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/goku.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/gokuIzquierda.gif"));
	public Goku(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		Image imagen = imgDerecha.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerecha = new ImageIcon(imagen);
		imagen = imgIzquierda.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierda = new ImageIcon(imagen);
	}

}
