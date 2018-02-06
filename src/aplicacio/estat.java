package aplicacio;

import domini.joc;

public class estat {
	
	// En aquesta classe es crea el taulell i es criden a les funcions de la classe joc
	private joc taulell = new joc();
	
	public estat(){
		taulell.creaTaulell();
	}
	
	public String toString(){
		return taulell.toString();
	}
	
	public void mouCasella(int seleccionada, int desti) throws IllegalArgumentException{
		taulell.comprovaCaselles(seleccionada, desti);
	}
	

	public int getCasellesEliminades(){
		return taulell.getCasellesEliminades();
	}
	
	public int getCasellesRestants(){
		return taulell.getCasellesRestants();
	}
	
}
