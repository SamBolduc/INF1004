package ca.uqtr.menu.tasks;

import ca.uqtr.DataManager;

import ca.uqtr.exceptions.NoPersistentDataException;

// Afficher toutes les caract�ristiques des trajets effectu�s
// ainsi que les caract�ristiques des limousines utilis�es
public class FindAllTrajets extends AbstractTask {
	@Override
	public void execute() {

		try {
			DataManager manager = DataManager.getInstance();
			if (manager.getAutoDeLuxe().getTrajets().size() > 0)
				manager.getAutoDeLuxe().getTrajets().forEach(System.out::println);
			else System.out.println("D�sol�, il n'y a pas de trajet associ� � la compagnie.");
		} catch (NoPersistentDataException e) {
			System.err.println(e.getMessage());
		}

	}
}
