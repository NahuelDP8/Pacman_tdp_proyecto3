package Logic;


import GUI.GUI_MAPA;
import Mapas.MapaGrilla;
import Nivel.Nivel;
import Timer.Timer;

import Entities.EntidadGrafica;
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
	
	private Logica(GUI_MAPA g, FactoryMapaGrilla f, Nivel n) {
		miGUI = g;
		miFabrica = f;
		miMapa = miFabrica.crearMapa(this);
		miReloj = new Timer(this);
		nivelSiguiente(n);
		miGUI.añadirFondo(miMapa.getImage()); 
	}
	
	public static Logica getLogic(GUI_MAPA g, FactoryMapaGrilla f, Nivel n) {
		if(logic == null) 
			logic = new Logica(g,f,n);
		return logic;
	}
	

	
	public void gameOver(){
		
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
	public void añadirEntidad(EntidadGrafica miEntidad) {
		miGUI.añadirEntidadGrafica(miEntidad);
		
	}
	
	public void quitarVida() {
		miGUI.quitarVida();
	}

	public void nivelSiguiente(Nivel n) {
		n.setMapa(miMapa);
		miNivel = n;
		miMapa.setNivel(n);
		//actualizarSleepProtagonista(miNivel.sleepProtagonista());
		//actualizarSleepFantasmas(miNivel.sleepFantasmas());
		//this.setEsperaFruta(miNivel.sleepFruta());
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

}
