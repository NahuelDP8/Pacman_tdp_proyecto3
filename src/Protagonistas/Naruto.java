package Protagonistas;

import java.awt.Image;

import javax.swing.ImageIcon;

import Entities.PairTupla;
import Mapas.MapaGrilla;

public class Naruto extends Protagonista{
	private ImageIcon imgDerechaNormal=new ImageIcon(Naruto.class.getResource("/Imagenes/Naruto/Protagonista/narutoRun.gif"));
	private ImageIcon imgIzquierdaNormal=new ImageIcon(Naruto.class.getResource("/Imagenes/Naruto/Protagonista/narutoRunIzquierda.gif"));
	private ImageIcon imgDerechaBomba=new ImageIcon(Naruto.class.getResource("/Imagenes/Naruto/Protagonista/narutoBomba.gif"));
	private ImageIcon imgIzquierdaBomba=new ImageIcon(Naruto.class.getResource("/Imagenes/Naruto/Protagonista/narutoBombaIzquierda.gif"));
	private ImageIcon imgDerechaVelocidad=new ImageIcon(Naruto.class.getResource("/Imagenes/Naruto/Protagonista/narutoVelocidad.gif"));
	private ImageIcon imgIzquierdaVelocidad=new ImageIcon(Naruto.class.getResource("/Imagenes/Naruto/Protagonista/narutoVelocidadIzquierda.gif"));
	public Naruto(PairTupla p, int anc, int alt,ImageIcon img, MapaGrilla grilla) {
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
