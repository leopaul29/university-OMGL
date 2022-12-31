package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedHashMap;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import Controleur.Ecran;

public class PanMenuPlayList extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LinkedHashMap<Integer,JRadioButton> liste_button;
	public ButtonGroup group;

	public ButtonGroup getGroup() {
		return group;
	}
	public void setGroup(ButtonGroup group) {
		this.group = group;
	}
	// --------------------- Constructeur par défaut 
	public PanMenuPlayList(){
		super();
	}
	
	
	// --------------------- Constructeur normal (1)
	public PanMenuPlayList(JPanel createur){
	/*	liste_button = new LinkedHashMap<Integer, JRadioButton>();
		setLayout(new GridLayout(3,3,5,5));
		JPanel fond = new JPanel();
		JPanel vide = new JPanel();
		vide.setBackground(Color.blue);
		group = new ButtonGroup();
		for(int i = 0; i<9;i++){
			fond = new JPanel();
			fond.setLayout(new BorderLayout());
			//Ecran r1 = (Ecran) new Ecran("Ecran "+i);
			r1.setBackground(Color.blue);
			JPanel bou = new JPanel();
			fond.add(r1,BorderLayout.NORTH);
			group.add(r1);
		
			fond.add(vide,BorderLayout.CENTER);
			fond.setBackground(Color.blue);
			liste_button.put(i,r1);
			add(fond);
		}*/
	}
	
	
	/*
	 * 
	 * V2
	 */
	// --------------------- Constructeur normal (2)
		public PanMenuPlayList(JPanel createur,LinkedHashMap<?, ?> modele){
			liste_button = new LinkedHashMap<Integer, JRadioButton>();
			setLayout(new GridLayout((int) Math.sqrt(modele.size()),(int) Math.sqrt(modele.size()),5,5));
			JPanel fond = new JPanel();
			JPanel vide = new JPanel();
			vide.setBackground(Color.blue);
			group = new ButtonGroup();
			for(int i = 0; i<modele.size();i++){
				fond = new JPanel();
				fond.setLayout(new BorderLayout());
				Ecran r1 = (Ecran) modele.get(i);
				
				r1.setBackground(Color.blue);
				fond.add(r1,BorderLayout.NORTH);
				group.add(r1);
			
				fond.add(vide,BorderLayout.CENTER);
				fond.setBackground(Color.blue);
				liste_button.put(i,r1);
				add(fond);
			}
		}

}
