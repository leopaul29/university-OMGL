package Modele;

public class Style {
	
	// ---											Attributs
	//
	private String nom;

	// ---											Constructeur normal
	//
	public Style(String nom, StockStyle liste_style) {

		// Nommer un style
		//
		this.nom = nom;
		
		// Ajouter le style à la liste de style
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

	// ---											Méthode toString
	//
	public String toString() {
		
		return "Style " + getNom();
	}
}