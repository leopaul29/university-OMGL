package Vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueCE extends JFrame{

	// ---								Attributs
	//
	private JPanel panneauSupport;
	private JButton deconnexion;
	private JButton creerAfficheur;
	private JButton associeRenderers;
	
	// ---								Constructeur par défaut
	//
	public VueCE() {
		
		setTitle("Concepteur d'écran");
		setSize(300, 160);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panneauSupport = new JPanel();
		getContentPane().add(panneauSupport);
		panneauSupport.setBackground(Color.YELLOW);
		panneauSupport.setLayout(new GridLayout(3, 2));

		creerAfficheur = new JButton("Créer un afficheur");
		panneauSupport.add(creerAfficheur);
		
		associeRenderers = new JButton("Associer renderers");
		panneauSupport.add(associeRenderers);

		deconnexion = new JButton("Se déconnecter");
		panneauSupport.add(deconnexion);
		
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

	public JButton getCreerAfficheur() {
		return creerAfficheur;
	}

	public void setCreerAfficheur(JButton creerAfficheur) {
		this.creerAfficheur = creerAfficheur;
	}

	public JButton getAssocieRenderers() {
		return associeRenderers;
	}

	public void setAssocieRenderers(JButton associeRenderers) {
		this.associeRenderers = associeRenderers;
	}

	public JButton getDeconnexion() {
		return deconnexion;
	}

	public void setDeconnexion(JButton deconnexion) {
		this.deconnexion = deconnexion;
	}
}
