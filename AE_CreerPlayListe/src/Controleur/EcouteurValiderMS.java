	package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import Modele.GestionnaireSources;

public class EcouteurValiderMS implements ActionListener{
@SuppressWarnings("unused")
private JPanel createur;
@SuppressWarnings("rawtypes")
private JList l2;
private Ecran ecran;

	@SuppressWarnings("rawtypes")
	public EcouteurValiderMS(JPanel createur, JList jList, Ecran ecran) {
		this.createur = createur;
		this.l2 = jList;
		this.ecran = ecran;
	}
	


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void actionPerformed(ActionEvent arg0) {
		LinkedHashMap a = new LinkedHashMap<Integer, String>();
			

			DefaultListModel dm = (DefaultListModel) l2.getModel();
			for (int i = 0 ; i < dm.getSize();i++){
				a.put(i, dm.elementAt(i));
				System.out.println("Sources selectionnée : "+dm.getElementAt(i));
			}
		
			System.out.println("Sources validée\n");
		GestionnaireSources.store(a, "_Sources/"+ecran.getSource());
	}
	
	@SuppressWarnings("rawtypes")
	public boolean getListe(JList l1){
		for (int i = 0 ; i < l1.getSelectedIndices().length ; i++){
			if(l1.isSelectedIndex(i))
				return true;
		}
		return false;

}
}
