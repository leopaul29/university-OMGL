package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import Vue.PanCreerPlayList;

public class EcouteurValiderPlayList implements ActionListener{
private PanCreerPlayList		createur;


	public EcouteurValiderPlayList(PanCreerPlayList createur) {
	// TODO Auto-generated constructor stub
		this.createur = createur;
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		File c = null;
		if(!createur.getNom_playlist().getText().equals(null))
		{
			System.out.println("Enregistrement de la PlayList : "+createur.getNom_playlist().getText());
			c = new File("_Data/_PlayList/" + createur.getNom_playlist().getText() + ".txt");
			boolean b;
			try {
				b = c.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else System.out.println("Le nom de la PlayList est vide");
	}

}
