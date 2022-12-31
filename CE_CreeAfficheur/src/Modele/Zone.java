package Modele;

public class Zone {

	// ---											Attributs
	//
	private String nom;
	private Object source_information;
	private boolean type_text;
	private boolean type_bloc;
	private boolean alerte;
	private Dimension dimension;

	// ---											Constructeur normal
	//
	public Zone(String nom, Dimension dimension, Object source_information, StockZone stock_Zone) {

		// Une zone est nommée
		//
		this.nom = nom;

		// Associer une dimension à la zone
		//
		this.dimension = dimension;

		// Associer une source d'information
		//
		this.source_information = source_information;
		
		// Définir que la zone n'est pas une zone d'alerte
		//
		this.setAlerte(false);
		
		// Ajouter la zone au stock de zones
		//
		stock_Zone.ajouterZone(this);
	}

	// ---											Getter & Setter
	//
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Object getSource_information() {
		return source_information;
	}

	public void setSource_information(Object source_information) {
		this.source_information = source_information;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public boolean isType_text() {
		return type_text;
	}

	public void setType_text(boolean type_text) {
		this.type_text = type_text;
	}

	public boolean isType_bloc() {
		return type_bloc;
	}

	public void setType_bloc(boolean type_bloc) {
		this.type_bloc = type_bloc;
	}

	public boolean isAlerte() {
		return alerte;
	}

	public void setAlerte(boolean alerte) {
		this.alerte = alerte;
	}

	// ---											Méthode definirType
	//
	public void definirType(boolean type_text) {

		// Définir le type de la zone
		//
		if(type_text == true) { 
			setType_text(true);
			setType_bloc(false);
		}
		else {
			setType_text(false);
			setType_bloc(true);
		}
	}

	// ---											Méthode afficherType
	//
	public String afficherType() {

		// Déclarer un resultat
		//
		String resultat = "";

		// Dire que c'est une zone de bloc
		//
		if(isType_bloc() == true) resultat = "Bloc";

		// Dire que c'est une zone de text
		//
		if(isType_text() == true) resultat = "Text";
		
		// Dire que c'est une zone d'alerte
		//
		if(isAlerte() == true) resultat += "Alerte";

		// Renvoyer le resultat
		//
		return resultat;
	}
	
	// ---											Méthode afficherDim
	//
	public String afficherDim() {

		// Afficher la dimension de la zone
		//
		return getDimension().toString();
	}

	// ---											Méthode toString
	//
	public String toString() {
		
		return "Zone " + afficherType() + " : " + getNom() + " [ " + afficherDim() + ", " + getSource_information() + " ]";
	}
}