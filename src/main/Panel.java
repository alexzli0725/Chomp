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

	boolean revealed;
	JLabel labeling;

	public Panel() {
		setLayout(new BorderLayout());
		board = new Tile[row][col];
		JPanel cPanel = new JPanel();
		GridLayout layout = new GridLayout(row, col);
		cPanel.setLayout(layout);
		add(cPanel);

		you = true;
		player = new PlayerA(this);

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				Tile tile = new Tile(r, c);
				board[r][c] = tile;
				tile.setFocusable(false);
				tile.addMouseListener(this);
				cPanel.add(tile);
			}
		}
		setMines();

		JPanel bPanel = new JPanel(); // defaults to FlowLayout
		labeling = new JLabel("Player A's turn");
		bPanel.add(labeling);
		add(bPanel, BorderLayout.SOUTH); // doesn't affect grid size

	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setMines() {
		mineList = new ArrayList<Tile>();
		mineList.add(board[3][0]);
	}

	public void revealMines() {
		revealed = true;
		if (you) {
			labeling.setText("Player B wins");
		} else {
			labeling.setText("Player A wins");
		}
		for (int i = 0; i < mineList.size(); i++) {
			Tile tile = mineList.get(i);
			tile.setBackground(Color.PINK);
			tile.setEnabled(false);
			tile.setFont(new Font("Arial Unicode MS", Font.PLAIN, 45));
		}
	}

//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//
//		Button btd = (Button) e.getSource();
//
//		for (int r = 0; r < row; r++) {
//			for (int c = 0; c < col; c++) {
//				if (board[r][c] == btd) {
//					
////					if ()
//					
//					you = player.switchSide(you);
//					System.out.println(you);
//					board[r][c].setBackground(Color.GREEN);
//					board[r][c].setFocusable(false);
//					board[r][c].setEnabled(false);
//					fillRest(r, c, col);
//					if (mineList.contains(board[r][c])) {
//						revealMines();
//					}
//				}
//			}
//		}
//	}

	private void fillRest(int r, int c, int col) {
		// TODO Auto-generated method stub
//		board[r - 1][c].setBackground(Color.GREEN);;
		for (int rAlt = r; rAlt >= 0; rAlt--) {
			for (int cAlt = c; cAlt < col; cAlt++) {
				board[rAlt][cAlt].setBackground(Color.GREEN);
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
				you = player.switchSide(you);
				btd.setBackground(Color.GREEN);
				btd.setFocusable(false);
				btd.setEnabled(false);
				if (you) {
					labeling.setText("Player A's turn");
				} else {
					labeling.setText("Player B's turn");
				}
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
