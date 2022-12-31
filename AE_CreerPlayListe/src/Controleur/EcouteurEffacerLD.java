package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

public class EcouteurEffacerLD implements ActionListener{
private JList<?> l1;
@SuppressWarnings("rawtypes")
private JList l2;

		public EcouteurEffacerLD(JPanel createur, @SuppressWarnings("rawtypes") JList list1, @SuppressWarnings("rawtypes") JList list2) {
			this.l1 = list1;
			this.l2 = list2;
		}
		
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {

				@SuppressWarnings("rawtypes")
				DefaultListModel dl2 = (DefaultListModel) l2.getModel();
				@SuppressWarnings("rawtypes")
				DefaultListModel dl = (DefaultListModel) l1.getModel();
				if(l2.getSelectedValue() != null){
					System.out.println("Enleve '"+l2.getSelectedValue()+"' de la liste "
							+ "pour le remettre dans la liste à gauche");
					dl.addElement(l2.getSelectedValue());
					dl2.removeElement(l2.getSelectedValue());
					
					l1.setModel(dl);
					l2.setModel(dl2);
				}
			
		}
		
		public boolean getListe(@SuppressWarnings("rawtypes") JList l){
			for (int i = 0 ; i < l.getSize().getHeight() ; i++){
				if(l.isSelectedIndex(i))
					return true;
			}
			return false;
		}
}
