package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Frame extends JFrame{
//	JFrame frame;
	JPanel panel;
	JLabel label;

	private JButton button;
	
	Panel p;
	
	private cPanel cpane;

	public Frame() {
		this.setTitle("Chomp");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("Minesweeper");
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 25));
		panel = new JPanel();
		panel.add(label);

		this.add(panel, BorderLayout.NORTH);
		
		button = new JButton("Reset");

		p = new Panel(cpane);
		
		this.add(button, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(3);
		this.setSize(700, 400);
		this.add(p, BorderLayout.CENTER);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		button.addActionListener((ActionEvent e) -> {
			this.remove(p);
			p = new Panel(cpane);
			this.add(p);
			SwingUtilities.updateComponentTreeUI(this);
		});

		
	}

}
