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

import Factories.FactoryMapaGrilla;
import Factories.FactoryMapaGrillaGoku;
import Factories.FactoryMapaGrillaNaruto;
import Factories.FactoryNiveles;
import Nivel.Nivel;
import ranking.Player;
import ranking.TopPlayers;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel ContentPanel;
	private FactoryMapaGrilla F_Mapa_Grilla;
	private Nivel F_Nivel;
	private String nombre;
	private JTextField JTFmiNombre;
	private TopPlayers topPlayers; 
	/**
	 * Launch the application.
	 */
	
	public static Properties configuration;
	
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
		JLIngresaN.setBounds(0, 476, 337, 87);
		PSeleccionProta.add(JLIngresaN);
		
		JButton JBAceptar = new JButton("ACEPTAR\r\n");
		JBAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre=JTFmiNombre.getText();
				JBGoku.setEnabled(true);
				JBNaruto.setEnabled(true);
				JBAceptar.setEnabled(false);
			}
		});
		JBAceptar.setBounds(480, 542, 102, 32);
		PSeleccionProta.add(JBAceptar);
		
		
		JTFmiNombre = new JTextField();
		JTFmiNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent. VK_ENTER) {
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
		
		
		
		
		JButton JBNivel1 = new JButton("NIVEL 1");
		JBNivel1.setBackground(Color.WHITE);
		JBNivel1.setFont(new Font("Playbill", Font.BOLD, 80));
		JBNivel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F_Nivel=new FactoryNiveles().crearNivel1();
				GUI_MAPA GUIWindow = new GUI_MAPA(F_Mapa_Grilla,F_Nivel,nombre,tp);
				GUIWindow.getFrame().setVisible(true);
				ContentPanel.setLayout(null);
				dispose();
			}
		});
		JBNivel1.setBounds(0, 151, 236, 277);
		PSeleccionNivel.add(JBNivel1);
		
		JButton JBNivel2 = new JButton("NIVEL 2");
		JBNivel2.setFont(new Font("Playbill", Font.BOLD, 80));
		JBNivel2.setBounds(238, 151, 236, 277);
		PSeleccionNivel.add(JBNivel2);
		JBNivel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				//
				//
				//TIENE QUE IR EL INVOKE LATER????? PORQUE??? Nahuel
				//
				//
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							F_Nivel=new FactoryNiveles().crearNivel2();
							GUI_MAPA GUIWindow = new GUI_MAPA(F_Mapa_Grilla,F_Nivel,nombre,tp);
							GUIWindow.getFrame().setVisible(true);
							ContentPanel.setLayout(null);
							
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		
		JButton JBNivel3 = new JButton("NIVEL 3");
		JBNivel3.setFont(new Font("Playbill", Font.BOLD, 80));
		JBNivel3.setBounds(472, 151, 236, 277);
		PSeleccionNivel.add(JBNivel3);
		JBNivel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				//
				//
				//TIENE QUE IR EL INVOKE LATER????? PORQUE??? Nahuel
				//
				//
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							F_Nivel=new FactoryNiveles().crearNivel3();
							GUI_MAPA GUIWindow = new GUI_MAPA(F_Mapa_Grilla,F_Nivel,nombre,tp);
							GUIWindow.getFrame().setVisible(true);
							ContentPanel.setLayout(null);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		JLabel lblNewLabel = new JLabel("Elije el nivel que quieres jugar");
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 23, 630, 95);
		PSeleccionNivel.add(lblNewLabel);
	}
}