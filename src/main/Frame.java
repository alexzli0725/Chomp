package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {
	JFrame frame;
	JPanel panel;
	JLabel label;
	JPanel bPanel;
//	JLabel labeling;

	public Frame(Panel p) {
		frame = new JFrame("Chomp");

		label = new JLabel("Minesweeper");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 25));
		panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		panel.add(label);

		frame.add(panel, BorderLayout.NORTH);

//		System.out.println(p.you);
		
		
//		labeling = new JLabel("false" + p.you);
//		labeling.setHorizontalAlignment(JLabel.CENTER);
//		labeling.setFont(new Font("Arial", Font.BOLD, 25));
//		bPanel = new JPanel();
//		
//		bPanel.setLayout(new BorderLayout());
//		bPanel.add(labeling);
//		frame.add(bPanel, BorderLayout.SOUTH);
		
		frame.setDefaultCloseOperation(3);
		frame.setSize(700, 400);
		frame.add(p, BorderLayout.CENTER);
		
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
