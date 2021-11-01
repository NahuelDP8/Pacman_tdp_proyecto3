package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Factories.FactoryMapaGrilla;
import GUI.GUI.EventoDeTeclado;
import Logic.Logica;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI_MAPA {

	private JFrame frame;
	private JLabel JLPlayer;
	private Logica log;
	private JLabel JLTiempo;
	private JLabel JLFondoMapa;
	/**
	 * Create the application.
	 */
	public GUI_MAPA(FactoryMapaGrilla f) {
		initialize();
		log = new Logica(this,f);
	}
	
	public void actualizarFondo(ImageIcon imagen){
		Image EscalarFoto = imagen.getImage().getScaledInstance(JLFondoMapa.getWidth(),JLFondoMapa.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		//fondo.setIcon(FotoEscalada);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	public void actualizarProtagonista(ImageIcon imagenProtagonista, int xProtagonista, int yProtagonista) {
		JLPlayer.setLocation(xProtagonista,yProtagonista);
		
	}
	public void fotoProtagonista(ImageIcon imagenProtagonista, int xProtagonista, int yProtagonista) {
		Image EscalarFoto = imagenProtagonista.getImage().getScaledInstance(JLPlayer.getWidth(),JLPlayer.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		JLPlayer.setIcon(FotoEscalada);
		
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
	
	
	
	class EventoDeTeclado implements KeyListener{
		public void keyTyped(KeyEvent e) {
			
			}
	
	boolean jugando=true; //REVISAR SACAR
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
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		EventoDeTeclado tecla=new EventoDeTeclado();
		frame = new JFrame();
		frame.addKeyListener(tecla);
		frame.setBounds(100, 100, 1046, 842);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		
		//JLABEL
		JLTiempo = new JLabel("00:00");
        JLTiempo.setVerticalAlignment(SwingConstants.TOP);
        JLTiempo.setForeground(Color.WHITE);
        JLTiempo.setFont(new Font("Yu Gothic Light", Font.PLAIN, 48));
        JLTiempo.setBounds(10, 10, 203, 52);
	
		JLPlayer = new JLabel("");
		JLPlayer.setBounds(463, 504, 30,30);
		frame.getContentPane().add(JLPlayer);
		JLPlayer.setForeground(new Color(0, 128, 0));
		JLPlayer.setBackground(Color.WHITE);
		JLFondoMapa = new JLabel("");
		JLFondoMapa.setBounds(0, 154, 960, 540);
		frame.getContentPane().add(JLFondoMapa);
		JLFondoMapa.setIcon(new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/fondo.png")));
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 965, 155);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("vidas");
		lblNewLabel.setFont(new Font("Engravers MT", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-42, 10, 320, 62);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(261, 0, 320, 84);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel JLVIDAS2 = new JLabel("New label");
		JLVIDAS2.setBounds(124, 10, 64, 64);
		panel_1.add(JLVIDAS2);
		
		JLabel JLVIDAS1 = new JLabel("New label");
		JLVIDAS1.setBounds(20, 10, 64, 64);
		panel_1.add(JLVIDAS1);
		
		JLabel JLVIDAS3 = new JLabel("New label");
		JLVIDAS3.setBounds(234, 10, 64, 64);
		panel_1.add(JLVIDAS3);
		
		JLabel JLPlayerPuntaje = new JLabel("Tu Puntaje:");
		JLPlayerPuntaje.setFont(new Font("Rockwell", Font.BOLD, 20));
		JLPlayerPuntaje.setBounds(340, 97, 306, 48);
		panel.add(JLPlayerPuntaje);
		
		JLabel JLHIGHSCORE = new JLabel("HIGH SCORE: ");
		JLHIGHSCORE.setFont(new Font("Rockwell", Font.BOLD, 20));
		JLHIGHSCORE.setBounds(649, 97, 306, 48);
		panel.add(JLHIGHSCORE);
		
		JLabel JLNIVEL = new JLabel("Nivel: ");
		JLNIVEL.setFont(new Font("Cooper Black", Font.PLAIN, 29));
		JLNIVEL.setBounds(43, 96, 160, 45);
		panel.add(JLNIVEL);
	}
}
