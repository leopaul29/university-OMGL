package Tests_AS_ControleEcrans;

import Modele.Connexion;
import Modele.ConnexionSysteme;
import Modele.Dimension;
import Modele.Ecran;
import Modele.Gestionnaire;
import Modele.Personne;
import Modele.Site;
import Modele.StockAfficheur;


public class TUN_AS_ControleEcrans {

	public static void main(String[] args) {

		// Creer un Stock d'afficheur de départ
		//
		StockAfficheur stock_afficheur = new StockAfficheur();

		// Créer gestionnaire
		//
		Gestionnaire g = new Gestionnaire(stock_afficheur);

		// Déclarer des sites par leur nom, leur localisation
		//
		Site s1 = new Site("Fabron", "route Napoleon");
		Site s2 = new Site("Sophia", "quelquepart");

		// Creer plusieurs dimensions d'écran dédié au afficheur
		//
		Dimension dim_ecran1 = new Dimension(800, 800);
		Dimension dim_ecran2 = new Dimension(600, 600);

		// Créer plusieurs écrans
		//
		Ecran e1 = new Ecran(s1, "hall d'entrée", "e1", dim_ecran1, g);
		Ecran e2 = new Ecran(s1, "premier etage","e2", dim_ecran2, g);
		Ecran e3 = new Ecran(s1, "Entrée batiment B", "e3", dim_ecran1, g);
		Ecran e4 = new Ecran(s2, "Entrée batiment A", "e4", dim_ecran2, g);

		// Ajouter les sites au gestionnaire
		//
		g.ajouterSite(s1);
		g.ajouterSite(s2);

		// Creer un AS
		//
		Personne p = new Personne("Marie", "AS", "mamamama", false);

		// Connecter le system
		//
		ConnexionSysteme c0 = new ConnexionSysteme();

		// Connecter la personnes
		//
		Connexion c = new Connexion(p, c0);

		/* Tests d'integration des US :
		 * 
		 * AS_ControleEcrans
		 * AS_ConOrganiseEcrans
		 */
		Tests.Begin("Intégration AS_ControleEcrans & AS_ConOrganiseEcrans"
				, "1.0.0");

		Tests.Design("AS_ControleEcrans - Accesseur", 3); {

			Tests.Case("Accesseur de consultation d'un écran", 3); {

				// Afficher l'état de l'écran "e1"
				//
				Tests.Unit("en marche", e1.getEtat());

				// Afficher si l'écran "e3" a des erreurs levées
				//
				Tests.Unit(false, e3.isErreur());

				// Afficher les erreurs de l'écran "e2"
				//
				Tests.Unit("[]", e2.consulterErreur(c));

				// Afficher si l'écran "e3" est éteint
				//
				Tests.Unit(false, e3.isEteint());

				// Afficher par qui l'écran "e4" a était éteint
				//
				Tests.Unit("Personne", e1.getEteintPar(c));
			}
		}

		Tests.Design("AS_ControleEcrans - Visualiser l'état des écrans", 3); {

			Tests.Case("Visualiser l'état des écran un par un", 3); {

				// Verifier l'état des écran
				//
				Tests.Unit("en marche", e1.getEtat());
				Tests.Unit("en marche", e2.getEtat());
				Tests.Unit("en marche", e3.getEtat());
				Tests.Unit("en marche", e4.getEtat());

				// Afficher la visualisation de l'état des écrans
				//
				Tests.Unit("[ e1 - en marche ]", e1.visualiserEtat(c));
				Tests.Unit("[ e2 - en marche ]", e2.visualiserEtat(c));
				Tests.Unit("[ e3 - en marche ]", e3.visualiserEtat(c));
				Tests.Unit("[ e4 - en marche ]", e4.visualiserEtat(c));
			}

			Tests.Case("Visualiser l'état des écran par site", 3); {

				// Afficher le statut complet du site "s1"
				//
				String test_s1_toString = "[ nom = Fabron, localisation = route Napoleon, écrans = [[ nom = e1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = e2, site = Fabron, position = premier etage, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ], [ nom = e3, site = Fabron, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]] ]";
				Tests.Unit(test_s1_toString, s1.toString());

				// Afficher la visualisation de l'état des écrans du site "s1"
				//
				String test_visualiserS1 = "[ e1 - en marche ][ e2 - en marche ][ e3 - en marche ]";
				Tests.Unit(test_visualiserS1, s1.visualiserEtat(c));

				// Afficher le statut complet du site "s2"
				//
				String test_s2_toString = "[ nom = Sophia, localisation = quelquepart, écrans = [[ nom = e4, site = Sophia, position = Entrée batiment A, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]";
				Tests.Unit(test_s2_toString, s2.toString());

				// Afficher la visualisation de l'état des écrans du site "s2"
				//
				String test_visualiserS2 = "[ e4 - en marche ]";
				Tests.Unit(test_visualiserS2, s2.visualiserEtat(c));
			}

			Tests.Case("Visualiser l'état des écran du gestionnaire", 3); {

				// Afficher le statut complet du gestionnaire de site "g"
				//
				String test_g_toString = "Gestionnaire [ Site = [[[ nom = Fabron, localisation = route Napoleon, écrans = [[ nom = e1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = e2, site = Fabron, position = premier etage, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ], [ nom = e3, site = Fabron, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]] ], [ nom = Sophia, localisation = quelquepart, écrans = [[ nom = e4, site = Sophia, position = Entrée batiment A, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]]] ]";
				Tests.Unit(test_g_toString, g.toString());

				// Afficher la visualisation de l'état des écrans du site "s2"
				//
				String test_visualiserG = "[ e1 - en marche ][ e2 - en marche ][ e3 - en marche ][ e4 - en marche ]";
				Tests.Unit(test_visualiserG, g.visualiserEtat(c));
			}
		}

		Tests.Design("AS_ControleEcrans - Stopper un écran", 3); {

			Tests.Case("Avant d'éteindre les écrans 'e1', 'e3' et 'e4'", 3); {

				// Verfifier que les écrans "e1", "e3" et "e4" sont en marche
				//
				Tests.Unit("en marche", e1.getEtat());
				Tests.Unit("en marche", e2.getEtat());
				Tests.Unit("en marche", e3.getEtat());
				Tests.Unit("en marche", e4.getEtat());

				// Verifier qu'ils ne sont pas eteint
				//
				Tests.Unit(false, e1.isEteint());
				Tests.Unit(false, e2.isEteint());
				Tests.Unit(false, e3.isEteint());
				Tests.Unit(false, e4.isEteint());
			}

			Tests.Case("Eteindre les écrans 'e1', 'e3' et 'e4'", 3); {

				// Eteindre les écrans "e1" et "e4"
				//
				Tests.Unit(true, e1.eteindreEcran(c));
				Tests.Unit(true, e3.eteindreEcran(c));
				Tests.Unit(true, e4.eteindreEcran(c));

				// Eteindre une seconde fois l'écrans "e1"
				//
				Tests.Unit(false, e1.eteindreEcran(c));
			}

			Tests.Case("Après avoir éteint les écrans 'e1', 'e3' et 'e4'", 3); {

				// Verfifier que les écrans "e1" et "e4" sont en marche
				//
				Tests.Unit("eteint", e1.getEtat());
				Tests.Unit("en marche", e2.getEtat());
				Tests.Unit("eteint", e3.getEtat());
				Tests.Unit("eteint", e4.getEtat());

				// Verifier qu'ils ne sont pas eteint
				//
				Tests.Unit(true, e1.isEteint());
				Tests.Unit(false, e2.isEteint());
				Tests.Unit(true, e3.isEteint());
				Tests.Unit(true, e4.isEteint());
			}

		}

		Tests.Design("AS_ControleEcrans - Savoir qui a arrêté un écran", 3); {

			Tests.Case("Savoir qui a arrêté un écran une première fois", 3); {

				// Afficher par qui les écrans "e1", "e3" et "e4" sont en marche
				//
				Tests.Unit("Jule", e1.getEteintPar(c));
				Tests.Unit("Personne", e2.getEteintPar(c));
				Tests.Unit("Joe", e3.getEteintPar(c));
				Tests.Unit("Jule", e4.getEteintPar(c));
			}

			Tests.Case("Savoir qui a arrêté un écran une deuxieme fois", 3); {

				// Allumer l'écran "e4"
				//
				e4.setEteint(false);

				// Vérifier l'état de l'écran "e4"
				//
				Tests.Unit("en marche", e4.getEtat());

				// Vérifier que l'écran "e4" ne soit pas eteint
				//
				Tests.Unit(false, e4.isEteint());

				// Eteindre l'écran "e4" par une autre personne
				//
				e4.eteindreEcran(c);

				// Vérifier que la dernière personne qui a éteint l'écran "e4" est "Alice"
				//
				Tests.Unit("Alice", e4.getEteintPar(c));
			}

		}

		Tests.Design("AS_ControleEcrans - Consulter les erreurs levées par un écran", 3); {

			Tests.Case("Consulter les erreurs de l'écran 'e2' et 'e4'", 3); {

				// Consulter les erreurs de l'écran "e2" et "e4"
				//
				Tests.Unit("[]", e2.consulterErreur(c));
				Tests.Unit("[]", e4.consulterErreur(c));

				// Vérifier que les écrans ne possède aucune erreurs levées
				//
				Tests.Unit(false, e1.isErreur());
				Tests.Unit(false, e2.isErreur());
				Tests.Unit(false, e3.isErreur());
				Tests.Unit(false, e4.isErreur());
			}

			// J'ajoute 2 erreurs a l'écran "e2"
			//
			e2.getMockErreur().addErreur("écran cassé");
			e2.getMockErreur().addErreur("souris disparu");

			Tests.Case("Consulter les erreurs de l'écran 'e2'"); {

				// Vérification de la liste d'erreurs levées
				//
				Tests.Unit("[écran cassé, souris disparu]", e2.consulterErreur(c));

				// Vérifier que l'écran "e2" possède des erreurs
				//
				Tests.Unit(true, e2.getMockErreur().hasErreur());
				Tests.Unit(true, e2.isErreur());
				Tests.Unit("erreurs levées", e2.getEtat());

				// Vérifier que l'écran "e2" possède 2 erreurs
				//
				Tests.Unit(2, e2.nombreErreur());
			}

			// J'enlève une erreur à l'écran
			//
			e2.getMockErreur().removeErreur(1);

			Tests.Case("Consulter les erreurs de l'écran 'e2'"); {

				// Vérification de la liste d'erreurs levées
				//
				Tests.Unit("[écran cassé]", e2.consulterErreur(c));

				// Vérifier que l'écran "e2" possède des erreurs
				//
				Tests.Unit(true, e2.getMockErreur().hasErreur());
				Tests.Unit(true, e2.isErreur());
				Tests.Unit("erreurs levées", e2.getEtat());

				// Vérifier que l'écran "e2" possède plus qu'une erreur
				//
				Tests.Unit(1, e2.nombreErreur());
			}

			// J'enlève toutes les erreurs à l'écran
			//
			e2.getMockErreur().removeAll();

			Tests.Case("Consulter les erreurs de l'écran 'e2'"); {

				// Vérification de la liste d'erreurs levées
				//
				Tests.Unit("[]", e2.consulterErreur(c));

				// Vérifier que l'écran "e2" possède des erreurs
				//
				Tests.Unit(false, e2.getMockErreur().hasErreur());
				Tests.Unit(false, e2.isErreur());
				Tests.Unit("en marche", e2.getEtat());
			}
		}

		// se deconnecter
		//
		c.seDeconnecter();
		
		// Arreter le systeme
		//
		c0.deconnexionSyst();
		
		Tests.End();
	}
}