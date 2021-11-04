package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Factories.FactoryMapaGrilla;
import Logic.Logica;
import Nivel.Nivel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI_MAPA {

	private JFrame frame;
	private JLabel JLPlayer;
	private JLabel [][] labels = new JLabel[31][33];
	private Logica log;
	private JLabel JLTiempo;
	private JLabel JLFondoMapa; 
	/**
	 * Create the application.
	 */
	public GUI_MAPA(FactoryMapaGrilla f, Nivel nivel) {
		initialize();
		log = new Logica(this,f, nivel);
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
		JLPlayer.setLocation(xProtagonista,yProtagonista+155);
		
	}
	public void fotoProtagonista(ImageIcon imagenProtagonista, int xProtagonista, int yProtagonista) {
		Image EscalarFoto = imagenProtagonista.getImage().getScaledInstance(JLPlayer.getWidth(),JLPlayer.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		JLPlayer.setIcon(FotoEscalada);
		
	}
	
	public void actualizarPunto(ImageIcon imagenPunto, int x, int y) {
		int i = (x-12)/15;
		int j = (y-12)/15;
		JLabel punto = labels[i][j];
		
		Image EscalarFoto = imagenPunto.getImage().getScaledInstance(punto.getWidth(),punto.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		punto.setIcon(FotoEscalada);
		labels[i][j] = punto;
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
		
		
		
		
		
		JLPlayer = new JLabel("");
		JLPlayer.setBounds(189, 290+155, 30,30);
		frame.getContentPane().add(JLPlayer);
		JLPlayer.setForeground(new Color(0, 128, 0));
		JLPlayer.setBackground(Color.WHITE);
		
		for (int i =0; i< labels.length;i++) {
			for (int j =0; j< labels[0].length;j++) {
				JLabel lab = new JLabel("");
				lab.setBounds(12+i*15,22+j*15 + 155, 10,10);
				frame.getContentPane().add(lab);
				lab.setForeground(new Color(0, 128, 0));
				lab.setBackground(Color.WHITE);
				labels[i][j]= lab;
			}}
		
		JLFondoMapa = new JLabel("");
		JLFondoMapa.setBounds(0, 154, 500, 540);
		frame.getContentPane().add(JLFondoMapa);
		JLFondoMapa.setIcon(new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/fondoauxarreglo.png")));
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 965, 155);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("vidas");
		lblNewLabel.setFont(new Font("Engravers MT", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 9, 213, 62);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(213, 0, 313, 104);
		panel.add(panel_1);
		panel_1.setLayout(null);
	
		
		JLabel JLVIDAS1 = new JLabel("New label");
		JLVIDAS1.setBounds(20, 0, 87, 104);
		panel_1.add(JLVIDAS1);
		Image EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")).getImage().getScaledInstance(JLVIDAS1.getWidth(),JLVIDAS1.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		JLVIDAS1.setIcon(FotoEscalada);
		
		JLabel JLVIDAS2 = new JLabel("New label");
		JLVIDAS2.setIcon(new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")));
		JLVIDAS2.setBounds(120, 0, 87, 104);
		panel_1.add(JLVIDAS2);
		EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")).getImage().getScaledInstance(JLVIDAS2.getWidth(),JLVIDAS2.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		JLVIDAS2.setIcon(FotoEscalada);
		
		JLabel JLVIDAS3 = new JLabel("New label");
		JLVIDAS3.setIcon(new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")));
		JLVIDAS3.setBounds(220, 0, 87, 104);
		panel_1.add(JLVIDAS3);
		EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")).getImage().getScaledInstance(JLVIDAS3.getWidth(),JLVIDAS3.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		JLVIDAS3.setIcon(FotoEscalada);
		
		
		JLabel JLPlayerPuntaje = new JLabel("Tu Puntaje:");
		JLPlayerPuntaje.setFont(new Font("Rockwell", Font.BOLD, 20));
		JLPlayerPuntaje.setBounds(340, 97, 306, 48);
		panel.add(JLPlayerPuntaje);
		
		JLabel JLNIVEL = new JLabel("Nivel: ");
		JLNIVEL.setFont(new Font("Cooper Black", Font.PLAIN, 29));
		JLNIVEL.setBounds(43, 96, 160, 45);
		panel.add(JLNIVEL);
		//JLABEL
		JLTiempo = new JLabel("00:00");
		JLTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		JLTiempo.setBounds(651, 12, 213, 75);
		panel.add(JLTiempo);
		JLTiempo.setForeground(Color.RED);
		JLTiempo.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 48));
		
		JLabel JLHighScoreList = new JLabel("\"PREGUNTAR COMO HACER LOS ENTER\" LISTA DE HIGH SCORE PARA MAS ADELANTE"+"/n");
		JLHighScoreList.setBounds(526, 222, 374, 348);
		frame.getContentPane().add(JLHighScoreList);
		
		JLabel JLHIGHSCORE = new JLabel("HIGH SCORE: ");
		JLHIGHSCORE.setBounds(548, 165, 306, 48);
		frame.getContentPane().add(JLHIGHSCORE);
		JLHIGHSCORE.setFont(new Font("Rockwell", Font.BOLD, 20));
	}
}
