package domini;

<<<<<<< HEAD
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;

=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
public class casella {
	
	// Atributs de la clase casella
	private boolean ocupada;
	private int numeroCasella;
	private posicio pos;
<<<<<<< HEAD
	private JButton casellaGrafica; //necessaria en cas que l'usuari vulgui jugar de forma grafica
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
	
	// Constructor de casella
	public casella(int nC, boolean oc,int fila, int columna){
		numeroCasella = nC;
		ocupada = oc; //La casella central no esta ocupada
		pos = new posicio(fila,columna); 
<<<<<<< HEAD
		casellaGrafica = null; //aquest boto el crearem si l'usuari decideix jugar de forma grafica
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
	}
	
	
	// Metodes de la clase casella, a partir de l'objecte podem saber la pos de la casella
	public posicio getPos(){
		return pos;
	}
	
	public int NumeroCasella(){
		return numeroCasella;
	}
	
	public boolean Ocupada(){
		return ocupada;
	}
	
	public void setOcupada(boolean par){
		ocupada = par;
	}
<<<<<<< HEAD
	
	//per poder obtenir la part "grafica" de la casella
	public void setButton(boolean ocupada){
		casellaGrafica = new JButton();
		casellaGrafica.setBackground(new Color(122,138,153));
		if(ocupada){
			casellaGrafica.setIcon(new ImageIcon("noEliminado.png"));
		}else{
			casellaGrafica.setIcon(new ImageIcon("eliminado.png"));
		}
		
		//aixo es perque nom�s aparegi la imatge que t� d'icona el JButton
		casellaGrafica.setOpaque(true);
		casellaGrafica.setBorder(null);
		
		Color c = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
		casellaGrafica.setBackground(new Color(c.getRed(), c.getGreen(), c.getBlue()));
	}
	
	public JButton getButton(){
		return casellaGrafica;
	}
	
	
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
}
