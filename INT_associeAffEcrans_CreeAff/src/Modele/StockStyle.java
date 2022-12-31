package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import Modele.Style;

public class StockStyle {

	// ---											Attributs
	//
	private HashMap<String, Style> liste_styles;
	private ArrayList<String> liste_nomS;

	// ---											Constructeur normal
	//
	public StockStyle() {

		// Cr�er un HashMap de style
		//
		this.liste_styles = new HashMap<String, Style>();
		
		// Cr�er une ArrayList de nom de style
		//
		this.liste_nomS = new ArrayList<String>();

		// Ajouter aux listes de style le style "Basic"
		//
		ajouterStyleBasic(this);
	}

	// ---											Getter & Setter
	//
	public Style getStyle(String nom) {
		return getListe_styles().get(nom);
	}

	public HashMap<String, Style> getListe_styles() {
		return liste_styles;
	}

	public void setListe_styles(HashMap<String, Style> liste_styles) {
		this.liste_styles = liste_styles;
	}

	public ArrayList<String> getListe_nomS() {
		return liste_nomS;
	}

	public void setListe_nomS(ArrayList<String> liste_nomS) {
		this.liste_nomS = liste_nomS;
	}

	public Style getStyle(int numero) {
		
		// Obtenir le style de la liste
		//
		return getListe_styles().get(getListe_nomS().get(numero));
	}

	// ---											M�thode nombreNom
	//
	public int nombreNom() {

		// Obtenir le nombre de nom de style dans la liste
		//
		return getListe_nomS().size();
	}
	
	// ---											M�thode nombreStyle
	//
	public int nombreStyle() {

		// Obtenir le nombre de zone dans le HashMap
		//
		return getListe_styles().size();
	}

	// ---											M�thode ajouterStyle
	//
	public void ajouterStyle(Style style) {

		// R�cuperer le nom du style
		//
		String nom_style = style.getNom();

		// Ajouter le style au HashMap
		//
		getListe_styles().put(nom_style, style);
		
		// Ajouter le nom du style � la liste
		//
		ajouterNom(nom_style);
	}

	// ---											M�thode ajouterStyleBasic
	//
	public void ajouterStyleBasic(StockStyle stock_style) {

		// Cr�er un style de base
		//
		new Style("Basic", stock_style);
	}
	
	// ---											M�thode ajouterNom
	//
	public void ajouterNom(String nom) {
		
		// Ajouter le nom du style � la liste
		//
		getListe_nomS().add(nom);
	}

	// ---											M�thode afficherNomS
	//
	public String afficherNomS() {

		// D�clarer un resultat
		//
		String resultat = "Liste de Styles : [ ";

		// Parcourir la liste de nom
		//
		for(int i = 0; i < nombreNom(); i++) {

			// Ajouter au resultat le nom de la zone
			//
			resultat += "[ " + getStyle(i).getNom() + " ] ";
		}

		// Renvoyer le resultat
		//
		return resultat += "]";
	}

	// ---											M�thode toString
	//
	public String toString() {
		
		return "Liste de Styles : " + getListe_styles().toString();
	}
}