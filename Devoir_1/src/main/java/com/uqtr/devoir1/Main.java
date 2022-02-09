package com.uqtr.devoir1;

import com.uqtr.devoir1.persist.DataManager;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args){
        // Charger les fichiers de données
        if (args.length != 3) {
            System.err.println("Veuillez spécifier le chemin d'accès des fichiers [0]: chauffeurs, [1]: limousines, [2]: trajets");
            return;
        }

        try {
            new DataManager(args[0], args[1], args[2]);
        } catch (FileNotFoundException e) {
            System.err.println("Une erreur est survenue lors de la lecture des fichiers : " + e.getMessage());
            System.exit(-1);
        }

        // Lancer le menu en console
        new Application(args);
    }
}
