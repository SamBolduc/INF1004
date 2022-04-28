/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.app.menu.tasks;

import secretariat.TableauPrincipal;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ObtenirCoursPourEtudiant extends AbstractTask {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Veuillez inscrire le code permanent de l'étudiant : ");
        String codePerm = scanner.nextLine();

        AtomicBoolean trouve = new AtomicBoolean(false);

        TableauPrincipal.getInstance().getEtudiants().forEach(et -> {
            if(et.getCodePermanent().equalsIgnoreCase(codePerm)) {
                trouve.set(true);
                System.out.println("Cours inscrits pour l'étudiant " + codePerm.toUpperCase());
                et.iterator().forEachRemaining(inscription -> System.out.println(inscription.getCours().getSigle()));
            }
        });

        if (!trouve.get()) System.err.println("Il n'a pas été possible de trouver d'étudiant avec ce code permanent.");
    }
}
