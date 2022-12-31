package Controleur;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Modele.Modele;

public class EcouteurFermerFenetre implements WindowListener{

	private Modele modele;
	
	public EcouteurFermerFenetre(Modele modele){
		
		this.modele = modele;
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		if(modele.getConn() != null) {
			System.out.println("Fermeture de la session de : " + modele.getConn().getPersonne().getNom());
			modele.seDeconnecter();
		}
		System.out.println("Fermeture du systeme");
		modele.deconnexionSyst();
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
