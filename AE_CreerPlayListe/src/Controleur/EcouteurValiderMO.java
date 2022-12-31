package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

import javax.swing.JList;
import javax.swing.JPanel;

import Modele.GestionnaireSources;

public class EcouteurValiderMO implements ActionListener{
	private JList<?> l2;
	private Ecran ecran;

	public EcouteurValiderMO(JPanel createur, JList<?> jList, Ecran ecran) {
		this.l2 = jList;
		this.ecran = ecran;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		@SuppressWarnings("rawtypes")
		LinkedHashMap a = new LinkedHashMap();
		
		if(getListe(l2) == true){ 					// si liste pas vide
			for (int i = 0 ; i < l2.getSelectedValuesList().size();i++){
				a.put(i, l2.getSelectedValues()[i]);
				System.out.println("Ordre "+i+" : "+a.get(i));
			}
		}
		
		
		
		GestionnaireSources.store(a, "_Sources/"+ecran.getSource());
	}
	
	public boolean getListe(JList<?> l1){
		for (int i = 0 ; i < l1.getSelectedIndices().length ; i++){
			if(l1.isSelectedIndex(i))
				return true;
		}
		return false;
	}
}
