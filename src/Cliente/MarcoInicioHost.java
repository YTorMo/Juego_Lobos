package Cliente;


import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.*;

import Comunicacion.envioPaqueteDatosC;
import Errores.*;
import PaquetesDeDatos.Jugador;


public class MarcoInicioHost extends JFrame {
	
	private Jugador DatosJugador;
	private Boolean correct=false,seleccionTerminada;
	private int n_jugadores;
	private String[] almacenRoles;
	private control_cant c_jugCant;
	

	private envioPaqueteDatosC enviar;




	public MarcoInicioHost() {
		
		
		c_jugCant= new control_cant();
		enviar= new envioPaqueteDatosC();
		
		//---------NOMBRE DEL JUGADOR QUE CREA LA PARTIDA-----------------------------------------------------------------------------
		
		
		DatosJugador = new Jugador();
		String nombreusuario= JOptionPane.showInputDialog("Introduce tu nick de usuario: ");
		DatosJugador.setNombre(nombreusuario);
		
		
		//-----------------------------------------------------------------------------------------------------------------------------
		
		//---------NUMERO DE JUGADORES QUE PARTICIPARAN EN LA PARTIDA------------------------------------------------------------------
		
		 
    	do {
    	
    		try {
    			n_jugadores=Integer.parseInt(JOptionPane.showInputDialog(this, "Introduce el número de jugadores." + "\n"+"El número debe de ser mayor que 4 y menor que 19.", "Titulo", 3));

    			try {
        			c_jugCant.examinaNumero(n_jugadores);
        			correct=true;
        		}catch(error_longitud e2) {
        			JOptionPane.showMessageDialog(MarcoInicioHost.this,e2.getMessage(), "Titulo", 2);
        		}
    			
    		}catch(NumberFormatException e) {
    			JOptionPane.showMessageDialog(this,"Introduce un valor numérico entero", "Titulo", 2);
    		}
    
    	}while(!correct);
    	
    	DatosJugador.setNJugadores(n_jugadores);
    	DatosJugador.setHost(true);
    	try {
			DatosJugador.setIP_jugador(InetAddress.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(MarcoInicioHost.this,"No hay conexion", "Titulo", 2);
		}
    	
    	enviar.envioInformacion(DatosJugador);
    	
		
    	//-----------------------------------------------------------------------------------------------------------------------------
	
    	//---------SELECCION DE LOS ROLES EN LA PARTIDA--------------------------------------------------------------------------------
    	
    	
    	MarcoSleccionRoles rolesPartida = new MarcoSleccionRoles(n_jugadores);
    	rolesPartida.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	seleccionTerminada= rolesPartida.getTerminadaSeleccion();
    	almacenRoles=rolesPartida.getRolesSeleccionados();
    	
    	
    	//-----------------------------------------------------------------------------------------------------------------------------
    	
    	//---------COMIENZA LA PARTIDA-------------------------------------------------------------------------------------------------
    	
		
    	
		setVisible(true);
		
	}
	
	
	
	public Boolean getSeleccionTerminada() {
		return seleccionTerminada;
	}
		
	public String[] getAlmacenRoles() {
		return almacenRoles;
	}

	public void setAlmacenRoles(String[] almacenRoles) {
		this.almacenRoles = almacenRoles;
	}
	
	
	public Jugador getDatosJugador() {
		return DatosJugador;
	}

	public void setDatosJugador(Jugador datosJugador) {
		DatosJugador = datosJugador;
	}



}
