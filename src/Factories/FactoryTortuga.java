package Factories;

import javax.swing.ImageIcon;

import Entities.Enemigo;
import Mapas.MapaGrilla;
import Entities.PairTupla;
import Entities.TortugaBlinky;
import Entities.TortugaClyde;
import Entities.TortugaInky;
import Entities.TortugaPinky;

public class FactoryTortuga extends FactoryEnemigo{
	private ImageIcon imgRoja=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/zombie.gif"));
	private ImageIcon imgRosa=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/zombie2.gif"));
	private ImageIcon imgAzul=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/zombie3.gif"));
	private ImageIcon imgNaranja=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/zombie4.gif"));
	public Enemigo crearRojo(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		Enemigo rojo = new TortugaBlinky(p, ancho, altura,imgRoja,grilla,posR,posS);
		return rojo;
	}

	public Enemigo crearAzul(PairTupla p , int ancho, int altura,MapaGrilla grilla,Enemigo rojo,PairTupla posR,PairTupla posS) {
		Enemigo azul = new TortugaInky( p ,  ancho,  altura,imgAzul,grilla,rojo,posR,posS);
		return azul;
	}

	public Enemigo crearNaranja(PairTupla p , int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		Enemigo naranja = new TortugaClyde( p ,  ancho,  altura,imgNaranja,grilla,posR,posS);
		return naranja;
	}
	public Enemigo crearRosa(PairTupla p, int ancho, int altura,MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		Enemigo rosa = new TortugaPinky( p ,  ancho,  altura,imgRosa,grilla,posR,posS);
		return rosa;
	}
}
