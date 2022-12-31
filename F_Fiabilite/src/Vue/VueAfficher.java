package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueAfficher extends JFrame {

	// ---								Attributs
	//
	private JPanel panneauSupport;
	private JButton retour;
	private TextArea txt_affiche;
	private JButton trierRole;
	private JButton trierDate;
	private JButton trierNom;
	
	// ---								Constructeur par défaut
	//
	public VueAfficher() {
		
		setTitle("Afficher");
		setSize(500, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		txt_affiche = new TextArea();
		txt_affiche.setEditable(false);
		getContentPane().add(txt_affiche, BorderLayout.CENTER);

		trierDate = new JButton("Trier par date");
		trierRole = new JButton("Trier par role");
		trierNom = new JButton("Trier par nom");
		retour = new JButton("Retour");
		JPanel pan_bouton = new JPanel();
		pan_bouton.setLayout(new GridLayout(1, 2));
		pan_bouton.add(trierDate);
		pan_bouton.add(trierRole);
		pan_bouton.add(trierNom);
		pan_bouton.add(retour);
		getContentPane().add(pan_bouton, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	// ---								Getter & Setter
	//
	public JPanel getPanneauSupport() {
		return panneauSupport;
	}

	public void setPanneauSupport(JPanel panneauSupport) {
		this.panneauSupport = panneauSupport;
	}

	public JButton getRetour() {
		return retour;
	}

	public void setRetour(JButton retour) {
		this.retour = retour;
	}

	public TextArea getTxt_affiche() {
		return txt_affiche;
	}

	public void setTxt_affiche(TextArea txt_affiche) {
		this.txt_affiche = txt_affiche;
	}

	public JButton getTrierRole() {
		return trierRole;
	}

	public void setTrierRole(JButton trierRole) {
		this.trierRole = trierRole;
	}

	public JButton getTrierNom() {
		return trierNom;
	}

	public void setTrierNom(JButton trierNom) {
		this.trierNom = trierNom;
	}

	public JButton getTrierDate() {
		return trierDate;
	}

	public void setTrierDate(JButton trierDate) {
		this.trierDate = trierDate;
	}
}
