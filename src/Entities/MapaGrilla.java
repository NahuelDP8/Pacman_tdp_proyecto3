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
	
	public MapaGrilla(ImageIcon fondo,FactoryProtagonista fp, FactoryEnemigo fe, int an, int al, Logica miLogica) {
		miFondo = fondo;
		fabricaProt = fp;
		fabricaEnem = fe;
		fabricaMejora = new FactoryMejora();
		ancho = an;
		altura = al;
		this.miLogica = miLogica;
	}
	

	protected void agregarProtagonista() {
		miProtagonista = fabricaProt.crearProtagonista(new PairTupla(563,400),50,50);
		miProtagonista.setGrilla(this);
	}

	protected void construccionZonasGrilla(int ancho, int alto) {
		//Inicializamos el tamaño de nuestra matriz de zonas
		zonas =  new Zona[ancho][alto];
		//Creamos las zonas
		int i = 0,j = 0;
		for(Zona[] zz:zonas) {
			for(Zona z:zz) {
				z = new Zona(1,new PairTupla(i*(miFondo.getIconWidth()/ancho),i*(miFondo.getIconHeight()/alto)),miFondo.getIconWidth()/4,miFondo.getIconHeight()/4);
				zonas[i][j] = z;
				j++;
			}
			j=0;
			i++;
		}
	}
	
	abstract protected void construccionParedeslimitaciones();
	private void agregarParedes() {}

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
	public void setLogica(Logica logica) {
		miLogica = logica;
		
	}

	public void realizarMovimiento() {
		miProtagonista.realizarMovimiento();
		
	}
}
