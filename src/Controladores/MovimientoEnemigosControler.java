package Controladores;

import java.util.ArrayList;
import Entities.Enemigo;

public class MovimientoEnemigosControler extends ThreadControl{
	private ArrayList<Enemigo> misEnemigos ;
	
	public MovimientoEnemigosControler (ArrayList<Enemigo> lisEnem) {
		misEnemigos = lisEnem; 
	}

	public void moverTodosLosFantasmas() {
		for(Enemigo enemigo : misEnemigos) {
			enemigo.moverme(); 
		}
	}
}
