package Modele;

public class Connexion {

	// ---										Attributs
	//
	private Personne personne;
	private boolean connexion;

	// ---									Constructeur normal
	//
	public Connexion(Personne personne, ConnexionSysteme system_connecte) {

		// V�rifier si le system est connect�
		//
		if(system_connecte.isSyst_connecte()) {
			
			// Attribuer une personne
			//
			this.personne = personne;

			// V�rifier si la personne peut se connecter
			//
			if(verifierConnection(personne)) {
				
				// Connecter la personne
				//
				setConnexion(true);
				
			} else
				
				// Ne pas connecter la personne
				//
				setConnexion(false);

			// Ecrire la connection
			//
			if(isConnexion()) enregisterConnection();
		}
	}

	// ---										Getter & Setter
	//
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public boolean isConnexion() {
		return connexion;
	}

	public void setConnexion(boolean connexion) {
		this.connexion = connexion;
	}

	// ---										M�thode verifierConnection
	//
	public boolean verifierConnection(Personne personne) {

		return personne.isConnexion();
	}
	
	// ---										M�thode seDeconnecter
	//
	public void seDeconnecter() {
		
		// Deconnecter la personne
		//
		setConnexion(false);
		
		// Ecrire la deconnection
		//
		enregisterDeconnection();
	}
	
	//
	public String ecrireConnection() {
		
		MyDate date = new MyDate();

		return date.formatJJMMAAAA_HHMMSS() + " " + getPersonne().toString() + " connexion";
	}
	
	public String ecrireDeconnection() {
		
		MyDate date = new MyDate();

		return date.formatJJMMAAAA_HHMMSS() + " " + getPersonne().toString() + " d�connexion";
	}

	public void enregisterConnection() {

		MyFile.enregistrer("Log/log.txt", ecrireConnection());
	}
	
	public void enregisterDeconnection() {

		MyFile.enregistrer("Log/log.txt", ecrireDeconnection());
	}
}
