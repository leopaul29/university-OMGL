package VueWB;

import javax.swing.JPanel;
import java.awt.TextArea;

public class VueAfficher extends JPanel {

	private TextArea txt_affiche;

	/**
	 * Create the panel.
	 */
	public VueAfficher() {
		
		txt_affiche = new TextArea();
		add(txt_affiche);

	}

	public TextArea getTxt_affiche() {
		return txt_affiche;
	}

	public void setTxt_affiche(TextArea txt_affiche) {
		this.txt_affiche = txt_affiche;
	}

}
