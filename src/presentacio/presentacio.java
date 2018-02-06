package presentacio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import aplicacio.*;


public class presentacio {
	// Classe que conté el main, a imprimir
	public static void main (String args[])throws IOException{
		// Inici. Booleà que servirà per controlar si l'usuari no vol jugar més partides:
		boolean continua = true;
		
		// L'usuari podrà escollir seguir jugant un cop acabi la partida:
		while (continua){
			
			// El Taulell es crearà una sola vegada per partida. Creem-lo:
			estat taulellDeJoc = new estat();
			
			// Cridem al text inicial. No l'incloem directament aquí per no saturar el main de text:
			System.out.println(textInicial());
			
			// Cos del joc; fins que l'usuari explícitament no surti, se seguiran reben entrades de tirades:
			boolean partidaAbortada = false;
			while (!partidaAbortada){
				System.out.println(taulellDeJoc);
				boolean valorsPerSeguir = false;
				while (!valorsPerSeguir){
					System.out.println("Quina fitxa vols moure (entra el seu número de casella) o bé -1 per sortir:");
					
					// Demanem a l'usuari el moviment que desitja realitzar:
					int fitxaSeleccionada = demanaNombre();
					valorsPerSeguir = true;
					
					// Contemplem l'opció que l'usuari hagi indicat la finalització de la partida:
					if (fitxaSeleccionada == -1){
						partidaAbortada = true;
						
					} else {
						System.out.println("A quina casella la vols moure?");
						int fitxaDesti = demanaNombre();
						
						//'try-catch' per recollir l'excepció en cas que l'usuari introdueix una dada invàlida:
						try {
							taulellDeJoc.mouCasella(fitxaSeleccionada, fitxaDesti);//int i = 0;
						} catch(IllegalArgumentException e){ // Només es llencen errors de tipus IllegalArgumentException
							System.out.println(e.getMessage()); // 'getMessage()' per mostrar el missatge de l'excepció
							valorsPerSeguir = false;
							System.out.println("\n" + taulellDeJoc);
						}
					}
				}	
			}
			
			// Si l'usuari ha jugat una bona partida, es mostra el missatge corresponent; sinó, 'Fi joc.':
			if (taulellDeJoc.getCasellesRestants() <= 10){
				if (taulellDeJoc.getCasellesRestants() < 5){
					if (taulellDeJoc.getCasellesRestants() == 1){
						System.out.println("Fi joc. Ets un crac.");
					} else System.out.println("Fi joc. Excel·lent.");
				} else System.out.println("Fi joc. Força bé.");
			} else System.out.println("Fi joc.");
			
			
			// Pregunta a l'usuari si desitja jugar una altra partida:
			System.out.println("Vols jugar una altra partida? (s/n)");
			BufferedReader final_br = new BufferedReader(new InputStreamReader(System.in));
			String resposta = final_br.readLine();
			
			// Detectem tant minúscules com majúscules per facilitar l'usabilitat:
			while (!resposta.equals("s") && !resposta.equals("n") && !resposta.equals("S") && !resposta.equals("N")){
				System.out.println("Siusplau, respon 's' o 'n'; vols jugar una altra partida?");
				resposta = final_br.readLine();
			}
			if (resposta.equals("n") || resposta.equals("N")){
				System.out.println("Gràcies per haver jugat!");
				continua = false; // S'acaba el joc definitivament
			}
			// No és necessari incloure la condició positiva, donat que 'continua' està en true per defecte
		}
	}
	
	// Senzillament mostra el text d'inici de cada partida:
	public static String textInicial(){
		return "******** Joc del SENKU ********\n"
				+ "Es tracta d'eliminar totes les fitxes 'X' del taulell menys una.\n"
				+ "Per fer-ho qualsevol fitxa pot saltar una altra fitxa i col·locar/-se a una posició buida.\n"
				+ "La fitxa saltada s'elimina del taulell.\n"
				+ "Els moviments només poden ser horitzontals o verticals, mai diagonals.\n";
	}
	
	// Mètode a cridar quan se sol·licita la fitxa a moure i la casella destí:
	public static int demanaNombre(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Comprovem que l'usuari sempre introdueixi un nombre enter:
		boolean enter = false;
		
		// Forcem la inicialització del nombre que rebrem de l'usuari
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