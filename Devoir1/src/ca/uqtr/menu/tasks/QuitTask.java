/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Task permettant de quitter l'application.
 */

package ca.uqtr.menu.tasks;

public class QuitTask extends AbstractTask {
    @Override
    public void execute() {
        System.out.println("Beeeeep Boooop...");
        System.exit(-1);
    }
}
