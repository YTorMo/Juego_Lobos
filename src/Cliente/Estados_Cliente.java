package Cliente;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Estados_Cliente extends JPanel {
	/**
	 * @wbp.nonvisual location=189,139
	 */
	
	private File ruta;
	private Image imagen;
	/**
	 * Create the panel.
	 */
	public Estados_Cliente(String tipoEstado) {
		
		
		ruta=new File("F:/Proyecto_Java/Juego_Lobos/src/Errores/ESTADOS_VERDAD/" + tipoEstado.toLowerCase() + ".png");
		
		
		setBackground(new Color(150,0,0,0));
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		try{
	        imagen=ImageIO.read(ruta);
	    }catch(IOException e){
	        JOptionPane.showMessageDialog(getRootPane(), "La imagen no se encuentra en el directorio: F:/Proyecto_Java/Juego_Lobos/src/Errores/ESTADOS_VERDAD/" );
	        System.out.println("La imagen no se encuentra en el directorio: F:/Proyecto_Java/Juego_Lobos/src/Errores/ESTADOS_VERDAD/");
	    }

	}


	protected void paintComponent(Graphics g){
        super.paintComponent(g);

        //IMAGENES
        Graphics2D g2=(Graphics2D) g;
        if(imagen==null) {
        	g2.drawString("No se encuentra la imagen.",1,1);
        }else {
        	int anchura_img= imagen.getWidth(this);
        	int altura_img= imagen.getHeight(this);
        	Image escalada= imagen.getScaledInstance(anchura_img/4, altura_img/4, Image.SCALE_DEFAULT);
        	g.drawImage(escalada,0,0, null);
        	
        }
	}

}
