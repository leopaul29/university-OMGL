package Modele;

public class ZoneAlerte extends Zone {

	// ---											Constructeur normal
	//
	public ZoneAlerte(String nom, Dimension dimension, boolean type_text, Object source_information, StockZone stock_Zone) {

		// Creer une zone
		//
		super(nom, dimension, source_information, stock_Zone);
		// TODO Auto-generated constructor stub

		// D�finir la zone en zone d'alerte
		//
		this.setAlerte(true);
		
		// Une zone est soit une zone de d�filement de texte, soit une zone bloc
		//
		definirType(type_text);
	}

}