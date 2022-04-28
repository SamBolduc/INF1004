/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.app.menu.tasks;

import secretariat.TableauPrincipal;
import java.util.Scanner;

public class InscrireEtudiant extends AbstractTask {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Veuillez inscrire le code permanent de l'étudiant : ");
        String codePerm = scanner.nextLine();

        System.out.println("Veuillez inscrire le sigle du cours : ");
        String sigle = scanner.nextLine();

        boolean trouve = TableauPrincipal.getInstance().inscrire(sigle, codePerm);
        if (!trouve)
            System.err.println("Il n'a pas été possible de créer une inscription pour l'étudiant et le sigle donné.");

        System.out.println("L'inscription a bien été fait!");
    }
}
