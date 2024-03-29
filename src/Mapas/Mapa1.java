package Mapas;

import javax.swing.ImageIcon;
import Controladores.MovimientosControler;
import EnemigosGenerales.Enemigo;
import Entities.Entidad;
import Improvements.Mejora; 
import Entities.PairTupla;
import EstructurasMapas.*; 
import Factories.FabricaDominio;
import Logic.Logica;
import Nivel.Nivel;

public class Mapa1 extends MapaGrilla {
	protected int ancho;
	protected int altura;
	protected Mejora fruta;
	protected Mejora pocion;
	protected Mejora bomba;
	
	public Mapa1(ImageIcon fondo, int an, int al, Logica miLogica,Nivel lvl,FabricaDominio f) {
		super(fondo,an, al,miLogica,lvl,f);
		anchoMapa = 500;
		altoMapa = 540;
		construccionZonasGrilla(5,6);
		/*Las paredes son representadas por un arreglos de strings, donde cada String tiene informacion de la pared que representa.
		Una representación alternativa podría haber sido representar los objetos del mapa
		en forma de "grilla" de caracteres, donde cada caracter representa el objeto que se dibujará en el mapa.
		Sin embargo, esta representación es muy superior, ya que, si bien la otra puede considerarse como más intuitiva,
		esta otorga la flexibilidad de crear paredes y objetos de las dimensiones y posiciones que desee
		de forma muy sencilla.*/
		/* Paredes: (x y ancho largo)*/
		paredes = new String[]{"50 45 55 38","136 45 72 38","240 0 20 83", "292 45 72 38","396 45 56 38", //Primer fila
				"50 116 55 18", "138 116 19 120", "188 116 124 18", "344 116 20 121", "396 116 56 18",//Segunda fila
				"0 165 105 72", "157 165 52 20","240 134 20 50","293 165 52 20", "396 165 105 72", // Tercer fila
				"189 218 12 72","189 218 30 12","252 218 61 27","189 277 124 13","301 218 12 72", //Paredes que componen el cuadrado del medio
				"0 270 105 72","137 270 20 72", "189 323 124 19", "344 270 20 72", "396 270 105 72",// Cuarta fila
				"49 372 56 18","137 372 72 18","241 343 20 47","293 372 72 18","396 372 56 18",// Quinta fila
				"0 423 52 20","85 393 20 50", "137 423 20 50", "189 423 124 20", "344 423 20 50","396 393 20 50","447 423 53 20",//Sexta fila
				"49 479 160 19", "241 449 20 49", "293 479 160 19",//Septima fila
				"0 0 500 12","0 528 500 12","0 0 16 237", "0 270 16 270", "483 0 18 237", "483 270 18 270"};//Bordes
		construccionParedesLimitaciones();
		
		posInicialProtagonista = new PairTupla(189, 86);
		posResurreccion = new PairTupla(201,246);
		posSalida = new PairTupla(221,186);
		agregarMejoras();
		agregarFantasmas();
		agregarPortales();
		agregarProtagonista();
		//Agregamos la puerta de la zona de los enemigos
		PuertaEnemigo puerta = new PuertaEnemigo(new PairTupla(219,218), 64, 12,this);
		actualizarEntidad(puerta);

		fruta = fabrica.crearFruta(new PairTupla(300,300), 20, 20,this);
		pocion = fabrica.crearPocion(new PairTupla(200,300), 20, 20,this);
		bomba = fabrica.crearBomba(new PairTupla(250,300), 20, 20,this);
		agregarFruta(); 
		agregarPocion(); 
		agregarBomba(); 

		controladorDeMovimientos = new MovimientosControler(miNivel.sleepProtagonista(), miNivel.sleepFantasmas(), miProtagonista, misEnemigos,miLogica.getConstanteMOVER_ENEMIGOS(),miLogica.getConstanteMOVER_PROTAGONISTA() ); 
		
	}
	
	protected void agregarMejoras() {
		Mejora m;
		int x,y;
		cantPuntos = 0;
		agregarPowerPellets();
		for(int i = 1; i<21;i++) {
			for (int j = 0; j<22;j++) {
				x = 9+i*24;
				y = 22+j*24;
				if(!(x>155 &&  x<345 && y>183 && y<322)) {
					m = fabrica.crearPunto(new PairTupla(x,y), 10,10,this);
					ubicarPunto(m);
				}
			}
		}
	}
	protected void agregarFantasmas() {
		
		 Enemigo rojo = fabrica.crearRojo(new PairTupla(posResurreccion.getX(),posResurreccion.getY()),30,30,this,posResurreccion,posSalida);
		 addEntidad(rojo.getEntidad());
		 this.misEnemigos.add(rojo);
		 Enemigo azul = fabrica.crearAzul(new PairTupla(posResurreccion.getX()+20,posResurreccion.getY()),30,30,this,rojo,posResurreccion,posSalida);
		 this.misEnemigos.add(azul);
		 addEntidad(azul.getEntidad());
		 Enemigo naranja = fabrica.crearNaranja(new PairTupla(posResurreccion.getX()+40,posResurreccion.getY()),30,30,this,posResurreccion,posSalida);
		 this.misEnemigos.add(naranja);
		 addEntidad(naranja.getEntidad());
		 Enemigo rosa = fabrica.crearRosa(new PairTupla(posResurreccion.getX()+60,posResurreccion.getY()),30,30,this,posResurreccion,posSalida);
		 this.misEnemigos.add(rosa);
		 addEntidad(rosa.getEntidad());
	}
	public void encerrarFantasmas() {
		PairTupla pos = new PairTupla(posResurreccion.getX(),posResurreccion.getY());
		for(Enemigo e:misEnemigos) {
			e.encerrar();
			e.setPos(new PairTupla(pos.getX(),pos.getY()));
			pos.setX(pos.getX() + 20);
		
			actualizarEntidad(e);
		}
	}
	protected void construccionParedesLimitaciones() {
		//Se lee la representación de las paredes, creandolas.
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

	public void agregarPortales() {
		Portal portalIzquierda = new Portal(new PairTupla(0,237),1,30,null,this);
		zonas [2][0].setEntidad(portalIzquierda);
		Portal portalDerecha  = new Portal(new PairTupla(499,237),1,30,null,this);
		zonas [2][4].setEntidad(portalDerecha);
		portalIzquierda.setMiDestino(portalDerecha.getX()-30,0);
		portalDerecha.setMiDestino(portalIzquierda.getX()+29,0);
	}
	
	public void agregarFruta() {
		actualizarEntidad(fruta);	
	}
	
	public void agregarPocion() {
		actualizarEntidad(pocion);	
	}
	public void agregarBomba() {
		actualizarEntidad(bomba);	
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
	protected void nivelSiguiente(Nivel lvl) {
		sacarTodo();
		miLogica.nivelSiguiente(lvl);
	}
}