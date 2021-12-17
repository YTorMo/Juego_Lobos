package Cliente;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelDeRol extends JPanel {
	
	 private File ruta;
	 private Image imagen;
	 private String Nusuario,rol;
	
	public PanelDeRol (String Nusuario, String rol){

		
        ruta=new File("F:/Proyecto_Java/Juego_Lobos/src/ESTADOS/" + rol.toLowerCase() + ".png");
        setBackground(new Color(255,255,255,0));
        this.Nusuario=Nusuario;
        if(rol.equalsIgnoreCase("Niño_Salvaje")) {
        	this.rol="Niño Salvaje";
        }else {
        	this.rol=rol;
        }
        
        //DISPOSICION DE LOS ELEMENTOS DENTRO DE LA LAMINA COMO FLOWLAYOUT
        setLayout(new FlowLayout(FlowLayout.RIGHT));

        //AÑADIR LA IMAGEN
        try{
            imagen=ImageIO.read(ruta);
        }catch(IOException e){
        	JOptionPane.showMessageDialog(getRootPane(), "La imagen no se encuentra en el directorio: F:/Proyecto_Java/Juego_Lobos/src/ESTADOS/" );
            System.out.println("La imagen no se encuentra en el directorio: F:/Proyecto_Java/Juego_Lobos/src/ESTADOS/");
        }
        
    }
	
	protected void paintComponent(Graphics g){
        super.paintComponent(g);

        //IMAGENES
        Graphics2D g2=(Graphics2D) g;
        if(imagen==null) {
        	g2.drawString("No se encuentra la imagen.",10,10);
        }else {
        	int anchura_img= imagen.getWidth(this);
        	int altura_img= imagen.getHeight(this);
        	Image escalada= imagen.getScaledInstance(anchura_img/4, altura_img/4, Image.SCALE_DEFAULT);
        	g.drawImage(escalada, 20, 20, null);
        	Font fuente1= new Font ("Arial", Font.BOLD, 18);

        	g2.setFont(fuente1);
        	g2.setColor(new Color(45,45,45));
        	g2.drawString("Rol: " + rol , 20 , escalada.getHeight(this)+45);
        	g2.drawString("Nick: " + Nusuario, 20 , escalada.getHeight(this)+70);

        }
	}
	

}
