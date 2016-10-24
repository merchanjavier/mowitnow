package mowitnow.pilotage.orientation;

import mowitnow.enums.Orientation;
import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.PositionOrientation;

public class OrienteeNord implements EtatOrientation {

	@Override
	public void avancer(Pelouse pelouse, PositionOrientation positionActuelle) {
		int posNouvelleY = positionActuelle.getPosition().getPosY() + 1;

		if (neDepassePasParLeNord(pelouse, posNouvelleY))
			positionActuelle.getPosition().setPosY(posNouvelleY);
	}

	private boolean neDepassePasParLeNord(Pelouse pelouse, int posNouvelleY) {
		return posNouvelleY <= pelouse.getCoinSuperieurDroit().getPosY();
	}

	@Override
	public EtatOrientation pivoterADroite(PositionOrientation positionActuelle) {
		positionActuelle.setOrientation(Orientation.E);

		return new OrienteeEst();
	}

	@Override
	public EtatOrientation pivoterAGauche(PositionOrientation positionActuelle) {
		positionActuelle.setOrientation(Orientation.W);

		return new OrienteeOuest();
	}

	@Override
	public Orientation obtenirOrientation() {
		return Orientation.N;
	}
}
