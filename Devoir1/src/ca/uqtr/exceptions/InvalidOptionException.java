package ca.uqtr.exceptions;

import ca.uqtr.menu.options.Option;

import java.util.function.Supplier;

public class InvalidOptionException extends Exception {
    public InvalidOptionException() {
        super("L'option sélectionnée n'est pas valide. Veuillez en choisir une autre.");
    }
}
