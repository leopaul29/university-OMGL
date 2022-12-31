package Vue;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class VueAE extends JFrame {

	// ---								Attributs
	//
	private JPanel panneauSupport;
	private JButton deconnexion;
	private JButton assocAffEcran;
	
	// ---								Constructeur par défaut
	//
	public VueAE() {
		
		setTitle("Administrateur d'écran");
		setSize(300, 160);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panneauSupport = new JPanel();
		getContentPane().add(panneauSupport);
		panneauSupport.setBackground(Color.YELLOW);
		panneauSupport.setLayout(new GridLayout(4, 2));

		assocAffEcran = new JButton("Associer afficheur écran");
		panneauSupport.add(assocAffEcran);
		
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

	public JButton getAssocAffEcran() {
		return assocAffEcran;
	}

	public void setAssocAffEcran(JButton assocAffEcran) {
		this.assocAffEcran = assocAffEcran;
	}

	public JButton getDeconnexion() {
		return deconnexion;
	}

	public void setDeconnexion(JButton deconnexion) {
		this.deconnexion = deconnexion;
	}
}
