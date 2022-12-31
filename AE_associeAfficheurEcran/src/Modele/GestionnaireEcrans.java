package Modele;

import java.util.ArrayList;

public class GestionnaireEcrans {
	private ArrayList<Ecran> listEcran;
	private ArrayList<Afficheur> listAfficheur;
	
	public GestionnaireEcrans(){
		this.listEcran = new ArrayList<Ecran>();
		this.listAfficheur = new ArrayList<Afficheur>();
	}

	public ArrayList<Ecran> getListEcran() {
		return listEcran;
	}
	public void setListEcran(ArrayList<Ecran> listEcran) {
		this.listEcran = listEcran;
	}
	public ArrayList<Afficheur> getListAfficheur() {
		return listAfficheur;
	}
	public void setListAfficheur(ArrayList<Afficheur> listAfficheur) {
		this.listAfficheur = listAfficheur;
	}
	
	public void addEcran(Ecran e){
		this.listEcran.add(e);
	}
	
	public void addAfficheur(Afficheur a){
		this.listAfficheur.add(a);
	}

	@Override
	public String toString() {
		return "GestionnaireEcrans [listEcran=" + listEcran + ", listAfficheur=" + listAfficheur + "]";
	}
}