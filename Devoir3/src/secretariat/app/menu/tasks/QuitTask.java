/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Task permettant de quitter l'application.
 */

package secretariat.app.menu.tasks;

import java.util.Scanner;

public class QuitTask extends AbstractTask {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Beeeeep Boooop...");
        scanner.close();
        System.exit(-1);
    }
}
