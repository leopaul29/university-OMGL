package Modele;

import java.util.ArrayList;

import Modele.Ecran;

// TODO: Auto-generated Javadoc
/**
 * The Class Site.
 * Class qui permet de g�rer les �cran appartenant � un site.
 * 
 * --- Attributs / type :
 * nom								String
 * localisation						String
 * liste_ecrans						ArrayList<Ecran>
 * 
 * --- Constructeur :
 * Site(String nom, String localisation)	Cr�er un site
 * 
 * --- Getter & Setter :
 * getNom							Obtenir le nom du site
 * setNom							Changer le nom du site
 * getLocalisation					Obtenir la localisation du site
 * setLocalisation					Changer la localisation du site
 * getListe_ecrans					Obtenir la liste d'�crans 
 * setListe_ecrans					Changer la liste d'�crans
 * getEcran							Obtenir un �cran de la liste
 * isVide							Savoir si la liste d'�cran est vide
 * 
 * --- M�thodes :
 * nombreEcran()					Afficher le nombre d'�cran que contient le site
 * ajouterEcran(Ecran ecran)		Ajouter a la liste d'�cran du site un �cran
 * enleverEcran(Ecran ecran)		Enlever a la liste d'�cran du site un �cran
 * enleverToutEcran()				Enlever a la liste d'�cran du site tous les �crans
 * visualiserEtat()					Afficher les �tats de chaque �crans du site
 * toString()						Afficher un site
 * 
 * 
 * @author LeoPaul
 */
public class Site {

	// ---								Attributs
	//
	/** The nom. */
	private String 				nom;

	/** The localisation. */
	private String 				localisation;

	/** The liste_ecrans. */
	private ArrayList<Ecran> 	liste_ecrans;

	// ---								Constructeur normal
	//
	/**
	 * Instantiates a new site.
	 *
	 * @param nom the nom
	 * @param localisation the localisation
	 */
	public Site(String nom, String localisation){

		// D�clarer des sites par leur nom, leur localisation
		//
		this.nom = nom;
		this.localisation = localisation;
		this.liste_ecrans = new ArrayList<Ecran>();
	}

	// ---								Getter & Setter
	//
	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the localisation.
	 *
	 * @return the localisation
	 */
	public String getLocalisation() {
		return localisation;
	}

	/**
	 * Sets the localisation.
	 *
	 * @param localisation the new localisation
	 */
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	/**
	 * Gets the liste_ ecrans.
	 *
	 * @return the liste_ ecrans
	 */
	public ArrayList<Ecran> getListe_Ecrans() {
		return liste_ecrans;
	}

	/**
	 * Sets the liste_ ecrans.
	 *
	 * @param ecrans the new liste_ ecrans
	 */
	public void setListe_Ecrans(ArrayList<Ecran> ecrans) {
		this.liste_ecrans = ecrans;
	}

	// ---								M�thode getEcran
	//
	/**
	 * Gets the ecran.
	 *
	 * @param numero the numero
	 * @return the ecran
	 */
	public Ecran getEcran(int numero) {

		// Recuperer un �cran par rapport � sa place dans la liste d'�cran du site
		//
		return this.getListe_Ecrans().get(numero);
	}

	// ---								M�thode isVide
	//
	/**
	 * Checks if is vide.
	 *
	 * @return true, if is vide
	 */
	public boolean isVide() {

		// Indique si le site n'a pas d'�cran
		//
		return nombreEcran() == 0;
	}

	// ---								M�thode nombreEcran
	//
	/**
	 * Nombre ecran.
	 *
	 * @return the int
	 */
	public int nombreEcran() {

		// Recuperer la taille de la liste d'�cran du site
		//
		return this.getListe_Ecrans().size();
	}

	// ---								M�thode ajouterEcran
	//
	/**
	 * Ajouter ecran.
	 *
	 * @param ecran the ecran
	 */
	public void ajouterEcran(Ecran ecran) {

		// Ajouter un �cran � la liste d'�cran du site
		//
		this.getListe_Ecrans().add(ecran);
	}

	// ---								M�thode enleverEcran
	//
	/**
	 * Enlever ecran.
	 *
	 * @param ecran the ecran
	 * @return true, if successful
	 */
	public boolean enleverEcran(Ecran ecran) {

		// Enlever un �cran � la liste du site
		//
		return this.getListe_Ecrans().remove(ecran);
	}

	// ---								M�thode enleverToutEcran
	//
	/**
	 * Enlever tout ecran.
	 *
	 * @return true, if successful
	 */
	public boolean enleverToutEcran() {

		// Enlever tous les �cran de la liste du site
		//
		return this.getListe_Ecrans().removeAll(this.getListe_Ecrans());
	}

	// ---								M�thode visualiserEtat
	//
	/**
	 * Visualiser etat.
	 *
	 * @return the string
	 */
	public String visualiserEtat() {

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
			resultat += cible.visualiserEtat();
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