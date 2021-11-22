package Mapas;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controladores.MovimientosControler;
import Entities.Enemigo;
import Entities.Entidad;
import Entities.Mejora;
import Entities.PairTupla;
import Entities.Pared;
import Entities.Portal;
import Entities.PuertaEnemigo;
import Factories.FactoryEnemigo;
import Factories.FactoryMapa;
import Factories.FactoryMapa1;
import Factories.FactoryMapa2;
import Factories.FactoryProtagonista;
import Logic.Logica;
import Nivel.Nivel;

public class Mapa3 extends MapaGrilla {
	protected int ancho;
	protected int altura;
	protected Mejora fruta;
	protected Mejora pocion;
	
	public Mapa3(ImageIcon fondo, FactoryProtagonista fp, FactoryEnemigo fe, int ancho, int altura, Logica miLogica,Nivel lvl) {
		super(fondo, fp, fe, ancho, altura, miLogica,lvl);
		anchoMapa = 680;
		altoMapa = 680;
		construccionZonasGrilla(8,8);
		paredes = new String[]{"47 45 10 290","90 45 31 314","154 45 32 249 ", "186 45 150 12", "369 45 159 12","496 45 32 249","561 45 32 314","626 45 10 290", //Primera fila
				"219 88 244 11","186 132 277 11","219 176 277 10","219 219 244 11",//Arriba del centro
				"186 263 150 30","369 263 159 30","219 263 31 200", "455 263 31 200","283 326 12 75","410 326 12 75","283 326 56 12","283 371 139 30","372 326 50 12", "219 434 117 29","369 434 117 29",//Centro del mapa
				"47 368 10 20","47 392 32 243","112 392 10 243","90 326 96 33","155 326 31 309",//Esquina inferior izquierda
				"219 463 10 172", "262 496 181 12","262 541 214 10","262 584 181 10","229 627 108 10","370 627 106 10", "476 463 10 172",//Abajo del centro
				"626 368 10 20","583 392 53 243","519 326 31 309", "519 326 74 33",//Esquina inferior derecha
				"0 0 14 335","0 368 14 312","0 0 336 14", "369 0 311 14", "0 668 335 14","369 668 335 12","669 0 11 335","669 368 11 312"};//Bordes
		construccionParedesLimitaciones();
		posInicialProtagonista = new PairTupla(300, 14);
		posResurreccion = new PairTupla(340,338);
		posSalida = new PairTupla(340,294);
		agregarMejoras();
		agregarFantasmas();
		agregarPortales();
		agregarProtagonista();
		//Agregamos la puerta de la zona de los enemigos
		PuertaEnemigo puerta = new PuertaEnemigo(new PairTupla(339,326), 33, 12,this);
		actualizarEntidad(puerta);
		fruta = fabricaMejora.crearFruta(new PairTupla(260,191), 20, 20,this);
		pocion = fabricaMejora.crearBomba(new PairTupla(230,196), 20, 20,this);
		agregarFruta(); 
		agregarPocion(); 
		
		controladorDeMovimientos = new MovimientosControler(miNivel.sleepProtagonista(), miNivel.sleepFantasmas(), miProtagonista, misEnemigos,miLogica.getConstanteMOVER_ENEMIGOS(),miLogica.getConstanteMOVER_PROTAGONISTA() ); 
		
	}
	
	protected void reiniciar() {
		agregarMejoras();
		Enemigo enemigo = misEnemigos.get(0);
		miProtagonista.setPos(new PairTupla(189, 290));
		enemigo.setPos(new PairTupla(365,50));
		
		miLogica.actualizarEntidad(enemigo.getEntidad(),enemigo.getX(),enemigo.getY(),false);
		miLogica.actualizarEntidad(miProtagonista.getEntidad(),miProtagonista.getX(),miProtagonista.getY(),false);
		
		miLogica.pintar();
	}
	protected void agregarMejoras() {
		Mejora m;
		int x,y;
		cantPuntos = 0;
		agregarPowerPellets();
		/*for(int i = 1; i<28;i++) {
			for (int j = 0; j<28;j++) {
				x = 9+i*24;
				y = 22+j*24;
				if(!(x>250 &&  x<455 && y>293 && y<434)) {
					m = fabricaMejora.crearPunto(new PairTupla(x,y), 10,10,this);
					ubicarPunto(m);
				}
			}
		}*/
	}
	public void encerrarFantasmas() {
		PairTupla pos = new PairTupla(posResurreccion.getX()-24,posResurreccion.getY());
		for(Enemigo e:misEnemigos) {
			e.encerrar();
			e.setPos(new PairTupla(pos.getX(),pos.getY()));
			pos.setX(pos.getX() + 20);
		
			actualizarEntidad(e);
		}
	}

	private void ubicarPunto(Mejora m) {
		Rectangle2D rect = m.getRectangulo().getBounds2D();
		ArrayList<Zona> misZonas = new ArrayList<Zona>();
		boolean colision = false;
		for (Zona[] zz: zonas) {
			for(Zona z: zz) {
				
				if(z.getRectangulo().intersects(rect)) {// el punto esta en la zona
					misZonas.add(z);
					for(Entidad e: z.getEntidades()) {
						if(e.getRectangulo().intersects(rect)){
							colision = true;
							break;
						}
					}
				}
			}
		}
		if(!colision) {
			cantPuntos++;
			for(Zona z:misZonas)
				z.setEntidad(m);
			miLogica.actualizarEntidad(m.getEntidad(),m.getX(),m.getY(),true);
			
		}else {
			miLogica.quitarDeLaGui(m.getEntidad());
			m.setEntidad(null);
			m= null;
		}
	}
	protected void construccionParedesLimitaciones() {
		int xPared,yPared,anchoPared,largoPared;
		Entidad p;
		for(String pared:paredes) {
			String[] componentesPared = pared.split(" ");
			xPared = Integer.valueOf(componentesPared[0]);
			yPared = Integer.valueOf(componentesPared[1]);
			anchoPared = Integer.valueOf(componentesPared[2]);
			largoPared = Integer.valueOf(componentesPared[3]);
			p = new Pared(new PairTupla(xPared,yPared), anchoPared, largoPared,this);
			actualizarEntidad(p);
		}
	}
	
	protected void agregarFantasmas() {
		Enemigo rojo = fabricaEnem.crearRojo(new PairTupla(posResurreccion.getX(),posResurreccion.getY()),30,30,this,posResurreccion,posSalida);
		
		 Enemigo azul = fabricaEnem.crearAzul(new PairTupla(posResurreccion.getX()+12,posResurreccion.getY()),30,30,this,rojo,posResurreccion,posSalida);
		 this.misEnemigos.add(azul);
		 addEntidad(azul.getEntidad());
		 Enemigo naranja = fabricaEnem.crearNaranja(new PairTupla(posResurreccion.getX()+36,posResurreccion.getY()),30,30,this,posResurreccion,posSalida);
		 this.misEnemigos.add(naranja);
		 addEntidad(naranja.getEntidad());
		 Enemigo rosa = fabricaEnem.crearRosa(new PairTupla(posResurreccion.getX()-24,posResurreccion.getY()),30,30,this,posResurreccion,posSalida);
		 this.misEnemigos.add(rosa);
		 addEntidad(rosa.getEntidad());
		 this.misEnemigos.add(rojo);
		 addEntidad(rojo.getEntidad());
	}
	public void agregarPortales() {
		//Hay que posicionarlos bien 
		Portal portalIzquierda = new Portal(new PairTupla(0,335),1,30,null,this);
		Portal portalDerecha  = new Portal(new PairTupla(679,335),1,30,null,this);
		Portal portalArriba = new Portal(new PairTupla(336,0),30,1,null,this);
		Portal portalAbajo  = new Portal(new PairTupla(336,679),30,1,null,this);
		portalIzquierda.setMiDestino(portalDerecha.getX()-31,0);
		portalDerecha.setMiDestino(portalIzquierda.getX()+4,0);
		portalArriba.setMiDestino(0,portalAbajo.getY()-33);
		portalAbajo.setMiDestino(0,portalArriba.getY()+14);
		
		actualizarEntidad(portalIzquierda);
		actualizarEntidad(portalDerecha);
		actualizarEntidad(portalAbajo);
		actualizarEntidad(portalArriba);
		
	}
	
	public void agregarFruta() {
		actualizarEntidad(fruta);	
	}
	
	public void agregarPocion() {
		actualizarEntidad(pocion);	
	}

	@Override
	public void quitarPocion() {
		sacarEntidad(pocion);
	}

	@Override
	public void quitarFruta() {
		sacarEntidad(fruta);
	}

	private void win() {
		miLogica.win();
		
	}
	@Override
	public FactoryMapa mapaSiguiente() {
		win();
		return null;
	}
}