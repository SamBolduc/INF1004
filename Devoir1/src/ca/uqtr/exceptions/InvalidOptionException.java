package ca.uqtr.exceptions;

public class InvalidOptionException extends Exception {
    public InvalidOptionException() {
        super("L'option sélectionnée n'est pas valide. Veuillez en choisir une autre.");
    }
}
