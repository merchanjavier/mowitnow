package mowitnow.parFichier;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import mowitnow.enums.Instruction;
import mowitnow.enums.Orientation;
import mowitnow.pilotage.Pelouse;
import mowitnow.pilotage.PiloteDeTondeuse;
import mowitnow.pilotage.Position;
import mowitnow.pilotage.PositionOrientation;

/**
 * 
 * Commande les actions sur les tondeuses à partir d'un fichier
 *
 */
public class ProgrammeurDeTondeuses {

	private PiloteDeTondeuse pilote = new PiloteDeTondeuse();

	/**
	 * Programmer des tondeuses à partir d'un fichier texte
	 * @param nomDuFichier
	 * @return positions finales des tondeuses programmées
	 * @throws IOException
	 */
	public List<String> programmer(String nomDuFichier) throws IOException {
		List<String> lignes = Files.readAllLines(Paths.get(nomDuFichier), Charset.forName("ISO-8859-1"));

		Pelouse pelouse = extrairePelouse(lignes.get(0));

		List<PositionOrientation> positionsInitiales = new ArrayList<>();
		List<List<Instruction>> listesDInstructions = new ArrayList<>();

		extrairePositionsEtInstructionsAPartirDesLignesDuFichier(lignes, positionsInitiales, listesDInstructions);

		return piloterLesTondeuses(pelouse, positionsInitiales, listesDInstructions);
	}

	private Pelouse extrairePelouse(String lignePelouse) {
		String[] chiffresTaillePelouse = lignePelouse.split(" ");
		
		int coinSupDroitX = Integer.parseInt(chiffresTaillePelouse[0]);
		int coinSupDroitY = Integer.parseInt(chiffresTaillePelouse[1]);
		
		return new Pelouse(new Position(coinSupDroitX, coinSupDroitY));
	}
	
	private void extrairePositionsEtInstructionsAPartirDesLignesDuFichier(List<String> lignes,
			List<PositionOrientation> positionsInitiales, List<List<Instruction>> listesDInstructions) {
		for (int numeroLigne = 1; numeroLigne < lignes.size(); numeroLigne++) {
			String ligne = lignes.get(numeroLigne);
			
			if (ligneImpaire(numeroLigne)) {
				ajouterPositionInitiale(positionsInitiales, ligne);
			} else {
				ajouterListeDInstructions(listesDInstructions, ligne);
			}
		}
	}
	
	private boolean ligneImpaire(int numeroLigne) {
		return numeroLigne % 2 == 1;
	}
	
	private void ajouterPositionInitiale(List<PositionOrientation> positionsInitiales, String ligne) {
		String[] chiffresPositionInitiale = ligne.split(" ");
		positionsInitiales.add(extrairePositionAPartirDesChiffres(chiffresPositionInitiale));
	}
	
	private PositionOrientation extrairePositionAPartirDesChiffres(String[] chiffresPositionInitiale) {
		return new PositionOrientation(new Position(Integer.parseInt(chiffresPositionInitiale[0]),
				Integer.parseInt(chiffresPositionInitiale[1])), traduireOrientation(chiffresPositionInitiale[2]));
	}
	
	private Orientation traduireOrientation(String orientation) {
		switch (orientation) {
		case "N":
			return Orientation.N;
		case "E":
			return Orientation.E;
		case "W":
			return Orientation.W;
		case "S":
			return Orientation.S;
		default:
			return null;
		}
	}
	
	private void ajouterListeDInstructions(List<List<Instruction>> listesDInstructions, String ligne) {
		String[] lettresInstructions = ligne.split("(?<!^)");
		listesDInstructions.add(extraireInstructionsAPartirDesLettres(lettresInstructions));
	}
	
	private List<Instruction> extraireInstructionsAPartirDesLettres(String[] lettresInstructions) {
		List<Instruction> instructions = new ArrayList<>();
		
		for (String lettre : lettresInstructions) {
			instructions.add(traduireInstruction(lettre));
		}
		
		return instructions;
	}

	private Instruction traduireInstruction(String lettre) {
		switch (lettre) {
		case "A":
			return Instruction.A;
		case "D":
			return Instruction.D;
		case "G":
			return Instruction.G;
		default:
			return null;
		}
	}
	
	private List<String> piloterLesTondeuses(Pelouse pelouse, List<PositionOrientation> positionsInitiales,
			List<List<Instruction>> listesDInstructions) {
		List<String> resultats = new ArrayList<String>();
		
		for (int tondeuseCourante = 0; tondeuseCourante < positionsInitiales.size(); tondeuseCourante++) {
			PositionOrientation positionInitialeDeLaTondeuse = positionsInitiales.get(tondeuseCourante);
			List<Instruction> instructionsPourLaTondeuse = listesDInstructions.get(tondeuseCourante);
		
			PositionOrientation positionFinale = pilote.piloter(pelouse, positionInitialeDeLaTondeuse,
					instructionsPourLaTondeuse);
			
			resultats.add(formatterPourAffichage(positionFinale));
		}
		
		return resultats;
	}

	private String formatterPourAffichage(PositionOrientation positionFinale) {
		return positionFinale.getPosition().getPosX() + " " + positionFinale.getPosition().getPosY() + " "
				+ positionFinale.getOrientation();
	}

}
