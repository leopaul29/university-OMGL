package VueWB;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueAdmin extends JPanel {

	private JButton afficherLog;
	private JButton creerID;
	private JButton afficherID;
	private JButton afficherAction;
	private JButton deconnexion;

	/**
	 * Create the panel.
	 */
	public VueAdmin() {
		setLayout(null);
		
		JLabel lblAdministration = new JLabel("Administration");
		lblAdministration.setBounds(182, 11, 90, 14);
		add(lblAdministration);
		
		afficherLog = new JButton("Afficher LOG");
		afficherLog.setBounds(69, 66, 135, 47);
		add(afficherLog);
		
		afficherAction = new JButton("Afficher ACTIONS");
		afficherAction.setBounds(230, 66, 135, 47);
		add(afficherAction);
		
		creerID = new JButton("Cr\u00E9er un ID");
		creerID.setBounds(69, 139, 135, 47);
		add(creerID);
		
		afficherID = new JButton("Afficher ID");
		afficherID.setBounds(230, 139, 135, 47);
		add(afficherID);
		
		deconnexion = new JButton("D\u00E9connexion");
		deconnexion.setBounds(252, 266, 111, 23);
		add(deconnexion);

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
