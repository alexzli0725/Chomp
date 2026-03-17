package main;

public abstract class Player {
	protected Panel panel;

	public Player(Panel panel) {
		this.panel = panel;
	}

	abstract boolean switchSide(boolean you);

}
