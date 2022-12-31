package Modele;

public class Afficheur {
	private String nom;
	private Dimension d;
	private String auteur;
	private String style;

	public Afficheur(String nom, Dimension d){
		this.nom=nom;
		this.d=d;
		this.auteur=null;
		this.style=null;
	}

	public Afficheur(String nom, Dimension d, String auteur, String style){
		this.nom=nom;
		this.d=d;
		this.auteur=auteur;
		this.style=style;
	}

	public Dimension getDimension() {
		return d;
	}

	public void setDimension(Dimension d) {
		this.d = d;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public String toString() {
		return "Afficheur [nom=" + nom + ", d=" + d + ", auteur=" + auteur + ", style=" + style + "]";
	}

}