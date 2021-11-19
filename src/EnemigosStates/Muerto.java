package EnemigosStates;

import javax.swing.ImageIcon;
import Entities.Enemigo;
import Factories.FactoryMapaGrillaNaruto;

public class Muerto implements EstadoEnemigo{
	protected Enemigo miEnemigo; 
	private ImageIcon miImagen=new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/muerte.png"));
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

}
