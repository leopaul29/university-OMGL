package Modele;

import java.util.ArrayList;

import Modele.Ecran;

// TODO: Auto-generated Javadoc
/**
 * The Class Gestionnaire.
 * Class qui permet de g�rer tous les �crans par le biais de site.
 * 
 * --- Attributs :
 * liste_site :					ArrayList
 * reserve :					Site
 * 
 * --- Constructeur :
 * Gestionnaire()				Cr�er un gestionnaire
 * 
 * --- Getter & Setter :
 * getListe_site				Obtenir la liste de sites
 * setListe_site				Changer la liste de sites
 * getReserve					Obtenir la reserve
 * setReserve					Changer la reserve
 * getSite						Obtenir un site de la liste
 * isVide						Savoir si la liste de sites est vide
 * 
 * --- M�thodes :
 * nombreSite()											Afficher le nombre de site que contient le gestionnaire	
 * visualiserEtat()										Afficher les �tats de chaque �crans
 * consulterReserve()									Afficher le contenu de la reserve
 * ajouterSite(Site site)								Ajouter un site au gestionnaire
 * effacerSite(Site site)								Effacer un site du gestionnaire en deplacent tous les �crans restant vers la reserve
 * supprimerSite(Site site)								Effacer un site de la liste de sites du gestionnaire
 * deplacerToutEcran(ancien_site, Site nouveau_site)	D�placer tous les �crans d'un site vers un autre site				
 * deplacerVersReserve(Site ancien_site)				D�placer tous les �crans d'un site vers la reserve
 * deplacerEcran(Ecran ecran, Site site)				D�placer un �cran vers un autre site
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

	// ---								Constructeur par d�faut
	//
	/**
	 * Instantiates a new gestionnaire.
	 */
	public Gestionnaire(StockAfficheur liste_afficheurs){

		// Cr�er une liste d'�crans
		//
		this.liste_ecrans = new ArrayList<Ecran>();

		// Cr�er une liste d'afficheur
		//
		this.liste_afficheurs = liste_afficheurs;

		// Cr�er une liste de sites
		//
		this.liste_site = new ArrayList<Site>();

		// D�clarer la reserve
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
		public String afficherGestionnaire() {

			return "GestionnaireEcrans [listEcran=" + liste_ecrans + ", listAfficheur=" + liste_afficheurs + "]";
		}

	// ---								M�thode getSite
	//
	/**
	 * Gets the site.
	 *
	 * @param numero the numero
	 * @return the site
	 */
	public Site getSite(int numero) {

		// Recuperer un site par rapport � sa place dans la liste de site du gestionnaire
		//
		return this.getListe_site().get(numero);
	}

	// ---								M�thode isVide
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

	// ---								M�thode nombreSite
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

		// Remplir le resultat avec la visualisation de l'�tat de chaque �cran par site
		//
		for(int i = 0; i < nombreSite(); i++) {

			// D�clarer le site cible de la boucle
			//
			Site cible = getSite(i);

			// Ajouter la visualisation de l'�tat de l'�cran au resultat
			//
			resultat += cible.visualiserEtat();
		}

		// Renvoyer la visualisation de l'�tat des �cran du gestionnaire par site
		//
		return resultat;
	}

	// ---								M�thode consulterReserve
	//
	/**
	 * Consulter reserve.
	 *
	 * @return the array list
	 */
	public ArrayList<Ecran> consulterReserve() {

		// Obtenir la liste d'�cran du gestionnaire
		//
		return getReserve().getListe_Ecrans();
	}

	// ---								M�thode ajouterSite
	//
	/**
	 * Ajouter site.
	 *
	 * @param site the site
	 */
	public void ajouterSite(Site site){

		// Ajouter le site � la liste de site du gestionnaire
		//
		getListe_site().add(site);
	}

	// ---								M�thode effacerSite
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

			// D�placer les �crans vers la reserve si il en reste
			//
			if(!deplacerVersReserve(site)) return false;

			// Si la liste d'�cran du site n'est pas vide
			//
			if(site.enleverToutEcran()) return false;
		}

		// D�truire tous les attribut du site
		//
		site.setNom(null);
		site.setLocalisation(null);

		// Effacer le site de la liste de site du gestionnaire
		//
		return supprimerSite(site);
	}

	// ---								M�thode supprimerSite
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

	// ---								M�thode deplacerToutEcrans
	//
	/**
	 * Deplacer tout ecrans.
	 *
	 * @param ancien_site the ancien_site
	 * @param nouveau_site the nouveau_site
	 * @return true, if successful
	 */
	public boolean deplacerToutEcrans(Site ancien_site, Site nouveau_site) {

		// D�placer chaque �crans de la liste vers un nouveau site
		//
		for(int i = 0; i < ancien_site.nombreEcran(); i++){

			// Ecran numero "i" de la liste de l'ancien site
			//
			Ecran cible = ancien_site.getEcran(i);

			// D�placer l'�cran vers le nouveau site
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

	// ---								M�thode deplacerVersReserve
	//
	/**
	 * Deplacer vers reserve.
	 *
	 * @param ancien_site the ancien_site
	 * @return true, if successful
	 */
	public boolean deplacerVersReserve(Site ancien_site) {

		// D�placer chaque �crans de la liste vers la reserve
		//
		return deplacerToutEcrans(ancien_site, getReserve());
	}

	// --- 								M�thode deplacerEcran
	//
	/**
	 * Deplacer ecran.
	 *
	 * @param ecran the ecran
	 * @param nouveau_site the nouveau_site
	 * @return true, if successful
	 */
	public boolean deplacerEcran(Ecran ecran, Site nouveau_site) {

		// Recuperer le site actuel de l'�cran
		//
		Site ancien_site = ecran.getSite();

		// V�rifier si le site de d�part n'est pas vide
		//
		if(ancien_site.isVide()) return false;

		// Comparer les sites de d�part et d'arriv�
		//
		if(ancien_site == nouveau_site) return false;

		// Enlever l'�cran � son site
		//
		if(ancien_site.enleverEcran(ecran))
		{
			// Ajouter l'�cran � son nouveau site
			//
			nouveau_site.ajouterEcran(ecran);

			// Modifier le site de l'�cran
			//
			ecran.setSite(nouveau_site);

			// Attribuer une nouvelle position null � l'�cran
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

	// ---								M�thode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		
		return "Gestionnaire [ Site = [" + getListe_site().toString() + "] ]";
	}

}
