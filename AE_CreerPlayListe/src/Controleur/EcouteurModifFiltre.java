package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import Vue.ModifFiltre;

public class EcouteurModifFiltre implements ActionListener{

	private ControleurPlayList createur;
	
	public EcouteurModifFiltre(ControleurPlayList createur){
		this.createur = createur;
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(unSelect(createur.getPan_menu().ecran.group) ){
			for(int i = 0; i< createur.getPan_menu().ecran.liste_button.size();i++){
				if(createur.getPan_menu().ecran.liste_button.get(i).isSelected() == true){
				}
			}
					
			JFrame n = new JFrame();
			n.setSize(800,600);
			ModifFiltre pan = new ModifFiltre(n);
			n.setTitle("Modifier les filtres");
			pan.getQuitter().addActionListener(new EcouteurQuitter(n));
			n.setContentPane(pan);
			n.setVisible(true);
		}
		
	}
	
	public boolean unSelect(ButtonGroup group){
		for(int i = 0 ; i < group.getButtonCount() ; i++){
			if (createur.getPan_menu().ecran.liste_button.get(i).isSelected()){
				System.out.println("Modifier le filtre d'un ecran selectionné : "+createur.getPan_menu().ecran.liste_button.get(i).isSelected());
				return true;
			}
		}
		return false;
	}

}
