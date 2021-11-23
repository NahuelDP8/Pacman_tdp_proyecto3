package Factories;

import javax.swing.ImageIcon;

import Entities.Enemigo;
import Mapas.MapaGrilla;
import Entities.NinjaBlinky;
import Entities.NinjaClyde;
import Entities.NinjaInky;
import Entities.NinjaPinky;
import Entities.PairTupla;

public class FactoryNinjaMalvado extends FactoryEnemigo{
	private ImageIcon NinjaRojo=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/madaraRun.gif"));
	private ImageIcon NinjaRosa=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/kaguyaRun.gif"));
	private ImageIcon NinjaAzul=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/kisameRun.gif"));
	private ImageIcon NinjaNaranja=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/danzoRun.gif"));
	
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
