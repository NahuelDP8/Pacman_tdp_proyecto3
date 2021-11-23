package Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

import Factories.FactoryMapaGrillaNaruto;
import Mapas.MapaGrilla;

public class ZombieInky extends EnemigoAzul{

	private ImageIcon imgDerecha=new ImageIcon(ZombieInky.class.getResource("/Imagenes/zombie3.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(ZombieInky.class.getResource("/Imagenes/zombie3Izquierda.gif"));
	private ImageIcon imgAzul=new ImageIcon(ZombieInky.class.getResource("/Imagenes/zombieAzul.png"));
	public ZombieInky(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,Enemigo rojo,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla,rojo,posR, posS);
		Image imagen = imgDerecha.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerecha = new ImageIcon(imagen);
		imagen = imgIzquierda.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierda = new ImageIcon(imagen);
	}

}
