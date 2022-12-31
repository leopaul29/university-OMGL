package Vue;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JComboBox;

public class IHM_AssocieRenderer extends JPanel {

	/**
	 * Create the panel.
	 */
	public IHM_AssocieRenderer() {
		setSize(600,400);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 425, 378);
		add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(445, 11, 145, 27);
		add(comboBox);
	}
}
