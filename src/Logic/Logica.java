package Logic;


import javax.swing.ImageIcon;
import GUI.GUI_MAPA;
import Nivel.Nivel;
import Timer.Timer;
import Entities.*;
import Factories.FactoryMapaGrilla;

public class Logica {

	private GUI_MAPA miGUI;
	private Timer miTimer;
	private MapaGrilla miMapa;
	protected FactoryMapaGrilla miFabrica;
	protected Timer miReloj;
	protected Nivel miNivel;
	
	public Logica(GUI_MAPA g, FactoryMapaGrilla f, Nivel n) {
		miGUI = g;
		miFabrica = f;
		miMapa = miFabrica.crearMapa(this);
		n.setMapa(miMapa);
		miNivel = n;
		miMapa.setNivel(n);

		
		//Trabajo con la gui
		miReloj = new Timer(this);
		miGUI.actualizarFondo(miMapa.getImage());
		miGUI.fotoProtagonista(miMapa.getImagenProtagonista(),100,100);
		actualizarSleepProtagonista(miNivel.sleepProtagonista());
		actualizarSleepFantasmas(miNivel.sleepFantasmas());
		this.setEsperaFruta(miNivel.sleepFruta());
		this.setEsperaPocion(miNivel.sleepPocion());
		n.llevarACaboActivaciones();
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
	public void actualizarProtagonista(int x,int y) {
		miGUI.actualizarProtagonista(miMapa.getImagenProtagonista(),x,y);
	}
	public void actualizarPunto(ImageIcon img, int x,int y) {
		miGUI.actualizarPunto(img,x,y);
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
	public void realizarMovimiento() {
		miGUI.captar();
		miMapa.realizarMovimiento();
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
	

	public void actualizarPocion(ImageIcon img, int x, int y) {
		miGUI.actualizarMejora(img,x,y);
		
	}
	public void actualizarFruta(ImageIcon img, int x, int y) {
		miGUI.actualizarMejora(img,x,y);
	}

	public void desactivarPociones() {
		miReloj.desactivarPocion();
	}

	public void desactivarFrutas() {
		miReloj.desactivarFruta(); 
	}

	public void quitarDeLaGui(int x, int y) {
		miGUI.quitarEntidad(x, y);
	}

	public void actualizarPuntos(int puntos) {
		miGUI.actualizarPuntos(puntos);
		
	}

}
