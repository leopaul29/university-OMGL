package Tests_F_Fiabilite;

import Modele.Connexion;
import Modele.ConnexionSysteme;
import Modele.Log;
import Modele.Personne;

public class TUN_Connexion {

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

		// Tests de l'US "F_Fiabilité"
		//
		Tests.Begin("F_Fiabilité", "1.0.0");

		// Tests de la class Connexion
		//
		Tests.Design("Class Connexion", 3); {

			// Verifier les personne connecté
			//
			Tests.Case("Afficher les personnes connecté"); {

				Tests.Unit("Admin Leo", c1.getPersonne().toString());
				Tests.Unit("AE Loic", c2.getPersonne().toString());
				Tests.Unit("AS Corentin", c3.getPersonne().toString());
				Tests.Unit("CE Coraline", c4.getPersonne().toString());
			}

			// Verifier si les personne peuvent se connecter
			//
			Tests.Case("Afficher si les personnes peuvent se connecter"); {

				Tests.Unit(true, c1.isConnexion());
				Tests.Unit(true, c2.isConnexion());
				Tests.Unit(true, c3.isConnexion());
				Tests.Unit(true, c4.isConnexion());
			}

			// Verifier connexion
			//
			Tests.Case("Afficher les connexions"); {

				System.out.println("\n\t" + c1.toString_connection());
				System.out.println("\t" + c2.toString_connection());
				System.out.println("\t" + c3.toString_connection());
				System.out.println("\t" + c4.toString_connection());
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
			Tests.Case("Afficher si les personnes peuvent se connecter"); {

				Tests.Unit(false, c1.isConnexion());
				Tests.Unit(false, c2.isConnexion());
				Tests.Unit(false, c3.isConnexion());
				Tests.Unit(false, c4.isConnexion());
			}
		}

		// Deconnecter le systeme
		//
		c0.deconnexionSyst();

		Tests.End();
	}
}
