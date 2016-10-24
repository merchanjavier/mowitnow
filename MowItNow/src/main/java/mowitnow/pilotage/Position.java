package mowitnow.pilotage;

public class Position {
	private int posX;
	private int posY;

	public Position(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Position))
			return false;

		Position otherPosition = (Position) other;

		return posX == otherPosition.posX && posY == otherPosition.posY;
	}
}
