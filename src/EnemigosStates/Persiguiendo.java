package EnemigosStates;

import javax.swing.ImageIcon;
import Entities.Enemigo;

public class Persiguiendo implements EstadoEnemigo{
	private Enemigo miEnemigo; 
	
	public Persiguiendo(Enemigo e) {
		miEnemigo = e; 
	}
	
	public void realizarMovimiento() {
		miEnemigo.perseguirPrincipal(); 
	}

	@Override
	public ImageIcon getImagen() {
		return null;
	}

}
