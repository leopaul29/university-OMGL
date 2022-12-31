package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Connexion;
import Modele.Modele;
import VueWB.VueCreerAfficheur;

public class ControleurCreerAfficheur implements ActionListener{

	// ---								Attributs
	//
	private Modele modele;
	private VueCreerAfficheur vueCreerAfficheur;
	private ControleurCE controleurCE;

	// ---								Constructeur normal
	//
	public ControleurCreerAfficheur(Modele modele, VueCreerAfficheur vueCreerAfficheur, ControleurCE controleurCE) {

		// Associer le modele
		//
		this.modele = modele;

		// Associer la vueAdmin
		//
		this.vueCreerAfficheur = vueCreerAfficheur;

		this.controleurCE = controleurCE;
		
		// Ajouter les écouteurs
		//
		this.vueCreerAfficheur.getcZoneTxt().addActionListener(this);
		this.vueCreerAfficheur.getcZoneAlert().addActionListener(this);
		this.vueCreerAfficheur.getcZoneBloc().addActionListener(this);
		this.vueCreerAfficheur.getNommerZone().addActionListener(this);
		this.vueCreerAfficheur.getAssocieStyleAff().addActionListener(this);
		this.vueCreerAfficheur.getRetour().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Concepteur écran - créer afficheur : bouton ");

		// Bouton cZoneTxt
		//
		if(e.getSource() == vueCreerAfficheur.getcZoneTxt()) {
			String action = "créer une zone de texte";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton cZoneAlerte
		//
		if(e.getSource() == vueCreerAfficheur.getcZoneAlert()) {
			String action = "créer une zone d'alerte";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton cZoneBloc
		//
		if(e.getSource() == vueCreerAfficheur.getcZoneBloc()) {
			String action = "créer une zone de bloc";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton NommerZone
		//
		if(e.getSource() == vueCreerAfficheur.getNommerZone()) {
			String action = "Nommer une zone";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton AssocieStyleAfficheur
		//
		if(e.getSource() == vueCreerAfficheur.getAssocieStyleAff()) {
			String action = "Associer un style à un afficheur";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton retour
		//
		if(e.getSource() == vueCreerAfficheur.getRetour()) {
			System.out.println("retour");

			retourMenu();
		}
	}

	// ---									Méthode enregistrerAction
	//
	public void enregistrerAction(Connexion connexion, String l_action) {

		modele.enregistrerAction(connexion, l_action);
	}

	// ---									Méthode retourMenu
	//
	public void retourMenu() {

		// Revenir au menu
		//
		controleurCE.retour();
	}

}
