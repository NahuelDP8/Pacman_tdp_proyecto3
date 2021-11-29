package EnemigosModoGoku;

import java.awt.Image;
import javax.swing.ImageIcon;
import EnemigosGenerales.EnemigoRosa;
import Entities.PairTupla;
import Mapas.MapaGrilla;

public class ZombiePinky extends EnemigoRosa{

	private ImageIcon imgDerecha=new ImageIcon(ZombiePinky.class.getResource("/Imagenes/Goku/Enemigos/zombie4.gif"));
	private ImageIcon imgIzquierda=new ImageIcon(ZombiePinky.class.getResource("/Imagenes/Goku/Enemigos/zombie4Izquierda.gif"));
	private ImageIcon imgA=new ImageIcon(ZombiePinky.class.getResource("/Imagenes/Goku/Enemigos/zombieAzul.png"));
	private ImageIcon imgM=new ImageIcon(ZombiePinky.class.getResource("/Imagenes/Goku/Enemigos/zombieMuerte.gif"));
	/*
	 * Escalado de Imagenes dentro del constructor
	 */
	public ZombiePinky(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
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
