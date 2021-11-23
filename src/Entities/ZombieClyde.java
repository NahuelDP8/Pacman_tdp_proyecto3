package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Factories.FactoryMapaGrillaNaruto;
import Mapas.MapaGrilla;

public class ZombieClyde extends EnemigoNaranja{

	private ImageIcon imgDerecha=new ImageIcon(ZombieClyde.class.getResource("/Imagenes/zombie2.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(ZombieClyde.class.getResource("/Imagenes/zombie2Izquierda.gif"));
	private ImageIcon imgAzul=new ImageIcon(ZombieClyde.class.getResource("/Imagenes/zombieAzul.png"));
	public ZombieClyde(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,posR, posS);
		Image imagen = imgDerecha.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerecha = new ImageIcon(imagen);
		imagen = imgIzquierda.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierda = new ImageIcon(imagen);
	}
}
