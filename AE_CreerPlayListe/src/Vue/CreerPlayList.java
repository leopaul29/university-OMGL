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

public class CreerPlayList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JFrame createur;
	public JButton quitter;
	

	public CreerPlayList(JFrame createur){
		this.createur = createur;
		
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gb);
		
		///---TITRE

		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 1, 50, 1);
		c.gridx = 0; c.gridy = 0;
		c.gridwidth = 6; c.gridheight = 3;
		c.ipady = createur.getHeight() * 1 /10;
		c.ipadx = createur.getWidth();
		JPanel fond = new JPanel();
		fond.add(new JLabel("Créer une Playlist"));
		fond.setBackground(Color.blue);
		gb.setConstraints(fond, c);
		add(fond);
		

		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 500, 1, 1);
		c.gridx = 0; c.gridy = 4;
		c.gridwidth = 1; c.gridheight = 1;
		c.ipady = createur.getHeight() * 1 /20;
		c.ipadx = createur.getWidth() *1 /40;
		 fond = new JPanel();
		fond.add(new JLabel("Créer une Playlist"));
		fond.setBackground(Color.blue);
		gb.setConstraints(fond, c);
		add(fond);
		
		
		
		///---List 1
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 1, 1, 1);
		c.gridx = 0; c.gridy = 6;
		c.gridwidth = 1; c.gridheight = 2;
		c.ipady = createur.getHeight() * 1 / 4;
		c.ipadx = createur.getWidth() * 1 / 10;
		 fond = new JPanel();
		fond.add(new List());
		gb.setConstraints(fond, c);
		add(fond);
		
		///---Bouton
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 1, 1, 1);
		c.gridx = 1; c.gridy = 6;
		c.gridwidth = 1; c.gridheight = 1;
		c.ipady = createur.getHeight() *1 /40;
		c.ipadx = createur.getWidth() * 1 / 20;
		 fond = new JPanel();
		 fond.setLayout(new GridLayout(2,1));
		fond.add(new JButton(">"));
		fond.add(new JButton("<"));
		gb.setConstraints(fond, c);
		add(fond);
		
		
		///---List 1
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 1, 1, 1);
		c.gridx = 2; c.gridy = 6;
		c.gridwidth = 1; c.gridheight = 2;
		c.ipady = createur.getHeight() * 1 / 4;
		c.ipadx = createur.getWidth() * 1 / 10;
		 fond = new JPanel();
		fond.add(new List());
		gb.setConstraints(fond, c);
		add(fond);
		
		
		///---List 1
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 1, 1, 1);
		c.gridx = 0; c.gridy = 8;
		c.gridwidth = 1; c.gridheight = 2;
		c.ipady = createur.getHeight() * 1 / 4;
		c.ipadx = createur.getWidth() * 1 / 10;
		 fond = new JPanel();
		fond.add(new List());
		gb.setConstraints(fond, c);
		add(fond);
		
		///---Bouton
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 1, 1, 1);
		c.gridx = 1; c.gridy = 8;
		c.gridwidth = 1; c.gridheight = 1;
		c.ipady = createur.getHeight() * 1 / 4;
		c.ipadx = createur.getWidth() * 1 / 10;
		 fond = new JPanel();
		fond.add(new JButton(">"));
		gb.setConstraints(fond, c);
		add(fond);
		
		///---Bouton
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 1, 1, 1);
		c.gridx = 1; c.gridy = 9;
		c.gridwidth = 1; c.gridheight = 1;
		c.ipady = createur.getHeight() * 1 / 4;
		c.ipadx = createur.getWidth() * 1 / 10;
		 fond = new JPanel();
		fond.add(new JButton("<"));
		gb.setConstraints(fond, c);
		add(fond);
		
	}
	
	
	
}
