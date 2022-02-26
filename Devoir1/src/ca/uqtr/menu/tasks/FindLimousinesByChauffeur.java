package ca.uqtr.menu.tasks;

import ca.uqtr.DataManager;

import ca.uqtr.exceptions.NoPersistentDataException;
import ca.uqtr.models.Limousine;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindLimousinesByChauffeur extends AbstractTask {
	@Override
	public void execute() {
		System.out.println("Veuillez entrer l'identification du chauffeur d�sir� :");
		Scanner scanner = new Scanner(System.in);
		String identification = scanner.nextLine();

		try {
			DataManager manager = DataManager.getInstance();
			Set<Limousine> limousines = new HashSet<>();
			manager.getAutoDeLuxe().getChauffeurs().stream()
					.filter(chauffeur -> chauffeur.getIdentification().equalsIgnoreCase(identification))
					.forEach(chauffeur -> chauffeur.getTrajets()
							.forEach(trajet -> limousines.add(trajet.getLimousine())));

			if (limousines.size() > 0)
				limousines.forEach(System.out::println);
			else System.out.println("D�sol�, il n'y a aucun r�sultat.");

		} catch (NoPersistentDataException e) {
			System.err.println(e.getMessage());
		}

	}

}
