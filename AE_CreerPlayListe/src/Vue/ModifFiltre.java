package Vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ModifFiltre extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton quitter;
	private JButton valider;
	private List liste;
	private List lb;
	private JButton d;
	private JButton g;


	public JButton getVal(){return valider;}
	public List getListe(){return liste;}
	public List getlb(){return lb;}
	public JButton getD(){return d;	}
	public JButton getG(){return g;}
	public JButton getQuitter(){return quitter;}
	
	public ModifFiltre(JFrame createur){
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gb);
		
		///---TITRE
		c.weightx = 1;
		//c.weighty = 1;
		c.insets = new Insets(0, 1, 1, 1);
		c.gridx = 0; c.gridy = 0;
		c.gridwidth = 2; c.gridheight = 1;
		c.ipady = createur.getHeight()*1 /9;
		c.ipadx = createur.getWidth();
		JPanel fond = new JPanel();
		fond.add(new JLabel("Sélectionner un filtre"));
		fond.setBackground(Color.blue);
		gb.setConstraints(fond, c);
		add(fond);
		

		///---List
		c.gridx = 0; c.gridy = 1;
		c.gridwidth = 1; c.gridheight = 7;
		c.ipady = createur.getHeight() *10/20 ;
		c.ipadx = createur.getWidth() *2/3;
		fond = new JPanel();
		liste = new List();
		JLabel la = new JLabel("filtre disponible :");
		liste.add("Images");
		fond.add(la);
		fond.add(liste);
		 d = new JButton(">");
		 g = new JButton("<");
		fond.add(d);
		fond.add(g);
		lb = new List();
		fond.add(lb);
		Color c1 = new Color(0, 247, 132);
		fond.setBackground(c1);
		gb.setConstraints(fond, c);
		add(fond);
		
		///---vide
		c.gridx = 1; c.gridy = 1;
		c.gridwidth = 1; c.gridheight = 7;
		c.ipady = createur.getHeight() *10/20 ;
		c.ipadx = createur.getWidth() *1/3;
		fond = new JPanel();	
		fond.setBackground(c1);
		gb.setConstraints(fond, c);
		add(fond);
		setBackground(c1);
		
		//---ligne bas 
		c.gridx = 0; c.gridy = 8;
		c.gridwidth = 2; c.gridheight = 1;
		c.ipady = createur.getHeight() /9 ;
		c.ipadx = createur.getWidth();
		fond = new JPanel();
		fond.setLayout(new GridLayout(0,10));
		for(int i = 0;i <8;i++){
			JPanel vide = new JPanel();
			vide.setBackground(c1);
			fond.add(vide);
		}
		quitter = new JButton("Quitter");
		fond.add(quitter);
		valider = new JButton("Valider");
		fond.add(valider);

		gb.setConstraints(fond, c);
		add(fond);
		
		
	}
}
