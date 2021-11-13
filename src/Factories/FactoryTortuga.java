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
	private ImageIcon imgRoja=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/madaraRun.gif"));
	private ImageIcon imgRosa=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/kaguyaRun.gif"));
	private ImageIcon imgAzul=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/kisameRun.gif"));
	private ImageIcon imgNaranja=new ImageIcon(FactoryNinjaMalvado.class.getResource("/Imagenes/danzoRun.gif"));
	public Enemigo crearRojo(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Enemigo rojo = new TortugaBlinky(null, ancho, altura,imgRoja,grilla);
		return rojo;
	}

	public Enemigo crearAzul(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Enemigo azul = new TortugaInky( p ,  ancho,  altura,imgAzul,grilla);
		return azul;
	}

	public Enemigo crearNaranja(PairTupla p , int ancho, int altura,MapaGrilla grilla) {
		Enemigo naranja = new TortugaClyde( p ,  ancho,  altura,imgNaranja,grilla);
		return naranja;
	}
	public Enemigo crearRosa(PairTupla p, int ancho, int altura,MapaGrilla grilla) {
		Enemigo rosa = new TortugaPinky( p ,  ancho,  altura,imgRosa,grilla);
		return rosa;
	}
}
