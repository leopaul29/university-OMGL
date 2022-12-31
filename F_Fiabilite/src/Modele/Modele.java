package Modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


public class Modele {

	// ---									Attributs
	//
	private ConnexionSysteme connSyst;
	private Connexion conn;

	// ---								Constructeur par defaut
	//
	public Modele() {

		// Démarrer la connection au système
		//
		this.connSyst = new ConnexionSysteme();
		obtenirListe_nom();
	}

	// ---								Méthode seConnecter
	//
	public boolean seConnecter(String nom, String password, String role) {

		if(nom.isEmpty() || password.isEmpty()) return false;

		Personne p = new Personne(nom, role, password, true);

		conn = new Connexion(p, connSyst);

		return conn.isConnexion();
	}

	// ---								Méthode creerIdentifiant
	//
	public boolean creerIdentifiant(String nom, String password, String role) {

		if(nom.isEmpty() || password.isEmpty()) return false;

		Personne p = new Personne(nom, role, password, false);

		return p.isConnexion();
	}

	// ---								Méthode seDeconnecter
	//
	public void seDeconnecter() {

		conn.seDeconnecter();
	}

	// ---								Méthode enregistrerAction
	//
	public void enregistrerAction(Connexion connexion, String l_action) {

		new Action(connexion, l_action);
	}

	// ---								Méthode obtenirRole
	//
	public String obtenirRole(String abreviationRole) {

		if(abreviationRole.isEmpty() || abreviationRole == null) return null;

		if(abreviationRole.equals("Administrateur Système")) return "AS";
		if(abreviationRole.equals("Administrateur d'Ecran")) return "AE";
		if(abreviationRole.equals("Concepteur d'Ecran")) return "CE";
		if(abreviationRole.equals("Super Administrateur")) return "Admin";

		else return null;
	}

	// ---								Méthode afficher (Log / Action / ID)
	//
	public String afficher(String aAfficher) {

		if(aAfficher.isEmpty()) return null;

		enregistrerAction(getConn(), "Consultation des " + aAfficher);

		return MyFile.charger("Log/" + aAfficher);
	}

	// ---								Méthode deconnexionSystem
	//
	public void deconnexionSyst() {

		// Ecrire la deconnection et fermer le programme
		//
		connSyst.deconnexionSyst();
	}

	// ---								Méthode obtenirListe_nom
	//
	public ArrayList<String> obtenirListe_nom() {

		ArrayList<String> resultat = new ArrayList<String>();

		String contenu = MyFile.charger("Log/identifiant.txt");

		for(int i = 1; i<=MyFile.nombreLigne(contenu); i++) {

			String id = MyFile.obtenirLigneNumero(i, contenu);

			int index1 = id.indexOf("/");
			if(index1 == -1) return null;

			String nom = "";
			for(int j = 0; j<index1; j++) {

				nom += id.charAt(j);
			}

			// Ajouter le role
			//
			resultat.add(nom);
		}

		return trierParOrdreAlpha(resultat);
	}

	// ---								Méthode trierNom
	//
	public String trierNom(String aAfficher) {

		ArrayList<String> liste_nom = obtenirListe_nom();

		String contenu = MyFile.charger("Log/" + aAfficher);

		HashMap<String, ArrayList<String>> triage = MyFile.obtenirLignesContientS(liste_nom, contenu);

		String new_contenu = "";
		for(int i = 0; i<liste_nom.size(); i++) {

			ArrayList<String> fichier = (ArrayList<String>) triage.get(liste_nom.get(i));

			for(int j = 0; j<fichier.size(); j++) {

				new_contenu += fichier.get(j).toString() + "\n";
			}
		}
		return new_contenu;
	}

	// ---								Méthode obtenirListe_role
	//
	public ArrayList<String> obtenirListe_role() {

		ArrayList<String> resultat = new ArrayList<String>();

		String contenu = MyFile.charger("Log/identifiant.txt");

		for(int i = 1; i<MyFile.nombreLigne(contenu); i++) {

			String id = MyFile.obtenirLigneNumero(i, contenu);

			// Couper avant le premier et deuxième "/"
			//	
			for(int j = 0; j<2; j++) {

				int index1 = id.indexOf("/");
				if(index1 == -1) return null;

				id = id.substring(index1+1);
			}

			// Ajouter le role
			//
			resultat.add(id);
		}

		return trierParOrdreAlpha(resultat);
	}

	// ---								Méthode trierRole
	//
	public String trierRole(String aAfficher) {

		ArrayList<String> liste_role = obtenirListe_role();

		String contenu = MyFile.charger("Log/" + aAfficher);

		HashMap<String, ArrayList<String>> triage = MyFile.obtenirLignesContientS(liste_role, contenu);

		String new_contenu = "";
		for(int i = 0; i<liste_role.size(); i++) {

			ArrayList<String> fichier = (ArrayList<String>) triage.get(liste_role.get(i));

			for(int j = 0; j<fichier.size(); j++) {

				new_contenu += fichier.get(j).toString() + "\n";
			}
		}
		return new_contenu;
	}

	// ---								Méthode trierParOrdreAlpha
	//
	public ArrayList<String> trierParOrdreAlpha(ArrayList<String> liste_a_trier) {

		// Trier par ordreAlphabétique
		//
		Collections.sort(liste_a_trier);
		
		return liste_a_trier;
	}

	// ---								Méthode Getter & Setter
	//
	public Connexion getConn() {
		return conn;
	}

	public void setConn(Connexion conn) {
		this.conn = conn;
	}
}
