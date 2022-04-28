/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.app.menu.tasks;

import secretariat.TableauPrincipal;

import java.util.Scanner;

public class ModifierInscription extends AbstractTask {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Veuillez inscrire le code permanent de l'étudiant : ");
        String codePerm = scanner.nextLine();

        System.out.println("Veuillez inscrire le sigle du cours actuel : ");
        String oldSigle = scanner.nextLine();

        System.out.println("Veuillez inscrire le sigle du nouveau cours : ");
        String newSigle = scanner.nextLine();

        boolean trouve = TableauPrincipal.getInstance().desinscrire(oldSigle, codePerm);
        if (!trouve) {
            System.err.println("Il n'a pas été possible de trouver l'inscription à modifier");
            return;
        }

        trouve = TableauPrincipal.getInstance().inscrire(newSigle, codePerm);
        if (!trouve) {
            System.err.println("Il n'a pas été possible de trouver le nouveau cours.");
            return;
        }

        System.out.println("L'inscription a été modifiée.");
    }
}
