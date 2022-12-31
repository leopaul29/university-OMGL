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

		// D�marrer la connection au syst�me
		//
		this.connSyst = new ConnexionSysteme();
		obtenirListe_nom();
	}

	// ---								M�thode seConnecter
	//
	public boolean seConnecter(String nom, String password, String role) {

		if(nom.isEmpty() || password.isEmpty()) return false;

		Personne p = new Personne(nom, role, password, true);

		conn = new Connexion(p, connSyst);

		return conn.isConnexion();
	}

	// ---								M�thode creerIdentifiant
	//
	public boolean creerIdentifiant(String nom, String password, String role) {

		if(nom.isEmpty() || password.isEmpty()) return false;

		Personne p = new Personne(nom, role, password, false);

		return p.isConnexion();
	}

	// ---								M�thode seDeconnecter
	//
	public void seDeconnecter() {

		conn.seDeconnecter();
	}

	// ---								M�thode enregistrerAction
	//
	public void enregistrerAction(Connexion connexion, String l_action) {

		new Action(connexion, l_action);
	}

	// ---								M�thode obtenirRole
	//
	public String obtenirRole(String abreviationRole) {

		if(abreviationRole.isEmpty() || abreviationRole == null) return null;

		if(abreviationRole.equals("Administrateur Syst�me")) return "AS";
		if(abreviationRole.equals("Administrateur d'Ecran")) return "AE";
		if(abreviationRole.equals("Concepteur d'Ecran")) return "CE";
		if(abreviationRole.equals("Super Administrateur")) return "Admin";

		else return null;
	}

	// ---								M�thode afficher (Log / Action / ID)
	//
	public String afficher(String aAfficher) {

		if(aAfficher.isEmpty()) return null;

		enregistrerAction(getConn(), "Consultation des " + aAfficher);

		return MyFile.charger("Log/" + aAfficher);
	}

	// ---								M�thode deconnexionSystem
	//
	public void deconnexionSyst() {

		// Ecrire la deconnection et fermer le programme
		//
		connSyst.deconnexionSyst();
	}

	// ---								M�thode obtenirListe_nom
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

	// ---								M�thode trierNom
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

	// ---								M�thode obtenirListe_role
	//
	public ArrayList<String> obtenirListe_role() {

		ArrayList<String> resultat = new ArrayList<String>();

		String contenu = MyFile.charger("Log/identifiant.txt");

		for(int i = 1; i<MyFile.nombreLigne(contenu); i++) {

			String id = MyFile.obtenirLigneNumero(i, contenu);

			// Couper avant le premier et deuxi�me "/"
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

	// ---								M�thode trierRole
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

	// ---								M�thode trierParOrdreAlpha
	//
	public ArrayList<String> trierParOrdreAlpha(ArrayList<String> liste_a_trier) {

		// Trier par ordreAlphab�tique
		//
		Collections.sort(liste_a_trier);
		
		return liste_a_trier;
	}

	// ---								M�thode Getter & Setter
	//
	public Connexion getConn() {
		return conn;
	}

	public void setConn(Connexion conn) {
		this.conn = conn;
	}
}
