package EnemigosModoNaruto;

import java.awt.Image;
import javax.swing.ImageIcon;

import EnemigosGenerales.EnemigoNaranja;
import Entities.PairTupla;
import Mapas.MapaGrilla;

public class NinjaClyde extends EnemigoNaranja{
	private ImageIcon imgDerecha=new ImageIcon(NinjaClyde.class.getResource("/Imagenes/Naruto/Enemigos/danzoRun.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(NinjaClyde.class.getResource("/Imagenes/Naruto/Enemigos/danzoRunIzquierda.gif"));
	private ImageIcon imgA=new ImageIcon(NinjaClyde.class.getResource("/Imagenes/Naruto/Enemigos/ninjaAzul.gif"));
	private ImageIcon imgM=new ImageIcon(NinjaClyde.class.getResource("/Imagenes/Naruto/Enemigos/ninjaMuerte.gif"));
	
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
