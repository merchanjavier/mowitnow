package mowitnow.pilotage;

/**
 * 
 * Pelouse d�finie � partir de ses dimensions
 *
 */
public class Pelouse {
	public Pelouse(Position coinSuperieurDroit) {
		super();
		this.coinSuperieurDroit = coinSuperieurDroit;
	}

	private Position coinSuperieurDroit;

	public Position getCoinSuperieurDroit() {
		return coinSuperieurDroit;
	}
}
