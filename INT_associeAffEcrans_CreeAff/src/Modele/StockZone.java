package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import Modele.Zone;

public class StockZone {
	
	// ---											Attributs
	//
	private HashMap<String, Zone> liste_zones;
	private ArrayList<String> liste_nomZ;

	// ---											Constructeur normal
	//
	public StockZone() {
		
		// Cr�er un HashMap de zone
		//
		this.liste_zones = new HashMap<String, Zone>();
		
		// Cr�er une ArrayList de nom de zone
		//
		this.liste_nomZ = new ArrayList<String>();
	}

	// ---											Getter & Setter
	//
	public HashMap<String, Zone> getListe_zones() {
		return liste_zones;
	}

	public void setListe_zones(HashMap<String, Zone> liste_zones) {
		this.liste_zones = liste_zones;
	}
	
	public ArrayList<String> getListe_nomZ() {
		return liste_nomZ;
	}

	public void setListe_nomZ(ArrayList<String> liste_nomZ) {
		this.liste_nomZ = liste_nomZ;
	}
	
	public Zone getZone(String nom) {
		
		// Obtenir une zone � partir de son nom
		//
		return getListe_zones().get(nom);
	}
	
	public Zone getZone(int numero) {
		
		// Obtenir une zone � partir de son numero dans la liste de nom
		//
		return getListe_zones().get(getListe_nomZ().get(numero));
	}

	// ---											M�thode nombreNom
	//
	public int nombreNom() {

		// Obtenir le nombre de nom de zone dans la liste
		//
		return getListe_nomZ().size();
	}
	
	// ---											M�thode nombreZone
	//
	public int nombreZone() {

		// Obtenir le nombre de zone dans le HashMap
		//
		return getListe_zones().size();
	}

	// ---											M�thode ajouterZone
	//
	public void ajouterZone(Zone zone) {
		
		// R�cuperer le nom de la zone
		//
		String nom_zone = zone.getNom();
		
		// Ajouter la zone au HashMap
		//
		getListe_zones().put(nom_zone, zone);
		
		// Ajouter le nom de la zone � la liste
		//
		ajouterNom(nom_zone);
	}
	
	// ---											M�thode ajouterNom
	//
	public void ajouterNom(String nom) {
		
		// Ajouter le nom de la zone � la liste
		//
		getListe_nomZ().add(nom);
	}
	
	// ---											M�thode afficherNomZ
	//
	public String afficherNomZ() {

		// D�clarer un resultat
		//
		String resultat = "Liste de Zones : [ ";

		// Parcourir la liste de nom
		//
		for(int i = 0; i < nombreNom(); i++) {
			
			// Ajouter au resultat le nom de la zone
			//
			resultat += "[ " + getZone(i).getNom() + " ] ";
		}

		// Renvoyer le resultat
		//
		return resultat += "]";
	}
	
	// ---											M�thode toString
	//
	public String toString() {
		
		return "Liste de Zones : " + getListe_zones().toString();
	}
}