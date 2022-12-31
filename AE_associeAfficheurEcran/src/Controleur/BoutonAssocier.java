package Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BoutonAssocier implements ActionListener{

	
	public BoutonAssocier(){
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame f = new JFrame();
		f.setSize(600, 600);
		f.setVisible(true);
	}

}
