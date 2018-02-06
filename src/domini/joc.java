package domini;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

<<<<<<< HEAD
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class joc extends JFrame{
	private  List<casella> taulell;
	private int casellesEliminades,casellesRestants; // Atributs per portar la comptabilitat de les fitxes
	private String missatgeFinal; //aquest fa referencia al missatge final que es mostrar en el frame
	
	/**experimental*/
	//private JFrame ; //aques sera el senku grafic
	
	//aquestes son les imatges utilitzades per representar la casella que NO ES PODEN TOCAR
	
	private static final ImageIcon [] imatges = {new ImageIcon("eliminado.png"),new ImageIcon("noEliminado.png"), new ImageIcon("mute.png"),
			new ImageIcon("sound.png"),new ImageIcon("porta.png")};
	
	
	/**aquesta casella auxiliar es per saber quina ha seleccionat l'usuari en el FRAME!!*/
	private static casella casellaSeleccionada = null;
	private static boolean usuariVolSoroll = true; //per saber si l'usuari vol interacció acústica,inicialment estara activat
	
=======
public class joc {
	private  List<casella> taulell;
	private int casellesEliminades,casellesRestants; // Atributs per portar la comptabilitat de les fitxes
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
	
	public joc(){
		casellesEliminades = 0;
		casellesRestants = 29; // La casella central esta buida per tant es una fitxa menys
		taulell = new ArrayList<casella>();
<<<<<<< HEAD
		missatgeFinal = null; //fins que no acaba la partida no es mostra el missatge
	}
	
	
	
=======
	}
	
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
	public int getCasellesEliminades(){
		return casellesEliminades;
	}
	
	public int getCasellesRestants(){
		return casellesRestants;
	}
	
<<<<<<< HEAD
	/**s'executa abans d'acabar per saber quin missatge mostrar a l'usuari*/
	public void setMissatgeFrame(){
		
	}
	
	public void creaTaulell(){ //aquest metode tambe afegeix al FRAME les figures
=======
	public void creaTaulell(){
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
		int comptador = 0; //variable per poder numerar la fitxa
		for(int f = 0; f < 7; f++){
			for(int c = 0; c < 7; c++){
				if(comptador == 16){  //la casella central esta buida 
<<<<<<< HEAD
					casella crea = new casella(17,false,f,c);
					taulell.add(crea);
					
=======
					taulell.add(new casella(17,false,f,c));
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
					comptador = 17;
					
				}
				else if(posicio.posicioIncorrecte(f, c) == false){
					comptador++;
					taulell.add(new casella(comptador,true,f,c));
				}
				
			}
		
		}
<<<<<<< HEAD
				
=======
		
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
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
	
<<<<<<< HEAD
	
	/*El metode s'encarrega de comprovar que les dades de l'usuari sin correctes
	aquest metode realitza els moviments de fitxes o llen�a una excepcio si no ho pot fer
	*/
	
	/**AQUEST METODE S'HA MODIFICAT PER PODER FER EL SENKU DE FORMA GRAFICA*/
	
	public casella comprovaCaselles(int casellaSeleccionada, int casellaDesti) throws IllegalArgumentException {
=======
	/*El metode s'encarrega de comprovar que les dades de l'usuari siguin correctes
	aquest metode realitza els moviments de fitxes o llen�a una excepcio si no ho pot fer
	*/
	public void comprovaCaselles(int casellaSeleccionada, int casellaDesti) throws IllegalArgumentException {
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
		if (casellaSeleccionada == casellaDesti) {
			throw new IllegalArgumentException("Atenció, la casella d'inici i la de destí no poden ser les mateixes.");
		}
		if (casellaSeleccionada < 1 || casellaSeleccionada > 33) {
			throw new IllegalArgumentException("Atenció, has seleccionat la casella incial incorrectament.");
		}
		if (casellaDesti < 1 || casellaDesti > 33) {
			throw new IllegalArgumentException("Atenció, has seleccionat la casella de destí incorrectament.");
		}

<<<<<<< HEAD
		// Comprovem que la casella a la que es vol saltar esti buida i la seleccionada que no ho esti
=======
		// Comprovem que la casella a la que es vol saltar estigui buida i la seleccionada que no ho estigui
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
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
		
<<<<<<< HEAD
		//el metode retorna la casella que s'ha eliminat
		return eliminaFitxaEntremig(cSeleccionada, cDesti);
		
	} 
=======
		eliminaFitxaEntremig(cSeleccionada, cDesti);
		
		//si el metode anterior no dispara excepcions vol dir que s'ha eliminat una fitxa i hem d'actualitar el marcador
		casellesEliminades++;
		casellesRestants--;
		
	 } 
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
	
	//aquest metode s'encarrega de comprovar que les fitxes seleccionades estan ben seleccionades
	//i tambe realitza el moviment de fitxes i les elimines
	
<<<<<<< HEAD
	private casella eliminaFitxaEntremig(posicio seleccionada, posicio desti) {
		casella eliminada = null;
		
=======
	private void eliminaFitxaEntremig(posicio seleccionada, posicio desti) {
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
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
<<<<<<< HEAD
					eliminada = getNumCasella(seleccionada.getFila(), seleccionada.getColumna() + 1);
					
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
					this.getNumCasella(desti.getFila(), desti.getColumna()).setOcupada(true); //coloquem la nova fitxa a la posicio de desti
					this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna()).setOcupada(false);//eliminem la fitxa de la posicio inicial
				}else{
					throw new IllegalArgumentException("Atenció, no es pot realitzar el salt perque no es pot saltar cap fitxa. ");
				
				}
			}else if (this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna() -1).Ocupada()){
					this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna() -1 ).setOcupada(false);
<<<<<<< HEAD
					eliminada = getNumCasella(seleccionada.getFila(), seleccionada.getColumna() - 1);
					
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
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
<<<<<<< HEAD
						eliminada = getNumCasella(seleccionada.getFila() + 1, seleccionada.getColumna());
						
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
						this.getNumCasella(desti.getFila(), desti.getColumna()).setOcupada(true);
						this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna()).setOcupada(false);
					}else{
						throw new IllegalArgumentException("Atenció, no es pot realitzar el salt sobre una casella buida.");
					}

				} else if(this.getNumCasella(seleccionada.getFila() - 1, seleccionada.getColumna()).Ocupada()){
					this.getNumCasella(seleccionada.getFila() - 1, seleccionada.getColumna()).setOcupada(false);
<<<<<<< HEAD
					eliminada = getNumCasella(seleccionada.getFila()-1, seleccionada.getColumna());
					
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
					this.getNumCasella(desti.getFila(), desti.getColumna()).setOcupada(true);
					this.getNumCasella(seleccionada.getFila(), seleccionada.getColumna()).setOcupada(false);
				}else{
				
				}
			}
			
		else{
				throw new IllegalArgumentException("Atenció, la fitxa seleccionada no es troba dins dels movmients posibles");
		 }
<<<<<<< HEAD
		
		//vol dir que s'ha eliminat una casella i per tant actualitzem els marcadors
		if(eliminada != null){
			casellesEliminades++;
			casellesRestants--;
		}
		return eliminada;
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
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
<<<<<<< HEAD
	
	
	//A PARTIR D'AQUI TROBEM EL FRAME
	public void initComponents(){
	
		//mesures del frame
		setSize(1024,576); //per defecte, es la mesura de la imatge de fons del frame
		setExtendedState(JFrame.MAXIMIZED_BOTH); //quan l'usuari l'obri s'executar a pantalla completa, ell el pot fer mes petit si vols
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("SENKU V.3");
				
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				setMissatgeFrame();
				JOptionPane.showMessageDialog(null, "resultats de haver jugat"); //aqui hay que hacer el mensaje
				System.exit(0); //acabem amb l'execucio
			}
		});
		
		setIconImage(getToolkit().getImage("iconaPrograma.png"));
		
			
	
		GridLayout matriuBotons = new GridLayout(7,7);

		JPanel panell = new JPanel(); //te el grid layout com a manager
		
		panell.setLayout(matriuBotons);
		getContentPane().add(panell);
		
		//fem que hi hagi separacio entre les caselels perque es pun veure be en cas que no es ju a pantalla completa
		matriuBotons.setHgap(6);
		matriuBotons.setVgap(6);
			
		
		//contenidor.setBackground(colorFons);
		
		Iterator <casella> it = taulell.iterator();
		while(it.hasNext()){
			casella aux = it.next();
			if(aux.NumeroCasella() == 17){
				aux.setButton(false);
			}else{
				aux.setButton(true);
			}
		
		}
			
		
		
		//aquest boto permet  a l'usuari decidir si vol soroll INICALMENT SI HI HAURÀ SOROLL
		
		
		JButton musica = new JButton();
		
		musica.setIcon(imatges[3]);
		musica.setOpaque(true);
		musica.setBorder(null);
		Color col = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
		
		musica.setBackground(new Color(col.getRed(), col.getGreen(), col.getBlue()));
		musica.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(usuariVolSoroll){
					//l'usuari tenia soroll i ara no en vol
					usuariVolSoroll = false;
					musica.setIcon(joc.imatges[2]);
				}else{
					//l'usuari tenia el so desactivtiat i ara en vol
					usuariVolSoroll = true;
					musica.setIcon(joc.imatges[3]);
				}
			}
			
		});
		
		//aquest boto permet a l'usuari sortir del frame i li donara un missatge d'alerta indicant les seves estadistiques
			
		
		int comptador = 0;
		
		for(int f = 0; f < 7; f++){
			for(int c = 0; c < 7; c++){
				//utilitzem metode de la clase posicio per posicionar els botons correctament al gestor de posicio
				if(posicio.posicioIncorrecte(f,c)){ //si la posicio es incorrecte
					if(f == 0 && c == 0){
						//aqui anira el boto que permetera a l'usuari escollir so
						panell.add(musica); //afegim el boto de contorl de so
					}else{
						JButton invisible = new JButton();
						invisible.setVisible(false); //es centinela, només per omplir el frame
						panell.add(invisible);
					}
				}else{
					panell.add(taulell.get(comptador).getButton());
					comptador++;
				}
			}
		}
		
		
		
		//ara modifiquem la del centre perque esti eliminada
		taulell.get(16).getButton().setIcon(joc.imatges[0]);
		
		
		//pero hem d'afegir funcionalitats a aquest frame, per aixo utilitzarem un event del tipus click
		it = taulell.iterator();
		while(it.hasNext()){
			casella aux = it.next();
			aux.getButton().addActionListener(new ActionListener(){
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					//asignem la casella
					if(casellaSeleccionada == null){ //vol dir que seleccionem un nou boto
						casellaSeleccionada = aux;
						/**aixo d'aqui sota eliminar a l'entrega final del projecte*/
						casellaSeleccionada.getButton().setBackground(Color.GREEN); //per saber quina s'ha escollit com a inici
					
					}else{
						//aqui llavors es quan hem de realitzar l'acció
						
						try{
							//aux.getButton().setBackground(Color.blue); //per saber quina s'ha escollit com a desti
							
							casella eliminar = comprovaCaselles(casellaSeleccionada.NumeroCasella(), aux.NumeroCasella());
							//si no salta l'excepció procedim a jugar
							
							//com el moviment ha estat correcte avisem acusticament de que s'ha eliminat una fitxa, tambe l'usuari ha de voler
							if(joc.usuariVolSoroll == true){
								
								/**fem reproduir el so per afirmar que s'ha eliminat una fitxa amb èxit"*/
								try {
									Clip sonido = AudioSystem.getClip();
									sonido.open(AudioSystem.getAudioInputStream(new File("correcte.wav")));
									sonido.start();
								} catch (Exception e1) {}
								
							}
							
							//aquesta es la casella que queda entremig
							eliminar.getButton().setIcon(joc.imatges[0]);
							casellaSeleccionada.getButton().setIcon(joc.imatges[0]);
							//l'auxiliar es la casella desti
							aux.getButton().setIcon(joc.imatges[1]);
							
							/**El soroll dona a entendre que el moviment es CORRECTE*/
							
							
						
						}catch(IllegalArgumentException error){
							//no realitzem res perque l'usuari ha intenta realitzar un mvoiment incorrecte
							System.out.println(error.getMessage()); //per si vol veure el que ha passat per consola
						}
						
						//reiniciem el fons de la casella seleccionada, ja que, ara estara "deseleccionada"
						Color c = UIManager.getLookAndFeel().getDefaults().getColor( "Panel.background");
						casellaSeleccionada.getButton().setBackground(new Color(c.getRed(), c.getGreen(), c.getBlue()));
						
						casellaSeleccionada = null;
						//aux.getButton().setBackground(colorFons);
			
					}
				}
			});
		}
		
		
		//un cop hem afegit tots els parametres
		
		setVisible(true);
		
	}
=======
>>>>>>> c93fadc98cd0079a9a3b7d4db6cda8ca6b20a64e
}
