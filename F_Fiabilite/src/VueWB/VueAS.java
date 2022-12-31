package VueWB;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VueAS extends JPanel {

	private JButton EtatEcran;
	private JButton ConsulterErreurs;
	private JButton SavoirQuiA;
	private JButton StopperEcran;
	private JButton DeclarerSite;
	private JButton DeclarerEcran;
	private JButton DeplacerEcran;
	private JButton EffacerSite;
	private JButton Deconnexion;

	/**
	 * Create the panel.
	 */
	public VueAS() {
		setLayout(null);
		
		JLabel lblAdministrateurSystme = new JLabel("Administrateur Syst\u00E8me");
		lblAdministrateurSystme.setBounds(175, 11, 143, 14);
		add(lblAdministrateurSystme);
		
		JPanel panel = new JPanel();
		panel.setBounds(66, 56, 332, 164);
		add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		EtatEcran = new JButton("Etat Ecran");
		panel.add(EtatEcran);
		
		ConsulterErreurs = new JButton("Consulter Err");
		panel.add(ConsulterErreurs);
		
		SavoirQuiA = new JButton("Qui eteint ?");
		panel.add(SavoirQuiA);
		
		StopperEcran = new JButton("Stopper Ecran");
		panel.add(StopperEcran);
		
		DeclarerSite = new JButton("D\u00E9clarer Site");
		panel.add(DeclarerSite);
		
		DeclarerEcran = new JButton("D\u00E9clarer Ecran");
		panel.add(DeclarerEcran);
		
		DeplacerEcran = new JButton("D\u00E9placer Ecran");
		panel.add(DeplacerEcran);
		
		EffacerSite = new JButton("Effacer Site");
		panel.add(EffacerSite);
		
		Deconnexion = new JButton("D\u00E9connexion");
		Deconnexion.setBounds(276, 255, 122, 23);
		add(Deconnexion);

	}

	public JButton getEtatEcran() {
		return EtatEcran;
	}

	public void setEtatEcran(JButton etatEcran) {
		EtatEcran = etatEcran;
	}

	public JButton getConsulterErreurs() {
		return ConsulterErreurs;
	}

	public void setConsulterErreurs(JButton consulterErreurs) {
		ConsulterErreurs = consulterErreurs;
	}

	public JButton getSavoirQuiA() {
		return SavoirQuiA;
	}

	public void setSavoirQuiA(JButton savoirQuiA) {
		SavoirQuiA = savoirQuiA;
	}

	public JButton getStopperEcran() {
		return StopperEcran;
	}

	public void setStopperEcran(JButton stopperEcran) {
		StopperEcran = stopperEcran;
	}

	public JButton getDeclarerSite() {
		return DeclarerSite;
	}

	public void setDeclarerSite(JButton declarerSite) {
		DeclarerSite = declarerSite;
	}

	public JButton getDeclarerEcran() {
		return DeclarerEcran;
	}

	public void setDeclarerEcran(JButton declarerEcran) {
		DeclarerEcran = declarerEcran;
	}

	public JButton getDeplacerEcran() {
		return DeplacerEcran;
	}

	public void setDeplacerEcran(JButton deplacerEcran) {
		DeplacerEcran = deplacerEcran;
	}

	public JButton getEffacerSite() {
		return EffacerSite;
	}

	public void setEffacerSite(JButton effacerSite) {
		EffacerSite = effacerSite;
	}

	public JButton getDeconnexion() {
		return Deconnexion;
	}

	public void setDeconnexion(JButton deconnexion) {
		Deconnexion = deconnexion;
	}
}
