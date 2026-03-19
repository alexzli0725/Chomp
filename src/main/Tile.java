package main;

import java.awt.Button;

import javax.swing.JButton;

public abstract class Tile extends Button{
	int r;
	int c;
	
	public Tile(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public abstract void dothis();
}
