package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Connexion;
import Modele.Modele;
import VueWB.VueCE;
import VueWB.VueCreerAfficheur;

public class ControleurCE implements ActionListener{

	// ---								Attributs
	//
	private Modele modele;
	private VueCE vueCE;
	private Controleur controleur;
	private VueCreerAfficheur vueCreerAfficheur;

	// ---								Constructeur normal
	//
	public ControleurCE(Modele modele, VueCE vueCE, Controleur controleur) {

		// Associer le modele
		//
		this.modele = modele;

		// Associer la vueAdmin
		//
		this.vueCE = vueCE;

		this.controleur = controleur;
		
		this.vueCreerAfficheur = new VueCreerAfficheur();
		new ControleurCreerAfficheur(modele, vueCreerAfficheur, this);

		// Ajouter les écouteurs
		//
		this.vueCE.getCreerAfficheur().addActionListener(this);
		this.vueCE.getAssocieRenderers().addActionListener(this);
		this.vueCE.getDeconnexion().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Concepteur d'Ecran : bouton ");

		// Bouton creerAfficheur
		//
		if(e.getSource() == vueCE.getCreerAfficheur()) {
			System.out.println("vers creerAfficheur");

			creerAfficheur();
		}

		// Bouton creerAfficheur
		//
		if(e.getSource() == vueCE.getAssocieRenderers()) {
			String action = "Associer renderers";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton quitter
		//
		if(e.getSource() == vueCE.getDeconnexion()) {
			System.out.println("se deconnecter");

			// Revenir au menu
			//
			retourMenu();			
		}
	}

	// ---									Méthode creerID
	//
	public void creerAfficheur() {

		controleur.allerVers(vueCreerAfficheur, "Créer un afficheur");
	}

	// ---									Méthode seDeconnecter
	//
	public void seDeconnecter() {modele.seDeconnecter();}

	// ---									Méthode enregistrerAction
	//
	public void enregistrerAction(Connexion connexion, String l_action) {
		modele.enregistrerAction(connexion, l_action);
	}

	// ---									Méthode creerIdentifiant
	//
	public void retourMenu() {

		// Revenir au menu
		//
		seDeconnecter();
		controleur.retourConnexion();	
	}

	public void retour() {
		// TODO Auto-generated method stub

		controleur.allerVers(vueCE, "Concepteur d'Ecran");
	}
}
