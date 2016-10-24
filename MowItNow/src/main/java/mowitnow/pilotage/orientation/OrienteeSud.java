package mowitnow.pilotage.orientation;

import mowitnow.enums.Orientation;
import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.PositionOrientation;

public class OrienteeSud implements EtatOrientation {

	@Override
	public void avancer(Pelouse pelouse, PositionOrientation positionActuelle) {
		int posNouvelleY = positionActuelle.getPosition().getPosY() - 1;

		if (neDepassePasParLeSud(posNouvelleY))
			positionActuelle.getPosition().setPosY(posNouvelleY);
	}

	private boolean neDepassePasParLeSud(int posNouvelleY) {
		return posNouvelleY >= 0;
	}

	@Override
	public EtatOrientation pivoterADroite(PositionOrientation positionActuelle) {
		positionActuelle.setOrientation(Orientation.W);

		return new OrienteeOuest();
	}

	@Override
	public EtatOrientation pivoterAGauche(PositionOrientation positionActuelle) {
		positionActuelle.setOrientation(Orientation.E);

		return new OrienteeEst();
	}

	@Override
	public Orientation obtenirOrientation() {
		return Orientation.S;
	}
}
