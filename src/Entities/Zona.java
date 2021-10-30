package Entities;
import java.util.ArrayList;

public class Zona {
	protected PairTupla posicionEnMatriz;
	protected ArrayList<Entidad> misEntidades;
	protected int idZona;
	protected int ancho;
	protected int alto;
	
	public Zona(int id, PairTupla p, int an,int al) {
		posicionEnMatriz = p;
		idZona = id;
		ancho = an;
		alto = al;
	}
	public ArrayList<Entidad> obtenerEntidades(){
		return misEntidades;
	}
	public void setEntidad(Entidad nueva) {
		misEntidades.add(nueva);
	}
	
	public void realizarColisiones() {
		
	}
}
