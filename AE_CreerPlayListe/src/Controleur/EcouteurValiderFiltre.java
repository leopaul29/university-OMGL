package Controleur;

import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;


public class EcouteurValiderFiltre implements ActionListener {
	public EcouteurValiderFiltre(JPanel createur, CheckboxGroup group, CheckboxGroup group2, Ecran ecran) {
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Valider le filtre");
	}

}
