package Vue;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueMenu extends JFrame{

	// ---								Attributs
	//
	private JPanel panneauSupport;
	private JTextField txt_nom;
	private JTextField txt_pass;
	private JButton Connexion;
	private JButton Quitter;
	private Choice liste_role;
	
	// ---								Constructeur par défaut
	//
	public VueMenu() {
		
		setTitle("Menu connexion");
		setSize(300, 160);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panneauSupport = new JPanel();
		getContentPane().add(panneauSupport);
		panneauSupport.setBackground(Color.YELLOW);
		panneauSupport.setLayout(new GridLayout(4, 2));

		JLabel lab_nom = new JLabel("Nom :");
		txt_nom = new JTextField();
		panneauSupport.add(lab_nom);
		panneauSupport.add(txt_nom);
		
		JLabel lab_pass = new JLabel("Password :");
		txt_pass = new JTextField();
		panneauSupport.add(lab_pass);
		panneauSupport.add(txt_pass);
		
		JLabel lab_role= new JLabel("Role :");
		liste_role = new Choice();
		liste_role.add("Concepteur d'Ecran");
		liste_role.add("Administrateur d'Ecran");
		liste_role.add("Administrateur Système");
		liste_role.add("Super Administrateur");
		panneauSupport.add(lab_role);
		panneauSupport.add(liste_role);
		
		Connexion = new JButton("Connexion");
		Quitter = new JButton("Quitter");
		panneauSupport.add(Connexion);
		panneauSupport.add(Quitter);
		
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

	public JTextField getTxt_nom() {
		return txt_nom;
	}

	public void setTxt_nom(JTextField txt_nom) {
		this.txt_nom = txt_nom;
	}

	public JTextField getTxt_pass() {
		return txt_pass;
	}

	public void setTxt_pass(JTextField txt_pass) {
		this.txt_pass = txt_pass;
	}

	public Choice getListe_role() {
		return liste_role;
	}

	public void setListe_role(Choice liste_role) {
		this.liste_role = liste_role;
	}

	public JButton getConnexion() {
		return Connexion;
	}

	public void setConnexion(JButton connexion) {
		Connexion = connexion;
	}

	public JButton getQuitter() {
		return Quitter;
	}

	public void setQuitter(JButton quitter) {
		Quitter = quitter;
	}
}
