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

		// Déclarer des sites par leur nom, leur localisation
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

	// ---								Méthode getEcran
	//
	public Ecran getEcran(int numero) {

		// Recuperer un écran par rapport à sa place dans la liste d'écran du site
		//
		return this.getListe_Ecrans().get(numero);
	}

	// ---								Méthode isVide
	//
	public boolean isVide() {

		// Indique si le site n'a pas d'écran
		//
		return nombreEcran() == 0;
	}

	// ---								Méthode nombreEcran
	//
	public int nombreEcran() {

		// Recuperer la taille de la liste d'écran du site
		//
		return this.getListe_Ecrans().size();
	}

	// ---								Méthode ajouterEcran
	//
	public void ajouterEcran(Ecran ecran) {

		// Ajouter un écran à la liste d'écran du site
		//
		this.getListe_Ecrans().add(ecran);
	}

	// ---								Méthode enleverEcran
	//
	public boolean enleverEcran(Ecran ecran) {

		// Enlever un écran à la liste du site
		//
		return this.getListe_Ecrans().remove(ecran);
	}

	// ---								Méthode enleverToutEcran
	//
	public boolean enleverToutEcran() {

		// Enlever tous les écran de la liste du site
		//
		return this.getListe_Ecrans().removeAll(this.getListe_Ecrans());
	}

	// ---								Méthode visualiserEtat
	//
	public String visualiserEtat(Connexion connexion) {

		// Vérifier que le site n'est pas vide
		//
		if(isVide()) return null;

		// Déclarer la variable resultat
		//
		String resultat = "";

		// Remplir le resultat avec la visualisation de l'état de chaque écran
		//
		for(int i = 0; i < this.nombreEcran(); i++) {

			// Déclarer l'écran cible de la boucle
			//
			Ecran cible = getEcran(i);

			// Ajouter la visualisation de l'état de l'écran au resultat
			//
			resultat += cible.visualiserEtat(connexion);
		}

		// Renvoyer la visualisation de l'état des écran du site
		//
		return resultat;
	}

	// ---								Méthode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		return "[ nom = " + this.getNom()
				+ ", localisation = " + this.getLocalisation()
				+ ", écrans = " + this.getListe_Ecrans().toString() + " ]";
	}
}