package Factories;

import javax.swing.ImageIcon;

import Entities.BombasPocion;
import Entities.Explosion;
import Entities.Fruta;
import Mapas.MapaGrilla;
import Entities.Mejora;
import Entities.PairTupla;
import Entities.PocionVelocidad;
import Entities.Punto;
import Entities.PuntoGrande;

public class FactoryMejoraNaruto extends FactoryMejora{
	private ImageIcon imagenPunto=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/narutoPunto.png"));
	private ImageIcon imagenBomba=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/narutoExplosivo.png"));
	private ImageIcon imagenExplosion=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/narutoExplosion.gif"));
	private ImageIcon imagenFruta=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/narutoFruta.png"));
	private ImageIcon imagenPocion=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/narutoPocion.png"));
	private ImageIcon imagenPuntoGrande=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/narutoPowerPellets.png"));

	public Mejora crearPunto(PairTupla p , int ancho, int altura, MapaGrilla grilla) {
		Mejora punto = new Punto( p ,  ancho,  altura,imagenPunto, grilla);
		return punto;
	}
	public Mejora crearFruta(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Mejora fruta = new Fruta( p ,  ancho,  altura,imagenFruta,grilla);
		return fruta;
	}
	public Mejora crearPocion(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Mejora pocion = new PocionVelocidad( p ,  ancho,  altura,imagenPocion,grilla);
		return pocion;
	}
	public Mejora crearBomba(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Mejora pocion = new BombasPocion( p ,  ancho,  altura,imagenBomba,grilla);
		return pocion;
	}
	public Mejora crearPuntoGrande(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Mejora puntoGrande = new PuntoGrande( p , ancho,  altura,imagenPuntoGrande,grilla);
		return puntoGrande;
	}
	public Explosion crearExplosion(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Explosion explosion= new Explosion( p , ancho,  altura,imagenBomba,imagenExplosion,grilla);
		return explosion;
	}
	
}
