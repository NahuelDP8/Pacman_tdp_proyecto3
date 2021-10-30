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

import Factories.FactoryMapaGrillaGoku;
import Factories.FactoryMapaGrillaNaruto;

import javax.swing.border.BevelBorder;

public class GUIMenu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		setBounds(400,60,522,522);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		
		JButton btnNaruto = new JButton("JUGAR NARUTO");
		btnNaruto.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
		btnNaruto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GUI window = new GUI(new FactoryMapaGrillaNaruto());
							window.frmJuego.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNaruto.setBounds(261, 100, 261, 422);
		
		JButton btnGoku = new JButton("JUGAR GOKU");
		btnGoku.setFont(new Font("Source Sans Pro", Font.BOLD, 14));
		btnGoku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GUI window = new GUI(new FactoryMapaGrillaGoku());
							window.frmJuego.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnGoku.setBounds(0, 100, 261, 422);
		
		JLabel lblNewLabel = new JLabel("MODO DE JUEGO");
		lblNewLabel.setBounds(0, 30, 522, 78);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 45));
		contentPane.setLayout(null);
		ImageIcon imagen = new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/naruto.png"));
		Image EscalarFoto = imagen.getImage().getScaledInstance(btnNaruto.getWidth(),btnNaruto.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon FotoEscalada = new ImageIcon(EscalarFoto);
		btnNaruto.setIcon(FotoEscalada);
		contentPane.add(btnNaruto);
		imagen = new ImageIcon(FactoryMapaGrillaNaruto.class.getResource("/Imagenes/goku.png"));
		EscalarFoto = imagen.getImage().getScaledInstance(btnGoku.getWidth(),btnGoku.getHeight(), Image.SCALE_SMOOTH);
		FotoEscalada = new ImageIcon(EscalarFoto);
		btnGoku.setIcon(FotoEscalada);
		contentPane.add(btnGoku);
		contentPane.add(lblNewLabel);
		
		JLabel Fondo = new JLabel("");
		Fondo.setVerticalAlignment(SwingConstants.BOTTOM);
		Fondo.setBounds(10, 30, 315, 642);
		contentPane.add(Fondo);
	}
}