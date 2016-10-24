package mowitnow.pilotage;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import mowitnow.enums.Instruction;
import mowitnow.enums.Orientation;
import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.PiloteDeTondeuse;
import mowitnow.pilotage.Position;
import mowitnow.pilotage.PositionOrientation;

import org.junit.Test;

public class PiloteDeTondeuseTest {

	@Test
	public void devrait_terminer_a_1_3_N_depuis_1_2_N_avec_GAGAGAGAA_sur_une_pelouse_de_5X5() {
		// GIVEN
		PiloteDeTondeuse pilote = new PiloteDeTondeuse();
		Pelouse pelouse = new Pelouse(new Position(5, 5));
		PositionOrientation positionTondeuse = new PositionOrientation(new Position(1, 2), Orientation.N);

		List<Instruction> instructions = Arrays.asList(Instruction.G, Instruction.A, Instruction.G, Instruction.A,
				Instruction.G, Instruction.A, Instruction.G, Instruction.A, Instruction.A);

		PositionOrientation expected = new PositionOrientation(new Position(1, 3), Orientation.N);

		// WHEN
		PositionOrientation actual = pilote.piloter(pelouse, positionTondeuse, instructions);

		// THEN
		assertEquals(actual, expected);
	}

	@Test
	public void devrait_terminer_a_5_1_E_depuis_3_3_E_avec_AADAADADDA_sur_une_pelouse_de_5X5() {
		// GIVEN
		PiloteDeTondeuse pilote = new PiloteDeTondeuse();
		Pelouse pelouse = new Pelouse(new Position(5, 5));
		PositionOrientation positionTondeuse = new PositionOrientation(new Position(3, 3), Orientation.E);

		List<Instruction> instructions = Arrays.asList(Instruction.A, Instruction.A, Instruction.D, Instruction.A,
				Instruction.A, Instruction.D, Instruction.A, Instruction.D, Instruction.D, Instruction.A);

		PositionOrientation expected = new PositionOrientation(new Position(5, 1), Orientation.E);

		// WHEN
		PositionOrientation actual = pilote.piloter(pelouse, positionTondeuse, instructions);

		// THEN
		assertEquals(actual, expected);
	}

}
