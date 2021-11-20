package GUI;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import javax.swing.SwingConstants;

import Entities.EntidadGrafica;
import Factories.FactoryMapaGrilla;
import Logic.Logica;
import Music.AudioPlayer;
import Nivel.Nivel;
import ranking.Player;
import ranking.TopPlayers;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JButton;

public class GUI_MAPA{

	private JFrame frame;
	private Logica log;
	private JLabel JLTiempo;
	private JLabel JLPuntaje;
	private TopPlayers topPlayers;
	private JLabel JLFondoMapa;
	private JLabel JLNombre;
	private JLabel JLNivel;
	private JPanel panelCargando;
	private boolean izquierda, derecha, abajo, arriba;
	private JLabel JLVIDAS1, JLVIDAS2,JLVIDAS3;
	private AudioPlayer audio;
	private final JLabel lblNewLabel = new JLabel("New label");
	private JButton JBMusic;
	/**
	 * Create the application.
	 */
	public GUI_MAPA(FactoryMapaGrilla f, Nivel nivel,String nom, TopPlayers TP,AudioPlayer audioaux) {
		initialize();
		JLNombre.setText("Nombre: "+ nom);
		JLNivel.setText("Nivel: "+ nivel.getNivel());
		frame.getContentPane().add(lblNewLabel);
		topPlayers=TP;
		audio=audioaux;
		log = log.getLogic(this, f, nivel);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void quitarEntidad(EntidadGrafica entidad) {
		entidad.setVisible(false);
	}
	
	public void añadirEntidadGrafica(EntidadGrafica entidad) {
		frame.getContentPane().add(entidad);
		frame.getContentPane().setComponentZOrder(entidad, 1);
		
	}
	
	public void actualizarEntidad(EntidadGrafica entidad, int x, int y,boolean frente) {
		entidad.setLocation(x, y+95);
		if(frente)
			frame.getContentPane().setComponentZOrder(entidad, 1);
	}
	
	public void actualizarPuntos(int p) {
		JLPuntaje.setText(String.valueOf(p));
		
	}
	
	public void quitarVida() {
		if(JLVIDAS3.isVisible()) {
			JLVIDAS3.setVisible(false);
		}else if(JLVIDAS2.isVisible()) {
			JLVIDAS2.setVisible(false);
		}else{
			JLVIDAS1.setVisible(false);
		}
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
	public void pintar() {
		frame.paint(frame.getGraphics());
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
	
	public void añadirFondo(ImageIcon imageIcon) {
		JLFondoMapa.setBounds(0, 95, imageIcon.getIconWidth(), imageIcon.getIconHeight());
		frame.getContentPane().add(JLFondoMapa);
		JLFondoMapa.setIcon(imageIcon);

		crearTablaHighScore(716);

	}
	public void captar() {
		if(izquierda)
			captarMovimientoIzq();
		else if(derecha)
			captarMovimientoDer();
		else if(abajo)
			captarMovimientoAbajo();
		else if(arriba)
			captarMovimientoArriba();
	}

	class EventoDeTeclado implements KeyListener{
		public void keyTyped(KeyEvent e) {
			}
	
	boolean jugando=true; //REVISAR SACAR
	//se capta cuando se presionan las teclas izq,der,arriba
			public void keyPressed(KeyEvent e) {
				if(jugando) {
					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						izquierda = true;
					}else
						if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
							derecha= true;
						}else
							if((e.getKeyCode() == KeyEvent.VK_UP)) {
								arriba = true;
							}else {
								if(e.getKeyCode() == KeyEvent.VK_DOWN) {
									//captarAbajoNormalizarPausa();
									abajo = true;
								}
							}
				}
			}

			public void keyReleased(KeyEvent e) {
				if(jugando) {
					if(e.getKeyCode() == KeyEvent.VK_LEFT) {
						izquierda = false;
					}else
						if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
							derecha= false;
						}else
							if((e.getKeyCode() == KeyEvent.VK_UP)) {
								arriba = false;
							}else {
								if(e.getKeyCode() == KeyEvent.VK_DOWN) {
									//captarAbajoNormalizarPausa();
									abajo = false;
								}
							}
				}
			}
		}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		abajo = false;
		arriba = false;
		izquierda = false;
		derecha = false;
		
		EventoDeTeclado tecla=new EventoDeTeclado();
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				gameOver();
				gameClose();
			}
		});
		frame.addKeyListener(tecla);
		frame.setBounds(6, 6, 1500, 890);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLFondoMapa = new JLabel("");
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1476, 97);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel JLVIDAS = new JLabel("vidas");
		JLVIDAS.setFont(new Font("Engravers MT", Font.BOLD, 40));
		JLVIDAS.setHorizontalAlignment(SwingConstants.CENTER);
		JLVIDAS.setBounds(0, 9, 213, 62);
		panel.add(JLVIDAS);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(213, 0, 308, 87);
		panel.add(panel_1);
		panel_1.setLayout(null);
	
		
		JLVIDAS1 = new JLabel("");
		JLVIDAS1.setBounds(20, 0, 87, 88);
		panel_1.add(JLVIDAS1);
		Image EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")).getImage().getScaledInstance(JLVIDAS1.getWidth(),JLVIDAS1.getHeight(), Image.SCALE_DEFAULT);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		JLVIDAS1.setIcon(FotoEscalada);
		JLVIDAS1.setVisible(true);
		
		JLVIDAS2 = new JLabel("");
		JLVIDAS2.setIcon(new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")));
		JLVIDAS2.setBounds(120, 0, 87, 88);
		panel_1.add(JLVIDAS2);
		EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")).getImage().getScaledInstance(JLVIDAS2.getWidth(),JLVIDAS2.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		JLVIDAS2.setIcon(FotoEscalada);
		JLVIDAS1.setVisible(true);
		
		JLVIDAS3 = new JLabel("");
		JLVIDAS3.setIcon(new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")));
		JLVIDAS3.setBounds(220, 0, 87, 88);
		panel_1.add(JLVIDAS3);
		EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")).getImage().getScaledInstance(JLVIDAS3.getWidth(),JLVIDAS3.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		JLVIDAS3.setIcon(FotoEscalada);
		JLVIDAS1.setVisible(true);
		
		JLNivel = new JLabel();
		JLNivel.setFont(new Font("Cooper Black", Font.PLAIN, 29));
		JLNivel.setBounds(824, 22, 160, 45);
		panel.add(JLNivel);
		//JLABEL
		JLTiempo = new JLabel("00:00");
		JLTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		JLTiempo.setBounds(531, 0, 213, 75);
		panel.add(JLTiempo);
		JLTiempo.setForeground(Color.RED);
		JLTiempo.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 48));
		
		JLNombre = new JLabel();
		JLNombre.setFont(new Font("Rockwell", Font.BOLD, 20));
		JLNombre.setBounds(1036, 27, 372, 40);
		panel.add(JLNombre);
		
		JBMusic = new JButton("");
		JBMusic.setBounds(753, 56, 42, 31);
		EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/music.png")).getImage().getScaledInstance(JBMusic.getWidth(),JBMusic.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		JBMusic.setIcon(FotoEscalada);
		JBMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				audio.alternarSilencio();
			}
		});
		panel.add(JBMusic);
		
		
		JLabel JLPlayerPuntaje = new JLabel("Tu Puntaje:");
		JLPlayerPuntaje.setBounds(716, 130, 130, 40);
		frame.getContentPane().add(JLPlayerPuntaje);
		JLPlayerPuntaje.setFont(new Font("Rockwell", Font.BOLD, 20));
		
		JLPuntaje = new JLabel("0");
		JLPuntaje.setBounds(835, 130, 276, 40);
		frame.getContentPane().add(JLPuntaje);
		JLPuntaje.setFont(new Font("Rockwell", Font.BOLD, 20));
		
		JLabel JLHIGHSCORE = new JLabel("HIGH SCORE: ");
		JLHIGHSCORE.setBounds(716, 182, 306, 48);
		frame.getContentPane().add(JLHIGHSCORE);
		JLHIGHSCORE.setFont(new Font("Rockwell", Font.BOLD, 20));
		
		panelCargando = new JPanel();
		EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/cargando.gif")).getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		panelCargando.add(
			    new JLabel("",FotoEscalada, SwingConstants.CENTER));
		
		panelCargando.setBounds(0,95,800,800);
		frame.getContentPane().add(panelCargando);
		panelCargando.setVisible(false);
	}
	
	private void crearTablaHighScore(int width) {
		JLabel JLHighScoreList = new JLabel();
		JLHighScoreList.setVerticalAlignment(SwingConstants.TOP);
		JLHighScoreList.setHorizontalAlignment(SwingConstants.LEFT);
		JLHighScoreList.setFont(new Font("SimSun", Font.BOLD, 18));
		JLHighScoreList.setBounds(716, 218, 482, 472);
		frame.getContentPane().add(JLHighScoreList);
		if(topPlayers.size()!=0) {
			JLHighScoreList.setText(topPlayers.getPlayer(0).toString());
		}
		for(int i =1; i<topPlayers.size();i++) {
			JLHighScoreList.setText("<html>"+JLHighScoreList.getText()+"<p>"+topPlayers.getPlayer(i).toString().substring(7)+"<html>");
		}
		
	}
	
	// SE NECESITA VER COMO COPIAR UN STRING DESDE CIERTO CARACTER PARA BORRAR ("NOMBRE")
	public void gameOver() {
		int puntosDPlayer=0;
		puntosDPlayer = Integer.parseInt(JLPuntaje.getText());
		topPlayers.addPlayer(new Player(JLNombre.getText(),puntosDPlayer));
	}
	private void gameClose() {
		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(GUIMenu.configuration.getProperty("HighscoreFile"));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(this.topPlayers);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch (IOException e) {// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void win() {
	}
	public void cargando(boolean visibilidad) {
		frame.getContentPane().setComponentZOrder(panelCargando, 0);
		panelCargando.setVisible(visibilidad);
	}
}
