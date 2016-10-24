package mowitnow.parFichier;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class ProgrammeurDeTondeusesTest {

	@Test
	public void devrait_programmer_le_fichier_de_test() throws IOException {
		// GIVEN
		ProgrammeurDeTondeuses programmeur = new ProgrammeurDeTondeuses();
		
		// WHEN
		List<String> actual = programmeur.programmer("src/test/resources/fichierEnEntree.txt");

		// THEN
		String premiereLigne = actual.get(0);
		String deuxiemeLigne = actual.get(1);

		assertEquals(premiereLigne, "1 3 N");
		assertEquals(deuxiemeLigne, "5 1 E");
	}
}
