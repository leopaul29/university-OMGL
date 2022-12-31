package Modele;

public class Afficheur {

	// ---											Attributs
	//
	private String nom;
	private StockZone liste_zones;
	private Style style;
	private Dimension dimension;
	private StockStyle liste_styles;
	private StockAfficheur liste_afficheurs;

	// ---			 Constructeur par défaut
	//
	public Afficheur() {
		
		this.nom = "afficheur par defaut";
		
		this.liste_zones = new StockZone();
		
		this.style = new Style("Basic");
		
		this.dimension = new Dimension(1300, 800);
	}
	
	// ---											Constructeur normal 1
	//
	public Afficheur(String nom, Dimension dimension_ecran, StockZone liste_zones, StockStyle liste_styles, StockAfficheur liste_afficheur) {

		// Nommer l'afficheur
		//
		this.nom = nom;

		// Un afficheur est dédié à une taille d'écran donnée
		//
		this.dimension = dimension_ecran;

		// Les zones doivent rester dans la taille de l'écran
		//
		gererListeZone(liste_zones);

		// Associer une liste de zones
		//
		this.liste_zones = liste_zones;

		// Associer une liste de styles
		//
		this.liste_styles = liste_styles;

		// Pour ajouter le style neutre
		//
		this.setStyle_liste("Basic");

		// Associer une liste d'afficheur
		//
		this.liste_afficheurs = liste_afficheur;

		// Pour ajouter l'afficheur à liste d'afficheur
		//
		this.liste_afficheurs.ajouterAfficheur(this);
	}

	// ---											Constructeur normal 2
	//
	public Afficheur(String nom, Dimension dimension_ecran, Style style, StockZone liste_zones, StockAfficheur liste_afficheur) {

		// Nommer l'afficheur
		//
		this.nom = nom;

		// Un afficheur est dédié à une taille d'écran donnée
		//
		this.dimension = dimension_ecran;

		// Les zones doivent rester dans la taille de l'écran
		//
		gererListeZone(liste_zones);

		// Associer une liste de zones
		//
		this.liste_zones = liste_zones;

		// Ajouter le style
		//
		this.style = style;

		// Associer une liste d'afficheur
		//
		this.liste_afficheurs = liste_afficheur;

		// Pour ajouter l'afficheur à liste d'afficheur
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
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
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

		// Recupérer un Style a partir de son nom
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

	// ---											Méthode supprimerZone
	//
	public void supprimerZone(StockZone liste_zones, int numero) {

		liste_zones.getListe_nomZ().remove(liste_zones.getZone(numero));
	}

	// ---											Méthode gererListeZone
	//
	public void gererListeZone(StockZone liste_zones) {

		// Un afficheur est dédié à une taille d'écran donnée
		//
		float largeur_ecran = getDimension().getWidth();

		// Parcourir la liste de zones
		//
		for(int i = 0; i < liste_zones.nombreNom(); i++) { 

			// Les zones doivent rester dans la taille de l'écran
			//
			if(largeur_ecran < getDimension(liste_zones, i).getWidth())

				// Supprimer la zone de dimension superieur à l'écran
				//
				supprimerZone(liste_zones, i);
		}
	}

	// ---											Méthode placerZone
	//
	public boolean placerZone() {

		// Le découpage est réalisé relativement à une taille d'écran donnée
		//
		float largeur_ecran = getDimension().getWidth();

		// Déclarer une taille de base
		//
		float largeur_listeZ = 0;

		// Parcourir la liste de zones
		//
		for(int i = 0; i < getListe_zones().nombreNom(); i++) {

			// Seule une zone d'alerte peut chevaucher d'autres zones.
			//
			if(!getZone(i).isAlerte())

				// Ajouter à la taille de base la taille de la zone
				//
				largeur_listeZ += getDimension(i).getWidth();
		}

		// Les zones doivent rester dans la taille de l'écran
		//
		return largeur_listeZ < largeur_ecran;
	}

	// ---											Méthode placerZone
	//
	public boolean placerZone(StockZone liste_zones) {

		// Le découpage est réalisé relativement à une taille d'écran donnée
		//
		float largeur_ecran = getDimension().getWidth();

		// Déclarer une taille de base
		//
		float largeur_listeZ = 0;

		// Parcourir la liste de zones
		//
		for(int i = 0; i < liste_zones.nombreNom(); i++) {

			// Seule une zone d'alerte peut chevaucher d'autres zones.
			//
			if(!getZone(liste_zones, i).isAlerte())

				// Ajouter à la taille de base la taille de la zone
				//
				largeur_listeZ += getDimension(liste_zones, i).getWidth();
		}

		// Les zones doivent rester dans la taille de l'écran
		//
		return largeur_listeZ < largeur_ecran;
	}

	// ---											Méthode afficherDimension
	//
	public String afficherDimension() {

		// Afficher la taille de l'écran dédié
		//
		return getDimension().toString();
	}

	// ---											Méthode toString
	//
	public String toString() {

		return "Afficheur " + getNom() + " [ " + getDimension().toString() + ", " + getStyle().toString() + ", " + getListe_zones().toString() + " ]";
	}
}