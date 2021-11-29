package EnemigosStates;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import Entities.Enemigo;

public class Muerto implements EstadoEnemigo{
	protected Enemigo miEnemigo; 
	private ImageIcon miImagen;
	
	public Muerto(Enemigo e) {
		miEnemigo = e; 
		miImagen=miEnemigo.getImagenMuerte();
		//Deberiamos actualizar la imagen del enemigo particular
	}

	@Override
	public void realizarMovimiento() {
		miEnemigo.irAPosicion(miEnemigo.getPosResurreccion(),new Encerrado(miEnemigo)); 
	}

	@Override
	public ImageIcon getImagen() {
		return miImagen;
	}

	@Override
	public void deboEscapar() {}

	@Override
	public void interactuarConProtagonista() {}

	
	public void deboPerseguir() {
		
	}

	@Override
	public void actualizarFoto() {
	}

	@Override
	public void explotar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void colisionarPuertaEnemigo() {
	}
	@Override
	public ArrayList<Integer> movimientosAEstudiar() {
		// TODO Auto-generated method stub
		return miEnemigo.movimientosAEstudiar();
	}
}
