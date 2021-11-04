package Logic;

import GUI.GUI;

import javax.swing.ImageIcon;

import GUI.GUI_MAPA;
import Nivel.Nivel;
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
		actualizarVelocidadProtagonista(miNivel.velocidadProtagonista());
		actualizarVelocidadFantasmas(miNivel.velocidadFantasmas());
		n.llevarACaboActivaciones();
	}
	
	public void actualizarVelocidadProtagonista(int i) {
		miReloj.setSleepProtagonista(i);
	}
	
	public void actualizarVelocidadFantasmas(int i) {
		miReloj.setSLeepFantasmas(i);
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
		miMapa.realizarMovimiento();
	}

	public void activarFrutas() {
		miReloj.activarFruta();
		
	}

	public void mostrarFrutas() {
		miMapa.agregarFruta();
	}
}
