package senku;

public class Fitxa {
	
	private int posicio;
	private boolean eliminada;
	
	
	public Fitxa (int posicio){
		this.posicio= posicio;
		this.eliminada=false;
	}
	
	public int getPosicio(){
		return this.posicio;	// Aquest mètode retorna la casella en la que es troba la fitxa
	}
	
	public boolean getEliminada(){
		return this.eliminada;	// Aquest mètode retorna un booleà que indica si la fitxa està eliminada
	}
	
	public void eliminaFitxa(){
		this.eliminada = true;
	}
	
	public void reviuFitxa(){
		this.eliminada = false;
	}
	
	public String toString(){
		
		// Condicions fetes per qüestió d'estètica a l'hora de mostrar per pantalla el taulell:
		if(this.posicio < 10){
			if(this.eliminada){
				return "0"+this.posicio+"  ";
			}else{
				return "0"+this.posicio+" X";
			}
		}else{
			if(this.eliminada){
				return this.posicio+"  ";
			}else{
				return this.posicio+" X";
			}
		}
	}
	
	public boolean equals (Object o){
		Fitxa f = (Fitxa) o;
		try{
			return this.posicio == f.posicio;
		}catch(ClassCastException e){ // Mai hauria de llencar excepció
			return false;
		}
	}
}

