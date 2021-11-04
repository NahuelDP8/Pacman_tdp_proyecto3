package Entities;

import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import Factories.FactoryEnemigo;
import Factories.FactoryProtagonista;
import Logic.Logica;

public class Mapa1 extends MapaGrilla {
	protected int ancho;
	protected int altura;

	public Mapa1(ImageIcon fondo, FactoryProtagonista fp, FactoryEnemigo fe, int ancho, int altura, Logica miLogica) {
		super(fondo, fp, fe, ancho, altura, miLogica);
		construccionZonasGrilla(5,6);
		construccionParedesLimitaciones();
		agregarMejoras();
		agregarProtagonista();
	}
	
	protected void agregarMejoras() {
		Mejora m;
		for(int i = 1; i<31;i++) {
			for (int j = 0; j<33;j++) {
				if(!((12+i*15)>155 &&  (12+i*15)<345 && (22+j*15)>183 && (22+j*15)<322)) {
					m = fabricaMejora.crearPunto(new PairTupla(12+i*15,22+j*15), 10, 10);
					ubicarPunto(m);
				}
			}
		}
	}
	private void ubicarPunto(Mejora m) {
		Rectangle2D rect = m.getRectangulo().getBounds2D();
		boolean colision = false;
		for (Zona[] zz: zonas) {
			for(Zona z: zz) {
				
				if(z.getRectangulo().intersects(rect)) {// el punto esta en la zona
					for(Entidad e: z.getEntidades()) {
						if(e.getRectangulo().intersects(rect)){
							colision = true;
							break;
						}
					}
				}
			}
		}
		if(!colision)
			miLogica.actualizarPunto(m.getImagen(), m.getX(), m.getY());
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
}
