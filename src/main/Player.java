package main;

public abstract class Player {
	protected Panel panel;

	public Player(Panel panel) {
		this.panel = panel;
	}

	abstract boolean switchSide(boolean you, bPanel bpane);
	
	abstract void win(boolean you, bPanel bpane);

}
