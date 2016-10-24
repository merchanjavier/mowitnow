package mowitnow.pilotage.orientation;

import mowitnow.enums.Orientation;
import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.PositionOrientation;

public class OrienteeOuest implements EtatOrientation {

	@Override
	public void avancer(Pelouse pelouse, PositionOrientation positionActuelle) {
		int posNouvelleX = positionActuelle.getPosition().getPosX() - 1;

		if (neDepassePasParLOuest(posNouvelleX))
			positionActuelle.getPosition().setPosX(posNouvelleX);
	}

	private boolean neDepassePasParLOuest(int posNouvelleX) {
		return posNouvelleX >= 0;
	}

	@Override
	public EtatOrientation pivoterADroite(PositionOrientation positionActuelle) {
		positionActuelle.setOrientation(Orientation.N);

		return new OrienteeNord();
	}

	@Override
	public EtatOrientation pivoterAGauche(PositionOrientation positionActuelle) {
		positionActuelle.setOrientation(Orientation.S);

		return new OrienteeSud();
	}

	@Override
	public Orientation obtenirOrientation() {
		return Orientation.W;
	}
}
