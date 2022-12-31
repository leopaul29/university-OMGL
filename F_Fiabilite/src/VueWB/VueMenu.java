package VueWB;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VueMenu extends JPanel {
	private JTextField txt_nom;
	private JPasswordField txt_pass;
	private JComboBox<String> liste_role;
	private JButton Connexion;
	private JButton Quitter;

	/**
	 * Create the panel.
	 */
	public VueMenu() {
		setLayout(null);
		
		JLabel lblPageDeConnexion = new JLabel("Page de Connexion");
		lblPageDeConnexion.setBounds(166, 11, 136, 14);
		add(lblPageDeConnexion);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(136, 74, 46, 14);
		add(lblNom);
		
		txt_nom = new JTextField();
		txt_nom.setBounds(216, 71, 86, 20);
		add(txt_nom);
		txt_nom.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(136, 116, 67, 14);
		add(lblPassword);
		
		txt_pass = new JPasswordField();
		txt_pass.setBounds(216, 113, 86, 20);
		add(txt_pass);
		
		JLabel lblRle = new JLabel("R\u00F4le :");
		lblRle.setBounds(194, 155, 46, 14);
		add(lblRle);
		
		liste_role = new JComboBox<String>();
		DefaultComboBoxModel<String> mod_role = new DefaultComboBoxModel<String>();
		mod_role.addElement("Concepteur d'Ecran");
		mod_role.addElement("Administrateur d'Ecran");
		mod_role.addElement("Administrateur Système");
		mod_role.addElement("Super Administrateur");
		liste_role.setModel(mod_role);
		liste_role.setBounds(136, 185, 169, 20);
		add(liste_role);
		
		Connexion = new JButton("Connexion");
		Connexion.setBounds(114, 249, 106, 23);
		add(Connexion);
		
		Quitter = new JButton("Quitter");
		Quitter.setBounds(241, 249, 100, 23);
		add(Quitter);

	}

	public JTextField getTxt_nom() {
		return txt_nom;
	}

	public void setTxt_nom(JTextField txt_nom) {
		this.txt_nom = txt_nom;
	}

	public JPasswordField getTxt_pass() {
		return txt_pass;
	}

	public void setTxt_pass(JPasswordField txt_pass) {
		this.txt_pass = txt_pass;
	}

	public JComboBox<String> getListe_role() {
		return liste_role;
	}

	public void setListe_role(JComboBox<String> choix_role) {
		this.liste_role = choix_role;
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
