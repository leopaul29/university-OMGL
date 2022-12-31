package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class EcouteurQuitter implements ActionListener{
	private JFrame createur;
	
	public EcouteurQuitter(JFrame createur) {
		this.createur = createur;
	}
	
	public void actionPerformed(ActionEvent e) {
		createur.dispose();
		System.out.println("Vous fermez la fenetre de : "+createur.getTitle());
	}

}
