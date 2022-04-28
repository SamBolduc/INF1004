/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.app.menu.tasks;

import secretariat.TableauPrincipal;

import java.util.Scanner;

public class LectureDonnees extends AbstractTask {
    @Override
    public void execute(Scanner scanner) {
        TableauPrincipal.getInstance().load();
    }
}
