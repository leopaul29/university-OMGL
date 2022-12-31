package Modele;

public class Connexion {

	private Personne personne;
	private boolean connexion;

	public Connexion(Personne personne, ConnexionSysteme system_connecte) {

		if(system_connecte.isSyst_connecte()) {
			this.personne = personne;

			if(verifierNom(personne)) {
				setConnexion(true);
			} else 
				setConnexion(false);

			if(isConnexion()) ecrireConnection();
		}
	}

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

	public boolean verifierNom(Personne personne) {

		return personne.isConnexion();
	}
	
	public void seDeconnecter() {
		
		setConnexion(false);
		
		ecrireDeconnection();
	}
	
	public String toString_connection() {
		
		MyDate date = new MyDate();

		return getPersonne().toString() + " connecté le " + date.toString() + "\t\r\n";
	}
	
	public String toString_deconnection() {
		
		MyDate date = new MyDate();

		return getPersonne().toString() + " déconnecté le " + date.toString() + "\t\r\n";
	}

	public void ecrireConnection() {

		Log.enregistrerLog(toString_connection(), "Log", "log.txt");
	}
	
	public void ecrireDeconnection() {

		Log.enregistrerLog(toString_deconnection(), "Log", "log.txt");
	}
}
