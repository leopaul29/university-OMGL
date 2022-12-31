package Modele;

public class Personne {

	// ---										Attributs
	//
	private String nom;
	private String password;
	private String role;
	private String identite;
	private boolean exist;
	private boolean connexion;
	
	// ---									Constructeur normal
	//
	public Personne(String nom, String role, String password, boolean exist) {

		// Nommer la personne
		//
		this.nom = nom;

		// Attribuer un rôle
		//
		this.role = role;

		// Attribuer un mot de passe
		//
		this.password = password;

		// Attribuer une id
		//
		this.identite = ecrireIdentite();
		//System.out.println("identité : " + getIdentite());
		
		// Personne existe
		//
		this.exist = exist;
		
		// Si la personne n'existe pas
		//
		if(!isExist()) {
			
			// Verifier si l'id n'existe pas
			//
			if(!identiteExist())
				
				// Enregistrer l'id
				//
				MyFile.enregistrer("Log/identifiant.txt", getIdentite());
			
			// Verifier si l'id existe
			//
			setConnexion(identiteExist());
			//System.out.println("identité existe 1 ? " + isConnexion());
		}
		else {
			
			// Verifier si l'id existe
			//
			setConnexion(identiteExist());
			//System.out.println("identité existe 2 ? " + isConnexion());
		}
	}

	// ---									Getter & Setter
	//
	public String getIdentite() {
		return identite;
	}

	public void setIdentite(String identite) {
		this.identite = identite;
	}

	public boolean isConnexion() {
		return connexion;
	}

	public void setConnexion(boolean connexion) {
		this.connexion = connexion;
	}

	public boolean isExist() {
		return exist;
	}

	public void setExist(boolean exist) {
		this.exist = exist;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	// ---										Méthode identiteExist
	//
	public boolean identiteExist() {
		
		// Obtenir le contenu du fichier "Log/identifiant.txt"
		//
		String total = MyFile.charger("Log/identifiant.txt"); 
		
		// Renvoyer si l'id existe dans le fichier
		//
		return MyFile.indiceExist(getIdentite(), total);
	}

	// ---										Méthode ecrireIdentite
	//
	public String ecrireIdentite() {

		return getNom() + "/" + getPassword() + "/" + getRole();
	}

	// ---										Méthode toString
	//
	public String toString() {

		return getRole() + " " + getNom();
	}
}
