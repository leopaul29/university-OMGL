package Tests;

import Modele.Dimension;
import Modele.StockZone;
import Modele.ZoneAlerte;
import Modele.ZoneBloc;
import Modele.ZoneText;

public class TUN_Zone {

	public static void main(String[] args) {

		// Creer un Stock de style de départ
		//
		StockZone stock_zone = new StockZone();

		// Creer plusieurs dimensions de zones
		//
		Dimension dim_z1 = new Dimension(500, 500);
		Dimension dim_z2 = new Dimension(200, 800);
		Dimension dim_z3 = new Dimension(600, 300);

		// Creer plusieurs style
		//
		ZoneText z1 = new ZoneText("zone 1", dim_z1, "texte d'information", stock_zone);
		ZoneBloc z2 = new ZoneBloc("paysage", dim_z3, "chemin d'image", stock_zone);
		ZoneBloc z3 = new ZoneBloc("diaporama", dim_z2, "chemin dossierImages", stock_zone);
		ZoneAlerte zA = new ZoneAlerte("Alerte rouge", dim_z2, true, "URGENT", stock_zone);

		// Tests de l'US "CE_CreerAfficheur"
		//
		Tests.Begin("CE_CreerAfficheur", "1.0.0");

		// Tests de la class style
		//
		Tests.Design("Controle du style", 3); {

			// Tests des getters
			//
			Tests.Case("Accesseur de consultation"); {

				// Afficher le nom des zones
				//
				Tests.Unit("zone 1", z1.getNom());
				Tests.Unit("paysage", z2.getNom());
				Tests.Unit("diaporama", z3.getNom());
				Tests.Unit("Alerte rouge", zA.getNom());

				// Afficher la dimension des zones
				//
				Tests.Unit("Dimension [ height = 500.0, width = 500.0 ]", z1.afficherDim());
				Tests.Unit("Dimension [ height = 300.0, width = 600.0 ]", z2.afficherDim());
				Tests.Unit("Dimension [ height = 800.0, width = 200.0 ]", zA.afficherDim());

				// Afficher le sources d'information des zones
				//
				Tests.Unit("texte d'information", z1.getSource_information());
				Tests.Unit("chemin d'image", z2.getSource_information());
				Tests.Unit("chemin dossierImages", z3.getSource_information());
				Tests.Unit("URGENT", zA.getSource_information());
			}

			Tests.Case("Accesseur du type"); {

				// Tests du type bloc
				//
				Tests.Unit(false, z1.isType_bloc());
				Tests.Unit(true, z2.isType_bloc());
				Tests.Unit(false, zA.isType_bloc());

				// Tests du type texte
				//
				Tests.Unit(true, z1.isType_text());
				Tests.Unit(false, z3.isType_text());
				Tests.Unit(true, zA.isType_text());

				// Afficher si la zone est du type "bloc", "texte" , "blocAlerte" ou "textAlerte"
				//
				Tests.Unit("Text", z1.afficherType());
				Tests.Unit("Bloc", z2.afficherType());
				Tests.Unit("Bloc", z3.afficherType());
				Tests.Unit("TextAlerte", zA.afficherType());
			}

			Tests.Case("Accesseur de Zone d'alerte"); {

				// Tests du type d'alerte
				//
				Tests.Unit(false, z2.isAlerte());
				Tests.Unit(false, z3.isAlerte());
				Tests.Unit(true, zA.isAlerte());
			}

			Tests.Case("Nommer une zone"); {

				// Afficher le nom de la zone
				//
				Tests.Unit("zone 1", z1.getNom());

				// Renommer la zone
				//
				z1.setNom("zone 2");
				
				// Afficher le nom de la zone
				//
				Tests.Unit("zone 2", z1.getNom());
				
				// Renommer la zone
				//
				z1.setNom("zone 1");
				
				// Afficher le nom de la zone
				//
				Tests.Unit("zone 1", z1.getNom());
			}

			Tests.Case("Méthode toString"); {

				// Afficher les zones
				//
				Tests.Unit("Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]"
						, z1.toString());
				Tests.Unit("Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ]"
						, z2.toString());
				Tests.Unit("Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]"
						, z3.toString());
				Tests.Unit("Zone TextAlerte : Alerte rouge [ Dimension [ height = 800.0, width = 200.0 ], URGENT ]"
						, zA.toString());
			}
		}

		// Tests de la class StockStyle
		//
		Tests.Design("Controle du Stock_zones", 3); {

			// Tests des getters
			//
			Tests.Case("Accesseur de consultation"); {

				String zone1 = "zone 1";
				String im = "paysage";
				String diapo = "diaporama";
				String alerte = "Alerte rouge";

				// Afficher le nom des zones de la liste
				//
				Tests.Unit("zone 1", stock_zone.getZone(zone1).getNom());
				Tests.Unit("diaporama", stock_zone.getZone(diapo).getNom());
				Tests.Unit("paysage", stock_zone.getZone(im).getNom());
				Tests.Unit("Alerte rouge", stock_zone.getZone(alerte).getNom());

				// Afficher la dimensions des zones de la liste
				//
				Tests.Unit("Dimension [ height = 800.0, width = 200.0 ]", stock_zone.getZone(alerte).afficherDim());
				Tests.Unit("Dimension [ height = 300.0, width = 600.0 ]", stock_zone.getZone(im).afficherDim());
				Tests.Unit("Dimension [ height = 500.0, width = 500.0 ]", stock_zone.getZone(zone1).afficherDim());
				Tests.Unit("Dimension [ height = 800.0, width = 200.0 ]", stock_zone.getZone(diapo).afficherDim());
				
				// Afficher la source d'information des zones de la liste
				//
				Tests.Unit("chemin d'image", stock_zone.getZone(im).getSource_information());
				Tests.Unit("chemin dossierImages", stock_zone.getZone(diapo).getSource_information());
				Tests.Unit("URGENT", stock_zone.getZone(alerte).getSource_information());
				Tests.Unit("texte d'information", stock_zone.getZone(zone1).getSource_information());

				// Test du type bloc
				//
				Tests.Unit(true, stock_zone.getZone(im).isType_bloc());
				Tests.Unit(true, stock_zone.getZone(diapo).isType_bloc());
				Tests.Unit(false,stock_zone.getZone(alerte).isType_bloc());
				Tests.Unit(false, stock_zone.getZone(zone1).isType_bloc());

				// Test du type texte
				//
				Tests.Unit(true, stock_zone.getZone(zone1).isType_text());
				Tests.Unit(false, stock_zone.getZone(im).isType_text());
				Tests.Unit(false, stock_zone.getZone(diapo).isType_text());
				Tests.Unit(true, stock_zone.getZone(alerte).isType_text());

				// Test du type alerte
				//
				Tests.Unit(true, stock_zone.getZone(alerte).isAlerte());
				Tests.Unit(false, stock_zone.getZone(diapo).isAlerte());
				Tests.Unit(false, stock_zone.getZone(zone1).isAlerte());
				Tests.Unit(false, stock_zone.getZone(im).isAlerte());
			}

			Tests.Case("Méthode toString"); {

				// Liste des zones
				//
				String test_toString1 = "Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ],"
						+ " Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 800.0, width = 200.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 800.0, width = 200.0 ], chemin dossierImages ]}";

				Tests.Unit(test_toString1, stock_zone.toString());
				
				// Nombre de zones de la liste
				//
				Tests.Unit(4, stock_zone.nombreZone());

				// Liste des noms de la zone
				//
				Tests.Unit("Liste de Zones : [ [ zone 1 ] [ paysage ] [ diaporama ] [ Alerte rouge ] ]", stock_zone.afficherNomZ());
				
				// Nombre de noms de la liste
				//
				Tests.Unit(4, stock_zone.nombreNom());
			}

			Tests.Case("Nommer une zone"); {

				// Afficher le nom de la zone
				//
				Tests.Unit("zone 1", z1.getNom());

				// Renommer la zone
				//
				z1.setNom("Information");

				// Afficher le nom de la zone
				//
				Tests.Unit("Information", z1.getNom());

				// Afficher le nom de la zone
				//
				Tests.Unit("Alerte rouge", zA.getNom());

				// Renommer la zone
				//
				zA.setNom("Alerte");

				// Afficher le nom de la zone
				//
				Tests.Unit("Alerte", zA.getNom());
			}
		}

		Tests.End();
	}
}
