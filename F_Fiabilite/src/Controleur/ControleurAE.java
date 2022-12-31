package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import Modele.Connexion;
import Modele.Modele;
import VueWB.VueAE;

public class ControleurAE extends Observable implements ActionListener{

	// ---								Attributs
	//
	private Modele modele;
	private VueAE vueAE;
	private Controleur controleur;
	
	// ---								Constructeur normal
	//
	public ControleurAE(Modele modele, VueAE vueAE, Controleur controleur) {

		// Associer le modele
		//
		this.modele = modele;

		// Associer la vueAdmin
		//
		this.vueAE = vueAE;
		
		this.controleur = controleur;

		// Ajouter les �couteurs
		//
		this.vueAE.getAssocAffEcran().addActionListener(this);
		this.vueAE.getDeconnexion().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Administrateur d'Ecran : bouton ");
		
		// Bouton associerAfficheurEcran
		//
		if(e.getSource() == vueAE.getAssocAffEcran()) {
			String action = "associer afficheur �cran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}
		
		// Bouton quitter
		//
		if(e.getSource() == vueAE.getDeconnexion()) {
			System.out.println("se deconnecter");

			// Revenir au menu
			//
			retourMenu();		
		}
	}

	// ---									M�thode seDeconnecter
	//
	public void seDeconnecter() {modele.seDeconnecter();}
	
	// ---									M�thode enregistrerAction
	//
	public void enregistrerAction(Connexion connexion, String l_action) {
		modele.enregistrerAction(connexion, l_action);
	}
	
	// ---									M�thode creerIdentifiant
	//
	public void retourMenu() {

		// Revenir au menu
		//
		seDeconnecter();
		controleur.retourConnexion();
	}
}
