package Factories;

import javax.swing.ImageIcon;
import Entities.PairTupla;
import Entities.Protagonista;
import Entities.ZombieBlinky;
import Entities.ZombieClyde;
import Entities.ZombieInky;
import Entities.ZombiePinky;
import Logic.Logica;
import Mapas.Mapa1;
import Mapas.Mapa2;
import Mapas.Mapa3;
import Mapas.MapaGrilla;
import Nivel.Nivel;
import Entities.Enemigo;
import Entities.Goku;

public class FabricaDominioGoku extends FabricaDominio{
	private ImageIcon cargando=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/gokuCargando.gif"));
	private ImageIcon imagenGoku=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/goku.gif"));
	
	private ImageIcon imgRoja=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/zombie.gif"));
	private ImageIcon imgRosa=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/zombie2.gif"));
	private ImageIcon imgAzul=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/zombie3.gif"));
	private ImageIcon imgNaranja=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/zombie4.gif"));
	
	public FabricaDominioGoku(){
		imagenPunto=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/gokuPunto.png"));
		imagenBomba=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/gokuExplosivo.png"));
		imagenExplosion=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/gokuExplosion.gif"));
		imagenFruta=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/gokuFruta.png"));
		imagenPocion=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/gokuPocion.png"));
		imagenPuntoGrande=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/gokuPowerPellets.png"));
	}
	@Override
	public MapaGrilla crearMapa(Logica logica, Nivel lvl) {
		MapaGrilla mapa = lvl.mapa(this,logica);	
		return mapa;
	}

	@Override
	public ImageIcon getImagenCargando() {
		// TODO Auto-generated method stub
		return cargando;
	}

	@Override
	public MapaGrilla crearMapa1(Logica log,Nivel lvl) {
		MapaGrilla mapa = new Mapa1(fondo1, 0, 0,log,lvl,this);
		return mapa;
	}

	@Override
	public MapaGrilla crearMapa2(Logica log, Nivel lvl) {
		MapaGrilla mapa = new Mapa2(fondo2, 0, 0,log,lvl,this);
		return mapa;
	}

	@Override
	public MapaGrilla crearMapa3(Logica log, Nivel lvl) {
		MapaGrilla mapa = new Mapa3(fondo3, 0, 0,log,lvl,this);
		return mapa;
	}

	@Override
	public Protagonista crearProtagonista(PairTupla p, int ancho, int altura, MapaGrilla grilla) {
		Protagonista goku = new Goku( p ,  ancho,  altura,imagenGoku,grilla);
		return goku;
	}
	public Enemigo crearRojo(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		Enemigo rojo = new ZombieBlinky(p, ancho, altura,imgRoja,grilla,posR,posS);
		return rojo;
	}

	public Enemigo crearAzul(PairTupla p , int ancho, int altura,MapaGrilla grilla,Enemigo rojo,PairTupla posR,PairTupla posS) {
		Enemigo azul = new ZombieInky( p ,  ancho,  altura,imgAzul,grilla,rojo,posR,posS);
		return azul;
	}

	public Enemigo crearNaranja(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		Enemigo naranja = new ZombieClyde( p ,  ancho,  altura,imgNaranja,grilla,posR,posS);
		return naranja;
	}
	public Enemigo crearRosa(PairTupla p, int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		Enemigo rosa = new ZombiePinky( p ,  ancho,  altura,imgRosa,grilla,posR,posS);
		return rosa;
	}

}
