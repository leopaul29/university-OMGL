package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Modele.*;
import Vue.IHMAssocierAfficheur;

public class ControleurChoixIHM{
	private JButton b;
	
	public ControleurChoixIHM(JButton b){
		this.b=b;
		Bouton btn = new Bouton(this.b);
	}
	

	public String[] getListEcrans() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param e
	 */
	public void getListAfficheur(Ecran e) {

	}

	/**
	 * 
	 * @param a
	 */
	public void setAfficheurComp(Afficheur a) {

	}

	
	
	
	
	class Bouton implements ActionListener{
		
		JButton b;
		
		public Bouton(JButton b){
			this.b=b;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			new IHMAssocierAfficheur();
		}
		
	}

}