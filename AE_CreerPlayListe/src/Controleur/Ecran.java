package Controleur;

import javax.swing.JRadioButton;

import Modele.GestionnaireSources;

public class Ecran extends JRadioButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GestionnaireSources modele;
	private int id;
	private String source;
	
	
	public GestionnaireSources getModele() {
		return modele;
	}

	public String getSource(){
		return source;
	}
	public void setModele(GestionnaireSources modele) {
		this.modele = modele;
	}


	public int getId(){	return id;}
	
	public Ecran(){
	}
	
	// --------------------- Constructeur normal (1)
	public Ecran(GestionnaireSources modele, String titre, String source){
		this.modele = modele;
		setText(titre);
		this.source = source;
	}
	
	// --------------------- Constructeur par défaut 
	public Ecran(String titre){
		super(titre);
	}
}
