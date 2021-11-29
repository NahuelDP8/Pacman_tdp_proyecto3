package Entities;

import java.awt.Image;
import javax.swing.ImageIcon;
import Mapas.MapaGrilla;

public class ZombieClyde extends EnemigoNaranja{

	private ImageIcon imgDerecha=new ImageIcon(ZombieClyde.class.getResource("/Imagenes/Goku/Enemigos/zombie2.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(ZombieClyde.class.getResource("/Imagenes/Goku/Enemigos/zombie2Izquierda.gif"));
	private ImageIcon imgA=new ImageIcon(ZombieClyde.class.getResource("/Imagenes/Goku/Enemigos/zombieAzul.png"));
	private ImageIcon imgM=new ImageIcon(ZombieClyde.class.getResource("/Imagenes/Goku/Enemigos/zombieMuerte.gif"));
	/*
	 * Escalado de Imagenes dentro del constructor
	 */
	public ZombieClyde(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
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
