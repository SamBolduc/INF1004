/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Task permettant d'obtenir la liste des limousines utilisées par un chauffeur.
 */

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
        System.out.println("Veuillez entrer l'identification du chauffeur désiré :");
        Scanner scanner = new Scanner(System.in);
        String identification = scanner.nextLine();

        try {
            DataManager manager = DataManager.getInstance();
            Set<Limousine> limousines = new HashSet<>();
            manager.getAutoDeLuxe().getChauffeurs().stream().filter(chauffeur -> chauffeur.getIdentification().equalsIgnoreCase(identification)).forEach(chauffeur -> chauffeur.getTrajets().forEach(trajet -> limousines.add(trajet.getLimousine())));

            if (limousines.size() > 0) limousines.forEach(System.out::println);
            else System.out.println("Désolé, il n'y a aucun résultat.");

        } catch (NoPersistentDataException e) {
            System.err.println(e.getMessage());
        } finally {
        	scanner.close();
        }
    }
}
