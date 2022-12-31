package Modele;

public class Action {

	private Personne personne;
	private String action;
	private MyDate date;
	private boolean actionPossible;
	
	public Action(Connexion connexion, String action) {
		
		this.personne = connexion.getPersonne();
		
		this.action = action;
		
		this.date = new MyDate();
		
		this.actionPossible = connexion.isConnexion();
		
		if(isActionPossible()) enregistrerAction();
		
	}

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
	
	public void enregistrerAction() {
		
		Log.enregistrerLog(this.toString(), "Log", "action.txt");
	}
	
	public String toString() {
		
		return getPersonne().toString() + " a fait \"" + getAction() + "\" le " + getDate().toString()  + "\t\r\n";
	}
}
