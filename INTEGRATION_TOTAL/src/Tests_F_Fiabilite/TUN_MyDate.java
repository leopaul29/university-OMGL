package Tests_F_Fiabilite;

import Modele.MyDate;

public class TUN_MyDate {

	public static void main(String[] args) {

		// Créer Date
		//
		MyDate date = new MyDate();
		
		// Tests de l'US "F_Fiabilité"
		//
		Tests.Begin("F_Fiabilité", "1.0.0");

		// Tests de la class MyDate
		//
		Tests.Design("Class MyDate", 3); {

			// Verifier les champs de la date
			//
			Tests.Case("Afficher les differentes partie de la date"); {

				System.out.println("\n\tNom de jour : " + date.getJours());
				System.out.println("\n\tNumero de jour : " + date.getNumeroJour());
				System.out.println("\n\tNom de mois : " + date.getMois());
				System.out.println("\n\tL'année : " + date.getAnnees());
				System.out.println("\n\tLes heures : " + date.getHeures());
				System.out.println("\n\tLes minutes : " + date.getMinutes());
				System.out.println("\n\tLes secondes : " + date.getSecondes());
			}
			
			// Verifier la date
			//
			Tests.Case("Afficher la date complete"); {
				
				System.out.println("\n\t" + date.toString());
			}
		}
		
		Tests.End();
	}
}
