package Modele;

public class Dimension {

	// ---											Attributs
	//
	private float height;
	private float width;

	// ---											Constructeur normal
	//
	public Dimension(float width, float height){

		// Créer une hauteur
		//
		this.height = height;

		// Créer une largeur
		//
		this.width = width;
	}

	// ---											Getter & Setter
	//
	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	// ---											Méthode equals
	//
	public boolean equals(Dimension dimension){

		// Comparer les deux hauteurs
		//
		if(getHeight() == dimension.getHeight()) {
			
			// Comparer les deux largeurs
			//
			if(getWidth() == dimension.getWidth())
				return true;
			else
				return false;
		}
		else 
			return false;
	}

	// ---											Méthode toString
	//
	public String toString() {

		return "Dimension [ height = " + getHeight() + ", width = " + getWidth() + " ]";
	}

}