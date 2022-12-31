package Connexion;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Intervenant.PanneauMenu;


public class PanneauConnexion extends JFrame{
private TextField idText;
private TextField mdpText;

public String getidText(){return idText.getText();}
public String getmdpText(){return mdpText.getText();}

	public PanneauConnexion()
	{
		//Propriété fenetre
		setSize(280,150);
		setTitle("Connexion");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		//Divise la fenetre en 3
		getContentPane().setLayout(new GridLayout(3, 1));
		
		//Panneau ID
		JPanel id = new JPanel();
		id.setLayout(new GridLayout(1, 2));
		JLabel idLab = new JLabel("Login : ");
		idText = new TextField();
		getContentPane().add(id);
		id.add(idLab);
		id.add(idText);
		
		//Panneau mdp
		JPanel mdp = new JPanel();
		id.setLayout(new GridLayout(1, 2));
		JLabel mdpLab = new JLabel("Mot de passe : ");
		mdpText = new TextField(20);
		getContentPane().add(mdp);
		mdp.add(mdpLab);
		mdp.add(mdpText);
		
		//Bouton connexion
		JPanel co = new JPanel();
		getContentPane().add(co);
		
		JButton ConnexionAdmin = new JButton("ConnexionAdmin");
		co.add(ConnexionAdmin);
		
		//Ajout ecouteurButton
		ConnexionAdmin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(idText.getText() == "toto" || mdpText.getText() == "toto")
					System.out.println("cool");
				else
					System.out.println("pas cool");
				dispose();
				new Admin.PanneauMenu();
			}
		});
		
		
		
		//Bouton connexion
		JButton ConnexionIntervenant = new JButton("ConnexionInter");
		co.add(ConnexionIntervenant);
		
		//Ajout ecouteurButton
		ConnexionIntervenant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
				new PanneauMenu();
			}
		});
		
		
		setVisible(true);
	}
	
	public static void main(String[]args)
	{
		new PanneauConnexion();
	}
}
