package Entities;

import javax.swing.ImageIcon;
import Factories.FactoryEnemigo;
import Factories.FactoryMejora;
import Factories.FactoryProtagonista;
import Logic.Logica;
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
		//Inicializamos el tama�o de nuestra matriz de zonas
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
			if(!auxZ.getEntidades().contains(e))
				auxZ.setEntidad(e);
		}
	}
	public void actualizarProtagonista() {
		ArrayList<Zona> zonasActivasDePro = mapeoPosEntidadAZona(miProtagonista);
		actualizarZonas(zonasActivasDePro, miProtagonista);
		miLogica.actualizarProtagonista(miProtagonista.getX(),miProtagonista.getY());
	}

	public void realizarMovimiento() {
		boolean huboColisiones  = verificarColisiones(miProtagonista);
		System.out.println(huboColisiones);
		if(!huboColisiones) miProtagonista.realizarMovimiento();
		
	}

	protected ArrayList<Zona> mapeoPosEntidadAZona(Entidad e) {
		ArrayList<Zona> toReturn = new ArrayList<Zona>();
		Rectangle2D rect = e.getRectangulo().getBounds2D();
		for(int i =0; i<zonas.length; i++) {
			for(int j = 0; j<zonas[0].length; j++) {
				Zona agregamos = zonas[i][j];
				Shape auxiliar = agregamos.getRectangulo();
				if(auxiliar.intersects(rect))
						toReturn.add(agregamos);
			}
		}
		return toReturn;
	}
	
	public boolean verificarColisiones(Entidad e) {
		boolean huboColisiones = false;
		ArrayList<Zona> zonasActivasDeE = mapeoPosEntidadAZona(e);
		ArrayList<Entidad> entidadesColisionadasConE = entidadesColisionadas(zonasActivasDeE, e);
		System.out.println(entidadesColisionadasConE.size()+"este era el tamanio de la lista");
		//System.out.println(entidadesColisionadasConE.get(0).ancho+"este era el ancho de una pared");
		//System.out.println(entidadesColisionadasConE.get(0).altura+"este era el altura de una pared");
		if(entidadesColisionadasConE.size()!=0) {
			huboColisiones = true;
			for(Entidad aux : entidadesColisionadasConE)
				e.accept(aux.getVisitor());		
		}
		return huboColisiones; 
	}

	private ArrayList<Entidad> entidadesColisionadas(ArrayList<Zona> l, Entidad e){
		ArrayList<Entidad> toReturn = new ArrayList<Entidad>();
		Shape boundE = e.getRectangulo();
		for(Zona aux : l) {
			for(Entidad auxEntidad : aux.getEntidades()) {
				if(auxEntidad != e) {
					if(boundE.intersects(auxEntidad.getRectangulo().getBounds())) {
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
	
	/*public boolean colision(int movimiento) {
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
	}*/
}
