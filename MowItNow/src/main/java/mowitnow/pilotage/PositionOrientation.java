package mowitnow.pilotage;

import mowitnow.enums.Orientation;

/**
 * 
 * La position de la tondeuse est définie à partir de sa position X et Y et aussi de son orientation
 *
 */
public class PositionOrientation {
	private Position position;
	private Orientation orientation;

	public PositionOrientation(Position position, Orientation orientation) {
		super();
		this.position = position;
		this.orientation = orientation;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof PositionOrientation))
			return false;
		PositionOrientation otherPositionTondeuse = (PositionOrientation) other;

		return position.equals(otherPositionTondeuse.position) && orientation == otherPositionTondeuse.getOrientation();
	}

}
