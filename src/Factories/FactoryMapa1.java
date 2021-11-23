package Factories;

import javax.swing.ImageIcon;

import Mapas.Mapa1;

import Mapas.MapaGrilla;
import Nivel.Nivel;
import Logic.Logica;

public class FactoryMapa1 extends FactoryMapa{

	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/fondo.png"));
	public MapaGrilla crearMapa(FactoryProtagonista fabricaProt,FactoryEnemigo fabricaEnem,Logica logica,Nivel lvl) {
		MapaGrilla mapa = new Mapa1(miImagen,fabricaProt,fabricaEnem, 0, 0,logica,lvl);
		return mapa;
	}

}