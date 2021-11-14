package EnemigosStates;

import javax.swing.ImageIcon;
import Entities.Enemigo;

public class Persiguiendo implements EstadoEnemigo{
	protected Enemigo miEnemigo; 

	public Persiguiendo(Enemigo e) {
		miEnemigo = e;
		//Deberiamos actualizar la imagen del enemigo particular;
	}

	public void realizarMovimiento() {
		miEnemigo.perseguirProtagonista(); 
	}

	@Override
	public ImageIcon getImagen() {
		return null;
	}

	@Override
	public void deboEscapar() {
		miEnemigo.changeState(new Escapando(miEnemigo));
	}

	@Override
	public void interactuarConProtagonista() {
		miEnemigo.notificarMuerteProtagonista(); 
	}
}
