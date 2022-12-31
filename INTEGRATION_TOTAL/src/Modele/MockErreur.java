package Modele;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * Interface MockErreur :
 * 
 * Class pour ne pas avoir a developper la levée d'erreur.
 * 
 * Méthodes à implemtener :
 * getList_Erreur : 	Obtenir la liste d'erreur
 * addErreur : 			Ajouter des erreurs à cette liste
 * removeErreur : 		Supprimer des erreurs à cette liste
 * removeAll : 			Supprimer toutes les erreurs de cette liste
 * hasErreur :			Savoir si il y a une ou plusieurs erreurs
 * HasErreur :			Modifier la valeur de 'hasErreur'
 * 
 * @author LeoPaul
 *
 */
public interface MockErreur {

	/**
	 * Gets the list_ erreur.
	 *
	 * @return the list_ erreur
	 */
	ArrayList<String> getList_Erreur();
	
	/**
	 * Adds the erreur.
	 *
	 * @param erreur the erreur
	 */
	void addErreur(String erreur);
	
	/**
	 * Removes the erreur.
	 *
	 * @param i the i
	 */
	void removeErreur(int i);
	
	/**
	 * Removes the all.
	 */
	void removeAll();
	
	/**
	 * Checks for erreur.
	 *
	 * @return true, if successful
	 */
	boolean hasErreur();
	
	/**
	 * Sets the has erreur.
	 *
	 * @param erreur the erreur
	 * @return true, if successful
	 */
	boolean HasErreur(boolean erreur);
}
