package VueWB;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VueAE extends JPanel {

	private JButton deconnexion;
	private JButton assocAffEcran;

	/**
	 * Create the panel.
	 */
	public VueAE() {
		setLayout(null);
		
		JLabel lblAdministrateurDcran = new JLabel("Administrateur d'\u00E9cran");
		lblAdministrateurDcran.setBounds(218, 11, 158, 14);
		add(lblAdministrateurDcran);
		
		assocAffEcran = new JButton("Associer afficheur Ecran");
		assocAffEcran.setBounds(184, 73, 164, 75);
		add(assocAffEcran);
		
		deconnexion = new JButton("Deconnexion");
		deconnexion.setBounds(300, 266, 113, 23);
		add(deconnexion);

	}

	public JButton getDeconnexion() {
		return deconnexion;
	}

	public void setDeconnexion(JButton deconnexion) {
		this.deconnexion = deconnexion;
	}

	public JButton getAssocAffEcran() {
		return assocAffEcran;
	}

	public void setAssocAffEcran(JButton assocAffEcran) {
		this.assocAffEcran = assocAffEcran;
	}

}
