package Entities;

import javax.swing.ImageIcon;

import Factories.FactoryEnemigo;
import Factories.FactoryProtagonista;
import Logic.Logica;

public class Mapa1 extends MapaGrilla {
	protected int ancho;
	protected int altura;

	public Mapa1(ImageIcon fondo, FactoryProtagonista fp, FactoryEnemigo fe, int ancho, int altura, Logica miLogica) {
		super(fondo, fp, fe, ancho, altura, miLogica);
		construccionZonasGrilla(4,4);
		construccionParedesLimitaciones();
		agregarProtagonista();
	}
	
	protected void agregarMejoras() {
		Mejora m;
		//Comenzamos por la primer zona:
		Zona z = zonas[0][0];
		int x = z.getX();
		int y = z.getY();
		//Primer zona:
		m = fabricaMejora.crearPuntoGrande(new PairTupla(x+(z.getAncho()/5),y+(z.getAlto()/5)), 10, 10);
		z.setEntidad(m);
		m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*2,y+(z.getAlto()/5)), 10, 10);
		z.setEntidad(m);
		m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*3,y+(z.getAlto()/5)), 10, 10);
		z.setEntidad(m);
		m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*4,y+(z.getAlto()/5)), 10, 10);
		z.setEntidad(m);
		m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5),y+(z.getAlto()/5)*2), 10, 10);
		z.setEntidad(m);
		m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*4,y+(z.getAlto()/5)*2), 10, 10);
		z.setEntidad(m);
		m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5),y+(z.getAlto()/5)*3), 10, 10);
		z.setEntidad(m);
		m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*3,y+(z.getAlto()/5)*3), 10, 10);
		z.setEntidad(m);
		m = fabricaMejora.crearPunto(new PairTupla(x+(z.getAncho()/5)*4,y+(z.getAlto()/5)*3), 10, 10);
		z.setEntidad(m);
	}
	protected void construccionParedesLimitaciones() {
		//Debemos llevar a cabo las limitaciones de acuerdo a la imagen del mapa que nosotros queremos representar
		
		//construimos las paredes de la zona [0][0]
		Zona z = zonas[0][0];
		int x = z.getX();
		int y = z.getY();
		
		
	}
	@Override
	protected void construccionParedeslimitaciones() {
		// TODO Auto-generated method stub

	}
}
