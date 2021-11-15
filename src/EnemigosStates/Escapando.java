package EnemigosStates;

import javax.swing.ImageIcon;

import Entities.Enemigo;

public class Escapando implements EstadoEnemigo{
	
	protected Enemigo miEnemigo; 
	
	public Escapando(Enemigo enemigo) {
		miEnemigo = enemigo; 
		//Deberiamos actualizar a imagen del enemigo particular
		miEnemigo.validarMovimientos();
	}

	@Override
	public void realizarMovimiento() {
		miEnemigo.realizarEscape(); 
	}

	@Override
	public ImageIcon getImagen() {
		return null;
	}

	@Override
	public void deboEscapar() {
		//no debemos hacer nada, ya que, ya estamos escapando.		
	}

	@Override
	public void interactuarConProtagonista() {
		miEnemigo.changeState(new Muerto(miEnemigo));
	}

	
	public void deboPerseguir() {
		miEnemigo.changeState(new Persiguiendo(miEnemigo));
		System.out.println("Pasamos al estado persiguiendo");
	}

}
