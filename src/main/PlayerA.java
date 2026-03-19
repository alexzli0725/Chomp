package main;

public class PlayerA extends Player {

	public PlayerA(Panel panel) {
		super(panel);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean switchSide(boolean you, bPanel bpane) {
		you = false;
		// TODO Auto-generated method stub
		bpane.setLabel("Player B's turn");
		panel.setPlayer(new PlayerB(panel));
		return you;
	}

	@Override
	void win(boolean you, bPanel bpane) {
		// TODO Auto-generated method stub
		bpane.setLabel("Player B wins");
	}

}
