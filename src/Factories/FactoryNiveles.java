package Factories;

import javax.swing.ImageIcon;
import Nivel.Nivel;
import Nivel.Nivel1;
import Nivel.Nivel2;
import Nivel.Nivel3;

public class FactoryNiveles {
		
	public Nivel crearNivel1() {
		Nivel1 nivel = new Nivel1();
		return nivel;
	}
	
	public Nivel crearNivel2() {
		Nivel2 nivel = new Nivel2();
		return nivel;
	}
	
	public Nivel crearNivel3() {
		Nivel3 nivel = new Nivel3();
		return nivel;
	}
		
	
}
