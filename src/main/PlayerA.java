package main;

public class PlayerA extends Player{

	public PlayerA(Panel panel) {
		super(panel);
		// TODO Auto-generated constructor stub
	}

	@Override
	boolean switchSide(boolean you) {
		you = false;
		// TODO Auto-generated method stub
		panel.setPlayer(new PlayerB(panel));
		return you;
	}

}
