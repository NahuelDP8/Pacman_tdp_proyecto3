package Mapas;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Entities.Entidad;
import Entities.Mejora;
import Entities.PairTupla;
import Entities.Pared;
import Factories.FactoryEnemigo;
import Factories.FactoryProtagonista;
import Logic.Logica;

public class Mapa1 extends MapaGrilla {
	protected int ancho;
	protected int altura;
	protected Mejora fruta;
	protected Mejora pocion;
	
	public Mapa1(ImageIcon fondo, FactoryProtagonista fp, FactoryEnemigo fe, int ancho, int altura, Logica miLogica) {
		super(fondo, fp, fe, ancho, altura, miLogica);
		construccionZonasGrilla(5,6);
		construccionParedesLimitaciones();
		agregarMejoras();
		agregarProtagonista();
		this.agregarFantasmas();
		fruta = fabricaMejora.crearFruta(new PairTupla(260,345-154), 20, 20);
		pocion = fabricaMejora.crearPocion(new PairTupla(230,450-154), 20, 20);
	}
	
	protected void agregarMejoras() {
		Mejora m;
		int x,y;
		agregarPowerPellets();
		for(int i = 1; i<31;i++) {
			for (int j = 0; j<33;j++) {
				x = 12+i*15;
				y = 22+j*15;
				if(!(x>155 &&  x<345 && y>183 && y<322) && !(x<50 && y <50) && !(y<50 && x > 440) && !(x<50 && y > 490)&& !(x>440 && y > 490)) {
					m = fabricaMejora.crearPunto(new PairTupla(x,y), 10, 10);
					ubicarPunto(m);
				}
			}
		}
	}
	private void agregarPowerPellets() {
		Mejora m;
		m = fabricaMejora.crearPuntoGrande(new PairTupla(40,20),25,25);
		miLogica.actualizarFruta(m.getImagen(), m.getX(), m.getY());
		zonas[0][0].setEntidad(m);
		m = fabricaMejora.crearPuntoGrande(new PairTupla(450,20),25,25);
		miLogica.actualizarFruta(m.getImagen(), m.getX(), m.getY());
		zonas[0][4].setEntidad(m);
		m = fabricaMejora.crearPuntoGrande(new PairTupla(40,500),25,25);
		miLogica.actualizarFruta(m.getImagen(), m.getX(), m.getY());
		zonas[5][0].setEntidad(m);
		m = fabricaMejora.crearPuntoGrande(new PairTupla(450,500),25,25);
		miLogica.actualizarFruta(m.getImagen(), m.getX(), m.getY());
		zonas[5][4].setEntidad(m);
		
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
			System.out.print("X:"+m.getX());
			System.out.print("Y:"+m.getY());

			miLogica.actualizarPunto(m.getImagen(), m.getX(), m.getY());
			for(Zona z:misZonas)
				z.setEntidad(m);
		}
	}
	protected void construccionParedesLimitaciones() {
		//Debemos llevar a cabo las limitaciones de acuerdo a la imagen del mapa que nosotros queremos representar
		
		//construimos las paredes del perímetro del mapa
		//primero realizamos las paredes en horizontal límitrofes
		Entidad p = new Pared(new PairTupla(0,0), 500, 12);
		for(int j = 0; j<=4; j++) {
			zonas [0][j].setEntidad(p);
		}
		
		p = new Pared(new PairTupla(0,528), 500, 12);
		for(int j = 0; j<=4; j++) {
			zonas [5][j].setEntidad(p);
		}
		
		//Ahora las paredes verticales realizamos las paredes en vertical límitrofes
		//Pared vertical, eje izquierdo parte superior. 
		p = new Pared(new PairTupla(0,0), 16, 240);
		for(int i = 0; i<=2; i++) {
			zonas [i][0].setEntidad(p);
		}
		//Pared vertical, eje izquierdo parte inferior. 
		p = new Pared(new PairTupla(0,270), 16, 270);
		for(int i = 3; i<=5; i++) {
			zonas [i][0].setEntidad(p);
		}
		
		//Pared vertical, eje derecho parte superior. 
		p = new Pared(new PairTupla(483,0), 18, 240);
		for(int i = 0; i<=2; i++) {
			zonas [i][4].setEntidad(p);
		}
		//Pared vertical, eje derecho parte inferior. 
		p = new Pared(new PairTupla(483,270), 18, 270);
		for(int i = 3; i<=5; i++) {
			zonas [i][4].setEntidad(p);
		}
		
		//Paredes de la primer fila.
		p = new Pared(new PairTupla(50,45), 55, 38);
		zonas [0][0].setEntidad(p); zonas [0][1].setEntidad(p);
		p = new Pared(new PairTupla(136,45), 72, 38);
		zonas [0][1].setEntidad(p); zonas [0][2].setEntidad(p);
		p = new Pared(new PairTupla(240,0), 20, 83);
		zonas [0][2].setEntidad(p);
		p = new Pared(new PairTupla(292,45), 72, 38);
		zonas [0][2].setEntidad(p);zonas [0][3].setEntidad(p);
		p = new Pared(new PairTupla(396,45), 56, 38);
		zonas [0][3].setEntidad(p);zonas [0][4].setEntidad(p);
		
		//Paredes de la segunda fila.
		p = new Pared(new PairTupla(50,116), 55, 18);
		zonas [1][0].setEntidad(p); zonas [1][1].setEntidad(p);
		p = new Pared(new PairTupla(138,116), 19, 120);
		zonas [1][1].setEntidad(p);zonas [2][1].setEntidad(p);
		p = new Pared(new PairTupla(188,116), 124, 18);
		zonas [1][1].setEntidad(p);zonas [1][2].setEntidad(p);zonas [1][3].setEntidad(p);
		p = new Pared(new PairTupla(344,116), 20, 121);
		zonas [1][3].setEntidad(p);zonas [2][3].setEntidad(p);
		p = new Pared(new PairTupla(396,116), 56, 18);
		zonas [1][3].setEntidad(p);zonas [1][4].setEntidad(p);
		
		//Paredes de la tercer fila.
		p = new Pared(new PairTupla(0,165), 105, 72);
		zonas [1][0].setEntidad(p);zonas [1][1].setEntidad(p); 
		zonas [2][0].setEntidad(p);zonas [2][1].setEntidad(p);
		p = new Pared(new PairTupla(157,165), 52, 20);
		zonas [1][1].setEntidad(p);zonas [1][2].setEntidad(p);
		zonas [2][1].setEntidad(p);zonas [2][2].setEntidad(p);
		p = new Pared(new PairTupla(240,134), 20, 50);
		zonas [1][2].setEntidad(p);zonas [2][2].setEntidad(p);
		p = new Pared(new PairTupla(293,165), 52, 20);
		zonas [1][2].setEntidad(p);
		zonas [2][2].setEntidad(p);
		zonas [1][3].setEntidad(p);
		zonas [2][3].setEntidad(p);
		p = new Pared(new PairTupla(396,165), 105, 72);
		zonas [1][3].setEntidad(p);zonas [1][4].setEntidad(p);
		zonas [2][3].setEntidad(p);zonas[2][4].setEntidad(p);
		
		//Paredes cuadrado del medio.
		p = new Pared(new PairTupla(189,218), 124, 72);
		zonas [2][1].setEntidad(p);zonas [2][2].setEntidad(p);zonas [2][3].setEntidad(p);
		zonas [3][1].setEntidad(p);zonas[3][2].setEntidad(p);zonas [3][3].setEntidad(p);
		
		//Paredes de la cuarta fila.
		p = new Pared(new PairTupla(0,270), 105, 72);
		zonas [3][0].setEntidad(p);zonas [3][1].setEntidad(p); 
		p = new Pared(new PairTupla(137,270), 20, 72);
		zonas [3][1].setEntidad(p);
		p = new Pared(new PairTupla(189,323), 124, 19);
		zonas [3][1].setEntidad(p);zonas [3][2].setEntidad(p);zonas [3][3].setEntidad(p);
		p = new Pared(new PairTupla(344,270), 20, 72);
		zonas [3][3].setEntidad(p);
		p = new Pared(new PairTupla(396,270), 105, 72);
		zonas [3][3].setEntidad(p);zonas [3][4].setEntidad(p);
		
		//Paredes de la quinta fila.
		p = new Pared(new PairTupla(49,372), 56, 18);
		zonas [4][0].setEntidad(p);zonas [4][1].setEntidad(p); 
		p = new Pared(new PairTupla(137,372), 72, 18);
		zonas [4][1].setEntidad(p);zonas [4][2].setEntidad(p);
		p = new Pared(new PairTupla(241,343), 20, 47);
		zonas [3][2].setEntidad(p);zonas [4][2].setEntidad(p);
		p = new Pared(new PairTupla(293,372), 72, 18);
		zonas [4][2].setEntidad(p);zonas [4][3].setEntidad(p);
		p = new Pared(new PairTupla(396,372), 56, 18);
		zonas [4][3].setEntidad(p);zonas [4][4].setEntidad(p);
		
		//Paredes de la sexta fila.
		p = new Pared(new PairTupla(0,423), 52, 20);
		zonas [4][0].setEntidad(p);
		p = new Pared(new PairTupla(85,393), 20, 50);
		zonas [4][0].setEntidad(p);zonas [4][1].setEntidad(p);
		p = new Pared(new PairTupla(137,423), 20, 50);
		zonas [4][1].setEntidad(p);zonas [5][1].setEntidad(p);
		p = new Pared(new PairTupla(189,423), 124, 20);
		zonas [4][1].setEntidad(p);zonas [4][2].setEntidad(p);zonas [4][3].setEntidad(p);
		p = new Pared(new PairTupla(344,423), 20, 50);
		zonas [4][3].setEntidad(p);zonas [5][3].setEntidad(p);
		p = new Pared(new PairTupla(396,393), 20, 50);
		zonas [4][3].setEntidad(p);zonas [4][4].setEntidad(p);
		p = new Pared(new PairTupla(447,423), 53, 20);
		zonas [4][4].setEntidad(p);
		
		//Paredes de la septima fila.
		p = new Pared(new PairTupla(49,479), 160, 19);
		zonas [5][0].setEntidad(p);zonas [5][1].setEntidad(p);zonas [5][2].setEntidad(p);
		p = new Pared(new PairTupla(241,449), 20, 49);
		zonas [5][0].setEntidad(p);zonas [5][1].setEntidad(p);zonas [5][2].setEntidad(p);
		p = new Pared(new PairTupla(293,479), 160, 19);
		zonas [5][2].setEntidad(p);zonas [5][3].setEntidad(p);zonas [5][4].setEntidad(p);
	}

	@Override
	public void agregarFruta() {
		zonas[2][2].setEntidad(fruta);
		miLogica.actualizarFruta(fruta.getImagen(),fruta.getX(),fruta.getY());	
	}
	
	public void agregarPocion() {
		zonas[3][2].setEntidad(pocion);
		miLogica.actualizarPocion(pocion.getImagen(),pocion.getX(),pocion.getY());	
	}

	@Override
	public void quitarPocion() {
		miLogica.quitarDeLaGui(pocion.getX(), pocion.getY());
	}

	@Override
	public void quitarFruta() {
		miLogica.quitarDeLaGui(fruta.getX(), fruta.getY());
	}
}
