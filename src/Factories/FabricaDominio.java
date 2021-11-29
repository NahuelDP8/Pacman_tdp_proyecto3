package Factories;

import javax.swing.ImageIcon;

import Improvements.BombasPocion;
import EnemigosGenerales.Enemigo;
import Improvements.Explosion;
import Improvements.Fruta;
import Improvements.Mejora;
import Entities.PairTupla;
import Improvements.PocionVelocidad;
import Protagonistas.Protagonista;
import Improvements.Punto;
import Improvements.PuntoGrande;
import Logic.Logica;
import Mapas.MapaGrilla;
import Nivel.Nivel;

abstract public class FabricaDominio {
	protected ImageIcon fondo1=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Mapa/fondo.png"));
	protected ImageIcon fondo2=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Mapa/fondo2.png"));
	protected ImageIcon fondo3=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Mapa/fondo3.png"));
	protected ImageIcon imagenPunto;
	protected ImageIcon imagenBomba;
	protected ImageIcon imagenExplosion;
	protected ImageIcon imagenFruta;
	protected ImageIcon imagenPocion;
	protected ImageIcon imagenPuntoGrande;
	
	abstract public MapaGrilla crearMapa(Logica logica,Nivel lvl);
	
	abstract public ImageIcon getImagenCargando();
	
	abstract public MapaGrilla crearMapa1(Logica log, Nivel lvl);
	abstract public MapaGrilla crearMapa2(Logica log, Nivel lvl);
	abstract public MapaGrilla crearMapa3(Logica log, Nivel lvl);
	
	abstract public Protagonista crearProtagonista(PairTupla pairTupla, int i, int j, MapaGrilla mapaGrilla);
	
	abstract public Enemigo crearRojo(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS);
	abstract public Enemigo crearAzul(PairTupla p , int ancho, int altura,MapaGrilla grilla,Enemigo rojo,PairTupla posR,PairTupla posS);
	abstract public Enemigo crearRosa(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS);
	abstract public Enemigo crearNaranja(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS);
	
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
