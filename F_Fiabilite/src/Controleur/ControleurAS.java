package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import Modele.Connexion;
import Modele.Modele;
import VueWB.VueAS;

public class ControleurAS extends Observable implements ActionListener{

	// ---								Attributs
	//
	private Modele modele;
	private VueAS vueAS;
	private Controleur controleur;

	// ---								Constructeur normal
	//
	public ControleurAS(Modele modele, VueAS vueAS, Controleur controleur) {

		// Associer le modele
		//
		this.modele = modele;

		// Associer la vueAdmin
		//
		this.vueAS = vueAS;
		
		this.controleur = controleur;
		
		// Ajouter les écouteurs
		//
		this.vueAS.getEtatEcran().addActionListener(this);
		this.vueAS.getConsulterErreurs().addActionListener(this);
		this.vueAS.getSavoirQuiA().addActionListener(this);
		this.vueAS.getStopperEcran().addActionListener(this);
		this.vueAS.getDeclarerSite().addActionListener(this);
		this.vueAS.getDeclarerEcran().addActionListener(this);
		this.vueAS.getDeplacerEcran().addActionListener(this);
		this.vueAS.getEffacerSite().addActionListener(this);
		this.vueAS.getDeconnexion().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Administrateur système : bouton ");

		// Bouton afficherEtatEcran
		//
		if(e.getSource() == vueAS.getEtatEcran()) {
			String action = "afficher l'état d'un écran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton ConsulterErreurs
		//
		if(e.getSource() == vueAS.getConsulterErreurs()) {
			String action = "Consulter les erreurs d'un écran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton SavoirQuiAEteintEcran
		//
		if(e.getSource() == vueAS.getSavoirQuiA()) {
			String action = "Savoir qui a éteint l'écran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton StopperEcran
		//
		if(e.getSource() == vueAS.getStopperEcran()) {
			String action = "Stopper un écran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton DeclarerSites
		//
		if(e.getSource() == vueAS.getDeclarerSite()) {
			String action = "Déclarer un site";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton DeclarerEcran
		//
		if(e.getSource() == vueAS.getDeclarerEcran()) {
			String action = "Déclarer un écran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton DeplacerEcran
		//
		if(e.getSource() == vueAS.getDeplacerEcran()) {
			String action = "Déplacer un écran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton EffacerSite
		//
		if(e.getSource() == vueAS.getEffacerSite()) {
			String action = "Effacer un site";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton quitter
		//
		if(e.getSource() == vueAS.getDeconnexion()) {
			System.out.println("se deconnecter");

			// Revenir au menu
			//
			retourMenu();			
		}
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
}
