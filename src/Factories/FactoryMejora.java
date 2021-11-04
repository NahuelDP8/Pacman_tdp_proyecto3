package Factories;

import javax.swing.ImageIcon;

import Entities.Fruta;
import Entities.Mejora;
import Entities.PairTupla;
import Entities.Pocion;
import Entities.Punto;
import Entities.PuntoGrande;

public class FactoryMejora{
	private ImageIcon imagenPunto=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/punto.png"));
	private ImageIcon imagenFruta=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/fruta.png"));
	private ImageIcon imagenPocion=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/pocion.png"));

	public Mejora crearPunto(PairTupla p , int ancho, int altura) {
		Mejora punto = new Punto( p ,  ancho,  altura);
		punto.setImagen(imagenPunto);
		return punto;
	}
	public Mejora crearFruta(PairTupla p , int ancho, int altura) {
		Mejora punto = new Fruta( p ,  ancho,  altura);
		punto.setImagen(imagenFruta);
		return punto;
	}
	public Mejora crearPocion(PairTupla p , int ancho, int altura) {
		Mejora punto = new Pocion( p ,  ancho,  altura);
		punto.setImagen(imagenPocion);
		return punto;
	}
	public Mejora crearPuntoGrande(PairTupla p , int ancho, int altura) {
		Mejora punto = new PuntoGrande( p , ancho,  altura);
		return punto;
	}
	
}
