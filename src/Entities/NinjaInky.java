package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Factories.FactoryMapaGrillaNaruto;
import Mapas.MapaGrilla;

public class NinjaInky extends EnemigoAzul{

	private ImageIcon imgDerecha=new ImageIcon(NinjaInky.class.getResource("/Imagenes/kisameRun.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(NinjaInky.class.getResource("/Imagenes/kisameRunIzquierda.gif"));
	private ImageIcon imgA=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/ninjaAzul.gif"));
	private ImageIcon imgM=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/ninjaMuerte.gif"));
	
	/*
	 * Escalado de Imagenes dentro del constructor
	 */
	public NinjaInky(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,Enemigo rojo,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,rojo,posR, posS);
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
