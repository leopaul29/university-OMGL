package Tests;

import Modele.Afficheur;
import Modele.Dimension;
import Modele.Ecran;
import Modele.GestionnaireEcrans;

public class TUN {


	public static void main(String[] args) {

		GestionnaireEcrans g = new GestionnaireEcrans();

		Ecran e1 = new Ecran("ecran1", new Dimension(1280, 800));
		g.addEcran(e1);

		Afficheur a1 = new Afficheur("afficheur1", new Dimension(1280, 800));
		g.addAfficheur(a1);

		Afficheur a2 = new Afficheur("afficheur2", new Dimension(1366,768), "Corentin", "xfce");
		g.addAfficheur(a2);

		Ecran e2 = new Ecran("ecran2", new Dimension(1366,768), a2);
		g.addEcran(e2);

		Ecran e3 = new Ecran("ecran3", new Dimension(1600, 1200));
		g.addEcran(e3);

		Afficheur a3 = new Afficheur("afficher3", new Dimension(1600, 1200));
		g.addAfficheur(a3);

		Tests.Begin("AssocieAfficheurEcran", "1.0.0");

		Tests.Design("Controle Constructeur", 3); {

			Tests.Case("Test Constructeurs"); {
				Tests.Unit("Ecran [nom=ecran1, d=Dimension [height=800.0, width=1280.0, rapport=1.6], a=null]", e1.toString());
				Tests.Unit("Afficheur [nom=afficheur1, d=Dimension [height=800.0, width=1280.0, rapport=1.6], auteur=null, style=null]", a1.toString());
				Tests.Unit("Afficheur [nom=afficheur2, d=Dimension [height=768.0, width=1366.0, rapport=1.7786459], auteur=Corentin, style=xfce]", a2.toString());
				Tests.Unit("GestionnaireEcrans [listEcran=[Ecran [nom=ecran1, d=Dimension [height=800.0, width=1280.0, rapport=1.6], a=null], Ecran [nom=ecran2, d=Dimension [height=768.0, width=1366.0, rapport=1.7786459], a=Afficheur [nom=afficheur2, d=Dimension [height=768.0, width=1366.0, rapport=1.7786459], auteur=Corentin, style=xfce]], Ecran [nom=ecran3, d=Dimension [height=1200.0, width=1600.0, rapport=1.3333334], a=null]], listAfficheur=[Afficheur [nom=afficheur1, d=Dimension [height=800.0, width=1280.0, rapport=1.6], auteur=null, style=null], Afficheur [nom=afficheur2, d=Dimension [height=768.0, width=1366.0, rapport=1.7786459], auteur=Corentin, style=xfce], Afficheur [nom=afficher3, d=Dimension [height=1200.0, width=1600.0, rapport=1.3333334], auteur=null, style=null]]]", g.toString());

			}

			Tests.Case("Test Méthodes");{

				Tests.Unit(false, e1.setAfficheurComp(a3));
				Tests.Unit(false, e3.setAfficheurComp(a2));
				Tests.Unit(true, e3.setAfficheurComp(a3));

			}
		}

		Tests.End();


	}

}