package Modele;

public class Renderer {

	// ---											Attributs
	//
	private String nom;
	private Dimension dimension_min;
	private Dimension dimension_max;
	private Zone zone;
	private Object source_information;
	private Style style;
	private StockStyle liste_style;
	private Afficheur afficheur;

	// ---											Constructeur normal 1
	//
	public Renderer(String nom, Style style, Afficheur afficheur, Dimension dimension_min, Dimension dimension_max, Object source_information, Zone zone, StockRenderers liste_renderers) {

		this.nom = nom;

		this.dimension_min = dimension_min;

		this.dimension_max = dimension_max;

		this.zone = zone;

		this.source_information = source_information;

		this.style = style;

		liste_renderers.ajouterRenderer(this);

		this.afficheur = afficheur;

		ajouterRenderer();
	}

	// ---											Constructeur normal 2
	//
	public Renderer(String nom, StockStyle liste_style, Afficheur afficheur, Dimension dimension_min, Dimension dimension_max, Object source_information, Zone zone, StockRenderers liste_renderers) {

		this.nom = nom;

		this.dimension_min = dimension_min;

		this.dimension_max = dimension_max;

		this.zone = zone;

		this.source_information = source_information;

		// Associer une liste de styles
		//
		this.liste_style = liste_style;

		// Pour ajouter le style neutre
		//
		this.setStyle_liste("Basic");

		liste_renderers.ajouterRenderer(this);

		this.afficheur = afficheur;

		ajouterRenderer();
	}

	// ---											Getter & Setter
	//
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Dimension getDimension_min() {
		return dimension_min;
	}

	public void setDimension_min(Dimension dimension_min) {
		this.dimension_min = dimension_min;
	}

	public Dimension getDimension_max() {
		return dimension_max;
	}

	public void setDimension_max(Dimension dimension_max) {
		this.dimension_max = dimension_max;
	}

	public Object getSource_information() {
		return source_information;
	}

	public void setSource_information(Object source_information) {
		this.source_information = source_information;
	}

	public Afficheur getAfficheur() {
		return afficheur;
	}

	public void setAfficheur(Afficheur afficheur) {
		this.afficheur = afficheur;
	}

	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public StockStyle getListe_style() {
		return liste_style;
	}

	public void setListe_style(StockStyle liste_style) {
		this.liste_style = liste_style;
	}

	public Style getStyle_liste(String nom_style) {

		// Recupérer un Style a partir de son nom
		//
		return getListe_style().getStyle(nom_style);
	}

	public void setStyle_liste(String nom_style) {

		// Choisir le style
		//
		Style nouveau_style = getStyle_liste(nom_style);

		// Modifier le style
		//
		this.setStyle(nouveau_style);
	}

	// ---											Méthode verif_typeZone
	//
	public boolean verif_typeZone() {

		// Savoir si la zone est de type "Bloc"
		//
		return getZone().isType_bloc();
	}

	// ---											Méthode verif_hauteurZone
	//
	public boolean verif_hauteurZone() {

		// Obtenir la hauteur de la zone cible du renderer
		//
		float hauteur_zone = getZone().getDimension().getHeight();

		// Renvoyer si la hauteur de la zone est compris 
		// entre la hauteur min et la hauteur max du renderer
		//
		return hauteur_zone < getDimension_max().getHeight() && hauteur_zone > getDimension_min().getHeight();
	}

	// ---											Méthode verif_largeurZone
	//
	public boolean verif_largeurZone() {

		// Obtenir la largeur de la zone cible du renderer
		//
		float largeur_zone = getZone().getDimension().getWidth();

		// Renvoyer si la largeur de la zone est compris 
		// entre la largeur min et la largeur max du renderer
		//
		return largeur_zone < getDimension_max().getWidth() && largeur_zone > getDimension_min().getWidth();
	}

	// ---											Méthode verif_dimZone
	//
	public boolean verif_dimZone() {

		// Savoir si la taille de la zone est valide pour le renderer
		//
		return verif_hauteurZone() && verif_largeurZone();
	}

	// ---											Méthode verif_style
	//
	public boolean verif_style() {

		// Comparer le style du renderer et celui de l'afficheur de la zone
		//
		return getAfficheur().getStyle().getNom() == getStyle().getNom();
	}

	// ---											Méthode verif_style
	//
	public boolean verif_style(Afficheur afficheur) {

		// Obtenir le style d'un afficheur
		//
		String style_afficheur = afficheur.getStyle().getNom();

		// Comparer le style du renderer et celui de l'afficheur de la zone
		//
		return style_afficheur == getStyle().getNom();
	}

	// ---											Méthode verif_zone
	//
	public boolean verif_zone() {

		// Vérifier si la zone est valide pour le renderer
		//
		return verif_dimZone() && verif_style();
	}

	// ---											Méthode verif_zone
	//
	public boolean verif_zone(Afficheur afficheur) {

		// Vérifier si la zone est valide pour le renderer
		//
		return verif_dimZone() && verif_style(afficheur);
	}

	// ---											Méthode ajouterRenderer
	//
	public void ajouterRenderer() {

		// Si la zone est valide
		//
		if(verif_zone()) 

			// J'ajoute le renderer à la source d'information de la zone cible et validé
			//
			getZone().setSource_information(this);
	}

	// ---											Méthode afficherDimensionMin
	//
	public String afficherDimensionMin() {

		// Afficher la dimension min du renderer
		//
		return getDimension_min().toString();
	}

	// ---											Méthode afficherDimensionMax
	//
	public String afficherDimensionMax() {

		// Afficher la dimension max du renderer
		//
		return getDimension_max().toString();
	}

	// ---											Méthode toString
	//
	public String toString() {

		return "Renderer : " + getNom() + "[ dimension(min) = " + getDimension_min() + ", dimension(max) = " + getDimension_max() + ", Style = " + getStyle() + ", Source = " + getSource_information() + " ]";
	}
}
