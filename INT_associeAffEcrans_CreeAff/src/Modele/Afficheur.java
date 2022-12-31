package Modele;

public class Afficheur {

	// ---											Attributs
	//
	private String nom;
	private StockZone liste_zones;
	private Style style;
	private Dimension dimension_ecran;
	private Dimension dimension_afficheur;
	private StockStyle liste_styles;
	private StockAfficheur liste_afficheurs;
	private String auteur;

	// ---											Constructeur normal 1
	//
	public Afficheur(String nom, Dimension dimension_ecran, String auteur, StockZone liste_zones, StockStyle liste_styles, StockAfficheur liste_afficheur) {

		// Nommer l'afficheur
		//
		this.nom = nom;

		// Nommer l'auteur
		//
		this.auteur = auteur;

		// Un afficheur est d�di� � une taille d'�cran donn�e
		//
		this.dimension_ecran = dimension_ecran;

		// Les zones doivent rester dans la taille de l'�cran
		//
		gererListeZone(liste_zones);

		// Associer une liste de zones
		//
		this.liste_zones = liste_zones;

		// Placer les zones
		//
		placerZone(liste_zones);

		// Associer une liste de styles
		//
		this.liste_styles = liste_styles;

		// Pour ajouter le style neutre
		//
		this.setStyle_liste("Basic");

		// Associer une liste d'afficheur
		//
		this.liste_afficheurs = liste_afficheur;

		// Pour ajouter l'afficheur � liste d'afficheur
		//
		this.liste_afficheurs.ajouterAfficheur(this);
	}

	// ---											Constructeur normal 2
	//
	public Afficheur(String nom, Dimension dimension_ecran, String auteur, Style style, StockZone liste_zones, StockAfficheur liste_afficheur) {

		// Nommer l'afficheur
		//
		this.nom = nom;

		// Nommer l'auteur
		//
		this.auteur = auteur;

		// Un afficheur est d�di� � une taille d'�cran donn�e
		//
		this.dimension_ecran = dimension_ecran;

		// Les zones doivent rester dans la taille de l'�cran
		//
		gererListeZone(liste_zones);

		// Associer une liste de zones
		//
		this.liste_zones = liste_zones;

		// Placer les zones
		//
		placerZone(liste_zones);

		// Ajouter le style
		//
		this.style = style;

		// Associer une liste d'afficheur
		//
		this.liste_afficheurs = liste_afficheur;

		// Pour ajouter l'afficheur � liste d'afficheur
		//
		this.liste_afficheurs.ajouterAfficheur(this);
	}

	// ---											Getter & Setter
	//
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public StockZone getListe_zones() {
		return this.liste_zones;
	}

	public void setListe_zones(StockZone liste_zones) {
		this.liste_zones = liste_zones;
	}

	public Style getStyle() {
		return this.style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Dimension getDimension() {
		return dimension_ecran;
	}

	public void setDimension(Dimension dimension) {
		this.dimension_ecran = dimension;
	}

	public StockStyle getListe_styles() {
		return liste_styles;
	}

	public void setListe_styles(StockStyle liste_styles) {
		this.liste_styles = liste_styles;
	}

	public StockAfficheur getListe_afficheurs() {
		return liste_afficheurs;
	}

	public void setListe_afficheurs(StockAfficheur liste_afficheurs) {
		this.liste_afficheurs = liste_afficheurs;
	}

	public Style getStyle_liste(String nom_style) {

		// Recup�rer un Style a partir de son nom
		//
		return getListe_styles().getStyle(nom_style);
	}

	public void setStyle_liste(String nom_style) {

		// Choisir le style
		//
		Style nouveau_style = getStyle_liste(nom_style);

		// Modifier le style
		//
		this.setStyle(nouveau_style);
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Dimension getDimension_afficheur() {
		return dimension_afficheur;
	}

	public void setDimension_afficheur(Dimension dimension_afficheur) {
		this.dimension_afficheur = dimension_afficheur;
	}

	public Dimension getDimension(int numero) {

		// Obtenir la dimension d'une zone de la liste actuelle
		//
		return getZone(numero).getDimension();
	}

	public Dimension getDimension(StockZone liste_zones, int numero) {

		// Obtenir la dimension d'une zone d'une liste exterieure
		//
		return getZone(liste_zones, numero).getDimension();
	}

	public Zone getZone(int numero) {

		// Obtenir une zone de la liste actuelle
		//
		return getListe_zones().getZone(numero);
	}

	public Zone getZone(StockZone liste_zones, int numero) {

		// Obtenir une zone d'une liste exterieure
		//
		return liste_zones.getZone(numero);
	}

	// ---											M�thode supprimerZone
	//
	public void supprimerZone(StockZone liste_zones, int numero) {

		liste_zones.getListe_nomZ().remove(liste_zones.getZone(numero));
	}

	// ---											M�thode gererListeZone
	//
	public void gererListeZone(StockZone liste_zones) {

		// Un afficheur est d�di� � une taille d'�cran donn�e
		//
		float largeur_ecran = getDimension().getWidth();

		// Parcourir la liste de zones
		//
		for(int i = 0; i < liste_zones.nombreNom(); i++) { 

			// Les zones doivent rester dans la taille de l'�cran
			//
			if(largeur_ecran < getDimension(liste_zones, i).getWidth())

				// Supprimer la zone de dimension superieur � l'�cran
				//
				supprimerZone(liste_zones, i);
		}
	}

	// ---											M�thode placerZone
	//
	public boolean placerZone() {

		// Le d�coupage est r�alis� relativement � une taille d'�cran donn�e
		//
		float largeur_ecran = getDimension().getWidth();

		// D�clarer une taille de base
		//
		float largeur_listeZ = 0;

		// D�clarer une taille de base
		//
		float hauteur_listeZ = getDimension(0).getHeight();

		// Parcourir la liste de zones
		//
		for(int i = 0; i < getListe_zones().nombreNom(); i++) {

			// Seule une zone d'alerte peut chevaucher d'autres zones.
			//
			if(!getZone(i).isAlerte())

				// Ajouter � la taille de base la taille de la zone
				//
				largeur_listeZ += getDimension(i).getWidth();

			// Definir la hauteur maximum de l'afficheur
			//
			if(getDimension(i).getHeight() > hauteur_listeZ)

				// Redefinir la hauteur
				//
				hauteur_listeZ = getDimension(i).getHeight();
		}

		// Definir la dimension de l'afficheur
		//
		Dimension dimension_afficheur = new Dimension(largeur_listeZ, hauteur_listeZ);

		// Modifier la dimension de l'afficheur
		//
		setDimension_afficheur(dimension_afficheur);

		// Les zones doivent rester dans la taille de l'�cran
		//
		return largeur_listeZ < largeur_ecran;
	}

	// ---											M�thode placerZone
	//
	public boolean placerZone(StockZone liste_zones) {

		// Le d�coupage est r�alis� relativement � une taille d'�cran donn�e
		//
		float largeur_ecran = getDimension().getWidth();

		// D�clarer une taille de base
		//
		float largeur_listeZ = 0;

		// D�clarer une taille de base
		//
		float hauteur_listeZ = getDimension(0).getHeight();

		// Parcourir la liste de zones
		//
		for(int i = 0; i < liste_zones.nombreNom(); i++) {

			// Seule une zone d'alerte peut chevaucher d'autres zones.
			//
			if(!getZone(liste_zones, i).isAlerte())

				// Ajouter � la taille de base la taille de la zone
				//
				largeur_listeZ += getDimension(liste_zones, i).getWidth();
			
			// Definir la hauteur maximum de l'afficheur
			//
			if(liste_zones.getZone(i).getDimension().getHeight() > hauteur_listeZ)

				// Redefinir la hauteur
				//
				hauteur_listeZ = liste_zones.getZone(i).getDimension().getHeight();
		}

		// Definir la dimension de l'afficheur
		//
		Dimension dimension_afficheur = new Dimension(largeur_listeZ, hauteur_listeZ);

		// Modifier la dimension de l'afficheur
		//
		setDimension_afficheur(dimension_afficheur);

		// Les zones doivent rester dans la taille de l'�cran
		//
		return largeur_listeZ < largeur_ecran;
	}

	// ---											M�thode afficherDimensionE
	//
	public String afficherDimensionE() {

		// Afficher la taille de l'�cran d�di�
		//
		return getDimension().toString();
	}

	// ---											M�thode afficherDimensionA
	//
	public String afficherDimensionA() {

		// Afficher la taille de l'�cran d�di�
		//
		return getDimension_afficheur().toString();
	}

	// ---											M�thode toString
	//
	public String toString() {

		return "Afficheur " + getNom() + " [ " + afficherDimensionA() + ", " + getStyle().toString() + ", " + getListe_zones().toString() + " ]";
	}
}