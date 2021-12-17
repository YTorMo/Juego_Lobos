package Cliente;

import javax.swing.JPanel;

import PaquetesDeDatos.Jugador;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;

public class panelVotar extends JPanel {
	
	
	public static JButton votarbtn;
	/**
	 * Create the panel.
	 */
	public panelVotar(ArrayList<Jugador> listado, Jugador jugadorActual) {
		setBackground(new Color(102, 0, 0,0));
		setLayout(null);
		
		votarbtn = new JButton("Votar");
		votarbtn.setForeground(new Color(204, 102, 0));
		votarbtn.setFont(new Font("Arial", Font.BOLD, 28));
		votarbtn.setBounds(27, 11, 158, 80);
		votarbtn.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
				marcoVotacion votar=new marcoVotacion(listado,jugadorActual);
				votar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
			
		});
		add(votarbtn);

	}
}
