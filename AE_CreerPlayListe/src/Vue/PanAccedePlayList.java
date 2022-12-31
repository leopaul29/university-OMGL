package Vue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import Modele.GestionnaireSources;

import java.awt.Color;

public class PanAccedePlayList extends JPanel {
	private JTextField textField;
	private JButton btnQuitter;
	private JButton btnValider;
	private JList list;

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JButton getBtnQuitter() {
		return btnQuitter;
	}

	public void setBtnQuitter(JButton btnQuitter) {
		this.btnQuitter = btnQuitter;
	}

	public JButton getBtnValider() {
		return btnValider;
	}

	public void setBtnValider(JButton btnValider) {
		this.btnValider = btnValider;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	/**
	 * Create the panel.
	 */
	public PanAccedePlayList(JFrame createur) {
		setLayout(null);
		createur.setTitle("Acceder au PlayList");
		
		JLabel lblPlaylistDisponible = new JLabel("PlayList disponible :");
		lblPlaylistDisponible.setBounds(94, 178, 160, 14);
		add(lblPlaylistDisponible);
		
		 list = new JList();
		list.setBounds(94, 211, 148, 295);
		add(list);
		
		textField = new JTextField();
		textField.setBounds(332, 209, 220, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblPlaylistRenommer = new JLabel("PlayList \u00E0 renommer");
		lblPlaylistRenommer.setBounds(332, 178, 166, 14);
		add(lblPlaylistRenommer);
		
		 btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(516, 490, 89, 23);
		add(btnQuitter);
		
		 btnValider = new JButton("Valider");
		btnValider.setBounds(628, 490, 89, 23);
		add(btnValider);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 11, 770, 77);
		add(panel);
		
		JLabel lblAccederAuPlaylist = new JLabel("Acceder au PlayList");
		panel.add(lblAccederAuPlaylist);

	}
}
