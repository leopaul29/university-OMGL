package Vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.LinkedHashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MenuPlayList extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton source;
	public JButton ordre;
	public JButton filtre;
	public JButton creer;
	public JButton quitter;
	public JButton modifier;
	
	public PanMenuPlayList ecran;

	
	public MenuPlayList(JFrame createur, LinkedHashMap<?, ?> modele){
		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		setLayout(gb);
		
		///---TITRE

		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(0, 1, 10, 1);
		c.gridx = 0; c.gridy = 0;
		c.gridwidth = 2; c.gridheight = 1;
		c.ipady = createur.getHeight()*1 /9;
		c.ipadx = createur.getWidth();
		JPanel fond = new JPanel();
		fond.add(new JLabel("Menu de gestion des écrans"));
		fond.setBackground(Color.blue);
		gb.setConstraints(fond, c);
		add(fond);
		
		
		
		
		
		///---écrans
		c.gridx = 0; c.gridy = 1;
		c.gridwidth = 1; c.gridheight = 7;
		c.ipady = createur.getHeight() *10/20 ;
		c.ipadx = createur.getWidth() *2/3;
		ecran = new PanMenuPlayList(ecran ,modele);
		gb.setConstraints(ecran, c);
		add(ecran);
		
		
		
		
		
		
		
		
		//----Menu de droite
		//----Bouton Modifier les sources
		c.insets = new Insets(1, 1, 1, 1);
		c.gridx = 1; c.gridy = 1;
		c.gridwidth = 1; c.gridheight = 1;
		c.ipady = createur.getHeight() /20 ;
		c.ipadx = createur.getWidth() *1/3;
		fond = new JPanel();
		source = new JButton("Modifier les sources");
        fond.add(source);
		gb.setConstraints(fond, c);
		add(fond);
		
		//----Bouton Modifier l'ordre de passage
		c.gridy = 2;
		fond = new JPanel();
		ordre = new JButton("Modifier l'ordre de passage");
        fond.add(ordre);
		gb.setConstraints(fond, c);
		add(fond);
		
		//----Bouton Modifier le filtre
		c.gridy = 3;
		fond = new JPanel();
		filtre = new JButton("Modifier le filtre");
        fond.add(filtre);
		gb.setConstraints(fond, c);
		add(fond);


		//----Bouton Creer Play List
		c.gridy = 4;
		fond = new JPanel();
		creer = new JButton("Creer PlayList");
        fond.add(creer);
		gb.setConstraints(fond, c);
		add(fond);

		
		//----Bouton Accédez au PlayList
		c.gridy = 5;
		fond = new JPanel();
		modifier = new JButton("Accéder aux PlayLists");
        fond.add(modifier);
		gb.setConstraints(fond, c);
		add(fond);
		
		//----Bouton Accédez au PlayList
		c.gridy = 6;
		fond = new JPanel();
		//JButton modifier = new JButton("Accéder au PlayList");
        fond.add(modifier);
		gb.setConstraints(fond, c);
		add(fond);
		
		//----Bouton Accédez au PlayList
		c.gridy = 7;
		fond = new JPanel();
		//JButton modifier = new JButton("Accéder au PlayList");
        fond.add(modifier);
		gb.setConstraints(fond, c);
		add(fond);
		
		
		//---ligne bas 
		c.gridx = 0; c.gridy = 8;
		c.gridwidth = 2; c.gridheight = 1;
		c.ipady = createur.getHeight() /9 ;
		c.ipadx = createur.getWidth();
		fond = new JPanel();
		fond.setLayout(new GridLayout(0,10));
		for(int i = 0;i <8;i++){
			JPanel vide = new JPanel();
			fond.add(vide);
		}
		quitter = new JButton("Quitter");
		fond.add(quitter);

		gb.setConstraints(fond, c);
		add(fond);
		
		
	}



}
