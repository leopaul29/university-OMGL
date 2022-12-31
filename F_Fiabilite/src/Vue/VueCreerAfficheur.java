package Vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueCreerAfficheur extends JFrame{

	// ---								Attributs
	//
	private JPanel panneauSupport;
	private JButton cZoneTxt;
	private JButton cZoneBloc;
	private JButton cZoneAlert;
	private JButton nommerZone;
	private JButton associeStyleAff;
	private JButton retour;
	
	// ---								Constructeur par défaut
	//
	public VueCreerAfficheur() {
		
		setTitle("Concepteur d'écran");
		setSize(300, 160);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panneauSupport = new JPanel();
		getContentPane().add(panneauSupport);
		panneauSupport.setBackground(Color.YELLOW);
		panneauSupport.setLayout(new GridLayout(4, 2));

		cZoneTxt = new JButton("Créer une zone de texte");
		panneauSupport.add(cZoneTxt);

		cZoneBloc = new JButton("Créer une zone de bloc");
		panneauSupport.add(cZoneBloc);

		cZoneAlert = new JButton("Créer une zone d'alerte");
		panneauSupport.add(cZoneAlert);

		nommerZone = new JButton("Nommer une zone");
		panneauSupport.add(nommerZone);

		associeStyleAff = new JButton("associeStyleAff");
		panneauSupport.add(associeStyleAff);

		retour = new JButton("Retour");
		panneauSupport.add(retour);
		
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

	public JButton getcZoneTxt() {
		return cZoneTxt;
	}

	public void setcZoneTxt(JButton cZoneTxt) {
		this.cZoneTxt = cZoneTxt;
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

	public JButton getRetour() {
		return retour;
	}

	public void setRetour(JButton retour) {
		this.retour = retour;
	}
}
