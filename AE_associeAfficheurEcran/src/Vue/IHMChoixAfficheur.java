package Vue;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;

import Controleur.ControleurChoixIHM;

public class IHMChoixAfficheur extends JFrame {
	
	private ControleurChoixIHM controler;

	private JPanel contentPane;
	
	private JList list;
	private JList list_1;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	/**
	 * Create the frame.
	 */
	public IHMChoixAfficheur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 368);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		this.contentPane.setLayout(null);
		
		JLabel lblEcrans = new JLabel("Ecrans : ");
		lblEcrans.setBounds(31, 41, 46, 14);
		this.contentPane.add(lblEcrans);
		
		list = new JList();
		list.setBounds(132, 11, 117, 79);
		this.contentPane.add(list);
		
		JLabel lblAfficheurs = new JLabel("Afficheurs : ");
		lblAfficheurs.setBounds(31, 176, 59, 14);
		this.contentPane.add(lblAfficheurs);
		
		list_1 = new JList();
		list_1.setBounds(132, 156, 117, 84);
		this.contentPane.add(list_1);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(203, 285, 89, 23);
		this.contentPane.add(btnOk);
		this.setContentPane(contentPane);
		this.setBackground(Color.blue);
		this.setVisible(true);
	}
	
	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public JList getList_1() {
		return list_1;
	}

	public void setList_1(JList list_1) {
		this.list_1 = list_1;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public ControleurChoixIHM getControler() {
		return controler;
	}

	public void setControler(ControleurChoixIHM controler) {
		this.controler = controler;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}
}
