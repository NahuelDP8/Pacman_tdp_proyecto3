package Factories;

import javax.swing.ImageIcon;

import Entities.Enemigo;
import Entities.Naruto;
import Entities.NinjaBlinky;
import Entities.NinjaClyde;
import Entities.NinjaInky;
import Entities.NinjaPinky;
import Entities.PairTupla;
import Entities.Protagonista;
import Logic.Logica;
import Mapas.Mapa1;
import Mapas.Mapa2;
import Mapas.Mapa3;
import Mapas.MapaGrilla;
import Nivel.Nivel;

public class FabricaDominioNaruto extends FabricaDominio{
	private ImageIcon cargando=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Protagonista/narutoCargando.gif"));
	private ImageIcon imagenNaruto=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Protagonista/narutoRun.gif"));
	
	private ImageIcon NinjaRojo=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Enemigos/madaraRun.gif"));
	private ImageIcon NinjaRosa=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Enemigos/kaguyaRun.gif"));
	private ImageIcon NinjaAzul=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Enemigos/kisameRun.gif"));
	private ImageIcon NinjaNaranja=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Enemigos/danzoRun.gif"));
	
	public FabricaDominioNaruto() {
		imagenPunto=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Mejora/narutoPunto.png"));
		imagenBomba=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Mejora/narutoExplosivo.png"));
		imagenExplosion=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Mejora/narutoExplosion.gif"));
		imagenFruta=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Mejora/narutoFruta.png"));
		imagenPocion=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Mejora/narutoPocion.png"));
		imagenPuntoGrande=new ImageIcon(FabricaDominio.class.getResource("/Imagenes/Naruto/Mejora/narutoPowerPellets.png"));
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
		Protagonista naruto = new Naruto( p ,  ancho,  altura,imagenNaruto,grilla);
		return naruto;
	}
	public Enemigo crearRosa(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		Enemigo rosa = new NinjaPinky( p ,  ancho,  altura, NinjaRosa,grilla,posR,posS);
		rosa.setImagen(NinjaRosa);
		return rosa;
	}

	public Enemigo crearRojo(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		Enemigo rojo = new NinjaBlinky(p ,  ancho,  altura,NinjaRojo,grilla,posR,posS);
		rojo.setImagen(NinjaRojo);
		return rojo;
	}

	public Enemigo crearAzul(PairTupla p , int ancho, int altura,MapaGrilla grilla,Enemigo rojo,PairTupla posR,PairTupla posS) {
		Enemigo azul = new NinjaInky(p ,  ancho,  altura,NinjaAzul,grilla,rojo,posR,posS);
		azul.setImagen(NinjaAzul);
		return azul;
	}

	public Enemigo crearNaranja(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		Enemigo naranja = new NinjaClyde(p ,  ancho,  altura,NinjaNaranja,grilla,posR,posS);
		naranja.setImagen(NinjaNaranja);
		return naranja;
	}

}
