package Modele;

public class ZoneBloc extends Zone{

	// ---											Constructeur normal
	//
	public ZoneBloc(String nom, Dimension dimension, Object source_information, StockZone stock_Zone) {
		
		// Creer une zone
		//
		super(nom, dimension, source_information, stock_Zone);
		// TODO Auto-generated constructor stub
		
		// Une zone est soit une zone de défilement de texte, soit une zone bloc
		//
		definirType(false);
	}

}
