package Modele;

import Controleur.ControleurAssocieRenderer;

public class Modele_Afficheur {
	private ControleurAssocieRenderer controleurAssocieRenderer_;
	private Afficheur afficheur;
	
	
	public Modele_Afficheur(){
		afficheur = new Afficheur();
	}
	
	
	public void setRenderer(Renderer aRend, Zone zone) {
		zone.setRenderer(aRend);
	}

	public void store() {
		throw new UnsupportedOperationException();
	}
}