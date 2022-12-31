package Modele;

import java.util.ArrayList;

/**
 * The Class Ecran.
 * Class qui permet de cr�er et de modifier un �cran
 * 
 * --- Constructeurs :
 * Ecran :						Cr�er un �cran
 * Ecran(int numEcran) :		Cr�er un �cran avec un num�ro
 * 
 * --- M�thodes :
 * getEtat :					Obtenir l'�tat d'un �cran
 * setEtat :					Changer l'�tat d'un �cran
 * getNumEcran :				Obtenir le num�ro d'un �cran
 * getErreur :					Obtenir les d'erreurs
 * isErreur :					Savoir si l'�cran a des erreurs
 * setErreur :					Changer la valeur de erreur(boolean)
 * getList_Erreur :				Obtenir la liste d'erreurs
 * toStringErreur :				Afficher les erreurs
 * isEteint :					Savoir si l'�cran est eteint
 * setEteint :					Changer la valeur de eteint(boolean)
 * getEteintPar :				Savoir par qui a �tait eteint l'�cran la derni�re fois
 * setEteintPar :				Changer la personne qui a eteint l'�cran
 * toString :					Afficher un �cran
 * afficherEtat :				Afficher l'�tat d'un �cran
 * eteindreEcran :				Eteindre un �cran
 * allumerEcran :				Allumer un �cran
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
			this.setEtat("erreurs lev�es");
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
		
		// Si je l'eteint alors je set l'�tat a "eteint"
		//
		if(this.eteint == true)
			setEtat("eteint");
		
		// Sinon je l'allume  alors je set l'�tat a "en marche"
		else
			setEtat("en marche");
	}
	
	public String getEteintPar() {
		return this.eteintPar;
	}
	
	public void setEteintPar(String eteintPar) {
		this.eteintPar = eteintPar;
	}

	// ---								M�thode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Ecran n:" + getNumEcran() + " - " + getEtat()
				+ " - erreurs lev�es : " + toStringErreur()
				+ " - eteint : "+ isEteint()
				+ " - eteint par : " + getEteintPar();
	}
	
	// ---								M�thode afficherEtat
	//
	/**
	 * Afficher etat.
	 *
	 * @return the string
	 */
	public String afficherEtat() {return "Ecran n:" + getNumEcran() + " - " + getEtat();}
	
	// ---								M�thode eteindre �cran
	//
	/**
	 * Eteindre ecran.
	 *
	 * @param nomPersonne the nom personne
	 */
	public void eteindreEcran(String nomPersonne) {
		
		// Changer � true l'�tat eteint de l'�cran
		//
		setEteint(true);
		
		// Changer la valeur de la personne qui a eteint l'�cran
		//
		setEteintPar(nomPersonne);
	}
}