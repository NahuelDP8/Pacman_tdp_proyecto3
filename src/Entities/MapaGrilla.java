package Entities;

import javax.swing.ImageIcon;

import Factories.FactoryEnemigo;
import Factories.FactoryMejora;
import Factories.FactoryProtagonista;
import Logic.Logica;

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
	protected int ancho;
	protected int altura; 
	
	public MapaGrilla(ImageIcon fondo,FactoryProtagonista fp, FactoryEnemigo fe, int an, int al) {
		miFondo = fondo;
		fabricaProt = fp;
		fabricaEnem = fe;
		fabricaMejora = new FactoryMejora();
		ancho = an;
		altura = al;
		zonas = new Zona[4][4];
		completarMapa();
		agregarProtagonista();
	}
	
	private void agregarProtagonista() {
		miProtagonista = fabricaProt.crearProtagonista(new PairTupla(100,100),50,50, zonas[0][0]);
		miProtagonista.setGrilla(this);
	}

	private void completarMapa() {
		//Creamos las zonas
		int i = 0,j = 0;
		for(Zona[] zz:zonas) {
			for(Zona z:zz) {
				z = new Zona(1,new PairTupla(i*(miFondo.getIconWidth()/4),i*(miFondo.getIconHeight()/4)),miFondo.getIconWidth()/4,miFondo.getIconHeight()/4);
				j++;
			}
			i++;
		}
		agregarParedes();
		agregarMejoras();
	}

	private void agregarParedes() {
		
	}

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
	//Métodos para agregar mejoras en el mapa
	public void agregarPunto() {
		
	}

	public void agregarEnemigoNaranja(){
		
	}
	public void agregarEnemigoAzul() {
		
	}
	public void agregarEnemigoRojo() {
		
	}
	public void agregarEnemigoRosa() {
		
	}
	public ImageIcon getImagenProtagonista() {
		return miProtagonista.getImagen();
	}
	public void actualizarProtagonista() {
		miLogica.actualizarProtagonista(miProtagonista.getX(),miProtagonista.getY());
	}
	public void setLogica(Logica logica) {
		miLogica = logica;
		
	}

	public void realizarMovimiento() {
		miProtagonista.realizarMovimiento();
		
	}
}
