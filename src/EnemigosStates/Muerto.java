package EnemigosStates;

import javax.swing.ImageIcon;
import Entities.Enemigo;

public class Muerto implements EstadoEnemigo{
	protected Enemigo miEnemigo; 
	public Muerto(Enemigo e) {
		miEnemigo = e; 
		//Deberiamos actualizar la imagen del enemigo particular
	}

	@Override
	public void realizarMovimiento() {
		miEnemigo.retornarZonaEnemigo(); 
	}

	@Override
	public ImageIcon getImagen() {
		return null;
	}

	@Override
	public void deboEscapar() {}

	@Override
	public void interactuarConProtagonista() {}

}
