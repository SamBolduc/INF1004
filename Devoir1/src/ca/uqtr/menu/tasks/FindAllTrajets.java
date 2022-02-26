package ca.uqtr.menu.tasks;

import ca.uqtr.DataManager;

import ca.uqtr.exceptions.NoPersistentDataException;

// Afficher toutes les caractéristiques des trajets effectués
// ainsi que les caractéristiques des limousines utilisées
public class FindAllTrajets extends AbstractTask {
	@Override
	public void execute() {

		try {
			DataManager manager = DataManager.getInstance();
			if (manager.getAutoDeLuxe().getTrajets().size() > 0)
				manager.getAutoDeLuxe().getTrajets().forEach(System.out::println);
			else System.out.println("Désolé, il n'y a pas de trajet associé à la compagnie.");
		} catch (NoPersistentDataException e) {
			System.err.println(e.getMessage());
		}

	}
}
