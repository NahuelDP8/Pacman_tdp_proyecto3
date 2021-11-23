package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Factories.FactoryMapaGrillaNaruto;
import Mapas.MapaGrilla;

public class NinjaClyde extends EnemigoNaranja{
	private ImageIcon imgDerecha=new ImageIcon(NinjaClyde.class.getResource("/Imagenes/danzoRun.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(NinjaClyde.class.getResource("/Imagenes/danzoRunIzquierda.gif"));
	private ImageIcon imgA=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/ninjaAzul.gif"));
	private ImageIcon imgM=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/ninjaMuerte.gif"));
	
	/*
	 * Escalado de Imagenes dentro del constructor
	 */
	public NinjaClyde(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,posR, posS);
		Image imagen = imgDerecha.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerecha = new ImageIcon(imagen);
		imagen = imgIzquierda.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierda = new ImageIcon(imagen);
		imagen = imgA.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imgAzul=new ImageIcon(imagen);
		imagen = imgM.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imgMuerte=new ImageIcon(imagen);
	}

}
