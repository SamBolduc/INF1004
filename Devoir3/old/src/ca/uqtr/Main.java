/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Classe principale.
 */

package ca.uqtr;

import ca.uqtr.menu.Menu;
import ca.uqtr.menu.MenuOption;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        loadFiles(args);

        List<MenuOption> options = new ArrayList<>();

        // Add menu options as needed. (Id must be different than 0)
//        options.add(new MenuOption(1, "Trouver toutes les limousines conduites par un chauffeur", new FindLimousinesByChauffeur()));
//        options.add(new MenuOption(2, "Afficher toutes les caractéristiques des trajets effectués", new FindAllTrajets()));

        Menu menu = new Menu(options);
        menu.displayAndPrompt();
    }

    private static void loadFiles(String[] args) {
//        if (args.length != 3) {
//            System.err.println("Veuillez spécifier les chemins d'accès vers les 3 fichiers");
//            System.exit(-1);
//        }
//
//        try {
//            new DataManager(args[0], args[1], args[2]);
//        } catch (FileNotFoundException e) {
//            System.err.println("Il n'a pas été possible de lire les fichiers de données.");
//            System.exit(-1);
//        }
    }
}