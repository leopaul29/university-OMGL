package Controleur;

import Modele.*;
import Vue.IHMAssocierAfficheur;

public class ControleurAfficheurIHM {
	
	private IHMAssocierAfficheur IHMa;
	
	public ControleurAfficheurIHM(){
		this.IHMa = new IHMAssocierAfficheur();
//		new BoutonAssocier(associer);
//		new BoutonAnnuler(annuler);
		this.IHMa.getBtnAfficher().addActionListener(new BoutonAssocier());
	}

	/**
	 * 
	 * @param e
	 */
	public void setAfficheur(Ecran e) {

	}

	public void annulerSelectAfficheur() {
		throw new UnsupportedOperationException();
	}
	
	/*
	class BoutonAssocier implements ActionListener{
		
		private JButton b;
		
		public BoutonAssocier(JButton b){
			this.b=b;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	class BoutonAnnuler implements ActionListener{

		private JButton b;
		
		public BoutonAnnuler(JButton b){
			this.b=b;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	*/

}