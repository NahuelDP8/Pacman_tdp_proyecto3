package Entities;

import javax.swing.ImageIcon;
import Factories.FactoryEnemigo;
import Factories.FactoryMejora;
import Factories.FactoryProtagonista;
import Logic.Logica;
import Nivel.Nivel;

import java.awt.Rectangle;
import java.awt.Shape;
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
	protected Nivel miNivel;
	
	public MapaGrilla(ImageIcon fondo,FactoryProtagonista fp, FactoryEnemigo fe, int an, int al, Logica miLogica) {
		//Asignamos imagen de fondo del mapa
		miFondo = fondo;
		//Asignamos las fabricas correspondientes 
		fabricaProt = fp;
		fabricaEnem = fe;
		fabricaMejora = new FactoryMejora();
		ancho = an;
		altura = al;
		this.miLogica = miLogica;
		anchoMapa = 500;
		altoMapa = 540;
	}
	
	public void setNivel(Nivel n) {
		miNivel = n;
	}
	
	protected void agregarProtagonista() {
		miProtagonista = fabricaProt.crearProtagonista(new PairTupla(189, 290),30,30);
		miProtagonista.setGrilla(this);
	}
	
	protected void agregarFantasmas() {
		 this.misEnemigos.add(fabricaEnem.crearAzul(new PairTupla(243, 404),30,30));
		 this.misEnemigos.add(fabricaEnem.crearRosa(new PairTupla(243, 404),30,30));
		 this.misEnemigos.add(fabricaEnem.crearRojo(new PairTupla(243, 404),30,30));
		 this.misEnemigos.add(fabricaEnem.crearNaranja(new PairTupla(243, 404),30,30));
		//Faltaría setearlos a la grilla y a las zonas correspondientes
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


	public ImageIcon getImagenProtagonista() {
		return miProtagonista.getImagen();
	}
	
	private void actualizarZonas(ArrayList<Zona> l, Entidad e) {
		for(Zona auxZ : l) {
			if(!auxZ.getEntidades().contains(e)) {
				auxZ.setEntidad(e);
			}
		}
	}
	public void actualizarProtagonista() {
		ArrayList<Zona> zonasActivasDePro = mapeoPosEntidadAZona(miProtagonista);
		actualizarZonas(zonasActivasDePro, miProtagonista);
		miLogica.actualizarProtagonista(miProtagonista.getX(),miProtagonista.getY());
	}

	public void realizarMovimiento() {
		boolean huboColisiones  = verificarColisiones(miProtagonista);
		if(!huboColisiones) miProtagonista.realizarMovimiento();		
	}

	protected ArrayList<Zona> mapeoPosEntidadAZona(Entidad e) {
		ArrayList<Zona> toReturn = new ArrayList<Zona>();
		int x, y, ancho, largo;
		x = e.getX();
		y = e.getY();
		ancho = e.getAncho();
		largo = e.getAltura();
		int movimiento  =miProtagonista.getMovimientoActual();
		if (movimiento == 1)
			y += 4;
		else if(movimiento == 2)
			y-=4;
		else if(movimiento == 3)
			x-=4;
		else if(movimiento == 4)
			x +=4;
		for(int i =0; i<zonas.length; i++) {
			for(int j = 0; j<zonas[0].length; j++) {
				Zona agregamos = zonas[i][j];
				Shape auxiliar = agregamos.getRectangulo();
				if(auxiliar.intersects(x,y,ancho,largo))
						toReturn.add(agregamos);
			}
		}
		return toReturn;
	}
	
	public boolean verificarColisiones(Entidad e) {
		boolean huboColisiones = false;
		ArrayList<Zona> zonasActivasDeE = mapeoPosEntidadAZona(e);
		ArrayList<Entidad> entidadesColisionadasConE = entidadesColisionadas(zonasActivasDeE, e);
		if(entidadesColisionadasConE.size()!=0) {
			huboColisiones = true;
			for(Entidad aux : entidadesColisionadasConE)
				e.accept(aux.getVisitor());		
		}
		return huboColisiones; 
	}

	public ArrayList<Entidad> entidadesColisionadas(ArrayList<Zona> l, Entidad e){
		int x,y,an,al;
		x = e.getX();
		y = e.getY();
		an = e.getAncho();
		al = e.getAltura();
		int movimiento  =miProtagonista.getMovimientoActual();
		if (movimiento == 1)
			y += 4;
		else if(movimiento == 2)
			y-=4;
		else if(movimiento == 3)
			x-=4;
		else if(movimiento == 4)
			x+=4;
		
		ArrayList<Entidad> toReturn = new ArrayList<Entidad>();
		for(Zona aux : l) {
			for(Entidad auxEntidad : aux.getEntidades()) {
				if(auxEntidad != e) {
					if(auxEntidad.getRectangulo().intersects(x,y,an,al)) {
						if(!esRepetida(toReturn, auxEntidad))
							toReturn.add(auxEntidad);
					}
				}
			}
		}
		return toReturn;
	}
	
	//Nos devuelve si la entidad se encuentra ya o no en la lista correspondiente. 
	private boolean esRepetida(ArrayList<Entidad> l ,Entidad e) {
		boolean encontrado = false;
		for(int i =0; i<l.size() && !encontrado; i++) {
			if(e == l.get(i))
				encontrado = true;
		}
		return encontrado;
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
	
	public void desactivarPociones() {
	}
	public void activarPociones() {
		//Mandaría un mensaje a la lógica activando el timer relacionado a las pociones. 
	}

	public void activarFrutas() {
		//Mandaría un mensaje a la lógica activando el timer relacionado a las pociones.
		miLogica.activarFrutas(); 
		//Luego deberíamos obtener las frutas con las que se trabajará este nivel. 
	}
	
	public void desactivarFrutas() {
		//Mandaría un mensaje a la lógica activando el timer relacionado a las frutas.
	}
}
