package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel implements MouseListener {
//	private Button[][] grid;
	int row = 4;
	int col = 7;

//	maybe i'll cite one... from another source
//	like this: https://www.youtube.com/watch?v=5VrMVSDjeso

	private Tile[][] board;
	private List<Tile> mineList;

	boolean you;
	private Player player;

	private bPanel bpane;
	private Factory factory;
	private Tile tile;

	public Panel(cPanel cpane) {
		setLayout(new BorderLayout());
		board = new Tile[row][col];

		cpane = new cPanel();
		add(cpane);

		you = true;
		player = new PlayerA(this);
		
		factory = new Factory();

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {

				tile = factory.create(r, c);
				board[r][c] = (Tile) tile;
				tile.setFocusable(false);
				tile.addMouseListener(this);
				cpane.add(tile);
			}
		}
		setMines();

		bpane = new bPanel();
		add(bpane, BorderLayout.SOUTH); // doesn't affect grid size

	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setMines() {
		mineList = new ArrayList<Tile>();
		mineList.add(board[3][0]);
	}

	public void revealMines() {
		player.win(you, bpane);
		for (int i = 0; i < mineList.size(); i++) {
			Tile tile = mineList.get(i);
			tile.dothis();
			tile.setEnabled(false);
		}
	}

	private void fillRest(int r, int c, int col) {
		// TODO Auto-generated method stub
		for (int rAlt = r; rAlt >= 0; rAlt--) {
			for (int cAlt = c; cAlt < col; cAlt++) {
				board[rAlt][cAlt].dothis();
				board[rAlt][cAlt].setEnabled(false);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Tile btd = (Tile) e.getSource();
		if (e.getButton() == MouseEvent.BUTTON1) {
			fillRest(btd.r, btd.c, col);
			if (mineList.contains(board[btd.r][btd.c])) {
				revealMines();
				return;
			} else {
				you = player.switchSide(you, bpane);
				btd.setFocusable(false);
				btd.setEnabled(false);
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
