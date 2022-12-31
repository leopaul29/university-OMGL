package Modele;

public class Action {

	// ---										Attributs
	//
	private Personne personne;
	private String action;
	private MyDate date;
	private boolean actionPossible;
	
	// ---									Constructeur normal 1
	//
	public Action(Connexion connexion, String action) {
		
		// Attribuer une personne
		//
		this.personne = connexion.getPersonne();
		
		// Attribuer une action
		//
		this.action = action;

		// Créer la date
		//
		this.date = new MyDate();
		
		// Obtenir si l'action est possible
		//
		this.actionPossible = connexion.isConnexion();
		
		// Vérifier si l'action est possible
		//
		if(isActionPossible())
			
			// Enregister l'action
			//
			enregistrerAction();
	}

	// ---									Constructeur normal 2
	//
	public Action(ConnexionSysteme connexionSysteme, String action) { }

	// ---										Getter & Setter
	//
	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public boolean isActionPossible() {
		return actionPossible;
	}

	public void setActionPossible(boolean actionPossible) {
		this.actionPossible = actionPossible;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public MyDate getDate() {
		return date;
	}

	public void setDate(MyDate date) {
		this.date = date;
	}
	
	// ---									Méthode enregistrerAction 1
	//
	public void enregistrerAction() {
		
		MyFile.enregistrer("Log/action.txt", this.toString());
	}
	
	// ---									Méthode enregistrerAction 2
	//
	public void enregistrerAction(String action) {
		
		MyFile.enregistrer("Log/action.txt", action);
	}
	
	// ---									Méthode toString
	//
	public String toString() {
		
		return getDate().formatJJMMAAAA_HHMMSS() + " : " + getPersonne().toString() + " %" + getAction();
	}
}
