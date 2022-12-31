package Controleur;

import Vue.IHMChoixAfficheur;

public class Launcher {
	
	public static void main(String[] args){
		IHMChoixAfficheur IHMChoix = new IHMChoixAfficheur();
		new ControleurChoixIHM(IHMChoix.getBtnOk());
	}

}
