package Factories;

import javax.swing.ImageIcon;

import Entities.Fruta;
import Mapas.MapaGrilla;
import Entities.Mejora;
import Entities.PairTupla;
import Entities.Pocion;
import Entities.Punto;
import Entities.PuntoGrande;

public class FactoryMejora{
	private ImageIcon imagenPunto=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/punto.png"));
	private ImageIcon imagenFruta=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/fruta.png"));
	private ImageIcon imagenPocion=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/pocion.png"));
	private ImageIcon imagenPuntoGrande=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/powerPellets.png"));

	public Mejora crearPunto(PairTupla p , int ancho, int altura, MapaGrilla grilla) {
		Mejora punto = new Punto( p ,  ancho,  altura,imagenPunto, grilla);
		return punto;
	}
	public Mejora crearFruta(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Mejora fruta = new Fruta( p ,  ancho,  altura,imagenFruta,grilla);
		return fruta;
	}
	public Mejora crearPocion(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Mejora pocion = new Pocion( p ,  ancho,  altura,imagenPocion,grilla);
		return pocion;
	}
	public Mejora crearPuntoGrande(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Mejora puntoGrande = new PuntoGrande( p , ancho,  altura,imagenPuntoGrande,grilla);
		return puntoGrande;
	}
	
}
