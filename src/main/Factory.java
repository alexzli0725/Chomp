package main;

public class Factory {
	int r;
	int c;
	
	public Tile create(int r, int c) {
		this.r = r;
		this.c = c;
		if (r == 3 && c == 0) {
			return new Ptile(r, c);
		}
		return new NTile(r, c);
	}
}
