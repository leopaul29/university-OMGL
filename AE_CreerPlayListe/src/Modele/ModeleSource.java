package Modele;


public class ModeleSource {
	private String contenu;
	private int ordre;

	public String getTitre() {return this.contenu;}
	public void setTitre(String aTitre) {this.contenu = aTitre;}
	public int getOrdre() {return this.ordre;}
	public void setOrdre(int aListe_mot) {this.ordre = aListe_mot;}
	 
	// --------------------- Constructeur par défaut 
	public ModeleSource(){
	
	}
	
	// --------------------- Constructeur normal (1)
	public ModeleSource(String chemin){

		
	}
	
	
}
