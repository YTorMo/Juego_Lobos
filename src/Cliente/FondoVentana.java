package Cliente;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.io.*;


public class FondoVentana extends JPanel{

	 private File ruta;
	 private Image imagen;
	
	public FondoVentana (){

		
        ruta=new File("F:/Proyecto_Java/Juego_Lobos/src/ESTADOS/lobo.png");
        setBackground(new Color(255,255,255));

        //AÑADIR LA IMAGEN
        try{
            imagen=ImageIO.read(ruta);
        }catch(IOException e){
        	JOptionPane.showMessageDialog(getRootPane(), "La imagen no se encuentra en el directorio: F:/Proyecto_Java/Juego_Lobos/src/ESTADOS/" );
            System.out.println("La imagen no se encuentra en el directorio: F:/Proyecto_Java/Juego_Lobos/src/ESTADOS/");
        }
    }
	
	public void paintComponent(Graphics g){
        super.paintComponent(g);

        if(imagen==null) {
        	g.drawString("No se encuentra la imagen.",10,10);
        }else {
        	g.drawImage(imagen, 20, 20, null);
        }
	}

}
