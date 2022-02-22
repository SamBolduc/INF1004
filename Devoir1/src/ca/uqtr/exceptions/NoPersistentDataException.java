package ca.uqtr.exceptions;

public class NoPersistentDataException extends Exception {

    public NoPersistentDataException() {
        super("Les données n'a pas été initialisés.");
    }

}
