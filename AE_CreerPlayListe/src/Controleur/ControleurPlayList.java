package Controleur;

import java.util.LinkedHashMap;

import javax.swing.JFrame;

import Modele.Fichier;
import Modele.GestionnaireSources;
import Vue.MenuPlayList;

public class ControleurPlayList {
	private JFrame menu_play_list;
	private MenuPlayList pan_menu;
	private GestionnaireSources modele;
	private LinkedHashMap<Integer, Ecran> lesecrans = new LinkedHashMap<Integer, Ecran>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private LinkedHashMap<String, Integer> lesbouton = new LinkedHashMap();
	
	@SuppressWarnings("rawtypes")
	public LinkedHashMap getLesEcrans(){return lesecrans;}
	@SuppressWarnings("rawtypes")
	public LinkedHashMap getLesbouton() {
		return lesbouton;
	}
	@SuppressWarnings("unchecked")
	public void setLesbouton(@SuppressWarnings("rawtypes") LinkedHashMap lesbouton) {
		this.lesbouton = lesbouton;
	}
	public JFrame getMenu_play_list() {return menu_play_list;}
	public void setMenu_play_list(JFrame menu_play_list) {this.menu_play_list = menu_play_list;}
	public MenuPlayList getPan_menu() {return pan_menu;}
	public void setPan_menu(MenuPlayList pan_menu) {	this.pan_menu = pan_menu;}

	
	public ControleurPlayList(){
		menu_play_list = new JFrame("Menu");
		@SuppressWarnings("rawtypes")
		LinkedHashMap liste_ecrans = GestionnaireSources.load_ecran();
		
		for(int i = 0 ; i<liste_ecrans.size();i++){
			String gs = GestionnaireSources.recup_config("Sources : ", (String)Fichier.chargementFichierTexte("_Data/_Ecrans/"+liste_ecrans.get(i)));
			modele = new GestionnaireSources("_Sources/"+gs);
			lesecrans.put(i,new Ecran(modele,"Ecran "+i ,gs));
			lesbouton.put("Ecran "+i, i);
			GestionnaireSources.load_ecran();
		}
		menu_play_list.setSize(800, 600);
		menu_play_list.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pan_menu = new MenuPlayList(menu_play_list,lesecrans);
		menu_play_list.add(pan_menu);
		menu_play_list.setVisible(true);
		
		pan_menu.creer.addActionListener(new EcouteurCreerPlayList(this));
		pan_menu.filtre.addActionListener(new EcouteurModifFiltre(this));
		pan_menu.source.addActionListener(new EcouteurModifSource(this, modele));
		pan_menu.modifier.addActionListener(new EcouteurAccPL(this));
		pan_menu.quitter.addActionListener(new EcouteurQuitter(menu_play_list));
		pan_menu.ordre.addActionListener(new EcouteurModifOrdre(this,modele));
		
		

	}
	
	
	// -------------------- Méthode main
	public static void main(String args[]) {
		new ControleurPlayList();
		
	}
	
}
