package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import Modele.Afficheur;

public class StockAfficheur {

	// ---											Attributs
	//
	private HashMap<String, Afficheur> liste_afficheur;
	private ArrayList<String> liste_nomA;
	private ArrayList<String> liste_auteur;
	private ArrayList<String> liste_style;

	// ---											Constructeur normal
	//
	public StockAfficheur() {

		// Créer un HashMap d'afficheur
		//
		this.liste_afficheur = new HashMap<String, Afficheur>();

		// Créer une ArrayList de nom d'afficheur
		//
		this.liste_nomA = new ArrayList<String>();

		// Créer une ArrayList de nom d'auteur
		//
		this.liste_auteur = new ArrayList<String>();

		// Créer une ArrayList de nom de style
		//
		this.liste_style = new ArrayList<String>();
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

	public ArrayList<String> getListe_auteur() {
		return liste_auteur;
	}

	public void setListe_auteur(ArrayList<String> liste_auteur) {
		this.liste_auteur = liste_auteur;
	}

	public ArrayList<String> getListe_style() {
		return liste_style;
	}

	public void setListe_style(ArrayList<String> liste_style) {
		this.liste_style = liste_style;
	}

	public Afficheur getAfficheur(String nom) {

		// Obtenir un afficheur à partir de son nom
		//
		return getListe_afficheur().get(nom);
	}

	public Afficheur getAfficheur(int numero) {

		// Obtenir un afficheur à partir de son numero dans la liste de nom
		//
		return getListe_afficheur().get(getListe_nomA().get(numero));
	}

	public String getAuteur(int numero) {

		// Obtenir le nom d'auteur de l'afficheur
		//
		return getAfficheur(numero).getAuteur();
	}

	public Style getStyle(int numero) {

		// Obtenir le nom d'auteur de l'afficheur
		//
		return getAfficheur(numero).getStyle();
	}

	//
	public String getNomStyle(int numero) {

		// Obtenir le nom du style de l'afficheur
		//
		return getStyle(numero).getNom();
	}

	// ---											Méthode nombreNom
	//
	public int nombreNom() {

		// Obtenir le nombre de nom d'afficheur dans la liste
		//
		return getListe_nomA().size();
	}

	// ---											Méthode nombreStyle
	//
	public int nombreStyle() {

		// Obtenir le nombre de nom de style dans la liste
		//
		return getListe_style().size();
	}

	// ---											Méthode nombreAuteur
	//
	public int nombreAuteur() {

		// Obtenir le nombre de nom d'auteur dans la liste
		//
		return getListe_auteur().size();
	}


	// ---											Méthode nombreAfficheur
	//
	public int nombreAfficheur() {

		// Obtenir le nombre d'afficheur dans le HashMap
		//
		return getListe_afficheur().size();
	}

	// ---											Méthode afficherAuteur
	//
	public String afficherAuteur() {

		// Déclarer un resultat
		//
		String resultat = "Afficheur par auteur { ";

		// Parcourir la liste d'auteur pour afficher les afficheur correspondant à chaque auteurs
		//
		for(int i = 0; i < nombreAuteur(); i++) {

			// Ajouter au resultat les afficheurs de l'auteur actuel
			//
			resultat += afficherAuteur(getAuteur(i));
		}

		// Renvoyer le resultat
		//
		return resultat += " }";
	}

	// ---											Méthode afficherAuteur
	//
	public String afficherAuteur(String auteur) {

		// Déclarer un resultat
		//
		String resultat = "Auteur : " + auteur + " [ ";

		// Parcourir la liste d'afficheur pour afficher les afficheur correspondant à l'auteur voulu
		//
		for(int i = 0; i < nombreAfficheur(); i++) {

			// Verifier que l'auteur correspond
			//
			if(auteur == getAuteur(i))

				// Ajouter au resultat l'afficheur
				//
				resultat += getAfficheur(i).toString();
		}

		// Renvoyer le resultat
		//
		return resultat += " ]";
	}

	// ---											Méthode afficherStyle
	//
	public String afficherStyle() {

		// Déclarer un resultat
		//
		String resultat = "Afficheur style : { ";

		// Parcourir la liste d'afficheur pour afficher les afficheur correspondant à l'auteur voulu
		//
		for(int i = 1; i < nombreStyle() + 1; i++) {

			// Verifier que l'auteur correspond
			//
			resultat += afficherStyle(getNomStyle(i));
		}

		// Renvoyer le resultat
		//
		return resultat += " }";
	}

	// ---											Méthode afficherStyle
	//
	public String afficherStyle(Style style) {

		// Obtenir nom du style
		//
		String nom_style = style.getNom();

		// Déclarer un resultat
		//
		String resultat = "Afficheur style : " + nom_style + " [ ";

		// Parcourir la liste d'afficheur pour afficher les afficheur correspondant à l'auteur voulu
		//
		for(int i = 0; i < nombreAfficheur(); i++) {

			// Verifier que l'auteur correspond
			//
			if(nom_style == getNomStyle(i))

				// Ajouter au resultat l'afficheur
				//
				resultat += getAfficheur(i).toString();
		}

		// Renvoyer le resultat
		//
		return resultat += " ]";
	}

	// ---											Méthode afficherStyle
	//
	public String afficherStyle(String nom_style) {

		// Déclarer un resultat
		//
		String resultat = "Afficheur style : " + nom_style + " [ ";

		// Parcourir la liste d'afficheur pour afficher les afficheur correspondant à l'auteur voulu
		//
		for(int i = 0; i < nombreAfficheur(); i++) {

			// Verifier que le style correspond
			//
			if(nom_style == getNomStyle(i))

				// Ajouter au resultat l'afficheur
				//
				resultat += getAfficheur(i).toString();
		}

		// Renvoyer le resultat
		//
		return resultat += " ]";
	}

	// ---											Méthode ajouterAfficheur
	//
	public void ajouterAfficheur(Afficheur afficheur) {

		// Récuperer le nom de l'afficheur
		//
		String nom_afficheur = afficheur.getNom();

		// Récuperer le nom de l'auteur
		//
		String nom_auteur = afficheur.getAuteur();

		// Récuperer le nom du style
		//
		String nom_style = afficheur.getStyle().getNom();

		// Ajouter l'afficheur au HashMap
		//
		getListe_afficheur().put(nom_afficheur, afficheur);

		// Ajouter le nom de l'afficheur à la liste
		//
		ajouterNom(nom_afficheur);

		// Ajouter le nom de l'auteur à la liste
		//
		ajouterAuteur(nom_auteur);

		// Ajouter le nom du style à la liste
		//
		ajouterStyle(nom_style);
	}

	// ---											Méthode ajouterNom
	//
	public void ajouterNom(String nom) {

		// Ajouter le nom de l'afficheur à la liste
		//
		getListe_nomA().add(nom);
	}

	// ---											Méthode ajouterAuteur
	//
	public void ajouterAuteur(String nom_auteur) {

		// Parcourir la liste d'auteur pour eliminer le doublon
		//
		for(int i = 0; i < nombreAuteur(); i++) {

			// Vérifier le doublon
			//
			if(nom_auteur == getAuteur(i))
				return;
		}

		// Ajouter le nom de l'afficheur à la liste
		//
		getListe_auteur().add(nom_auteur);
	}

	// ---											Méthode ajouterStyle
	//
	public void ajouterStyle(String nom_style) {

		// Parcourir la liste d'auteur pour eliminer le doublon
		//
		for(int i = 0; i < nombreStyle(); i++) {

			// Vérifier le doublon
			//
			if(nom_style == getNomStyle(i))
				return;
		}

		// Ajouter le nom de l'afficheur à la liste
		//
		getListe_style().add(nom_style);
	}

	// ---											Méthode afficherNomAfficheur
	//
	public String afficherNomAfficheur() {

		return getListe_nomA().toString();
	}

	// ---											Méthode afficherNomAuteur
	//
	public String afficherNomAuteur() {

		return getListe_auteur().toString();
	}

	// ---											Méthode afficherAfficheur
	//
	public String afficherAfficheur() {

		return getListe_afficheur().toString();
	}

	// ---											Méthode afficherNomStyle
	//
	public String afficherNomStyle() {

		return getListe_style().toString();
	}

	// ---											Méthode toString
	//
	public String toString() {

		return "Liste d'Afficheurs : " + getListe_afficheur().toString();
	}
}