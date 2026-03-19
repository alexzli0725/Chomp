package main;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class cPanel extends JPanel{
	int row = 4;
	int col = 7;
	public cPanel() {
		GridLayout layout = new GridLayout(row, col);
		setLayout(layout);
	}
}
