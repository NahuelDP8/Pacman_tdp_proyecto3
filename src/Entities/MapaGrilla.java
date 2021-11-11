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
	protected final int MOVER_ABAJO = 1;	
	protected final int MOVER_ARRIBA = 2;
	protected final int MOVER_IZQUIERDA = 3;
	protected final int MOVER_DERECHA = 4;
	
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
			}else
				auxZ.remove(e);
		}
	}
	public void actualizarProtagonista() {
		ArrayList<Zona> zonasActivasDePro = mapeoPosEntidadAZona(miProtagonista, miProtagonista.getMovimientoActual());
		actualizarZonas(zonasActivasDePro, miProtagonista);
		miLogica.actualizarProtagonista(miProtagonista.getX(),miProtagonista.getY());
	}

	public void realizarMovimiento() {
		boolean huboColisiones  = verificarColisiones(miProtagonista);
		if(!huboColisiones) miProtagonista.realizarMovimiento();		
	}

	public boolean verificarColisiones(Entidad e) {
		boolean huboColisiones = false;
		ArrayList<Zona> zonasActivasDeE = mapeoPosEntidadAZona(e, e.getMovimientoActual());
		ArrayList<Entidad> entidadesColisionadasConE = entidadesColisionadas(zonasActivasDeE, e, e.getMovimientoActual()); 
		if(entidadesColisionadasConE.size()!=0) {
			for(Entidad aux : entidadesColisionadasConE) {
				e.accept(aux.getVisitor());		
			}
		}
		if(miProtagonista.getColisiono())
			huboColisiones = true;
		miProtagonista.setColisiono(false);
			
		return huboColisiones; 
	}
	
	protected ArrayList<Zona> mapeoPosEntidadAZona(Entidad e, int movimiento) {
		ArrayList<Zona> toReturn = new ArrayList<Zona>();
		int x, y, ancho, largo;
		x = e.getX();
		y = e.getY();
		ancho = e.getAncho();
		largo = e.getAltura();
		
		//Preguntamos si estamos trabajando con una montidad que está en movimiento o no
		if(movimiento != 0) {
			int vel = miProtagonista.getVelocidad();
			if (movimiento == MOVER_ABAJO)
				y += vel;
			else if(movimiento == MOVER_ARRIBA)
				y-=vel;
			else if(movimiento == MOVER_IZQUIERDA)
				x-=vel;
			else if(movimiento == MOVER_DERECHA)
				x +=vel;
		}
		
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

	public ArrayList<Entidad> entidadesColisionadas(ArrayList<Zona> l, Entidad e, int movimiento){
		int x,y,an,al;
		x = e.getX();
		y = e.getY();
		an = e.getAncho();
		al = e.getAltura();
		
		if(movimiento != 0) {
			int vel = miProtagonista.getVelocidad();
			if (movimiento == MOVER_ABAJO)
				y += vel;
			else if(movimiento == MOVER_ARRIBA)
				y-=vel;
			else if(movimiento == MOVER_IZQUIERDA)
				x-=vel;
			else if(movimiento == MOVER_DERECHA)
				x +=vel;
		}
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
	abstract public void agregarFruta();

	abstract public void agregarPocion(); 
	
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
		miLogica.desactivarPociones();
	}
	public void activarPociones() {
		//Mandaría un mensaje a la lógica activando el timer relacionado a las pociones.
		miLogica.activarPocion();
	}

	public void activarFrutas() {
		//Mandaría un mensaje a la lógica activando el timer relacionado a las pociones.
		miLogica.activarFrutas(); 
		//Luego deberíamos obtener las frutas con las que se trabajará este nivel. 
	}
	
	public void desactivarFrutas() {
		miLogica.desactivarFrutas(); 
	}

	abstract public void quitarPocion() ; //aca podríamos tener una lista de frutas y pociones por separado, entonces armar un metodo generico para quitarlas de la vistas
	
	abstract public void quitarFruta() ;

	public void verificarMovimientoPosible() {
		ArrayList<Zona> zonasActivasDeE = mapeoPosEntidadAZona(miProtagonista, miProtagonista.getMovimientoActual());
		ArrayList<Entidad> entidadesColisionadasConE = entidadesColisionadas(zonasActivasDeE, miProtagonista, miProtagonista.getMovimientoActual()); 
		if(entidadesColisionadasConE.size()!=0) {
			for(Entidad aux : entidadesColisionadasConE) {
				miProtagonista.accept(aux.getVisitor());	
				return;
			}
		}
	}

	public void sacarPunto(Entidad punto) {
		ArrayList<Zona> zonasActivasDeE = mapeoPosEntidadAZona(punto, punto.getMovimientoActual());
		for(Zona z : zonasActivasDeE)
			z.remove(punto);
		miLogica.quitarDeLaGui(punto.getX(), punto.getY());
		punto = null;

	}

	public void actualizarPuntos(int i) {
		miLogica.actualizarPuntos(i);
	}
	
	public void colisionEnemigo(Enemigo e, int movimiento) {
		ArrayList<Zona> zonasActivasDeE = mapeoPosEntidadAZona(e, movimiento);
		ArrayList<Entidad> entidadesColisionadasConE = entidadesColisionadas(zonasActivasDeE, e, e.getMovimientoActual());		if(entidadesColisionadasConE.size()!=0) {
			for(int i = 0 ; i<entidadesColisionadasConE.size(); i++) {
				Entidad aux = entidadesColisionadasConE.get(i); 
				e.accept(aux.getVisitor());		
			}
			if(e.getColisionPared()){
				e.noColisioPared();
				e.invalidarMovimiento(movimiento); 
			}
			
		}
	}
	
	public void realizarMovimientoFantasma(Enemigo e, ArrayList<Integer> movimientos) {
		for(int i = 0 ; i<3; i++) {
			colisionEnemigo(e, movimientos.get(i));
		}
	}

	public PairTupla getPosicionActualProtagonista() {
		return new PairTupla(miProtagonista.getX(),miProtagonista.getY());
	}
}
