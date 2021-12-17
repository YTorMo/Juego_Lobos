package Cliente;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Comunicacion.envioPaqueteDatosC;
import PaquetesDeDatos.Jugador;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class marcoVotacion extends JFrame {

	private JPanel contentPane;
	private String jugadorVotado;
	private envioPaqueteDatosC enviar;
	
	/**
	 * Create the frame.
	 */
	public marcoVotacion(ArrayList<Jugador> listado, Jugador jugadorActual) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		enviar= new envioPaqueteDatosC();
		
		//------------------Longitud del Strng[]---------------------------
		
		int cont=0,cont2=0;
		
		for(Jugador i: listado) {
			
			if(i.getVivo()) {
				cont++;
			}
			
		}
		
		String[] jugadoresVotar= new String[(cont)];
		
		//------------------Crear un String[] con los jugadores a votar----------------------------------
		
		
		
		for(Jugador j: listado) {
				
				jugadoresVotar[cont2]=j.getNombre();
				cont2++;
			
		}
		
		JComboBox<String> listaJugadores = new JComboBox<String>();
		for(int z=0; z<jugadoresVotar.length; z++) {
			
			if(!(jugadoresVotar[z].equalsIgnoreCase(jugadorActual.getNombre())))
				listaJugadores.addItem(jugadoresVotar[z]);
			
		}
		
		listaJugadores.setBounds(110, 78, 180, 22);
		contentPane.add(listaJugadores);
		
		
		
		//--------------Boton Aceptar------------------------------------
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jugadorVotado=(String) listaJugadores.getSelectedItem();
				System.out.println(jugadorVotado);
				enviar.envioInformacion(jugadorVotado);
				dispose();
				
			}
		});
		btnAceptar.setBounds(110, 227, 90, 25);
		contentPane.add(btnAceptar);
		
		
		//--------------Boton Cancelar------------------------------------
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(200, 227, 90, 25);
		contentPane.add(btnCancelar);
		
		
		//-------------Etiqueta enunciado---------------------------------
		
		JLabel etiquetaSeleccion = new JLabel("Elige al judador al que quieres votar:");
		etiquetaSeleccion.setFont(new Font("Arial", Font.PLAIN, 14));
		etiquetaSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
		etiquetaSeleccion.setBounds(60, 28, 266, 29);
		contentPane.add(etiquetaSeleccion);
		
		
		
		setVisible(true);
	}
	
	
}
