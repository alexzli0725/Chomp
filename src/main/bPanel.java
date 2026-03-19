package main;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class bPanel extends JPanel {
	private JLabel labeling;

	public bPanel() {
		labeling = new JLabel("Player A's turn");
		add(labeling);

	}

	public void setLabel(String word) {
		labeling.setText(word);
	}

	public JLabel getLabel() {
		return labeling;
	}
}
