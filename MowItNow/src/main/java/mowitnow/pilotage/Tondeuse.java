package mowitnow.pilotage;

import mowitnow.pilotage.orientation.ContexteOrientation;

/**
 * 
 * Representation d'une tondeuse
 *
 */
public class Tondeuse {

	private Pelouse pelouse;

	private PositionOrientation position;

	private ContexteOrientation contexte;

	/**
	 * Une tondeuse est définie à partir de sa position initiale
	 * @param pelouse pour controler les limites de déplacement de la tondeuse
	 * @param positionInitiale
	 */
	public Tondeuse(Pelouse pelouse, PositionOrientation positionInitiale) {
		super();
		this.pelouse = pelouse;
		this.position = positionInitiale;
		contexte = new ContexteOrientation(positionInitiale);
	}

	/**
	 * Faire avancer la tondeuse
	 */
	public void avancer() {
		contexte.avancer(pelouse, position);
	}

	/**
	 * Faire pivoter à droite la tondeuse
	 */
	public void pivoterADroite() {
		contexte.pivoterADroite(position);
	}

	/**
	 * Faire pivoter à gauche la tondeuse
	 */
	public void pivoterAGauche() {
		contexte.pivoterAGauche(position);
	}

	/**
	 * Récupére la position courante la tondeuse
	 * @return
	 */
	public PositionOrientation getPosition() {
		return position;
	}

}
