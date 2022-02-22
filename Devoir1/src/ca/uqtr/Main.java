package ca.uqtr;

import ca.uqtr.menu.Menu;
import ca.uqtr.menu.options.Option;
import ca.uqtr.menu.tasks.FindLimousinesByChauffeur;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        loadFiles(args);

        List<Option> options = new ArrayList<>();

        // Add menu options as needed. (Id must be different than 0)
        options.add(new Option(1, "Trouver toutes les limousines conduites par un chauffeur", new FindLimousinesByChauffeur()));

        Menu menu = new Menu(options);
        menu.displayAndPrompt();
    }

    private static void loadFiles(String[] args) {
        try {
            DataManager manager = new DataManager(args[0], args[1], args[2]);
        } catch (FileNotFoundException e) {
            System.err.println("Il n'a pas été possible de lire les fichiers de données.");
            System.exit(-1);
        }
    }
}
