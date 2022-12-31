package VueWB;

import java.util.Observable;
import java.util.Observer;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vue extends JFrame implements Observer{

	public Vue() {
		
		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	@Override
	public void update(Observable Controleur, Object modifs) {
		// TODO Auto-generated method stub
		
		String titre = (String) ((HashMap<?, ?>) modifs).get("titre");
		this.setTitle(titre);
		
		JPanel pan = (JPanel) ((HashMap<?, ?>) modifs).get("vue");
		this.setContentPane(pan);
		
		this.setVisible(true);
	}
}
