package Tests;

import Modele.Ecran;

public class TUN_Ecran {

	public static void main(String[] args) {

		// Cr�ation de 3 �crans pour le test
		//
		Ecran e1 = new Ecran();
		Ecran e2 = new Ecran(1);
		Ecran e3 = new Ecran(2);

		Tests.Begin("AS_ControleEcrans", "1.0.0");

		Tests.Design("Controle Accesseurs Ecran", 3); {

			Tests.Case("Accesseur de consultation d'un �cran", 3); {

				Tests.Unit("en marche", e1.getEtat());
				Tests.Unit("[]", e1.toStringErreur());
				Tests.Unit(false, e1.isEteint());
				Tests.Unit("", e1.getEteintPar());
			}

			Tests.Case("Accesseur de modification d'un �cran", 3); {

				// Changer l'�tat de l'�cran
				//
				e1.setEtat("en panne");
				Tests.Unit("en panne", e1.getEtat());

				// Changer la valeur de �teint de l'�cran
				//
				e1.setEteint(true);
				e1.setEteintPar("toto");

				Tests.Unit("eteint", e1.getEtat());
				Tests.Unit(true, e1.isEteint());
				Tests.Unit("toto", e1.getEteintPar());
			}
		}

		Tests.Design("Controle M�thode Ecran", 3); {

			Tests.Case("Test de la m�thode 'afficherEtat'", 3); {

				Tests.Unit("Ecran n:1 - en marche", e2.afficherEtat());
			}

			Tests.Case("Test de la m�thode 'toString'", 3); {

				Tests.Unit("Ecran n:1 - en marche "
						+ "- erreurs lev�es : []"
						+ " - eteint : false - eteint par "
						+ ": ", e2.toString());
			}

			Tests.Case("Test de la m�thode 'eteindreEcran'", 3); {

				// Eteindre l'�cran 2 par Jule
				//
				e2.eteindreEcran("Jule");

				Tests.Unit("eteint", e2.getEtat());
				Tests.Unit(true, e2.isEteint());
				Tests.Unit("Jule", e2.getEteintPar());
			}
			
			Tests.Case("Test de la m�thode 'getList_Erreur'"); {
				
				// J'ajoute 2 erreurs a l'�cran
				//
				e3.getErreur().addErreur("�cran cass�");
				e3.getErreur().addErreur("souris disparu");
				
				// V�rification de la liste d'erreur
				//
				Tests.Unit("[�cran cass�, souris disparu]", e3.toStringErreur());
				Tests.Unit(true, e3.getErreur().hasErreur());
				Tests.Unit("erreurs lev�es", e3.getEtat());
				
				// J'enl�ve une erreur � l'�cran
				//
				e3.getErreur().removeErreur(1);
				
				// V�rification de la liste d'erreur
				//
				Tests.Unit("[�cran cass�]", e3.toStringErreur());
				Tests.Unit(true, e3.getErreur().hasErreur());
				Tests.Unit("erreurs lev�es", e3.getEtat());
				
				// J'enl�ve toutes les erreurs � l'�cran
				//
				e3.getErreur().removeAll();
				
				// V�rification de la liste d'erreur
				//
				Tests.Unit("[]", e3.toStringErreur());
				Tests.Unit(false, e3.getErreur().hasErreur());
				Tests.Unit("en marche", e3.getEtat());
			}
		}

		Tests.End();
	}
}