package ca.uqtr.menu.tasks;

import ca.uqtr.DataManager;
import ca.uqtr.exceptions.NoPersistentDataException;
import ca.uqtr.models.Limousine;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindLimousinesByChauffeur extends AbstractTask {
    @Override
    public void execute() {
        // Demander à l'utilisateur l'identification du chauffeur puis ensuite trouver les limousines qui lui appartiennent puis les afficher.
        // Aide : DataManager.getInstance().getChauffeurs()
        //        DataManager.getInstance().getLimousines()
        //
        //        limousine.toString()
        //        Set<Limousine> limousines = new HashSet<>();
        throw new NotImplementedException();
    }
}
