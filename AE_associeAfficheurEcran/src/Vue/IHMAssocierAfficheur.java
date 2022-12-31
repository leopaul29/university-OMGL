package Vue;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import Controleur.ControleurAfficheurIHM;

public class IHMAssocierAfficheur extends JFrame {
	
	private ControleurAfficheurIHM controler;

	private JPanel contentPane;
	
	private JButton btnAfficher, btnAnnuler;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHMAssocierAfficheur frame = new IHMAssocierAfficheur();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IHMAssocierAfficheur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVousAvezChoisi = new JLabel("Vous avez choisi : ");
		lblVousAvezChoisi.setBounds(162, 29, 101, 14);
		contentPane.add(lblVousAvezChoisi);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(69, 113, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(304, 113, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		btnAfficher = new JButton("Afficher");
		btnAfficher.setBounds(218, 206, 89, 23);
		contentPane.add(btnAfficher);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(119, 206, 89, 23);
		contentPane.add(btnAnnuler);
	}
	
	public ControleurAfficheurIHM getControler() {
		return controler;
	}

	public void setControler(ControleurAfficheurIHM controler) {
		this.controler = controler;
	}

	public JButton getBtnAfficher() {
		return btnAfficher;
	}

	public void setBtnAfficher(JButton btnAfficher) {
		this.btnAfficher = btnAfficher;
	}

	public JButton getBtnAnnuler() {
		return btnAnnuler;
	}

	public void setBtnAnnuler(JButton btnAnnuler) {
		this.btnAnnuler = btnAnnuler;
	}

	public ControleurAfficheurIHM getCa() {
		return controler;
	}

	public void setCa(ControleurAfficheurIHM ca) {
		this.controler = controler;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

}
