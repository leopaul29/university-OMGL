package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class EcouteurEnvoyerLD implements ActionListener {
private JList<?> l1;
private JList<?> l2;

	public EcouteurEnvoyerLD(JPanel createur, JList<?> list1, JList<?> list2) {
		this.l1 = list1;
		this.l2 = list2;
	}
	
	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
		
		
			@SuppressWarnings("rawtypes")
			DefaultListModel dl = (DefaultListModel<?>) l1.getModel();
			@SuppressWarnings("rawtypes")
			DefaultListModel dl2 = (DefaultListModel) l2.getModel();
			if(l1.getSelectedValue() != null){
				System.out.println("Rempli la liste que je veux selectionner avec '"+l1.getSelectedValue()+"' de la "
						+ "liste de gauche");
				dl2.addElement(l1.getSelectedValue());
				dl.removeElement(l1.getSelectedValue());
			
				l1.setModel(dl);
				l2.setModel(dl2);
			}
		
	}
	
	public boolean getListe(JList<?> l1){
		for (int i = 0 ; i < l1.getSelectedIndices().length ; i++){
			if(l1.isSelectedIndex(i))
				return true;
		}
		return false;
	}
}
