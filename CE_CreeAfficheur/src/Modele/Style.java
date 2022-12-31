package Modele;

public class Style {
	
	// ---											Attributs
	//
	private String nom;

	// ---											Constructeur normal 1 
	//
	public Style(String nom) {

		// Nommer un style
		//
		this.nom = nom;
	}
	
	// ---											Constructeur normal 2 
	//
	public Style(String nom, StockStyle liste_style) {

		// Nommer un style
		//
		this.nom = nom;
		
		// Ajouter le style � la liste de style
		//
		liste_style.ajouterStyle(this);
	}

	// ---											Getter & Setter
	//
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// ---											M�thode toString
	//
	public String toString() {
		
		return "Style " + getNom();
	}
}