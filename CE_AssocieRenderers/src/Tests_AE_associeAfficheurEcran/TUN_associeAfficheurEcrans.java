package Tests_AE_associeAfficheurEcran;

import Modele.Afficheur;
import Modele.Dimension;
import Modele.Ecran;
import Modele.GestionnaireEcrans;
import Modele.StockAfficheur;
import Modele.StockStyle;
import Modele.StockZone;
import Modele.Style;
import Modele.ZoneAlerte;
import Modele.ZoneBloc;
import Modele.ZoneText;

public class TUN_associeAfficheurEcrans {


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
		Dimension dim_z4 = new Dimension(100, 500);
		Dimension dim_z5 = new Dimension(366, 768);
		Dimension dim_z6 = new Dimension(180, 768);

		// Creer plusieurs zones
		//
		ZoneText z1 = new ZoneText("zone 1", dim_z1, "texte d'information", stock_zone);
		ZoneBloc z2 = new ZoneBloc("paysage", dim_z3, "chemin d'image", stock_zone);
		ZoneBloc z3 = new ZoneBloc("diaporama", dim_z2, "chemin dossierImages", stock_zone);
		ZoneAlerte zA = new ZoneAlerte("Alerte rouge", dim_z1, true, "URGENT", stock_zone);
		ZoneText z4 = new ZoneText("zone 4", dim_z4, "vide", stock_zone);
		ZoneText z5 = new ZoneText("zone 5", dim_z5, "vide", stock_zone);
		ZoneBloc z6 = new ZoneBloc("zone 6", dim_z6, "vide", stock_zone);

		// Creer un Stock d'afficheur de départ
		//
		StockAfficheur stock_afficheur = new StockAfficheur();

		// Creer plusieurs dimensions d'écran dédié au afficheur
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
		liste1.ajouterZone(z1);
		liste1.ajouterZone(z4);

		liste2.ajouterZone(z2);
		liste2.ajouterZone(z1);
		liste2.ajouterZone(z3);
		liste2.ajouterZone(z6);

		liste3.ajouterZone(zA);
		liste3.ajouterZone(z2);
		liste3.ajouterZone(z1);
		liste3.ajouterZone(z4);
		liste3.ajouterZone(z4);
		liste3.ajouterZone(z5);

		// Creer plusieurs afficheurs
		//
		Afficheur a1 = new Afficheur("afficheur 1", dim_ecran1, "leo", liste1, stock_style, stock_afficheur);
		Afficheur a2 = new Afficheur("afficheur 2", dim_ecran2, "corentin", liste2, stock_style, stock_afficheur);
		Afficheur a3 = new Afficheur("afficheur 3", dim_ecran3, "coraline", s3, liste3, stock_afficheur);
		Afficheur a4 = new Afficheur("afficheur 4", dim_ecran3, "leo", s2, liste2, stock_afficheur);
		Afficheur a5 = new Afficheur("afficheur 5", dim_ecran3, "leo", s1, liste1, stock_afficheur);

		// Créer le gestionnaire d'écran
		//
		GestionnaireEcrans g = new GestionnaireEcrans(stock_afficheur);

		// Créer plusieurs écrans
		//
		Ecran e1 = new Ecran("ecran1", dim_ecran1, a1, g);
		Ecran e2 = new Ecran("ecran2", dim_ecran2, a2, g);
		Ecran e3 = new Ecran("ecran3", dim_ecran3, g);
		Ecran e4 = new Ecran("ecran4", dim_ecran1, a4, g);
		Ecran e5 = new Ecran("ecran5", dim_ecran2, a5, g);

		/* Tests d'integration des US :
		 * 
		 * AE_AssocieAfficheurEcran
		 * CE_CreerAfficheur
		 */
		Tests.Begin("Intégration AE_AssocieAfficheurEcran & CE_CreerAfficheur"
				, "1.0.0");

		// Vérifier les dimensions
		//
		Tests.Design("Controle des dimensions", 3); {

			// Vérifier les dimensions des écrans
			//
			Tests.Case("Afficher la dimension des écrans"); {

				Tests.Unit("Dimension [ height = 800.0, width = 800.0 ]", e1.afficherDimension());
				Tests.Unit("Dimension [ height = 1180.0, width = 800.0 ]", e2.afficherDimension());
				Tests.Unit("Dimension [ height = 1366.0, width = 768.0 ]", e3.afficherDimension());
				Tests.Unit("Dimension [ height = 800.0, width = 800.0 ]", e4.afficherDimension());
				Tests.Unit("Dimension [ height = 1180.0, width = 800.0 ]", e5.afficherDimension());
			}

			// Vérifier les dimensions des afficheur
			//
			Tests.Case("Afficher la dimension des afficheurs"); {

				Tests.Unit("Dimension [ height = 800.0, width = 800.0 ]", a1.afficherDimensionA());
				Tests.Unit("Dimension [ height = 1180.0, width = 800.0 ]", a2.afficherDimensionA());
				Tests.Unit("Dimension [ height = 1366.0, width = 768.0 ]", a3.afficherDimensionA());
				Tests.Unit("Dimension [ height = 1180.0, width = 800.0 ]", a4.afficherDimensionA());
				Tests.Unit("Dimension [ height = 800.0, width = 800.0 ]", a5.afficherDimensionA());
			}

			// Vérifier les dimensions des écrans dédié aux afficheur
			//
			Tests.Case("Afficher la dimension des écran auquel ils sont attribués"); {

				Tests.Unit("Dimension [ height = 800.0, width = 800.0 ]", a1.afficherDimensionE());
				Tests.Unit("Dimension [ height = 1180.0, width = 800.0 ]", a2.afficherDimensionE());
				Tests.Unit("Dimension [ height = 1366.0, width = 768.0 ]", a3.afficherDimensionE());
				Tests.Unit("Dimension [ height = 1366.0, width = 768.0 ]", a4.afficherDimensionE());
				Tests.Unit("Dimension [ height = 1366.0, width = 768.0 ]", a5.afficherDimensionE());
			}

			// Vérifier les dimensions des afficheur sont comprises dans les dimensions de leur écran attribué
			//
			Tests.Case("Afficher si les afficheur sont plus grand que leur écran attribué"); {

				Tests.Unit(false, a1.placerZone());
				Tests.Unit(false, a2.placerZone());
				Tests.Unit(false, a3.placerZone());
				Tests.Unit(true, a4.placerZone());
				Tests.Unit(true, a5.placerZone());
			}
		}

		// Vérifier les afficheurs
		//
		Tests.Design("Controle des afficheurs par le nom d'afficheur", 3); {

			// Vérifier les nom des afficheurs
			//
			Tests.Case("Nom afficheur");{

				Tests.Unit("afficheur 1", a1.getNom());
				Tests.Unit("afficheur 2", a2.getNom());
				Tests.Unit("afficheur 3", a3.getNom());
				Tests.Unit("afficheur 4", a4.getNom());
				Tests.Unit("afficheur 5", a5.getNom());

				// Vérifier la liste de noms du stock d'afficheurs
				//
				Tests.Unit("[afficheur 1, afficheur 2, afficheur 3, afficheur 4, afficheur 5]", stock_afficheur.afficherNomAfficheur());

				// Vérifier le nombre de nom d'afficheurs
				//
				Tests.Unit(5, stock_afficheur.nombreNom());

				// Vérifier le nombre d'afficheurs
				//
				Tests.Unit(5, stock_afficheur.nombreAfficheur());
			}

			// Vérifier le contenu du stock d'afficheurs
			//
			Tests.Case("Contenu du stock d'afficheur");{

				String test_listAff = 
						// Afficheur 1
						//
						"{afficheur 1=Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
						+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
						+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ], "

						// Afficheur 2
						//
						+ "afficheur 2=Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
						+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
						+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ], "

						// Afficheur 3
						//
						+ "afficheur 3=Afficheur afficheur 3 [ Dimension [ height = 1366.0, width = 768.0 ], Style Festival de Cannes, "
						+ "Liste de Zones : {zone 5=Zone Text : zone 5 [ Dimension [ height = 366.0, width = 768.0 ], vide ], "
						+ "zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
						+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
						+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]} ], "

						// Afficheur 4
						//
						+ "afficheur 4=Afficheur afficheur 4 [ Dimension [ height = 1180.0, width = 800.0 ], Style IUT Fabron, "
						+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
						+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ], "

						// Afficheur 5
						//
						+ "afficheur 5=Afficheur afficheur 5 [ Dimension [ height = 800.0, width = 800.0 ], Style Noel, "
						+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
						+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ]}";

				Tests.Unit(test_listAff, stock_afficheur.afficherAfficheur());
			}


			// Vérifier le tri d'afficheur par "nom d'auteur"
			//
			Tests.Design("Controle des afficheur par le nom d'auteur", 3); {

				Tests.Case("Nom auteur afficheur");{

					// Vérifier le nom des auteurs d'afficheur
					//
					Tests.Unit("leo", a1.getAuteur());
					Tests.Unit("corentin", a2.getAuteur());
					Tests.Unit("coraline", a3.getAuteur());
					Tests.Unit("leo", a4.getAuteur());
					Tests.Unit("leo", a5.getAuteur());

					// Vérifier les noms de la liste d'auteurs
					//
					Tests.Unit("[leo, corentin, coraline]", stock_afficheur.afficherNomAuteur());

					// Vérifier le nombre d'auteurs de la liste
					//
					Tests.Unit(3, stock_afficheur.nombreAuteur());
				}

				Tests.Case("Afficheur par nom auteur");{

					// Vérifier le(s) afficheur(s) de l'auteur "leo"
					//
					String test_affparLeo = "Auteur : leo [ "
							// Afficheur 1
							//
							+ "Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ]"

							// Afficheur 4
							//
							+ "Afficheur afficheur 4 [ Dimension [ height = 1180.0, width = 800.0 ], Style IUT Fabron, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ]"

							// Afficheur 5
							//
							+ "Afficheur afficheur 5 [ Dimension [ height = 800.0, width = 800.0 ], Style Noel, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]";

					Tests.Unit(test_affparLeo, stock_afficheur.afficherAuteur("leo"));


					// Vérifier le(s) afficheur(s) de l'auteur "corentin"
					//
					String test_affparCorentin = "Auteur : corentin [ "
							+ "Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]";

					Tests.Unit(test_affparCorentin, stock_afficheur.afficherAuteur("corentin"));


					// Vérifier le(s) afficheur(s) de l'auteur "coraline"
					//
					String test_affparCoraline = "Auteur : coraline [ "
							+ "Afficheur afficheur 3 [ Dimension [ height = 1366.0, width = 768.0 ], Style Festival de Cannes, "
							+ "Liste de Zones : {zone 5=Zone Text : zone 5 [ Dimension [ height = 366.0, width = 768.0 ], vide ], "
							+ "zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]} ] ]";

					Tests.Unit(test_affparCoraline, stock_afficheur.afficherAuteur("coraline"));
				}

				Tests.Case("Afficheur par auteur"); {

					// Vérifier les afficheurs par auteurs
					//
					String test_affParAuteur = "Afficheur par auteur { "
							// Auteur "leo"
							//
							+ "Auteur : leo [ "
							// Afficheur 1
							//
							+ "Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ]"

							// Afficheur 4
							//
							+ "Afficheur afficheur 4 [ Dimension [ height = 1180.0, width = 800.0 ], Style IUT Fabron, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ]"

							// Afficheur 5
							//
							+ "Afficheur afficheur 5 [ Dimension [ height = 800.0, width = 800.0 ], Style Noel, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]"


							// Auteur "corentin"
							//
							+ "Auteur : corentin [ "
							// Afficheur 2
							//
							+ "Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]"


							// Auteur "coraline"
							//
							+ "Auteur : coraline [ "
							// Afficheur 3
							//
							+ "Afficheur afficheur 3 [ Dimension [ height = 1366.0, width = 768.0 ], Style Festival de Cannes, "
							+ "Liste de Zones : {zone 5=Zone Text : zone 5 [ Dimension [ height = 366.0, width = 768.0 ], vide ], "
							+ "zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]} ] ] }";

					Tests.Unit(test_affParAuteur, stock_afficheur.afficherAuteur());
				}
			}

			// Vérifier le tri d'afficheur par "style"
			//
			Tests.Design("Controle des afficheur par le style", 3); {

				// Vérifier le nom des styles d'afficheur
				//
				Tests.Case("Nom style afficheur");{

					Tests.Unit("Basic", a1.getStyle().getNom());
					Tests.Unit("Basic", a2.getStyle().getNom());
					Tests.Unit("Festival de Cannes", a3.getStyle().getNom());
					Tests.Unit("IUT Fabron", a4.getStyle().getNom());
					Tests.Unit("Noel", a5.getStyle().getNom());

					// Vérifier les noms de la liste de style des afficheurs
					//
					Tests.Unit("[Basic, Festival de Cannes, IUT Fabron, Noel]", stock_afficheur.afficherNomStyle());

					// Vérifier le nombre de style different des afficheurs
					//
					Tests.Unit(4, stock_afficheur.nombreStyle());
				}

				Tests.Case("Afficheur par style");{

					// Vérifier le(s) afficheur(s) de style "s1"
					//
					String test_Affs1 = "Afficheur style : Noel [ "
							+ "Afficheur afficheur 5 [ Dimension [ height = 800.0, width = 800.0 ], Style Noel, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]";

					Tests.Unit(test_Affs1, stock_afficheur.afficherStyle(s1));


					// Vérifier le(s) afficheur(s) de style "s2"
					//
					String test_Affs2 = "Afficheur style : IUT Fabron [ "
							+ "Afficheur afficheur 4 [ Dimension [ height = 1180.0, width = 800.0 ], Style IUT Fabron, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]";

					Tests.Unit(test_Affs2, stock_afficheur.afficherStyle(s2));


					// Vérifier le(s) afficheur(s) de style "s3"
					//
					String test_Affs3 = "Afficheur style : Festival de Cannes [ "
							+ "Afficheur afficheur 3 [ Dimension [ height = 1366.0, width = 768.0 ], Style Festival de Cannes, "
							+ "Liste de Zones : {zone 5=Zone Text : zone 5 [ Dimension [ height = 366.0, width = 768.0 ], vide ], "
							+ "zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]} ] ]";

					Tests.Unit(test_Affs3, stock_afficheur.afficherStyle(s3));
				}

				// Vérifier les afficheurs par nom de style
				//
				Tests.Case("Afficheur par nom style");{

					// Afficheur de style "Basic"
					//
					String test_affBasic = "Afficheur style : Basic [ "
							+ "Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ]"

						+ "Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
						+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
						+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]";

					Tests.Unit(test_affBasic, stock_afficheur.afficherStyle("Basic"));


					// Afficheur de style "Festival de Cannes"
					//
					String test_AffFestCanne = "Afficheur style : Festival de Cannes [ "
							+ "Afficheur afficheur 3 [ Dimension [ height = 1366.0, width = 768.0 ], Style Festival de Cannes, "
							+ "Liste de Zones : {zone 5=Zone Text : zone 5 [ Dimension [ height = 366.0, width = 768.0 ], vide ], "
							+ "zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]} ] ]";

					Tests.Unit(test_AffFestCanne, stock_afficheur.afficherStyle("Festival de Cannes"));
				}

				// Vérifier les afficheurs par nom de style
				//
				Tests.Case("Afficheur par style");{

					String test_affStyle = "Afficheur style : { "	// Afficheur de style "Basic"
							+ "Afficheur style : Basic [ "
							// Afficheur 1
							//
							+ "Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ]"

							// Afficheur 2
							//
							+ "Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]"


						// Afficheur de style "Festival de Cannes"
						//
						+ "Afficheur style : Festival de Cannes [ "
						+ "Afficheur afficheur 3 [ Dimension [ height = 1366.0, width = 768.0 ], Style Festival de Cannes, "
						+ "Liste de Zones : {zone 5=Zone Text : zone 5 [ Dimension [ height = 366.0, width = 768.0 ], vide ], "
						+ "zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
						+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
						+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]} ] ]"


						// Afficheur de style "IUT Fabron"
						//
						+ "Afficheur style : IUT Fabron [ "
						+ "Afficheur afficheur 4 [ Dimension [ height = 1180.0, width = 800.0 ], Style IUT Fabron, "
						+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
						+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]"


						// Afficheur de style "Noel"
						//
						+ "Afficheur style : Noel [ "
						+ "Afficheur afficheur 5 [ Dimension [ height = 800.0, width = 800.0 ], Style Noel, "
						+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
						+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
						+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
						+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ] }";

					Tests.Unit(test_affStyle, stock_afficheur.afficherStyle());
				}
			}

			// Vérifier les écrans
			//
			Tests.Design("Controle des écrans", 3); {

				// Vérifier le nom des écrans
				//
				Tests.Case("Afficher le nom des écrans");{

					Tests.Unit("ecran1", e1.getNom());
					Tests.Unit("ecran2", e2.getNom());
					Tests.Unit("ecran3", e3.getNom());
					Tests.Unit("ecran4", e4.getNom());
					Tests.Unit("ecran5", e5.getNom());
				}

				// Vérifié que chaque écran possede un afficheur et en afficher le nom
				//
				Tests.Case("Afficher le nom de l'afficheur que possede un écran"); {

					try {
						Tests.Unit("afficheur 1", e1.getAfficheur().getNom());
					}catch(Exception e){
						System.out.println("\n\tL'écran 1 ne possede pas d'afficheur");
					}

					try {
						Tests.Unit("afficheur 2", e2.getAfficheur().getNom());
					}catch(Exception e){
						System.out.println("\n\tL'écran 2 ne possede pas d'afficheur");
					}

					try {
						Tests.Unit("", e3.getAfficheur().getNom());
					}catch(Exception e){
						System.out.println("\n\tL'écran 3 ne possede pas d'afficheur");
					}

					try {
						Tests.Unit("afficheur 4", e4.getAfficheur().getNom());
					}catch(Exception e){
						System.out.println("\n\tL'écran 4 ne possede pas d'afficheur");
					}

					try {
						Tests.Unit("afficheur 5", e5.getAfficheur().getNom());
					}catch(Exception e){
						System.out.println("\n\tL'écran 5 ne possede pas d'afficheur");
					}
				}

				// Vérifié que chaque écran possede un afficheur
				//
				Tests.Case("Vérifié que chaque écran possede un afficheur et en afficher le nom (2)"); {

					Tests.Unit(true, e1.possederAfficheur());
					Tests.Unit(true, e2.possederAfficheur());
					Tests.Unit(false, e3.possederAfficheur());
					Tests.Unit(false, e4.possederAfficheur());
					Tests.Unit(false, e5.possederAfficheur());
				}

				// Vérifié si un écran peut posseder un autre afficheur
				//
				Tests.Case("Vérifié qu'un autre afficheur est peut etre compatible pour un autre écran sans afficheur");{

					Tests.Unit(false, e3.setAfficheurComp(a4));
					Tests.Unit(true, e4.setAfficheurComp(a1));
					Tests.Unit(true, e5.setAfficheurComp(a2));

					Tests.Unit(true, e3.setAfficheurComp(a3));
					Tests.Unit(false, e4.setAfficheurComp(a3));
					Tests.Unit(false, e5.setAfficheurComp(a3));
				}

				// Vérifié le contenu d'un écrans
				//
				Tests.Case("Afficher un écran");{

					// Ecran 1
					//
					String test_e1 = "Ecran [ nom = ecran1, dimension = Dimension [ height = 800.0, width = 800.0 ], "
							// Afficheur 1 associé à l'écran 1 !
							+ "afficheur = Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]";

					Tests.Unit(test_e1, e1.toString());


					// Ecran 2
					//
					String test_e2 = "Ecran [ nom = ecran2, dimension = Dimension [ height = 1180.0, width = 800.0 ], "
							// Afficheur 2 associé à l'écran 2 !
							+ "afficheur = Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]";

					Tests.Unit(test_e2, e2.toString());


					// Ecran 3
					//
					String test_e3 = "Ecran [ nom = ecran3, dimension = Dimension [ height = 1366.0, width = 768.0 ], "
							// Afficheur 3 associé à l'écran 3 !
							+ "afficheur = Afficheur afficheur 3 [ Dimension [ height = 1366.0, width = 768.0 ], Style Festival de Cannes, "
							+ "Liste de Zones : {zone 5=Zone Text : zone 5 [ Dimension [ height = 366.0, width = 768.0 ], vide ], "
							+ "zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]} ] ]";

					Tests.Unit(test_e3, e3.toString());


					// Ecran 4
					//
					String test_e4 = "Ecran [ nom = ecran4, dimension = Dimension [ height = 800.0, width = 800.0 ], "
							// Afficheur 1 associé à l'écran 4 !
							+ "afficheur = Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]";

					Tests.Unit(test_e4, e4.toString());


					// Ecran 5
					//
					String test_e5 = "Ecran [ nom = ecran5, dimension = Dimension [ height = 1180.0, width = 800.0 ], "
							// Afficheur 2 associé à l'écran 5 !
							+ "afficheur = Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]";

					Tests.Unit(test_e5, e5.toString());
				}

				// Vérifié le contenu du gestionnaire
				//
				Tests.Case("Afficher le gestionnaire");{

					// Vérifié le contenu de la liste d'afficheur du gestionnaire
					//
					String test_gA = "Liste d'Afficheurs : {"
							// Afficheur 1
							//
							+ "afficheur 1=Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ], "

							// Afficheur 2
							//
							+ "afficheur 2=Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ], "

							// Afficheur 3
							//
							+ "afficheur 3=Afficheur afficheur 3 [ Dimension [ height = 1366.0, width = 768.0 ], Style Festival de Cannes, "
							+ "Liste de Zones : {zone 5=Zone Text : zone 5 [ Dimension [ height = 366.0, width = 768.0 ], vide ], "
							+ "zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]} ], "

							// Afficheur 4
							//
							+ "afficheur 4=Afficheur afficheur 4 [ Dimension [ height = 1180.0, width = 800.0 ], Style IUT Fabron, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ], "

							// Afficheur 5
							//
							+ "afficheur 5=Afficheur afficheur 5 [ Dimension [ height = 800.0, width = 800.0 ], Style Noel, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ]}";

					Tests.Unit(test_gA, g.afficherAfficheurs());

					// Vérifier le nombre d'afficheur dans la liste
					//
					Tests.Unit(5, g.nombreAfficheur());

					// Vérifié le contenu de la liste d'écran du gestionnaire
					//
					String test_gE = "[Ecran "
							// Ecran 1
							//
							+ "[ nom = ecran1, dimension = Dimension [ height = 800.0, width = 800.0 ], "
							// Afficheur 1 associé à l'écran 1 !
							+ "afficheur = Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ], "

							// Ecran 2
							//
							+ "Ecran [ nom = ecran2, dimension = Dimension [ height = 1180.0, width = 800.0 ], "
							// Afficheur 2 associé à l'écran 2 !
							+ "afficheur = Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ], "

							// Ecran 3
							//
							+ "Ecran [ nom = ecran3, dimension = Dimension [ height = 1366.0, width = 768.0 ], "
							// Afficheur 3 associé à l'écran 3 !
							+ "afficheur = Afficheur afficheur 3 [ Dimension [ height = 1366.0, width = 768.0 ], Style Festival de Cannes, "
							+ "Liste de Zones : {zone 5=Zone Text : zone 5 [ Dimension [ height = 366.0, width = 768.0 ], vide ], "
							+ "zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ]} ] ], "

							// Ecran 4
							//
							+ "Ecran [ nom = ecran4, dimension = Dimension [ height = 800.0, width = 800.0 ], "
							// Afficheur 1 associé à l'écran 4 !
							+ "afficheur = Afficheur afficheur 1 [ Dimension [ height = 800.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 4=Zone Text : zone 4 [ Dimension [ height = 100.0, width = 500.0 ], vide ], "
							+ "Alerte rouge=Zone TextAlerte : Alerte rouge [ Dimension [ height = 500.0, width = 500.0 ], URGENT ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ], "

							// Ecran 5
							//
							+ "Ecran [ nom = ecran5, dimension = Dimension [ height = 1180.0, width = 800.0 ], "
							// Afficheur 2 associé à l'écran 5 !
							+ "afficheur = Afficheur afficheur 2 [ Dimension [ height = 1180.0, width = 800.0 ], Style Basic, "
							+ "Liste de Zones : {zone 6=Zone Bloc : zone 6 [ Dimension [ height = 180.0, width = 768.0 ], vide ], "
							+ "paysage=Zone Bloc : paysage [ Dimension [ height = 300.0, width = 600.0 ], chemin d'image ], "
							+ "zone 1=Zone Text : zone 1 [ Dimension [ height = 500.0, width = 500.0 ], texte d'information ], "
							+ "diaporama=Zone Bloc : diaporama [ Dimension [ height = 200.0, width = 800.0 ], chemin dossierImages ]} ] ]]";

					Tests.Unit(test_gE, g.afficherEcrans());

					// Vérifier le nombre d'écrans dans la liste
					//
					Tests.Unit(5, g.nombreEcran());
				}
			}
		}

		Tests.End();
	}
}