/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.app.menu.tasks;

import secretariat.TableauPrincipal;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class ObtenirEtudiantsPourCours extends AbstractTask {
    @Override
    public void execute(Scanner scanner) {
        System.out.println("Veuillez inscrire le sigle du cours : ");
        String sigle = scanner.nextLine();

        AtomicBoolean trouve = new AtomicBoolean(false);

        TableauPrincipal.getInstance().getCours().forEach(cours -> {
            if(cours.getSigle().equalsIgnoreCase(sigle)) {
                trouve.set(true);
                System.out.println("Étudiants inscrits pour le cours " + sigle.toUpperCase());
                cours.iterator().forEachRemaining(stu -> System.out.println(stu.getEtudiant().getCodePermanent()));
            }
        });

        if (!trouve.get()) System.err.println("Il n'a pas été possible de trouver de cours avec ce sigle.");
    }
}
