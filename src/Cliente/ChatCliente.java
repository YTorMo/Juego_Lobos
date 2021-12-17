package Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

import PaquetesDeDatos.Datos_lobo;
class ChatCliente extends JPanel implements Runnable{
	
	private JTextField texto;
	private JLabel nick;
	private JButton btn1;
	private JTextArea chat;
	private int tipoChat;
	private JPanel sup,inf,lob;
	
	public ChatCliente(int tipoChat, String Nusuario) {
		
		
		setBorder(BorderFactory.createLineBorder(new Color(230,230,230), 1));
		setLayout(new BorderLayout());
		setBackground(new Color(0,0,0,0));
		
		this.tipoChat= tipoChat;
		
		if(tipoChat==0) {
		
			sup=new JPanel();
			add(sup, BorderLayout.NORTH);
		
			nick= new JLabel(Nusuario);
		
			JLabel txt= new JLabel("      -CHAT PRINCIPAL-");
			sup.add(txt);	
			
		}else {
			nick = new JLabel(Nusuario);
			
			lob=new JPanel();
			lob.setBackground(new Color(150,0,0));
			add(lob, BorderLayout.NORTH);
			
			/*String white = "this is white";
			SpannableString whiteSpannable= new SpannableString(white);
			whiteSpannable.setSpan(new ForegroundColorSpan(Color.WHITE), 0, white.length(), 0);*/
			
			JLabel txt= new JLabel("      -CHAT LOBOS-");
			txt.setFont(new Font("Arial", Font.PLAIN, 14));
			txt.setForeground(new Color(255,255,255));
			lob.add(txt);
		}
		
		
			
		chat= new JTextArea(12,20);
		add(chat, BorderLayout.CENTER);
		
		inf=new JPanel();
		add(inf, BorderLayout.SOUTH);
		inf.setLayout(new BorderLayout());
		
		texto= new JTextField(20);
		inf.add(texto, BorderLayout.CENTER);
		
		btn1= new JButton("Enviar");
		btn1.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
//----------------------------------------------------------------Informacion enviada al servidor------------------------------------------------------------------
				

					
					try {
					
						Socket misocked = new Socket("192.168.1.41", 444);
					
					
						Datos_lobo paquete = new Datos_lobo();
						paquete.setNick(nick.getText());
						paquete.setMensaje(texto.getText());
						texto.setText("");
						paquete.setRol("lobo");
						paquete.setTipoChat(tipoChat);
					
						ObjectOutputStream paquetededatos = new ObjectOutputStream(misocked.getOutputStream());
						paquetededatos.writeObject(paquete);
						paquetededatos.close();
					
						misocked.close();
					
					
					
					
					} catch (UnknownHostException e1) {
						System.out.println(e1.getMessage());
					} catch (IOException e1) {
						System.out.println(e1.getMessage() + " caca =(");
					}

				
				
				
			}
			
		});
		inf.add(btn1, BorderLayout.EAST);
		
		
		Thread hilo2= new Thread(this);
		hilo2.start();
	}//Fin del constructor de LaminaMarcoCliente
	
	
	
	
	

//----------------------------------------------------------------Informacion de regreso------------------------------------------------------------------
	
	
	

	
	public void run() {
			
			int puerto;
			if(tipoChat==0) puerto=9090;
			else puerto=9080;
			
			
			try {
			ServerSocket servidor = new ServerSocket(puerto);
			String nick,mensaje;
			Datos_lobo paqueterecibido;
			
			while(true) {
			
				Socket misocket = servidor.accept();
				
				ObjectInputStream paquetededatos = new ObjectInputStream(misocket.getInputStream());
				paqueterecibido = (Datos_lobo) paquetededatos.readObject();
				paquetededatos.close();
				
				nick = paqueterecibido.getNick();
				mensaje = paqueterecibido.getMensaje();
				if(paqueterecibido.getOnline()==null) {
					if(tipoChat==0) 
					chat.append(nick + ": " + mensaje + "\n");
					if(tipoChat==1 && paqueterecibido.getRol().equalsIgnoreCase("lobo")) 
					chat.append(nick + ": " + mensaje + "\n");
				
				}
				
				
				misocket.close();
			}
			
			
		} catch (IOException | ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	
	
		
	}
	
}






