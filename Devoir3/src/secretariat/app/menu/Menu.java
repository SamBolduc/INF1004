/*
 * Modifié par:Samuel Bolduc, Simon Bolduc & Patrick Vezina.
 *
 */

package secretariat.app.menu;


import secretariat.app.exceptions.InvalidOptionException;
import secretariat.app.menu.tasks.QuitTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final List<MenuOption> options;
    private final Scanner scanner;

    public Menu(List<MenuOption> options) {
        this.options = new ArrayList<>();
        this.options.add(new MenuOption(0, "Quitter l'application", new QuitTask()));
        this.options.addAll(options);
        this.scanner = new Scanner(System.in);
    }

    private void printOptions() {
        System.out.println();
        for (MenuOption option : options) {
            System.out.println(option);
        }
        System.out.println();
    }

    public void displayAndPrompt() {
        System.out.println("Veuillez sélectionner une option :");
        this.printOptions();

        int choice = -1;
        do {
            try {
                choice = Integer.parseInt(this.scanner.nextLine());
                MenuOption option = this.findOptionById(choice);
                if (null == option) throw new InvalidOptionException();
                option.getTask().execute(this.scanner);
            } catch (NumberFormatException exception) {
                System.err.println("Veuillez entrer une option numérique.");
            } catch (InvalidOptionException exception) {
                System.err.println(exception.getMessage());
            } finally {
                this.printOptions();
            }
        } while (choice != this.options.get(0).getId());
    }

    private MenuOption findOptionById(int id) {
        return this.options.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }
}