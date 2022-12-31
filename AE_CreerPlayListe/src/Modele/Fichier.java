
package Modele;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

public class Fichier {
	
	public static String chargementFichierTexte (String nomFichier){
		
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
	
	
	public static boolean sauvegardeFichierTexte (String nomFichier, String contenu ){
		
		if(nomFichier == null || nomFichier.length() == 0)
			return false;
		
		File fichier = new File(nomFichier);
		
		if(fichier.isDirectory()) return false;
		
		String cont = contenu.replace("\n", "\r\n");
		
		if(!fichier.exists()){
			try {
				fichier.createNewFile();
			} catch (IOException e) {
				System.out.printf("Impossible de creer le fichier: " + fichier.getName());
				return false;
			}
		}
		
		PrintWriter ecriture = null;
		
		try {
			//on ouvre un flux d'écriture
			ecriture = new PrintWriter(new BufferedWriter(new FileWriter(fichier)));
			ecriture.println(cont);
			
		} catch (IOException e) {
			System.out.println("Erreur lors de l'ecriture dans le fichier: "+ nomFichier);
			return false;
		}
		finally{
			ecriture.close();// on ferme le flux
		}
		
		return true;
	}
	
	
	
	public static BufferedImage chargementFichierImage(String chemin){
		
		File fichier = new File(chemin);
		
		if(!fichier.isFile()) return null;
		
		BufferedImage image = null;
		try {
			image = ImageIO.read(fichier);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return image;
	}

}
