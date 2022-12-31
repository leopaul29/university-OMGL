package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.Modele;
import Vue.VueAfficher;

public class ControleurAfficher implements ActionListener{

	// ---								Attributs
	//
	private Modele modele;
	private VueAfficher vueAfficher;

	// ---								Constructeur normal
	//
	public ControleurAfficher(Modele modele, VueAfficher vueAfficher, String contenu) {

		// Associer le modele
		//
		this.modele = modele;

		// Associer la vueAdmin
		//
		this.vueAfficher = vueAfficher;

		// Remplir la textarea du contenu
		//
		this.vueAfficher.getTxt_affiche().setText(contenu);

		// Ajouter les écouteurs
		//
		this.vueAfficher.getRetour().addActionListener(this);
		this.vueAfficher.getTrierRole().addActionListener(this);
		this.vueAfficher.getTrierNom().addActionListener(this);
		this.vueAfficher.getTrierDate().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("Admin : bouton ");

		// Bouton trierDate
		//
		if(e.getSource() == vueAfficher.getTrierDate()) {
			System.out.println("trier par date");

			trierDate(vueAfficher.getTitle());
		}
		
		// Bouton trierNom
		//
		if(e.getSource() == vueAfficher.getTrierNom()) {
			System.out.println("trier par nom");

			trierNom(vueAfficher.getTitle());
		}
		
		// Bouton trierRole
		//
		if(e.getSource() == vueAfficher.getTrierRole()) {
			System.out.println("trier par role");

			trierRole(vueAfficher.getTitle());
		}

		// Bouton retour
		//
		if(e.getSource() == vueAfficher.getRetour()) {
			System.out.println("retour");

			retourMenu();
		}
	}

	// ---									Méthode retourMenu
	//
	public void retourMenu() {

		// Revenir au menu
		//
		vueAfficher.dispose();
		//new ControleurAdmin(modele, new VueAdmin());	
	}
	
	// ---									Méthode trierDate
	//
	public void trierDate(String aAfficher) {
		
		vueAfficher.getTxt_affiche().setText(modele.afficher(aAfficher));
	}
	
	// ---									Méthode trierNom
	//
	public void trierNom(String aAfficher) {
		
		vueAfficher.getTxt_affiche().setText(modele.trierNom(aAfficher));
	}
	
	// ---									Méthode trierRole
	//
	public void trierRole(String aAfficher) {

		vueAfficher.getTxt_affiche().setText(modele.trierRole(aAfficher));
	}
}
