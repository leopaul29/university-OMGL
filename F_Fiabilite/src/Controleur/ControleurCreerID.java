package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import Modele.Connexion;
import Modele.Modele;
import VueWB.VueCreerID;

public class ControleurCreerID extends Observable implements ActionListener{

	// ---								Attributs
	//
	private Modele modele;
	private VueCreerID vueCreerID;
	private ControleurAdmin controleurAdmin;

	// ---								Constructeur normal
	//
	public ControleurCreerID(Modele modele, VueCreerID vueCreerID, ControleurAdmin controleurAdmin) {

		// Associer le modele
		//
		this.modele = modele;

		// Associer la vueMenu
		//
		this.vueCreerID = vueCreerID;
		
		this.controleurAdmin = controleurAdmin;
		
		// Fixer les �couteur sur les boutons du menu
		//
		vueCreerID.getCreerID().addActionListener(this);
		vueCreerID.getAnnuler().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("CreerID : bouton ");

		// Bouton creation
		//
		if(e.getSource() == vueCreerID.getCreerID()) {
			System.out.println("cr�er");

			// R�cup�r� parametre de connexion
			//
			String nom = vueCreerID.getTxt_nom().getText();
			String mdp = vueCreerID.getTxt_pass().getText();
			String role = vueCreerID.getListe_role().getSelectedItem().toString();
			role = obtenirRole(role);

			// Creer ID
			//
			creationID(nom, mdp, role);
		}

		// Bouton Annuler
		//
		if(e.getSource() == vueCreerID.getAnnuler()) {
			System.out.println("annuler");

			// Revenir au menu
			//
			retourAdministration();
		}
	}

	// ---									M�thode creationID
	//
	public void creationID(String nom, String password, String role) {

		// Cr�erID
		//
		if(!nom.isEmpty() || !password.isEmpty()) {
			System.out.println("ID cr��e");
			creerIdentifiant(nom, password, role);
		}else System.out.println("ID non cr��e");

		// Revenir au menu admin
		//
		controleurAdmin.retourAdministration();
	}

	// ---									M�thode creerIdentifiant
	//
	public void retourAdministration() {
		
		// Revenir au menu
		//
		controleurAdmin.retourAdministration();
	}
	
	
	// ---									M�thode creerIdentifiant
	//
	public boolean creerIdentifiant(String nom, String password, String role) {

		boolean cID = (modele.creerIdentifiant(nom, password, role)) ? true : false;

		if(cID) enregistrerAction(modele.getConn(), "cr�ation d'identit�");

		return cID;
	}

	// ---									M�thode obtenirRole
	//
	public String obtenirRole(String abreviationRole) {
		return modele.obtenirRole(abreviationRole);
	}

	// ---									M�thode enregistrerAction
	//
	public void enregistrerAction(Connexion connexion, String l_action) {
		modele.enregistrerAction(connexion, l_action);
	}
}
