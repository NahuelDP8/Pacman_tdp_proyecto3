package Entities;

import javax.swing.ImageIcon;
import Factories.FactoryEnemigo;
import Factories.FactoryMejora;
import Factories.FactoryProtagonista;
import Logic.Logica;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

abstract public class MapaGrilla {
	protected Logica miLogica;
	protected ImageIcon miFondo;
	protected FactoryProtagonista fabricaProt;
	protected FactoryEnemigo fabricaEnem;
	protected FactoryMejora fabricaMejora;
	protected Protagonista miProtagonista;
	protected ArrayList<Enemigo> misEnemigos;
	protected Zona [][] zonas;
	protected int ancho, altura, anchoMapa, altoMapa;
	
	public MapaGrilla(ImageIcon fondo,FactoryProtagonista fp, FactoryEnemigo fe, int an, int al, Logica miLogica) {
		miFondo = fondo;
		fabricaProt = fp;
		fabricaEnem = fe;
		fabricaMejora = new FactoryMejora();
		ancho = an;
		altura = al;
		this.miLogica = miLogica;
		anchoMapa = 500;
		altoMapa = 540;
	}
	

	protected void agregarProtagonista() {
		miProtagonista = fabricaProt.crearProtagonista(new PairTupla(189, 290),30,30);
		miProtagonista.setGrilla(this);
	}

	protected void construccionZonasGrilla(int ancho, int alto) {
		//Inicializamos el tamaño de nuestra matriz de zonas
		zonas =  new Zona[alto][ancho];
		//Creamos las zonas
		int i = 0,j = 0;
		for(Zona[] zz:zonas) {
			for(Zona z:zz) {
				z = new Zona(1,new PairTupla(j*(anchoMapa/5),i*(altoMapa/6)),anchoMapa/5,altoMapa/6);
				zonas[i][j] = z;
				j++;
			}
			j=0;
			i++;
		}

	}
	
	abstract protected void construccionParedesLimitaciones();

	abstract protected void agregarMejoras();
	
	public ImageIcon getImage() {
		return miFondo;
	}
	
	public void moverProtagonistaAbajo() {
		miProtagonista.moverAbajo();
	}
	public void moverProtagonistaArriba() {
		miProtagonista.moverArriba();
	}
	public void moverProtagonistaDerecha() {
		miProtagonista.moverDerecha();
	}
	public void moverProtagonistaIzquierda() {
		miProtagonista.moverIzquierda();
	}

	public void agregarEnemigoNaranja(){
		misEnemigos.add(fabricaEnem.crearNaranja(null, ancho, altura));
	}
	public void agregarEnemigoAzul() {
		misEnemigos.add(fabricaEnem.crearAzul(null, ancho, altura));
	}
	public void agregarEnemigoRojo() {
		misEnemigos.add(fabricaEnem.crearRojo(null, ancho, altura));
	}
	public void agregarEnemigoRosa() {
		misEnemigos.add(fabricaEnem.crearRosa(null, ancho, altura));
	}
	public ImageIcon getImagenProtagonista() {
		return miProtagonista.getImagen();
	}
	public void actualizarProtagonista() {
		miLogica.actualizarProtagonista(miProtagonista.getX(),miProtagonista.getY());
	}

	public void realizarMovimiento() {
		miProtagonista.realizarMovimiento();
		
	}


	public boolean colision(int movimiento) {
		int x,y,an,al;
		x = miProtagonista.getX();
		y = miProtagonista.getY();
		an = miProtagonista.getAncho();
		al = miProtagonista.getAltura();
		if (movimiento == 1)
			y += 4;
		else if(movimiento == 2)
			y-=4;
		else if(movimiento == 3)
			x-=4;
		else if(movimiento == 4)
			x+=4;
		boolean colision = false;
		for(Zona[] zz:zonas) {
			for(Zona z:zz) {
				if(z.getRectangulo().intersects(x,y,an,al)) {// el punto esta en la zona
					for(Entidad e: z.getEntidades()) {
						if(e.getRectangulo().intersects(x,y,an,al)){
							colision = true;
							break;
						}
					}
				}
			}
		}
		return colision;
	}

}
