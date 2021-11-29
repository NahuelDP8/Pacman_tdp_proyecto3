package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import Music.AudioPlayer;
import ranking.TopPlayers;

public class GUI_Defeat extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel ContentPanel;
	private JPanel PPerdiste;
	private JLabel JLPerdiste;
	private JButton JBVolverAMenuD;
	private TopPlayers topPlayers;
	private AudioPlayer audio;
	private boolean musicLoop;
	
	public GUI_Defeat(TopPlayers TP) {
		topPlayers=TP;
		musicLoop=false;
		audio=new AudioPlayer(new File(GUIMenu.configuration.getProperty("DefeatMusic")),musicLoop);
		initialized();
	}
	private void initialized() {
		Image EscalarFoto;
		ImageIcon FotoEscalada;
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50,60,1152,747);
		ContentPanel = new JPanel();
		ContentPanel.setBackground(Color.BLACK);
		ContentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(ContentPanel);
		ContentPanel.setLayout(null);
		//Panel de victoria
		PPerdiste = new JPanel();
		PPerdiste.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PPerdiste.setForeground(Color.WHITE);
		PPerdiste.setBounds(6, 6, 1500, 890);
		ContentPanel.add(PPerdiste);
		PPerdiste.setBackground(new Color(0, 0, 0));
		PPerdiste.setLayout(null);
		
		JLPerdiste = new JLabel("HAS PERDIDO");
		JLPerdiste.setBounds(584, 99, 439, 121);
		PPerdiste.add(JLPerdiste);
		JLPerdiste.setForeground(Color.WHITE);
		JLPerdiste.setBackground(Color.BLACK);
		JLPerdiste.setToolTipText("");
		JLPerdiste.setHorizontalAlignment(SwingConstants.CENTER);
		JLPerdiste.setFont(new Font("Times New Roman", Font.BOLD, 50));
		
		JLabel JLWinnerImage = new JLabel("");
		JLWinnerImage.setBounds(80, 52, 439, 570);
		System.out.println("etBounds(80, 52, 439, 570)");
		EscalarFoto = new ImageIcon(GUI_Defeat.class.getResource("/Imagenes/defeat.png")).getImage().getScaledInstance(JLWinnerImage.getWidth(),JLWinnerImage.getHeight(), Image.SCALE_DEFAULT);
		System.out.println(" = new ImageIcon(GUI_Victory");
		FotoEscalada = new ImageIcon(EscalarFoto);
		System.out.println("da = new ImageIcon(EscalarFo");
		JLWinnerImage.setIcon(FotoEscalada);
		PPerdiste.add(JLWinnerImage);
		
		JBVolverAMenuD = new JButton("Volver al menu");
		JBVolverAMenuD.setBackground(Color.BLACK);
		JBVolverAMenuD.setForeground(Color.WHITE);
		JBVolverAMenuD.setFont(new Font("Segoe UI Black", Font.ITALIC, 30));
		
		JBVolverAMenuD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							audio.stopMusic();
							GUIMenu Nframe = new GUIMenu(topPlayers);
							Nframe.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		JBVolverAMenuD.setBounds(650, 377, 311, 70);
		PPerdiste.add(JBVolverAMenuD);
		
		
		
		
	}
}
