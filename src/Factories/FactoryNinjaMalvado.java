package Factories;

import javax.swing.ImageIcon;

import Entities.Enemigo;
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
	
	public Enemigo crearRosa(PairTupla p , int ancho, int altura) {
		Enemigo rosa = new NinjaPinky( p ,  ancho,  altura);
		rosa.setImagen(NinjaRosa);
		return rosa;
	}

	public Enemigo crearRojo(PairTupla p , int ancho, int altura) {
		Enemigo rojo = new NinjaBlinky(p ,  ancho,  altura);
		rojo.setImagen(NinjaRojo);
		return rojo;
	}

	public Enemigo crearAzul(PairTupla p , int ancho, int altura) {
		Enemigo azul = new NinjaInky(p ,  ancho,  altura);
		azul.setImagen(NinjaAzul);
		return azul;
	}

	public Enemigo crearNaranja(PairTupla p , int ancho, int altura) {
		Enemigo naranja = new NinjaClyde(p ,  ancho,  altura);
		naranja.setImagen(NinjaNaranja);
		return naranja;
	}
}
