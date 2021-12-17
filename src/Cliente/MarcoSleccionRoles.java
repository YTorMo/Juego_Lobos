package Cliente;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.*;

import Comunicacion.envioPaqueteDatosC;
import PaquetesDeDatos.*;

public class MarcoSleccionRoles extends JFrame{
	
	private String[] rolesSeleccionados;
	private JButton btn;
	private Boolean terminadaSeleccion=false,correct=false, rolC=false;
	private int cantLobos=1,cantAldeanos=0,cont=0,cont2=0;
	
	
	private String[] opciones= {"Aldeano","Anciano","Bruja","Cazador","Cupido","Flautista","Niña","Niño Salvaje"};
	private JCheckBox rolesJuego;
	private JPanel centro;
	private ArrayList<JCheckBox> contenedor;
	
	






	public MarcoSleccionRoles(int Njugadores) {
		
		setBounds(600,300,200,400);
		setLayout(new BorderLayout());
		contenedor = new ArrayList<JCheckBox>();
		rolesSeleccionados= new String[Njugadores];
		tipoArrayString almacenRoles = new tipoArrayString();
		envioPaqueteDatosC enviar= new envioPaqueteDatosC();
		
		do {
	    	
    		try {
   //----------------------------------------------INTRODUCIR LA CANTIDAD DE LOBOS EN PARTIDA---------------------------------------------------------------------------------------------------------------------------
    			
    			
    			cantLobos = Integer.parseInt(JOptionPane.showInputDialog(MarcoSleccionRoles.this, "Selecciona cantdad de lobos:", "Titulo", 3));

    			
    //----------------------------------------------COMPROBAR QUE LA CANTIDAD INDICADA DE LOBOS ES CORRECTA--------------------------------------------------------------------------------------------------------------			
    			
    			
    			if(cantLobos>=1 && cantLobos<=Math.round(Njugadores/3)) {
    				correct=true;
    				    			
   //----------------------------------------------INTRODUCIR LA CANTIDAD INDICADA DE LOBOS EN EL ARRAY DE ROLES DE LA PARTIDA------------------------------------------------------------------------------------------
    			
    			
    				for(int h=0; h<cantLobos;h++) {
    					rolesSeleccionados[cont]= "Lobo";
    					cont++;
    				}
    		}else {
    				JOptionPane.showMessageDialog(MarcoSleccionRoles.this, "El numero de Lobos debe ser mayor que 1 y menor o igual que un tercio de los jugadores totales.", "Titulo", 1);
    				correct=false;
    			}
    			
    		}catch(NumberFormatException e1) {
    			JOptionPane.showMessageDialog(MarcoSleccionRoles.this, "El numero de Lobos debe ser un número entero.", "Titulo", 1);
    			correct=false;
    		}
    
    	}while(!correct);
		
		
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		
		
		centro = new JPanel();
		centro.setLayout(new GridLayout(opciones.length,1));
		add(centro, BorderLayout.CENTER);
		
		
		 
		 for(int i=0;i<opciones.length;i++) {
			 rolesJuego=new JCheckBox(opciones[i]);
			 contenedor.add(rolesJuego);
			 centro.add(rolesJuego);
			 	
		 }
		
		JPanel zonaBTN = new JPanel();
		add(zonaBTN, BorderLayout.SOUTH);
		
		btn= new JButton("OK");
		btn.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				
				
			//-------------COMPROBAR QUE NO HAYA MAS ROLES QUE JUGADORES---------------------------------------
				cont2=cantLobos;
				for(JCheckBox w: contenedor) {
					
					if(w.isSelected()) {
						cont2++;
					}
					
				}
				
				if(cont2>Njugadores) {
					
					for(JCheckBox y: contenedor) {
						
						if(y.isSelected()) {
							y.setSelected(false);
						}
					}
					rolC=false;
					JOptionPane.showMessageDialog(MarcoSleccionRoles.this, "El numero de roles seleccionados es superior al numero de jugadores.", "Error", 3);
			
//----------------------------------------------SELECCIONAR EL RESTO DE ROLES QUE HABRÁ EN LA PARTIDA-----------------------------------------------------------------------------------------
					
				}else if(cont2<=Njugadores){
				
				
				for(JCheckBox z: contenedor) {
					
					if(z.isSelected()) {
						if(z.getText().equalsIgnoreCase("Niño Salvaje")) rolesSeleccionados[cont] ="Niño_salvaje";
						
						else rolesSeleccionados[cont] = z.getText();
						
						
						cont++;
					}
					
				}
				
				
				
				
				
				
				if(Njugadores==cont) {
					JOptionPane.showMessageDialog(MarcoSleccionRoles.this, "Terminada la seleccion.", "Titulo", 3);
					rolC=true;
				}else if(Njugadores>cont) {
					
					
//----------------------------------------Comprobar si está el rol de aldeano--------------------------------------------------------------------------------------------------------------
							
							
							
			    			for(int j=0; j<cont;j++) {
			    				
								if(rolesSeleccionados[j].equalsIgnoreCase("aldeano")) {
									cantAldeanos = 1 + (Njugadores-(cont));
									JOptionPane.showMessageDialog(MarcoSleccionRoles.this, "El numero de Aldeanos es: "+ cantAldeanos, "Titulo", 3);
									rolC=true;	
									
								}
								
			    			}
								
							if(cantAldeanos!=0) {
			    				
			    				for(int h=cont ; h<Njugadores; h++) {
										rolesSeleccionados[h]="Aldeano";
										cont++;
								}
			    				
			    				
//------------------------------------------------------------------COMPROBAR QUE NO HAYA MENOS ROLES QUE JUGADORES------------------------------------------------------------------------------------			    				
			    				
			    			}else {
									
									for(JCheckBox y: contenedor) {
										
										if(y.isSelected()) {
											y.setSelected(false);
										}
									}
									
									//----------Se devuelve el contador a la cantidad de lobos para que se reinicie----------------------------------------------
									
									cont= cantLobos;
									rolC=false;
									
									//----------Se vacia el String para no causar problemas----------------------------------------------
									
									for(int h=cont ; h<Njugadores; h++) {
										rolesSeleccionados[h]="";
									}
									JOptionPane.showMessageDialog(MarcoSleccionRoles.this, "El numero de roles seleccionados es inferior al numero de jugadores.", "Error", 3);
								}
			    			
					
				}
				
				}
				
		
				
				for(String l: rolesSeleccionados) {
					System.out.println(l);
				}
				
				
					
				
				
				
				if(rolC) {
					
					almacenRoles.setAlmacen(rolesSeleccionados);
					
					enviar.envioInformacion(almacenRoles);
					
					terminadaSeleccion=true;
					//System.exit(0);
					dispose();
				}
				
					
					
				
				
				
				
				
				
				
			}
			
		});
		
		
		zonaBTN.add(btn);
		
		setVisible(true);
	}
	
	
	
	public Boolean getTerminadaSeleccion() {
		return terminadaSeleccion;
	}
	public void setTerminadaSeleccion(Boolean terminadaSeleccion) {
		this.terminadaSeleccion = terminadaSeleccion;
	}


	public String[] getRolesSeleccionados() {
		return rolesSeleccionados;
	}

	public void setRolesSeleccionados(String[] rolesSeleccionados) {
		this.rolesSeleccionados = rolesSeleccionados;
	}
		
		
		
		
		
}
