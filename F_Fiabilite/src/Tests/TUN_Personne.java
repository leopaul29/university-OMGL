package Tests;

import Modele.Personne;

public class TUN_Personne {

	public static void main(String[] args) {

		// Creer plusieurs personne
		//
		Personne p0 = new Personne("Leo", "Admin", "leoel", false);
		Personne p1 = new Personne("Loic", "AE", "loiciol", false);
		Personne p2 = new Personne("Corentin", "AS", "corentinit", false);
		Personne p3 = new Personne("Coraline", "CE", "coralineni", false);

		// Tests de l'US "F_Fiabilité"
		//
		Tests.Begin("F_Fiabilité", "1.0.0");

		// Tests de la class Personne
		//
		Tests.Design("Class Personne", 3); {

			// Vérifier le nom des personnes connectés
			//
			Tests.Case("Afficher les nom des personnes"); {

				Tests.Unit("Leo", p0.getNom());
				Tests.Unit("Loic", p1.getNom());
				Tests.Unit("Corentin", p2.getNom());
				Tests.Unit("Coraline", p3.getNom());
			}
			
			// Vérifier le mot de passe des personnes connectés
			//
			Tests.Case("Afficher le mot de passe des personnes"); {

				Tests.Unit("leoel", p0.getPassword());
				Tests.Unit("loiciol", p1.getPassword());
				Tests.Unit("corentinit", p2.getPassword());
				Tests.Unit("coralineni", p3.getPassword());
			}

			// Vérifier le role des personnes connectés
			//
			Tests.Case("Afficher le role des personnes"); {

				Tests.Unit("Admin", p0.getRole());
				Tests.Unit("AE", p1.getRole());
				Tests.Unit("AS", p2.getRole());
				Tests.Unit("CE", p3.getRole());
			}

			// Vérifier les identités des personnes connectés
			//
			Tests.Case("Afficher l'identité des personnes"); {

				Tests.Unit("Leo/leoel/Admin", p0.getIdentite());
				Tests.Unit("Loic/loiciol/AE", p1.getIdentite());
				Tests.Unit("Corentin/corentinit/AS", p2.getIdentite());
				Tests.Unit("Coraline/coralineni/CE", p3.getIdentite());
			}
			
			// Vérifier que l'on doit créer les identifiants des personnes
			//
			Tests.Case("Afficher si l'on doit créer les identifiant"); {

				Tests.Unit(false, p0.isExist());
				Tests.Unit(false, p1.isExist());
				Tests.Unit(false, p2.isExist());
				Tests.Unit(false, p3.isExist());
			}
			
			// Vérifier que les identifiants des personnes sont bien créer
			//
			Tests.Case("Afficher si les personne créées existe a present dans les identifiant"); {

				Tests.Unit(true, p0.identiteExist());
				Tests.Unit(true, p1.identiteExist());
				Tests.Unit(true, p2.identiteExist());
				Tests.Unit(true, p3.identiteExist());
			}
			
			// Vérifier que les personnes puissent se connecter
			//
			Tests.Case("Afficher si les personne peuvent se connecter avec leur identifiant"); {

				Tests.Unit(true, p0.isConnexion());
				Tests.Unit(true, p1.isConnexion());
				Tests.Unit(true, p2.isConnexion());
				Tests.Unit(true, p3.isConnexion());
			}
		}

		Tests.End();
	}
}
