package Admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Connexion.*;

public class PanneauMenu extends JFrame{

	public PanneauMenu()
	{
		//Propriété fenetre
		setSize(280,200);
		setTitle("Menu Administrateur");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setLayout(new GridLayout(6, 1));
		
		// --- Button SaisirQR
		JButton SaisirQR = new JButton("Saisir une question relative");
		//ajout ecouteur
		SaisirQR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("SaisirQR clik");
				dispose();
				new SaisirQR();
			}
		});
		//ajout Button au panneau
		getContentPane().add(SaisirQR);
		
		// --- Button ChoisirInfo
		JButton ChoisirInfo = new JButton("Choisir les informations");
		//ajout ecouteur
		ChoisirInfo.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ChoisirInfo clik");
			}
		});
		//ajout Button au panneau
		getContentPane().add(ChoisirInfo);
	
		// --- Button ModifDroit	
		JButton ModifDroit = new JButton("Modifier les Droits");
		//ajout ecouteur
		ModifDroit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("ModifDroit clik");
			}
		});
		//ajout Button au panneau
		getContentPane().add(ModifDroit);
		
		// --- Button EmDemande
		JButton EmDemande = new JButton("Émettre une demande");
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
		JButton RepDemande = new JButton("Répondre à une demande");
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
