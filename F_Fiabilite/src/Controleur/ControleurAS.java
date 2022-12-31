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
		
		// Ajouter les �couteurs
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
		System.out.print("Administrateur syst�me : bouton ");

		// Bouton afficherEtatEcran
		//
		if(e.getSource() == vueAS.getEtatEcran()) {
			String action = "afficher l'�tat d'un �cran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton ConsulterErreurs
		//
		if(e.getSource() == vueAS.getConsulterErreurs()) {
			String action = "Consulter les erreurs d'un �cran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton SavoirQuiAEteintEcran
		//
		if(e.getSource() == vueAS.getSavoirQuiA()) {
			String action = "Savoir qui a �teint l'�cran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton StopperEcran
		//
		if(e.getSource() == vueAS.getStopperEcran()) {
			String action = "Stopper un �cran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton DeclarerSites
		//
		if(e.getSource() == vueAS.getDeclarerSite()) {
			String action = "D�clarer un site";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton DeclarerEcran
		//
		if(e.getSource() == vueAS.getDeclarerEcran()) {
			String action = "D�clarer un �cran";
			System.out.println(action);
			enregistrerAction(modele.getConn(), action);
		}

		// Bouton DeplacerEcran
		//
		if(e.getSource() == vueAS.getDeplacerEcran()) {
			String action = "D�placer un �cran";
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
