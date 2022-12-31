package VueWB;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VueCreerID extends JPanel {
	private JButton creerID;
	private JButton Annuler;
	private JComboBox<String> liste_role;
	private JPasswordField txt_pass;
	private JTextField txt_nom;

	/**
	 * Create the panel.
	 */
	public VueCreerID() {
		setLayout(null);

		JLabel lblPageDeConnexion = new JLabel("Création d'identifiant");
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

		creerID = new JButton("Créer ID");
		creerID.setBounds(114, 249, 106, 23);
		add(creerID);

		Annuler = new JButton("Annuler");
		Annuler.setBounds(241, 249, 100, 23);
		add(Annuler);

	}

	public JButton getCreerID() {
		return creerID;
	}

	public void setCreerID(JButton creerID) {
		this.creerID = creerID;
	}

	public JButton getAnnuler() {
		return Annuler;
	}

	public void setAnnuler(JButton annuler) {
		Annuler = annuler;
	}

	public JComboBox<String> getListe_role() {
		return liste_role;
	}

	public void setListe_role(JComboBox<String> liste_role) {
		this.liste_role = liste_role;
	}

	public JPasswordField getTxt_pass() {
		return txt_pass;
	}

	public void setTxt_pass(JPasswordField txt_pass) {
		this.txt_pass = txt_pass;
	}

	public JTextField getTxt_nom() {
		return txt_nom;
	}

	public void setTxt_nom(JTextField txt_nom) {
		this.txt_nom = txt_nom;
	}
}
