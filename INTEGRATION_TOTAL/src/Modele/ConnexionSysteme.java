package Modele;

public class ConnexionSysteme {

	private boolean syst_connecte;

	public ConnexionSysteme() {

		setSyst_connecte(true);
		
		if(isSyst_connecte()) ecrireConnection();
	}

	public boolean isSyst_connecte() {
		return syst_connecte;
	}

	public void setSyst_connecte(boolean syst_connecte) {
		this.syst_connecte = syst_connecte;
	}
	
	public void deconnexionSyst() {
		
		setSyst_connecte(false);
		
		if(!isSyst_connecte()) ecrireDeconnection();
	}
	
	public void ecrireConnection() {
		
		MyDate date = new MyDate();

		String text = "Demarrage du système à " + date + "\t\r\n";
		
		Log.enregistrerLog(text, "Log", "action.txt");
	}
	
	public void ecrireDeconnection() {
		
		MyDate date = new MyDate();

		String text = "Arret du système à " + date + "\t\r\n";
		
		Log.enregistrerLog(text, "Log", "action.txt");
	}
}
