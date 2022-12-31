package Modele;

import java.util.ArrayList;

import Modele.Ecran;

// TODO: Auto-generated Javadoc
/**
 * The Class Gestionnaire.
 * Class qui permet de gérer tous les écrans par le biais de site.
 * 
 * --- Attributs :
 * liste_site :					ArrayList
 * reserve :					Site
 * 
 * --- Constructeur :
 * Gestionnaire()				Créer un gestionnaire
 * 
 * --- Getter & Setter :
 * getListe_site				Obtenir la liste de sites
 * setListe_site				Changer la liste de sites
 * getReserve					Obtenir la reserve
 * setReserve					Changer la reserve
 * getSite						Obtenir un site de la liste
 * isVide						Savoir si la liste de sites est vide
 * 
 * --- Méthodes :
 * nombreSite()											Afficher le nombre de site que contient le gestionnaire	
 * visualiserEtat()										Afficher les états de chaque écrans
 * consulterReserve()									Afficher le contenu de la reserve
 * ajouterSite(Site site)								Ajouter un site au gestionnaire
 * effacerSite(Site site)								Effacer un site du gestionnaire en deplacent tous les écrans restant vers la reserve
 * supprimerSite(Site site)								Effacer un site de la liste de sites du gestionnaire
 * deplacerToutEcran(ancien_site, Site nouveau_site)	Déplacer tous les écrans d'un site vers un autre site				
 * deplacerVersReserve(Site ancien_site)				Déplacer tous les écrans d'un site vers la reserve
 * deplacerEcran(Ecran ecran, Site site)				Déplacer un écran vers un autre site
 * toString()											Afficher le gestionnaire
 * 
 * 
 * @author LeoPaul
 */
public class Gestionnaire {

	// ---								Attributs
	//
	/** The liste_site. */
	private ArrayList<Site> 	liste_site;

	/** The reserve. */
	private Site				reserve;
	
	private ArrayList<Ecran> liste_ecrans;
	private StockAfficheur liste_afficheurs;

	// ---								Constructeur par défaut
	//
	/**
	 * Instantiates a new gestionnaire.
	 */
	public Gestionnaire(StockAfficheur liste_afficheurs){

		// Créer une liste d'écrans
		//
		this.liste_ecrans = new ArrayList<Ecran>();

		// Créer une liste d'afficheur
		//
		this.liste_afficheurs = liste_afficheurs;

		// Créer une liste de sites
		//
		this.liste_site = new ArrayList<Site>();

		// Déclarer la reserve
		//
		this.reserve = new Site("Reserve", "secret defense");
	}

	// ---								Getter & Setter
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
	
	/**
	 * Gets the liste_site.
	 *
	 * @return the liste_site
	 */
	public ArrayList<Site> getListe_site() {
		return this.liste_site;
	}

	/**
	 * Sets the liste_site.
	 *
	 * @param liste_site the new liste_site
	 */
	public void setListe_site(ArrayList<Site> liste_site) {
		this.liste_site = liste_site;
	}

	/**
	 * Gets the reserve.
	 *
	 * @return the reserve
	 */
	public Site getReserve() {
		return this.reserve;
	}

	/**
	 * Sets the reserve.
	 *
	 * @param reserve the new reserve
	 */
	public void setReserve(Site reserve) {
		this.reserve = reserve;
	}
	
	// ---											Méthode ajouterEcran
		//
		public void ajouterEcran(Ecran ecran){

			// Ajouter un écran au gestionnaire
			//
			getListe_ecrans().add(ecran);
		}

		// ---											Méthode nombreAfficheur
		//
		public int nombreAfficheur() {

			return getListe_afficheurs().getListe_nomA().size();
		}

		// ---											Méthode nombreEcran
		//
		public int nombreEcran() {

			return getListe_ecrans().size();
		}

		// ---											Méthode afficherAfficheurs
		//
		public String afficherAfficheurs() {

			return getListe_afficheurs().toString();
		}

		// ---											Méthode afficherEcrans
		//
		public String afficherEcrans() {

			return getListe_ecrans().toString();
		}

		// ---											Méthode toString
		//
		public String afficherGestionnaire() {

			return "GestionnaireEcrans [listEcran=" + liste_ecrans + ", listAfficheur=" + liste_afficheurs + "]";
		}

	// ---								Méthode getSite
	//
	/**
	 * Gets the site.
	 *
	 * @param numero the numero
	 * @return the site
	 */
	public Site getSite(int numero) {

		// Recuperer un site par rapport à sa place dans la liste de site du gestionnaire
		//
		return this.getListe_site().get(numero);
	}

	// ---								Méthode isVide
	//
	/**
	 * Checks if is vide.
	 *
	 * @return true, if is vide
	 */
	public boolean isVide() {

		// Indique si le gestionnaire n'a pas de site
		//
		return nombreSite() == 0;
	}

	// ---								Méthode nombreSite
	//
	/**
	 * Nombre site.
	 *
	 * @return the int
	 */
	public int nombreSite() {

		// Recuperer la taille du gestionnaire
		//
		return this.getListe_site().size();
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

		// Remplir le resultat avec la visualisation de l'état de chaque écran par site
		//
		for(int i = 0; i < nombreSite(); i++) {

			// Déclarer le site cible de la boucle
			//
			Site cible = getSite(i);

			// Ajouter la visualisation de l'état de l'écran au resultat
			//
			resultat += cible.visualiserEtat();
		}

		// Renvoyer la visualisation de l'état des écran du gestionnaire par site
		//
		return resultat;
	}

	// ---								Méthode consulterReserve
	//
	/**
	 * Consulter reserve.
	 *
	 * @return the array list
	 */
	public ArrayList<Ecran> consulterReserve() {

		// Obtenir la liste d'écran du gestionnaire
		//
		return getReserve().getListe_Ecrans();
	}

	// ---								Méthode ajouterSite
	//
	/**
	 * Ajouter site.
	 *
	 * @param site the site
	 */
	public void ajouterSite(Site site){

		// Ajouter le site à la liste de site du gestionnaire
		//
		getListe_site().add(site);
	}

	// ---								Méthode effacerSite
	//
	/**
	 * Effacer site.
	 *
	 * @param site the site
	 * @return true, if successful
	 */
	public boolean effacerSite(Site site){

		// Verifier si le site est vide
		//
		if(!site.isVide()) {

			// Déplacer les écrans vers la reserve si il en reste
			//
			if(!deplacerVersReserve(site)) return false;

			// Si la liste d'écran du site n'est pas vide
			//
			if(site.enleverToutEcran()) return false;
		}

		// Détruire tous les attribut du site
		//
		site.setNom(null);
		site.setLocalisation(null);

		// Effacer le site de la liste de site du gestionnaire
		//
		return supprimerSite(site);
	}

	// ---								Méthode supprimerSite
	//
	/**
	 * Supprimer site.
	 *
	 * @param site the site
	 * @return true, if successful
	 */
	public boolean supprimerSite(Site site) {

		// Effacer le site de la liste de site du gestionnaire
		//
		return getListe_site().remove(site);
	}

	// ---								Méthode deplacerToutEcrans
	//
	/**
	 * Deplacer tout ecrans.
	 *
	 * @param ancien_site the ancien_site
	 * @param nouveau_site the nouveau_site
	 * @return true, if successful
	 */
	public boolean deplacerToutEcrans(Site ancien_site, Site nouveau_site) {

		// Déplacer chaque écrans de la liste vers un nouveau site
		//
		for(int i = 0; i < ancien_site.nombreEcran(); i++){

			// Ecran numero "i" de la liste de l'ancien site
			//
			Ecran cible = ancien_site.getEcran(i);

			// Déplacer l'écran vers le nouveau site
			//
			if(deplacerEcran(cible, nouveau_site)) continue;

			// Renvoi true si echec
			//
			else return false;
		}

		// Renvoi true si succes
		//
		return true;
	}

	// ---								Méthode deplacerVersReserve
	//
	/**
	 * Deplacer vers reserve.
	 *
	 * @param ancien_site the ancien_site
	 * @return true, if successful
	 */
	public boolean deplacerVersReserve(Site ancien_site) {

		// Déplacer chaque écrans de la liste vers la reserve
		//
		return deplacerToutEcrans(ancien_site, getReserve());
	}

	// --- 								Méthode deplacerEcran
	//
	/**
	 * Deplacer ecran.
	 *
	 * @param ecran the ecran
	 * @param nouveau_site the nouveau_site
	 * @return true, if successful
	 */
	public boolean deplacerEcran(Ecran ecran, Site nouveau_site) {

		// Recuperer le site actuel de l'écran
		//
		Site ancien_site = ecran.getSite();

		// Vérifier si le site de départ n'est pas vide
		//
		if(ancien_site.isVide()) return false;

		// Comparer les sites de départ et d'arrivé
		//
		if(ancien_site == nouveau_site) return false;

		// Enlever l'écran à son site
		//
		if(ancien_site.enleverEcran(ecran))
		{
			// Ajouter l'écran à son nouveau site
			//
			nouveau_site.ajouterEcran(ecran);

			// Modifier le site de l'écran
			//
			ecran.setSite(nouveau_site);

			// Attribuer une nouvelle position null à l'écran
			//
			ecran.setPosition(null);

			// Renvoi true si succes
			//
			return true;
		}
		else

			// Renvoi false si echec
			//
			return false;
	}

	// ---								Méthode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return "Gestionnaire [ Site = [" + getListe_site().toString() + "] ]";
	}

}
