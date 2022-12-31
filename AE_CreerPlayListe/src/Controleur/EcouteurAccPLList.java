package Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Vue.PanAccedePlayList;

public class EcouteurAccPLList implements MouseListener{
private PanAccedePlayList createur;

	public EcouteurAccPLList(PanAccedePlayList createur){
		this.createur = createur;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("PlayList selectionnée : " + createur.getList().getSelectedValue());
		createur.getTextField().setText((String) createur.getList().getSelectedValue());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
