package EnemigosStates;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Entities.Enemigo;
import Factories.FactoryMapaGrillaNaruto;

public class Escapando implements EstadoEnemigo{
	
	protected Enemigo miEnemigo; 
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/debilAzul.gif"));
	
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
		return miImagen;
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

	@Override
	public void actualizarFoto() {
	}

	@Override
	public void explotar() {
		miEnemigo.changeState(new Muerto(miEnemigo));
		
	}
	@Override
	public ArrayList<Integer> movimientosAEstudiar() {
		// TODO Auto-generated method stub
		return miEnemigo.movimientosAEstudiar();
	}

	@Override
	public void colisionarPuertaEnemigo() {
		miEnemigo.colisionPared();
	}

}
