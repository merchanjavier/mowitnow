package mowitnow.pilotage;

import java.util.List;

import mowitnow.enums.Instruction;

/**
 * 
 * Pilote une tondeuse
 *
 */
public class PiloteDeTondeuse {
	/**
	 * Pilote une tondeuse à partir de sa position initiale et des instructions qu'on lui donne
	 * @param pelouse
	 * @param positionInitiale
	 * @param instructions
	 * @return
	 */
	public PositionOrientation piloter(Pelouse pelouse, PositionOrientation positionInitiale, List<Instruction> instructions) {

		Tondeuse tondeuse = new Tondeuse(pelouse, positionInitiale);
		
		executerInstructions(tondeuse, instructions);

		return tondeuse.getPosition();
	}

	private void executerInstructions(Tondeuse tondeuse, List<Instruction> instructions) {
		for (Instruction instruction : instructions) {
			switch (instruction) {
			case A:
				tondeuse.avancer();
				break;
			case D:
				tondeuse.pivoterADroite();
				break;
			case G:
				tondeuse.pivoterAGauche();
				break;
			}
		}
	}
}
