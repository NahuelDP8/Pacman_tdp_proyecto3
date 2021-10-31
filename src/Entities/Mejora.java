package Entities;

abstract public class Mejora extends Entidad{
	public Mejora(PairTupla p, int anc, int alt,Zona zona) {
		super(p, anc, alt,zona);
	}

	protected int miPuntaje; 
}
