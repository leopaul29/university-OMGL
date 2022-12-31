package Modele;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

import Controleur.*;

public class Modele_Renderer {
	private ControleurAssocieRenderer controleurAssocieRenderer_;
	private LinkedList<Renderer> liste_renderer;

	public Modele_Renderer(){
		liste_renderer = new LinkedList<Renderer>();
		load();
	}
	
	
	public void load(){
		File f = new File("_Config/");
		
		for(int i = 0 ; i < f.list().length;i++){
			Renderer rend = (Renderer) Config.load("_Config/"+f.list()[i], "");
			liste_renderer.add(rend);
		}
	}
	
	
	public LinkedList<Renderer> getRenderer(Zone aZone) {
		
		LinkedList<Renderer> aenvoyer = new LinkedList<Renderer>();
		
		for(int i = 0 ; i < liste_renderer.size() ; i++){
			Renderer rend = liste_renderer.get(i);
			double taille =  (aZone.getDimension().getWidth() * aZone.getDimension().getHeight());
			if(rend.getType_bloc() == aZone.isType_bloc() && rend.getType_text() == aZone.isType_text() 
					&& taille < rend.getTaille_max() && taille > rend.getTaille_min()){
				aenvoyer.add(rend);
			}
		}
		
		return liste_renderer;
	}
	
}