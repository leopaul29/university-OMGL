package Tests_INT_Controle_Organise_Ecrans;

import Modele.Dimension;
import Modele.Ecran;
import Modele.Gestionnaire;
import Modele.Site;
import Modele.StockAfficheur;

public class TUN_AS_ConOrganiseEcrans {

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
		Ecran e1 = new Ecran(s1, "hall d'entrée", "ecran1", dim_ecran1, g);
		Ecran e2 = new Ecran(s1, "premier etage","ecran2", dim_ecran2, g);
		Ecran e3 = new Ecran(s2, "Entrée batiment B", "ecran3", dim_ecran1, g);
		Ecran e4 = new Ecran(s2, "Entrée batiment A", "ecran4", dim_ecran2, g);

		// Ajouter les sites au gestionnaire
		//
		g.ajouterSite(s1);
		g.ajouterSite(s2);

		/* Tests d'integration des US :
		 * 
		 * AS_ControleEcrans
		 * AS_ConOrganiseEcrans
		 */
		Tests.Begin("Intégration AS_ControleEcrans & AS_ConOrganiseEcrans"
				, "1.0.0");

		Tests.Design("AS_ConOrganiseEcrans - Accesseur", 3); {

			Tests.Case("Accesseur de consultation d'un écran", 3); {

				// Afficher le nom de l'écran "e1"
				//
				Tests.Unit("ecran1", e1.getNom());

				// Afficher le site de l'écran "e4"
				//
				String test_getSite = "[ nom = Sophia, localisation = quelquepart, écrans = [[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran4, site = Sophia, position = Entrée batiment A, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]";
				Tests.Unit(test_getSite, e4.getSite().toString());

				// Afficher la position de l'écran "e3"
				//
				Tests.Unit("Entrée batiment B", e3.getPosition());
			}

			Tests.Case("Accesseur de consultation d'un site", 3); {

				// Afficher le nom du site "s2"
				//
				Tests.Unit("Sophia", s2.getNom());

				// Afficher la position du site "s1"
				//
				Tests.Unit("route Napoleon", s1.getLocalisation());

				// Afficher la liste d'écran du site "s1"
				//
				String test_getListe_Ecrans = "[[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Fabron, position = premier etage, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]]";
				Tests.Unit(test_getListe_Ecrans, s1.getListe_Ecrans().toString());

				// Afficher le nombre d'écran du site "s2"
				//
				Tests.Unit(2, s2.nombreEcran());
			}

			Tests.Case("Accesseur de consultation du gestionnaire"); {

				// Afficher la liste des sites du gestionnaire
				//
				String test_getListe_site = "[[ nom = Fabron, localisation = route Napoleon, écrans = [[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Fabron, position = premier etage, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ], [ nom = Sophia, localisation = quelquepart, écrans = [[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran4, site = Sophia, position = Entrée batiment A, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]]";
				Tests.Unit(test_getListe_site, g.getListe_site().toString());

				// Afficher le contenu de la reserve
				//
				String test_getReserve = "[ nom = Reserve, localisation = secret defense, écrans = [] ]";
				Tests.Unit(test_getReserve, g.getReserve().toString());
			}
		}

		Tests.Design("AS_ConOrganiseEcrans - Méthode toString", 3); {

			Tests.Case("Méthode toString de l'écran", 3); {

				// Afficher le statut complet de l'écran "e1"
				//
				String test_e1_toString = "[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]";
				Tests.Unit(test_e1_toString, e1.toString());

				// Afficher le statut complet de l'écran "e2"
				//
				String test_e2_toString = "[ nom = ecran2, site = Fabron, position = premier etage, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]";
				Tests.Unit(test_e2_toString, e2.toString());

				// Afficher le statut complet de l'écran "e3"
				//
				String test_e3_toString = "[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]";
				Tests.Unit(test_e3_toString, e3.toString());

				// Afficher le statut complet de l'écran "e4"
				//
				String test_e4_toString = "[ nom = ecran4, site = Sophia, position = Entrée batiment A, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]";
				Tests.Unit(test_e4_toString, e4.toString());
			}

			Tests.Case("Méthode toString du site", 3); {

				// Afficher le statut complet du site "s1"
				//
				String test_s1_toString = "[ nom = Fabron, localisation = route Napoleon, écrans = [[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Fabron, position = premier etage, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]";
				Tests.Unit(test_s1_toString, s1.toString());

				// Afficher le statut complet du site "s2"
				//
				String test_s2_toString = "[ nom = Sophia, localisation = quelquepart, écrans = [[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran4, site = Sophia, position = Entrée batiment A, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]";
				Tests.Unit(test_s2_toString, s2.toString());
			}

			Tests.Case("Méthode toString du gestionnaire", 3); {

				// Afficher le statut complet du gestionnaire de site "g"
				//
				String test_g_toString = "Gestionnaire [ Site = [[[ nom = Fabron, localisation = route Napoleon, écrans = [[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Fabron, position = premier etage, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ], [ nom = Sophia, localisation = quelquepart, écrans = [[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran4, site = Sophia, position = Entrée batiment A, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]]] ]";
				Tests.Unit(test_g_toString, g.toString());
			}

			Tests.Design("AS_ConOrganiseEcrans - Changer de site un écran", 3); {

				Tests.Case("Avant le déplacement de l'écran 'e4'"); {

					// Vérifier le site de l'écran "e4" avant le déplacement
					//
					Tests.Unit("Sophia", e4.getSite().getNom());

					// Contenu du site "s2" avant le deplacement
					//
					String test_s2_avantDeplace = "[[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran4, site = Sophia, position = Entrée batiment A, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]]";
					Tests.Unit(test_s2_avantDeplace, s2.getListe_Ecrans().toString());

					// Contenue du site "s1" avant le deplacement
					//
					String test_s1_apresDeplace = "[[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Fabron, position = premier etage, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]]";
					Tests.Unit(test_s1_apresDeplace, s1.getListe_Ecrans().toString());
				}

				Tests.Case("Déplacer l'écran 'e4'"); {

					// Déplacer l'écran "e3" dans son site actuel
					//
					Tests.Unit(false, g.deplacerEcran(e3, s2));

					// ---													Déplacer l'écran "e4" de s1 à s2
					//
					Tests.Unit(true, g.deplacerEcran(e4, s1));
				}

				Tests.Case("Apres le déplacement de l'écran 'e4'"); {

					// Verifier le site de l'écran "e4" apres le déplacement
					//
					Tests.Unit("Fabron", e4.getSite().getNom());

					// Contenu du site "s2" après le deplacement
					//
					String test_s2_apresDeplace ="[[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]]";
					Tests.Unit(test_s2_apresDeplace, s2.getListe_Ecrans().toString());

					// Contenue du site "s1" après le deplacement
					//
					String test_s1_apresDeplace = "[[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Fabron, position = premier etage, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ], [ nom = ecran4, site = Fabron, position = null, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]]";
					Tests.Unit(test_s1_apresDeplace, s1.getListe_Ecrans().toString());
				}
			}

			Tests.Design("AS_ConOrganiseEcrans - Effacer un site", 3); {

				// Création d'un nouveau site
				//
				Site s3	= new Site("Antibes", "ailleur");

				// Ajouter le nouveau site au gestionnaire
				//
				g.ajouterSite(s3);

				Tests.Case("Avant d'éffacer les site 's2' et 's3'"); {

					// Verifier le contenu de la liste d'écran du site "s3"
					//
					Tests.Unit("[]", s3.getListe_Ecrans().toString());

					// Déplacer l'écran "e2" vers le site "s2"
					//
					g.deplacerEcran(e2, s2);

					// Verifier le contenu de la liste d'écran du site "s2"
					//
					String test_contenuS2 = "[[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Sophia, position = null, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]]";
					Tests.Unit(test_contenuS2, s2.getListe_Ecrans().toString());

					// Verifier que les sites "s2" et "s3" appartiennent au gestionnaire
					//
					String test_gToString = "Gestionnaire [ Site = [[[ nom = Fabron, localisation = route Napoleon, écrans = [[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran4, site = Fabron, position = null, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ], [ nom = Sophia, localisation = quelquepart, écrans = [[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Sophia, position = null, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ], [ nom = Antibes, localisation = ailleur, écrans = [] ]]] ]";

					Tests.Unit(test_gToString, g.toString());
				}

				Tests.Case("Effacer le site 's3'"); {

					// Effacer le site "s3"
					//
					Tests.Unit(true, g.effacerSite(s3));

					// Verifier que le site "s3" n'appartiennent plus au gestionnaire
					//
					String test_gToString2 = "Gestionnaire [ Site = [[[ nom = Fabron, localisation = route Napoleon, écrans = [[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran4, site = Fabron, position = null, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ], [ nom = Sophia, localisation = quelquepart, écrans = [[ nom = ecran3, site = Sophia, position = Entrée batiment B, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Sophia, position = null, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]] ]]] ]";

					Tests.Unit(test_gToString2, g.toString());

					// Verifier que le site "s3" n'existe plus, tous les attribut sont NULL
					//
					Tests.Unit(null, s3.getNom());
					Tests.Unit(null, s3.getLocalisation());
					Tests.Unit("[]", s3.getListe_Ecrans().toString());

					// Effacer une deuxieme fois le site "s3"
					//
					Tests.Unit(false, g.effacerSite(s3));
				}

				Tests.Case("Effacer le site 's2'"); {

					// Verifier le contenu de la reserve, avant d'effacer le site "s2"
					//
					Tests.Unit("[]", g.consulterReserve().toString());

					// Effacer le site "s2" qui lui possede un écran (e2)
					//
					Tests.Unit(true, g.deplacerEcran(e3, s1));
					Tests.Unit(1, s2.nombreEcran());
					Tests.Unit(true, g.effacerSite(s2));

					// Verifier que le site "s2" n'appartiennent plus au gestionnaire
					//
					String test_gToString3 = "Gestionnaire [ Site = [[[ nom = Fabron, localisation = route Napoleon, écrans = [[ nom = ecran1, site = Fabron, position = hall d'entrée, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran4, site = Fabron, position = null, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ], [ nom = ecran3, site = Fabron, position = null, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]] ]]] ]";

					Tests.Unit(test_gToString3, g.toString());

					// Verifier que le site "s2" n'existe plus, tous les attribut sont NULL
					//
					Tests.Unit(null, s2.getNom());
					Tests.Unit(null, s2.getLocalisation());
					Tests.Unit("[]", s2.getListe_Ecrans().toString());

					// Verifier le contenu de la reserve, apres avoir effacé le site "s2"
					//
					String test_contenuR = "[[ nom = ecran2, site = Reserve, position = null, état = en marche, erreurs levées = [], éteint = false, éteint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = null ]]";
					Tests.Unit(test_contenuR, g.consulterReserve().toString());
				}

				Tests.Case("Après avoir effacé les site 's2' et 's3'"); {

					// Verifier que l'on a plus accès au site "s2"
					//
					try{
						Tests.Unit(null, g.getListe_site().get(1).getNom());
					}catch(Exception e){
						System.out.println("\n     Le site s2 n'est plus present dans la liste");
					}

					// Verifier que l'on a plus accès au site "s3"
					//
					try{
						Tests.Unit(null, g.getListe_site().get(2).getNom());
					}catch(Exception e){
						System.out.println("\n     Le site s3 n'est plus present dans la liste");
					}

					// Verifier la taille du gestionnaire
					//
					Tests.Unit(1, g.nombreSite());
				}
			}
		}

		Tests.End();
	}
}
