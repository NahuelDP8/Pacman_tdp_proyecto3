package EnemigosStates;

import javax.swing.ImageIcon;
import Entities.Enemigo;

public class Persiguiendo implements EstadoEnemigo{
	protected Enemigo miEnemigo; 
	

	public Persiguiendo(Enemigo e) {
		// TODO Auto-generated constructor stub
	}

	public void realizarMovimiento() {
		miEnemigo.perseguirProtagonista(); 
	}

	@Override
	public ImageIcon getImagen() {
		return null;
	}


}
