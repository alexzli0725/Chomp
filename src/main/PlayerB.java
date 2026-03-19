package main;

public class PlayerB extends Player {

	public PlayerB(Panel panel) {
		super(panel);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean switchSide(boolean you, bPanel bpane) {
		you = true;
		// TODO Auto-generated method stub
		bpane.setLabel("Player A's turn");
		panel.setPlayer(new PlayerA(panel));
		return you;
	}

	@Override
	void win(boolean you, bPanel bpane) {
		// TODO Auto-generated method stub
		bpane.setLabel("Player A wins");
	}

}
