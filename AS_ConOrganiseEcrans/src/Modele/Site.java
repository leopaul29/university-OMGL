package Modele;

import java.util.ArrayList;
import Modele.Ecran;

public class Site {
	private String nom;
	private String localisation;
	private ArrayList<Ecran> ecrans = new ArrayList<Ecran>();

	public Site(String nom, String localisation){
		this.nom=nom;
		this.localisation=localisation;
		this.ecrans=new ArrayList<Ecran>();
//		this.g=g;
//		(this.g).addList(this);
	}
	
	public void addEcran(Ecran e) {
		this.ecrans.add(e);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public ArrayList<Ecran> getEcrans() {
		return ecrans;
	}

	public void setEcrans(ArrayList<Ecran> ecrans) {
		this.ecrans = ecrans;
	}

	@Override
	public String toString() {
		return "Site [nom=" + nom + ", localisation=" + localisation + ", " + "ecrans=" + ecrans + /*", g=" + g +*/ "]";
	}
}