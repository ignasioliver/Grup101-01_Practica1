package senku;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Taulell {
	
	// Classe que conté el main, a imprimir
	public static void main (String args[])throws IOException{
		// Inici. Booleà que servirà per controlar si l'usuari no vol jugar més partides:
		boolean continua = true;
		
		// L'usuari podrà escollir seguir jugant un cop acabi la partida:
		while (continua){
			
			// El Taulell es crearà una sola vegada per partida. Creem-lo:
			Taulell taulellDeJoc = new Taulell();
			
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
							taulellDeJoc.mouFitxa(fitxaSeleccionada, fitxaDesti);
						} catch(IllegalArgumentException e){ // Només es llencen errors de tipus IllegalArgumentException
							System.out.println(e.getMessage()); // 'getMessage()' per mostrar el missatge de l'excepció
							valorsPerSeguir = false;
							System.out.println("\n" + taulellDeJoc);
						}
					}
				}	
			}
			
			// Si l'usuari ha jugat una bona partida, es mostra el missatge corresponent; sinó, 'Fi joc.':
			if (taulellDeJoc.getFitxesRestants() <= 10){
				if (taulellDeJoc.getFitxesRestants() < 5){
					if (taulellDeJoc.getFitxesRestants() == 1){
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

	// Atributs de l'objecte Taula:
	private Fitxa taulell[][];
	private int fitxesEliminades, fitxesRestants;

	public Taulell() {
		taulell = iniciaTaulell();
		
		// La casella del centre a l'inici ha d'estar buida:
		taulell[3][3].eliminaFitxa();
		fitxesEliminades = 0;
		fitxesRestants = 32;

	}

	public int getFitxesEliminades() {
		return fitxesEliminades;
	}

	public int getFitxesRestants() {
		return fitxesRestants;
	}

	// Mètode que omple els valors del Taulell:
	private Fitxa[][] iniciaTaulell() {
		
		// S'ha de considerar que hi han caselles de la matriu que no formen part del taulell.
		// Per evitar problemes, no fem ús d'iteradors al crear-la:
		Fitxa taula[][] = { { null, null, new Fitxa(1), new Fitxa(2), new Fitxa(3), null, null },
				{ null, null, new Fitxa(4), new Fitxa(5), new Fitxa(6), null, null },
				{ new Fitxa(7), new Fitxa(8), new Fitxa(9), new Fitxa(10), new Fitxa(11), new Fitxa(12),
						new Fitxa(13) },
				{ new Fitxa(14), new Fitxa(15), new Fitxa(16), new Fitxa(17), new Fitxa(18), new Fitxa(19),
						new Fitxa(20) },
				{ new Fitxa(21), new Fitxa(22), new Fitxa(23), new Fitxa(24), new Fitxa(25), new Fitxa(26),
						new Fitxa(27) },
				{ null, null, new Fitxa(28), new Fitxa(29), new Fitxa(30), null, null },
				{ null, null, new Fitxa(31), new Fitxa(32), new Fitxa(33), null, null } };
		return taula;
	}

	// Mètode al que s'accedeix per moure la fitxa que també l'eliminarà:
	public void mouFitxa(int fitxaSeleccionada, int fitxaDesti) throws IllegalArgumentException {
			comprovaCaselles(fitxaSeleccionada, fitxaDesti); //cridem al mètode que s'encarrega del procés
	}

	// Mètode privat que comprova que les caselles introduïdes per l'usuari siguin les correctes i de pas elimina les fitxes:
	private void comprovaCaselles(int casellaSeleccionada, int casellaDesti) throws IllegalArgumentException {
		if (casellaSeleccionada == casellaDesti) {
			throw new IllegalArgumentException("Atenció, la casella d'inici i la de destí no poden ser les mateixes.");
		}
		if (casellaSeleccionada < 1 || casellaSeleccionada > 33) {
			throw new IllegalArgumentException("Atenció, has seleccionat la casella incial incorrectament.");
		}
		if (casellaDesti < 1 || casellaDesti > 33) {
			throw new IllegalArgumentException("Atenció, has seleccionat la casella de destí incorrectament.");
		}

		// Comprovem que la casella a la que es vol saltar estigui buida i la seleccionada que no ho estigui:
		if(taulell[getFilaFitxa(casellaSeleccionada)][getColumnaFitxa(casellaSeleccionada)].getEliminada()){
			throw new IllegalArgumentException("Atenció, no has seleccionat cap fitxa. ");
		}

		if (!taulell[getFilaFitxa(casellaDesti)][getColumnaFitxa(casellaDesti)].getEliminada()) {
			throw new IllegalArgumentException(
					"Atenció, la casella de desti no és buida, per tant no es pot realitzar el moviment. ");
		} else {
			
			// Un cop fetes les comprovacions pasem a eliminar la fitxa
			eliminaFitxaEntremig(getFilaFitxa(casellaSeleccionada), getColumnaFitxa(casellaSeleccionada),
					getFilaFitxa(casellaDesti), getColumnaFitxa(casellaDesti));

			//Si no salta cap excepció significa que s'ha eliminat correctament la fitxa i podem actualitzar els comptadors:
			fitxesEliminades++;
			fitxesRestants--;
		}
	}

	// Aquest mètode s'encarrega principalment d'eliminar la fitxa:
	private void eliminaFitxaEntremig(int filSeleccionada, int colSeleccionada, int filDesti, int colDesti) {
		if (filSeleccionada == filDesti) {
			
			// Si es troben a la mateixa fila:
			int pos = colSeleccionada - colDesti;

			if (Math.abs(pos) != 2) { // Diferència de 2 perquè es tracti d'un salt
				throw new IllegalArgumentException(
						"Atenció, la fitxa de destí seleccionada no es troba dins dels posibles moviments. ");
			}

			if (pos < 0) { 
				
				// Si està a la part esquerra de la casella seleccionada:
				if (!taulell[filSeleccionada][colSeleccionada + 1].getEliminada()) {
					taulell[filSeleccionada][colSeleccionada + 1].eliminaFitxa(); // Eliminem la fitxa que hi ha entremig
					taulell[filDesti][colDesti].reviuFitxa(); // Coloquem la nova fitxa a la posicio de desti
					taulell[filSeleccionada][colSeleccionada].eliminaFitxa(); //Eliminem de la posicio inicial la fitxa
				} else {
					throw new IllegalArgumentException(
							"Atenció, no es pot realitzar el salt perquè no es pot saltar cap fitxa. ");
				}

			} else if (!taulell[filSeleccionada][colSeleccionada - 1].getEliminada()) {
				
				// Si està a la part dreta de la casella seleccionada:
				taulell[filSeleccionada][colSeleccionada - 1].eliminaFitxa();
				taulell[filDesti][colDesti].reviuFitxa();
				taulell[filSeleccionada][colSeleccionada].eliminaFitxa();
			} else {
				throw new IllegalArgumentException(
						"Atenció, no es pot realitzar el salt perquè no es pot saltar cap fitxa. ");
			}

		} else if (colSeleccionada == colDesti) {
			
			// Si es troben a la mateixa columna:
			int pos = filSeleccionada - filDesti;
			if (Math.abs(pos) != 2) {
				throw new IllegalArgumentException(
						"Atencio, la fitxa de destí seleccionada no es troba dins dels posibles moviments. ");
			}
			if (pos < 0) {
				if (!taulell[filSeleccionada + 1][colSeleccionada].getEliminada()) { // Si està per sobre de la casella seleccionada
					taulell[filSeleccionada + 1][colSeleccionada].eliminaFitxa();
					taulell[filDesti][colDesti].reviuFitxa();
					taulell[filSeleccionada][colSeleccionada].eliminaFitxa();
				} else {
					throw new IllegalArgumentException(
							"Atenció, no es pot realitzar el salt perque no es pot saltar cap fitxa. ");
				}

			} else if (!taulell[filSeleccionada - 1][colSeleccionada].getEliminada()) { // Si està per sota de la casella seleccionada
					taulell[filSeleccionada - 1][colSeleccionada].eliminaFitxa();
					taulell[filDesti][colDesti].reviuFitxa();
					taulell[filSeleccionada][colSeleccionada].eliminaFitxa();
				}else {
					throw new IllegalArgumentException(
							"Atenció, no es pot realitzar el salt perquè no es pot saltar cap fitxa. ");
				}
		} else {
			
			// Si no està a la mateixa columna/fila, vol dir que la casella ha estat seleccionada incorrectament:
			throw new IllegalArgumentException(
					"Atenció, la fitxa seleccionada no es troba dins dels moviments posibles.");
		}
	}

	private int getColumnaFitxa(int casella) {
		for (int f = 0; f < 7; f++) {
			for (int c = 0; c < 7; c++) {
				if (taulell[f][c] != null && taulell[f][c].getPosicio() == casella) {
					return c;
				}
			}
		}
		
		// Si retorna un -1 significa que la casella seleccionada és incorrecta:
		return -1; 
	}

	private int getFilaFitxa(int casella) {
		for (int f = 0; f < 7; f++) {
			for (int c = 0; c < 7; c++) {
				if (taulell[f][c] != null && taulell[f][c].getPosicio() == casella) {
					return f;
				}
			}
		}
		return -1; // La casella seleccionada és incorrecta
	}

	public String toString() {
		String visual = "";
		for (int f = 0; f < 7; f++) {
			for (int c = 0; c < 7; c++) {
				if (taulell[f][c] != null) {
					visual = visual + " " + taulell[f][c].toString();
				} else {
					visual += "     "; // Casella que no forma part del taulell
				}
			}
			visual += "\n";
		}
		return visual;
	}
}
