package EnemigosStates;

import javax.swing.ImageIcon;

import Entities.Enemigo;

public class Encerrado implements EstadoEnemigo{
	protected Enemigo miEnemigo;
	
	public Encerrado(Enemigo e) {
		miEnemigo = e; 
		//deberiamos cambiar la imagen del enemigo en particular
	}
	public void realizarMovimiento() {
		// TODO Auto-generated method stub
		
	}

	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deboEscapar() {
		
	}

	@Override
	public void interactuarConProtagonista() {
		// TODO Auto-generated method stub
		
	}
	
	public void deboPerseguir() {
		
	}
	@Override
	public void actualizarFoto() {
	}

}
