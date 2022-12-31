package Modele;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Ecran.
 * Class qui permet de créer et de modifier un écran ses caractéristiques.
 * 
 * --- Attributs / type:
 * etat							String			
 * mockErreur					MockErreur
 * erreur				 		boolean
 * eteint						boolean
 * eteintPar					String
 * nom							String
 * position						String
 * site							Site
 * 
 * --- Constructeurs :
 * Ecran(Site site, String position, String nom)	Créer un écran
 * 
 * --- Getter & Setter :
 * getNom						Obtenir le nom d'un écran
 * setNom						Changer le nom d'un écran
 * getPosition					Obtenir la position d'un écran
 * setPosition					Changer la position d'un écran
 * getSite						Obtenir le site d'un écran
 * setSite						Changer le site d'un écran
 * getEtat						Obtenir l'état d'un écran
 * setEtat						Changer l'état d'un écran
 * getMockErreur				Obtenir les erreurs
 * isErreur						Savoir si l'écran a des erreurs
 * setErreur					Changer la valeur de erreur(boolean)
 * getListe_erreur				Obtenir la liste d'erreurs
 * isEteint						Savoir si l'écran est eteint
 * setEteint					Changer la valeur de eteint(boolean)
 * getEteintPar					Savoir par qui a était eteint l'écran la dernière fois
 * setEteintPar					Changer la personne qui a eteint l'écran
 * 
 * --- Méthodes / Rôle :
 * consulterErreur()								Afficher les erreurs d'un écran
 * nombreErreur()									Afficher le nombre d'erreur d'un écran
 * eteindreEcran(String nomPersonne)				Eteindre un écran
 * visualiseEtat()									Afficher l'état d'un écran
 * toString()										Afficher un écran
 *
 *
 * @author LeoPaul
 */
public class Ecran {

	// ---								Attributs
	//

	// ---							Attributs AS_ControleEcran
	/** The etat. */
	private String 			etat;

	/** The mock erreur. */
	private MockErreur 		mockErreur;

	/** The erreur. */
	private boolean			erreur;

	/** The eteint. */
	private boolean 		eteint;

	/** The eteint par. */
	private String 			eteintPar;

	// ---							Attributs AS_ConOrganiseEcran
	/** The nom. */
	private String 			nom;

	/** The position. */
	private String 			position;

	/** The site. */
	private Site 			site;

	private Dimension dimension;
	private Afficheur afficheur;

	// ---								Constructeur par defaut
	//
	/**
	 * Instantiates a new ecran.
	 *
	 * @param site the site
	 * @param position the position
	 * @param nom the nom
	 */
	public Ecran(Site site, String position, String nom, Dimension dimension, Gestionnaire gestionnaire){

		// Attribuer une dimension
		//
		this.dimension = dimension;

		// Ajouter l'écran au gestionnaire
		//
		gestionnaire.ajouterEcran(this);

		// Déclarer des écrans par leur nom, le site auquel ils se rattachent, leur position 
		//
		this.nom = nom;
		this.position = position;
		this.site = site;

		// Ajouter l'écran au site
		//
		(this.site).ajouterEcran(this);

		// Etat de l'écran
		//
		this.etat = "en marche";
		this.eteint = false;
		this.eteintPar = "Personne";

		// Gestion des erreurs
		//
		this.mockErreur = new MockErreurImpl(this);
		this.erreur = false;
	}

	public Ecran(Site site, String position, String nom, Dimension dimension, Afficheur afficheur, Gestionnaire gestionnaire){

		// Attribuer une dimension
		//
		this.dimension = dimension;

		// Ajouter afficheur si la dimension est la meme
		//
		this.setAfficheurComp(afficheur);

		// Ajouter l'écran au gestionnaire
		//
		gestionnaire.ajouterEcran(this);

		// Déclarer des écrans par leur nom, le site auquel ils se rattachent, leur position 
		//
		this.nom = nom;
		this.position = position;
		this.site = site;

		// Ajouter l'écran au site
		//
		(this.site).ajouterEcran(this);

		// Etat de l'écran
		//
		this.etat = "en marche";
		this.eteint = false;
		this.eteintPar = "Personne";

		// Gestion des erreurs
		//
		this.mockErreur = new MockErreurImpl(this);
		this.erreur = false;
	}

	// ---								Getter & Setter
	//

	// ---							Accesseur INT_CreeAfficheur_AssocieAfficheurEcran_AssocieRenderer
	//
	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Afficheur getAfficheur() {
		return afficheur;
	}

	private void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	// --- 							Accesseur AS_ConOrganisEcrans
	//
	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
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
	 * Gets the position.
	 *
	 * @return the position
	 */
	public String getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * Gets the site.
	 *
	 * @return the site
	 */
	public Site getSite() {
		return this.site;
	}

	/**
	 * Sets the site.
	 *
	 * @param site the new site
	 */
	public void setSite(Site site) {
		this.site = site;
	}

	// --- 							Accesseur AS_ControleEcrans
	//
	/**
	 * Gets the etat.
	 *
	 * @return the etat
	 */
	public String getEtat() {
		return this.etat;
	}

	/**
	 * Sets the etat.
	 *
	 * @param etat the new etat
	 */
	public void setEtat(String etat) {
		this.etat = etat;
	}
	// ---								Gestion des erreurs
	//
	/**
	 * Gets the mock erreur.
	 *
	 * @return the mock erreur
	 */
	public MockErreur getMockErreur() {
		return this.mockErreur;
	}

	/**
	 * Checks if is erreur.
	 *
	 * @return true, if is erreur
	 */
	public boolean isErreur() {
		return this.erreur;
	}

	/**
	 * Sets the erreur.
	 *
	 * @param erreur the new erreur
	 */
	public void setErreur(boolean erreur){

		this.erreur = erreur;

		if(this.erreur == true)
			this.setEtat("erreurs levées");
		else
			this.setEtat("en marche");
	}

	/**
	 * Gets the liste_ erreur.
	 *
	 * @return the liste_ erreur
	 */
	public ArrayList<String> getListe_Erreur() {
		return getMockErreur().getList_Erreur();
	}

	// ---								Méthode consulterErreur
	//
	/**
	 * Consulter erreur.
	 *
	 * @return the string
	 */
	public String consulterErreur() {

		return getListe_Erreur().toString();
	}

	// ---								Méthode nombreErreur
	//
	/**
	 * Nombre erreur.
	 *
	 * @return the int
	 */
	public int nombreErreur() {

		// Recuperer la taille de la liste d'erreurs de l'écran
		//
		return this.getListe_Erreur().size();
	}

	// ---								Eteindre
	//
	/**
	 * Checks if is eteint.
	 *
	 * @return true, if is eteint
	 */
	public boolean isEteint() {
		return this.eteint;
	}

	/**
	 * Sets the eteint.
	 *
	 * @param eteint the new eteint
	 */
	public void setEteint(boolean eteint) {

		this.eteint = eteint;

		if(this.eteint == true)
			setEtat("eteint");
		else
			setEtat("en marche");
	}

	/**
	 * Gets the eteint par.
	 *
	 * @return the eteint par
	 */
	public String getEteintPar() {
		return this.eteintPar;
	}

	/**
	 * Sets the eteint par.
	 *
	 * @param eteintPar the new eteint par
	 */
	public void setEteintPar(String eteintPar) {
		this.eteintPar = eteintPar;
	}

	// ---								Méthode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[ nom = " + this.getNom()
				+ ", site = " + this.getSite().getNom()
				+ ", position = " + this.getPosition() 
				+ ", état = " + this.getEtat()
				+ ", erreurs levées = " + this.consulterErreur()
				+ ", éteint = "+ this.isEteint()
				+ ", éteint par = " + this.getEteintPar()
				+ ", dimension = " + getDimension() 
				+ ", afficheur = " + getAfficheur() + " ]";
	}

	// ---								Méthode eteindreEcran
	//
	/**
	 * Eteindre ecran.
	 *
	 * @param nomPersonne the nom personne
	 * @return true, if successful
	 */
	public boolean eteindreEcran(String nomPersonne) {

		// Vérifier que l'écran n'est pas éteint
		//
		if(isEteint() == true) return false;

		// Changer à true l'état eteint de l'écran
		//
		setEteint(true);

		// Changer la valeur de la personne qui a eteint l'écran
		//
		setEteintPar(nomPersonne);

		// L'écran est maintenant éteint
		//
		return true;
	}

	// ---								Méthode afficherEtat
	//
	/**
	 * Visualiser etat.
	 *
	 * @return the string
	 */
	public String visualiserEtat() {

		return "[ " + this.getNom() + " - " + this.getEtat() + " ]";
	}

	// ---											Méthode possederAfficheur
	//
	public boolean possederAfficheur() {

		return getAfficheur() != null;
	}
	// ---											Méthode afficherDimension
	//
	public String afficherDimension() {

		// Obtenir la dimension
		//
		return getDimension().toString();
	}

	// ---											Méthode setAfficheurComp
	//
	public boolean setAfficheurComp(Afficheur afficheur) {

		// Obtenir la dimension de l'écran
		//
		Dimension dim_ecran = this.getDimension();

		// Obtenir la dimension de l'afficheur
		//
		Dimension dim_afficheur = afficheur.getDimension_afficheur();

		// Comparer les 2 dimension
		//
		if (dim_ecran.equals(dim_afficheur)) {

			// Modifier l'afficheur
			//
			this.setAfficheur(afficheur);

			return true;
		}
		else 
			return false;
	}
}