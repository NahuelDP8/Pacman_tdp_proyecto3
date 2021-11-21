package EnemigosStates;

import java.util.ArrayList;

import javax.swing.ImageIcon;
public interface EstadoEnemigo {
	
	public void realizarMovimiento(); 
	public ImageIcon getImagen();
	public void deboEscapar();
	public void interactuarConProtagonista();
	public void deboPerseguir(); 
	public void actualizarFoto();
	public void explotar();
	public void colisionarPuertaEnemigo();
	public ArrayList<Integer> movimientosAEstudiar();
}
