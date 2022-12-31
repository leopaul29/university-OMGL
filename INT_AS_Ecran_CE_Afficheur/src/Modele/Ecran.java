package Modele;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Ecran.
 * Class qui permet de cr�er et de modifier un �cran ses caract�ristiques.
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
 * Ecran(Site site, String position, String nom)	Cr�er un �cran
 * 
 * --- Getter & Setter :
 * getNom						Obtenir le nom d'un �cran
 * setNom						Changer le nom d'un �cran
 * getPosition					Obtenir la position d'un �cran
 * setPosition					Changer la position d'un �cran
 * getSite						Obtenir le site d'un �cran
 * setSite						Changer le site d'un �cran
 * getEtat						Obtenir l'�tat d'un �cran
 * setEtat						Changer l'�tat d'un �cran
 * getMockErreur				Obtenir les erreurs
 * isErreur						Savoir si l'�cran a des erreurs
 * setErreur					Changer la valeur de erreur(boolean)
 * getListe_erreur				Obtenir la liste d'erreurs
 * isEteint						Savoir si l'�cran est eteint
 * setEteint					Changer la valeur de eteint(boolean)
 * getEteintPar					Savoir par qui a �tait eteint l'�cran la derni�re fois
 * setEteintPar					Changer la personne qui a eteint l'�cran
 * 
 * --- M�thodes / R�le :
 * consulterErreur()								Afficher les erreurs d'un �cran
 * nombreErreur()									Afficher le nombre d'erreur d'un �cran
 * eteindreEcran(String nomPersonne)				Eteindre un �cran
 * visualiseEtat()									Afficher l'�tat d'un �cran
 * toString()										Afficher un �cran
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

		// Ajouter l'�cran au gestionnaire
		//
		gestionnaire.ajouterEcran(this);

		// D�clarer des �crans par leur nom, le site auquel ils se rattachent, leur position 
		//
		this.nom = nom;
		this.position = position;
		this.site = site;

		// Ajouter l'�cran au site
		//
		(this.site).ajouterEcran(this);

		// Etat de l'�cran
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

		// Ajouter l'�cran au gestionnaire
		//
		gestionnaire.ajouterEcran(this);

		// D�clarer des �crans par leur nom, le site auquel ils se rattachent, leur position 
		//
		this.nom = nom;
		this.position = position;
		this.site = site;

		// Ajouter l'�cran au site
		//
		(this.site).ajouterEcran(this);

		// Etat de l'�cran
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
			this.setEtat("erreurs lev�es");
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

	// ---								M�thode consulterErreur
	//
	/**
	 * Consulter erreur.
	 *
	 * @return the string
	 */
	public String consulterErreur() {

		return getListe_Erreur().toString();
	}

	// ---								M�thode nombreErreur
	//
	/**
	 * Nombre erreur.
	 *
	 * @return the int
	 */
	public int nombreErreur() {

		// Recuperer la taille de la liste d'erreurs de l'�cran
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

	// ---								M�thode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[ nom = " + this.getNom()
				+ ", site = " + this.getSite().getNom()
				+ ", position = " + this.getPosition() 
				+ ", �tat = " + this.getEtat()
				+ ", erreurs lev�es = " + this.consulterErreur()
				+ ", �teint = "+ this.isEteint()
				+ ", �teint par = " + this.getEteintPar()
				+ ", dimension = " + getDimension() 
				+ ", afficheur = " + getAfficheur() + " ]";
	}

	// ---								M�thode eteindreEcran
	//
	/**
	 * Eteindre ecran.
	 *
	 * @param nomPersonne the nom personne
	 * @return true, if successful
	 */
	public boolean eteindreEcran(String nomPersonne) {

		// V�rifier que l'�cran n'est pas �teint
		//
		if(isEteint() == true) return false;

		// Changer � true l'�tat eteint de l'�cran
		//
		setEteint(true);

		// Changer la valeur de la personne qui a eteint l'�cran
		//
		setEteintPar(nomPersonne);

		// L'�cran est maintenant �teint
		//
		return true;
	}

	// ---								M�thode afficherEtat
	//
	/**
	 * Visualiser etat.
	 *
	 * @return the string
	 */
	public String visualiserEtat() {

		return "[ " + this.getNom() + " - " + this.getEtat() + " ]";
	}

	// ---											M�thode possederAfficheur
	//
	public boolean possederAfficheur() {

		return getAfficheur() != null;
	}
	// ---											M�thode afficherDimension
	//
	public String afficherDimension() {

		// Obtenir la dimension
		//
		return getDimension().toString();
	}

	// ---											M�thode setAfficheurComp
	//
	public boolean setAfficheurComp(Afficheur afficheur) {

		// Obtenir la dimension de l'�cran
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