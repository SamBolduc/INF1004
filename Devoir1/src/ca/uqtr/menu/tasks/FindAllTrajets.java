package ca.uqtr.menu.tasks;

import ca.uqtr.DataManager;

import ca.uqtr.exceptions.NoPersistentDataException;
import ca.uqtr.menu.Menu;
import ca.uqtr.menu.options.Option;
import ca.uqtr.models.Limousine;
import ca.uqtr.models.Trajet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// Afficher toutes les caractéristiques des trajets effectués
// ainsi que les caractéristiques des limousines utilisées
public class FindAllTrajets extends AbstractTask {
	@Override
	public void execute() {

		try {
			DataManager manager = DataManager.getInstance();
			Set<Trajet> trajets = new HashSet<>();
			manager.getAutoDeLuxe().getTrajets().stream()
			.forEach(trajet -> trajets.add(trajet));

			trajets.forEach(System.out::println);


		} catch (NoPersistentDataException e) {
			System.err.println(e.getMessage());
		}

	}
}
