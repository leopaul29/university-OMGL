package Tests;

import Modele.Ecran;
import Modele.Gestionnaire;

public class TUN_Gestionnaire {


	public static void main(String[] args) {

		// Cr�ation d'une liste d'�crans pour le test
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

				// Afficher la liste des �crans
				//
				Tests.Unit("[Ecran n:0 - en marche - erreurs lev�es : [] - eteint : false - eteint par : ,"
						+ " Ecran n:1 - en marche - erreurs lev�es : [] - eteint : false - eteint par : ,"
						+ " Ecran n:2 - en marche - erreurs lev�es : [] - eteint : false - eteint par : ,"
						+ " Ecran n:3 - en marche - erreurs lev�es : [] - eteint : false - eteint par : ,"
						+ " Ecran n:4 - en marche - erreurs lev�es : [] - eteint : false - eteint par : ]",
						g.getListe_ecrans().toString());

				// Afficher l'�cran num�ro 2
				//
				Tests.Unit("Ecran n:2 - en marche - erreurs lev�es : [] - eteint : false - eteint par : ",
						g.getEcran(2).toString());

				// Afficher la liste des �crans eteint
				//
				Tests.Unit("[]", g.getliste_EcranEteint().toString());

				// Afficher les erreurs lev�es de chaque �cran
				//
				Tests.Unit("[]", g.getliste_EcranErreur().toString());
			}

			Tests.Case("Visualiser l'�tat des �crans"); {

				// Afficher l'�tat de chaque �cran
				//
				Tests.Unit("[Ecran n:0 - en marche, Ecran n:1 - en marche, Ecran n:2 - en marche,"
						+ " Ecran n:3 - en marche, Ecran n:4 - en marche]", g.getListe_EcranEtats().toString());
			}
		}

		Tests.Design("Controle M�thode Gestionnaire", 3); {

			// J'eteint l'�cran numero 2
			//
			g.eteindreEcran(2, "Alice");
			g.eteindreEcran(4, "Marc");

			Tests.Case("Stopper un �cran"); {
				
				// Savoir si les �crans sont bien eteint
				//
				Tests.Unit(false, g.getEcran(1).isEteint());
				Tests.Unit(true, g.getEcran(2).isEteint());
				Tests.Unit(true, g.getEcran(4).isEteint());
				
				// Afficher l'�tat des �crans que j'ai eteint
				//
				Tests.Unit("en marche", g.getEcran(1).getEtat());
				Tests.Unit("eteint", g.getEcran(2).getEtat());
				Tests.Unit("eteint", g.getEcran(4).getEtat());

				// Afficher la liste des �crans eteint
				//
				Tests.Unit("[Ecran n:2 - Alice, Ecran n:4 - Marc]",
						g.getliste_EcranEteint().toString());
			}

			Tests.Case("Savoir qui a arreter un �cran"); {

				// Afficher le nom des personnes qui ont eteint les �crans
				//
				Tests.Unit("", g.eteintParQui(1));
				Tests.Unit("Alice", g.eteintParQui(2));
				Tests.Unit("Marc", g.eteintParQui(4));
			}

			Tests.Case("consulter les erreurs lev�es d'un �cran"); {
				
				// Afficher les erreurs lev�es d'un �cran
				//
				e3.getErreur().addErreur("�cran bleu");
				e4.getErreur().addErreur("�cran cass�");
				
				Tests.Unit("[�cran bleu]", e3.getList_Erreur().toString());
				Tests.Unit("[Ecran n:2 - [�cran bleu], Ecran n:3 - [�cran cass�]]",
						g.getliste_EcranErreur().toString());
			}
		}

		Tests.End();
	}
}
