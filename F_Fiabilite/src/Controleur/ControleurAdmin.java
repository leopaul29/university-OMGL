package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import Modele.Modele;
import Vue.VueAfficher;
import VueWB.VueAdmin;
import VueWB.VueCreerID;

public class ControleurAdmin extends Observable implements ActionListener{

	// ---								Attributs
	//
	private Modele modele;
	private VueAdmin vueAdmin;
	private Controleur controleur;
	private VueCreerID vueCreerID;

	// ---								Constructeur normal
	//
	public ControleurAdmin(Modele modele, VueAdmin vueAdmin, Controleur controleur) {

		// Associer le modele
		//
		this.modele = modele;

		// Associer la vueAdmin
		//
		this.vueAdmin = vueAdmin;
		
		this.controleur = controleur;
		
		this.vueCreerID = new VueCreerID();
		new ControleurCreerID(modele, vueCreerID, this);
		
		// Ajouter les écouteurs
		//
		this.vueAdmin.getAfficherLog().addActionListener(this);
		this.vueAdmin.getCreerID().addActionListener(this);
		this.vueAdmin.getAfficherID().addActionListener(this);
		this.vueAdmin.getAfficherAction().addActionListener(this);
		this.vueAdmin.getDeconnexion().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Administration : bouton ");

		// Bouton afficherLog
		//
		if(e.getSource() == vueAdmin.getAfficherLog()) {
			System.out.println("afficherLog");

			// Afficher les log
			//
			afficher("log.txt");
		}

		// Bouton afficherAction
		//
		if(e.getSource() == vueAdmin.getAfficherAction()) {
			System.out.println("afficherAction");

			// Afficher les action
			//
			afficher("action.txt");
		}

		// Bouton creerID
		//
		if(e.getSource() == vueAdmin.getCreerID()) {
			System.out.println("créer un identifiant");

			// Acceder a la création d'ID
			//
			creerID();
		}

		// Bouton afficherID
		//
		if(e.getSource() == vueAdmin.getAfficherID()) {
			System.out.println("afficherID");

			// Afficher les identifiants
			//
			afficher("identifiant.txt");
		}

		// Bouton quitter
		//
		if(e.getSource() == vueAdmin.getDeconnexion()) {
			System.out.println("se deconnecter");

			// Revenir au menu
			//
			retourMenu();			
		}
	}

	// ---									Méthode creerID
	//
	public void creerID() {

		controleur.allerVers(vueCreerID, "Créer un identifiant");
	}

	// ---									Méthode seDeconnecter
	//
	public void seDeconnecter() {modele.seDeconnecter();}

	// ---									Méthode creerIdentifiant
	//
	public void retourMenu() {

		// Revenir au menu
		//
		seDeconnecter();
		controleur.retourConnexion();	
	}

	// ---									Méthode afficher
	//
	public void afficher(String aAfficher) {

		String contenu = modele.afficher(aAfficher);
		VueAfficher vueAfficher = new VueAfficher();
		vueAfficher.setTitle(aAfficher);
		new ControleurAfficher(modele, vueAfficher, contenu);
	}
	
	public void retourAdministration() {
		
		controleur.allerVers(vueAdmin, "Administration");
	}

}
