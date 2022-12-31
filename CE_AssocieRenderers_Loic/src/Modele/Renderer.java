package Modele;

import java.io.Serializable;

public class Renderer implements Serializable {
		
	private Object type_information;
	private Object type;
	private boolean type_text;
	private boolean type_bloc;
	private int taille_min;
	private int taille_max;
	private StockZone zone;
	
	public Renderer(){
		type_information = null;
		type = null;
		taille_min = 10;
		taille_max = 100;
		zone = new StockZone();
	}
	
	
	public void store(String name){
		Config.store(this, "_Config/"+name,"");
	}
	
	
	public Renderer load(String name){
		return (Renderer) Config.load(name, "");
	}


	public Object getType_information() {
		return type_information;
	}

	// -------------------- Méthode main
	public static void main(String args[]) {
		System.out.println("couc");
		Renderer a = new Renderer();
		a.store("coucou");

	}

	// -------------------- Méthode clone (a surcharger)
	protected Object clone() {
		Object o1 = new Object();

		return o1;
	}

	// -------------------- Méthode equals (a surcharger)
	public boolean equals(Object op2) {
		return false;
	}

	// -------------------- Méthode toString (a surcharger)
	public String toString() {
		String str = "";

		return str;
	}



	public void setType_information(Object type_information) {
		this.type_information = type_information;
	}


	public Object getType() {
		return type;
	}


	public void setType(Object type) {
		this.type = type;
	}


	public int getTaille_min() {
		return taille_min;
	}


	public void setTaille_min(int taille_min) {
		this.taille_min = taille_min;
	}


	public int getTaille_max() {
		return taille_max;
	}


	public void setTaille_max(int taille_max) {
		this.taille_max = taille_max;
	}


	public StockZone getZone() {
		return zone;
	}


	public void setZone(StockZone zone) {
		this.zone = zone;
	}


	public boolean getType_text() {
		return type_text;
	}


	public void setType_text(boolean type_text) {
		this.type_text = type_text;
	}


	public boolean getType_bloc() {
		return type_bloc;
	}


	public void setType_bloc(boolean type_bloc) {
		this.type_bloc = type_bloc;
	}
}
