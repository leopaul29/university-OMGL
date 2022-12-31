package Tests_F_Fiabilite;

import Modele.Action;
import Modele.Connexion;
import Modele.ConnexionSysteme;
import Modele.Personne;

public class TUN_Action {

	public static void main(String[] args) {

		// Personne a utiliser
		//
		Personne p1 = new Personne("Leo", "Admin", "leoel", true);
		Personne p2 = new Personne("Loic", "AE", "loiciol", true);
		Personne p3 = new Personne("Corentin", "AS", "corentinit", true);
		Personne p4 = new Personne("Coraline", "CE", "coralineni", true);

		// Connecter le system
		//
		ConnexionSysteme c0 = new ConnexionSysteme();

		// Connecter les personnes
		//
		Connexion c1 = new Connexion(p1, c0);
		Connexion c2 = new Connexion(p2, c0);
		Connexion c3 = new Connexion(p3, c0);
		Connexion c4 = new Connexion(p4, c0);

		// Créer action
		//
		Modele.Action a1 = new Modele.Action(c1, "déplacer un écran");
		Modele.Action a2 = new Modele.Action(c2, "Associe un renderer à un afficheur");
		Modele.Action a3 = new Modele.Action(c3, "effacer un site");
		Modele.Action a4 = new Modele.Action(c4, "creer un afficheur");

		// Tests de l'US "F_Fiabilité"
		//
		Tests.Begin("F_Fiabilité", "1.0.0");

		// Tests de la class Action
		//
		Tests.Design("Class Action", 3); {

			// Verifier les personne qui on effectué une action
			//
			Tests.Case("Afficher les personne ayant effectué une action"); {

				Tests.Unit("Admin Leo", a1.getPersonne().toString());
				Tests.Unit("AE Loic", a2.getPersonne().toString());
				Tests.Unit("AS Corentin", a3.getPersonne().toString());
				Tests.Unit("CE Coraline", a4.getPersonne().toString());
			}

			// Verifier les personne qui on effectué une action
			//
			Tests.Case("Afficher les action"); {

				Tests.Unit("déplacer un écran", a1.getAction());
				Tests.Unit("Associe un renderer à un afficheur", a2.getAction());
				Tests.Unit("effacer un site", a3.getAction());
				Tests.Unit("creer un afficheur", a4.getAction());
			}

			// Verifier les personne qui on effectué une action
			//
			Tests.Case("Afficher les action (complete)"); {

				System.out.println("\n\t" + a1.toString());
				System.out.println("\t" + a2.toString());
				System.out.println("\t" + a3.toString());
				System.out.println("\t" + a4.toString());
			}
		}

		Tests.Design("Test de la deconnection", 3); {

			// Deconnecter tout le monde
			//
			c1.seDeconnecter();
			c2.seDeconnecter();
			c3.seDeconnecter();
			c4.seDeconnecter();

			// Verifier si les personne peuvent se connecter
			//
			Tests.Case("Afficher si les personnes sont connecté"); {

				Tests.Unit(false, c1.isConnexion());
				Tests.Unit(false, c2.isConnexion());
				Tests.Unit(false, c3.isConnexion());
				Tests.Unit(false, c4.isConnexion());
			}
			
			// Executer une action
			//
			Action a5 = new Action(c1, "visualiser l'état des écran");
			
			Tests.Case("Afficher si les personnes peuvent effectuer des actions"); {
				
				Tests.Unit(false, c1.isConnexion());
				Tests.Unit(false, a5.isActionPossible());
			}
		}

		// Deconnecter le system
		//
		c0.deconnexionSyst();

		Tests.End();
	}
}
