package Intervenant;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Connexion.PanneauConnexion;

public class PanneauMenu extends JFrame{

	public PanneauMenu()
	{
		//Propri�t� fenetre
		setSize(280,200);
		setTitle("Menu Intervenant");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setLayout(new GridLayout(3, 1));
		
		// --- Button EmDemande
		JButton EmDemande = new JButton("�mettre une demande");
		//ajout ecouteur
		EmDemande.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("EmDemande clik");
				dispose();
				new EmettreDemande();
			}
		});
		//ajout Button au panneau
		getContentPane().add(EmDemande);
		
		// --- Button RepDemande
		JButton RepDemande = new JButton("R�pondre � une demande");
		//ajout ecouteur
		RepDemande.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("RepDemande clik");
				dispose();
				new RepondreDemande();
			}
		});
		//ajout Button au panneau
		getContentPane().add(RepDemande);
		
		
		// --- Button Deconnexion
		JButton Deconnexion = new JButton("Deconnexion");
		//ajout ecouteur
		Deconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Deconnexion clik");
				dispose();
				new PanneauConnexion();
			}
		});
		//ajout Button au panneau
		getContentPane().add(Deconnexion);

		setVisible(true);
	}

	public static void main(String[]args)
	{
		new PanneauMenu();
	}
}

