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

public class GUI_MAPA{

	private JFrame frame;
	private Logica log;
	private JLabel JLTiempo;
	private JLabel JLFondoMapa; 
	private JLabel JLPuntaje;
	private TopPlayers topPlayers;
	private JLabel JLNombre=new JLabel();
	private boolean izquierda, derecha, abajo, arriba;
	/**
	 * Create the application.
	 */
	public GUI_MAPA(FactoryMapaGrilla f, Nivel nivel,String nom, TopPlayers TP) {
		initialize();
		JLNombre.setText("Nombre: "+ nom);
		topPlayers=TP;

		crearTablaHighScore();
		log = new Logica(this,f, nivel);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	
	public void quitarEntidad(EntidadGrafica entidad) {
		entidad.setVisible(false);
	}
	
	public void añadirEntidadGrafica(EntidadGrafica entidad) {
		frame.getContentPane().add(entidad);
	}
	
	public void actualizarEntidad(EntidadGrafica entidad, int x, int y) {
		entidad.setLocation(x, y+155);
	}
	
	public void actualizarPuntos(int p) {
		JLPuntaje.setText(String.valueOf(p));
		
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
	
	public void añadirFondo() {
		JLFondoMapa = new JLabel("");
		JLFondoMapa.setBounds(0, 154, 500, 540);
		frame.getContentPane().add(JLFondoMapa);
		JLFondoMapa.setIcon(new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/fondoauxarreglo.png")));
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
		frame.setBounds(100, 100, 1046, 842);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

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
		
		JLPuntaje = new JLabel("0");
		JLPuntaje.setFont(new Font("Rockwell", Font.BOLD, 20));
		JLPuntaje.setBounds(725, 105, 213, 40);
		panel.add(JLPuntaje);
		
		
		JLabel JLPlayerPuntaje = new JLabel("Tu Puntaje:");
		JLPlayerPuntaje.setFont(new Font("Rockwell", Font.BOLD, 20));
		JLPlayerPuntaje.setBounds(609, 105, 130, 40);
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
		
		
		JLNombre.setFont(new Font("Rockwell", Font.BOLD, 20));
		JLNombre.setBounds(213, 105, 372, 40);
		panel.add(JLNombre);
		
		
		
		JLabel JLHIGHSCORE = new JLabel("HIGH SCORE: ");
		JLHIGHSCORE.setBounds(526, 165, 306, 48);
		frame.getContentPane().add(JLHIGHSCORE);
		JLHIGHSCORE.setFont(new Font("Rockwell", Font.BOLD, 20));
	}
	
	private void crearTablaHighScore() {
		JLabel JLHighScoreList = new JLabel();
		JLHighScoreList.setBounds(526, 222, 374, 472);
		frame.getContentPane().add(JLHighScoreList);
		if(topPlayers.size()!=0) {
			JLHighScoreList.setText(topPlayers.getPlayer(0).toString());
		}
		for(int i =1; i<topPlayers.size();i++) {
			JLHighScoreList.setText("<html>"+JLHighScoreList.getText()+"<p>"+topPlayers.getPlayer(i).toString()+"<html>");
		}
		
	}
	
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

}
