package presentacio;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

<<<<<<< HEAD
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
import aplicacio.*;


public class presentacio {
	// Classe que cont� el main, a imprimir
	public static void main (String args[])throws IOException{
		// Inici. Boole� que servir� per controlar si l'usuari no vol jugar m�s partides:
		boolean continua = true;
		
		// L'usuari podr� escollir seguir jugant un cop acabi la partida:
		while (continua){
			
			// El Taulell es crear� una sola vegada per partida. Creem-lo:
<<<<<<< HEAD
			estat taulellDeJoc = new estat(); 
		
=======
			estat taulellDeJoc = new estat();
			
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
			// Cridem al text inicial. No l'incloem directament aqu� per no saturar el main de text:
			System.out.println(textInicial());
			
			// Cos del joc; fins que l'usuari expl�citament no surti, se seguiran reben entrades de tirades:
			boolean partidaAbortada = false;
			while (!partidaAbortada){
				System.out.println(taulellDeJoc);
				boolean valorsPerSeguir = false;
				while (!valorsPerSeguir){
					System.out.println("Quina fitxa vols moure (entra el seu n�mero de casella) o b� -1 per sortir:");
					
					// Demanem a l'usuari el moviment que desitja realitzar:
					int fitxaSeleccionada = demanaNombre();
					valorsPerSeguir = true;
					
					// Contemplem l'opci� que l'usuari hagi indicat la finalitzaci� de la partida:
					if (fitxaSeleccionada == -1){
						partidaAbortada = true;
						
					} else {
						System.out.println("A quina casella la vols moure?");
						int fitxaDesti = demanaNombre();
						
						//'try-catch' per recollir l'excepci� en cas que l'usuari introdueix una dada inv�lida:
						try {
							taulellDeJoc.mouCasella(fitxaSeleccionada, fitxaDesti);//int i = 0;
						} catch(IllegalArgumentException e){ // Nom�s es llencen errors de tipus IllegalArgumentException
							System.out.println(e.getMessage()); // 'getMessage()' per mostrar el missatge de l'excepci�
							valorsPerSeguir = false;
							System.out.println("\n" + taulellDeJoc);
						}
					}
				}	
			}
			
			// Si l'usuari ha jugat una bona partida, es mostra el missatge corresponent; sin�, 'Fi joc.':
			if (taulellDeJoc.getCasellesRestants() <= 10){
				if (taulellDeJoc.getCasellesRestants() < 5){
					if (taulellDeJoc.getCasellesRestants() == 1){
						System.out.println("Fi joc. Ets un crac.");
					} else System.out.println("Fi joc. Excel�lent.");
				} else System.out.println("Fi joc. For�a b�.");
			} else System.out.println("Fi joc.");
			
<<<<<<< HEAD
=======
			
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
			// Pregunta a l'usuari si desitja jugar una altra partida:
			System.out.println("Vols jugar una altra partida? (s/n)");
			BufferedReader final_br = new BufferedReader(new InputStreamReader(System.in));
			String resposta = final_br.readLine();
			
			// Detectem tant min�scules com maj�scules per facilitar l'usabilitat:
			while (!resposta.equals("s") && !resposta.equals("n") && !resposta.equals("S") && !resposta.equals("N")){
				System.out.println("Siusplau, respon 's' o 'n'; vols jugar una altra partida?");
				resposta = final_br.readLine();
			}
			if (resposta.equals("n") || resposta.equals("N")){
				System.out.println("Gr�cies per haver jugat!");
				continua = false; // S'acaba el joc definitivament
			}
			// No �s necessari incloure la condici� positiva, donat que 'continua' est� en true per defecte
		}
	}
	
	// Senzillament mostra el text d'inici de cada partida:
	public static String textInicial(){
		return "******** Joc del SENKU ********\n"
				+ "Es tracta d'eliminar totes les fitxes 'X' del taulell menys una.\n"
				+ "Per fer-ho qualsevol fitxa pot saltar una altra fitxa i col�locar/-se a una posici� buida.\n"
				+ "La fitxa saltada s'elimina del taulell.\n"
				+ "Els moviments nom�s poden ser horitzontals o verticals, mai diagonals.\n";
	}
	
	// M�tode a cridar quan se sol�licita la fitxa a moure i la casella dest�:
	public static int demanaNombre(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Comprovem que l'usuari sempre introdueixi un nombre enter:
		boolean enter = false;
		
		// Forcem la inicialitzaci� del nombre que rebrem de l'usuari
		int number = 0;
		while (!enter){
			try {
				String input = br.readLine();
				
				// Comprovem que l'entrada d'usuari es tracti d'un nombre enter:
		        number = Integer.parseInt(input);
		        enter = true;
		    } catch (IOException | NumberFormatException e) { // Capturem les dues possibles excepcions
		    	
		    	// L'usuari mai hauria de visualitzar l'error (e.printStackTrace();)
		        System.out.println("Siusplau introdueix un nombre enter: ");
		    }
		} return number;
	}
}