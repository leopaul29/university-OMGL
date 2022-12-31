package Modele;

import java.awt.Color;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * The Class MyFile.
 * 
 * Version V0_0_X : Navigation dans le systeme et serialization de String
 * 
 * V0_0_0 : ls
 * V0_0_1 : lsR
 * V0_0_2 : lsL
 * V0_0_3 : enregistrerSous
 * V0_0_4 : charger
 * V0_0_5 : enregistrer
 * 
 * Version V0_1_X : Recuperation de texte
 * 
 * V0_1_0 : obtenirLigneApres
 * V0_1_1 : obtenirLigneAPartir, indiceExist
 * V0_1_2 : obtenirLigneContient
 * V0_1_3 : obtenirPremiereLigne
 * V0_1_4 : obtenirLigneNumero, ligneExiste
 * V0_1_5 : obtenirLigneNumero(CORRIGE), obtenirTouteLigneContient, nombreLigne
 * V0_1_6 : CORRECTION et renommage des methodes "obtenir"
 * V0_1_7 : obtenirLigneNumeraux
 * V0_1_8 : obtenirLignesContientS
 * V0_1_9 : obtenirCouleurs, obtenirCouleurLigne, obtenirCouleur
 * 
 * Version V0_2_X : 
 * 
 * V0_2_0 : encoderToXML, decoderFromXML
 * 
 * @author LeoPaul
 * 
 * A venir :
 * recup un partern (date!!)
 * ajouterPackage en haut des class
 * insererTexte a la ligne, X ligne
 * supprimerText a la ligne, X ligne
 * remplacer a la ligne, X ligne
 * supprimer a la ligne, X ligne
 *
 */
public class MyFile {

	// ---										Méthode ls
	//
	/**
	 * Ls.
	 * Afficher la liste de fichiers contenu dans le repertoire.
	 *
	 * @param chemin the chemin
	 */
	public static void ls(String chemin) {

		// Création de l'objet File, l'endroit où effectuer le "ls"
		//
		File dir = new File(chemin);

		// Déclarer une variable pour savoir le nombre de fichier que contient le répertoire
		//
		int nombre_fichier = 0;

		// Vérifier que le chemin est un répertoire
		//
		if(dir.isDirectory()) {

			try {

				// Parcourir la liste des fichiers du répertoires
				//
				for(File nom : dir.listFiles()) {

					// S'il s'agit d'un dossier, on ajoute un "/"
					//
					System.out.print(((nom.isDirectory()) ? nom.getName() + "/" : nom.getName()) + "\t\t");

					// Tout les 4 fichiers affiché, on saute un ligne dans l'affichage
					//
					if((nombre_fichier % 4) == 0)
						System.out.print("\n");

					// Incrémenter le nombre de fichiers parcourus
					//
					nombre_fichier ++;
				}
				System.out.println("\n");

				// Afficher le nombre de fichiers parcourus
				//
				System.out.println("Nombre de fichier(s) : " + nombre_fichier);

			} catch (NullPointerException e) {
				/* L'instruction peut générer une NullPointerException
				 * s'il n'y a pas de sous-fichier !
				 */
			}
		}

		else 
			System.out.println("'" + chemin + "' n'est pas un répertoire");

	}

	// ---										Méthode lsR
	//
	/**
	 * Ls r.
	 * Lister le contenu de chaque sous-répertoire.
	 *
	 * @param chemin the chemin
	 */
	public static void lsR(String chemin) {

		// Création de l'objet File, l'endroit où effectuer le "ls"
		//
		File dir = new File(chemin);

		// Vérifier que le chemin est un répertoire
		//
		if(dir.isDirectory()) {

			try {

				// Parcourir la liste des fichiers du répertoires
				//
				for(File nom : dir.listFiles()){

					// S'il s'agit d'un dossier, on ajoute un "/"
					//
					System.out.print(((nom.isDirectory()) ? nom.getName() + "/" : nom.getName()) + "\t");

					// S'il s'agit d'un dossier, je rappelle le "ls"
					//
					if(nom.isDirectory()) 
						lsR(nom.getAbsolutePath());

				}
				System.out.println("\n");

			} catch (NullPointerException e) {
				/* L'instruction peut générer une NullPointerException
				 * s'il n'y a pas de sous-fichier !
				 */
			}
		}

		else 
			System.out.println("'" + chemin + "' n'est pas un répertoire");

	}

	// ---										Méthode lsL
	//
	/**
	 * Ls l.
	 * Lister le contenu d'un repertoire.
	 *
	 * @param chemin the chemin
	 */
	public static void lsL(String chemin) {

		// Création de l'objet File, l'endroit où effectuer le "ls"
		//
		File dir = new File(chemin);

		// Déclarer une variable pour savoir le nombre de fichier que contient le repertoire
		//
		int nombre_fichier = 0;

		// Vérifier que le chemin est un répertoire
		//
		if(dir.isDirectory()) {

			System.out.println(chemin + "/ :\n");

			try {

				// Parcourir la liste des fichiers du répertoires
				//
				for(File nom : dir.listFiles()){

					//S'il s'agit d'un dossier, on ajoute un "/"
					//
					System.out.print(((nom.isDirectory()) ? nom.getName()+"/" : nom.getName()) + "\n");

					// Incrémenter le nombre de fichier parcourus
					//
					nombre_fichier ++;
				}
				System.out.println("\n");

				// Afficher le nombre de fichiers parcourus
				//
				System.out.println("Nombre de fichier(s) : " + nombre_fichier);

			} catch (NullPointerException e) {
				/* L'instruction peut générer une NullPointerException
				 * s'il n'y a pas de sous-fichier !
				 */
			}
		}

		else 
			System.out.println("'" + chemin + "' n'est pas un répertoire");

	}

	// ---										Méthode enregistrerSous
	//
	/**
	 * Enregistrer sous.
	 * Enregistrer un string dans un fichier.
	 *
	 * @param nomFichier the nom fichier
	 * @param contenu the contenu
	 * @return true, if successful
	 */
	public static boolean enregistrerSous(String nomFichier, String contenu) {

		// Vérifier les paramètres
		//
		if(nomFichier == null || nomFichier.length() == 0)
			return false;

		// Création de l'objet File
		//
		File fichier = new File(nomFichier);

		// Vérifier que le fichier n'est pas un répertoire
		//
		if(fichier.isDirectory()) return false;

		// Création du nouveau contenu
		//
		String nouveau_contenu = contenu.replace("\n", "\r\n");

		// Si le fichier n'existe pas
		//
		if(!fichier.exists()){

			try {

				// Création du fichier
				//
				fichier.createNewFile();
				System.out.println("Création du fichier : \"" + fichier.getName() + "\"");

			} catch (IOException e) {
				System.out.printf("Impossible de créer le fichier : \"" + fichier.getName() + "\"");
				return false;
			}
		}

		// Création un flux d'écriture
		//
		PrintWriter ecriture = null;

		try {

			// Ouvrir un flux d'écriture
			//
			ecriture = new PrintWriter(new BufferedWriter(new FileWriter(fichier)));

			// Ecrire le contenu dans le fichier
			//
			ecriture.println(nouveau_contenu);

		} catch (IOException e) {
			System.out.println("Erreur lors de l'écriture dans le fichier : \"" + fichier.getName() + "\"");
			return false;
		}
		finally{

			// Fermer le flux
			//
			ecriture.close();
		}

		// Le fichier a était enregistré
		//
		System.out.println("Enregristrement du fichier \"" + fichier.getName() + "\" effectué");
		return true;
	}

	// ---										Méthode enregistrer
	//
	/**
	 * Enregistrer.
	 * Ajouter du texte dans un fichier.
	 *
	 * @param nomFichier the nom fichier
	 * @param contenu the contenu
	 * @return true, if successful
	 */
	public static boolean enregistrer(String nomFichier, String contenu) {

		// Vérifier les paramètres
		//
		if(nomFichier == null || nomFichier.length() == 0)
			return false;

		// Création de l'objet File
		//
		File fichier = new File(nomFichier);

		// Vérifier que le fichier n'est pas un répertoire
		//
		if(fichier.isDirectory()) return false;

		// Création du nouveau contenu
		//
		String nouveau_contenu = contenu.replace("\n", "\r\n");

		// Si le fichier n'existe pas
		//
		if(!fichier.exists()){

			try {

				// Création du fichier
				//
				fichier.createNewFile();
				System.out.println("Création du fichier : \"" + fichier.getName() + "\"");

			} catch (IOException e) {
				System.out.printf("Impossible de creer le fichier : \"" + fichier.getName() + "\"");
				return false;
			}
		}

		// Création un flux d'écriture
		//
		BufferedWriter ecriture = null;

		try { 

			// Ouvrir un flux d'écriture
			//
			ecriture = new BufferedWriter(new FileWriter(nomFichier, true));

			// Ecrire le contenu dans le fichier
			//
			ecriture.write(nouveau_contenu + "\r\n");

		} catch (IOException e) {
			System.out.println("Erreur lors de l'ecriture dans le fichier : \"" + fichier.getName() + "\"");
			return false;
		}
		finally{

			// Fermer le flux
			//
			try {
				ecriture.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Le fichier a était enregistré
		//
		System.out.println("Enregristrement du fichier \"" + fichier.getName() + "\" effectué");
		return true;
	}

	// ---										Méthode charger
	//
	/**
	 * Charger.
	 * Obtenir le contenu d'un fichier texte.
	 *
	 * @param nomFichier the nom fichier
	 * @return the string
	 */
	public static String charger(String nomFichier) {

		// Vérifier les paramètres
		//
		if(nomFichier == null || nomFichier.length() == 0)
			return null;

		// Création de l'objet File
		//
		File fichier = new File(nomFichier);

		// Vérifier que le fichier n'est pas un répertoire
		//
		if(fichier.isDirectory()) return null;

		// Création d'un string pour accueillir le contenu du fichier
		//
		String contenuFichier = new String();

		// Création d'un flux de lecture
		//
		BufferedReader lecture = null;

		try {

			// Ouvrir un flux de lecture
			//
			lecture = new BufferedReader(new FileReader(nomFichier));

			// Création d'un string pour accueillir chaque lignes du fichier
			//
			String s = new String();

			// Tant que la ligne n'est pas vide
			//
			while((s = lecture.readLine()) != null) {

				// Vérifier que la ligne ne soit pas vide
				//
				if(s!=null)

					// Ajouter au contenu la ligne
					//
					contenuFichier += s+"\r\n";
			}

		} catch (IOException e) {
			System.out.println("Erreur sur la lecture du fichier : \"" + nomFichier + "\"");
			System.out.println(e);
			return null;
		}
		finally{

			// Fermer le flux
			//
			try {
				lecture.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Renvoyer le contenu du fichier texte
		//
		System.out.println("Chargement du fichier \"" + fichier.getName() + "\" effectué");
		return contenuFichier;
	}

	// ---										 Méthode obtenirLigneApres
	//
	/**
	 * obtenir ligne apres.
	 * Obtenir la ligne apres la première occurence de l'indice.
	 *
	 * @param indice the indice
	 * @param contenu the contenu
	 * @return the string
	 */
	public static String obtenirLigneApres(String indice, String contenu) {

		// Verfifier que l'indice existe
		//
		if(!indiceExist(indice, contenu)) return null;

		/* Obtenir le numero du premier caractère
		 *  de la premiere occurence de l'indice
		 *  dans le texte contenu
		 */
		int bloc = contenu.indexOf(indice);

		/* Déclarer un nombre qui correspond au dernier caractère
		 * de la premiere occurence de l'indice
		 * dans le texte contenu
		 */
		int bloc2 = bloc + indice.length();

		// Déclarer un string qui récupère le contenu de la ligne
		//
		String contenu_ligne = "";

		// Parcourir chaque caractère apres l'indice jusqu'au saut de ligne
		//
		for(int i = bloc2; contenu.charAt(i+1) != '\n'; i++)

			// Ajouter chaque caractère au string
			//
			contenu_ligne += contenu.charAt(i);

		// Renvoyer le contenu de la ligne apres l'indice
		//
		return contenu_ligne;
	}

	// ---										 Méthode recupererLigneAPartir
	//
	/**
	 * Recuperer ligne a partir.
	 *
	 * @param indice the indice
	 * @param total the total
	 * @return the string
	 */
	public static String recupererLigneAPartir(String indice, String total) {

		// Verfifier que le texte total contient l'indice
		//
		if(!indiceExist(indice, total)) return null;

		/* Obtenir le numero du premier caractere
		 *  de la premiere occurence de l'indice
		 *  dans le texte total
		 */
		int bloc = total.indexOf(indice);

		// Déclarer un string qui recupere le contenu de la ligne
		//
		String contenu_ligne = "";

		// Parcourir chaque caractere a partir de l'indice jusqu'au saut de ligne
		//
		for(int i = bloc; total.charAt(i+1) != '\n'; i++)

			// Ajouter chaque caractere au string
			//
			contenu_ligne+=total.charAt(i);

		// Renvoyer le contenu de la ligne apres l'indice
		//
		return contenu_ligne;
	}

	// ---										Méthode VérifierIndice
	//
	/**
	 * Indice exist.
	 * Vérifier que l'indice est dans le contenu.
	 *
	 * @param indice the indice
	 * @param contenu the contenu
	 * @return true, if successful
	 */
	public static boolean indiceExist(String indice, String contenu) {

		// Vérifier que le contenu ne soit pas vide
		//
		if(contenu.isEmpty()) return false;

		// Verfifier que le texte contenu contient l'indice
		//
		return contenu.indexOf(indice) >= 0;
	}

	// ---										 Méthode obtenirLigneContient
	//
	/**
	 * Obtenir ligne contient.
	 * Obtenir la ligne qui contient la première occurence de l'indice.
	 *
	 * @param indice the indice
	 * @param contenu the contenu
	 * @return the string
	 */
	public static String obtenirLigneContient(String indice, String contenu) {

		// Verfifier que l'indice existe
		//
		if(!indiceExist(indice, contenu) || nombreLigne(contenu) == -1) return null;

		// Parcourir chaque ligne du contenu
		//
		for(int i = 1; i <= nombreLigne(contenu); i++) {

			// Obtenir le contenu de la ligne parcouru
			//
			String contenuLigneN = obtenirLigneNumero(i, contenu);

			// Ajouter la ligne si elle contient l'indice
			//
			if(indiceExist(indice, contenuLigneN)) return contenuLigneN;
		}

		return null;
	}

	// ---										 Méthode obtenirPremiereLigne
	//
	/**
	 * obtenir premiere ligne.
	 * Obtenir la première ligne du contenu.
	 *
	 * @param contenu the contenu
	 * @return the string
	 */
	public static String obtenirPremiereLigne(String contenu) {

		// Vérfifier que le contenu n'est pas vide
		//
		if(contenu.isEmpty()) return null;

		// Déclarer un string qui récupère le contenu de la ligne
		//
		String contenu_ligne = ""; // Important pour les autres méthodes !!!

		// Parcourir chaque caractère jusqu'au saut de ligne
		//
		for(int i = 0; contenu.charAt(i+1) != '\n'; i++)

			// Ajouter chaque caractère au string
			//
			contenu_ligne += contenu.charAt(i);

		// Renvoyer le contenu de la premiere ligne
		//
		return contenu_ligne;
	}

	// ---										 Méthode obtenirLigneNumero
	//
	/**
	 * Obtenir ligne numero.
	 * Obtenir le numero de la ligne demandée dans le contenu.
	 *
	 * @param numeroLigne the numero ligne
	 * @param contenu the contenu
	 * @return the string
	 */
	public static String obtenirLigneNumero(int numeroLigne, String contenu) {

		/* Verfifier que le contenu n'est pas vide,
		 * que le numero de ligne n'est pas inferieur ou égale à 0,
		 * que le nombre de ligne soit superieur à -1
		 */
		if(contenu.isEmpty() || numeroLigne <= 0 || nombreLigne(contenu) == -1) return null;

		// Vérifier si le numero de ligne est égale à 1
		//
		if(numeroLigne == 1) return obtenirPremiereLigne(contenu);

		// Déclarer un numero de ligne parcourus
		//
		int numLigneParcouru = 1;

		do {
			// Incrémenter le nombre de ligne parcourus
			//
			numLigneParcouru ++;

			// Obtenir l'index de la prochaine ligne à parcourir
			//
			int firstLigneLength = obtenirPremiereLigne(contenu).length() + 2;

			// Redéfinir le contenu sans la première ligne
			//
			contenu = contenu.substring(firstLigneLength);

			// Vérifier si la ligne parcouru est la ligne demandée
			//
			if(numLigneParcouru == numeroLigne) return obtenirPremiereLigne(contenu);

			// Vérifier si le contenu est vide
			//
			if(contenu.isEmpty()) return null;

		}while(true);

	}

	// ---										 Méthode ligneExiste
	//
	/**
	 * Ligne existe.
	 * Vérifie si la ligne existe dans le contenu.
	 *
	 * @param numeroLigne the numero ligne
	 * @param contenu the contenu
	 * @return true, if successful
	 */
	public static boolean ligneExiste(int numeroLigne, String contenu) {

		// Vérifier si la ligne demandée n'est pas null
		//
		return obtenirLigneNumero(numeroLigne, contenu) != null;
	}

	// ---										 Méthode obtenirLignesContient
	//
	/**
	 * Obtenir lignes contient.
	 * Obtenir les lignes qui contiennent l'indice dans le contenu.
	 *
	 * @param indice the indice
	 * @param contenu the contenu
	 * @return the array list
	 */
	public static ArrayList<String> obtenirLignesContient(String indice, String contenu) {

		// Verfifier que l'indice existe
		//
		if(!indiceExist(indice, contenu) || nombreLigne(contenu) == -1) return null;

		// Déclarer un resultat
		//
		ArrayList<String> resultat = new ArrayList<String>();

		// Parcourir chaque ligne du contenu
		//
		for(int i = 1; i < nombreLigne(contenu); i++) {

			// Obtenir le contenu de la ligne parcouru
			//
			String contenuLigneN = obtenirLigneNumero(i, contenu);

			// Ajouter la ligne si elle contient l'indice
			//
			if(indiceExist(indice, contenuLigneN)) resultat.add(contenuLigneN);
		}

		// Renvoyer le resultat
		//
		return resultat;
	}

	// ---										 Méthode nombreLigne
	//
	/**
	 * Nombre ligne.
	 * Obtenir le nombre de lignes du contenu.
	 *
	 * @param contenu the contenu
	 * @return the int
	 */
	public static int nombreLigne(String contenu) {

		// Verfifier si le contenu n'est pas vide
		//
		if(contenu.isEmpty()) return -1;

		// Déclarer un numero de ligne parcourus
		//
		int numLigneParcouru = 0;

		do {
			// Incrémenter le nombre de ligne parcourus
			//
			numLigneParcouru ++;

			// Obtenir l'index de la prochaine ligne à parcourir
			//
			int firstLigneLength = obtenirPremiereLigne(contenu).length() + 2;

			// Redéfinir le contenu sans la première ligne
			//
			contenu = contenu.substring(firstLigneLength);

			// Renvoyer le nombre de ligne si le contenu est vide
			//
			if(contenu.isEmpty()) return numLigneParcouru;

		}while(true);

	}

	// ---										 Méthode obtenirLigneNumeraux
	//
	/**
	 * Obtenir ligne numeraux.
	 *
	 * @param liste_ligne the liste_ligne
	 * @param contenu the contenu
	 * @return the array list
	 */	
	public static ArrayList<String> obtenirLigneNumeraux(ArrayList<Integer> liste_ligne, String contenu) {

		// Verfifier si le contenu n'est pas vide
		//
		if(contenu.isEmpty() || liste_ligne == null) return null;

		// Déclarer un résultat
		//
		ArrayList<String> resultat = new ArrayList<String>();

		// Parcourir la liste de lignes demandées
		//
		for(int i = 0; i < liste_ligne.size(); i++) {

			// Obtenir la ligne demandée
			//
			int numeroligne = liste_ligne.get(i);

			// Vérifier que la ligne existe
			//
			if(ligneExiste(numeroligne, contenu))

				// Ajouter le contenu de la ligne
				//
				resultat.add(obtenirLigneNumero(numeroligne, contenu));
		}

		// Renvoyer la liste de resultat
		//
		return resultat;
	}

	// ---										 Méthode obtenirLignesContientS
	//
	/**
	 * Obtenir lignes contient s.
	 *
	 * @param liste_indice the liste_indice
	 * @param contenu the contenu
	 * @return the hash map
	 */
	public static HashMap<String, ArrayList<String>> obtenirLignesContientS(ArrayList<String> liste_indice, String contenu) {

		// Verfifier si le contenu n'est pas vide
		//
		if(contenu.isEmpty() || liste_indice == null) return null;

		// Déclarer un résultat
		//
		HashMap<String, ArrayList<String>> resultat = new HashMap<String, ArrayList<String>>();

		// Parcourir la liste d'indice
		//
		for(int i = 0; i < liste_indice.size(); i++) {

			// Obtenir l'indice de la liste
			//
			String indice = liste_indice.get(i);

			// Vérifier si l'indice est null ou vide, passer au prochain indice
			//
			if(indice == null || indice.isEmpty()) continue;

			// Obtenir les lignes qui contiennent l'indice
			//
			ArrayList<String> contenuIndice = obtenirLignesContient(indice, contenu);

			// Ajouter au HashMap la liste d'indice avec en clé l'indice
			//
			resultat.put(indice, contenuIndice);
		}

		// Renvoyer le resultat
		//
		return resultat;
	}

	// ---										 Méthode obtenirLignesContientS
	//
	/**
	 * Obtenir couleurs.
	 *
	 * @param contenu the contenu
	 * @return the array list
	 */
	public static ArrayList<Color> obtenirCouleurs(String contenu) {

		// Verfifier si le contenu n'est pas vide
		//
		if(contenu.isEmpty()) return null;

		// Déclarer un résultat
		//
		ArrayList<Color> liste_couleur = new ArrayList<Color>();

		// Déclarer l'indice à rechercher
		//
		String indice = "java.awt.Color[";

		// Parcourir chaque ligne du contenu
		//
		for(int i = 1; i <= nombreLigne(contenu); i++) {

			// Obtenir le contenu de la ligne parcouru
			//
			String contenuLigneN = obtenirLigneNumero(i, contenu);

			// Ajouter la ligne si elle contient l'indice
			//
			if(indiceExist(indice, contenuLigneN)) {

				// Obtenir la couleur de la ligne
				//
				Color couleur = obtenirCouleurLigne(indice, contenuLigneN);

				// Vérifier que la couleur n'est pas null
				//
				if(couleur != null)

					// Ajouter la couleur à la liste
					//
					liste_couleur.add(couleur);
			}
		}

		// Renvoyer la liste de couleur
		//
		return liste_couleur;
	}

	// ---										Méthode obtenirCouleurLigne
	//
	/**
	 * Obtenir couleur ligne.
	 *
	 * @param indice the indice
	 * @param couleurLigne the couleur ligne
	 * @return the color
	 */
	public static Color obtenirCouleurLigne(String indice, String couleurLigne) {

		// Obtenir String apres l'indice java.awt.Color[
		//
		String couleur = couleurLigne.substring(couleurLigne.indexOf(indice) + indice.length());

		// Obtenir String au format [r=xxx,g=xxx,b=xx]
		//
		couleur = couleur.substring(0, couleur.indexOf(']') + 1);

		// Renvoyer la couleur
		//
		return obtenirCouleur(couleur);

	}

	// ---										Méthode obtenirCouleur
	//
	/**
	 * Obtenir couleur.
	 *
	 * @param couleur the couleur
	 * @return the color
	 */
	public static Color obtenirCouleur(String couleur) {

		// Vérifier que l'indice n'est pas vide
		//
		if(couleur.isEmpty()) return null;

		// --- Necessite indice : [r=xxx,g=xxx,b=xxx] --- \\

		// Obtenir le numero du rouge
		//
		int red = Integer.valueOf(couleur.substring(2, couleur.indexOf(",g=")));

		// Obtenir le numero du vert
		//		
		int green = Integer.valueOf(couleur.substring(couleur.indexOf(",g=")+3, couleur.indexOf(",b=")));

		// Obtenir le numero du bleu
		//
		int blue = Integer.valueOf(couleur.substring(couleur.indexOf(",b=")+3, couleur.indexOf(']')));

		// Renvoyer la nouvelle couleur créée
		//
		return new Color(red,green,blue);
	}

	// --- 										Méthode encoderToXML
	//
	/**
	 * Encoder to xml.
	 *
	 * @param object the object
	 * @param nomFichier the nom fichier
	 * @return true, if successful
	 */
	public static boolean encoderToXML(Object object, String nomFichier) {

		// Ouvrir l'encodeur vers le fichier
		//
		XMLEncoder encoder = null;

		try {

			// Serialisation de l'objet
			//
			encoder = new XMLEncoder(new FileOutputStream(nomFichier));
			System.out.println("Création du fichier : \"" + nomFichier + "\"");

			// Ecrire dans le fichier
			//
			encoder.writeObject(object);
			encoder.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.printf("Impossible de créer le fichier : \"" + nomFichier + "\"");
			e.printStackTrace();
			return false;
			
		} finally {

			// Fermer l'encodeur
			//
			encoder.close();
		}

		// Le fichier a était enregistré
		//
		System.out.println("Enregristrement du fichier \"" + nomFichier + "\" effectué");
		return true;
	}

	// --- 										Méthode decoderFromFichier
	//
	/**
	 * Decoder from xml.
	 *
	 * @param nomFichier the nom fichier
	 * @return the object
	 */
	public static Object decoderFromXML(String nomFichier) {

		// Déclarer un objet d'accueille du contenu XML
		//
		Object object = null;

		// Ouvrir le decodeur
		//
		XMLDecoder decoder = null;

		try {

			// De-Serialisation de l'objet
			//
			decoder = new XMLDecoder(new FileInputStream(nomFichier));

			// Obtenir l'objet encodé
			//
			object = decoder.readObject();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Erreur sur la lecture du fichier : \"" + nomFichier + "\"");
			e.printStackTrace();
			
		} finally {

			// fermeture du decodeur
			//
			decoder.close();
		}

		// Renvoyer l'objet
		//
		System.out.println("Chargement du fichier \"" + nomFichier + "\" effectué");
		return object;
	}
}











