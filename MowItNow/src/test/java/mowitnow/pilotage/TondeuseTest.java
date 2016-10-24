package mowitnow.pilotage;

import static org.junit.Assert.assertEquals;
import mowitnow.enums.Orientation;
import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.Position;
import mowitnow.pilotage.PositionOrientation;
import mowitnow.pilotage.Tondeuse;

import org.junit.Test;

public class TondeuseTest {

	@Test
	public void devrait_avancer_a_0_1_N_depuis_0_0_N() {
		// GIVEN
		Tondeuse tondeuse = creerTondeuse(5, 5, 0, 0, Orientation.N);
		PositionOrientation expected = new PositionOrientation(new Position(0, 1), Orientation.N);

		// WHEN
		tondeuse.avancer();

		// THEN
		assertEquals(expected, tondeuse.getPosition());
	}

	@Test
	public void devrait_avancer_a_1_0_E_depuis_0_0_E() {
		// GIVEN
		Tondeuse tondeuse = creerTondeuse(5, 5, 0, 0, Orientation.E);
		PositionOrientation expected = new PositionOrientation(new Position(1, 0), Orientation.E);

		// WHEN
		tondeuse.avancer();

		// THEN
		assertEquals(expected, tondeuse.getPosition());
	}

	@Test
	public void devrait_avancer_a_1_0_S_depuis_1_1_S() {
		// GIVEN
		Tondeuse tondeuse = creerTondeuse(5, 5, 1, 1, Orientation.S);
		PositionOrientation expected = new PositionOrientation(new Position(1, 0), Orientation.S);

		// WHEN
		tondeuse.avancer();

		// THEN
		assertEquals(expected, tondeuse.getPosition());
	}

	@Test
	public void devrait_avancer_a_0_1_W_depuis_1_1_W() {
		// GIVEN
		Tondeuse tondeuse = creerTondeuse(5, 5, 1, 1, Orientation.W);
		PositionOrientation expected = new PositionOrientation(new Position(0, 1), Orientation.W);

		// WHEN
		tondeuse.avancer();

		// THEN
		assertEquals(expected, tondeuse.getPosition());
	}

	@Test
	public void devrait_rester_a_0_5_N_depuis_0_5_N() {
		// GIVEN
		Tondeuse tondeuse = creerTondeuse(5, 5, 0, 5, Orientation.N);
		PositionOrientation expected = new PositionOrientation(new Position(0, 5), Orientation.N);

		// WHEN
		tondeuse.avancer();

		// THEN
		assertEquals(expected, tondeuse.getPosition());
	}

	@Test
	public void devrait_rester_a_0_5_W_depuis_0_5_W() {
		// GIVEN
		Tondeuse tondeuse = creerTondeuse(5, 5, 0, 5, Orientation.W);
		PositionOrientation expected = new PositionOrientation(new Position(0, 5), Orientation.W);

		// WHEN
		tondeuse.avancer();

		// THEN
		assertEquals(expected, tondeuse.getPosition());
	}

	@Test
	public void devrait_rester_a_5_0_S_depuis_5_0_S() {
		// GIVEN
		Tondeuse tondeuse = creerTondeuse(5, 5, 5, 0, Orientation.S);
		PositionOrientation expected = new PositionOrientation(new Position(5, 0), Orientation.S);

		// WHEN
		tondeuse.avancer();

		// THEN
		assertEquals(expected, tondeuse.getPosition());
	}

	@Test
	public void devrait_rester_a_5_0_E_depuis_5_0_E() {
		// GIVEN
		Tondeuse tondeuse = creerTondeuse(5, 5, 5, 0, Orientation.E);
		PositionOrientation expected = new PositionOrientation(new Position(5, 0), Orientation.E);

		// WHEN
		tondeuse.avancer();

		// THEN
		assertEquals(expected, tondeuse.getPosition());
	}

	@Test
	public void devrait_pivoter_a_droite_a_0_0_E_depuis_0_0_N() {
		// GIVEN
		Tondeuse tondeuse = creerTondeuse(5, 5, 0, 0, Orientation.N);
		PositionOrientation expected = new PositionOrientation(new Position(0, 0), Orientation.E);

		// WHEN
		tondeuse.pivoterADroite();

		// THEN
		assertEquals(expected, tondeuse.getPosition());
	}

	private Tondeuse creerTondeuse(int longueurPelouse, int largeurPelouse, int posXInitiale, int posYInitiale,
			Orientation orientationInitiale) {
		Position coinSuperieurDroit = new Position(largeurPelouse, longueurPelouse);
		Pelouse pelouse = new Pelouse(coinSuperieurDroit);
		PositionOrientation positionInitiale = new PositionOrientation(new Position(posXInitiale, posYInitiale),
				orientationInitiale);
		return new Tondeuse(pelouse, positionInitiale);
	}
}
