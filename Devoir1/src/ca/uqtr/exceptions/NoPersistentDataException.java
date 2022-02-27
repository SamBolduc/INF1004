/*
 * Copyright (C) 2022 Samuel Bolduc, Simon Bolduc & Patrick Vezina. - Tous droits réservés
 *
 * Contenu: Exception lancée si la persistence n'a pas été initialisé.
 */

package ca.uqtr.exceptions;

public class NoPersistentDataException extends Exception {

    public NoPersistentDataException() {
        super("Les données n'a pas été initialisés.");
    }

}
