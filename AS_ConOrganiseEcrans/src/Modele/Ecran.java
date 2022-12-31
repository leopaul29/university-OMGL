package Modele;

public class Ecran {
	private String nom;
	private String position;
	private Site site;

	public Ecran(Site aS, String aPosition, String aNom) {
		this.nom=aNom;
		this.position=aPosition;
		this.site=aS;
		(this.site).addEcran(this);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "Ecran [nom=" + nom + ", position=" + position + /*", site="
				+ site +*/ "]";
	}

}