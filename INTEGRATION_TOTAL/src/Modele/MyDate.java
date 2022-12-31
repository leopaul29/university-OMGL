package Modele;

import java.util.ArrayList;
import java.util.Date;

public class MyDate {

	private Date date;
	private ArrayList<String> liste_mois;
	private ArrayList<String> liste_jours;
	
	public MyDate() {
		
		this.date = new Date();
		
		this.liste_mois = creerListe_mois();
		
		this.liste_jours = creerListe_jours();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public ArrayList<String> getListe_mois() {
		return liste_mois;
	}

	public void setListe_mois(ArrayList<String> liste_mois) {
		this.liste_mois = liste_mois;
	}

	public ArrayList<String> getListe_jours() {
		return liste_jours;
	}

	public void setListe_jours(ArrayList<String> liste_jours) {
		this.liste_jours = liste_jours;
	}

	public int getAnnees() {
		
		return getDate().getYear() + 1900;
	}
	
	public int getHeures() {
		
		return getDate().getHours();
	}
	
	public int getMinutes() {
		
		return getDate().getMinutes();
	}
	
	public int getSecondes() {
		
		return getDate().getSeconds();
	}
	
	public int getNumeroJour() {
		
		return getDate().getDate();
	}
	
	public String getMois() {
		
		int num_mois = getDate().getMonth();
		
		return getListe_mois().get(num_mois);
	}
	
	public String getJours() {
		
		int num_jours = getDate().getDay();
		
		return getListe_jours().get(num_jours);
	}
	
	public ArrayList<String> creerListe_mois() {
		
		ArrayList<String> liste_mois = new ArrayList<String>();
		
		liste_mois.add("Janvier");
		liste_mois.add("Fevrier");
		liste_mois.add("Mars");
		liste_mois.add("Avril");
		liste_mois.add("Mai");
		liste_mois.add("Juin");
		liste_mois.add("Juillet");
		liste_mois.add("Aout");
		liste_mois.add("Septembre");
		liste_mois.add("Octobre");
		liste_mois.add("Novembre");
		liste_mois.add("Decembre");
		
		return liste_mois;
	}
	
	public ArrayList<String> creerListe_jours() {
		
		ArrayList<String> liste_jours = new ArrayList<String>();
		
		liste_jours.add("Dimanche");
		liste_jours.add("Lundi");
		liste_jours.add("Mardi");
		liste_jours.add("Mercredi");
		liste_jours.add("Jeudi");
		liste_jours.add("Vendredi");
		liste_jours.add("Samedi");
		
		return liste_jours;
	}
	
	public String toString() {
		
		return getJours() + " " + getNumeroJour() + " " + getMois() + " " + getAnnees() + " à " + getHeures() + ":" + getMinutes() + ":" + getSecondes();
	}
}
