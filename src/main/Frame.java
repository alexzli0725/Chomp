package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Frame extends JFrame implements ActionListener{
//	JFrame frame;
	JPanel panel;
	JLabel label;
	
	private JPanel bottomPanel;

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

		p = new Panel(cpane);
		this.setDefaultCloseOperation(3);
		this.setSize(700, 400);
		this.add(p, BorderLayout.CENTER);
		
		button = new JButton("Reset");
		bottomPanel = new JPanel(); // FlowLayout by default
		bottomPanel.add(button);
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		button.addActionListener(this);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.remove(p);
		p = new Panel(cpane);
		this.add(p);
		this.revalidate();
		this.repaint();
	}

}
