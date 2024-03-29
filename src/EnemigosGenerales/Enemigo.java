package EnemigosGenerales;

import EnemigosStates.*;
import Entities.PairTupla;
import Entities.Personaje;
import Visitors.EnemigoVisitor;
import Visitors.Visitor;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import Mapas.MapaGrilla;

public abstract class Enemigo extends Personaje{
	protected EstadoEnemigo miEstado; 
	protected boolean huboColisionConPared;
	protected boolean movIzquierda; 
	protected boolean movDerecha;
	protected boolean movAbajo;
	protected boolean movArriba;
	protected PairTupla posResurreccion;
	protected PairTupla posSalida;
	protected ImageIcon imgAzul;
	protected ImageIcon imgMuerte;
	
	public Enemigo(PairTupla p, int anc, int alt, ImageIcon img, MapaGrilla grilla,PairTupla posR,PairTupla posS) {
		super(p, anc, alt,img, grilla );
		miEstado = new Encerrado(this); 
		huboColisionConPared = false;
		velocidad = 4; 
		v = new EnemigoVisitor(this);
		movimientoActual = 4;
		posResurreccion = posR;
		posSalida = posS;
	}
	
	public void accept(Visitor v) {
		v.visitEnemigo(this);
	}
	
	public void changeState(EstadoEnemigo e) {
		miEstado = e;
		Image EscalarFoto = miEstado.getImagen().getImage().getScaledInstance(ancho,altura, Image.SCALE_DEFAULT);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		miEntidad.setIcon(FotoEscalada);
	}
	
	public void colisionPared() {
		huboColisionConPared = true; 
	}
	
	public void noColisioPared() {
		huboColisionConPared=false; 
	}
	
	public boolean getColisionPared() {
		return huboColisionConPared; 
	}
	
	public void realizarMovimiento(int mov) {
		if(mov == miGrilla.getCnsMOVER_ABAJO()) {
			posicion.setY(posicion.getY()+ velocidad);
		}else if(mov == miGrilla.getCnsMOVER_ARRIBA()) {
			posicion.setY(posicion.getY()- velocidad);
		}else if(mov == miGrilla.getCnsMOVER_IZQUIERDA()) {
			posicion.setX(posicion.getX()- velocidad);
		}else if(mov == miGrilla.getCnsMOVER_DERECHA()) {
			posicion.setX(posicion.getX()+ velocidad);
		} 
		miRectangulo.setBounds(posicion.getX(), posicion.getY(), ancho, altura);
		miEstado.actualizarFoto();
		miGrilla.actualizarEntidad(this);
	}
	
	public void invalidarMovimiento(int movimiento) {
		if(movimiento == miGrilla.getCnsMOVER_ABAJO())
			movAbajo = false; 
		else if(movimiento == miGrilla.getCnsMOVER_ARRIBA())
			movArriba = false; 
		else if (movimiento == miGrilla.getCnsMOVER_IZQUIERDA())
			movIzquierda = false;
		else if (movimiento == miGrilla.getCnsMOVER_DERECHA())
			movDerecha = false; 
	}
	
	public void validarMovimientos() {
		movAbajo = true; 
		movArriba = true; 
		movIzquierda = true;
		movDerecha = true; 
	}
	
	abstract public void perseguirProtagonista();
	
	public void moverme() {
		miEstado.realizarMovimiento();
	}
	
	public void deboEscapar() {
		miEstado.deboEscapar(); 
	}
	
	public void deboPerseguir() {
		miEstado.deboPerseguir();
	}
	

	public ImageIcon getImagenEscapando() {
		return imgAzul;
	}
	public ImageIcon getImagenMuerte() {
		return imgMuerte;
	}
	
	protected double distanciaEntrePuntos(PairTupla A, PairTupla B) {
		double x = Math.pow(B.getX()-A.getX(),2);
		double y = Math.pow(B.getY()-A.getY(),2);
		double distancia = Math.sqrt(x+y); 
		return distancia; 
	}
	
	public ArrayList<Integer> movimientosAEstudiar(){
		ArrayList<Integer> toReturn  = new ArrayList<Integer>();
		this.validarMovimientos();
		
		toReturn.add(miGrilla.getCnsMOVER_ABAJO());
		toReturn.add(miGrilla.getCnsMOVER_ARRIBA());
		toReturn.add(miGrilla.getCnsMOVER_IZQUIERDA());
		toReturn.add(miGrilla.getCnsMOVER_DERECHA());
		
		int movActual = this.getMovimientoActual(); 
		
		if(movActual == miGrilla.getCnsMOVER_DERECHA()) { 
			toReturn.remove(miGrilla.getCnsMOVER_IZQUIERDA()-1);
			this.invalidarMovimiento(miGrilla.getCnsMOVER_IZQUIERDA());
		}else if (movActual == miGrilla.getCnsMOVER_IZQUIERDA()) {			
			toReturn.remove(miGrilla.getCnsMOVER_DERECHA()-1);
			this.invalidarMovimiento(miGrilla.getCnsMOVER_DERECHA());
		}else if (movActual == miGrilla.getCnsMOVER_ARRIBA()) {
			toReturn.remove(miGrilla.getCnsMOVER_ABAJO()-1);
			this.invalidarMovimiento(miGrilla.getCnsMOVER_ABAJO());
		}else if (movActual == miGrilla.getCnsMOVER_ABAJO()) {
			toReturn.remove(miGrilla.getCnsMOVER_ARRIBA()-1);
			this.invalidarMovimiento(miGrilla.getCnsMOVER_ARRIBA());
		}	
		
		return toReturn; 
	}
	
	//Todos los enemigos, tendr�n el mismo mecanismo de escape, dependiendo de la posici�n de pacman 
	public void realizarEscape() {
		int movFinal = movimientoActual;
		double disMayor = Double.MIN_VALUE;
		double disAux = 0;
		int posX = posicion.getX();
		int posY = posicion.getY(); 
		PairTupla posicionProtagonista = miGrilla.getPosicionActualProtagonista();
		ArrayList<Integer> movimientos = this.movimientosAEstudiar();
		miGrilla.realizarMovimientoFantasma(this, movimientos);
		
		for(int i =0; i<=movimientos.size()-1; i++) {	
			int movAux = movimientos.get(i); 
			if(movAux == miGrilla.getCnsMOVER_DERECHA() && movDerecha) {
				disAux = distanciaEntrePuntos(new PairTupla(posX+ velocidad, posY),posicionProtagonista);
				if(disAux>=disMayor) {
					disMayor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux == miGrilla.getCnsMOVER_IZQUIERDA() && movIzquierda) {
				disAux = distanciaEntrePuntos(new PairTupla(posX-velocidad, posY),posicionProtagonista);
				if(disAux>=disMayor) {
					disMayor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux== miGrilla.getCnsMOVER_ARRIBA() && movArriba) {
				disAux = distanciaEntrePuntos(new PairTupla(posX, posY-velocidad),posicionProtagonista);
				if(disAux>=disMayor) {
					disMayor= disAux; 
					movFinal = movAux;
				}
			}else if(movAux == miGrilla.getCnsMOVER_ABAJO() && movAbajo) {
				disAux = distanciaEntrePuntos(new PairTupla(posX, posY+velocidad),posicionProtagonista);
				if(disAux>=disMayor) {
					disMayor= disAux; 
					movFinal = movAux;
				}
			}
		}
		this.validarMovimientos();
		//Ahora lo que hacemos es movernos
		this.realizarMovimiento(movFinal);
		movimientoActual = movFinal; 
	}

	public void interactuarConProtagonista() {
		miEstado.interactuarConProtagonista(); 
	}
	
	public void explotar() {
		miEstado.explotar();
	}

	public void notificarMuerteProtagonista() {
		miGrilla.protagonistaPierdeVida(); 
	}

	public void irAPosicion(PairTupla posicionDestino,EstadoEnemigo siguienteEstado) {
		int movFinal = movimientoActual;
		double disMenor = Double.MAX_VALUE;
		double disAux = 0;
		int posX = posicion.getX();
		int posY = posicion.getY(); 
		ArrayList<Integer> movimientos = miEstado.movimientosAEstudiar();
		
		miGrilla.realizarMovimientoFantasma(this, movimientos);
		
		if(posX == posicionDestino.getX() && posY == posicionDestino.getY()) {
			//Cambiamos al estado que corresponda:
			changeState(siguienteEstado);
			//En el cambio de estado, seteamos un move random, para "distaciar" a los fantasmas.
			Random r = new Random();
			movimientoActual = r.nextInt(2) + 3;
		}else {
			
			for(int i =0; i<=movimientos.size()-1; i++) {	
				int movAux = movimientos.get(i); 
				if(movAux == miGrilla.getCnsMOVER_DERECHA() && movDerecha) {
					disAux = distanciaEntrePuntos(new PairTupla(posX+ velocidad, posY),posicionDestino);
					if(disAux<=disMenor) {
						disMenor= disAux; 
						movFinal = movAux;
					}
				}else if(movAux == miGrilla.getCnsMOVER_IZQUIERDA() && movIzquierda) {
					disAux = distanciaEntrePuntos(new PairTupla(posX-velocidad, posY),posicionDestino);
					if(disAux<=disMenor) {
						disMenor= disAux; 
						movFinal = movAux;
					}
				}else if(movAux== miGrilla.getCnsMOVER_ARRIBA() && movArriba) {
					disAux = distanciaEntrePuntos(new PairTupla(posX, posY-velocidad),posicionDestino);
					if(disAux<=disMenor) {
						disMenor= disAux; 
						movFinal = movAux;
					}
				}else if(movAux == miGrilla.getCnsMOVER_ABAJO() && movAbajo) {
					disAux = distanciaEntrePuntos(new PairTupla(posX, posY+velocidad),posicionDestino);
					if(disAux<=disMenor) {
						disMenor= disAux; 
						movFinal = movAux;
					}
				}
			}
		
		this.validarMovimientos();
		//Ahora lo que hacemos es movernos
		this.realizarMovimiento(movFinal);
		movimientoActual = movFinal; 
		}
	}
	

	public void setMovimientoActual(int mov) {
		movimientoActual = mov;
	}

	public void colisionarPuertaEnemigo() {
		miEstado.colisionarPuertaEnemigo();
		
	}

	public PairTupla getPosSalida() {
		return posSalida;
	}
	public PairTupla getPosResurreccion() {
		return posResurreccion;
	}

	public ArrayList<Integer> todosLosMovimientos() {
		ArrayList<Integer> toReturn  = new ArrayList<Integer>();
		validarMovimientos();
		toReturn.add(miGrilla.getCnsMOVER_ABAJO());
		toReturn.add(miGrilla.getCnsMOVER_ARRIBA());
		toReturn.add(miGrilla.getCnsMOVER_IZQUIERDA());
		toReturn.add(miGrilla.getCnsMOVER_DERECHA());
		return toReturn;
	}

	public void encerrar() {
		miEstado = new Encerrado(this); 
		miRectangulo = new Rectangle(posicion.getX(), posicion.getY(), ancho, altura); 
	}
}
