package Factories;

import Mapas.MapaGrilla;
import Nivel.Nivel;

import javax.swing.ImageIcon;

import Logic.Logica;

abstract public class FactoryMapaGrilla{

	abstract public MapaGrilla crearMapa(Logica logica,Nivel lvl,FactoryMapa m);
	abstract public ImageIcon getImagenCargando();
}
