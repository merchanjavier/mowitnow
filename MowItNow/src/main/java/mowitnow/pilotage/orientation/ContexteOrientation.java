package mowitnow.pilotage.orientation;

import java.util.Arrays;
import java.util.List;

import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.PositionOrientation;

/**
 * 
 * Contexte pour la machine à états des orientations d'une tondeuse
 *
 */
public class ContexteOrientation {
	private EtatOrientation etatCourant;

	/**
	 * Le contexte est composé par l'état courant qui est trouvé à partir de la position initiale
	 * @param positionInitiale
	 */
	public ContexteOrientation(PositionOrientation positionInitiale) {
		super();
		determinerEtatInitial(positionInitiale);
	}

	private void determinerEtatInitial(PositionOrientation positionInitiale) {
		List<EtatOrientation> etatsPossibles = Arrays.asList(new OrienteeNord(), new OrienteeEst(), new OrienteeOuest(),
				new OrienteeSud());

		for (EtatOrientation etat : etatsPossibles) {
			if (lEtatCorrespondALOrientation(etat, positionInitiale)) {
				etatCourant = etat;
			}
		}
	}

	private boolean lEtatCorrespondALOrientation(EtatOrientation etat, PositionOrientation positionInitiale) {
		return positionInitiale.getOrientation() == etat.obtenirOrientation();
	}

	/**
	 * Faire avancer la tondeuse si elle ne dépasse pas les limites de la pelouse
	 * @param pelouse
	 * @param positionActuelle
	 */
	public void avancer(Pelouse pelouse, PositionOrientation positionActuelle) {
		etatCourant.avancer(pelouse, positionActuelle);
	}

	/**
	 * Faire pivoter la tondeuse à droite et ensuite mettre à jour l'état d'orientation
	 * @param position
	 */
	public void pivoterADroite(PositionOrientation position) {
		etatCourant = etatCourant.pivoterADroite(position);
	}

	/**
	 * Faire pivoter la tondeuse à gauche et ensuite mettre à jour l'état d'orientation
	 * @param position
	 */
	public void pivoterAGauche(PositionOrientation position) {
		etatCourant = etatCourant.pivoterAGauche(position);
	}

}
