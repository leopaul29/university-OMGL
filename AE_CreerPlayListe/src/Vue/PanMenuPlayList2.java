package Vue;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


import javax.swing.JLayeredPane;
import javax.swing.JToggleButton;

public class PanMenuPlayList2 extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public PanMenuPlayList2() {
		setSize(800,600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 780, 94);
		add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(193, 116, 309, 134);
		add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(537, 147, 92, 105);
		add(layeredPane);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(193, 271, 144, 38);
		add(tglbtnNewToggleButton);
	}
}
