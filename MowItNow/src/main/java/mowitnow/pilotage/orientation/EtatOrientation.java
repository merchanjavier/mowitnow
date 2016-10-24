package mowitnow.pilotage.orientation;

import mowitnow.enums.Orientation;
import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.PositionOrientation;

/**
 * 
 * Etat de la machine à états des orientations d'une tondeuse
 *
 */
public interface EtatOrientation {
	/**
	 * Récupérer la lettre d'orientation associée à l'état
	 */
	public Orientation obtenirOrientation();

	/**
	 * Faire avancer la tondeuse si possible
	 * @param pelouse
	 * @param positionActuelle
	 */
	public void avancer(Pelouse pelouse, PositionOrientation positionActuelle);

	/**
	 * Faire pivoter à droite la tondeuse
	 * @param positionActuelle
	 * @return
	 */
	public EtatOrientation pivoterADroite(PositionOrientation positionActuelle);

	/**
	 * Faire pivoter à gauche la tondeuse
	 * @param positionActuelle
	 * @return
	 */
	public EtatOrientation pivoterAGauche(PositionOrientation positionActuelle);
}
