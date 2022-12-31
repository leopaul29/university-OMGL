package Admin;

import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EmettreDemande extends JFrame{

	public EmettreDemande()
	{
		//Propriété fenetre
		setSize(500,300);
		setTitle("Administrateur - Émettre une demande");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setLayout(new GridLayout(2, 1));
		
		//Zone de text
		TextArea SaisirQR = new TextArea();
		getContentPane().add(SaisirQR);
		
		
		//Panneau Button
		JPanel PanButton = new JPanel();
		getContentPane().add(PanButton);
		
		//Button Valider Annuler
		JButton Valider = new JButton("Valider");
		Valider.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Valider > panneauMenu");
				dispose();
				new PanneauMenu();
			}
		});
		PanButton.add(Valider);
		
		//Button Annuler
		JButton Annuler = new JButton("Annuler");
		Annuler.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Annuler > panneauMenu");
				dispose();
				new PanneauMenu();
			}
		});
		PanButton.add(Annuler);
		
		setVisible(true);
	}
	
	public static void main(String[]args)
	{
		new EmettreDemande();
	}

}
