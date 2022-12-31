package Tests_CE_AssocieRenderers;

import Modele.Afficheur;
import Modele.Dimension;
import Modele.Ecran;
import Modele.Gestionnaire;
import Modele.Renderer;
import Modele.Site;
import Modele.StockAfficheur;
import Modele.StockRenderers;
import Modele.StockStyle;
import Modele.StockZone;
import Modele.Style;
import Modele.ZoneAlerte;
import Modele.ZoneBloc;
import Modele.ZoneText;
import Tests_AE_associeAfficheurEcran.Tests;

public class TUN_associeRenderers {

	public static void main(String[] args) {

		// Creer un Stock de style de d�part
		//
		StockStyle stock_style = new StockStyle();

		// Creer plusieurs styles
		//
		Style s1 = new Style("Noel", stock_style);
		Style s2 = new Style("IUT Fabron", stock_style);
		Style s3 = new Style("Festival de Cannes", stock_style);

		// Creer un Stock de zone de d�part
		//
		StockZone stock_zone = new StockZone();

		// Creer plusieurs dimensions de zones
		//
		Dimension dim_z1 = new Dimension(100, 300);
		Dimension dim_z2 = new Dimension(200, 400);
		Dimension dim_z3 = new Dimension(300, 600);
		Dimension dim_z4 = new Dimension(110, 500);

		// Creer plusieurs zones
		//
		ZoneText z1 = new ZoneText("zone 1", dim_z1, "texte d'information", stock_zone);
		ZoneBloc z2 = new ZoneBloc("paysage", dim_z2, null, stock_zone);
		ZoneBloc z3 = new ZoneBloc("diaporama", dim_z3, null, stock_zone);
		ZoneAlerte zA = new ZoneAlerte("Alerte rouge", dim_z4, true, "URGENT", stock_zone);

		// Creer un Stock d'afficheur de d�part
		//
		StockAfficheur stock_afficheur = new StockAfficheur();

		// Creer plusieurs dimensions d'�cran d�di� au afficheur
		//
		Dimension dim_ecran1 = new Dimension(800, 800);
		Dimension dim_ecran2 = new Dimension(600, 600);

		// Creer plusieur liste de zone pour afficheur
		//
		StockZone liste1 = new StockZone();
		StockZone liste2 = new StockZone();
		StockZone liste3 = new StockZone();

		// Remplir les liste de zone de chaque afficheur
		//
		liste1.ajouterZone(z3);
		liste1.ajouterZone(zA);
		liste1.ajouterZone(z1);

		liste2.ajouterZone(z2);
		liste2.ajouterZone(z1);
		liste2.ajouterZone(z3);

		liste3.ajouterZone(zA);
		liste3.ajouterZone(z2);
		liste3.ajouterZone(z1);

		// Creer plusieurs afficheurs
		//
		Afficheur a1 = new Afficheur("afficheur 1", dim_ecran1, "leo", s2, liste1, stock_afficheur);
		Afficheur a2 = new Afficheur("afficheur 2", dim_ecran2, "corentin", s1, liste2, stock_afficheur);

		// Creer un stock de renderers de d�part
		//
		StockRenderers stock_renderers = new StockRenderers();

		// Creer plusieurs renderers
		//
		Renderer r1 = new Renderer("renderer 1",s1, a2, dim_z1, dim_z3, "chemin image", z2, stock_renderers);
		Renderer r2 = new Renderer("renderer 2", s3, a1, dim_z1, dim_z3, "diaporama", zA, stock_renderers);

		// Cr�er le gestionnaire d'�cran
		//
		Gestionnaire g = new Gestionnaire(stock_afficheur);

		// D�clarer des sites par leur nom, leur localisation
		//
		Site site1 = new Site("Fabron", "route Napoleon");
		Site site2 = new Site("Sophia", "quelquepart");

		// Cr�er plusieurs �crans
		//
		Ecran e1 = new Ecran(site1, "hall d'entr�e", "ecran1", dim_ecran1, a1, g);
		Ecran e2 = new Ecran(site1, "premier etage","ecran2", dim_ecran2, a2, g);
		Ecran e3 = new Ecran(site2, "Entr�e batiment B", "ecran3", dim_ecran1, g);
		Ecran e4 = new Ecran(site2, "Entr�e batiment A", "ecran4", dim_ecran2, g);

		// Tests CE_associeRenderer
		//
		Tests.Begin("Renderers", "1.0.0");

		// Tests Class Renderer
		//
		Tests.Design("Controle des renderers", 3); {

			// V�rifier les dimensions des renderers
			//
			Tests.Case("Afficher la dimension des renderers"); {

				// Afficher les dimensions minimun des renderers
				//
				Tests.Unit("Dimension [ height = 100.0, width = 300.0 ]", r1.afficherDimensionMin());
				Tests.Unit("Dimension [ height = 100.0, width = 300.0 ]", r2.afficherDimensionMin());

				// Afficher les dimensions maximum des renderers
				//
				Tests.Unit("Dimension [ height = 300.0, width = 600.0 ]", r1.afficherDimensionMax());
				Tests.Unit("Dimension [ height = 300.0, width = 600.0 ]", r2.afficherDimensionMax());
			}

			// V�rifier les dimensions des �crans d�di� aux afficheur
			//
			Tests.Case("V�rifier que la zone corresponde a l'intervalle de dimension du renderer"); {

				// V�rifier la hauteur par rapport leur zone cible
				//
				Tests.Unit(true, r1.verif_hauteurZone());
				Tests.Unit(true, r2.verif_hauteurZone());

				// V�rifier la largeur par rapport leur zone cible
				//
				Tests.Unit(true, r1.verif_largeurZone());
				Tests.Unit(true, r2.verif_largeurZone());

				// V�rifier la hauteur et la largeur par rapport leur zone cible
				//
				Tests.Unit(true, r1.verif_dimZone());
				Tests.Unit(true, r2.verif_dimZone());
			}

			Tests.Case("V�rifier que le style du renderer est en rapport avec celui de l'afficheur"); {

				// V�rifier le style par rapport � leur afficheur
				//
				Tests.Unit(true, r1.verif_style());
				Tests.Unit(false, r2.verif_style());

				// V�rifier le style par rapport � d'autre afficheur
				//
				Tests.Unit(false, r1.verif_style(a1));
				Tests.Unit(false, r2.verif_style(a1));
				Tests.Unit(false, r2.verif_style(a2));
			}

			Tests.Case("V�rifier que la zone est du type 'Bloc'"); {

				// V�rifier que le type de leurs zone cible puisse accueillir un renderer
				//
				Tests.Unit(true, r1.verif_typeZone());
				Tests.Unit(false, r2.verif_typeZone());
			}

			Tests.Case("V�rifier que le renderer corresponde bien � une zone"); {

				// V�rifier que la zone est valide
				//
				Tests.Unit(true, r1.verif_zone());
				Tests.Unit(false, r2.verif_zone());

				// V�rifier que la zone est valide par rapport � d'autre style d'afficheur
				//
				Tests.Unit(false, r1.verif_zone(a1));
				Tests.Unit(false, r2.verif_zone(a1));
				Tests.Unit(false, r2.verif_zone(a2));
			}

			Tests.Case("V�rifier le contenue des zones a present"); {

				// V�rifier les source d'information
				//
				Tests.Unit(null, z3.getSource_information());

				// Ici, le renderer � �tait ajout� comme source d'information � la zone z2
				//
				Tests.Unit("Renderer : renderer 1[ "
						+ "dimension(min) = Dimension [ height = 100.0, width = 300.0 ], "
						+ "dimension(max) = Dimension [ height = 300.0, width = 600.0 ], "
						+ "Style = Style Noel, Source = chemin image ]", z2.getSource_information().toString());
			}
		}

		// Tests Class StockRenderers
		//
		Tests.Design("Class StockRenderers", 3); {

			Tests.Case("Liste de nom des renderers"); {

				// Afficher le nom des renderers
				//
				Tests.Unit("Liste de Renderers : [ [ renderer 1 ] [ renderer 2 ] ]", stock_renderers.afficherNomR());

				// Afficher le nombre de noms de renderers
				//
				Tests.Unit(2, stock_renderers.nombreNom());
			}

			Tests.Case("Liste des renderers"); {

				// Afficher le nombre de renderers
				//
				Tests.Unit(2, stock_renderers.nombreRenderer());

				// Afficher les renderers
				//
				Tests.Unit("Liste de Renderers : {"
						+ "renderer 2=Renderer : renderer 2[ "
						+ "dimension(min) = Dimension [ height = 100.0, width = 300.0 ], "
						+ "dimension(max) = Dimension [ height = 300.0, width = 600.0 ], "
						+ "Style = Style Festival de Cannes, Source = diaporama ], "

						+ "renderer 1=Renderer : renderer 1[ "
						+ "dimension(min) = Dimension [ height = 100.0, width = 300.0 ], "
						+ "dimension(max) = Dimension [ height = 300.0, width = 600.0 ], "
						+ "Style = Style Noel, Source = chemin image ]}"

						, stock_renderers.toString());
			}
		}

		// V�rifier les �crans
		//
		Tests.Design("Controle des �crans", 3); {

			// V�rifier le nom des �crans
			//
			Tests.Case("Afficher le nom des �crans");{

				Tests.Unit("ecran1", e1.getNom());
				Tests.Unit("ecran2", e2.getNom());
				Tests.Unit("ecran3", e3.getNom());
				Tests.Unit("ecran4", e4.getNom());
			}

			// V�rifier les dimensions des �crans
			//
			Tests.Case("Afficher les dimensions des �crans");{

				Tests.Unit("Dimension [ height = 800.0, width = 800.0 ]", e1.afficherDimension());
				Tests.Unit("Dimension [ height = 600.0, width = 600.0 ]", e2.afficherDimension());
				Tests.Unit("Dimension [ height = 800.0, width = 800.0 ]", e3.afficherDimension());
				Tests.Unit("Dimension [ height = 600.0, width = 600.0 ]", e4.afficherDimension());
			}

			// V�rifier les dimensions des afficheur
			//
			Tests.Case("Afficher les dimensions des afficheur");{

				// V�rifier les dimension de l'afficheur
				//
				Tests.Unit("Dimension [ height = 400.0, width = 600.0 ]", a1.afficherDimensionA());
				Tests.Unit("Dimension [ height = 600.0, width = 600.0 ]", a2.afficherDimensionA());

				// V�rifier les dimension de l'�cran auquel il est d�di�
				//
				Tests.Unit("Dimension [ height = 800.0, width = 800.0 ]", a1.afficherDimensionE());
				Tests.Unit("Dimension [ height = 600.0, width = 600.0 ]", a2.afficherDimensionE());
			}

			// V�rifi� que chaque �cran possede un afficheur et en afficher le nom
			//
			Tests.Case("Afficher le nom de l'afficheur que possede un �cran"); {

				try {
					Tests.Unit("afficheur 1", e1.getAfficheur().getNom());
				}catch(Exception e){
					System.out.println("\n\tL'�cran 1 ne possede pas d'afficheur");
				}

				try {
					Tests.Unit("afficheur 2", e2.getAfficheur().getNom());
				}catch(Exception e){
					System.out.println("\n\tL'�cran 2 ne possede pas d'afficheur");
				}

				try {
					Tests.Unit("", e3.getAfficheur().getNom());
				}catch(Exception e){
					System.out.println("\n\tL'�cran 3 ne possede pas d'afficheur");
				}

				try {
					Tests.Unit("afficheur 4", e4.getAfficheur().getNom());
				}catch(Exception e){
					System.out.println("\n\tL'�cran 4 ne possede pas d'afficheur");
				}
			}

			// V�rifi� que chaque �cran possede un afficheur
			//
			Tests.Case("V�rifi� que chaque �cran possede un afficheur"); {

				Tests.Unit(false, e1.possederAfficheur());
				Tests.Unit(true, e2.possederAfficheur());
				Tests.Unit(false, e3.possederAfficheur());
				Tests.Unit(false, e4.possederAfficheur());
			}

			// V�rifi� si un �cran peut posseder un autre afficheur
			//
			Tests.Case("V�rifi� qu'un autre afficheur est peut etre compatible pour un autre �cran sans afficheur");{

				Tests.Unit(false, e1.setAfficheurComp(a1));
				Tests.Unit(false, e1.setAfficheurComp(a2));

				Tests.Unit(false, e2.setAfficheurComp(a1));
				Tests.Unit(true, e2.setAfficheurComp(a2));

				Tests.Unit(false, e3.setAfficheurComp(a1));
				Tests.Unit(false, e3.setAfficheurComp(a2));

				Tests.Unit(false, e4.setAfficheurComp(a1));
				Tests.Unit(true, e4.setAfficheurComp(a2));
			}

			// V�rifi� le contenu d'un �crans
			//
			Tests.Case("Afficher un �cran");{

				// Ecran 1
				//
				String test_e1 = "[ nom = ecran1, site = Fabron, position = hall d'entr�e, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]";

				Tests.Unit(test_e1, e1.toString());


				// Ecran 2
				//
				String test_e2 = "[ nom = ecran2, site = Fabron, position = premier etage, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = Afficheur afficheur 2 [ Dimension [ height = 600.0, width = 600.0 ], Style Noel, Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 200.0, width = 400.0 ], Renderer : renderer 1[ dimension(min) = Dimension [ height = 100.0, width = 300.0 ], dimension(max) = Dimension [ height = 300.0, width = 600.0 ], Style = Style Noel, Source = chemin image ] ], zone 1=Zone Text : zone 1 [ Dimension [ height = 100.0, width = 300.0 ], texte d'information ], diaporama=Zone Bloc : diaporama [ Dimension [ height = 300.0, width = 600.0 ], null ]} ] ]";

				Tests.Unit(test_e2, e2.toString());


				// Ecran 3
				//
				String test_e3 = "[ nom = ecran3, site = Sophia, position = Entr�e batiment B, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ]";

				Tests.Unit(test_e3, e3.toString());


				// Ecran 4
				//
				String test_e4 = "[ nom = ecran4, site = Sophia, position = Entr�e batiment A, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = Afficheur afficheur 2 [ Dimension [ height = 600.0, width = 600.0 ], Style Noel, Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 200.0, width = 400.0 ], Renderer : renderer 1[ dimension(min) = Dimension [ height = 100.0, width = 300.0 ], dimension(max) = Dimension [ height = 300.0, width = 600.0 ], Style = Style Noel, Source = chemin image ] ], zone 1=Zone Text : zone 1 [ Dimension [ height = 100.0, width = 300.0 ], texte d'information ], diaporama=Zone Bloc : diaporama [ Dimension [ height = 300.0, width = 600.0 ], null ]} ] ]";

				Tests.Unit(test_e4, e4.toString());
			}

			// V�rifi� le contenu du gestionnaire
			//
			Tests.Case("Afficher le gestionnaire");{

				// V�rifi� le contenu de la liste d'afficheur du gestionnaire
				//
				String test_gA = "Liste d'Afficheurs : {"
						+ "afficheur 1=Afficheur afficheur 1 [ Dimension [ height = 400.0, width = 600.0 ], Style IUT Fabron, "
						+ "Liste de Zones : {Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 110.0, width = 500.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 100.0, width = 300.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 300.0, width = 600.0 ], null ]} ], "

						+ "afficheur 2=Afficheur afficheur 2 [ Dimension [ height = 600.0, width = 600.0 ], Style Noel, "
						+ "Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 200.0, width = 400.0 ], "
						// Renderer associ� !
						+ "Renderer : renderer 1[ dimension(min) = Dimension [ height = 100.0, width = 300.0 ], "
						+ "dimension(max) = Dimension [ height = 300.0, width = 600.0 ], Style = Style Noel, Source = chemin image ] ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 100.0, width = 300.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 300.0, width = 600.0 ], null ]} ]}";

				Tests.Unit(test_gA, g.afficherAfficheurs());

				// V�rifier le nombre d'afficheur dans la liste
				//
				Tests.Unit(2, g.nombreAfficheur());

				// V�rifi� le contenu de la liste d'�cran du gestionnaire
				//
				String test_gE = "[[ nom = ecran1, site = Fabron, position = hall d'entr�e, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran2, site = Fabron, position = premier etage, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = Afficheur afficheur 2 [ Dimension [ height = 600.0, width = 600.0 ], Style Noel, Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 200.0, width = 400.0 ], Renderer : renderer 1[ dimension(min) = Dimension [ height = 100.0, width = 300.0 ], dimension(max) = Dimension [ height = 300.0, width = 600.0 ], Style = Style Noel, Source = chemin image ] ], zone 1=Zone Text : zone 1 [ Dimension [ height = 100.0, width = 300.0 ], texte d'information ], diaporama=Zone Bloc : diaporama [ Dimension [ height = 300.0, width = 600.0 ], null ]} ] ], [ nom = ecran3, site = Sophia, position = Entr�e batiment B, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 800.0, width = 800.0 ], afficheur = null ], [ nom = ecran4, site = Sophia, position = Entr�e batiment A, �tat = en marche, erreurs lev�es = [], �teint = false, �teint par = Personne, dimension = Dimension [ height = 600.0, width = 600.0 ], afficheur = Afficheur afficheur 2 [ Dimension [ height = 600.0, width = 600.0 ], Style Noel, Liste de Zones : {paysage=Zone Bloc : paysage [ Dimension [ height = 200.0, width = 400.0 ], Renderer : renderer 1[ dimension(min) = Dimension [ height = 100.0, width = 300.0 ], dimension(max) = Dimension [ height = 300.0, width = 600.0 ], Style = Style Noel, Source = chemin image ] ], zone 1=Zone Text : zone 1 [ Dimension [ height = 100.0, width = 300.0 ], texte d'information ], diaporama=Zone Bloc : diaporama [ Dimension [ height = 300.0, width = 600.0 ], null ]} ] ]]";

				Tests.Unit(test_gE, g.afficherEcrans());

				// V�rifier le nombre d'�crans dans la liste
				//
				Tests.Unit(4, g.nombreEcran());
			}
		}

		Tests.End();
	}
}