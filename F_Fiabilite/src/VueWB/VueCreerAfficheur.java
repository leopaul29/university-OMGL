package VueWB;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;

public class VueCreerAfficheur extends JPanel {

	private JButton cZoneTxt;
	private JButton retour;
	private JButton cZoneBloc;
	private JButton cZoneAlert;
	private JButton nommerZone;
	private JButton associeStyleAff;

	/**
	 * Create the panel.
	 */
	public VueCreerAfficheur() {
		setLayout(null);
		
		JLabel lblCrerUnAfficheur = new JLabel("Cr\u00E9er un afficheur");
		lblCrerUnAfficheur.setBounds(222, 11, 123, 14);
		add(lblCrerUnAfficheur);
		
		retour = new JButton("Retour");
		retour.setBounds(332, 266, 89, 23);
		add(retour);
		
		JPanel panel = new JPanel();
		panel.setBounds(102, 61, 303, 156);
		add(panel);
		panel.setLayout(new GridLayout(3, 2, 0, 0));
		
		cZoneTxt = new JButton("Cr\u00E9er Zone Bloc");
		panel.add(cZoneTxt);
		
		cZoneBloc = new JButton("Cr\u00E9er Zone Texte");
		panel.add(cZoneBloc);
		
		cZoneAlert = new JButton("Cr\u00E9er Zone Alerte");
		panel.add(cZoneAlert);
		
		nommerZone = new JButton("Nommer Zone");
		panel.add(nommerZone);
		
		associeStyleAff = new JButton("Style Afficheur");
		panel.add(associeStyleAff);

	}

	public JButton getcZoneTxt() {
		return cZoneTxt;
	}

	public void setcZoneTxt(JButton cZoneTxt) {
		this.cZoneTxt = cZoneTxt;
	}

	public JButton getRetour() {
		return retour;
	}

	public void setRetour(JButton retour) {
		this.retour = retour;
	}

	public JButton getcZoneBloc() {
		return cZoneBloc;
	}

	public void setcZoneBloc(JButton cZoneBloc) {
		this.cZoneBloc = cZoneBloc;
	}

	public JButton getcZoneAlert() {
		return cZoneAlert;
	}

	public void setcZoneAlert(JButton cZoneAlert) {
		this.cZoneAlert = cZoneAlert;
	}

	public JButton getNommerZone() {
		return nommerZone;
	}

	public void setNommerZone(JButton nommerZone) {
		this.nommerZone = nommerZone;
	}

	public JButton getAssocieStyleAff() {
		return associeStyleAff;
	}

	public void setAssocieStyleAff(JButton associeStyleAff) {
		this.associeStyleAff = associeStyleAff;
	}

}
