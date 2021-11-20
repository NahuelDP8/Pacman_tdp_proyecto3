package Controladores;

import java.util.ArrayList;

import Entities.BombasPocion;
import Entities.Enemigo;
import Entities.Explosion;

public class BombasControler extends ThreadControl{
	private Explosion miExplosion ;
	
	public BombasControler (Explosion b ) {
		miExplosion= b;
	}


	public void explotar() {
		miExplosion.crearExplosion();
		
	}

	public void parar() {
		miExplosion.pararExplosion();
		
	}
}
