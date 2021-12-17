package Cliente;

import javax.swing.JPanel;

import PaquetesDeDatos.Jugador;

import java.awt.*;
import java.util.ArrayList;

public class listaJugadores extends JPanel {

	/**
	 * Create the panel.
	 */
	private String[] listaGenerada;
	
	public listaJugadores( ArrayList<Jugador> listado) { //Cambio4
		
		setBackground(new Color(255,255,255,0));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		listaGenerada = new String[listado.size()];
		int j=0;
		
		for(Jugador i: listado) {
			listaGenerada[j]= i.getNombre();
			j++;
		}

	}


	protected void paintComponent(Graphics g){
        super.paintComponent(g);


        Graphics2D g2=(Graphics2D) g;
        Font fuente1= new Font ("Arial", Font.BOLD, 14);
        int posV=20;

    	g2.setFont(fuente1);
    	g2.setColor(new Color(45,45,45));
    	g2.drawString("Lista de Jugadores:",20,posV);
    	posV+=15;
    	for(String z: listaGenerada) {
    		
    		posV+=20;
    		g2.setColor(new Color(0,65,0));
    		g2.drawString(z,20,posV);
    		
    	}
    	
	}
	
	

}
