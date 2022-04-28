/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.app.menu.tasks;

import secretariat.TableauPrincipal;

import java.util.Scanner;

public class AnnulerInscription extends AbstractTask {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Veuillez inscrire le code permanent de l'étudiant : ");
        String codePerm = scanner.nextLine();

        System.out.println("Veuillez inscrire le sigle du cours : ");
        String sigle = scanner.nextLine();

        boolean trouve = TableauPrincipal.getInstance().desinscrire(sigle, codePerm);
        if (!trouve)
            System.err.println("Il n'a pas été possible supprimer une inscription pour l'étudiant et le sigle donné.");

        System.out.println("L'annulation de l'inscription a bien été fait!");
    }
}
