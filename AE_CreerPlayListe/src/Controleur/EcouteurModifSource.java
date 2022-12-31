package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import Modele.GestionnaireSources;
import Vue.ModifSource;

public class EcouteurModifSource implements ActionListener{

	private ControleurPlayList createur;
	@SuppressWarnings("unused")
	private GestionnaireSources modele;
	
	public EcouteurModifSource(ControleurPlayList createur, GestionnaireSources modele){
		this.createur = createur;
		this.modele = modele;
	}
		
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(unSelect(createur.getPan_menu().ecran.group) ){
			JFrame n = new JFrame();
			n.setSize(800,600);
			ModifSource pan = new ModifSource(n);
			n.setTitle("Modifier les sources");
			Ecran b = ecranSelect(createur.getPan_menu().ecran.group);
			setList(b,pan.getlb());
			setListAll(pan.getListe());

			//-- ecouteur Liste
			pan.getD().addActionListener(new EcouteurEnvoyerLD(pan, pan.getListe(), pan.getlb()));
			pan.getG().addActionListener(new EcouteurEffacerLD(pan, pan.getListe(), pan.getlb()));
			pan.getVal().addActionListener(new EcouteurValiderMS(pan, pan.getlb(),b));
			pan.getQuitter().addActionListener(new EcouteurQuitter(n));
			n.setContentPane(pan);
			n.setVisible(true);
		
		}
	}
	
	public boolean unSelect(ButtonGroup group){
		for(int i = 0 ; i < group.getButtonCount() ; i++){
			if (createur.getPan_menu().ecran.liste_button.get(i).isSelected()){
				System.out.println("Modifier les sources d'un ecran selectionné : "+createur.getPan_menu().ecran.liste_button.get(i).isSelected());
				return true;
			}
		}
		return false;
	}
	
	public Ecran ecranSelect(ButtonGroup group){
		
		for(int i = 0 ; i < group.getButtonCount() ; i++){
			if (createur.getPan_menu().ecran.liste_button.get(i).isSelected()){
				String titre = createur.getPan_menu().ecran.liste_button.get(i).getText();
				@SuppressWarnings("unused")
				int indice =(Integer) createur.getLesbouton().get(titre);
				Ecran b = (Ecran) createur.getLesEcrans().get(i);
				return b;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public void setListAll(@SuppressWarnings("rawtypes") JList l1){
		GestionnaireSources gs = new GestionnaireSources("_Sources/all_sources.txt");
		@SuppressWarnings("rawtypes")
		DefaultListModel lm=new DefaultListModel();
		for(int i = 0 ; i < gs.getTab_sources().size();i++){
			lm.addElement((String) gs.getTab_sources().get(i));
		}	
		l1.setModel(lm);
		l1.setLayoutOrientation(JList.VERTICAL_WRAP);
		}
	
	@SuppressWarnings("unchecked")
	public void setList(Ecran e, @SuppressWarnings("rawtypes") JList l1){
		GestionnaireSources gs = e.getModele();
		@SuppressWarnings("rawtypes")
		DefaultListModel lm=new DefaultListModel();
			for(int i = 0 ; i < gs.getTab_sources().size();i++){
			lm.addElement((String) gs.getTab_sources().get(i));
		}
		l1.setModel(lm);
		l1.setLayoutOrientation(JList.VERTICAL_WRAP);
		
		
	}
}
