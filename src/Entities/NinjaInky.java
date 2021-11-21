package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Factories.FactoryMapaGrillaNaruto;
import Mapas.MapaGrilla;

public class NinjaInky extends EnemigoAzul{

	private ImageIcon imgDerecha=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/kisameRun.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/kisameRunIzquierda.gif"));
	public NinjaInky(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,Enemigo rojo,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,rojo,posR, posS);
		Image imagen = imgDerecha.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerecha = new ImageIcon(imagen);
		imagen = imgIzquierda.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierda = new ImageIcon(imagen);
	}

}
