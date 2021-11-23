package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Factories.FactoryMapaGrillaNaruto;
import Mapas.MapaGrilla;

public class ZombieBlinky extends EnemigoRojo{

	private ImageIcon imgDerecha=new ImageIcon(ZombieBlinky.class.getResource("/Imagenes/zombie.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(ZombieBlinky.class.getResource("/Imagenes/zombieIzquierda.gif"));
	private ImageIcon imgAzul=new ImageIcon(ZombieBlinky.class.getResource("/Imagenes/zombieAzul.png"));
	public ZombieBlinky(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,posR, posS);
		Image imagen = imgDerecha.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerecha = new ImageIcon(imagen);
		imagen = imgIzquierda.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierda = new ImageIcon(imagen);
	}

}
