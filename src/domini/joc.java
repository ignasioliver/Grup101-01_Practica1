package domini;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class joc {
	private  List<casella> taulell;
	private int casellesEliminades,casellesRestants; // Atributs per portar la comptabilitat de les fitxes
	
	public joc(){
		casellesEliminades = 0;
		casellesRestants = 29; // La casella central esta buida per tant es una fitxa menys
		taulell = new ArrayList<casella>();
	}
	
	public int getCasellesEliminades(){
		return casellesEliminades;
	}
	
	public int getCasellesRestants(){
		return casellesRestants;
	}
	
	public void creaTaulell(){
		int comptador = 0; //variable per poder numerar la fitxa
		for(int f = 0; f < 7; f++){
			for(int c = 0; c < 7; c++){
				if(comptador == 16){  //la casella central esta buida 
					taulell.add(new casella(17,false,f,c));
					comptador = 17;
					
				}
				else if(posicio.posicioIncorrecte(f, c) == false){
					comptador++;
					taulell.add(new casella(comptador,true,f,c));
				}
				
			}
		
		}
		
		//la casella central esta buida
	} 
	
	//metode que retorna la posicio x d'una casella
	public int getFilaCasella(int numCasella){
		//utilitzem iterador per recorre la llista
		Iterator <casella> it = taulell.iterator();
		casella aux = null;
		
		while(it.hasNext()){
			aux = it.next();
			if(aux.NumeroCasella() == numCasella){
				return aux.getPos().getFila();
			}
		}
		return 0;
	}
	
	
	// Metode que retorna la posicio y d'una casella
	public int getColumnaCasella(int numCasella){
		Iterator <casella> it = taulell.iterator();
		casella aux = null;
		
		while(it.hasNext()){
			aux = it.next();
			if(aux.NumeroCasella() == numCasella){
				return aux.getPos().getColumna();
			}
		}
		
		return 0;
	}
	
	
	// Metode que retorna el numero de la casella a partir de la columna i fila on se situa
	// Ai retorna null, vol dir que la fila i la columna introduides no correspon a cap
	public casella getNumCasella(int fila, int columna){
		
		// Si l'usuari introdueix un numero negatiu directament no es fa la cerca
		if(fila < 0 || columna < 0){
			return null;
		}
		
		Iterator <casella> it = taulell.iterator();
		casella aux = null;
		
		while(it.hasNext()){
			aux = it.next();
			if(aux.getPos().getFila() == fila && aux.getPos().getColumna() == columna){
				return aux;
			}
		}
		
		return null;
	}
	
	/*El metode s'encarrega de comprovar que les dades de l'usuari siguin correctes
	aquest metode realitza els moviments de fitxes o llen�a una excepcio si no ho pot fer
	*/
	public void comprovaCaselles(int casellaSeleccionada, int casellaDesti) throws IllegalArgumentException {
		if (casellaSeleccionada == casellaDesti) {
			throw new IllegalArgumentException("Atenció, la casella d'inici i la de destí no poden ser les mateixes.");
		}
		if (casellaSeleccionada < 1 || casellaSeleccionada > 33) {
			throw new IllegalArgumentException("Atenció, has seleccionat la casella incial incorrectament.");
		}
		if (casellaDesti < 1 || casellaDesti > 33) {
			throw new IllegalArgumentException("Atenció, has seleccionat la casella de destí incorrectament.");
		}

		// Comprovem que la casella a la que es vol saltar estigui buida i la seleccionada que no ho estigui
		if(taulell.get(casellaSeleccionada - 1).Ocupada() == false){
			throw new IllegalArgumentException("Atenció, no has seleccionat cap fitxa. ");
		}

		if (taulell.get(casellaDesti - 1).Ocupada()) {
			throw new IllegalArgumentException(
					"Atenció, la casella de desti no es buida, per tant no es pot realitzar el moviment. ");
		} 
		
		//Un cop hem realitzat les comprovacions basiques pasem a realitzar les mes curoses
		posicio cSeleccionada, cDesti; // Treballem amb l'objecte posicio que facilita la feina
		cSeleccionada = taulell.get(casellaSeleccionada -1).getPos();
		cDesti = taulell.get(casellaDesti - 1).getPos();
		
		eliminaFitxaEntremig(cSeleccionada, cDesti);
		
		//si el metode anterior no dispara excepcions vol dir que s'ha eliminat una fitxa i hem d'actualitar el marcador
		casellesEliminades++;
		casellesRestants--;
		
	 } 
	
	//aquest metode s'encarrega de comprovar que les fitxes seleccionades estan ben seleccionades
	//i tambe realitza el moviment de fitxes i les elimines
	
	private void eliminaFitxaEntremig(posicio seleccionada, posicio desti) {
		if (seleccionada.getFila() == desti.getFila()) {
			// es troben a la mateixa fila
			int pos = seleccionada.getColumna() - desti.getColumna();

			if (Math.abs(pos) != 2) { // Diferencia de 2 perque es tracti d'un salt
				throw new IllegalArgumentException(
						"Atenció, la fitxa de destí seleccionada no es troba dins dels posibles moviments. ");
			}

			if (pos < 0) { //esta a la part esquerra de la casella seleccionada
				if(this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna() +1).Ocupada()){
					this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna() + 1).setOcupada(false); //eliminem la fitxa que hi ha entremig
					this.getNumCasella(desti.getFila(), desti.getColumna()).setOcupada(true); //coloquem la nova fitxa a la posicio de desti
					this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna()).setOcupada(false);//eliminem la fitxa de la posicio inicial
				}else{
					throw new IllegalArgumentException("Atenció, no es pot realitzar el salt perque no es pot saltar cap fitxa. ");
				
				}
			}else if (this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna() -1).Ocupada()){
					this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna() -1 ).setOcupada(false);
					this.getNumCasella(desti.getFila(), desti.getColumna()).setOcupada(true);
					this.getNumCasella(seleccionada.getFila(),seleccionada.getColumna()).setOcupada(false);
			}else{
					throw new IllegalArgumentException(""
							+ "Atenció, no es pot realitzar el salt perque no es pot saltar cap fitxa. ");
			}
		} else if (seleccionada.getColumna() == desti.getColumna()) {
			// es troben a la mateixa columna
			int pos = seleccionada.getFila() - desti.getFila();
				if (Math.abs(pos) != 2) {
					throw new IllegalArgumentException(
								"Atenció, la fitxa de desti seleccionada no es troba dins dels posibles moviments. ");
				}
				if (pos < 0) {
					if(this.getNumCasella(seleccionada.getFila() + 1, seleccionada.getColumna()).Ocupada()){
						this.getNumCasella(seleccionada.getFila() + 1, seleccionada.getColumna()).setOcupada(false);
						this.getNumCasella(desti.getFila(), desti.getColumna()).setOcupada(true);
						this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna()).setOcupada(false);
					}else{
						throw new IllegalArgumentException("Atenció, no es pot realitzar el salt sobre una casella buida.");
					}

				} else if(this.getNumCasella(seleccionada.getFila() - 1, seleccionada.getColumna()).Ocupada()){
					this.getNumCasella(seleccionada.getFila() - 1, seleccionada.getColumna()).setOcupada(false);
					this.getNumCasella(desti.getFila(), desti.getColumna()).setOcupada(true);
					this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna()).setOcupada(false);
				}else{
				
				}
			}
			
		else{
				throw new IllegalArgumentException("Atenció, la fitxa seleccionada no es troba dins dels movmients posibles");
		 }
	}
			
	
	// Metode redefinit per mostrar per pantalla el taulell
	public String toString() {
		String ret = "";
		int comptador = 0; //per poder fer els get corresponent a la llista
		
		for (int f = 0; f < 7; f++){
			for (int c = 0; c < 7; c++){
				if(posicio.posicioIncorrecte(f, c) == true){
					//mostrar espais
					ret +="    ";
				}else{
					//aixo vol dir que hi ha una figura
				    if(taulell.get(comptador).Ocupada()){
				     //mostrem la fitxa que hi ha la casella
				    	if(comptador>8){
				    	 ret += taulell.get(comptador).NumeroCasella() + "X ";
				    	}else{
				    		ret +=" "+taulell.get(comptador).NumeroCasella() + "X ";
				    	}
				    }else{
				    	//la casella no conte cap fitxa
				    	if(comptador>8){
					    	 ret += taulell.get(comptador).NumeroCasella() + "  ";
					    	}else{
					    		ret +=" "+taulell.get(comptador).NumeroCasella() + "  ";
					    	}
				    }
				    
				    comptador++; //pugem el comptador perque hem accedit a la casella
				}
			}	
			ret += "\n";
		}
		return ret;
	}
}
