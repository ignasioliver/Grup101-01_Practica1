package aplicacio;

import domini.joc;

public class estat {
	
	// En aquesta classe es crea el taulell i es criden a les funcions de la classe joc
	private joc taulell = new joc();
	
	public estat(){
<<<<<<< HEAD
		taulell.creaTaulell(); /**aquest obligatoriament s'ha de executar*/
		taulell.initComponents(); /**aixo s'ha de modficar perque sigui l'usuari qui ho deicidixi*/
=======
		taulell.creaTaulell();
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
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
<<<<<<< HEAD
		
=======
	
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
}
