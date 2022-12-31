package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import Modele.GestionnaireSources;
import Vue.*;

public class EcouteurCreerPlayList implements ActionListener {
	@SuppressWarnings("unused")
	private ControleurPlayList createur;
	public EcouteurCreerPlayList(ControleurPlayList createur){
		this.createur = createur;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame n = new JFrame("Creer PlayList");
		n.setSize(800, 600);
		PanCreerPlayList pan = new PanCreerPlayList();
		pan.getBtn_quitter().addActionListener(new EcouteurQuitter(n));
		@SuppressWarnings("rawtypes")
		JList l1 = pan.getList_source_g();
		remplirListAll(l1);
		@SuppressWarnings("rawtypes")
		DefaultListModel dm = new DefaultListModel();
		dm.addElement("");
		pan.getList_source_d().setModel(dm);
		pan.getBtn_source_d().addActionListener(new EcouteurEnvoyerLD(pan, l1, pan.getList_source_d()));
		n.setContentPane(pan);
		n.setVisible(true);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean remplirListAll(JList l1){
		GestionnaireSources gs = new GestionnaireSources("_Sources/all_sources.txt");
		DefaultListModel lm=new DefaultListModel();
			for(int i = 0 ; i < gs.getTab_sources().size();i++){
			lm.addElement((String) gs.getTab_sources().get(i));
		}
		l1.setModel(lm);
		l1.setLayoutOrientation(JList.VERTICAL_WRAP);
		return true;
	}

}
