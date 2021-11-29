package EnemigosStates;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import EnemigosGenerales.Enemigo;

public class Encerrado implements EstadoEnemigo{
	protected Enemigo miEnemigo;
	private ImageIcon miImagen;
	public Encerrado(Enemigo e) {
		miEnemigo = e; 
		miImagen= miEnemigo.getImagen();
		//deberiamos cambiar la imagen del enemigo en particular
	}
	@Override
	public void realizarMovimiento() {
		miEnemigo.irAPosicion(miEnemigo.getPosSalida(),new Persiguiendo(miEnemigo)); 
	}

	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return miImagen;
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
	@Override
	public void explotar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void colisionarPuertaEnemigo() {
	}
	@Override
	public ArrayList<Integer> movimientosAEstudiar(){
		return miEnemigo.todosLosMovimientos();
	}

}
