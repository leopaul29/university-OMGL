package Modele;

import java.util.ArrayList;

public class Ecran {

	// ---								Attributs
	//

	// ---							Attributs AS_ControleEcran
	private String 			etat;
	private MockErreur 		mockErreur;
	private boolean			erreur;
	private boolean 		eteint;
	private String 			eteintPar;
	private String 			nom;
	private String 			position;
	private Site 			site;
	private Dimension dimension;
	private Afficheur afficheur;

	// ---								Constructeur par defaut
	//
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
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Site getSite() {
		return this.site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	// --- 							Accesseur AS_ControleEcrans
	//
	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	// ---								Gestion des erreurs
	//
	public MockErreur getMockErreur() {
		return this.mockErreur;
	}

	public boolean isErreur() {
		return this.erreur;
	}

	public void setErreur(boolean erreur){

		this.erreur = erreur;

		if(this.erreur == true)
			this.setEtat("erreurs lev�es");
		else
			this.setEtat("en marche");
	}

	public ArrayList<String> getListe_Erreur() {
		return getMockErreur().getList_Erreur();
	}

	// ---								M�thode consulterErreur
	//
	public String consulterErreur(Connexion connexion) {
		
		String role = connexion.getPersonne().getRole();

		if(role != "AS") return null;
		
		new Action(connexion, "consulter les erreurs lev�es par l'�cran " + this.getNom());

		return getListe_Erreur().toString();
	}

	// ---								M�thode nombreErreur
	//
	public int nombreErreur() {

		// Recuperer la taille de la liste d'erreurs de l'�cran
		//
		return this.getListe_Erreur().size();
	}

	// ---								Eteindre
	//
	public boolean isEteint() {
		return this.eteint;
	}

	public void setEteint(boolean eteint) {

		this.eteint = eteint;

		if(this.eteint == true)
			setEtat("eteint");
		else
			setEtat("en marche");
	}

	public String getEteintPar(Connexion connexion) {
		
		String role = connexion.getPersonne().getRole();

		if(role != "AS") return null;
		
		new Action(connexion, "Savoir par qui a �tait �teint l'�cran " + this.getNom());
		
		return this.eteintPar;
	}

	public void setEteintPar(String eteintPar) {
		this.eteintPar = eteintPar;
	}

	// ---								M�thode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(Connexion connexion) {
		return "[ nom = " + this.getNom()
				+ ", site = " + this.getSite().getNom()
				+ ", position = " + this.getPosition() 
				+ ", �tat = " + this.getEtat()
				+ ", erreurs lev�es = " + this.consulterErreur(connexion)
				+ ", �teint = "+ this.isEteint()
				+ ", �teint par = " + this.getEteintPar(connexion)
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
	public boolean eteindreEcran(Connexion connexion) {

		String role = connexion.getPersonne().getRole();

		if(role != "AS") return false;

		// V�rifier que l'�cran n'est pas �teint
		//
		if(isEteint() == true) return false;

		new Action(connexion, "Eteindre l'�cran " + this.getNom());

		// Changer � true l'�tat eteint de l'�cran
		//
		setEteint(true);

		// Changer la valeur de la personne qui a eteint l'�cran
		//
		String nomPersonne = connexion.getPersonne().getNom();
		
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
	public String visualiserEtat(Connexion connexion) {

		String role = connexion.getPersonne().getRole();

		if(role != "AS") return null;

		new Action(connexion, "Visualiser l'etat de l'�cran " + this.getNom());

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