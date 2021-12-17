package Cliente;

import javax.swing.JPanel;

import PaquetesDeDatos.Jugador;

import java.awt.Color;

import javax.swing.JLabel;

public class contenedorEstados extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	public contenedorEstados(Jugador estados) {
		setBackground(new Color(255,255,255,0));
		setLayout(null);
		
		JLabel tituloEstados = new JLabel("Estados:");
		tituloEstados.setBounds(40, 23, 63, 14);
		tituloEstados.setBackground(new Color(45,45,45));
		add(tituloEstados);
		
		
		//---Enamorados-----
		
		
		if(estados.getEnamorado().equalsIgnoreCase("enamorado")) {
			
			Estados_Cliente estado2= new Estados_Cliente("enamorado");
			estado2.setBounds(40, 48, 30, 30);
			add(estado2);
			estado2.setVisible(true);
			
		}else if(estados.getEnamorado().equalsIgnoreCase("infiel")){
			
			Estados_Cliente estado2= new Estados_Cliente("infiel");
			estado2.setBounds(40, 48, 30, 30);
			add(estado2);
			estado2.setVisible(true);
			
		}else if(estados.getEnamorado().equalsIgnoreCase("amante")){
			
			Estados_Cliente estado2= new Estados_Cliente("amante");
			estado2.setBounds(40, 48, 30, 30);
			add(estado2);
			estado2.setVisible(true);
			
		}else{
			
			Estados_Cliente estado2= new Estados_Cliente("estado_vacio");
			estado2.setBounds(40, 48, 30, 30);
			add(estado2);
			estado2.setVisible(true);
			
		}
		
		
		//----Convertidos------
		
		
		if(estados.getConvertido().equalsIgnoreCase("convertido")) {
			
			Estados_Cliente estado3= new Estados_Cliente("convertido");
			estado3.setBounds(80, 48, 30, 30);
			add(estado3);
			estado3.setVisible(true);
			
		}else if(estados.getConvertido().equalsIgnoreCase("aliado_de_los_lobos")){
			
			Estados_Cliente estado3= new Estados_Cliente("aliado_de_los_lobos");
			estado3.setBounds(80, 48, 30, 30);
			add(estado3);
			estado3.setVisible(true);
			
		}else{
			
			Estados_Cliente estado3= new Estados_Cliente("estado_vacio");
			estado3.setBounds(80, 48, 30, 30);
			add(estado3);
			estado3.setVisible(true);
			
		}
		
		
		//-----Espiritista----------
		
		
		if(estados.getEspiritista()) {
			
			Estados_Cliente estado1= new Estados_Cliente("espiritista");
			estado1.setBounds(40, 89, 30, 30);
			add(estado1);
			estado1.setVisible(true);
			
		}else {
			
			Estados_Cliente estado1= new Estados_Cliente("estado_vacio");
			estado1.setBounds(40, 89, 30, 30);
			add(estado1);
			estado1.setVisible(true);
			
		}
		
		
		//-----Seguidor-----------
		
		
		if(estados.getSeguidor()) {
			
			Estados_Cliente estado4= new Estados_Cliente("seguidor_del_sectario");
			estado4.setBounds(80, 89, 30, 30);
			add(estado4);
			estado4.setVisible(true);
			
		}else {
			
			Estados_Cliente estado4= new Estados_Cliente("estado_vacio");
			estado4.setBounds(80, 89, 30, 30);
			add(estado4);
			estado4.setVisible(true);
			
		}
		
		
		//---------Protegido-------------
		
		
		if(estados.getProtegido()) {
			
			Estados_Cliente estado5= new Estados_Cliente("protegido");
			estado5.setBounds(40, 130, 30, 30);
			add(estado5);
			estado5.setVisible(true);
			
		}else {
			
			Estados_Cliente estado5= new Estados_Cliente("estado_vacio");
			estado5.setBounds(40, 130, 30, 30);
			add(estado5);
			estado5.setVisible(true);
			
		}
		
		
		//-----------Hechizado----------------
		
		
		if(estados.getHechizado()) {
			
			Estados_Cliente estado6= new Estados_Cliente("hechizado");
			estado6.setBounds(80, 130, 30, 30);
			add(estado6);
			estado6.setVisible(true);
			
		}else {
			
			Estados_Cliente estado6= new Estados_Cliente("estado_vacio");
			estado6.setBounds(80, 130, 30, 30);
			add(estado6);
			estado6.setVisible(true);
			
		}
		
	}

}