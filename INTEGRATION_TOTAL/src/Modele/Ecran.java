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
			this.setEtat("erreurs levées");
		else
			this.setEtat("en marche");
	}

	public ArrayList<String> getListe_Erreur() {
		return getMockErreur().getList_Erreur();
	}

	// ---								Méthode consulterErreur
	//
	public String consulterErreur(Connexion connexion) {
		
		String role = connexion.getPersonne().getRole();

		if(role != "AS") return null;
		
		new Action(connexion, "consulter les erreurs levées par l'écran " + this.getNom());

		return getListe_Erreur().toString();
	}

	// ---								Méthode nombreErreur
	//
	public int nombreErreur() {

		// Recuperer la taille de la liste d'erreurs de l'écran
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
		
		new Action(connexion, "Savoir par qui a était éteint l'écran " + this.getNom());
		
		return this.eteintPar;
	}

	public void setEteintPar(String eteintPar) {
		this.eteintPar = eteintPar;
	}

	// ---								Méthode toString
	//
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(Connexion connexion) {
		return "[ nom = " + this.getNom()
				+ ", site = " + this.getSite().getNom()
				+ ", position = " + this.getPosition() 
				+ ", état = " + this.getEtat()
				+ ", erreurs levées = " + this.consulterErreur(connexion)
				+ ", éteint = "+ this.isEteint()
				+ ", éteint par = " + this.getEteintPar(connexion)
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
	public boolean eteindreEcran(Connexion connexion) {

		String role = connexion.getPersonne().getRole();

		if(role != "AS") return false;

		// Vérifier que l'écran n'est pas éteint
		//
		if(isEteint() == true) return false;

		new Action(connexion, "Eteindre l'écran " + this.getNom());

		// Changer à true l'état eteint de l'écran
		//
		setEteint(true);

		// Changer la valeur de la personne qui a eteint l'écran
		//
		String nomPersonne = connexion.getPersonne().getNom();
		
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
	public String visualiserEtat(Connexion connexion) {

		String role = connexion.getPersonne().getRole();

		if(role != "AS") return null;

		new Action(connexion, "Visualiser l'etat de l'écran " + this.getNom());

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