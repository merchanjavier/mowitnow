package mowitnow.pilotage.orientation;

import mowitnow.enums.Orientation;
import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.PositionOrientation;

public class OrienteeEst implements EtatOrientation {

	@Override
	public void avancer(Pelouse pelouse, PositionOrientation positionActuelle) {
		int posNouvelleX = positionActuelle.getPosition().getPosX() + 1;

		if (neDepassePasParLEst(pelouse, posNouvelleX))
			positionActuelle.getPosition().setPosX(posNouvelleX);
	}

	private boolean neDepassePasParLEst(Pelouse pelouse, int posNouvelleX) {
		return posNouvelleX <= pelouse.getCoinSuperieurDroit().getPosX();
	}

	@Override
	public EtatOrientation pivoterADroite(PositionOrientation positionActuelle) {
		positionActuelle.setOrientation(Orientation.S);

		return new OrienteeSud();
	}

	@Override
	public EtatOrientation pivoterAGauche(PositionOrientation positionActuelle) {
		positionActuelle.setOrientation(Orientation.N);

		return new OrienteeNord();
	}

	@Override
	public Orientation obtenirOrientation() {
		return Orientation.E;
	}
}
