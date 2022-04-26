/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Abstraction des Tasks
 */

package secretariat.app.menu.tasks;

import java.util.Scanner;

public abstract class AbstractTask {
    public abstract void execute(Scanner scanner);
}
