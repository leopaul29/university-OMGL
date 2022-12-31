package Modele;

import java.util.ArrayList;

import Modele.Ecran;

// TODO: Auto-generated Javadoc
/**
 * The Class Site.
 * Class qui permet de gérer les écran appartenant à un site.
 * 
 * --- Attributs / type :
 * nom								String
 * localisation						String
 * liste_ecrans						ArrayList<Ecran>
 * 
 * --- Constructeur :
 * Site(String nom, String localisation)	Créer un site
 * 
 * --- Getter & Setter :
 * getNom							Obtenir le nom du site
 * setNom							Changer le nom du site
 * getLocalisation					Obtenir la localisation du site
 * setLocalisation					Changer la localisation du site
 * getListe_ecrans					Obtenir la liste d'écrans 
 * setListe_ecrans					Changer la liste d'écrans
 * getEcran							Obtenir un écran de la liste
 * isVide							Savoir si la liste d'écran est vide
 * 
 * --- Méthodes :
 * nombreEcran()					Afficher le nombre d'écran que contient le site
 * ajouterEcran(Ecran ecran)		Ajouter a la liste d'écran du site un écran
 * enleverEcran(Ecran ecran)		Enlever a la liste d'écran du site un écran
 * enleverToutEcran()				Enlever a la liste d'écran du site tous les écrans
 * visualiserEtat()					Afficher les états de chaque écrans du site
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

		// Déclarer des sites par leur nom, leur localisation
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

	// ---								Méthode getEcran
	//
	/**
	 * Gets the ecran.
	 *
	 * @param numero the numero
	 * @return the ecran
	 */
	public Ecran getEcran(int numero) {

		// Recuperer un écran par rapport à sa place dans la liste d'écran du site
		//
		return this.getListe_Ecrans().get(numero);
	}

	// ---								Méthode isVide
	//
	/**
	 * Checks if is vide.
	 *
	 * @return true, if is vide
	 */
	public boolean isVide() {

		// Indique si le site n'a pas d'écran
		//
		return nombreEcran() == 0;
	}

	// ---								Méthode nombreEcran
	//
	/**
	 * Nombre ecran.
	 *
	 * @return the int
	 */
	public int nombreEcran() {

		// Recuperer la taille de la liste d'écran du site
		//
		return this.getListe_Ecrans().size();
	}

	// ---								Méthode ajouterEcran
	//
	/**
	 * Ajouter ecran.
	 *
	 * @param ecran the ecran
	 */
	public void ajouterEcran(Ecran ecran) {

		// Ajouter un écran à la liste d'écran du site
		//
		this.getListe_Ecrans().add(ecran);
	}

	// ---								Méthode enleverEcran
	//
	/**
	 * Enlever ecran.
	 *
	 * @param ecran the ecran
	 * @return true, if successful
	 */
	public boolean enleverEcran(Ecran ecran) {

		// Enlever un écran à la liste du site
		//
		return this.getListe_Ecrans().remove(ecran);
	}

	// ---								Méthode enleverToutEcran
	//
	/**
	 * Enlever tout ecran.
	 *
	 * @return true, if successful
	 */
	public boolean enleverToutEcran() {

		// Enlever tous les écran de la liste du site
		//
		return this.getListe_Ecrans().removeAll(this.getListe_Ecrans());
	}

	// ---								Méthode visualiserEtat
	//
	/**
	 * Visualiser etat.
	 *
	 * @return the string
	 */
	public String visualiserEtat() {

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
			resultat += cible.visualiserEtat();
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