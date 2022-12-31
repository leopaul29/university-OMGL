package Modele;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class MockErreurImpl.
 *
 * @author LeoPaul
 */
public class MockErreurImpl implements MockErreur{

	private ArrayList<String> 	liste_erreurs;
	private boolean 			erreur;
	private Ecran				ecran;
	
	/**
	 * Instantiates a new mock erreur impl.
	 *
	 * @param ecran the ecran
	 */
	public MockErreurImpl(Ecran ecran){
		
		this.ecran = ecran;
		this.liste_erreurs = new ArrayList<String>();
	}
	
	/* (non-Javadoc)
	 * @see Modele.MockErreur#getList_Erreur()
	 */
	@Override
	public ArrayList<String> getList_Erreur() {
		// TODO Auto-generated method stub
		return this.liste_erreurs;
	}

	/* (non-Javadoc)
	 * @see Modele.MockErreur#addErreur(java.lang.String)
	 */
	@Override
	public void addErreur(String erreur) {
		// TODO Auto-generated method stub
		this.liste_erreurs.add(erreur);
		HasErreur(true);
	}

	/* (non-Javadoc)
	 * @see Modele.MockErreur#removeErreur(int)
	 */
	@Override
	public void removeErreur(int i) {
		// TODO Auto-generated method stub
		this.liste_erreurs.remove(i);
		if(this.liste_erreurs == null) {
			HasErreur(false);
		}
	}

	/* (non-Javadoc)
	 * @see Modele.MockErreur#removeAll()
	 */
	@Override
	public void removeAll() {
		// TODO Auto-generated method stub
		this.liste_erreurs.clear();
		HasErreur(false);
	}

	/* (non-Javadoc)
	 * @see Modele.MockErreur#setHasErreur(boolean)
	 */
	@Override
	public boolean HasErreur(boolean erreur) {
		// TODO Auto-generated method stub
		getEcran().setErreur(erreur);
		return this.erreur = erreur;
	}

	/* (non-Javadoc)
	 * @see Modele.MockErreur#hasErreur()
	 */
	@Override
	public boolean hasErreur() {
		// TODO Auto-generated method stub
		return this.erreur;
	}

	/**
	 * Gets the ecran.
	 *
	 * @return the ecran
	 */
	public Ecran getEcran() {return ecran;}
}
