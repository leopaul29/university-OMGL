package Tests;

import Modele.Ecran;

public class TUN_Ecran {

	public static void main(String[] args) {

		// Création de 3 écrans pour le test
		//
		Ecran e1 = new Ecran();
		Ecran e2 = new Ecran(1);
		Ecran e3 = new Ecran(2);

		Tests.Begin("AS_ControleEcrans", "1.0.0");

		Tests.Design("Controle Accesseurs Ecran", 3); {

			Tests.Case("Accesseur de consultation d'un écran", 3); {

				Tests.Unit("en marche", e1.getEtat());
				Tests.Unit("[]", e1.toStringErreur());
				Tests.Unit(false, e1.isEteint());
				Tests.Unit("", e1.getEteintPar());
			}

			Tests.Case("Accesseur de modification d'un écran", 3); {

				// Changer l'état de l'écran
				//
				e1.setEtat("en panne");
				Tests.Unit("en panne", e1.getEtat());

				// Changer la valeur de éteint de l'écran
				//
				e1.setEteint(true);
				e1.setEteintPar("toto");

				Tests.Unit("eteint", e1.getEtat());
				Tests.Unit(true, e1.isEteint());
				Tests.Unit("toto", e1.getEteintPar());
			}
		}

		Tests.Design("Controle Méthode Ecran", 3); {

			Tests.Case("Test de la méthode 'afficherEtat'", 3); {

				Tests.Unit("Ecran n:1 - en marche", e2.afficherEtat());
			}

			Tests.Case("Test de la méthode 'toString'", 3); {

				Tests.Unit("Ecran n:1 - en marche "
						+ "- erreurs levées : []"
						+ " - eteint : false - eteint par "
						+ ": ", e2.toString());
			}

			Tests.Case("Test de la méthode 'eteindreEcran'", 3); {

				// Eteindre l'écran 2 par Jule
				//
				e2.eteindreEcran("Jule");

				Tests.Unit("eteint", e2.getEtat());
				Tests.Unit(true, e2.isEteint());
				Tests.Unit("Jule", e2.getEteintPar());
			}
			
			Tests.Case("Test de la méthode 'getList_Erreur'"); {
				
				// J'ajoute 2 erreurs a l'écran
				//
				e3.getErreur().addErreur("écran cassé");
				e3.getErreur().addErreur("souris disparu");
				
				// Vérification de la liste d'erreur
				//
				Tests.Unit("[écran cassé, souris disparu]", e3.toStringErreur());
				Tests.Unit(true, e3.getErreur().hasErreur());
				Tests.Unit("erreurs levées", e3.getEtat());
				
				// J'enlève une erreur à l'écran
				//
				e3.getErreur().removeErreur(1);
				
				// Vérification de la liste d'erreur
				//
				Tests.Unit("[écran cassé]", e3.toStringErreur());
				Tests.Unit(true, e3.getErreur().hasErreur());
				Tests.Unit("erreurs levées", e3.getEtat());
				
				// J'enlève toutes les erreurs à l'écran
				//
				e3.getErreur().removeAll();
				
				// Vérification de la liste d'erreur
				//
				Tests.Unit("[]", e3.toStringErreur());
				Tests.Unit(false, e3.getErreur().hasErreur());
				Tests.Unit("en marche", e3.getEtat());
			}
		}

		Tests.End();
	}
}