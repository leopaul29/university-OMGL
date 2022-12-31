package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import Modele.Afficheur;

public class StockAfficheur {

	// ---											Attributs
	//
	private HashMap<String, Afficheur> liste_afficheur;
	private ArrayList<String> liste_nomA;

	// ---											Constructeur normal
	//
	public StockAfficheur() {

		// Cr�er un HashMap d'afficheur
		//
		this.liste_afficheur = new HashMap<String, Afficheur>();

		// Cr�er une ArrayList de nom d'afficheur
		//
		this.liste_nomA = new ArrayList<String>();
	}

	// ---											Getter & Setter
	//
	public HashMap<String, Afficheur> getListe_afficheur() {
		return liste_afficheur;
	}

	public void setListe_afficheur(HashMap<String, Afficheur> liste_afficheur) {
		this.liste_afficheur = liste_afficheur;
	}

	public ArrayList<String> getListe_nomA() {
		return liste_nomA;
	}

	public void setListe_nomA(ArrayList<String> liste_nomA) {
		this.liste_nomA = liste_nomA;
	}

	public Afficheur getAfficheur(String nom) {

		// Obtenir un afficheur � partir de son nom
		//
		return getListe_afficheur().get(nom);
	}

	public Afficheur getAfficheur(int numero) {

		// Obtenir un afficheur � partir de son numero dans la liste de nom
		//
		return getListe_afficheur().get(getListe_nomA().get(numero));
	}

	// ---											M�thode nombreNom
	//
	public int nombreNom() {

		// Obtenir le nombre de nom d'afficheur dans la liste
		//
		return getListe_nomA().size();
	}

	// ---											M�thode nombreAfficheur
	//
	public int nombreAfficheur() {

		// Obtenir le nombre d'afficheur dans le HashMap
		//
		return getListe_afficheur().size();
	}

	// ---											M�thode ajouterAfficheur
	//
	public void ajouterAfficheur(Afficheur afficheur) {

		// R�cuperer le nom de l'afficheur
		//
		String nom_afficheur = afficheur.getNom();

		// Ajouter l'afficheur au HashMap
		//
		getListe_afficheur().put(nom_afficheur, afficheur);

		// Ajouter le nom de l'afficheur � la liste
		//
		ajouterNom(nom_afficheur);
	}

	// ---											M�thode ajouterNom
	//
	public void ajouterNom(String nom) {

		// Ajouter le nom de l'afficheur � la liste
		//
		getListe_nomA().add(nom);
	}

	// ---											M�thode afficherNomA
	//
	public String afficherNomZ() {

		// D�clarer un resultat
		//
		String resultat = "Liste des Afficheurs : [ ";

		// Parcourir la liste de nom
		//
		for(int i = 0; i < nombreNom(); i++) {

			// Ajouter au resultat le nom de l'afficheur
			//
			resultat += "[ " + getAfficheur(i).getNom() + " ] ";
		}

		// Renvoyer le resultat
		//
		return resultat += "]";
	}

	// ---											M�thode toString
	//
	public String toString() {

		return "Liste d'Afficheurs : " + getListe_afficheur().toString();
	}
}