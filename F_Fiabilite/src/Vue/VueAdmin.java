package Vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueAdmin extends JFrame{

	// ---								Attributs
	//
	private JPanel panneauSupport;
	private JButton afficherLog;
	private JButton deconnexion;
	private JButton creerID;
	private JButton afficherID;
	private JButton afficherAction;
	
	// ---								Constructeur par défaut
	//
	public VueAdmin() {
		
		setTitle("Administration");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panneauSupport = new JPanel();
		getContentPane().add(panneauSupport);
		panneauSupport.setBackground(Color.YELLOW);
		panneauSupport.setLayout(new GridLayout(5, 1));
		
		afficherLog = new JButton("Afficher les log");
		panneauSupport.add(afficherLog);
		
		afficherAction = new JButton("Afficher les actions");
		panneauSupport.add(afficherAction);
		
		creerID = new JButton("Créer un identifiant");
		panneauSupport.add(creerID);
		
		afficherID = new JButton("Afficher les identifiants");
		panneauSupport.add(afficherID);
		
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

	public JButton getAfficherLog() {
		return afficherLog;
	}

	public void setAfficherLog(JButton afficherLog) {
		this.afficherLog = afficherLog;
	}
	
	public JButton getCreerID() {
		return creerID;
	}

	public void setCreerID(JButton creerID) {
		this.creerID = creerID;
	}

	public JButton getAfficherID() {
		return afficherID;
	}

	public void setAfficherID(JButton afficherID) {
		this.afficherID = afficherID;
	}

	public JButton getAfficherAction() {
		return afficherAction;
	}

	public void setAfficherAction(JButton afficherAction) {
		this.afficherAction = afficherAction;
	}

	public JButton getDeconnexion() {
		return deconnexion;
	}

	public void setDeconnexion(JButton deconnexion) {
		this.deconnexion = deconnexion;
	}
}
