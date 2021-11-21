package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Factories.FactoryMapaGrillaNaruto;
import Mapas.MapaGrilla;

public class NinjaBlinky extends EnemigoRojo{
	private ImageIcon imgDerecha=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/madaraRun.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/madaraRunIzquierda.gif"));
	public NinjaBlinky(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,posR, posS);
		Image imagen = imgDerecha.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerecha = new ImageIcon(imagen);
		imagen = imgIzquierda.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierda = new ImageIcon(imagen);
	}

}
