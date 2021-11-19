package Logic;


import GUI.GUI_MAPA;
import Mapas.MapaGrilla;
import Nivel.Nivel;
import Timer.Timer;

import javax.swing.ImageIcon;

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
	protected final int MOVER_FANTASMA= 0;
	
	private Logica(GUI_MAPA g, FactoryMapaGrilla f, Nivel n) {
		miGUI = g;
		miFabrica = f;
		miNivel = n;
		miMapa = miFabrica.crearMapa1(this);
		miMapa.setFabrica(miFabrica);
		miMapa.setNivel(n);
		n.setMapa(miMapa);
		miReloj = new Timer(this);
		setearSleeps();
	}
	
	public void actualizarFondo(ImageIcon img) {
		miGUI.añadirFondo(img); 
		
	}

	public static Logica getLogic(GUI_MAPA g, FactoryMapaGrilla f, Nivel n) {
		if(logic == null) 
			logic = new Logica(g,f,n);
		return logic;
	}
	

	
	public void gameOver(){
		
	}
	
	public void actualizarSleepProtagonista(int i) {
		miReloj.setSleepProtagonista(i);
	}
	
	public void actualizarSleepFantasmas(int i) {
		miReloj.setSLeepFantasmas(i);
	}
	public void setEsperaFruta(int i) {
		miReloj.setTiempoEsperaDeFruta(i);
	}
	
	public void setEsperaPocion(int i) {
		miReloj.setTiempoEsperaDePocion(i);
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
	public void realizarMovimiento(int constante) {
		miMapa.realizarMovimiento(constante);
	}
	public void captar() {
		miGUI.captar();
	}

	public void activarFrutas() {
		miReloj.activarFruta();
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
	
	public void activarPocion() {
		miReloj.activarPocion();
		
	}

	public void actualizarEntidad(EntidadGrafica entidad, int x, int y,boolean frente) {
		miGUI.actualizarEntidad(entidad,x,y,frente);
	}

	public void desactivarPociones() {
		miReloj.desactivarPocion();
	}

	public void desactivarFrutas() {
		miReloj.desactivarFruta(); 
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
		miGUI.cargando(true);
		miMapa = miMapa.mapaSiguiente();
		n.setMapa(miMapa);
		miNivel = n;
		miMapa.setNivel(n);
		setearSleeps();
		miGUI.cargando(false);
	}
	
	private void setearSleeps() {
		actualizarSleepProtagonista(miNivel.sleepProtagonista());
		actualizarSleepFantasmas(miNivel.sleepFantasmas());
		this.setEsperaFruta(miNivel.sleepFruta());
		this.setEsperaPocion(miNivel.sleepPocion());
	}

	public int getCteFantasma() {
		// TODO Auto-generated method stub
		return MOVER_FANTASMA;
	}
	public int getCteProtagonista() {
		// TODO Auto-generated method stub
		return MOVER_PROTAGONISTA;
	}



	public void añadirFondo() {
		
	}

	public void pintar() {
		miGUI.pintar();
		
	}

	public void win() {
		//miGUI.win();
	}

}
