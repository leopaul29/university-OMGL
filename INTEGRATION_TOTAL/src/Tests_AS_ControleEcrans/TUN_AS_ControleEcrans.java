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

		// Creer un Stock d'afficheur de d�part
		//
		StockAfficheur stock_afficheur = new StockAfficheur();

		// Cr�er gestionnaire
		//
		Gestionnaire g = new Gestionnaire(stock_afficheur);

		// D�clarer des sites par leur nom, leur localisation
		//
		Site s1 = new Site("Fabron", "route Napoleon");
		Site s2 = new Site("Sophia", "quelquepart");

		// Creer plusieurs dimensions d'�cran d�di� au afficheur
		//
		Dimension dim_ecran1 = new Dimension(800, 800);
		Dimension dim_ecran2 = new Dimension(600, 600);

		// Cr�er plusieurs �crans
		//
		Ecran e1 = new Ecran(s1, "hall d'entr�e", "e1", dim_ecran1, g);
		Ecran e2 = new Ecran(s1, "premier etage","e2", dim_ecran2, g);
		Ecran e3 = new Ecran(s1, "Entr�e batiment B", "e3", dim_ecran1, g);
		Ecran e4 = new Ecran(s2, "Entr�e batiment A", "e4", dim_ecran2, g);

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
		Tests.Begin("Int�gration AS_ControleEcrans & AS_ConOrganiseEcrans"
				, "1.0.0");

		Tests.Design("AS_ControleEcrans - Accesseur", 3); {

			Tests.Case("Accesseur de consultation d'un �cran", 3); {

				// Afficher l'�tat de l'�cran "e1"
				//
				Tests.Unit("en marche", e1.getEtat());

				// Afficher si l'�cran "e3" a des erreurs lev�es
				//
				Tests.Unit(false, e3.isErreur());

				// Afficher les erreurs de l'�cran "e2"
				//
				Tests.Unit("[]", e2.consulterErreur(c));

				// Afficher si l'�cran "e3" est �teint
				//
				Tests.Unit(false, e3.isEteint());

				// Afficher par qui l'�cran "e4" a �tait �teint
				//
				Tests.Unit("Personne", e1.getEteintPar(c));
			}
		}

		Tests.Design("AS_ControleEcrans - Visualiser l'�tat des �crans", 3); {

			Tests.Case("Visualiser l'�tat des �cran un par un", 3); {

				// Verifier l'�tat des �cran
				//
				Tests.Unit("en marche", e1.getEtat());
				Tests.Unit("en marche", e2.getEtat());
				Tests.Unit("en marche", e3.getEtat());
				Tests.Unit("en marche", e4.getEtat());

				// Afficher la visualisation de l'�tat des �crans
				//
				Tests.Unit("[ e1 - en marche ]", e1.visualiserEtat(c));
				Tests.Unit("[ e2 - en marche ]", e2.visualiserEtat(c));
				Tests.Unit("[ e3 - en marche ]", e3.visualiserEtat(c));
				Tests.Unit("[ e4 - en marche ]", e4.visualiserEtat(c));
			}

			Tests.Case("Visualiser l'�tat des �cran par site", 3); {

				// Afficher le statut complet du site "s1"
				//
				String test_s1_toString = "[ nom = Fabron, localisation = route Napoleon, �crans = [[ nom = e1, site = Fabron, position = hall d'entr�e, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = e2, site = Fabron, position = premier etage, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ], [ nom = e3, site = Fabron, position = Entr�e batiment B, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]] ]";
				Tests.Unit(test_s1_toString, s1.toString());

				// Afficher la visualisation de l'�tat des �crans du site "s1"
				//
				String test_visualiserS1 = "[ e1 - en marche ][ e2 - en marche ][ e3 - en marche ]";
				Tests.Unit(test_visualiserS1, s1.visualiserEtat(c));

				// Afficher le statut complet du site "s2"
				//
				String test_s2_toString = "[ nom = Sophia, localisation = quelquepart, �crans = [[ nom = e4, site = Sophia, position = Entr�e batiment A, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]";
				Tests.Unit(test_s2_toString, s2.toString());

				// Afficher la visualisation de l'�tat des �crans du site "s2"
				//
				String test_visualiserS2 = "[ e4 - en marche ]";
				Tests.Unit(test_visualiserS2, s2.visualiserEtat(c));
			}

			Tests.Case("Visualiser l'�tat des �cran du gestionnaire", 3); {

				// Afficher le statut complet du gestionnaire de site "g"
				//
				String test_g_toString = "Gestionnaire [ Site = [[[ nom = Fabron, localisation = route Napoleon, �crans = [[ nom = e1, site = Fabron, position = hall d'entr�e, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = e2, site = Fabron, position = premier etage, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ], [ nom = e3, site = Fabron, position = Entr�e batiment B, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]] ], [ nom = Sophia, localisation = quelquepart, �crans = [[ nom = e4, site = Sophia, position = Entr�e batiment A, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]]] ]";
				Tests.Unit(test_g_toString, g.toString());

				// Afficher la visualisation de l'�tat des �crans du site "s2"
				//
				String test_visualiserG = "[ e1 - en marche ][ e2 - en marche ][ e3 - en marche ][ e4 - en marche ]";
				Tests.Unit(test_visualiserG, g.visualiserEtat(c));
			}
		}

		Tests.Design("AS_ControleEcrans - Stopper un �cran", 3); {

			Tests.Case("Avant d'�teindre les �crans 'e1', 'e3' et 'e4'", 3); {

				// Verfifier que les �crans "e1", "e3" et "e4" sont en marche
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

			Tests.Case("Eteindre les �crans 'e1', 'e3' et 'e4'", 3); {

				// Eteindre les �crans "e1" et "e4"
				//
				Tests.Unit(true, e1.eteindreEcran(c));
				Tests.Unit(true, e3.eteindreEcran(c));
				Tests.Unit(true, e4.eteindreEcran(c));

				// Eteindre une seconde fois l'�crans "e1"
				//
				Tests.Unit(false, e1.eteindreEcran(c));
			}

			Tests.Case("Apr�s avoir �teint les �crans 'e1', 'e3' et 'e4'", 3); {

				// Verfifier que les �crans "e1" et "e4" sont en marche
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

		Tests.Design("AS_ControleEcrans - Savoir qui a arr�t� un �cran", 3); {

			Tests.Case("Savoir qui a arr�t� un �cran une premi�re fois", 3); {

				// Afficher par qui les �crans "e1", "e3" et "e4" sont en marche
				//
				Tests.Unit("Jule", e1.getEteintPar(c));
				Tests.Unit("Personne", e2.getEteintPar(c));
				Tests.Unit("Joe", e3.getEteintPar(c));
				Tests.Unit("Jule", e4.getEteintPar(c));
			}

			Tests.Case("Savoir qui a arr�t� un �cran une deuxieme fois", 3); {

				// Allumer l'�cran "e4"
				//
				e4.setEteint(false);

				// V�rifier l'�tat de l'�cran "e4"
				//
				Tests.Unit("en marche", e4.getEtat());

				// V�rifier que l'�cran "e4" ne soit pas eteint
				//
				Tests.Unit(false, e4.isEteint());

				// Eteindre l'�cran "e4" par une autre personne
				//
				e4.eteindreEcran(c);

				// V�rifier que la derni�re personne qui a �teint l'�cran "e4" est "Alice"
				//
				Tests.Unit("Alice", e4.getEteintPar(c));
			}

		}

		Tests.Design("AS_ControleEcrans - Consulter les erreurs lev�es par un �cran", 3); {

			Tests.Case("Consulter les erreurs de l'�cran 'e2' et 'e4'", 3); {

				// Consulter les erreurs de l'�cran "e2" et "e4"
				//
				Tests.Unit("[]", e2.consulterErreur(c));
				Tests.Unit("[]", e4.consulterErreur(c));

				// V�rifier que les �crans ne poss�de aucune erreurs lev�es
				//
				Tests.Unit(false, e1.isErreur());
				Tests.Unit(false, e2.isErreur());
				Tests.Unit(false, e3.isErreur());
				Tests.Unit(false, e4.isErreur());
			}

			// J'ajoute 2 erreurs a l'�cran "e2"
			//
			e2.getMockErreur().addErreur("�cran cass�");
			e2.getMockErreur().addErreur("souris disparu");

			Tests.Case("Consulter les erreurs de l'�cran 'e2'"); {

				// V�rification de la liste d'erreurs lev�es
				//
				Tests.Unit("[�cran cass�, souris disparu]", e2.consulterErreur(c));

				// V�rifier que l'�cran "e2" poss�de des erreurs
				//
				Tests.Unit(true, e2.getMockErreur().hasErreur());
				Tests.Unit(true, e2.isErreur());
				Tests.Unit("erreurs lev�es", e2.getEtat());

				// V�rifier que l'�cran "e2" poss�de 2 erreurs
				//
				Tests.Unit(2, e2.nombreErreur());
			}

			// J'enl�ve une erreur � l'�cran
			//
			e2.getMockErreur().removeErreur(1);

			Tests.Case("Consulter les erreurs de l'�cran 'e2'"); {

				// V�rification de la liste d'erreurs lev�es
				//
				Tests.Unit("[�cran cass�]", e2.consulterErreur(c));

				// V�rifier que l'�cran "e2" poss�de des erreurs
				//
				Tests.Unit(true, e2.getMockErreur().hasErreur());
				Tests.Unit(true, e2.isErreur());
				Tests.Unit("erreurs lev�es", e2.getEtat());

				// V�rifier que l'�cran "e2" poss�de plus qu'une erreur
				//
				Tests.Unit(1, e2.nombreErreur());
			}

			// J'enl�ve toutes les erreurs � l'�cran
			//
			e2.getMockErreur().removeAll();

			Tests.Case("Consulter les erreurs de l'�cran 'e2'"); {

				// V�rification de la liste d'erreurs lev�es
				//
				Tests.Unit("[]", e2.consulterErreur(c));

				// V�rifier que l'�cran "e2" poss�de des erreurs
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