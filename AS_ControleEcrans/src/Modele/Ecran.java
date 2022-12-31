package Modele;

import java.util.ArrayList;

/**
 * The Class Ecran.
 * Class qui permet de créer et de modifier un écran
 * 
 * --- Constructeurs :
 * Ecran :						Créer un écran
 * Ecran(int numEcran) :		Créer un écran avec un numéro
 * 
 * --- Méthodes :
 * getEtat :					Obtenir l'état d'un écran
 * setEtat :					Changer l'état d'un écran
 * getNumEcran :				Obtenir le numéro d'un écran
 * getErreur :					Obtenir les d'erreurs
 * isErreur :					Savoir si l'écran a des erreurs
 * setErreur :					Changer la valeur de erreur(boolean)
 * getList_Erreur :				Obtenir la liste d'erreurs
 * toStringErreur :				Afficher les erreurs
 * isEteint :					Savoir si l'écran est eteint
 * setEteint :					Changer la valeur de eteint(boolean)
 * getEteintPar :				Savoir par qui a était eteint l'écran la dernière fois
 * setEteintPar :				Changer la personne qui a eteint l'écran
 * toString :					Afficher un écran
 * afficherEtat :				Afficher l'état d'un écran
 * eteindreEcran :				Eteindre un écran
 * allumerEcran :				Allumer un écran
 *
 * @author LeoPaul
 */
public class Ecran {
	
	// ---								Attributs
	//
	private String 			etat;
	private MockErreur 		liste_erreur;
	private boolean			erreur;
	private boolean 		eteint;
	private String 			eteintPar;
	private int 			numEcran;

	// ---								Constructeur par defaut
	//
	/**
	 * Instantiates a new ecran.
	 */
	public Ecran() {
		
		this.etat = "en marche";
		this.numEcran = 0;
		
		this.liste_erreur = new MockErreurImpl(this);
		this.erreur = false;
		
		this.eteint = false;
		this.eteintPar = "";
	}
	
	// ---								Constructeur normal
	//
	/**
	 * Instantiates a new ecran.
	 *
	 * @param numEcran the num ecran
	 */
	public Ecran(int numEcran) {

		this.etat = "en marche";
		this.numEcran = numEcran;
		
		this.liste_erreur = new MockErreurImpl(this);
		this.erreur = false;
		
		this.eteint = false;
		this.eteintPar = "";
	}
	
	// ---								Getter & Setter
	//
	public String getEtat() {
		return this.etat;
	}
	
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public int getNumEcran() {
		return this.numEcran;
	}

	// ---								Erreurs
	//
	public MockErreur getErreur() {
		return this.liste_erreur;
	}
	
	public boolean isErreur() {
		return this.erreur;
	}
	
	public void setErreur(boolean erreur){
		if(erreur == true)
			this.setEtat("erreurs levées");
		else
			this.setEtat("en marche");
		this.erreur = erreur;
	}
	
	public ArrayList<String> getList_Erreur() {
		return getErreur().getList_Erreur();
	}
	
	public String toStringErreur() {
		return getList_Erreur().toString();
	}
	
	// ---								Eteindre
	//
	public boolean isEteint() {
		return this.eteint;
	}
	
	public void setEteint(boolean eteint) {
		
		this.eteint = eteint;
		
		// Si je l'eteint alors je set l'état a "eteint"
		//
		if(this.eteint == true)
			setEtat("eteint");
		
		// Sinon je l'allume  alors je set l'état a "en marche"
		else
			setEtat("en marche");
	}
	
	public String getEteintPar() {
		return this.eteintPar;
	}
	
	public void setEteintPar(String eteintPar) {
		this.eteintPar = eteintPar;
	}

	// ---								Méthode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Ecran n:" + getNumEcran() + " - " + getEtat()
				+ " - erreurs levées : " + toStringErreur()
				+ " - eteint : "+ isEteint()
				+ " - eteint par : " + getEteintPar();
	}
	
	// ---								Méthode afficherEtat
	//
	/**
	 * Afficher etat.
	 *
	 * @return the string
	 */
	public String afficherEtat() {return "Ecran n:" + getNumEcran() + " - " + getEtat();}
	
	// ---								Méthode eteindre écran
	//
	/**
	 * Eteindre ecran.
	 *
	 * @param nomPersonne the nom personne
	 */
	public void eteindreEcran(String nomPersonne) {
		
		// Changer à true l'état eteint de l'écran
		//
		setEteint(true);
		
		// Changer la valeur de la personne qui a eteint l'écran
		//
		setEteintPar(nomPersonne);
	}
}