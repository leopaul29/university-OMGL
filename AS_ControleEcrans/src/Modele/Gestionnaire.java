/*
 * 
 */
package Modele;

import java.util.ArrayList;
import Modele.Ecran;

// TODO: Auto-generated Javadoc
/**
 * The Class Gestionnaire.
 * Class qui permet de gérer tous les écrans
 * 
 * --- Constructeur :
 * Gestionnaire :					Créer une arrayList qui peux contenir des écrans
 * 
 * --- Méthodes :
 * getListe_ecrans :				Obtenir la liste de tous les écrans que contient le gestionnaire
 * getEcran :						Obtenir un écran du gestionnaire
 * getListe_EcranEtats :			Obtenir l'état de chaque écrans du gestionnaire
 * getListe_EcranEteint :			Obtenir les écrans qui sont eteint et par qui
 * getListe_EcranErreur :			Obtenir la liste des erreurs des écrans qui ont des erreurs levées dans le gestionnaire
 * eteindreEcran :					Eteindre un écran du gestionnaire
 * eteintParQui :					Savoir par qui a était eteint un écran du gestionnaire
 * 
 * @author LeoPaul
 */
public class Gestionnaire {

	// ---								Attributs
	//
	/** The liste_ecrans. */
	private ArrayList<Ecran> liste_ecrans;

	// ---								Constructeur par défaut
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

		// Renvoi un écran de la liste
		//
		return getListe_ecrans().get(numEcran);
	}
	
	// ---								Méthode getListe_EcranEtats
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
	
	// ---								Méthode getListe_EcranEteint
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

		// Si l'etat de l'écran est "eteint" alors j'ajoute l'écran dans cette arraylist
		//
		for(int i = 0 ; i < getListe_ecrans().size() ; i++)
			if(getEcran(i).isEteint() == true)
				listeEteint.add("Ecran n:" + getEcran(i).getNumEcran() + " - " + eteintParQui(i));

		// Je renvoi l'arraylist
		//
		return listeEteint;
	}
	
	// ---								Méthode getliste_EcranErreur
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

		// Si l'etat de l'écran est "erreurs levée" alors j'ajoute l'écran dans cette arraylist
		//
		for(int i = 0 ; i < getListe_ecrans().size() ; i++)
			if(getEcran(i).isErreur() == true)
				listeErreur.add("Ecran n:" + getEcran(i).getNumEcran() + " - " + getEcran(i).getList_Erreur().toString());

		// Je renvoi l'arraylist
		//
		return listeErreur;
	}

	// ---								Méthode eteindreEcran
	//
	/**
	 * Eteindre ecran.
	 *
	 * @param numEcran the num ecran
	 * @param nomPersonne the nom personne
	 */
	public void eteindreEcran(int numEcran, String nomPersonne) {
		
		// Eteindre l'écran choisi
		//
		getEcran(numEcran).eteindreEcran(nomPersonne);
	}

	// ---								Méthode eteintParQui
	//
	/**
	 * Eteint par qui.
	 *
	 * @param numEcran the num ecran
	 * @return the string
	 */
	public String eteintParQui(int numEcran) {
		
		// Renvoyer le nom de la personne qui a eteint l'écran
		//
		return getEcran(numEcran).getEteintPar();
	}



}