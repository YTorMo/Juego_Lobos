package Comunicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class envioPaqueteDatosC {
	
	
	
	public envioPaqueteDatosC() {
		
	}
	
	public void envioInformacion(Object paquet){
		
		try {
			
			
			
			Socket envioSocket = new Socket("192.168.1.41", 444);
		
			ObjectOutputStream paquetededatos = new ObjectOutputStream(envioSocket.getOutputStream());
			paquetededatos.writeObject(paquet);
			paquetededatos.close();
		
			envioSocket.close();
		
		
		
		
		} catch (UnknownHostException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage() + " caca =( Cliente");
		}
		
	}

}
