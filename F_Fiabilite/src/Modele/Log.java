package Modele;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Log {

	// ---									Méthode enregistrerLog
	//
	public static void enregistrerLog (String texte, String directoryName, String fileName) { 

		String directoryPath = System.getProperty("user.dir") + "\\" + directoryName + "\\"; 
		String filePath = System.getProperty("user.dir") + "\\" + directoryName + "\\" + fileName ; 

		//Recupere le chemin du fichier et le chemin de repertoire grace aux parametre
		//
		File file = new File(filePath); 
		File dir = new File(directoryPath); 

		if (dir.exists() && dir.isDirectory() && file.exists()){ 

			try { 
				FileWriter fw = new FileWriter(filePath, true); 
				BufferedWriter output = new BufferedWriter(fw); 

				output.write(texte); 
				output.flush(); 
				output.close(); 


			} catch (IOException ioe) {  
				ioe.printStackTrace(); 
			} catch (java.lang.NullPointerException e){ 
				System.out.println ("Error"); 
				e.printStackTrace(); 
			} 
		} 

		//Crée le fichier s'il n'existe pas 
		//
		else{ 

			if (dir.exists() && dir.isDirectory()){ 

				try {
					file.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				System.out.println("New file at " + filePath); 

				try {	
					FileWriter fw = new FileWriter(filePath, true); 
					BufferedWriter output = new BufferedWriter(fw); 

					output.write(texte + "\r\n"); 
					output.flush(); 
					output.close(); 

					System.out.println("Log enregistré"); 
				} catch (IOException ioe) { 
					ioe.printStackTrace(); 
				} catch (java.lang.NullPointerException e){ 
					System.out.println ("Error"); 
					e.printStackTrace(); 
				} 
				//Ecrit le texte dans le fichier 
				//
			} 
			else{ 
				//Crée le dossier s'il n'existe pas ainsi que le fichier 
				//
				dir.mkdir(); 
				System.out.println("New directory at " + directoryPath); 

				try {
					file.createNewFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				System.out.println("New file at " + filePath);

				try { 
					FileWriter fw = new FileWriter(filePath, true); 
					BufferedWriter output = new BufferedWriter(fw); 

					output.write(texte); 
					output.flush(); 
					output.close(); 

				} catch (IOException ioe) { 
					ioe.printStackTrace(); 
				} catch (java.lang.NullPointerException e){ 
					System.out.println ("Error"); 
					e.printStackTrace(); 
				} 
			} 
		} 

	}

	// --- 										Méthode chargerLog
	//
	public static String chargerLog (String nomFichier) {

		if(nomFichier == null || nomFichier.length() == 0)
			return null;

		File fichier = new File(nomFichier);

		if(fichier.isDirectory()) return null;

		String contenuFichier = new String();
		BufferedReader lecture = null;

		try {
			//on ouvre un flux de lecture
			lecture = new BufferedReader(new FileReader(nomFichier));
			String s = new String();

			while((s=lecture.readLine())!=null)
			{
				if(s!=null);
				contenuFichier += s+"\r\n";//on recupére le contenu
			}
		} catch (IOException e) {
			System.out.println("Erreur sur la lecture du fichier: "+ nomFichier);
			System.out.println(e);
			return null;
		}
		finally{
			try {
				lecture.close();
			} catch (IOException e) {
				e.printStackTrace();
			}// on ferme le flux
		}

		return contenuFichier;


	}

	// ---										 Méthode recup_config
	//
	public static String recup_config(String config,String total){
		int bloc = total.indexOf(config);
		int bloc2 = bloc + config.length();
		String loption= "";

		for(int i = bloc2; total.charAt(i+1) != '\n'; i++){
			loption+=total.charAt(i);
		}
		return loption;
	}

	// ---										Méthode recup_lignePar
	//
	public static ArrayList<String> recup_lignePar(String critere, String total) {

		ArrayList<String> resultat = new ArrayList<String>();

		//if(!recup_id(critere, total)) return resultat;
		
		String loption = "";

		int bloc = total.indexOf(critere);
		System.out.println("bloc "+bloc);
		int bloc2 = bloc - critere.length();
		System.out.println("bloc2 "+bloc2);
		int bloc3 = bloc;

		while(bloc3 > bloc2) {
			for(int i = bloc2; total.charAt(i+1) != '\n'; i++){
				loption +=total.charAt(i);

				bloc2 = i;
			}

			resultat.add(loption);

			bloc3 = total.indexOf(critere, bloc2);

		}
		
		return resultat;

	}

	// ---										Méthode recup_id
	//
	public static boolean recup_id(String id, String total) {

		return total.indexOf(id) >= 0;
	}
}
