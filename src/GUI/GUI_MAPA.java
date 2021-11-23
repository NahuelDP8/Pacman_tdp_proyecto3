package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Entities.EntidadGrafica;
import Factories.FactoryMapa;
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

public class GUI_MAPA{

	private JFrame frame;
	private Logica log;
	private JLabel JLTiempo;
	private JLabel JLPuntaje;
	private TopPlayers topPlayers;
	private JLabel JLFondoMapa;
	private JLabel JLNombre;
	private JLabel JLNivel;
	private JLabel JLBomba;
	private JPanel panelCargando;
	private boolean izquierda, derecha, abajo, arriba;
	private JLabel JLVIDAS1, JLVIDAS2,JLVIDAS3;
	private AudioPlayer audio;
	private Image EscalarFoto; 
	private ImageIcon FotoEscalada;
	private JPanel PPerdiste;
	private JPanel PGanaste;
	private JPanel panel;
	private JPanel panel_1;
	private JButton JBVolverAMenuG;
	private JButton JBVolverAMenuP;
	private JLabel JLPerdiste;
	private JLabel JLGanaste;
	private JLabel JLMusic;
	private boolean jugando;
	private boolean topPlayersActualizado;
	/**
	 * Create the application.
	 */
	public GUI_MAPA(FactoryMapaGrilla f, Nivel nivel,FactoryMapa map,String nom, TopPlayers TP,AudioPlayer audioaux) {
		initialize();
		JLNombre.setText("Nombre: "+ nom);
		JLNivel.setText("Nivel: "+ nivel.getNivel());
		topPlayers=TP;
		log = Logica.getLogic(this, f, nivel,map);
		audio = audioaux;
		topPlayersActualizado=false;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	//No permite ver entidades gráficas
	public void quitarEntidad(EntidadGrafica entidad) {
		entidad.setVisible(false);
	}
	//Añade entidad grafica
	public void addEntidadGrafica(EntidadGrafica entidad) {
		frame.getContentPane().add(entidad);
		frame.getContentPane().setComponentZOrder(entidad, 1);
		
	}
	//Actualiza entidad gráfica.
	public void actualizarEntidad(EntidadGrafica entidad, int x, int y,boolean frente) {
		entidad.setLocation(x, y+95);
		if(frente) //Si hace falta, se ponen al frente
			frame.getContentPane().setComponentZOrder(entidad, 1);
	}
	//Aumenta puntos
	public void actualizarPuntos(int p) {
		JLPuntaje.setText(String.valueOf(p));
	}
	//Quita label de vidas
	public void quitarVida() {
		if(JLVIDAS3.isVisible()) {
			JLVIDAS3.setVisible(false);
		}else if(JLVIDAS2.isVisible()) {
			JLVIDAS2.setVisible(false);
		}else{
			JLVIDAS1.setVisible(false);
		}
	}
	public void reinicioDVidas() {
		JLVIDAS3.setVisible(true);
		JLVIDAS2.setVisible(true);
		JLVIDAS1.setVisible(true);
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
	public void ponerBomba() {
		log.ponerBomba();
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
								}else {
									if(e.getKeyCode() == KeyEvent.VK_SPACE) 
										//captarAbajoNormalizarPausa();
										ponerBomba();
									else{	if(e.getKeyCode() == KeyEvent.VK_P) {
												audio.alternarSilencio();
									}
								}
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
		jugando = true;
		EventoDeTeclado tecla=new EventoDeTeclado();
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				actualizarArchivo();
			}
		});
		frame.addKeyListener(tecla);
		frame.setBounds(6, 6, 1500, 890);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JLFondoMapa = new JLabel("");
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1476, 97);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel JLVIDAS = new JLabel("vidas");
		JLVIDAS.setFont(new Font("Engravers MT", Font.BOLD, 40));
		JLVIDAS.setHorizontalAlignment(SwingConstants.CENTER);
		JLVIDAS.setBounds(0, 9, 213, 62);
		panel.add(JLVIDAS);
		//Panel de victoria
		PGanaste = new JPanel();
		PGanaste.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PGanaste.setForeground(Color.WHITE);
		PGanaste.setBounds(6, 6, 1500, 890);
		frame.getContentPane().add(PGanaste);
		PGanaste.setBackground(new Color(0, 0, 0));
		PGanaste.setLayout(null);
		
		JLGanaste = new JLabel("HAS GANADO");
		JLGanaste.setBounds(400, 200, 600, 112);
		PGanaste.add(JLGanaste);
		JLGanaste.setForeground(Color.WHITE);
		JLGanaste.setBackground(Color.GREEN);
		JLGanaste.setToolTipText("");
		JLGanaste.setHorizontalAlignment(SwingConstants.CENTER);
		JLGanaste.setFont(new Font("Yu Gothic Light", Font.PLAIN, 50));
		PGanaste.setVisible(false);
		//Panel derrota
		PPerdiste = new JPanel();
		PPerdiste.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PPerdiste.setForeground(Color.WHITE);
		PPerdiste.setBounds(6, 6, 1500, 890);
		frame.getContentPane().add(PPerdiste);
		PPerdiste.setBackground(new Color(0, 0, 0));
		PPerdiste.setLayout(null);
		
		JBVolverAMenuP = new JButton("Volver al menu");
		JBVolverAMenuP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GUIMenu Nframe = new GUIMenu(topPlayers);
							Nframe.setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		JBVolverAMenuP.setBounds(525, 450, 300, 50);
		JBVolverAMenuP.setEnabled(false);
		
		PPerdiste.add(JBVolverAMenuP);
		
		JBVolverAMenuG = new JButton("Volver al menu");
		JBVolverAMenuG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GUIMenu Nframe = new GUIMenu(topPlayers);
							Nframe.setVisible(true);
							frame.dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		JBVolverAMenuG.setBounds(525, 450, 300, 50);
		JBVolverAMenuG.setEnabled(false);
		PGanaste.add(JBVolverAMenuG);
		
		JLPerdiste = new JLabel("JUEGO TERMINADO");
		JLPerdiste.setBounds(400, 200, 600, 112);
		PPerdiste.add(JLPerdiste);
		JLPerdiste.setForeground(Color.WHITE);
		JLPerdiste.setBackground(new Color(255, 255, 255));
		JLPerdiste.setToolTipText("");
		JLPerdiste.setHorizontalAlignment(SwingConstants.CENTER);
		JLPerdiste.setFont(new Font("Yu Gothic Light", Font.PLAIN, 50));
		PPerdiste.setVisible(false);
		
		panel_1 = new JPanel();
		panel_1.setBounds(213, 0, 308, 87);
		panel.add(panel_1);
		panel_1.setLayout(null);
		//Indica que se pueden poner bombas
		JLBomba = new JLabel("PRESIONE SPACE PARA PONER BOMBA");
		JLBomba.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		JLBomba.setBounds(522, 100, 500, 29);
		frame.getContentPane().add(JLBomba);
		JLBomba.setVisible(false);
		
		//Labels vidas
		JLVIDAS1 = new JLabel("");
		JLVIDAS1.setBounds(20, 0, 87, 88);
		panel_1.add(JLVIDAS1);
		EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/VidasNaruto.png")).getImage().getScaledInstance(JLVIDAS1.getWidth(),JLVIDAS1.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
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
		
		//Label nivel
		JLNivel = new JLabel();
		JLNivel.setFont(new Font("Cooper Black", Font.PLAIN, 29));
		JLNivel.setBounds(824, 22, 160, 45);
		panel.add(JLNivel);
		//JLABEL
		JLTiempo = new JLabel("00:00");
		JLTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		JLTiempo.setBounds(544, 0, 213, 75);
		panel.add(JLTiempo);
		JLTiempo.setForeground(Color.RED);
		JLTiempo.setFont(new Font("OCR A Extended", Font.BOLD | Font.ITALIC, 48));
		
		JLNombre = new JLabel();
		JLNombre.setFont(new Font("Rockwell", Font.BOLD, 20));
		JLNombre.setBounds(1036, 27, 372, 40);
		panel.add(JLNombre);
		//Label musica
		JLMusic = new JLabel("Letra \"P\": ALTERNA MUTE M\u00DASICA");
		JLMusic.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		JLMusic.setBounds(522, 68, 355, 29);
		panel.add(JLMusic);
		FotoEscalada = new ImageIcon(EscalarFoto);
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
		//Gif de carga
		panelCargando = new JPanel();
		EscalarFoto = new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/cargando.gif")).getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		panelCargando.add( new JLabel("",new ImageIcon(GUI_MAPA.class.getResource("/Imagenes/cargando.gif")), SwingConstants.CENTER));
		
		panelCargando.setBounds(0,95,800,800);
		frame.getContentPane().add(panelCargando);
		panelCargando.setVisible(false);
	}
	
	private void crearTablaHighScore(int width) {
		JLabel JLHighScoreList = new JLabel("");
		JLHighScoreList.setFont(new Font("SimSun", Font.BOLD, 18));
		JLHighScoreList.setBounds(700, 250, 700, 472);
		frame.getContentPane().add(JLHighScoreList);
		System.out.println("cant "+topPlayers.size());
		if(!topPlayers.isEmpty()) {
			for(int i=0; i<topPlayers.size();i++) {
				JLHighScoreList.setText(JLHighScoreList.getText()+(i+1)+"-"+topPlayers.getPlayer(i).toString()+"<br>");
			}
			JLHighScoreList.setText("<html>"+JLHighScoreList.getText()+"</html>");
		}
		JLHighScoreList.setHorizontalAlignment(SwingConstants.LEFT);
		JLHighScoreList.setVerticalAlignment(SwingConstants.TOP);
	}
	
	// actualiza highscores
	private void actualizarArchivo() {
		FileOutputStream fileOutputStream;
		try {
			if(!topPlayersActualizado) {
				int puntosDPlayer=0;
				puntosDPlayer = Integer.parseInt(JLPuntaje.getText());
				topPlayers.addPlayer(new Player(JLNombre.getText().substring(7),puntosDPlayer));
				topPlayersActualizado=true;
			}
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
	
	public void gameOver() {
		audio.stopMusic();
		log.destruirSingleton();
		PPerdiste.setVisible(true);
		panel.setVisible(false);
		panel_1.setVisible(false);
		JBVolverAMenuP.setEnabled(true);
		frame.getContentPane().setComponentZOrder(panelCargando, 0);
		jugando = false;
		if(!topPlayersActualizado) {
			int puntosDPlayer=0;
			puntosDPlayer = Integer.parseInt(JLPuntaje.getText());
			topPlayers.addPlayer(new Player(JLNombre.getText().substring(7),puntosDPlayer));
			topPlayersActualizado=true;
		}

	}
	
	public void win() {
		audio.stopMusic();
		log.destruirSingleton();
		PGanaste.setVisible(true);
		panel.setVisible(false);
		panel_1.setVisible(false);
		JBVolverAMenuG.setEnabled(true);
		frame.getContentPane().setComponentZOrder(panelCargando, 0);
		jugando = false;
		if(!topPlayersActualizado) {
			int puntosDPlayer=0;
			puntosDPlayer = Integer.parseInt(JLPuntaje.getText());
			topPlayers.addPlayer(new Player(JLNombre.getText().substring(7),puntosDPlayer));
			topPlayersActualizado=true;
		}
		actualizarArchivo();
	}
	
	
	public void setJLNivel(int n) {
		JLNivel.setText("Nivel: "+ n);
	}
	//Activa panel cargando
	public void cargando(boolean visibilidad) {
		frame.getContentPane().setComponentZOrder(panelCargando, 0);
		panelCargando.setVisible(visibilidad);
	}

	public void activarBomba() {
		JLBomba.setVisible(true);
		
	}
	public void desactivarBomba() {
		JLBomba.setVisible(false);
	}
	
}
