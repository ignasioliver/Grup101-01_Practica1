package domini;

public class casella {
	
	// Atributs de la clase casella
	private boolean ocupada;
	private int numeroCasella;
	private posicio pos;
	
	// Constructor de casella
	public casella(int nC, boolean oc,int fila, int columna){
		numeroCasella = nC;
		ocupada = oc; //La casella central no esta ocupada
		pos = new posicio(fila,columna); 
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
}
