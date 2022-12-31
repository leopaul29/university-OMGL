/*
 * 
 */
package Modele;

import java.util.ArrayList;
import Modele.Ecran;

// TODO: Auto-generated Javadoc
/**
 * The Class Gestionnaire.
 * Class qui permet de g�rer tous les �crans
 * 
 * --- Constructeur :
 * Gestionnaire :					Cr�er une arrayList qui peux contenir des �crans
 * 
 * --- M�thodes :
 * getListe_ecrans :				Obtenir la liste de tous les �crans que contient le gestionnaire
 * getEcran :						Obtenir un �cran du gestionnaire
 * getListe_EcranEtats :			Obtenir l'�tat de chaque �crans du gestionnaire
 * getListe_EcranEteint :			Obtenir les �crans qui sont eteint et par qui
 * getListe_EcranErreur :			Obtenir la liste des erreurs des �crans qui ont des erreurs lev�es dans le gestionnaire
 * eteindreEcran :					Eteindre un �cran du gestionnaire
 * eteintParQui :					Savoir par qui a �tait eteint un �cran du gestionnaire
 * 
 * @author LeoPaul
 */
public class Gestionnaire {

	// ---								Attributs
	//
	/** The liste_ecrans. */
	private ArrayList<Ecran> liste_ecrans;

	// ---								Constructeur par d�faut
	//
	/**
	 * Instantiates a new gestionnaire.
	 */
	public Gestionnaire() {
		
		this.liste_ecrans = new ArrayList<Ecran>();
	}

	// ---								Getter
	//
	/**
	 * Gets the liste_ecrans.
	 *
	 * @return the liste_ecrans
	 */
	public ArrayList<Ecran> getListe_ecrans() {
		
		return this.liste_ecrans;
	}

	/**
	 * Gets the ecran.
	 *
	 * @param numEcran the num ecran
	 * @return the ecran
	 */
	public Ecran getEcran(int numEcran) {

		// Renvoi un �cran de la liste
		//
		return getListe_ecrans().get(numEcran);
	}
	
	// ---								M�thode getListe_EcranEtats
	//
	/**
	 * Gets the liste_ ecran etats.
	 *
	 * @return the liste_ ecran etats
	 */
	public ArrayList<String> getListe_EcranEtats() {

		// Creation d'une nouvelle arraylist
		//
		ArrayList<String> listeEtats = new ArrayList<String>();

		// J'ajoute l'etat de chaque ecran a cette arraylist
		//
		for(int i = 0 ; i < getListe_ecrans().size() ; i++)
			listeEtats.add(getEcran(i).afficherEtat());

		// Je renvoi l'arraylist
		//
		return listeEtats;
	}
	
	// ---								M�thode getListe_EcranEteint
	//
	/**
	 * Gets the liste_ ecran eteint.
	 *
	 * @return the liste_ ecran eteint
	 */
	public ArrayList<String> getliste_EcranEteint() {
		
		// Creation d'une nouvelle arraylist
		//
		ArrayList<String> listeEteint = new ArrayList<String>();

		// Si l'etat de l'�cran est "eteint" alors j'ajoute l'�cran dans cette arraylist
		//
		for(int i = 0 ; i < getListe_ecrans().size() ; i++)
			if(getEcran(i).isEteint() == true)
				listeEteint.add("Ecran n:" + getEcran(i).getNumEcran() + " - " + eteintParQui(i));

		// Je renvoi l'arraylist
		//
		return listeEteint;
	}
	
	// ---								M�thode getliste_EcranErreur
	//
	/**
	 * Gets the liste_ ecran erreur.
	 *
	 * @return the liste_ ecran erreur
	 */
	public ArrayList<String> getliste_EcranErreur() {
		
		// Creation d'une nouvelle arraylist
		//
		ArrayList<String> listeErreur = new ArrayList<String>();

		// Si l'etat de l'�cran est "erreurs lev�e" alors j'ajoute l'�cran dans cette arraylist
		//
		for(int i = 0 ; i < getListe_ecrans().size() ; i++)
			if(getEcran(i).isErreur() == true)
				listeErreur.add("Ecran n:" + getEcran(i).getNumEcran() + " - " + getEcran(i).getList_Erreur().toString());

		// Je renvoi l'arraylist
		//
		return listeErreur;
	}

	// ---								M�thode eteindreEcran
	//
	/**
	 * Eteindre ecran.
	 *
	 * @param numEcran the num ecran
	 * @param nomPersonne the nom personne
	 */
	public void eteindreEcran(int numEcran, String nomPersonne) {
		
		// Eteindre l'�cran choisi
		//
		getEcran(numEcran).eteindreEcran(nomPersonne);
	}

	// ---								M�thode eteintParQui
	//
	/**
	 * Eteint par qui.
	 *
	 * @param numEcran the num ecran
	 * @return the string
	 */
	public String eteintParQui(int numEcran) {
		
		// Renvoyer le nom de la personne qui a eteint l'�cran
		//
		return getEcran(numEcran).getEteintPar();
	}



}