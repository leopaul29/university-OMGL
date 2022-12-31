package Modele;

public class Ecran {

	// ---											Attributs
	//
	private String nom;
	private Dimension dimension;
	private Afficheur afficheur;

	// ---											Constructeur normal 1
	//
	public Ecran(String nom, Dimension dimension, GestionnaireEcrans gestionnaire){

		// Nommer l'�cran
		//
		this.nom = nom;

		// Attribuer une dimension
		//
		this.dimension = dimension;

		// Ajouter l'�cran au gestionnaire
		//
		gestionnaire.ajouterEcran(this);
	}

	// ---											Constructeur normal 2
	//
	public Ecran(String nom, Dimension dimension, Afficheur afficheur, GestionnaireEcrans gestionnaire){

		// Nommer l'�cran
		//
		this.nom = nom;

		// Attribuer une dimension
		//
		this.dimension = dimension;
		
		// Ajouter afficheur si la dimension est la meme
		//
		this.setAfficheurComp(afficheur);
		
		// Ajouter l'�cran au gestionnaire
		//
		gestionnaire.ajouterEcran(this);
	}	

	// ---											Getter & Setter
	//
	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Afficheur getAfficheur() {
		return afficheur;
	}

	private void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
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

	// ---											M�thode toString
	//
	public String toString() {
		
		return "Ecran [ nom = " + getNom() + ", dimension = " + getDimension() + ", afficheur = " + getAfficheur() + " ]";
	}
}