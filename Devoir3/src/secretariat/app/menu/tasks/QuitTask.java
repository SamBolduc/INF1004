/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
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
