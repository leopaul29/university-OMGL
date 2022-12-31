package Tests;

import Modele.Ecran;
import Modele.Gestionnaire;
import Modele.Site;

public class TUN {


	public static void main(String[] args) {
		
		Tests.Begin("AS_ConOrganiseEcrans", "1.0.0");

        Tests.Design("Controle des constructeurs et méthodes", 3); {

           Tests.Case("Test 1"); {
        	   
        	   	Gestionnaire g = new Gestionnaire();
       			Site s = new Site("Site Fabron", "route Napoleon");
       			Ecran e = new Ecran(s, "hall d'entrée", "e1");
       			g.addList(s);

       			String test1 ="Gestionnaire [site=[Site [nom=Site Fabron, localisation=route Napoleon, ecrans=[Ecran [nom=e1, position=hall d'entrée]]]]]";

       			Tests.Unit(test1, g.toString());
              
              	Site s1 = new Site("Site Sophia", "quelquepart");
      			Ecran e4 = new Ecran(s1, "Entrée batiment B", "e4");
      			g.addList(s1);
      			
      			String test2 = "Gestionnaire [site=[Site [nom=Site Fabron, localisation=route Napoleon, ecrans=[Ecran [nom=e1, position=hall d'entrée]]], Site [nom=Site Sophia, localisation=quelquepart, ecrans=[Ecran [nom=e4, position=Entrée batiment B]]]]]";
      			
      			Tests.Unit(test2, g.toString());
      			
      			Ecran e2 = new Ecran(s, "couloir 7**", "e2");
      			
      			String test3 = "Gestionnaire [site=[Site [nom=Site Fabron, localisation=route Napoleon, ecrans=[Ecran [nom=e1, position=hall d'entrée], Ecran [nom=e2, position=couloir 7**]]], Site [nom=Site Sophia, localisation=quelquepart, ecrans=[Ecran [nom=e4, position=Entrée batiment B]]]]]";
      			
      			Tests.Unit(test3, g.toString());
           }
        }

     Tests.End();
		

	}

}
