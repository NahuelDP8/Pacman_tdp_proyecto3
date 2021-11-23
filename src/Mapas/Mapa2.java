package Mapas;

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

import Factories.FactoryMapa3;
import Factories.FactoryMejora;
import Factories.FactoryProtagonista;
import Logic.Logica;
import Nivel.Nivel;

public class Mapa2 extends MapaGrilla {
	protected Mejora fruta;
	protected Mejora pocion;
	
	public Mapa2(ImageIcon fondo, FactoryProtagonista fp, FactoryEnemigo fe, int ancho, int altura, Logica miLogica,Nivel lvl,FactoryMejora fM) {
		super(fondo, fp, fe, ancho, altura, miLogica,lvl,fM);
		anchoMapa = 488;
		altoMapa = 540;
		construccionZonasGrilla(8,6);
		/*Las paredes son representadas por un arreglos de strings, donde cada String tiene informacion de la pared que representa.
		Una representación alternativa podría haber sido representar los objetos del mapa
		en forma de "grilla" de caracteres, donde cada caracter representa el objeto que se dibujará en el mapa.
		Sin embargo, esta representación es muy superior, ya que, si bien la otra puede considerarse como más intuitiva,
		esta otorga la flexibilidad de crear paredes y objetos de las dimensiones y posiciones que desee
		de forma muy sencilla.*/
		/* Paredes: (x y ancho largo)*/
		paredes = new String[]{"0 0 488 10","0 0 10 165", "0 198 10 142","0 373 10 167",//Bordes izquierda
				"0 530 488 10","478 0 10 165", "478 198 10 142","478 373 10 167",//Bordes derecha
				"43 43 54 19","43 95 54 19","43 95 19 70","130 43 19 71","130 95 72 19","182 0 19 62","95 147 54 18","182 147 125 18",//Esquina superior izquierda
				"234 43 19 122","286 0 19 62","286 95 71 19","338 43 19 71","390 43 55 19","390 95 55 19","426 95 19 70","340 147 53 19",//Esquina superior derecha
				//Centro
				"43 198 54 37", "130 198 19 124", "43 268 54 19", "78 268 19 124","43 373 54 19","0 321 45 19","182 198 12 70","295 198 12 70","182 198 46 22","260 198 47 22","182 253 125 15","182 301 125 19",
				"340 198 19 124", "392 198 53 37","392 268 53 19","392 268 19 124","392 373 53 19","444 320 44 19",
				"43 425 19 72","43 477 106 20", "95 425 54 19","130 355 19 89","130 355 71 19","182 407 19 90","182 477 124 20",//Esquina inferior izquierda
				"234 301 19 73","286 355 73 19","338 355 21 89","338 425 54 19", "234 407 19 37","286 407 19 90","338 477 107 19","426 425 19 72"//Esquina inferior derecha
		};
		construccionParedesLimitaciones();
		posInicialProtagonista = new PairTupla(350, 10);
		posResurreccion = new PairTupla(230,222);
		posSalida = new PairTupla(230,166);
		agregarMejoras();
		agregarFantasmas();
		agregarPortales();
		agregarProtagonista();
		//Agregamos la puerta de la zona de los enemigos
		PuertaEnemigo puerta = new PuertaEnemigo(new PairTupla(228,198), 33, 12,this);
		actualizarEntidad(puerta);
		fruta = fabricaMejora.crearFruta(new PairTupla(280,166), 20, 20,this);
		pocion = fabricaMejora.crearBomba(new PairTupla(230,166), 20, 20,this);
		agregarFruta(); 
		agregarPocion(); 
		controladorDeMovimientos = new MovimientosControler(miNivel.sleepProtagonista(), miNivel.sleepFantasmas(), miProtagonista, misEnemigos,miLogica.getConstanteMOVER_ENEMIGOS(),miLogica.getConstanteMOVER_PROTAGONISTA() ); 
		
	}
	protected void agregarMejoras() {
		Mejora m;
		int x,y;
		cantPuntos = 0;
		agregarPowerPellets();
		for(int i = 1; i<20;i++) {
			for (int j = 0; j<22;j++) {
				x = 9+i*24;
				y = 22+j*24;
				if(!(x>149 &&  x<340 && y>165 && y<301)) {
					m = fabricaMejora.crearPunto(new PairTupla(x,y), 10,10,this);
					ubicarPunto(m);
				}
			}
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
		Enemigo rojo = fabricaEnem.crearRojo(new PairTupla(posResurreccion.getX()-24,posResurreccion.getY()),30,30,this,posResurreccion,posSalida);
		
		 Enemigo azul = fabricaEnem.crearAzul(new PairTupla(posResurreccion.getX()-4,posResurreccion.getY()),30,30,this,rojo,posResurreccion,posSalida);
		 this.misEnemigos.add(azul);
		 addEntidad(azul.getEntidad());
		 Enemigo naranja = fabricaEnem.crearNaranja(new PairTupla(posResurreccion.getX()+16,posResurreccion.getY()),30,30,this,posResurreccion,posSalida);
		 this.misEnemigos.add(naranja);
		 addEntidad(naranja.getEntidad());
		 Enemigo rosa = fabricaEnem.crearRosa(new PairTupla(posResurreccion.getX()+36,posResurreccion.getY()),30,30,this,posResurreccion,posSalida);
		 this.misEnemigos.add(rosa);
		 addEntidad(rosa.getEntidad());
		 this.misEnemigos.add(rojo);
		 addEntidad(rojo.getEntidad());
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
	public void agregarPortales() {
		//Hay que posicionarlos bien 
		Portal portalIzquierda = new Portal(new PairTupla(0,165),1,30,null,this);
		Portal portalDerecha  = new Portal(new PairTupla(487,165),1,30,null,this);
		Portal portalIzquierda2 = new Portal(new PairTupla(0,340),1,30,null,this);
		Portal portalDerecha2  = new Portal(new PairTupla(487,340),1,30,null,this);
		portalIzquierda.setMiDestino(portalDerecha.getX()-33,0);
		portalDerecha.setMiDestino(portalIzquierda.getX()+6,0);
		portalIzquierda2.setMiDestino(portalDerecha2.getX()-33,0);
		portalDerecha2.setMiDestino(portalIzquierda2.getX()+6,0);
		
		actualizarEntidad(portalIzquierda);
		actualizarEntidad(portalDerecha);
		actualizarEntidad(portalIzquierda2);
		actualizarEntidad(portalDerecha2);
		
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
	@Override
	public FactoryMapa mapaSiguiente() {
		return new FactoryMapa3();
	}
	@Override
	protected void nivelSiguiente(Nivel lvl) {
		sacarTodo();
		miLogica.nivelSiguiente(lvl);
	}
}