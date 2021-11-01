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
		construccionZonasGrilla(5,6);
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
		Zona z;
		//Debemos llevar a cabo las limitaciones de acuerdo a la imagen del mapa que nosotros queremos representar
		
		//construimos las paredes del perímetro del mapa
		//primero realizamos las paredes en horizontal límitrofes
		Entidad p = new Pared(new PairTupla(0,0), 500, 12);
		for(int j = 0; j<=4; j++) {
			zonas [0][j].setEntidad(p);
		}
		
		p = new Pared(new PairTupla(0,528), 500, 12);
		for(int j = 0; j<=4; j++) {
			zonas [5][j].setEntidad(p);
		}
		
		//Ahora las paredes verticales realizamos las paredes en vertical límitrofes
		//Pared vertical, eje izquierdo parte superior. 
		p = new Pared(new PairTupla(0,0), 18, 240);
		for(int i = 0; i<=2; i++) {
			zonas [i][0].setEntidad(p);
		}
		//Pared vertical, eje izquierdo parte inferior. 
		p = new Pared(new PairTupla(0,270), 18, 270);
		for(int i = 3; i<=5; i++) {
			zonas [i][0].setEntidad(p);
		}
		
		//Pared vertical, eje derecho parte superior. 
		p = new Pared(new PairTupla(483,0), 18, 240);
		for(int i = 0; i<=2; i++) {
			zonas [i][4].setEntidad(p);
		}
		//Pared vertical, eje derecho parte inferior. 
		p = new Pared(new PairTupla(483,270), 18, 270);
		for(int i = 3; i<=5; i++) {
			zonas [i][4].setEntidad(p);
		}
		
	}
	@Override
	protected void construccionParedeslimitaciones() {
		// TODO Auto-generated method stub

	}
}
