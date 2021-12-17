package Servidor;

import javax.swing.*;

import Comunicacion.envioPaqueteDatosS;
import Comunicacion.receptorPaqueteDatosS;
import PaquetesDeDatos.Datos_lobo;
import PaquetesDeDatos.Jugador;
import PaquetesDeDatos.tipoArrayString;
import funcionesExtra.genera_aleatorios;

import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;

public class Lobo_servidor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarcoServidor mimarco= new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoServidor extends JFrame implements Runnable{
	
	private JTextArea areatxt;
	private InetAddress iplocalrecibida;
	private String ipUsuario;
	
	public MarcoServidor() {
		
		setBounds(1200,300,280,350);
		
		JPanel lam2= new JPanel();
		lam2.setLayout(new BorderLayout());
		areatxt= new JTextArea();
		lam2.add(areatxt, BorderLayout.CENTER);
		add(lam2);
		
		
		setVisible(true);
		
		
		Thread hilo1= new Thread(this);
		hilo1.start();
	}

	public void run() {
//--------------------------------------------------------------------CHAT--------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------CHAT--------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------CHAT--------------------------------------------------------------------------------------------------------------------------------------------------------
		
		//Variables
		ArrayList <String> listaIP = new ArrayList<String>();
		ArrayList <Jugador> jugadoresPartida = new ArrayList<Jugador>();
		String nick,mensaje,rolj;
		int tipoChat,nJugadores=0,contNJugadores=0,posAsignacion,contPos;
		int[] ordenAsignacionRoles,jugadoresRestantes=new int[2];
		Datos_lobo paqueterecibido;
		//Iterator<Jugador> it = jugadoresPartida.iterator();
		
		//Boolean EstadoOnline=false;
		
		//Instancias Objetos
		tipoArrayString datosRoles = new tipoArrayString();
		Object dat = new Object();
		Jugador jug= new Jugador();
		receptorPaqueteDatosS recibir= new receptorPaqueteDatosS();
		envioPaqueteDatosS enviar= new envioPaqueteDatosS();
		
		
		
		
		try {
			ServerSocket servidor = new ServerSocket(444);
			
			
			
			
			while(true) {

				Socket misocket = servidor.accept();
				
				//------------------RECEPCION DE PAQUETES DE INICIO DE PARTIDA--------------------------------
		
				
				
				//------------------PAQUETES RECIBIDOS--------------------------------------------------------
				
				dat = recibir.receptorInformacion(misocket);
				
				//------------------COMPROBACION DE TIPO DE PAQUETE RECIBIDO----------------------------------
				if(((dat.getClass()).getName()).equalsIgnoreCase("PaquetesDeDatos.tipoArrayString")) {
					System.out.println("Sabe que es un string");
					if(nJugadores!=0) {
						datosRoles= (tipoArrayString) dat;
						
						for(String z: datosRoles.getAlmacen()) {
						System.out.println("Recibido: " + z);
						}
						
					}
				}else if(((dat.getClass()).getName()).equalsIgnoreCase("PaquetesDeDatos.Jugador")) {
					System.out.println("Es un jugador");
					jug= (Jugador) dat;
					
					if(jug.getHost()){
						nJugadores= jug.getNJugadores();
				
						
					}
					
					
					if(contNJugadores<nJugadores) {
						
						contNJugadores++;
						System.out.println("N: " + contNJugadores);
						
				//--------------------IPS QUE SE CONECTAN--------------------------------------------------------
						iplocalrecibida = misocket.getInetAddress();
						ipUsuario = iplocalrecibida.getHostAddress();
						listaIP.add(ipUsuario);
						System.out.println(ipUsuario);
						//jug.setIP_jugador(ipUsuario);
						
				//--------------------AÑADIR AL JUGADOR AL ARRAYLIST DE JUGADORES---------------------------------	
						
						jugadoresPartida.add(jug);
						
				//------------------ACCIONES TRAS CONECTARSE TODOS LOS JUGADORES----------------------------------
						
						if(contNJugadores==nJugadores) {
							
				//------------------ASIGNACION ALEATORIA DE ROLES-------------------------------------------------
							
							ordenAsignacionRoles=(new genera_aleatorios(nJugadores).dame_aleatorios());
						
							for(int i=0; i<nJugadores; i++) {
								posAsignacion = ordenAsignacionRoles[i];
								contPos=0;
								for(Jugador w: jugadoresPartida) {
								
									contPos++;
									
									if(contPos == posAsignacion) {
										w.setRolN((datosRoles.getAlmacen())[i]);
									}
								
								}
							
							}
						
							for(Jugador f: jugadoresPartida) {
								System.out.println("Nombre del jugador: " + f.getNombre() + " Rol: " + f.getRolN());
							}
						
						}
					
						for(Jugador f: jugadoresPartida) {
						System.out.println("Nombre del jugador: " + f.getNombre());
						}
				//------------------FIN ASIGNACION ALEATORIA DE ROLES--------------------------------------------
					
					System.out.println("Numero de jugadores: " + nJugadores);
				}
				}else {
					System.out.println("No sabe que es");
				}
					
				System.out.println((dat.getClass()).getName());
					
				misocket.close();	
					
				//------------------FIN COMPROBACION DE TIPO DE PAQUETE RECIBIDO----------------------------------
					
					
				//------------------FIN DE PAQUETES DE INICIO DE PARTIDA------------------------------------------
					
					
					
					
		
				
				//------------------ENVIO DE REGRESO A LOS JUGADORES SUS ROLES ASIGNADOS--------------------------
					
						/*jugadoresRestantes[0]= contNJugadores;
						jugadoresRestantes[1]= nJugadores;*/
						
						for(String z:listaIP) {
							Socket salidadatos = new Socket(z, 9090);
							System.out.println("abre socket");
							ObjectOutputStream paquetedesalida = new ObjectOutputStream(salidadatos.getOutputStream());
							paquetedesalida.writeObject(jugadoresPartida);
							paquetedesalida.close();
							
							
						
							salidadatos.close();
							
							//misocket.close();
					
						}
				//------------------FIN ENVIO DE REGRESO A LOS JUGADORES SUS ROLES ASIGNADOS-----------------------
				
				/*ObjectInputStream paquetededatos = new ObjectInputStream(misocket.getInputStream());
				paqueterecibido = (Datos_lobo) paquetededatos.readObject();
				paquetededatos.close();
				nick = paqueterecibido.getNick();
				mensaje = paqueterecibido.getMensaje();
				tipoChat = paqueterecibido.getTipoChat();
				rolj = paqueterecibido.getRol();
					
				if(!EstadoOnline) {
					
					EstadoOnline=paqueterecibido.getOnline();
					iplocalrecibida = misocket.getInetAddress();
					ipUsuario = iplocalrecibida.getHostAddress();
					listaIP.add(ipUsuario);
					System.out.println("IP online");
					
					
					
						
						
						
				}else {
//----------------------------------------------------------------------Respuesta de regreso a todos los chats pricipales y de roles---------------------------------------------------------
						
						if(tipoChat==0) {
							
							for(String z:listaIP) {

								Socket salidadatos = new Socket(z, 9090);
								areatxt.append(nick + ": " + mensaje + "\n");
								paqueterecibido.setTipoChat(tipoChat);
								ObjectOutputStream paquetedesalida = new ObjectOutputStream(salidadatos.getOutputStream());
								paquetedesalida.writeObject(paqueterecibido);
								paquetedesalida.close();
								
								
							
								salidadatos.close();
								
								misocket.close();
						
								
								}
							
						}else {
							
							for(String z:listaIP) {

								Socket salidadatos = new Socket(z, 9080);
								areatxt.append(nick + ": " + mensaje + "\n");
								paqueterecibido.setTipoChat(tipoChat);
								ObjectOutputStream paquetedesalida = new ObjectOutputStream(salidadatos.getOutputStream());
								paquetedesalida.writeObject(paqueterecibido);
								paquetedesalida.close();
								
								
							
								salidadatos.close();
								
								misocket.close();
						
								
								}
							
						}
					
		//------------------------------------------------------------Informacion enviada de regreso al cliente especificado----------------------------------------------------------------------------------
						
						
						
					}*/
				
			}
			
		
			
		} catch (IOException e) {
			System.out.println("Caca Servidor =(");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
//--------------------------------------------------------------------FIN CHAT--------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------FIN CHAT--------------------------------------------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------FIN CHAT--------------------------------------------------------------------------------------------------------------------------------------------------------
		
	}//Final del Run
}