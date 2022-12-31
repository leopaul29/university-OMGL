package Vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueAS extends JFrame{

	// ---								Attributs
	//
	private JPanel panneauSupport;
	private JButton btnEtatEcran;
	private JButton btnConsulterErreurs;
	private JButton btnSavoirQuiA;
	private JButton btnStopperEcran;
	private JButton btnDeclarerSites;
	private JButton btnDeclarerEcrans;
	private JButton btnDeplacerEcran;
	private JButton btnEffacerSite;
	private JButton deconnexion;
	
	// ---								Constructeur par défaut
	//
	public VueAS() {
		
		setTitle("Administrateur systeme");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panneauSupport = new JPanel();
		getContentPane().add(panneauSupport);
		panneauSupport.setBackground(Color.YELLOW);
		panneauSupport.setLayout(new GridLayout(5, 2));
		
		btnEtatEcran = new JButton("Visualiser l'état des écrans");
		panneauSupport.add(btnEtatEcran);
		
		btnConsulterErreurs = new JButton("Consulter les erreurs");
		panneauSupport.add(btnConsulterErreurs);
		
		btnSavoirQuiA = new JButton("Savoir qui a éteint un écran");
		panneauSupport.add(btnSavoirQuiA);
		
		btnStopperEcran = new JButton("Stopper un écran");
		panneauSupport.add(btnStopperEcran);
		
		btnDeclarerSites = new JButton("Déclarer un site");
		panneauSupport.add(btnDeclarerSites);
		
		btnDeclarerEcrans = new JButton("Déclarer un écran");
		panneauSupport.add(btnDeclarerEcrans);
		
		btnDeplacerEcran = new JButton("Déplacer un écran");
		panneauSupport.add(btnDeplacerEcran);
		
		btnEffacerSite = new JButton("Effacer un site");
		panneauSupport.add(btnEffacerSite);

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

	public JButton getBtnEtatEcran() {
		return btnEtatEcran;
	}

	public void setBtnEtatEcran(JButton btnEtatEcran) {
		this.btnEtatEcran = btnEtatEcran;
	}

	public JButton getBtnConsulterErreurs() {
		return btnConsulterErreurs;
	}

	public void setBtnConsulterErreurs(JButton btnConsulterErreurs) {
		this.btnConsulterErreurs = btnConsulterErreurs;
	}

	public JButton getBtnSavoirQuiA() {
		return btnSavoirQuiA;
	}

	public void setBtnSavoirQuiA(JButton btnSavoirQuiA) {
		this.btnSavoirQuiA = btnSavoirQuiA;
	}

	public JButton getBtnStopperEcran() {
		return btnStopperEcran;
	}

	public void setBtnStopperEcran(JButton btnStopperEcran) {
		this.btnStopperEcran = btnStopperEcran;
	}

	public JButton getBtnDeclarerSites() {
		return btnDeclarerSites;
	}

	public void setBtnDeclarerSites(JButton btnDeclarerSites) {
		this.btnDeclarerSites = btnDeclarerSites;
	}

	public JButton getBtnDeclarerEcrans() {
		return btnDeclarerEcrans;
	}

	public void setBtnDeclarerEcrans(JButton btnDeclarerEcrans) {
		this.btnDeclarerEcrans = btnDeclarerEcrans;
	}

	public JButton getBtnDeplacerEcran() {
		return btnDeplacerEcran;
	}

	public void setBtnDeplacerEcran(JButton btnDeplacerEcran) {
		this.btnDeplacerEcran = btnDeplacerEcran;
	}

	public JButton getBtnEffacerSite() {
		return btnEffacerSite;
	}

	public void setBtnEffacerSite(JButton btnEffacerSite) {
		this.btnEffacerSite = btnEffacerSite;
	}

	public JButton getDeconnexion() {
		return deconnexion;
	}

	public void setDeconnexion(JButton deconnexion) {
		this.deconnexion = deconnexion;
	}
}
