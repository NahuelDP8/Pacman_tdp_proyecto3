package Logic;


import GUI.GUI_MAPA;
import Mapas.MapaGrilla;
import Nivel.Nivel;
import Timer.Timer;

import javax.swing.ImageIcon;

import Entities.EntidadGrafica;
import Entities.PairTupla;
import Entities.Protagonista;
import Factories.FactoryMapa;
import Factories.FactoryMapaGrilla;

public class Logica {
	private static Logica logic;
	private GUI_MAPA miGUI;
	private MapaGrilla miMapa;
	protected FactoryMapaGrilla miFabrica;
	protected Timer miReloj;
	protected Nivel miNivel;
	protected final int MOVER_PROTAGONISTA = 1;
	protected final int MOVER_ENEMIGO= 0;
	protected final int MOVER_ABAJO = 1;	
	protected final int MOVER_ARRIBA = 2;
	protected final int MOVER_IZQUIERDA = 3;
	protected final int MOVER_DERECHA = 4; 
	
	private Logica(GUI_MAPA g, FactoryMapaGrilla f, Nivel n,FactoryMapa map) {
		miGUI = g;
		miFabrica = f;
		miNivel = n;
		miMapa = f.crearMapa(this, n, map);
		miMapa.setFabrica(miFabrica);
		miMapa.setNivel(n);
		n.setMapa(miMapa);
		miReloj = new Timer(this);
	}
	
	public static Logica getLogic(GUI_MAPA g, FactoryMapaGrilla f, Nivel n,FactoryMapa map) {
		if(logic == null) 
			logic = new Logica(g,f,n,map);
		return logic;
	}
	public static Logica getLogica() {
		return logic; 
	}
	public void actualizarFondo(ImageIcon img) {
		miGUI.añadirFondo(img); 
	}

	public void gameOver(){
		miGUI.gameOver();
		miReloj.gameOver();
	}

	public void actualizarReloj() {
		//Llamamos a la Gui para que el reloj se actualice. 
		this.miGUI.actualizarReloj(miReloj.getMinutos(), miReloj.getSegundos());
	}
	
	public void moverProtagonistaAbajo() {
		miMapa.moverProtagonistaAbajo();
	}
	public void moverProtagonistaArriba() {
		miMapa.moverProtagonistaArriba();
	}
	public void moverProtagonistaDerecha() {
		miMapa.moverProtagonistaDerecha();
	}
	public void moverProtagonistaIzquierda() {
		miMapa.moverProtagonistaIzquierda();
	}
	
	public void captar() {
		miGUI.captar();
	}

	public void mostrarFrutas() {
		miMapa.agregarFruta();
	}
	
	public void mostrarPociones() {
		miMapa.agregarPocion();
	}
	
	public void eliminarPocion() {
		miMapa.quitarPocion(); 
	}
	public void eliminarFruta() {
		miMapa.quitarFruta(); 
	}


	public void actualizarEntidad(EntidadGrafica entidad, int x, int y,boolean frente) {
		miGUI.actualizarEntidad(entidad,x,y,frente);
	}


	public void quitarDeLaGui(EntidadGrafica entidad) {
		miGUI.quitarEntidad(entidad);
	}

	public void actualizarPuntos(int puntos) {
		miGUI.actualizarPuntos(puntos);
		
	}
	public void addEntidad(EntidadGrafica miEntidad) {
		miGUI.addEntidadGrafica(miEntidad);
		
	}
	
	public void quitarVida() {
		miGUI.quitarVida();
	}

	public void nivelSiguiente(Nivel n) {System.out.print("PUTA");
		miGUI.cargando(true);
		miNivel = n.nivelSiguiente();
		miMapa = miFabrica.crearMapa(this, n, miMapa.mapaSiguiente());
		miNivel.setMapa(miMapa);
		miGUI.setJLNivel(miNivel.getNivel());
		miGUI.reinicioDVidas();
		miGUI.cargando(false);
	}

	public int getCteFantasma() {
		// TODO Auto-generated method stub
		return MOVER_ENEMIGO;
	}
	public int getCteProtagonista() {
		// TODO Auto-generated method stub
		return MOVER_PROTAGONISTA;
	}

	public void pintar() {
		miGUI.pintar();
		
	}
	public int getConstanteMOVER_PROTAGONISTA() {
		return MOVER_PROTAGONISTA; 
	}
	public int getConstanteMOVER_ENEMIGOS() {
		return MOVER_ENEMIGO; 
	}

	public void win() {
		miGUI.win();
	}

	public void ponerBomba() {
		miMapa.ponerBomba();
		
	}
	public void destruirSingleton() {
		logic = null;
	}
	public void activarBomba() {
		miGUI.activarBomba();
		
	}
	public void desactivarBomba() {
		miGUI.desactivarBomba();
	}
	
	public int getCnsMOVER_ABAJO() {
		return MOVER_ABAJO; 
	}
	public int getCnsMOVER_ARRIBA() {
		return MOVER_ARRIBA; 
	}
	public int getCnsMOVER_IZQUIERDA() {
		return MOVER_IZQUIERDA; 
	}
	public int getCnsMOVER_DERECHA() {
		return MOVER_DERECHA; 
	}

}
