package Modele;

import java.util.ArrayList;

import javax.sound.midi.MidiDevice.Info;

import Modele.Site;

public class Gestionnaire {
	private ArrayList<Site> site = new ArrayList<Site>();
	
	public Gestionnaire(){
		this.site=new ArrayList<Site>();
	}

	public ArrayList<Site> getListe_site() {
		return this.site;
	}
	
	public void addList(Site s){
		this.site.add(s);
	}

	public ArrayList<Site> getSite() {
		return site;
	}

	public void setSite(ArrayList<Site> site) {
		this.site = site;
	}

	@Override
	public String toString() {
		return "Gestionnaire [site=" + site + "]";
	}
}