package Modele;

public class ConnexionSysteme {

	// ---										Attributs
	//
	private boolean syst_connecte;

	// ---									Constructeur par defaut
	//
	public ConnexionSysteme() {

		// Connecter le system
		//
		setSyst_connecte(true);
		
		// Ecrire la connexion dans les actions
		//
		if(isSyst_connecte()) ecrireConnection();
	}

	// ---										Getter & Setter
	//
	public boolean isSyst_connecte() {
		return syst_connecte;
	}

	public void setSyst_connecte(boolean syst_connecte) {
		this.syst_connecte = syst_connecte;
	}
	
	// ---										M�thode deconnexionSyst
	//
	public void deconnexionSyst() {
		
		// Deconnecter le system
		//
		setSyst_connecte(false);
		
		// Ecrire la deconnexion dans les actions
		//
		if(!isSyst_connecte()) ecrireDeconnection();
		
		// Fermer le system
		//
		System.exit(0);
	}
	
	// ---										Attributs
	//
	public void ecrireConnection() {
		
		// Cr�er la date
		//
		MyDate date = new MyDate();

		// D�clarer le texte � �crire
		//
		String text = date.formatJJMMAAAA_HHMMSS() + " : Demarrage du syst�me";
		
		// D�clarer une action
		//
		Action action = new Action(this, text);
		
		// Enregistrer l'action
		//
		action.enregistrerAction(text);
	}
	
	// ---										Attributs
	//
	public void ecrireDeconnection() {
		
		// Cr�er la date
		//
		MyDate date = new MyDate();

		// D�clarer le texte � �crire
		//
		String text = date.formatJJMMAAAA_HHMMSS() + " : Arret du syst�me";
		
		// D�clarer une action
		//
		Action action = new Action(this, text);
		
		// Enregistrer l'action
		//
		action.enregistrerAction(text);
	}
}
