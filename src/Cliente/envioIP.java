package Cliente;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectOutputStream;
import java.net.Socket;

import PaquetesDeDatos.Datos_lobo;

//-----------------------------------------------------------------Envio de la ip local al servidor remoto al iniciar la aplicacion------------------------------------------------------------

class envioIP extends WindowAdapter{
	
	public void windowOpened(WindowEvent e) {
		
		try {
			
			Socket online = new Socket("192.168.1.41", 444);
			
			
			Datos_lobo senalonline2 = new Datos_lobo();
			senalonline2.setOnline(true);
			senalonline2.setRol("lobo");
			
			ObjectOutputStream enviononline2= new ObjectOutputStream(online.getOutputStream());
			enviononline2.writeObject(senalonline2);
			enviononline2.close();
			
			online.close();
			
		}catch(Exception e1) {}
	}
	
}

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
