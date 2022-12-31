package Modele;

import java.util.ArrayList;

public class GestionnaireEcrans {

	// ---											Attributs
	//
	private ArrayList<Ecran> liste_ecrans;
	private StockAfficheur liste_afficheurs;

	// ---											Constructeur normal 1
	//
	public GestionnaireEcrans(StockAfficheur liste_afficheurs){

		// Cr�er une liste d'�crans
		//
		this.liste_ecrans = new ArrayList<Ecran>();

		// Cr�er une liste d'afficheur
		//
		this.liste_afficheurs = liste_afficheurs;
	}

	// ---											Getter & Setter
	//
	public ArrayList<Ecran> getListe_ecrans() {
		return liste_ecrans;
	}

	public void setListe_ecrans(ArrayList<Ecran> liste_ecrans) {
		this.liste_ecrans = liste_ecrans;
	}

	public StockAfficheur getListe_afficheurs() {
		return liste_afficheurs;
	}

	public void setListe_afficheurs(StockAfficheur liste_afficheurs) {
		this.liste_afficheurs = liste_afficheurs;
	}

	// ---											M�thode ajouterEcran
	//
	public void ajouterEcran(Ecran ecran){

		// Ajouter un �cran au gestionnaire
		//
		getListe_ecrans().add(ecran);
	}

	// ---											M�thode nombreAfficheur
	//
	public int nombreAfficheur() {

		return getListe_afficheurs().getListe_nomA().size();
	}

	// ---											M�thode nombreEcran
	//
	public int nombreEcran() {

		return getListe_ecrans().size();
	}

	// ---											M�thode afficherAfficheurs
	//
	public String afficherAfficheurs() {

		return getListe_afficheurs().toString();
	}

	// ---											M�thode afficherEcrans
	//
	public String afficherEcrans() {

		return getListe_ecrans().toString();
	}

	// ---											M�thode toString
	//
	public String toString() {

		return "GestionnaireEcrans [listEcran=" + liste_ecrans + ", listAfficheur=" + liste_afficheurs + "]";
	}
}