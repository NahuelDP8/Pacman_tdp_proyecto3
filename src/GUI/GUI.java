package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import Factories.FactoryMapaGrilla;
import Factories.FactoryMapaGrillaNaruto;
import GUI.GUI.EventoDeTeclado;
import Logic.Logica;

public class GUI {
	public JFrame frmJuego;
	private Logica log;
	private JLabel [][] labels = new JLabel[25][10];
	private JLabel JLTiempo;
	private JLabel player;
	private JLabel JLPuntaje;
	private JPanel panel;
	private JPanel PMatriz;
	private JPanel PPerdiste;
	private JLabel JLPerdiste;
	private boolean jugando;
	private JLabel fondo;
	
	public GUI(FactoryMapaGrilla f) {
		initialize();
		log = new Logica(this,f);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Listener Eventos
		
		EventoDeTeclado tecla=new EventoDeTeclado();
		frmJuego = new JFrame();
		frmJuego.setTitle("Tetris");
		frmJuego.getContentPane().setBackground(new Color(0, 0, 0));
		frmJuego.setBounds(400,60,1042,715);
		frmJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJuego.addKeyListener(tecla);
		frmJuego.getContentPane().setLayout(null);
		JLabel PRUEBA_REVISAR = new JLabel("");
		PRUEBA_REVISAR.setForeground(Color.WHITE);
		PRUEBA_REVISAR.setBounds(0, 0, 960, 540);
		ImageIcon imagen = new ImageIcon(GUI.class.getResource("/Imagenes/fondo.png"));
		Image EscalarFoto = imagen.getImage().getScaledInstance(PRUEBA_REVISAR.getWidth(),PRUEBA_REVISAR.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		
		//necesitamos que el random aparezca antes, osea crear un metodo para el random
		//y tener q imagen y tetrimino siguiente viene
		
		player = new JLabel("");
		player.setBounds(30, 30, 50,50);
		frmJuego.getContentPane().add(player);
		player.setForeground(new Color(0, 128, 0));
		player.setBackground(Color.WHITE);
		PRUEBA_REVISAR.setIcon(FotoEscalada);
		
		frmJuego.getContentPane().add(PRUEBA_REVISAR);
		jugando = true;
			
			
		PPerdiste = new JPanel();
		PPerdiste.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PPerdiste.setForeground(Color.WHITE);
		PPerdiste.setBounds(0, 335, 335, 142);
		//		PMatriz.add(PPerdiste);
				frmJuego.getContentPane().add(PPerdiste);
				PPerdiste.setBackground(new Color(0, 0, 0));
				PPerdiste.setLayout(null);
				
				JButton btnNewButton = new JButton("Volver al menu");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									GUIMenu Nframe = new GUIMenu();
									Nframe.setVisible(true);
									frmJuego.dispose();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				});
				btnNewButton.setBounds(109, 87, 118, 23);
				PPerdiste.add(btnNewButton);
				
				JLPerdiste = new JLabel("JUEGO TERMINADO");
				JLPerdiste.setBounds(10, 0, 320, 112);
				PPerdiste.add(JLPerdiste);
				JLPerdiste.setForeground(Color.WHITE);
				JLPerdiste.setBackground(new Color(255, 255, 255));
				JLPerdiste.setToolTipText("");
				JLPerdiste.setHorizontalAlignment(SwingConstants.CENTER);
				JLPerdiste.setFont(new Font("Yu Gothic Light", Font.PLAIN, 20));
				PPerdiste.setVisible(false);
	
		//Panel donde se crea la matriz
		PMatriz = new JPanel();
		PMatriz.setBorder(null);
		PMatriz.setBackground(new Color(0, 0, 0));
		PMatriz.setBounds(0,0, 500, 500); //PMatriz.setBounds(20, 25, 356, 678); //
		frmJuego.getContentPane().add(PMatriz);
		PMatriz.setLayout(null);
			
			
			
		
			panel = new JPanel();
			panel.setBounds(0, 0, 960, 540);
			PMatriz.add(panel);
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBackground(new Color(0, 0, 0));
			panel.setLayout(null);
			
			
			JLTiempo = new JLabel("00:00");
			JLTiempo.setVerticalAlignment(SwingConstants.TOP);
			JLTiempo.setForeground(Color.WHITE);
			JLTiempo.setFont(new Font("Yu Gothic Light", Font.PLAIN, 48));
			JLTiempo.setBounds(10, 10, 203, 52);
			panel.add(JLTiempo);
			
			JLPuntaje = new JLabel("Puntos: 0");
			JLPuntaje.setVerticalAlignment(SwingConstants.TOP);
			JLPuntaje.setForeground(Color.WHITE);
			JLPuntaje.setFont(new Font("Yu Gothic Light", Font.PLAIN, 20));
			JLPuntaje.setBounds(10, 66, 230, 25);
			panel.add(JLPuntaje);
			
			fondo = new JLabel("");
			fondo.setBounds(0, 100, 522, 422);
			PMatriz.add(fondo);
			fondo.setForeground(new Color(0, 128, 0));
			fondo.setBackground(Color.WHITE);
			
	}	
	
	public void actualizarFondo(ImageIcon imagen){
		Image EscalarFoto = imagen.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		//fondo.setIcon(FotoEscalada);
	}
	
	public void actualizarProtagonista(ImageIcon imagenProtagonista, int xProtagonista, int yProtagonista) {
		player.setLocation(xProtagonista,yProtagonista);
		
	}
	public void fotoProtagonista(ImageIcon imagenProtagonista, int xProtagonista, int yProtagonista) {
		Image EscalarFoto = imagenProtagonista.getImage().getScaledInstance(player.getWidth(),player.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		player.setIcon(FotoEscalada);
		
	}
	
	public void captarMovimientoAbajo() {
		log.moverProtagonistaAbajo();
	}
	public void captarMovimientoArriba() {
		log.moverProtagonistaArriba();
	}
	public void captarMovimientoIzq() {
		log.moverProtagonistaIzquierda();
	}
	public void captarMovimientoDer() {
		log.moverProtagonistaDerecha();
	}

	public void gameOver() {
		PPerdiste.setVisible(true);
		jugando = false;
	}
	
	public void actualizaPuntaje(int puntaje) {
		JLPuntaje.setText("Puntos: "+puntaje);
	}
	

	public void actualizarReloj(int min, int seg) {
		String minutos= ""+min;
		String segundos= ""+seg;
		if(min<10)
			minutos= "0"+min;
		if(seg<10)
			segundos= "0"+seg;
		JLTiempo.setText(minutos+":"+segundos);
	}


	class EventoDeTeclado implements KeyListener{
		public void keyTyped(KeyEvent e) {
			
			}
			
		
		
	//se capta cuando se presionan las teclas izq,der,arriba
		public void keyPressed(KeyEvent e) {
			if(jugando) {
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					captarMovimientoIzq();
				}else
					if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
						captarMovimientoDer();
					}else
						if((e.getKeyCode() == KeyEvent.VK_UP)) {
							captarMovimientoArriba();
						}else {
							if(e.getKeyCode() == KeyEvent.VK_DOWN) {
								//captarAbajoNormalizarPausa();
								captarMovimientoAbajo();
							}
						}
							
			}
		}

		public void keyReleased(KeyEvent e) {
						
		}
	}
}


