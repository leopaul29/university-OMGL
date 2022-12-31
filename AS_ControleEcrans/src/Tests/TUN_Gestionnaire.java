package Tests;

import Modele.Ecran;
import Modele.Gestionnaire;

public class TUN_Gestionnaire {


	public static void main(String[] args) {

		// Création d'une liste d'écrans pour le test
		//
		Ecran e1 = new Ecran();
		Ecran e2 = new Ecran(1);
		Ecran e3 = new Ecran(2);
		Ecran e4 = new Ecran(3);
		Ecran e5 = new Ecran(4);

		Gestionnaire g = new Gestionnaire();

		g.getListe_ecrans().add(e1);
		g.getListe_ecrans().add(e2);
		g.getListe_ecrans().add(e3);
		g.getListe_ecrans().add(e4);
		g.getListe_ecrans().add(e5);

		Tests.Begin("AS_ControleEcran", "1.0.0");

		Tests.Design("Controle Accesseur Gestionnaire", 3); {

			Tests.Case("Accesseur de consultation du gestionnaire"); {

				// Afficher la liste des écrans
				//
				Tests.Unit("[Ecran n:0 - en marche - erreurs levées : [] - eteint : false - eteint par : ,"
						+ " Ecran n:1 - en marche - erreurs levées : [] - eteint : false - eteint par : ,"
						+ " Ecran n:2 - en marche - erreurs levées : [] - eteint : false - eteint par : ,"
						+ " Ecran n:3 - en marche - erreurs levées : [] - eteint : false - eteint par : ,"
						+ " Ecran n:4 - en marche - erreurs levées : [] - eteint : false - eteint par : ]",
						g.getListe_ecrans().toString());

				// Afficher l'écran numéro 2
				//
				Tests.Unit("Ecran n:2 - en marche - erreurs levées : [] - eteint : false - eteint par : ",
						g.getEcran(2).toString());

				// Afficher la liste des écrans eteint
				//
				Tests.Unit("[]", g.getliste_EcranEteint().toString());

				// Afficher les erreurs levées de chaque écran
				//
				Tests.Unit("[]", g.getliste_EcranErreur().toString());
			}

			Tests.Case("Visualiser l'état des écrans"); {

				// Afficher l'état de chaque écran
				//
				Tests.Unit("[Ecran n:0 - en marche, Ecran n:1 - en marche, Ecran n:2 - en marche,"
						+ " Ecran n:3 - en marche, Ecran n:4 - en marche]", g.getListe_EcranEtats().toString());
			}
		}

		Tests.Design("Controle Méthode Gestionnaire", 3); {

			// J'eteint l'écran numero 2
			//
			g.eteindreEcran(2, "Alice");
			g.eteindreEcran(4, "Marc");

			Tests.Case("Stopper un écran"); {
				
				// Savoir si les écrans sont bien eteint
				//
				Tests.Unit(false, g.getEcran(1).isEteint());
				Tests.Unit(true, g.getEcran(2).isEteint());
				Tests.Unit(true, g.getEcran(4).isEteint());
				
				// Afficher l'état des écrans que j'ai eteint
				//
				Tests.Unit("en marche", g.getEcran(1).getEtat());
				Tests.Unit("eteint", g.getEcran(2).getEtat());
				Tests.Unit("eteint", g.getEcran(4).getEtat());

				// Afficher la liste des écrans eteint
				//
				Tests.Unit("[Ecran n:2 - Alice, Ecran n:4 - Marc]",
						g.getliste_EcranEteint().toString());
			}

			Tests.Case("Savoir qui a arreter un écran"); {

				// Afficher le nom des personnes qui ont eteint les écrans
				//
				Tests.Unit("", g.eteintParQui(1));
				Tests.Unit("Alice", g.eteintParQui(2));
				Tests.Unit("Marc", g.eteintParQui(4));
			}

			Tests.Case("consulter les erreurs levées d'un écran"); {
				
				// Afficher les erreurs levées d'un écran
				//
				e3.getErreur().addErreur("écran bleu");
				e4.getErreur().addErreur("écran cassé");
				
				Tests.Unit("[écran bleu]", e3.getList_Erreur().toString());
				Tests.Unit("[Ecran n:2 - [écran bleu], Ecran n:3 - [écran cassé]]",
						g.getliste_EcranErreur().toString());
			}
		}

		Tests.End();
	}
}
