package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.MutableComboBoxModel;

import Modele.GestionnaireSources;
import Vue.ModifFiltre;
import Vue.PanAccedePlayList;

public class EcouteurAccPL implements ActionListener{

private ControleurPlayList createur;
	
	public EcouteurAccPL(ControleurPlayList createur){
		this.createur = createur;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		JFrame n = new JFrame();
		n.setSize(800,600);
		PanAccedePlayList pan = new PanAccedePlayList(n);
		pan.getBtnQuitter().addActionListener(new EcouteurQuitter(n));
		n.setContentPane(pan);
		n.setVisible(true);
		
		File f = new File("_Data/_PlayList/");
		DefaultComboBoxModel b = new DefaultComboBoxModel();
		
		for(int i  = 0 ; i < f.list().length; i ++){
			String NomF = f.list()[i];
			b.addElement((String)NomF);
		}
		
		pan.getList().setModel(b);
	
		pan.getList().addMouseListener(new EcouteurAccPLList(pan));
		
		pan.getBtnValider().addActionListener(new EcouteurValiderRenomer(pan));
	}

	
}
