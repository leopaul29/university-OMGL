package Modele;

import java.util.ArrayList;

import Modele.Ecran;

public class Site {

	// ---								Attributs
	//
	private String 				nom;
	private String 				localisation;
	private ArrayList<Ecran> 	liste_ecrans;

	// ---								Constructeur normal
	//
	public Site(String nom, String localisation){

		// D�clarer des sites par leur nom, leur localisation
		//
		this.nom = nom;
		this.localisation = localisation;
		this.liste_ecrans = new ArrayList<Ecran>();
	}

	// ---								Getter & Setter
	//
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public ArrayList<Ecran> getListe_Ecrans() {
		return liste_ecrans;
	}

	public void setListe_Ecrans(ArrayList<Ecran> ecrans) {
		this.liste_ecrans = ecrans;
	}

	// ---								M�thode getEcran
	//
	public Ecran getEcran(int numero) {

		// Recuperer un �cran par rapport � sa place dans la liste d'�cran du site
		//
		return this.getListe_Ecrans().get(numero);
	}

	// ---								M�thode isVide
	//
	public boolean isVide() {

		// Indique si le site n'a pas d'�cran
		//
		return nombreEcran() == 0;
	}

	// ---								M�thode nombreEcran
	//
	public int nombreEcran() {

		// Recuperer la taille de la liste d'�cran du site
		//
		return this.getListe_Ecrans().size();
	}

	// ---								M�thode ajouterEcran
	//
	public void ajouterEcran(Ecran ecran) {

		// Ajouter un �cran � la liste d'�cran du site
		//
		this.getListe_Ecrans().add(ecran);
	}

	// ---								M�thode enleverEcran
	//
	public boolean enleverEcran(Ecran ecran) {

		// Enlever un �cran � la liste du site
		//
		return this.getListe_Ecrans().remove(ecran);
	}

	// ---								M�thode enleverToutEcran
	//
	public boolean enleverToutEcran() {

		// Enlever tous les �cran de la liste du site
		//
		return this.getListe_Ecrans().removeAll(this.getListe_Ecrans());
	}

	// ---								M�thode visualiserEtat
	//
	public String visualiserEtat(Connexion connexion) {

		// V�rifier que le site n'est pas vide
		//
		if(isVide()) return null;

		// D�clarer la variable resultat
		//
		String resultat = "";

		// Remplir le resultat avec la visualisation de l'�tat de chaque �cran
		//
		for(int i = 0; i < this.nombreEcran(); i++) {

			// D�clarer l'�cran cible de la boucle
			//
			Ecran cible = getEcran(i);

			// Ajouter la visualisation de l'�tat de l'�cran au resultat
			//
			resultat += cible.visualiserEtat(connexion);
		}

		// Renvoyer la visualisation de l'�tat des �cran du site
		//
		return resultat;
	}

	// ---								M�thode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		return "[ nom = " + this.getNom()
				+ ", localisation = " + this.getLocalisation()
				+ ", �crans = " + this.getListe_Ecrans().toString() + " ]";
	}
}