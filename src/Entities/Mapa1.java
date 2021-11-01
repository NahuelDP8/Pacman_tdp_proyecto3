package Entities;

import javax.swing.ImageIcon;

import Factories.FactoryEnemigo;
import Factories.FactoryProtagonista;

public class Mapa1 extends MapaGrilla {
	protected int ancho;
	protected int altura;
	public Mapa1(ImageIcon fondo, FactoryProtagonista fp, FactoryEnemigo fe, int ancho, int altura) {
		super(fondo, fp, fe, ancho, altura);
		for(int i =0 ; i<=3; i++) {
			for(int j = 0 ; j<=3; j++) {
				
			}
		}
	}
	protected void agregarMejoras() {
	Mejora m;
	//Comenzamos por la primer zona:
	int i = 0,j = 0;
	Zona z = zonas[0][0];
	int x = z.getX();
	int y = z.getY();
	//Primer zona:
	m = fabricaMejora.crearPuntoGrande(new PairTupla(x+(z.getAncho()/5),y+(z.getAlto()/5)), 10, 10, z);
	z.setEntidad(m);
	m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*2,y+(z.getAlto()/5)), 10, 10, z);
	z.setEntidad(m);
	m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*3,y+(z.getAlto()/5)), 10, 10, z);
	z.setEntidad(m);
	m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*4,y+(z.getAlto()/5)), 10, 10, z);
	z.setEntidad(m);
	m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5),y+(z.getAlto()/5)*2), 10, 10, z);
	z.setEntidad(m);
	m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*4,y+(z.getAlto()/5)*2), 10, 10, z);
	z.setEntidad(m);
	m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5),y+(z.getAlto()/5)*3), 10, 10, z);
	z.setEntidad(m);
	m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*3,y+(z.getAlto()/5)*3), 10, 10, z);
	z.setEntidad(m);
	m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*4,y+(z.getAlto()/5)*3), 10, 10, z);
	z.setEntidad(m);
	}
}
