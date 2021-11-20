package Mapas;

import javax.swing.ImageIcon;

import Controladores.MovimientosControler;
import Controladores.PowerPelletsControler;
import Entities.Enemigo;
import Entities.Entidad;
import Entities.PairTupla;
import Entities.Protagonista;
import Entities.EntidadGrafica;
import Entities.Mejora;
import Factories.FactoryEnemigo;
import Factories.FactoryMapaGrilla;
import Factories.FactoryMejora;
import Factories.FactoryProtagonista;
import Logic.Logica;
import Nivel.Nivel;
import Timer.PotionVelocidadTimer;
import Timer.PowerPelletsTimer; 
import Controladores.SpeedPotionControler;
import java.awt.Shape;
import java.util.ArrayList;

abstract public class MapaGrilla {
	protected Logica miLogica;
	protected ImageIcon miFondo;
	protected FactoryProtagonista fabricaProt;
	protected FactoryEnemigo fabricaEnem;
	protected FactoryMejora fabricaMejora;
	protected FactoryMapaGrilla fabrica;
	protected Protagonista miProtagonista;
	protected PairTupla posInicialProtagonista;
	protected ArrayList<Enemigo> misEnemigos;
	protected Zona [][] zonas;
	protected int ancho, altura, anchoMapa, altoMapa;
	protected Nivel miNivel;
	protected final int MOVER_ABAJO = 1;	
	protected final int MOVER_ARRIBA = 2;
	protected final int MOVER_IZQUIERDA = 3;
	protected final int MOVER_DERECHA = 4;
	protected PowerPelletsControler controladorPowerPellets; 
	protected SpeedPotionControler controladorPrincipalSpeed; 
	public MovimientosControler controladorDeMovimientos; 
	protected int cantPuntos;
	protected PowerPelletsTimer ppTimer; 
	protected PotionVelocidadTimer pvTimer; 
	protected String[] paredes;
	
	public MapaGrilla(ImageIcon fondo,FactoryProtagonista fp, FactoryEnemigo fe, int an, int al, Logica miLogica,Nivel lvl) {
		//Asignamos imagen de fondo del mapa
		miFondo = fondo;
		miLogica.actualizarFondo(fondo);
		//Asignamos las fabricas correspondientes 
		fabricaProt = fp;
		fabricaEnem = fe;
		fabricaMejora = new FactoryMejora();
		ancho = an;
		altura = al;
		this.miLogica = miLogica;
		misEnemigos= new ArrayList<Enemigo>();
		controladorPowerPellets = new PowerPelletsControler(); 
		miNivel = lvl;
		controladorPrincipalSpeed = new SpeedPotionControler(miNivel.sleepProtagonista()); 
	}
	
	public void setNivel(Nivel n) {
		miNivel = n;
	}
	
	protected void agregarProtagonista() {
		miProtagonista = fabricaProt.crearProtagonista(new PairTupla(posInicialProtagonista.getX(),posInicialProtagonista.getY()),30,30,this);
		miProtagonista.setGrilla(this);
	}
	
	public int getSleepPowerPellets() {
		return miNivel.sleepPowerPellets(); 
	}
	
	protected void construccionZonasGrilla(int ancho, int alto) {
		//Inicializamos el tamaño de nuestra matriz de zonas
		zonas =  new Zona[alto][ancho];
		//Creamos las zonas
		int i = 0,j = 0;
		for(Zona[] zz:zonas) {
			for(Zona z:zz) {
				z = new Zona(1,new PairTupla(j*(anchoMapa/ancho),i*(altoMapa/alto)),anchoMapa/ancho,altoMapa/alto);
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
		for(int i =0; i<zonas.length; i++) {
			for(int j = 0; j<zonas[0].length; j++) {
				Zona z = zonas[i][j];
				if(l.contains(z) && !z.getEntidades().contains(e)) {
					z.setEntidad(e);
				}else
					z.remove(e);	
			}
		}
	}
	
	public void actualizarEntidad(Entidad e) {
		ArrayList<Zona> zonasActivasDePro = mapeoPosEntidadAZona(e, 0);
		actualizarZonas(zonasActivasDePro, e);
		if(e.getEntidad() != null) // Si tiene foto que represente esa entidad
			miLogica.actualizarEntidad(e.getEntidad(),e.getX(),e.getY(),false);
		
	}
		
	public void verificacionesPreMovimientoProtagonista() {
		miLogica.captar();
		boolean huboColisiones = verificarColisiones(miProtagonista);
		if(!huboColisiones) miProtagonista.realizarMovimiento();		
	}

	public boolean verificarColisiones(Entidad e) {
		actualizarEntidad(miProtagonista);
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
				if(auxiliar.intersects(x,y,ancho,largo)) {
					toReturn.add(agregamos);
				}
					
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
			int vel = 4;
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
	
	abstract public void quitarPocion() ;
	
	abstract public void quitarFruta() ;

	public void verificarMovimientoPosible() {
		ArrayList<Zona> zonasActivasDeE = mapeoPosEntidadAZona(miProtagonista, miProtagonista.getMovimientoActual());
		ArrayList<Entidad> entidadesColisionadasConE = entidadesColisionadas(zonasActivasDeE, miProtagonista, miProtagonista.getMovimientoActual()); 
		if(entidadesColisionadasConE.size()!=0) {
			for(Entidad aux : entidadesColisionadasConE) {
				miProtagonista.accept(aux.getVisitor());	
			}
		}
	}

	public void sacarEntidad(Entidad entidad) {
		ArrayList<Zona> zonasActivasDeE = mapeoPosEntidadAZona(entidad,0);
		for(Zona z : zonasActivasDeE)
			z.remove(entidad);
		miLogica.quitarDeLaGui(entidad.getEntidad());
		entidad = null;
	}

	public void actualizarPuntos(int i) {
		miLogica.actualizarPuntos(i);
	}
	
	public void colisionEnemigo(Enemigo e, int movimiento) {
		ArrayList<Zona> zonasActivasDeE = mapeoPosEntidadAZona(e, movimiento);
		ArrayList<Entidad> entidadesColisionadasConE = entidadesColisionadas(zonasActivasDeE, e, movimiento);		
		if(entidadesColisionadasConE.size()!=0) {
			for(int i = 0 ; i<entidadesColisionadasConE.size(); i++) {
				Entidad aux = entidadesColisionadasConE.get(i); 
				e.accept(aux.getVisitor());		
			}
			if(e.getColisionPared()){
				e.invalidarMovimiento(movimiento); 
				e.noColisioPared();
			}
			
		}
	}
	
	public void realizarMovimientoFantasma(Enemigo e, ArrayList<Integer> movimientos) {
		for(int i = 0 ; i<movimientos.size(); i++) {
			colisionEnemigo(e, movimientos.get(i));
		}
	}

	public PairTupla getPosicionActualProtagonista() {
		return new PairTupla(miProtagonista.getX(),miProtagonista.getY());
	}
	public int getMovimientoProtagonista() {
		return miProtagonista.getMovimientoActual();
	}
	public int getAnchoProtagonista() {
		return miProtagonista.getAncho();
	}

	public void añadirEntidad(EntidadGrafica miEntidad) {
		miLogica.añadirEntidad(miEntidad);	
	
	}

	public void restarPunto() {
		cantPuntos--;
		if(cantPuntos == 0) {
			for(Enemigo e: misEnemigos)
				sacarEntidad(e);
			sacarEntidad(miProtagonista);
			miLogica.nivelSiguiente(miNivel);
		}	
	}

	protected void agregarPowerPellets() {
		Mejora m;
		m = fabricaMejora.crearPuntoGrande(new PairTupla(25,20),22,22,this);
		actualizarEntidad(m);
		cantPuntos++;
		m = fabricaMejora.crearPuntoGrande(new PairTupla(anchoMapa-50,20),22,22,this);
		actualizarEntidad(m);
		cantPuntos++;
		m = fabricaMejora.crearPuntoGrande(new PairTupla(25,altoMapa-50),22,22,this);
		actualizarEntidad(m);
		cantPuntos++;
		m = fabricaMejora.crearPuntoGrande(new PairTupla(anchoMapa-50,altoMapa-50),22,22,this);
		actualizarEntidad(m);
		cantPuntos++;
	}
	

	public void gameOver() {
		//el juego se acaba por el protagonista ha perdido todas sus vidas. 
		//o ha ganado. 
	}

	public void protagonistaPierdeVida() {
		setearProtagonistaAPosicionInicial();
		miProtagonista.quitarVida();
		miLogica.quitarVida();
		//Debereíamos actualizar los labels de las vidas quitando una
		//Además, reiniciar el juego solo con las localizaciones originales del las entidades móviles y nada más. 
	}


	private  void setearProtagonistaAPosicionInicial() {
		miProtagonista.setPos(new PairTupla(posInicialProtagonista.getX(),posInicialProtagonista.getY()));
	}

	public void comunicarControlPrincipalSpeed(int velocidad) {
		controladorPrincipalSpeed.activarSuperVelocidadDePacman(velocidad, miNivel.sleepSuperSpeedPocion());
	}
	
	public void comunicarControlPowerPellet() {
		controladorPowerPellets.activarPowerPellet(miNivel.sleepPowerPellets(), misEnemigos); 
	}

	public abstract MapaGrilla mapaSiguiente(Nivel lvl);

	public void setFabrica(FactoryMapaGrilla fab) {
		fabrica = fab;
	}

}
