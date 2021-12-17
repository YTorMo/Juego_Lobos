package Cliente;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import PaquetesDeDatos.Jugador;

public class MarcoInicioUnidos extends JFrame{
	
	Jugador DatosJugador;
	
	public MarcoInicioUnidos() {
		
		
		DatosJugador = new Jugador();
		String nombreusuario= JOptionPane.showInputDialog("Introduce tu nick de usuario: ");
		DatosJugador.setNombre(nombreusuario);
		DatosJugador.setHost(false);
		
		try {
			
			
			
			Socket envioSocket = new Socket("192.168.1.41", 444);
		
			ObjectOutputStream paquetededatos = new ObjectOutputStream(envioSocket.getOutputStream());
			paquetededatos.writeObject(DatosJugador);
			paquetededatos.close();
		
			envioSocket.close();
		
		
		
		
		} catch (UnknownHostException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage() + " caca =( Cliente");
		}
	}

}
