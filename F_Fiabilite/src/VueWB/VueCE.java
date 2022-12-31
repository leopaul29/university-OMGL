package VueWB;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VueCE extends JPanel {

	private JButton creerAfficheur;
	private JButton associeRenderers;
	private JButton deconnexion;

	/**
	 * Create the panel.
	 */
	public VueCE() {
		setLayout(null);
		
		JLabel lblConcepteurEcran = new JLabel("Concepteur Ecran");
		lblConcepteurEcran.setBounds(205, 11, 124, 14);
		add(lblConcepteurEcran);
		
		creerAfficheur = new JButton("Cr\u00E9er Afficheur");
		creerAfficheur.setBounds(92, 81, 142, 64);
		add(creerAfficheur);
		
		associeRenderers = new JButton("Associer Renderers");
		associeRenderers.setBounds(244, 81, 142, 64);
		add(associeRenderers);
		
		deconnexion = new JButton("D\u00E9connexion");
		deconnexion.setBounds(274, 266, 112, 23);
		add(deconnexion);

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
