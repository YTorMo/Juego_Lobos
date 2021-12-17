package Cliente;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class temporizador extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private int segsAux;
	private String segs;
	private Timer tiempoTurno;
	private Graphics tiempoenPantalla;
	
	public temporizador() {
		setBackground(new Color(150,0,0,0));
		setLayout(null);
		
		segs="100";
		
		
		JLabel tituloTemp = new JLabel("Tiempo restante hasta");
		tituloTemp.setForeground(new Color(45,45,45));
		tituloTemp.setBackground(new Color(45,45,45));
		tituloTemp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tituloTemp.setHorizontalAlignment(SwingConstants.CENTER);
		tituloTemp.setBounds(0, 0, 157, 26);
		add(tituloTemp);
		
		
		JLabel tituloTemp2 = new JLabel("el proximo turno:");
		tituloTemp2.setForeground(new Color(45,45,45));
		tituloTemp2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tituloTemp2.setHorizontalAlignment(SwingConstants.CENTER);
		tituloTemp2.setBounds(0, 23, 157, 26);
		add(tituloTemp2);
		
		tiempoenPantalla.drawString("caca",20,100);
		this.paintComponent(tiempoenPantalla);
		
		
		

	}
	
		
	
	/*protected void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Graphics2D g2=(Graphics2D) g;
		Font fuente1= new Font ("Arial", Font.BOLD, 14);
		int posV=20;

		g2.setFont(fuente1);
		g2.setColor(new Color(45,45,45));
		g2.drawString("Hola k ase",20,100);

        tiempoTurno = new Timer(1000, null);
		tiempoTurno.start();
		tiempoTurno.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("kk");
				
				Graphics2D g2=(Graphics2D) g;
				Font fuente1= new Font ("Arial", Font.BOLD, 14);
				int posV=20;

				g2.setFont(fuente1);
				g2.setColor(new Color(45,45,45));
				g2.drawString("Hola k ase2",20,100);
				
				JLabel tiempo = new JLabel(segs);
				tiempo.setForeground(new Color(45,45,45));
				tiempo.setBackground(new Color(45,45,45));
				tiempo.setFont(new Font("Tahoma", Font.BOLD, 30));
				tiempo.setHorizontalAlignment(SwingConstants.CENTER);
				tiempo.setBounds(0, 90, 147, 87);
				add(tiempo);
				segsAux = Integer.parseInt(segs);
				segsAux--;
				segs = Integer.toString(segsAux);
				
			}
			
		});
        
    		
    }*/
	
}
