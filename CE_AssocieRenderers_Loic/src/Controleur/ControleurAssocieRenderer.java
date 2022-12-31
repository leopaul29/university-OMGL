package Controleur;																																																																								

import Modele.*;
import Vue.*;

public class ControleurAssocieRenderer {
	private Modele_Afficheur modele_Afficheur;
	private IHM_AssocieRenderer IHM_AssocieRenderer;
	private Modele_Renderer modele_Renderer;
	
	public ControleurAssocieRenderer(){
		modele_Afficheur = new Modele_Afficheur();
		modele_Renderer = new Modele_Renderer();
	}
	
	// -------------------- Méthode main
	public static void main(String args[]) {
		new ControleurAssocieRenderer();
		
	}

	// -------------------- Méthode clone (a surcharger)
	protected Object clone() {
		Object o1 = new Object();

		return o1;
	}

	// -------------------- Méthode equals (a surcharger)
	public boolean equals(Object op2) {
		return false;
	}

	// -------------------- Méthode toString (a surcharger)
	public String toString() {
		String str = "";

		return str;
	}


	
	public void setRenderer(Renderer aRend, Afficheur aAfficheur) {
		throw new UnsupportedOperationException();
	}

	public void getRenderer(Zone aZone) {
		throw new UnsupportedOperationException();
	}
}