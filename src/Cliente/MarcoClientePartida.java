package Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Comunicacion.receptorPaqueteDatosC;
import Comunicacion.receptorPaqueteDatosS;
import PaquetesDeDatos.Jugador;

public class MarcoClientePartida  extends JFrame {
	
	public panelVotar votar;
	
	public MarcoClientePartida(int jOn, int nJugadores) {
		
		setBounds(600,300,880,650);
		setLayout(new GridLayout(1,2));
		
		JPanel A1 = new JPanel();
		A1.setLayout(new BorderLayout());
		A1.setBackground(new Color(150,0,0));
		A1.setVisible(true);
		add(A1);
		
		BufferedImage myPicture= null;
		try {
			myPicture = ImageIO.read(new File("F:/Proyecto_Java/Juego_Lobos/src/ESTADOS/lobo.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		A1.add(picLabel, BorderLayout.CENTER);
		
		JLabel esperando= new JLabel("                                         Esperando al resto de jugadores ( " + jOn + " / " + nJugadores + " )");
		esperando.setFont(new Font("Arial", Font.PLAIN, 20));
		esperando.setForeground(Color.WHITE);
		A1.add(esperando, BorderLayout.NORTH);
		
		setVisible(true);
		
	}
	
	public MarcoClientePartida(String rol,String nombreusuario, int nJugadores, ArrayList<Jugador> listado) { //Cambio1
		
		setBounds(600,300,880,650);
		setTitle("Partida en curso");
		
		//----------------Detectar el jugador de este marco----------------------
		
		Jugador esteJugador= new Jugador();
		
		for(Jugador i: listado) {
			if(i.getNombre().equalsIgnoreCase(nombreusuario)) {
				esteJugador=i;
				break;
			}
		}
		
		//----------------Fin de detectar el jugador de este marco----------------
		
		JPanel A0 = new JPanel();
		A0.setLayout(new GridLayout(1,2));
		A0.setBackground(new Color(150,0,0));
		A0.setVisible(true);
		add(A0);
		
//-------------------------------------------------------------------------Area 1-------------------------------------------------------------------------------------	
		
		JPanel A1 = new JPanel();
		A1.setLayout(new GridLayout(2,2));
		A1.setBackground(new Color(150,0,0,0));
		A1.setVisible(true);
		A0.add(A1);
		
		//Rol
		
		//---------------------Paneles de rol-------------------------------------
		
		PanelDeRol R_Graf= new PanelDeRol(nombreusuario, rol);
		R_Graf.setVisible(true);
		A1.add(R_Graf);
		
		//---------------------Fin de paneles de rol------------------------------
		
		
		//Estados
		
		//---------------------Paneles de estado-------------------------------------
		contenedorEstados estados = new contenedorEstados(esteJugador);
		A1.add(estados);
		
		//---------------------Fin Paneles de estado---------------------------------
		
		
		
		//Otros Jugadores
		
		//----------------------Lista de jugadores------------------------------------
		
		listaJugadores lista= new listaJugadores(listado);
		A1.add(lista);
		
		//----------------------Fin lista de jugadores--------------------------------
		
		
		//Temporizador
		
		//--------------Panel del temporizador----------------------
		
		
		temporizador tiempo= new temporizador();
		tiempo.setVisible(true);
		A1.add(tiempo);
		
		
		//--------------Fin del panel del temporizador--------------
		
//-------------------------------------------------------------------------Area 2-------------------------------------------------------------------------------------		
		
		JPanel A2 = new JPanel();
		A2.setLayout(new GridLayout(1,2));
		A2.setBackground(new Color(150,0,0,0));
		A2.setVisible(true);
		A0.add(A2);
		
		JPanel A3 = new JPanel();
		A3.setLayout(new GridLayout(2,1));
		A3.setBackground(new Color(255,255,255,0));
		A3.setVisible(true);
		A2.add(A3);
		
		JPanel Aux3 = new JPanel();
		Aux3.setLayout(new GridLayout(2,1));
		Aux3.setBackground(new Color(255,255,255,0));
		Aux3.setVisible(true);
		A3.add(Aux3);
		
		votar=new panelVotar(listado,esteJugador);
		votar.setVisible(true);
		A3.add(votar);
		
		
		
		//------------------------Area de Chats-----------------------------------
		
		JPanel A4 = new JPanel();
		A4.setLayout(new GridLayout(2,1));
		A4.setBackground(new Color(0,0,0,0));
		A4.setVisible(true);
		A2.add(A4);
		
		ChatCliente lam1= new ChatCliente(0, nombreusuario);
		A4.add(lam1);
		
		ChatCliente lam2= new ChatCliente(1, nombreusuario);
		A4.add(lam2);
		lam2.setVisible(rol.equalsIgnoreCase("lobo"));
		
//--------------------------------------------------------------------------Fin de los paneles------------------------------------------------------------------------------
		
		setVisible(true);//Del JFrame
		
	}

	
	

		
		
		
}
