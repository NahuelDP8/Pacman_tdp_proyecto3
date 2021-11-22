package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;

import Factories.FactoryMapa;
import Factories.FactoryMapa1;
import Factories.FactoryMapa2;
import Factories.FactoryMapa3;
import Factories.FactoryMapaGrilla;
import Factories.FactoryMapaGrillaGoku;
import Factories.FactoryMapaGrillaNaruto;
import Factories.FactoryNiveles;
import Music.AudioPlayer;
import Nivel.Nivel;
import ranking.TopPlayers;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel ContentPanel;
	private FactoryMapaGrilla F_Mapa_Grilla;
	private FactoryMapa F_Mapa;
	private Nivel F_Nivel;
	private String nombre;
	private JTextField JTFmiNombre;
	private TopPlayers topPlayers; 
	private AudioPlayer audio;
	private JButton JBMusic;
	private JButton JBNivel3;
	private JButton JBNivel2;
	private JButton JBNivel1;
	/**
	 * Launch the application.
	 */
	
	public static Properties configuration;
	private final JButton btnVerHighscores = new JButton("VER HIGHSCORES");
	
	public static void main(String[] args) {
		loadConfiguration();
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				TopPlayers  topPlayers;
				try {
					File tempFile = new File(GUIMenu.configuration.getProperty("HighscoreFile"));
					if((tempFile.exists()) && (tempFile.length() != 0)) {
						FileInputStream fileInputStream= new FileInputStream(GUIMenu.configuration.getProperty("HighscoreFile"));
						ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);
						topPlayers = (TopPlayers) objectInputStream.readObject();
						objectInputStream.close();
					}	else {
							topPlayers = new TopPlayers();
						}
					
					GUIMenu frame = new GUIMenu(topPlayers);
					frame.setVisible(true);
				}
				catch(FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException  e) {
					e.printStackTrace();
				}
				catch (ClassNotFoundException  e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static void loadConfiguration() {
		try {
			InputStream input = new FileInputStream("./configuration.properties");
			GUIMenu.configuration= new Properties();
			GUIMenu.configuration.load(input);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//FALTA ACOMODAR EL FILE
	private void IniciarMusica(File f) {
		audio=new AudioPlayer(f);
	}
	/**
	 * Create the frame.
	 */
	public GUIMenu(TopPlayers tp) {
		topPlayers = tp;
		setTitle("PacMan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400,60,781,652);
		ContentPanel = new JPanel();
		ContentPanel.setBackground(Color.BLACK);
		ContentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(ContentPanel);
		ImageIcon imagen;
		Image EscalarFoto; 
		ImageIcon FotoEscalada;
		ContentPanel.setLayout(null);
		
		JPanel PSeleccionProta = new JPanel();
		PSeleccionProta.setBounds(10, 8, 747, 597);
		PSeleccionProta.setBackground(Color.BLACK);
		ContentPanel.add(PSeleccionProta);
		PSeleccionProta.setLayout(null);
		
		JPanel PSeleccionNivel = new JPanel();
		PSeleccionNivel.setBounds(10, 8, 747, 597);
		ContentPanel.add(PSeleccionNivel);
		PSeleccionNivel.setLayout(null);
		PSeleccionNivel.setVisible(false);
		
		JPanel PHighscore = new JPanel();
		PHighscore.setBounds(10, 8, 747, 597);
		PHighscore.setBackground(Color.BLACK);
		ContentPanel.add(PHighscore);
		PHighscore.setLayout(null);
		PHighscore.setVisible(false);
		
		
		JButton JBGoku = new JButton("JUGAR GOKU");
		JBGoku.setBounds(54, 98, 255, 353);
		PSeleccionProta.add(JBGoku);
		imagen = new ImageIcon(FactoryMapaGrillaGoku.class.getResource("/Imagenes/goku.png"));
		EscalarFoto = imagen.getImage().getScaledInstance(JBGoku.getWidth(),JBGoku.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		JBGoku.setIcon(FotoEscalada);
		JBGoku.setBackground(Color.BLACK);
		JBGoku.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
		JBGoku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							F_Mapa_Grilla=new FactoryMapaGrillaGoku();
							File MusicFile = new File(GUIMenu.configuration.getProperty("GokuMusic"));
							IniciarMusica(MusicFile);
							PSeleccionProta.setVisible(false);
							PSeleccionNivel.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		JBGoku.setEnabled(false);
		
	
		
		JButton JBNaruto = new JButton("JUGAR NARUTO");
		JBNaruto.setBounds(435, 98, 255, 353);
		PSeleccionProta.add(JBNaruto);
		JBNaruto.setBackground(Color.BLACK);
		JBNaruto.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
		imagen = new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/narutoRun.gif"));
		EscalarFoto = imagen.getImage().getScaledInstance(JBNaruto.getWidth(),JBNaruto.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		JBNaruto.setIcon(FotoEscalada);
		JBNaruto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							F_Mapa_Grilla=new FactoryMapaGrillaNaruto();
							File MusicFile = new File(GUIMenu.configuration.getProperty("NarutoMusic"));
							IniciarMusica(MusicFile);
							PSeleccionProta.setVisible(false);
							PSeleccionNivel.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		JBNaruto.setEnabled(false);
		
		JLabel ModoDeJuego = new JLabel("MODO DE JUEGO");
		ModoDeJuego.setBounds(75, 10, 522, 78);
		PSeleccionProta.add(ModoDeJuego);
		ModoDeJuego.setHorizontalAlignment(SwingConstants.CENTER);
		ModoDeJuego.setForeground(Color.WHITE);
		ModoDeJuego.setFont(new Font("Yu Gothic Light", Font.PLAIN, 45));
		
		JLabel JLIngresaN = new JLabel("<html>INGRESA TU NOMBRE: <p> Maximo de ? caracteres<html>");
		JLIngresaN.setFont(new Font("Segoe Script", Font.BOLD, 25));
		JLIngresaN.setHorizontalAlignment(SwingConstants.CENTER);
		JLIngresaN.setForeground(Color.WHITE);
		JLIngresaN.setBounds(0, 462, 337, 87);
		PSeleccionProta.add(JLIngresaN);
		
		btnVerHighscores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PHighscore.setVisible(true);
				PSeleccionProta.setVisible(false);
				PSeleccionNivel.setVisible(false);
			}
		});
		btnVerHighscores.setBounds(111, 550, 143, 31);
		PSeleccionProta.add(btnVerHighscores);
		btnVerHighscores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton JBAceptar = new JButton("JUGAR");
		JBAceptar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JBAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre=JTFmiNombre.getText();
				JBGoku.setEnabled(true);
				JBNaruto.setEnabled(true);
				btnVerHighscores.setEnabled(false);
				JBAceptar.setEnabled(false);
			}
		});
		
		JBAceptar.setBounds(468, 542, 129, 44);
		PSeleccionProta.add(JBAceptar);
		
		
		JTFmiNombre = new JTextField();
		JTFmiNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					JBAceptar.doClick();
				}
			}
		});
		
		JTFmiNombre.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		JTFmiNombre.setText("\"Mi nombre\"");
		JTFmiNombre.setHorizontalAlignment(SwingConstants.LEFT);
		JTFmiNombre.setBounds(347, 473, 377, 53);
		PSeleccionProta.add(JTFmiNombre);
		JTFmiNombre.setColumns(10);
	
		
		JBMusic = new JButton("M\u00FAsica");
		JBMusic.setBounds(628, 0, 119, 46);
		JBMusic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				audio.alternarSilencio();
			}
		});
		
		PSeleccionNivel.add(JBMusic);
		JBMusic.setForeground(Color.BLACK);
		JBMusic.setFont(new Font("Impact", Font.PLAIN, 28));
		
		JBNivel1 = new JButton("NIVEL 1");
		JBNivel1.setBackground(Color.WHITE);
		JBNivel1.setFont(new Font("Playbill", Font.BOLD, 80));
		JBNivel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F_Nivel=new FactoryNiveles().crearNivel1();
				F_Mapa = new FactoryMapa1();
				GUI_MAPA GUIWindow = new GUI_MAPA(F_Mapa_Grilla,F_Nivel,F_Mapa, nombre,tp,audio);
				GUIWindow.getFrame().setVisible(true);
				dispose();
			}
		});
		JBNivel1.setBounds(0, 151, 236, 277);
		PSeleccionNivel.add(JBNivel1);
		
		JBNivel2 = new JButton("NIVEL 2");
		JBNivel2.setFont(new Font("Playbill", Font.BOLD, 80));
		JBNivel2.setBounds(238, 151, 236, 277);
		PSeleccionNivel.add(JBNivel2);
		JBNivel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("LA PUTA MADRE");
							F_Nivel=new FactoryNiveles().crearNivel2();
							F_Mapa = new FactoryMapa2();
							GUI_MAPA GUIWindow = new GUI_MAPA(F_Mapa_Grilla,F_Nivel,F_Mapa, nombre,tp,audio);
							GUIWindow.getFrame().setVisible(true);
							dispose();
			}
		});
		JBNivel3 = new JButton("NIVEL 3");
		JBNivel3.setFont(new Font("Playbill", Font.BOLD, 80));
		JBNivel3.setBounds(472, 151, 236, 277);
		PSeleccionNivel.add(JBNivel3);
		JBNivel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							F_Nivel=new FactoryNiveles().crearNivel3();
							F_Mapa = new FactoryMapa3();
							GUI_MAPA GUIWindow = new GUI_MAPA(F_Mapa_Grilla,F_Nivel,F_Mapa,nombre,tp,audio);
							GUIWindow.getFrame().setVisible(true);
							ContentPanel.setLayout(null);
							dispose();
			}
		});
		JLabel JLTextELijeProta = new JLabel("Elije el nivel que quieres jugar");
		JLTextELijeProta.setFont(new Font("Rockwell", Font.BOLD, 40));
		JLTextELijeProta.setHorizontalAlignment(SwingConstants.CENTER);
		JLTextELijeProta.setBounds(10, 35, 644, 73);
		PSeleccionNivel.add(JLTextELijeProta);
		
		
		
		//Creacion de la tabla highscores
		JLabel lblHighscore = new JLabel("HIGHSCORES");
		lblHighscore.setFont(new Font("SimSun", Font.BOLD, 40));
		lblHighscore.setForeground(Color.WHITE);
		lblHighscore.setBounds(50, 10, 647, 50);
		PHighscore.add(lblHighscore);
		JLabel lblmejores = new JLabel("Mejores puntuaciones:");
		lblmejores.setFont(new Font("SimSun", Font.BOLD, 30));
		lblmejores.setForeground(Color.WHITE);
		lblmejores.setBounds(20, 75, 647, 50);
		PHighscore.add(lblmejores);
		JLabel JLHighScoreList = new JLabel();
		JLHighScoreList.setVerticalAlignment(SwingConstants.TOP);
		JLHighScoreList.setHorizontalAlignment(SwingConstants.LEFT);
		JLHighScoreList.setFont(new Font("SimSun", Font.BOLD, 28));
		JLHighScoreList.setBounds(0, 150, 647, 500);
		JLHighScoreList.setForeground(Color.WHITE);
		PHighscore.add(JLHighScoreList);
		if(topPlayers.size()!=0) 
			JLHighScoreList.setText(topPlayers.getPlayer(0).toString());
		for(int i =1; i<topPlayers.size();i++) 
			JLHighScoreList.setText("<html>"+JLHighScoreList.getText()+"<p>"+topPlayers.getPlayer(i).toString().substring(7)+"<html>");
		
		JButton JBVolver = new JButton("VOLVER AL MENU");
		JBVolver.setFont(new Font("Playbill", Font.BOLD, 50));
		JBVolver.setBounds(400, 15, 300, 60);
		PHighscore.add(JBVolver);
		JBVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PHighscore.setVisible(false);
				PSeleccionProta.setVisible(true);
			}
		});
		
	}
}