package Factories;

import javax.swing.ImageIcon;

import Mapas.Mapa1;
import Mapas.Mapa2;
import Mapas.Mapa3;
import Mapas.MapaGrilla;
import Nivel.Nivel;
import Logic.Logica;

public class FactoryMapa2 extends FactoryMapa{

	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/fondo2.png"));
	public MapaGrilla crearMapa(FactoryProtagonista fabricaProt,FactoryEnemigo fabricaEnem,Logica logica,Nivel lvl) {
		MapaGrilla mapa = new Mapa2(miImagen,fabricaProt,fabricaEnem, 0, 0,logica,lvl);
		return mapa;
	}

}