package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Factories.FactoryMapaGrillaNaruto;
import Mapas.MapaGrilla;

public class TortugaClyde extends EnemigoNaranja{

	private ImageIcon imgDerecha=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/danzoRun.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/danzoRunIzquierda.gif"));
	public TortugaClyde(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,posR, posS);
		Image imagen = imgDerecha.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerecha = new ImageIcon(imagen);
		imagen = imgIzquierda.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierda = new ImageIcon(imagen);
	}
}
