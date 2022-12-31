package Modele;

public class Personne {

	private String nom;
	private String password;
	private String role;
	private String identite;
	private boolean exist;
	private boolean connexion;
	
	public Personne(String nom, String role, String password, boolean exist) {

		this.nom = nom;

		this.role = role;

		this.password = password;

		this.identite = ecrireIdentite();
		
		this.exist = exist;
		

		if(!isExist()) {

			if(!verif_id()) Log.enregistrerLog(getIdentite(), "Log", "identifiant.txt");
			
			setConnexion(verif_id());
		}
		else {
			
			setConnexion(verif_id());
		}
	}

	public String getIdentite() {
		return identite;
	}

	public void setIdentite(String identite) {
		this.identite = identite;
	}

	public void setNomPossible(boolean nomPossible) {
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
	
	public boolean verif_id() {
		
		String total = Log.chargerLog("Log/identifiant.txt");
		
		return Log.recup_id(getIdentite(), total);
	}

	public String ecrireIdentite() {

		return getNom() + "/" + getPassword() + "/" + getRole() + "\t\r\n";
	}

	public String toString() {

		return getRole() + " " + getNom();
	}
}
