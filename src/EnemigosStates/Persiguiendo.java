package EnemigosStates;

import javax.swing.ImageIcon;
import Entities.Enemigo;

public class Persiguiendo implements EstadoEnemigo{
	protected Enemigo miEnemigo; 
	private ImageIcon miImagen;

	public Persiguiendo(Enemigo e) {
		miEnemigo = e;
		miImagen= miEnemigo.getImagen();
		//Deberiamos actualizar la imagen del enemigo particular;
	}

	public void realizarMovimiento() {
		miEnemigo.perseguirProtagonista(); 
	}

	@Override
	public ImageIcon getImagen() {
		return miImagen;
	}

	@Override
	public void deboEscapar() {
		invertirMovimiento();
		miEnemigo.changeState(new Escapando(miEnemigo));
	}

	private void invertirMovimiento() {
		if(miEnemigo.getMovimientoActual() == miEnemigo.getIzquierda()) 
			miEnemigo.setMovimientoActual(miEnemigo.getDerecha());
		else if(miEnemigo.getMovimientoActual() == miEnemigo.getDerecha()) 
			miEnemigo.setMovimientoActual(miEnemigo.getIzquierda());
		else if(miEnemigo.getMovimientoActual() == miEnemigo.getArriba()) 
			miEnemigo.setMovimientoActual(miEnemigo.getAbajo());
		else if(miEnemigo.getMovimientoActual() == miEnemigo.getAbajo()) 
			miEnemigo.setMovimientoActual(miEnemigo.getArriba());
		 
	}

	@Override
	public void interactuarConProtagonista() {
		miEnemigo.notificarMuerteProtagonista(); 
	}

	
	public void deboPerseguir() {
		
	}

	@Override
	public void actualizarFoto() {
		miEnemigo.actualizarFoto();
		
	}
	
}
