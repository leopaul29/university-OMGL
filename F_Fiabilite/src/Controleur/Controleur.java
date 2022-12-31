package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Observable;

import Modele.Modele;
import VueWB.Vue;
import VueWB.VueAE;
import VueWB.VueAS;
import VueWB.VueAdmin;
import VueWB.VueCE;
import VueWB.VueMenu;

public class Controleur extends Observable implements ActionListener{

	// ---								Attributs
	//
	private Modele modele;
	private VueMenu vueMenu;
	private Vue vue;
	private VueAE vueAE;
	private VueCE vueCE;
	private VueAdmin vueAdmin;
	private VueAS vueAS;
	
	// ---								Constructeur par défaut
	//
	public Controleur() {

		// Créer la fenetre
		//
		vue = new Vue();
		vue.addWindowListener(new EcouteurFermerFenetre(modele));

		// Ajouter l'observation de la fenetre par le controleur
		// Pour changer de fenetre
		//
		this.addObserver(vue);

		// Créer le modele
		//
		this.modele = new Modele();

		// Créer la page de connexion
		//
		this.vueMenu = new VueMenu();

		allerVers(vueMenu, "Page de connexion");

		ajouterObs();

		// Fixer les écouteur sur les boutons du menu
		//
		vueMenu.getConnexion().addActionListener(this);
		vueMenu.getQuitter().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("MenuConnexion : bouton ");

		// Bouton connection
		//
		if(e.getSource() == vueMenu.getConnexion()) {
			System.out.println("connexion");

			// Récupéré parametre de connexion
			//
			String nom = vueMenu.getTxt_nom().getText();
			String mdp = vueMenu.getTxt_pass().getText();
			String role = vueMenu.getListe_role().getSelectedItem().toString();
			role = obtenirRole(role);

			// Se connecter
			//
			boolean connexion = seConnecter(nom, mdp, role);
			System.out.println("connexion : " + connexion);
			if(true) {
				// Afficher la page demander par rapport au role
				//
				obtenirFenetreRole(role);
			}

			vueMenu.getTxt_nom().setText("");
			vueMenu.getTxt_pass().setText("");
			vueMenu.getListe_role().setSelectedIndex(0);
		}

		// Bouton quitter
		//
		if(e.getSource() == vueMenu.getQuitter()) {
			System.out.println("quitter");

			// Quitter le programme
			//
			deconnexionSyst();
			System.exit(0);
		}
	}

	public boolean seConnecter(String nom, String password, String role) {
		return modele.seConnecter(nom, password, role);
	}

	public void deconnexionSyst() {	modele.deconnexionSyst();}

	public String obtenirRole(String abreviationRole) {
		return modele.obtenirRole(abreviationRole);
	}

	public void obtenirFenetreRole(String role) {

		if(role.equals("Admin")) allerVers(vueAdmin, "Administration");
		if(role.equals("AS")) allerVers(vueAS, "Administrateur système");
		if(role.equals("CE")) allerVers(vueCE, "Concepteur d'Ecran");
		if(role.equals("AE")) allerVers(vueAE, "Administrateur d'Ecran");
	}

	public void ajouterObs() {

		vueAE = new VueAE();
		new ControleurAE(modele, vueAE, this);

		vueCE = new VueCE();
		new ControleurCE(modele, vueCE, this);

		vueAdmin = new VueAdmin();
		new ControleurAdmin(modele, vueAdmin, this);

		vueAS = new VueAS();
		new ControleurAS(modele, vueAS, this);

	}

	public void retourConnexion() {allerVers(vueMenu, "Page de connexion");}

	public void allerVers(Object vue, String titre) {

		// Créer le HashMap pour modifier la vue
		//
		HashMap<String, Object> modifs = new HashMap<String, Object>();
		modifs.put("vue", vue);
		modifs.put("titre", titre);

		// Notifier la fenetre
		//
		setChanged();
		notifyObservers(modifs);
	}

	public static void main(String[] args) {
		new Controleur();
	}
}
