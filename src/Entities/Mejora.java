package Entities;

abstract public class Mejora extends Entidad{
	protected int miPuntaje; 
	
	public Mejora(PairTupla p, int anc, int alt) {
		super(p, anc, alt);
	}
	
	public int getMovimientoActual() {
		return 0; 
	}
}
