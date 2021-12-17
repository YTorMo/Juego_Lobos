package Comunicacion;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class receptorPaqueteDatosC {
	
private Object dat;

	
	public receptorPaqueteDatosC() {
		dat=null;
		}
		
		
		
		public Object receptorInformacion(Socket recibirSocket){
			
			
					
					
			ObjectInputStream paquetededatos2;
			try {
				paquetededatos2 = new ObjectInputStream(recibirSocket.getInputStream());
				dat = paquetededatos2.readObject();
				paquetededatos2.close();
				
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					
							
					
					
			
			return dat;
			
		}

}
