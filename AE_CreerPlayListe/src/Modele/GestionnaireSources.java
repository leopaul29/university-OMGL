package Modele;

import java.io.File;
import java.util.LinkedHashMap;


public class GestionnaireSources {
	private ModeleFiltre [] modele_filtres;
	private ModeleSource [] modele_sources;
	private LinkedHashMap<Integer, String> tab_sources;
	
	
	public LinkedHashMap<Integer, String> getTab_sources() {
		return tab_sources;
	}
	public void setTab_sources(LinkedHashMap<Integer, String> tab_sources) {
		this.tab_sources = tab_sources;
	}
	public ModeleFiltre[] getModele_filtres() {return modele_filtres;}
	public void setModele_filtres(ModeleFiltre[] modele_filtres) {this.modele_filtres = modele_filtres;}
	public ModeleSource[] getModele_sources() {	return modele_sources;}
	public void setModele_sources(ModeleSource[] modele_sources) {	this.modele_sources = modele_sources;}
	
	// --------------------- Constructeur par défaut
	public GestionnaireSources(){
		tab_sources = load("Source_1.txt");
		
	}
	
	// --------------------- Constructeur normal (1)
	public GestionnaireSources(String chemin){
		tab_sources = load(chemin);
		
	}
	
	
	// --------------------- Méthode recup_config
	public static String recup_config(String config,String total){
		int bloc = total.indexOf(config);
		int bloc2 = bloc + config.length();
		String loption= "";
		
		for(int i = bloc2; total.charAt(i+1) != '\n'; i++){
			loption+=total.charAt(i);
		}
		return loption;
	}
	

	// --------------------- Méthode load 
	public static LinkedHashMap<Integer, String> load(String chemin){
		LinkedHashMap<Integer,String> donnees = new LinkedHashMap<Integer,String>();
		String enregistrement = Fichier.chargementFichierTexte("_Data/"+chemin);
		donnees= getImages("Image",enregistrement,100);
		
		return donnees;
	}
	
	// --------------------- Méthode load Ecran
	public static LinkedHashMap<Integer, String> load_ecran(){
		File a = new File("_Data/_Ecrans");
		LinkedHashMap<Integer, String> liste_ecrans = new LinkedHashMap<Integer, String>();
		for(int i = 0; i < a.list().length;i++)
			liste_ecrans.put(i,new File(a.list()[i]).getName());
		
		return liste_ecrans;
	}
	
	public static LinkedHashMap<Integer, String> getImages(String config, String enregistrement, int nombre_image){
		LinkedHashMap<Integer, String> liste_images = new LinkedHashMap<Integer, String>();	

		int bloc = config.indexOf(config);
		int bloc2 = bloc + config.length() ;
		String images ="";
	 
	 
		for(int k = 0 ; k < nombre_image;k++){
			images="";
			String taille = config +"("+k+") : ";
			bloc = enregistrement.indexOf(taille);
			bloc2 = bloc + taille.length()  ;	
			
			for(int j = bloc2; enregistrement.charAt(j+1) != '\n'; j++){
				images+=enregistrement.charAt(j);
			}
			
			liste_images.put(k,images);

		}

		return getOrdre(liste_images);
	}
	
	// --------------------- 
	public static LinkedHashMap<Integer, String> getOrdre(LinkedHashMap<Integer, String> config){
		LinkedHashMap<Integer, String> im_ordre = new LinkedHashMap<Integer, String>();
		for(int i = 0 ; i < config.size();i++){
			String enr = (String) config.get(i)+" \n";
			int ordre = Integer.valueOf(recup_config("Ordre : ", enr));
			im_ordre.put(ordre,(String)takeImage("Image("+i+") : ",(String) config.get(i)));
			
		} 	
		return im_ordre;
	}
	
	
	
	// --------------------- Méthode garder png
	public static String takeImage(String config, String total){
	
		String loption= "";
		for(int j = 0; total.charAt(j+1) != '#'; j++){
			loption+=total.charAt(j);
		}
		
		return loption;
	}
	
	// -------------------- Méthode store
	public static void store(LinkedHashMap<?, ?> a, String chemin){
		String enregistrement= "";
		
		for(int i=0;i<a.size();i++)
			enregistrement += "Image("+i+") : "+ a.get(i).toString() +" #Ordre : "+i + '\n';
		
		Fichier.sauvegardeFichierTexte("_Data/"+chemin, enregistrement);
	}
}
