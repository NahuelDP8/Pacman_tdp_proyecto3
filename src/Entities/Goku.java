package Entities;

import java.awt.Image;
import javax.swing.ImageIcon;
import Mapas.MapaGrilla; 
public class Goku extends Protagonista{
	private ImageIcon imgDerechaNormal=new ImageIcon(Naruto.class.getResource("/Imagenes/goku.gif"));
	private ImageIcon imgIzquierdaNormal=new ImageIcon(Naruto.class.getResource("/Imagenes/gokuIzquierda.gif"));
	private ImageIcon imgDerechaBomba=new ImageIcon(Naruto.class.getResource("/Imagenes/gokuBomba.gif"));
	private ImageIcon imgIzquierdaBomba=new ImageIcon(Naruto.class.getResource("/Imagenes/gokuBombaIzquierda.gif"));
	private ImageIcon imgDerechaVelocidad=new ImageIcon(Naruto.class.getResource("/Imagenes/gokuVelocidad.gif"));
	private ImageIcon imgIzquierdaVelocidad=new ImageIcon(Naruto.class.getResource("/Imagenes/gokuVelocidadIzquierda.gif"));
	
	public Goku(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
		super(p, anc, alt,img, grilla);
		Image imagen = imgDerechaNormal.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerechaNormal = new ImageIcon(imagen);
		imagen = imgIzquierdaNormal.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierdaNormal = new ImageIcon(imagen);
		imagen = imgDerechaBomba.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerechaBomba = new ImageIcon(imagen);
		imagen = imgIzquierdaBomba.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierdaBomba = new ImageIcon(imagen);
		imagen = imgDerechaVelocidad.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenDerechaVelocidad = new ImageIcon(imagen);
		imagen = imgIzquierdaVelocidad.getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		imagenIzquierdaVelocidad = new ImageIcon(imagen);
		imagenDerecha = imagenDerechaNormal;
		imagenIzquierda = imagenIzquierdaNormal;
	}

}
