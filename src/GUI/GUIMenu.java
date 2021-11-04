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
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;

import Factories.FactoryMapaGrilla;
import Factories.FactoryMapaGrillaGoku;
import Factories.FactoryMapaGrillaNaruto;
import Factories.FactoryNiveles;
import Nivel.Nivel;

import javax.swing.border.BevelBorder;

public class GUIMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel ContentPanel;
	private FactoryMapaGrilla F_Mapa_Grilla;
	private Nivel F_Nivel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMenu frame = new GUIMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIMenu() {
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
		PSeleccionNivel.setBounds(10, 8, 730, 574);
		ContentPanel.add(PSeleccionNivel);
		PSeleccionNivel.setLayout(null);
		PSeleccionNivel.setVisible(false);
		
		
		JButton btnGoku = new JButton("JUGAR GOKU");
		btnGoku.setBounds(24, 106, 255, 353);
		PSeleccionProta.add(btnGoku);
		imagen = new ImageIcon(FactoryMapaGrillaGoku.class.getResource("/Imagenes/goku.png"));
		EscalarFoto = imagen.getImage().getScaledInstance(btnGoku.getWidth(),btnGoku.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		btnGoku.setIcon(FotoEscalada);
		btnGoku.setBackground(Color.BLACK);
		btnGoku.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
		btnGoku.addActionListener(new ActionListener() {
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
		
		
	
		
		JButton btnNaruto = new JButton("JUGAR NARUTO");
		btnNaruto.setBounds(387, 106, 255, 353);
		PSeleccionProta.add(btnNaruto);
		btnNaruto.setBackground(Color.BLACK);
		btnNaruto.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
		imagen = new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/narutoRun.gif"));
		EscalarFoto = imagen.getImage().getScaledInstance(btnNaruto.getWidth(),btnNaruto.getHeight(), Image.SCALE_DEFAULT);
		FotoEscalada = new ImageIcon(EscalarFoto);
		btnNaruto.setIcon(FotoEscalada);
		btnNaruto.addActionListener(new ActionListener() {
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
		
		
		JLabel ModoDeJuego = new JLabel("MODO DE JUEGO");
		ModoDeJuego.setBounds(75, 10, 522, 78);
		PSeleccionProta.add(ModoDeJuego);
		ModoDeJuego.setHorizontalAlignment(SwingConstants.CENTER);
		ModoDeJuego.setForeground(Color.WHITE);
		ModoDeJuego.setFont(new Font("Yu Gothic Light", Font.PLAIN, 45));
		
		
		
		JButton JBNivel1 = new JButton("NIVEL 1");
		JBNivel1.setBackground(Color.WHITE);
		JBNivel1.setFont(new Font("Playbill", Font.BOLD, 80));
		JBNivel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				F_Nivel=new FactoryNiveles().crearNivel1();
				GUI_MAPA GUIWindow = new GUI_MAPA(F_Mapa_Grilla,F_Nivel);
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
							GUI_MAPA GUIWindow = new GUI_MAPA(F_Mapa_Grilla,F_Nivel);
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
							GUI_MAPA GUIWindow = new GUI_MAPA(F_Mapa_Grilla,F_Nivel);
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