package Comunicacion;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class envioPaqueteDatosS {
	
public envioPaqueteDatosS() {
		
	}
	
	public void envioInformacion(String IP,Object paquet){
		
		try {
			
			Socket envioSocket = new Socket(IP , 9070);
		
			ObjectOutputStream paquetededatos = new ObjectOutputStream(envioSocket.getOutputStream());
			paquetededatos.writeObject(paquet);
			paquetededatos.close();
		
			envioSocket.close();
		
		
		
		
		} catch (UnknownHostException e1) {
			System.out.println(e1.getMessage());
		} catch (IOException e1) {
			System.out.println(e1.getMessage() + " caca =( Servidor");
		}
		
	}

}
