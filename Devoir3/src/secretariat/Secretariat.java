/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat;

import secretariat.app.menu.Menu;
import secretariat.app.menu.MenuOption;
import secretariat.app.menu.tasks.*;

import java.util.ArrayList;
import java.util.List;

public class Secretariat {

    public static void main(String[] args) {
        List<MenuOption> options = new ArrayList<>();

        options.add(new MenuOption(1, "Inscription d’un étudiant à un cours", new InscrireEtudiant()));
        options.add(new MenuOption(2, "Annulation de l’inscription d’un étudiant à un cours", new AnnulerInscription()));
        options.add(new MenuOption(3, "Modification de l’inscription : annuler une inscription à un cours et le réinscrire à un autre cours", new ModifierInscription()));
        options.add(new MenuOption(4, "Obtention de la liste des cours suivis par l’étudiant", new ObtenirCoursPourEtudiant()));
        options.add(new MenuOption(5, "Obtention de la liste des étudiants inscrits à un cours donné", new ObtenirEtudiantsPourCours()));
        options.add(new MenuOption(6, "Sauvegarde des informations relatives aux étudiants, aux cours et aux inscriptions dans des fichiers", new SauvegarderDonnees()));
        options.add(new MenuOption(7, "Lecture des informations relatives aux étudiants, aux cours et aux inscriptions à partir des fichiers", new LectureDonnees()));

        Menu menu = new Menu(options);
        menu.displayAndPrompt();
    }

}
