package Cliente;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

import Comunicacion.receptorPaqueteDatosC;
import PaquetesDeDatos.Jugador;


public class Lobo_cliente{
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int op;
		 
		MarcoInicioCliente MarcoVacio = new MarcoInicioCliente();
		MarcoVacio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		int op = JOptionPane.showOptionDialog(MarcoVacio, "Elige una opción:", "Hombres Lobo", 1,3,null, new String[]{"Crear Partida", "Unirse a partida"},null);
		
		
		if(op==0) {
			
			MarcoInicioHost mimarcoHost= new MarcoInicioHost();
			mimarcoHost.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}else {
			
			MarcoInicioUnidos mimarcoUnido= new MarcoInicioUnidos();
			mimarcoUnido.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		}
		

	}
}
	
	class MarcoInicioCliente extends JFrame implements Runnable{
		
		private Jugador DatosJugador;
		private int nJugadores=0;
		private MarcoClientePartida partida= null, partida2=null;
		private Boolean controlador= true;
		private InetAddress iplocal;
		
		
		public MarcoInicioCliente() {
			
			setBounds(600,300,880,650);
			
			
			JPanel A1 = new JPanel();
			A1.setBackground(new Color(150,0,0));
			A1.setLayout(new BorderLayout());
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
			
			
			setVisible(true);
			
			
			
			
			Thread h= new Thread(this);
			h.start();
			
		}
		
		public void run() {
			
			Object dat = new Object();
			ArrayList <Jugador> jugadoresPartida = new ArrayList<Jugador>();
			//receptorPaqueteDatosC recibir= new receptorPaqueteDatosC();
			
			try {
				ServerSocket servidor = new ServerSocket(9090);
				
				
				
				
				while(true) {

					Socket miSocket = servidor.accept();
					
					
					try {
						ObjectInputStream paquetededatos2 = new ObjectInputStream(miSocket.getInputStream());
						dat = paquetededatos2.readObject();
						System.out.println("Recibido paquete");
						paquetededatos2.close();
						
						System.out.println((dat.getClass()).getName());
						if(((dat.getClass()).getName()).equalsIgnoreCase("java.util.ArrayList")) {
							jugadoresPartida = (ArrayList<Jugador>) dat;
							
							for(Jugador j: jugadoresPartida) {
								
								if(j.getIP_jugador().equals(InetAddress.getLocalHost())) {
									System.out.println(j.getNombre() + "\n" +  j.getRolN() + "\n" +  j.getNJugadores() + "\n");
									nJugadores= j.getNJugadores();
									DatosJugador = j;
									break;
								}
								
							}
							if(partida!= null) {
								partida.dispose();
							}
							if(jugadoresPartida.size() < nJugadores) {
								partida= new MarcoClientePartida(jugadoresPartida.size() , nJugadores);
								setVisible(false);
								controlador= false;
								partida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							}else if (jugadoresPartida.size() == nJugadores) {
								partida2= new MarcoClientePartida(DatosJugador.getRolN(), DatosJugador.getNombre(), DatosJugador.getNJugadores(),jugadoresPartida);
								partida2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							}
						
						}
						
					} catch (IOException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println("Caca cliente =(");
						e.printStackTrace();
					}
				
					System.out.println(dat.getClass().getName());
				}
			} catch (IOException e) {
				
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	
	









