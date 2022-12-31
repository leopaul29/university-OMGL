package Vue;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import Controleur.EcouteurValiderPlayList;

public class PanCreerPlayList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nom_playlist;
	private JList<?> list_source_g;
	private JButton btn_source_d;
	private JButton btn_source_g;
	@SuppressWarnings("rawtypes")
	private JList list_source_d;
	private JButton btn_quitter;
	private JButton btn_valider;
	@SuppressWarnings("rawtypes")
	private JList list_filtre_g;
	private JButton btn_filtre_d;
	private JButton btn_filtre_g;
	@SuppressWarnings("rawtypes")
	private JList list_filtre_d;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JButton btnCalendrier;
	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings("rawtypes")
	public PanCreerPlayList() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		panel.setBounds(10, 11, 780, 87);
		add(panel);
		
		JLabel lblCrationDePlaylist = new JLabel("Création de PlayList");
		panel.add(lblCrationDePlaylist);
	

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 185, 107, 128);
		add(scrollPane);
		
		
		list_source_g = new JList();
		scrollPane.setViewportView(list_source_g);
		
		 btn_source_d = new JButton(">");
		
		btn_source_d.setBounds(226, 220, 56, 23);
		add(btn_source_d);
		
		 btn_source_g = new JButton("<");
		btn_source_g.setBounds(226, 254, 56, 23);
		add(btn_source_g);
		
		JLabel lblNomDeLa = new JLabel("Nom de la PlayList : ");
		lblNomDeLa.setBounds(513, 130, 119, 14);
		add(lblNomDeLa);
		
		nom_playlist = new JTextField();
		nom_playlist.setBounds(631, 126, 107, 23);
		add(nom_playlist);
		nom_playlist.setColumns(10);
		
		 btn_quitter = new JButton("Quitter");
		btn_quitter.setBounds(548, 511, 102, 32);
		add(btn_quitter);
		
		 btn_valider = new JButton("Valider");
		 btn_valider.addActionListener(new EcouteurValiderPlayList(this));
		btn_valider.setBounds(660, 511, 107, 32);
		add(btn_valider);
		
		 btn_filtre_d = new JButton(">");
		btn_filtre_d.setBounds(226, 398, 56, 23);
		add(btn_filtre_d);
		
		 btn_filtre_g = new JButton("<");
		btn_filtre_g.setBounds(226, 432, 56, 23);
		add(btn_filtre_g);
		Color c1 = new Color(0, 247, 132);
		setBackground(c1);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(357, 185, 107, 128);
		add(scrollPane_1);
		
		 list_source_d = new JList();
		 scrollPane_1.setViewportView(list_source_d);
		 
		 scrollPane_2 = new JScrollPane();
		 scrollPane_2.setBounds(45, 363, 107, 128);
		 add(scrollPane_2);
		 
		 list_filtre_g = new JList();
		 scrollPane_2.setViewportView(list_filtre_g);
		 
		 scrollPane_3 = new JScrollPane();
		 scrollPane_3.setBounds(357, 363, 107, 128);
		 add(scrollPane_3);
		 
		  list_filtre_d = new JList();
		  scrollPane_3.setViewportView(list_filtre_d);
		  
		  btnCalendrier = new JButton("Calendrier");
		  btnCalendrier.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		JFrame a = new JFrame();
		  		a.setSize(800, 600);
		  		a.setContentPane(new Calendrier(0,0,1,new JPanel(), a));
		  		a.setVisible(true );
		  	}
		  });
		  btnCalendrier.setBounds(635, 220, 89, 23);
		  add(btnCalendrier);
		

	}
	
	
	// --------------------- Getter & Setter 
	public JTextField getNom_playlist() {return nom_playlist;}
	public void setNom_playlist(JTextField nom_playlist) {	this.nom_playlist = nom_playlist;}
	public JList<?> getList_source_g() {return list_source_g;}
	public void setList_source_g(JList<?> list_source_g) {this.list_source_g = list_source_g;}
	public JButton getBtn_source_d() {return btn_source_d;}
	public void setBtn_source_d(JButton btn_source_d) {this.btn_source_d = btn_source_d;}
	public JButton getBtn_source_g() {return btn_source_g;}
	public void setBtn_source_g(JButton btn_source_g) {this.btn_source_g = btn_source_g;}
	public JList<?> getList_source_d() {return list_source_d;}
	public void setList_source_d(JList<?> list_source_d) {this.list_source_d = list_source_d;}
	public JButton getBtn_quitter() {return btn_quitter;}
	public void setBtn_quitter(JButton btn_quitter) {this.btn_quitter = btn_quitter;}
	public JButton getBtn_valider() {return btn_valider;}
	public void setBtn_valider(JButton btn_valider) {this.btn_valider = btn_valider;}
	public JList<?> getList_filtre_g() {return list_filtre_g;}
	public void setList_filtre_g(JList<?> list_filtre_g) {this.list_filtre_g = list_filtre_g;}
	public JButton getBtn_filtre_d() {return btn_filtre_d;}
	public void setBtn_filtre_d(JButton btn_filtre_d) {this.btn_filtre_d = btn_filtre_d;}
	public JButton getBtn_filtre_g() {return btn_filtre_g;}
	public void setBtn_filtre_g(JButton btn_filtre_g) {this.btn_filtre_g = btn_filtre_g;}
	public JList<?> getList_filtre_d() {return list_filtre_d;}
	public void setList_filtre_d(JList<?> list_filtre_d) {this.list_filtre_d = list_filtre_d;}
}
