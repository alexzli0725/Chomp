package main;

public class PlayerB extends Player {

	public PlayerB(Panel panel) {
		super(panel);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean switchSide(boolean you) {
		you = true;
		// TODO Auto-generated method stub
		panel.setPlayer(new PlayerA(panel));
		return you;
	}

}
