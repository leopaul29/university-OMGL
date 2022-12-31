package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import Vue.PanAccedePlayList;

public class EcouteurValiderRenomer implements ActionListener{
	private PanAccedePlayList createur;

	public EcouteurValiderRenomer(PanAccedePlayList createur){
		this.createur = createur;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		File a = new File("_Data/_PlayList/" + createur.getList().getSelectedValue());
		if(a.exists() == true)
			if(!createur.getTextField().getText().equals(null))
			{
				System.out.println("fichierSup : "+a);
				a.delete();
				File c = new File("_Data/_PlayList/" + createur.getTextField().getText());
				boolean b = a.renameTo(c);
				System.out.println("fichierRenommé : "+c);
			}
			else System.out.println("Nom de PlayList vide");
	}

}
