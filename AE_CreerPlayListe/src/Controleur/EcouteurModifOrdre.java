package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import Modele.GestionnaireSources;
import Vue.ModifOrdre;

public class EcouteurModifOrdre implements ActionListener{

	private ControleurPlayList createur;
	@SuppressWarnings("unused")
	private GestionnaireSources modele;
	
	public EcouteurModifOrdre(ControleurPlayList createur, GestionnaireSources modele){
		this.createur = createur;
		this.modele = modele;
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(unSelect(createur.getPan_menu().ecran.group) ){
			JFrame n = new JFrame();
			n.setSize(800,600);
			ModifOrdre pan = new ModifOrdre(n);
			n.setTitle("Modifier l'ordre");
			Ecran b = ecranSelect(createur.getPan_menu().ecran.group);
			setListAll(pan.getListe());
			pan.getQuitter().addActionListener(new EcouteurQuitter(n));
			//-- ecouteur Liste
			pan.getD().addActionListener(new EcouteurMonterOrdre(pan, pan.getListe()));
			pan.getG().addActionListener(new EcouteurDescendreOrdre(pan, pan.getListe()));
			pan.getVal().addActionListener(new EcouteurValiderMO(pan, pan.getListe(),b));
			n.setContentPane(pan);
			n.setVisible(true);
		
		}
	}
	
	public boolean unSelect(ButtonGroup group){
		for(int i = 0 ; i < group.getButtonCount() ; i++){
			if (createur.getPan_menu().ecran.liste_button.get(i).isSelected()){
				System.out.println("Modifier l'Ordre d'affichage des sources d'un ecran selectionné : "+createur.getPan_menu().ecran.liste_button.get(i).isSelected());
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unused")
	public Ecran ecranSelect(ButtonGroup group){
		
		for(int i = 0 ; i < group.getButtonCount() ; i++){
			if (createur.getPan_menu().ecran.liste_button.get(i).isSelected()){
				String titre = createur.getPan_menu().ecran.liste_button.get(i).getText();
				int indice =(Integer) createur.getLesbouton().get(titre);
				Ecran b = (Ecran) createur.getLesEcrans().get(i);
				return b;
			}
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setListAll(JList jList){
			GestionnaireSources gs = new GestionnaireSources("_Sources/all_sources.txt");
			DefaultListModel lm=new DefaultListModel();
			for(int i = 0 ; i < gs.getTab_sources().size();i++){
				lm.addElement((String) gs.getTab_sources().get(i));
			}
			jList.setModel(lm);
			jList.setLayoutOrientation(JList.VERTICAL_WRAP);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setList(Ecran e, JList jList){
		GestionnaireSources gs = e.getModele();
		DefaultListModel lm=new DefaultListModel();
			for(int i = 0 ; i < gs.getTab_sources().size();i++){
			lm.addElement((String) gs.getTab_sources().get(i));
		}
		jList.setModel(lm);
		jList.setLayoutOrientation(JList.VERTICAL_WRAP);
	}
}
