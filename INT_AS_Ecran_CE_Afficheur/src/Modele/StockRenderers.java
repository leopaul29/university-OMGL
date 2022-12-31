package Modele;

import java.util.ArrayList;
import java.util.HashMap;

public class StockRenderers {

	// ---											Attributs
	//
	private HashMap<String, Renderer> liste_renderers;
	private ArrayList<String> liste_nomR;

	// ---											Constructeur normal
	//
	public StockRenderers() {

		// Créer un HashMap de zone
		//
		this.liste_renderers = new HashMap<String, Renderer>();

		// Créer une ArrayList de nom de zone
		//
		this.liste_nomR = new ArrayList<String>();
	}

	// ---											Getter & Setter
	//
	public ArrayList<String> getListe_nomR() {
		return liste_nomR;
	}

	public void setListe_nomR(ArrayList<String> liste_nomR) {
		this.liste_nomR = liste_nomR;
	}

	public HashMap<String, Renderer> getListe_renderers() {
		return liste_renderers;
	}

	public void setListe_renderers(HashMap<String, Renderer> liste_renderers) {
		this.liste_renderers = liste_renderers;
	}

	public Renderer getRenderer(String nom) {

		// Obtenir un renderer à partir de son nom
		//
		return getListe_renderers().get(nom);
	}

	public Renderer getRenderer(int numero) {

		// Obtenir un renderer à partir de son numero dans la liste de nom
		//
		return getListe_renderers().get(getListe_nomR().get(numero));
	}

	// ---											Méthode nombreNom
	//
	public int nombreNom() {

		// Obtenir le nombre de nom de renderers dans la liste
		//
		return getListe_nomR().size();
	}

	// ---											Méthode nombreRenderer
	//
	public int nombreRenderer() {

		// Obtenir le nombre de renderers dans le HashMap
		//
		return getListe_renderers().size();
	}

	// ---											Méthode ajouterRenderer
		//
	public void ajouterRenderer(Renderer renderer) {

		// Récuperer le nom du renderer
		//
		String nom_renderer = renderer.getNom();

		// Ajouter le renderer au HashMap
		//
		getListe_renderers().put(nom_renderer, renderer);

		// Ajouter le nom du renderer à la liste
		//
		ajouterNom(nom_renderer);
	}

	// ---											Méthode ajouterNom
	//
	public void ajouterNom(String nom_renderer) {

		// Ajouter le nom du renderer à la liste
		//
		getListe_nomR().add(nom_renderer);
	}

	// ---											Méthode afficherNomZ
	//
	public String afficherNomR() {

		// Déclarer un resultat
		//
		String resultat = "Liste de Renderers : [ ";

		// Parcourir la liste de nom
		//
		for(int i = 0; i < nombreNom(); i++) {

			// Ajouter au resultat le nom de la zone
			//
			resultat += "[ " + getRenderer(i).getNom() + " ] ";
		}

		// Renvoyer le resultat
		//
		return resultat += "]";
	}

	// ---											Méthode toString
	//
	public String toString() {

		return "Liste de Renderers : " + getListe_renderers().toString();
	}
}
