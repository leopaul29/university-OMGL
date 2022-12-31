package Tests;

import java.util.LinkedHashMap;

import Modele.Afficheur;
import Modele.Dimension;
import Modele.StockAfficheur;
import Modele.StockStyle;
import Modele.StockZone;
import Modele.Style;
import Modele.ZoneAlerte;
import Modele.ZoneBloc;
import Modele.ZoneText;

public class TUN_Afficheur {

	public static void main(String[] args) {

		// Creer un Stock de style de départ
		//
		StockStyle stock_style = new StockStyle();

		// Creer plusieurs styles
		//
		Style s1 = new Style("Noel", stock_style);
		Style s2 = new Style("IUT Fabron", stock_style);
		Style s3 = new Style("Festival de Cannes", stock_style);

		// Creer un Stock de zone de départ
		//
		StockZone stock_zone = new StockZone();

		// Creer plusieurs dimensions de zones
		//
		Dimension dim_z1 = new Dimension(500, 500);
		Dimension dim_z2 = new Dimension(200, 800);
		Dimension dim_z3 = new Dimension(300, 600);

		// Creer plusieurs zones
		//
		ZoneText z1 = new ZoneText("zone 1", dim_z1, "texte d'information", stock_zone);
		ZoneBloc z2 = new ZoneBloc("paysage", dim_z3, "chemin d'image", stock_zone);
		ZoneBloc z3 = new ZoneBloc("diaporama", dim_z2, "chemin dossierImages", stock_zone);
		ZoneAlerte zA = new ZoneAlerte("Alerte rouge", dim_z2, true, "URGENT", stock_zone);

		// Creer un Stock d'afficheur de départ
		//
		StockAfficheur stock_afficheur = new StockAfficheur();

		// Creer plusieurs dimensions d'afficheur
		//
		Dimension dim_ecran1 = new Dimension(800, 800);
		Dimension dim_ecran2 = new Dimension(1180, 800);
		Dimension dim_ecran3 = new Dimension(1366, 768);

		// Creer plusieur liste de zone pour afficheur
		//
		StockZone liste1 = new StockZone();
		StockZone liste2 = new StockZone();
		StockZone liste3 = new StockZone();

		// Remplir les liste de zone de chaque afficheur
		//
		liste1.ajouterZone(z3);
		liste1.ajouterZone(zA);

		liste2.ajouterZone(z2);
		liste2.ajouterZone(z1);
		liste2.ajouterZone(z3);

		liste3.ajouterZone(zA);
		liste3.ajouterZone(z3);
		liste3.ajouterZone(z1);
		liste3.ajouterZone(z2);

		// Creer plusieurs style
		//
		Afficheur a1 = new Afficheur("afficheur 1", dim_ecran1, liste1, stock_style, stock_afficheur);
		Afficheur a2 = new Afficheur("afficheur 2", dim_ecran2, liste2, stock_style, stock_afficheur);
		Afficheur a3 = new Afficheur("afficheur 3", dim_ecran3, s3, liste3, stock_afficheur);

		// Tests de l'US "CE_CreerAfficheur"
		//
		Tests.Begin("CE_CreerAfficheur", "1.0.0");

		// Tests de la class Afficheur
		//
		Tests.Design("Controle de l'afficheur", 3); {

			Tests.Case("Accesseur de consultation"); {

				// Afficher le nom des afficheurs
				//
				Tests.Unit("afficheur 1", a1.getNom());
				Tests.Unit("afficheur 2", a2.getNom());
				Tests.Unit("afficheur 3", a3.getNom());

				// Afficher les dimensions des afficheurs
				//
				Tests.Unit("Dimension [ height = 800.0, width = 800.0 ]", a1.afficherDimension());
				Tests.Unit("Dimension [ height = 800.0, width = 1180.0 ]", a2.afficherDimension());
				Tests.Unit("Dimension [ height = 768.0, width = 1366.0 ]", a3.afficherDimension());

				// Afficher le nom du styles des afficheurs
				//
				Tests.Unit("Basic", a1.getStyle().getNom());
				Tests.Unit("Basic", a2.getStyle().getNom());
				Tests.Unit("Festival de Cannes", a3.getStyle().getNom());

				// Afficher le nom des zones des afficheurs
				//
				Tests.Unit("Liste de Zones : [ [ diaporama ] [ Alerte rouge ] ]", a1.getListe_zones().afficherNomZ());
				Tests.Unit("Liste de Zones : [ [ paysage ] [ zone 1 ] [ diaporama ] ]", a2.getListe_zones().afficherNomZ());
				Tests.Unit("Liste de Zones : [ [ Alerte rouge ] [ diaporama ] [ zone 1 ] [ paysage ] ]", a3.getListe_zones().afficherNomZ());

				// Afficher les zones des afficheurs
				//
				String test_LZ1 = "{Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 800.0, width = 200.0 ], URGENT ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]}";
				Tests.Unit(test_LZ1, a1.getListe_zones().getListe_zones().toString());

				String test_LZ2 = "{paysage=Zone Bloc : paysage [ Dimension [ height = 600.0, width = 300.0 ], chemin d'image ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]}";
				Tests.Unit(test_LZ2, a2.getListe_zones().getListe_zones().toString());

				String test_LZ3 = "{paysage=Zone Bloc : paysage [ Dimension [ height = 600.0, width = 300.0 ], chemin d'image ], "
						+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 800.0, width = 200.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]}";
				Tests.Unit(test_LZ3, a3.getListe_zones().getListe_zones().toString());
			}

			Tests.Case("Méthode toString"); {

				// Afficher les afficheurs
				//
				String test_toS_a1 = "Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
						+ "Liste de Zones : {Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 800.0, width = 200.0 ], URGENT ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]} ]";
				Tests.Unit(test_toS_a1, a1.toString());

				String test_toS_a2 = "Afficheur afficheur 2 [ Dimension [ height = 800.0, width = 1180.0 ], Style Basic, "
						+ "Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 600.0, width = 300.0 ], chemin d'image ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]} ]";
				Tests.Unit(test_toS_a2, a2.toString());

				String test_toS_a3 = "Afficheur afficheur 3 [ Dimension [ height = 768.0, width = 1366.0 ], Style Festival de Cannes, "
						+ "Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 600.0, width = 300.0 ], chemin d'image ], "
						+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 800.0, width = 200.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]} ]";
				Tests.Unit(test_toS_a3, a3.toString());
			}

			Tests.Case("Un afficheur est dédié à une taille d'écran donnée"); {

				// Tests si on peut placer les zones
				// qui sont attribuées à chaque afficheur
				//
				Tests.Unit(true, a1.placerZone());
				Tests.Unit(true, a2.placerZone());
				Tests.Unit(true, a3.placerZone());

				// Tests si on peut placer differente liste de zones dans chaque afficheur
				//
				Tests.Unit(true, a2.placerZone(liste1));
				Tests.Unit(true, a3.placerZone(liste1));

				Tests.Unit(false, a1.placerZone(liste2));
				Tests.Unit(true, a3.placerZone(liste2));

				Tests.Unit(false, a1.placerZone(liste3));
				Tests.Unit(true, a2.placerZone(liste3));
			}

			Tests.Case("Associer un style à un afficheur"); {

				// Afficher le style de l'afficheur "sans style"
				//
				Tests.Unit("Basic", a1.getStyle().getNom());

				// Attribuer un style à un afficheur
				//
				a1.setStyle(s2);

				// Afficher le nouveau style de l'afficheur
				//
				Tests.Unit("IUT Fabron", a1.getStyle().getNom());
			}
		}

		// Tests de la class StockAfficheur
		//
		Tests.Design("Controle du Stock_style", 3); {

			Tests.Case("Méthode toString"); {

				// Afficher la liste des afficheurs
				//
				Tests.Unit("Liste des Afficheurs : [ [ afficheur 1 ] [ afficheur 2 ] [ afficheur 3 ] ]", stock_afficheur.afficherNomZ());

				String test_toS_LA = 
						// Afficheur 1
						//
						"{afficheur 1=Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style IUT Fabron, "
						+ "Liste de Zones : {Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 800.0, width = 200.0 ], URGENT ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]} ], "

						// Afficheur 2
						//
						+ "afficheur 2=Afficheur afficheur 2 [ Dimension [ height = 800.0, width = 1180.0 ], Style Basic, "
						+ "Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 600.0, width = 300.0 ], chemin d'image ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]} ], "

						// Afficheur 3
						//
						+ "afficheur 3=Afficheur afficheur 3 [ Dimension [ height = 768.0, width = 1366.0 ], Style Festival de Cannes, "
						+ "Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 600.0, width = 300.0 ], chemin d'image ], "
						+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 800.0, width = 200.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]} ]}";

				Tests.Unit(test_toS_LA
						, stock_afficheur.getListe_afficheur().toString());
			}

			Tests.Case("Associer un style à un afficheur"); {

				// Afficher le style de l'afficheur "sans style" dans la liste
				//
				Tests.Unit("Basic", stock_afficheur.getAfficheur(a2.getNom()).getStyle().getNom());
				
				// Attribuer un style à un afficheur de la liste
				//
				a2.setStyle(s1);

				// Afficher le nouveau style de l'afficheur de la liste
				//
				Tests.Unit("Noel", stock_afficheur.getAfficheur(a2.getNom()).getStyle().getNom());
			}
		}

		Tests.End();
	}
}
