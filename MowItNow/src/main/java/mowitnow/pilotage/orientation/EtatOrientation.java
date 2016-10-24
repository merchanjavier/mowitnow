package mowitnow.pilotage.orientation;

import mowitnow.enums.Orientation;
import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.PositionOrientation;

/**
 * 
 * Etat de la machine � �tats des orientations d'une tondeuse
 *
 */
public interface EtatOrientation {
	/**
	 * R�cup�rer la lettre d'orientation associ�e � l'�tat
	 */
	public Orientation obtenirOrientation();

	/**
	 * Faire avancer la tondeuse si possible
	 * @param pelouse
	 * @param positionActuelle
	 */
	public void avancer(Pelouse pelouse, PositionOrientation positionActuelle);

	/**
	 * Faire pivoter � droite la tondeuse
	 * @param positionActuelle
	 * @return
	 */
	public EtatOrientation pivoterADroite(PositionOrientation positionActuelle);

	/**
	 * Faire pivoter � gauche la tondeuse
	 * @param positionActuelle
	 * @return
	 */
	public EtatOrientation pivoterAGauche(PositionOrientation positionActuelle);
}
