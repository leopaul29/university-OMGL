package Modele;

public class Ecran {
	private String nom;
	private Dimension d;
	private Afficheur a;

	public Ecran(String nom, Dimension d){
		this.nom=nom;
		this.d=d;
	}
	
	public Ecran(String nom, Dimension d, Afficheur a){
		this.nom=nom;
		this.d=d;
		if (a.getDimension().equals(d)){
			this.a=a;
		}
	}	
	
	public Dimension getDimension() {
		return d;
	}

	public void setDimension(Dimension d) {
		this.d = d;
	}

	public Afficheur getAfficher() {
		return a;
	}

	private void setAfficher(Afficheur a) {
		this.a = a;
	}

	public Dimension getDimensions() {
		return d;
	}

	public boolean setAfficheurComp(Afficheur aA) {
		if (this.getDimensions().equals(aA.getDimension())){
			this.setAfficher(aA);
			return true;
		}
		else return false;
	}
	
	@Override
	public String toString() {
		return "Ecran [nom="+this.nom+", d=" + this.d + ", a=" + this.a + "]";
	}
}