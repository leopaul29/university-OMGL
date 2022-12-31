package Tests;

import Modele.Dimension;

public class TUN_Dimension {

	public static void main(String[] args) {

		// Creer plusieurs dimensions d'écran
		//
		Dimension dim_e1 = new Dimension(1300, 800);
		Dimension dim_e2 = new Dimension(1280, 800);
		Dimension dim_e3 = new Dimension(1366,768);

		// Creer plusieurs dimensions d'afficheur
		//
		Dimension dim_a1 = new Dimension(1366,768);
		Dimension dim_a2 = new Dimension(1600, 1200);

		// Tests de l'US "CE_CreerAfficheur"
		//
		Tests.Begin("CE_CreerAfficheur", "1.0.0");

		// Tests de la class Dimension
		//
		Tests.Design("Class Dimension", 3); {

			Tests.Case("Accesseur de consultation"); {

				// Afficher la hauteur des dimensions
				//
				Tests.Unit(800, dim_e1.getHeight());
				Tests.Unit(800, dim_e2.getHeight());
				Tests.Unit(768, dim_a1.getHeight());

				// Afficher la largeur des dimensions
				//
				Tests.Unit(1300, dim_e1.getWidth());
				Tests.Unit(1366, dim_e3.getWidth());
				Tests.Unit(1600, dim_a2.getWidth());
			}

			Tests.Case("Méthode equals"); {

				// Comparer des dimensions
				//
				Tests.Unit(false, dim_e1.equals(dim_a2));
				Tests.Unit(false, dim_e2.equals(dim_a1));
				Tests.Unit(true, dim_e3.equals(dim_a1));
			}

			Tests.Case("Méthode toString"); {

				// Afficher les dimensions
				//
				Tests.Unit("Dimension [ height = 800.0, width = 1300.0 ]", dim_e1.toString());

				Tests.Unit("Dimension [ height = 768.0, width = 1366.0 ]", dim_a1.toString());

				Tests.Unit("Dimension [ height = 1200.0, width = 1600.0 ]", dim_a2.toString());
			}
		}

		Tests.End();
	}
}
