package Tests_CE_CreerAfficheur;

import Modele.StockStyle;
import Modele.Style;

public class TUN_Style {

	public static void main(String[] args) {

		// Creer un Stock de style de départ
		//
		StockStyle stock_style = new StockStyle();

		// Creer plusieurs style
		//
		Style s1 = new Style("Noel", stock_style);
		Style s2 = new Style("IUT Fabron", stock_style);
		Style s3 = new Style("Festival de Cannes", stock_style);

		// Tests de l'US "CE_CreerAfficheur"
		//
		Tests.Begin("CE_CreerAfficheur", "1.0.0");

		// Tests de la class style
		//
		Tests.Design("Controle du style", 3); {

			Tests.Case("Accesseur de consultation"); {

				// Afficher le nom des styles
				//
				Tests.Unit("Noel", s1.getNom());
				Tests.Unit("IUT Fabron", s2.getNom());
				Tests.Unit("Festival de Cannes", s3.getNom());
			}

			Tests.Case("Méthode toString"); {

				// Afficher les styles
				//
				Tests.Unit("Style Noel", s1.toString());
				Tests.Unit("Style IUT Fabron", s2.toString());
				Tests.Unit("Style Festival de Cannes", s3.toString());
			}
		}

		// Tests de la class StockStyle
		//
		Tests.Design("Controle du Stock_style", 3); {

			Tests.Case("Accesseur de consultation"); {

				// Afficher le nom des style de la liste
				//
				Tests.Unit("Noel", stock_style.getStyle("Noel").getNom());
				Tests.Unit("IUT Fabron", stock_style.getStyle("IUT Fabron").getNom());
				Tests.Unit("Festival de Cannes", stock_style.getStyle("Festival de Cannes").getNom());
			}

			Tests.Case("Méthode toString"); {

				// Afficher la liste des style
				//
				String test_ST_toString = "Liste de Styles : {Festival de Cannes=Style Festival de Cannes, "
						+ "Basic=Style Basic, "
						+ "IUT Fabron=Style IUT Fabron, "
						+ "Noel=Style Noel}";
				
				Tests.Unit(test_ST_toString, stock_style.toString());
				
				// Afficher le nombre de style de la liste
				//
				Tests.Unit(4, stock_style.nombreStyle());

				// Afficher la liste des noms de style
				//
				Tests.Unit("Liste de Styles : [ [ Basic ] [ Noel ] [ IUT Fabron ] [ Festival de Cannes ] ]", stock_style.afficherNomS());
				
				// Afficher le nombre de nom de style
				//
				Tests.Unit(4, stock_style.nombreNom());
			}
		}

		Tests.End();
	}
}
